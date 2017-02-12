package com.hibernate.basic.model.onetomany;

public class Account {

	
	private int acc_id;
	//private int user_id;
	private String acc_number;
	private UserAccount userAccount;
	public int getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}
/*	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
*/	public String getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id +  ", acc_number=" + acc_number + ", userAccount="
				+ userAccount + "]";
	}
	
	
	
	
}
