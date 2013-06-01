package com.entertainment.musicpage.daoimplement;

import java.util.List;

import com.entertainment.musicpage.dao.dao.AlbumDAO;
import com.entertainment.musicpage.dao.error.DuplicateException;
import com.entertainment.musicpage.dao.models.Album;

public interface CustomAlbumDAO extends AlbumDAO{
	public Integer insertAlbum(String title, String source, String sourceType, String description);
	
	public Integer insertAlbumWithoutDuplicated(String title, String source, String sourceType, String description) throws DuplicateException;
	
	public List<Album > findBySource(String source);
}
