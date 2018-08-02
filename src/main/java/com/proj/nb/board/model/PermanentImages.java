package com.proj.nb.board.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class PermanentImages {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String imagename;

	private Integer likes;
	public String description;
	public String button;
	public Integer category;
	
	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public String getName() {
		return imagename;
	}

	public void setName(String name) {
		this.imagename = name;
	}
	
	
	
	
	
	
	
}
