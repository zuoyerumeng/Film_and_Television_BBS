package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TForumsDAO;
import com.model.TForums;
import com.opensymphony.xwork2.ActionSupport;

public class forumsAction extends ActionSupport {
	/**
	 * 分区
	 */
	private static String typeGroup = "group";
	
	/**
	 * 版块
	 */
	private static String typeForum= "forum";
	
	/**
	 * 子版块
	 */
	private static String typeSub = "sub";
	
	private int fid;
	private String type;
	private String name;
	private int fup;
	
	private String message;
	private String path;
	
	private TForumsDAO forumsDAO;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getFup() {
		return fup;
	}

	public void setFup(int fup) {
		this.fup = fup;
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

	public TForumsDAO getForumsDAO() {
		return forumsDAO;
	}

	public void setForumsDAO(TForumsDAO forumsDAO) {
		this.forumsDAO = forumsDAO;
	}
	
	public String forumsMana(){
		String txt = "";
		if(typeForum.equals(type)){
			//添加版块
			txt = "版块管理";
		}else if(typeSub.equals(type)){
			txt = "子版块管理";
		}else{
			txt = "分区管理";
		}
		
		List forumsList = getForumsByType(type);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		request.put("forumsList", forumsList);
		request.put("txt", txt);
		return ActionSupport.SUCCESS;
	}
	
	public String toAdd(){
		String txt = "";
		String td = "";
		List forumsList = new ArrayList();
		if(typeForum.equals(type)){
			//添加版块
			forumsList = getForumsByType(typeGroup);//获取分区
			txt = "添加版块";
			td = "上级分区";
		}else if(typeSub.equals(type)){
			forumsList = getForumsByType(typeForum);//获取版块
			txt = "添加子版块";
			td = "上级版块";
		}else{
			txt = "添加分区";
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("type", type);
		request.put("forumsList", forumsList);
		request.put("txt", txt);
		request.put("td", td);
		return "toAdd";
	}
	
	public String doAdd(){
		TForums forums = new TForums();
		
		forums.setType(type);
		forums.setName(name);
		if(typeGroup.equals(type)){
			forums.setFup(0);
		}else{
			forums.setFup(fup);
		}
		forums.setStatus(new Short("1"));
		forumsDAO.save(forums);
		
		this.setMessage("操作成功");
		this.setPath("forumsMana.action?type="+type);
		return "succeed";
	}
	public String toEdit(){
		TForums forums = forumsDAO.findById(fid);
		String txt = "";
		String td = "";
		List forumsList = new ArrayList();
		if(typeForum.equals(forums.getType())){
			//添加版块
			forumsList = getForumsByType(typeGroup);//获取分区
			txt = "编辑版块";
			td = "上级分区";
		}else if(typeSub.equals(forums.getType())){
			forumsList = getForumsByType(typeForum);//获取版块
			txt = "编辑子版块";
			td = "上级版块";
		}else{
			txt = "编辑分区";
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("forumInfo", forums);
		request.put("forumsList", forumsList);
		request.put("txt", txt);
		request.put("td", td);
		return "toEdit";
	}
	
	public String doEdit(){
		TForums forums = forumsDAO.findById(fid);
		forums.setType(type);
		forums.setName(name);
		if(typeGroup.equals(type)){
			forums.setFup(0);
		}else{
			forums.setFup(fup);
		}
		forumsDAO.getHibernateTemplate().update(forums);
		
		this.setMessage("操作成功");
		this.setPath("forumsMana.action?type="+type);
		return "succeed";
	}
	
	public String doDel(){
		TForums forums = forumsDAO.findById(fid);
		forums.setStatus(new Short("0"));
		
		forumsDAO.getHibernateTemplate().update(forums);
		
		this.setMessage("操作成功");
		this.setPath("forumsMana.action?type="+forums.getType());
		return "succeed";
	}
	
	private List getForumsByType(String type){
		return forumsDAO.getHibernateTemplate().find("from TForums where type='"+type+"' and status=1");
	}
}
