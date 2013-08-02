package com.entertainment.musicpage.dto;

import java.util.List;

import com.entertainment.musicpage.dao.models.Album;

//@XmlRootElement(name="data")
public class ResponseRandListAlbum {
	private List<Album> listAlbums;
	
	public ResponseRandListAlbum() {
	}
	
	public ResponseRandListAlbum(List<Album> listAlbums) {
		super();
		this.listAlbums = listAlbums;
	}
	
	public List<Album> getListAlbums() {
		return listAlbums;
	}
	
//	@XmlElement(name="listALbum")
	public void setListAlbums(List<Album> listAlbums) {
		this.listAlbums = listAlbums;
	}
	
}
