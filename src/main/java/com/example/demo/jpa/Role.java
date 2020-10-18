package com.example.demo.jpa;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("t_role")
public class Role {
	@Id
	String id;
	private int roleid;
	private String roledesc;
	public  Role() {}
	public Role(final int roleid,final String roledesc) {
		this.roleid = roleid;
		this.roledesc = roledesc;
}
	public void setRoleid(int roleid) {this.roleid = roleid;}
	public void setRoledesc(String roledesc) {this.roledesc = roledesc;}

	public int getRoleid() {return this.roleid;}
	public String getRoledesc() {return this.roledesc;}
}