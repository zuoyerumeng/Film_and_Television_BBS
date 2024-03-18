package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TUserDAO;
import com.model.TUser;

public class loginService
{
	private TUserDAO userDAO;
	
	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String adminLogin(String userName,String userPw)
	{
		String result="no";
		try
		{
			String sql="from TUser where userName=? and userPw=? and isDel=0 and userType=0";
			Object[] con={userName,userPw};
			
			List userList=userDAO.getHibernateTemplate().find(sql,con);
			if(userList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TUser user=(TUser)userList.get(0);
	             session.setAttribute("user", user);
	             result="yes";
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public String login(String userName,String userPw)
	{
		String result="no";
		try
		{
			String sql="from TUser where userName=? and userPw=? and isDel=0 ";
			Object[] con={userName,userPw};
			
			List userList=userDAO.getHibernateTemplate().find(sql,con);
			if(userList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TUser user=(TUser)userList.get(0);
	             session.setAttribute("user", user);
	             result="yes";
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public void logout()
	{
		 WebContext ctx = WebContextFactory.get(); 
		 HttpSession session=ctx.getSession(); 
		 System.out.println("bbbb");
		 session.removeAttribute("user");
	}
}
