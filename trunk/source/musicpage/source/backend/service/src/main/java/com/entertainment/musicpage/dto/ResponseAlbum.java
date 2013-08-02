package com.entertainment.musicpage.dto;

import java.util.List;

import com.entertainment.musicpage.dao.models.Album;
import com.entertainment.musicpage.dao.models.Song;

public class ResponseAlbum {
	Album album;
	List<Song> listAlbumSongs;
	
	public ResponseAlbum() {
	}

	public ResponseAlbum(Album album, List<Song> listAlbumSongs) {
		this.album = album;
		this.listAlbumSongs = listAlbumSongs;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Song> getListAlbumSongs() {
		return listAlbumSongs;
	}

	public void setListAlbumSongs(List<Song> listAlbumSongs) {
		this.listAlbumSongs = listAlbumSongs;
	}
	
	
}
