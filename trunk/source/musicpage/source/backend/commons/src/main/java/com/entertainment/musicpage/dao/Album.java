package com.entertainment.musicpage.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the album database table.
 * 
 */
@Entity
@Table(name="album")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlbumPK id;

	@Lob
	private String description;

	@Column(nullable=false, length=5555)
	private String source;

	@Column(nullable=false, length=5555)
	private String sourceType;

	@Column(nullable=false, length=5555)
	private String title;

	public Album() {
	}

	public AlbumPK getId() {
		return this.id;
	}

	public void setId(AlbumPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}