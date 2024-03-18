package com.action;

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
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class threadAction extends ActionSupport{
	private TForumsDAO forumsDAO;
	private TTopicDAO topicDAO;
	private TThreadsDAO threadsDAO;
	
	private int pid;
	private int fid;
	private String subject;
	private String content;
	
	private String message;
	private String path;
	public String toAddThread(){
		TForums forums = forumsDAO.findById(fid);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("forums", forums);
		return ActionSupport.SUCCESS;
	}
	
	public String threadAdd()
	{
		Map session= ActionContext.getContext().getSession();
		TUser user = (TUser)session.get("user");
		
		Date date = new Date();
		
		TTopic topic = new TTopic();
		topic.setFid(fid);
		topic.setAuthor(user.getUserName());
		topic.setAuthorid(user.getId());
		topic.setSubject(subject);
		topic.setView(0);
		topic.setReplies(0);
		topic.setAddtime(date);
		topicDAO.save(topic);
		
		int pid = topic.getPid();
		TThreads threads = new TThreads();
		threads.setPid(pid);
		threads.setFid(fid);
		threads.setFtype(0);
		threads.setAuthor(user.getUserName());
		threads.setAuthorid(user.getId());
		threads.setSubject(subject);
		threads.setContent(content);
		threads.setAddtime(date);		
		threadsDAO.save(threads);
		
		this.setMessage("主题发布成功");
		this.setPath("threadview.action?pid="+pid);
		return "succeed";
	}
	
	public String threadview()
	{
		String sql="update TTopic set view=view+1 where pid="+pid;
		topicDAO.getHibernateTemplate().bulkUpdate(sql);
		
		TTopic topic = topicDAO.findById(pid);
		
		TForums forums = forumsDAO.findById(topic.getFid());
		
		Session session = threadsDAO.getSessionFactory().openSession();
		String getMain = "select tid,author,subject,content,addtime from t_threads where pid="+pid+" order by addtime limit 1";
		Object[] objThreadsMain = (Object[])session.createSQLQuery(getMain).list().get(0); 
		
		TThreads threadsMain = new TThreads();
		threadsMain.setTid((Integer)objThreadsMain[0]);
		threadsMain.setAuthor((String)objThreadsMain[1]);
		threadsMain.setSubject((String)objThreadsMain[2]);
		threadsMain.setContent((String)objThreadsMain[3]);
		threadsMain.setAddtime((Date)objThreadsMain[4]);
		
		List threads = threadsDAO.getHibernateTemplate().find("from TThreads where pid="+pid+" and ftype=1 order by addtime");
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		request.put("topic", topic);
		request.put("forums", forums);
		request.put("threadsMain", threadsMain);
		request.put("threadsList", threads);
		
		session.close();
		return SUCCESS;
	}
	
	public String replace()
	{
		Map session= ActionContext.getContext().getSession();
		TUser user = (TUser)session.get("user");
		
		String sql="update TTopic set replies=replies+1 where pid="+pid;
		topicDAO.getHibernateTemplate().bulkUpdate(sql);
		
		TThreads threads = new TThreads();
		threads.setPid(pid);
		threads.setFid(fid);
		threads.setFtype(1);
		threads.setAuthor(user.getUserName());
		threads.setAuthorid(user.getId());
		threads.setSubject(subject);
		threads.setContent(content);
		threads.setAddtime(new Date());		
		threadsDAO.save(threads);
		
		this.setMessage("主题回复成功");
		this.setPath("threadview.action?pid="+pid);
		return "succeed";
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

	public TForumsDAO getForumsDAO() {
		return forumsDAO;
	}

	public void setForumsDAO(TForumsDAO forumsDAO) {
		this.forumsDAO = forumsDAO;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
