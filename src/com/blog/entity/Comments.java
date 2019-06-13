package com.blog.entity;

public class Comments {
	private long id;
	private String name;
	private String message;
	private int messid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMessid() {
		return messid;
	}
	public void setMessid(int messid) {
		this.messid = messid;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", name=" + name + ", message=" + message + ", messid=" + messid + "]";
	}
	
	
}
