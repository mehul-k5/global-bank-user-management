package com.example.bankusermanagementbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id()
	String user_id;
	@Column
	String password;
	public User() {
		
	}
	public User(String userId, String password) {
		super();
		this.user_id = userId;
		this.password = password;
	}
	public String getUserId() {
		return user_id;
	}
	public void setUserId(String userId) {
		this.user_id = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
