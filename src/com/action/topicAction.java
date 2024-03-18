package com.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.TForumsDAO;
import com.dao.TThreadsDAO;
import com.dao.TTopicDAO;
import com.model.TForums;
import com.model.TThreads;
import com.model.TTopic;
import com.opensymphony.xwork2.ActionSupport;

public class topicAction extends ActionSupport{
	private TForumsDAO forumsDAO;
	private TTopicDAO topicDAO;
	private TThreadsDAO threadsDAO;
	private int fid;
	private int pid;
	
	private String message;
	private String path;
	
	public String topicMana(){
		List topicList = new ArrayList();
		
		String sql = "select ta.pid,author,name,`subject`,view,replies,addtime from t_topic ta left join t_forums tb on ta.fid=tb.fid";
		Session session = topicDAO.getSessionFactory().openSession();
		List objList = session.createSQLQuery(sql).list();
		for (Object object : objList) {
			Object[] objTopic = (Object[])object;
			
			TTopic topic = new TTopic();
			topic.setPid((Integer)objTopic[0]);
			topic.setAuthor((String)objTopic[1]);
			topic.setFname((String)objTopic[2]);
			topic.setSubject((String)objTopic[3]);
			topic.setView((Integer)objTopic[4]);
			topic.setReplies((Integer)objTopic[5]);
			topic.setAddtime((Date)objTopic[6]);
			
			topicList.add(topic);
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("topicList", topicList);
		return SUCCESS;
	}
	
	public String topicDel(){
		String delSql = "delete from TTopic where pid="+pid;
		topicDAO.getHibernateTemplate().bulkUpdate(delSql);
		
		delSql = "delete from TThreads where pid="+pid;
		topicDAO.getHibernateTemplate().bulkUpdate(delSql);
		
		this.setMessage("操作成功");
		this.setPath("topicMana.action");
		return "succeed";
	}
	
	public String topicview(){
		List topicList = topicDAO.getHibernateTemplate().find("from TTopic where fid="+fid +"order by addtime desc");
		for (Object object : topicList) {
			TTopic topic = (TTopic)object;
			topic.setStyle("folder_common");
			
			String sql = "from TThreads where pid="+topic.getPid()+" order by addtime desc limit 1";
			TThreads lastSub = (TThreads)threadsDAO.getHibernateTemplate().find(sql).get(0);
			
			if(topic.getReplies()>0){
				//判断是否是最新回复
				if(newSub(lastSub.getAddtime())){
					topic.setStyle("folder_new");
				}
			}
			topic.setLastsub(lastSub);
		}
		
		TForums forums = forumsDAO.findById(fid);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("topicList", topicList);
		request.put("forums", forums);
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * 判断是否有新主题
	 * @return
	 */
	private boolean newSub(Date addtime){
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
	public TTopicDAO getTopicDAO() {
		return topicDAO;
	}
	public void setTopicDAO(TTopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}
	public TThreadsDAO getThreadsDAO() {
		return threadsDAO;
	}
	public void setThreadsDAO(TThreadsDAO threadsDAO) {
		this.threadsDAO = threadsDAO;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
