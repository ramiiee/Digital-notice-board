package com.proj.nb.board.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnalyticsViews {
	
	
	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="UserId")
		private Integer uid;
	
	private String username;
	private String imagename;
	private Integer viewscount;
	private Integer uniqueviews;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public Integer getViewscount() {
		return viewscount;
	}
	public void setViewscount(Integer viewscount) {
		this.viewscount = viewscount;
	}
	public Integer getUniqueviews() {
		return uniqueviews;
	}
	public void setUniqueviews(Integer uniqueviews) {
		this.uniqueviews = uniqueviews;
	}
	
	
	
	

}
