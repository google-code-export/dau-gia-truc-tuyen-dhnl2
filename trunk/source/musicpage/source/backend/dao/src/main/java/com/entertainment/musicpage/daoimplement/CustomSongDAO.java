package com.entertainment.musicpage.daoimplement;

import java.util.List;

import com.entertainment.musicpage.dao.dao.SongDAO;
import com.entertainment.musicpage.dao.error.DuplicateException;
import com.entertainment.musicpage.dao.models.Song;

public interface CustomSongDAO extends SongDAO {
	public Integer insertSong(String title, String source, String sourceType, String description);

	public List<Song> findBySource(String link);
	
	public Integer insertWithoutDuplicate(String title, String source, String sourceType, String description)  throws DuplicateException;
	
	public List<Song> findOrderById(int start, int amount);
}
