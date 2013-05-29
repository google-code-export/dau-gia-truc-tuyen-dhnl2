package com.entertainment.musicpage.daoimplement;

import java.util.List;

import com.entertainment.musicpage.dao.dao.SongDAO;
import com.entertainment.musicpage.dao.models.Song;

public interface CustomSongDAO extends SongDAO {
	public Integer insertSong(String title, String source, String sourceType, String description);

	public List<Song> findBySource(String link);
}
