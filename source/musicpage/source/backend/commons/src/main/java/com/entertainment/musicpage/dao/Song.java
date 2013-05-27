package com.entertainment.musicpage.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the song database table.
 * 
 */
@Entity
@Table(name="song")
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String description;
	private String source;
	private String sourceType;
	private String title;

	public Song() {
	}


	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(length=5555)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(nullable=false, length=555)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	@Column(nullable=false, length=555)
	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}


	@Column(nullable=false, length=555)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}