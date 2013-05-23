package com.entertainment.musicpage.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the album database table.
 * 
 */
@Embeddable
public class AlbumPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int id;

	@Column(unique=true, nullable=false)
	private int idSong;

	public AlbumPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSong() {
		return this.idSong;
	}
	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AlbumPK)) {
			return false;
		}
		AlbumPK castOther = (AlbumPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idSong == castOther.idSong);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idSong;
		
		return hash;
	}
}