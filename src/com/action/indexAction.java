package com.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.TForumsDAO;
import com.model.TForums;
import com.model.TTopic;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction {
	private TForumsDAO forumsDAO;
	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		request.put("forumsList", getForums());
		return ActionSupport.SUCCESS;
	}
	
	private List getForums(){
		List groups = forumsDAO.getHibernateTemplate().find("from TForums where type='group' and status=1");
		Session session = forumsDAO.getSessionFactory().openSession();
		for (Object object : groups) {
			TForums group = (TForums)object;
			List forums = forumsDAO.getHibernateTemplate().find("from TForums where fup="+group.getFid()+" and status=1");
			for (Object object2 : forums) {
				TForums forum = (TForums)object2;
				List subs = forumsDAO.getHibernateTemplate().find("from TForums where fup="+forum.getFid()+" and status=1");
				
				String getTopicList = "select ta.pid,ta.author,ta.subject,ta.addtime from t_topic ta " +
									  "left join t_forums tb on ta.fid=tb.fid where tb.fup='"+forum.getFid()+"' order by addtime desc limit 1";
				List topicList = session.createSQLQuery(getTopicList).list();
				if(topicList!=null && topicList.size()>0){
					Object[] objTopic = (Object[])topicList.get(0);
					Date addtime = (Date)objTopic[3];
					
					TTopic topic = new TTopic();
					topic.setPid((Integer)objTopic[0]);
					topic.setAuthor((String)objTopic[1]);
					topic.setSubject((String)objTopic[2]);
					topic.setAddtime(addtime);
					
					List pList = new ArrayList();
					pList.add(topic);
					forum.setTopicList(pList);
					
					if(newTopic(addtime))
						forum.setStyle("class=new");
					else
					forum.setStyle("");
				}else{
					forum.setStyle("");
				}
				
				//获取主题数题
				String getTopicNum = "select count(1) from t_topic ta left join t_forums tb on ta.fid=tb.fid where tb.fup='"+forum.getFid()+"'";
				String getThreadNum = "select count(1) from t_threads ta left join t_forums tb on ta.fid=tb.fid where tb.fup='"+forum.getFid()+"'";
				
				forum.setChild(subs);
				
				forum.setTopicNum(((BigInteger)session.createSQLQuery(getTopicNum).list().get(0)).intValue());
				forum.setThreadNum(((BigInteger)session.createSQLQuery(getThreadNum).list().get(0)).intValue());
			}
			group.setChild(forums);
		}
		session.close();
		return groups;
	}

	/**
	 * 判断是否有新主题
	 * @return
	 */
	private boolean newTopic(Date addtime){
		boolean result = false;
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(addtime);
		long timeadd = calendar.getTimeInMillis();
		
		calendar.setTime(new Date());
		long timethis = calendar.getTimeInMillis();
		
		long theday = (timethis - timeadd) / (1000 * 60 * 60 * 24);
		
		if(theday<7)
			result = true;
		return result;
	}
	
	public TForumsDAO getForumsDAO() {
		return forumsDAO;
	}

	public void setForumsDAO(TForumsDAO forumsDAO) {
		this.forumsDAO = forumsDAO;
	}
}