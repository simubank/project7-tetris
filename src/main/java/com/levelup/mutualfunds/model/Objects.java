package com.levelup.mutualfunds.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Objects {
	
	private String header;
	private String name;
	private long id;
	private Date time;
	
	public Objects() {
		
	}
	
	public Objects(String header, String name, long id) {
		super();
		this.id = id;
		this.header = header;
		this.name = name;
		this.time = new Date();
	}
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
