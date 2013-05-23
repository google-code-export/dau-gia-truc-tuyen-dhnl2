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

	@Id
	@SequenceGenerator(name="SONG_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SONG_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private int id;

	@Lob
	private String description;

	@Column(nullable=false, length=5555)
	private String source;

	@Column(nullable=false, length=5555)
	private String sourceType;

	@Column(nullable=false, length=5555)
	private String title;

	public Song() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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