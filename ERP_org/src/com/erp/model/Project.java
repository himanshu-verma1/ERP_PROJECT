package com.erp.model;

public class Project {
	private int Id;
	private String name;
	private String duration;
	private String status;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int id, String name, String duration, String status) {
		super();
		Id = id;
		this.name = name;
		this.duration = duration;
		this.status = status;
	}
	
}
