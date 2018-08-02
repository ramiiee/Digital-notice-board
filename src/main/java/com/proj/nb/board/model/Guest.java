package com.proj.nb.board.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Guest {
	
	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private Integer uid;
	
	private String username;
 	private String password;
 	private String phonenumber;
 	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
 	
 	
 	
 	
 	
	
	

}
