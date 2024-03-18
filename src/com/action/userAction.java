package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class userAction {
	private TUserDAO userDAO;
	private int id;
	private String userName;
	private String userPw;
	private String realName;
	private String email;
	
	private String message;
	private String path;
	
	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String userLogout(){
		Map session= ActionContext.getContext().getSession();
		session.remove("user");
		this.setMessage("退出成功");
		this.setPath("bbs/jump.jsp");
		return "succeed";
	}
	
	public String userReg(){
		TUser user = new TUser();
		
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setEmail(email);
		user.setRealName(realName);
		user.setUserType(1);
		user.setIsDel(0);
		
		userDAO.save(user);
		
		Map session= ActionContext.getContext().getSession();
		session.put("user", user);
		this.setMessage("注册成功");
		this.setPath("bbs/jump.jsp");
		return "succeed";
	}
	
	public String userMana()
	{
		List userList = userDAO.getHibernateTemplate().find("from TUser where userType=1 and isDel=0");
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	public String userDel()
	{
		userDAO.getHibernateTemplate().bulkUpdate("update TUser set isDel=1 where id="+id);
		
		this.setMessage("操作成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
}
