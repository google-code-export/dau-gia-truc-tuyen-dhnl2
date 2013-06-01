package com.entertainment.musicpage.daoimplement;

import com.entertainment.musicpage.dao.dao.AlbumsongDAO;
import com.entertainment.musicpage.dao.models.AlbumsongId;

public interface CustomAlbumSongDAO extends AlbumsongDAO{
	public AlbumsongId insertAlbumSong(Integer idSong, Integer idAlbum);
}
