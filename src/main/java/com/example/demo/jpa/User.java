package com.example.demo.jpa;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("t_user")
public class User { 
	@Id
	String id;
	private String username;
	private String pwd;
	private int roleid;
	
public User() {}
	public User(final String username, final String pwd, final int roleid) {
		this.username = username;
		this.pwd = pwd;
		this.roleid = roleid;
	}
	public void setUsername(String username) {this.username = username;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	public void setRoleid(int roleid) {this.roleid = roleid;}

	public String getUsername() {return this.username;}
	public String getPwd() {return this.pwd;}
	public int getRoleid() {return this.roleid;}
}