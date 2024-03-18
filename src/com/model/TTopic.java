package com.model;

import java.util.Date;

/**
 * TTopic entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TTopic implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Integer fid;
	private String author;
	private Integer authorid;
	private String subject;
	private Integer view;
	private Integer replies;
	private Date addtime;

	//×îºó»Ø¸´
	private String fname;
	private TThreads lastsub;
	private String style;
	// Constructors
	
	/** default constructor */
	public TTopic() {
	}

	/** full constructor */
	public TTopic(Integer fid, String author, Integer authorid, String subject,
			Integer view, Integer replies, Date addtime) {
		this.fid = fid;
		this.author = author;
		this.authorid = authorid;
		this.subject = subject;
		this.view = view;
		this.replies = replies;
		this.addtime = addtime;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getAuthorid() {
		return this.authorid;
	}

	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getView() {
		return this.view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Integer getReplies() {
		return this.replies;
	}

	public void setReplies(Integer replies) {
		this.replies = replies;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public TThreads getLastsub() {
		return lastsub;
	}

	public void setLastsub(TThreads lastsub) {
		this.lastsub = lastsub;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
}