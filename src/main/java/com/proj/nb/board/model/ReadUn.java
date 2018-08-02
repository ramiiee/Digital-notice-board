package com.proj.nb.board.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReadUn {

	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="UserId")
		private Integer uid;
	
	private String imagename;
	private String username;
	private Integer readun;
	
	
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getReadun() {
		return readun;
	}
	public void setReadun(Integer readun) {
		this.readun = readun;
	}
	
	
	
	
	
	
}
