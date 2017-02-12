package com.hibernate.basic.model;

public class Phone {

	private int phone_id;
	private String phone_name;
	private User user;
	
	
	public int getPhone_id() {
		return phone_id;
	}
	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}
	public String getPhone_name() {
		return phone_name;
	}
	public void setPhone_name(String phone_name) {
		this.phone_name = phone_name;
	}
	
	
	
	@Override
	public String toString() {
		return "Phone [phone_id=" + phone_id + ", phone_name=" + phone_name + ", user=" + user + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
