package com.proj.nb.board.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
 public class Login {

 	@Id
 	    @GeneratedValue(strategy=GenerationType.AUTO)
 	    @Column(name="UserId")
 		private Integer uid;
 	
 	private String username;
 //	private String password;
 	private byte[] encpassword;
 	
 	public String getUsername() {
 		return username;
 	}
 	public void setUsername(String username) {
 		this.username = username;
 	}
 	/*
 	public String getPassword() {
 		return password;
 	}
 	public void setPassword(String password) {
 		this.password = password;
 	}*/
	public byte[] getEncpassword() {
		return encpassword;
	}
	public void setEncpassword(byte[] encpassword) {
		this.encpassword = encpassword;
	}
 	
 }
