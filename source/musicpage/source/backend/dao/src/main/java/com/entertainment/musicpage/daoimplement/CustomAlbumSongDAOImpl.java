package com.entertainment.musicpage.daoimplement;

import com.entertainment.musicpage.dao.dao.impl.AlbumsongDAOImpl;
import com.entertainment.musicpage.dao.models.Albumsong;
import com.entertainment.musicpage.dao.models.AlbumsongId;

public class CustomAlbumSongDAOImpl extends AlbumsongDAOImpl implements CustomAlbumSongDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlbumsongId insertAlbumSong(Integer songId, Integer AlbumId) {
		AlbumsongId id = new AlbumsongId(AlbumId, songId);
		Albumsong as = new Albumsong();
		as.setId(id);
		this.getDAOManager().beginTransaction();
		this.save(as);
		this.getDAOManager().getTransaction().commit();
		return id;
	}

}
