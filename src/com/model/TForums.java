package com.model;

import java.util.List;

/**
 * TForums entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TForums implements java.io.Serializable {

	// Fields

	private Integer fid;
	private String type;
	private String name;
	private Integer fup;
	private Short status;

	private List child;
	private List topicList;
	private int topicNum;
	private int threadNum;
	private String style;
	// Constructors

	/** default constructor */
	public TForums() {
	}

	/** full constructor */
	public TForums(String type, String name, Integer fup, Short status) {
		this.type = type;
		this.name = name;
		this.fup = fup;
		this.status = status;
	}

	// Property accessors

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFup() {
		return this.fup;
	}

	public void setFup(Integer fup) {
		this.fup = fup;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public List getChild() {
		return child;
	}

	public void setChild(List child) {
		this.child = child;
	}

	public List getTopicList() {
		return topicList;
	}

	public void setTopicList(List topicList) {
		this.topicList = topicList;
	}

	public int getTopicNum() {
		return topicNum;
	}

	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}

	public int getThreadNum() {
		return threadNum;
	}

	public void setThreadNum(int threadNum) {
		this.threadNum = threadNum;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}