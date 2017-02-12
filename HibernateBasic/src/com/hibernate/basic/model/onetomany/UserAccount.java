package com.hibernate.basic.model.onetomany;

import java.util.Set;

public class UserAccount {
	
	
	private int user_id;
	private String user_name;
	
	private Set<Account> accounts;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "UserAccount [user_id=" + user_id + ", user_name=" + user_name + ", accounts=" + accounts + "]";
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
}
