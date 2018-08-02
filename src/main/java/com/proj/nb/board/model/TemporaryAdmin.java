package com.proj.nb.board.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class TemporaryAdmin {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	public String name;
	public String button;
	
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	public String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*
	public String getTemporaryimagename() {
		return name;
	}

	public void setTemporaryimagename(String temporaryimagename) {
		this.name = temporaryimagename;
	}*/

}
