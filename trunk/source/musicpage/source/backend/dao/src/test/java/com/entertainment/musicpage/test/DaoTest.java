package com.entertainment.musicpage.test;

import java.util.List;

import com.entertainment.musicpage.dao.error.DuplicateException;
import com.entertainment.musicpage.dao.models.AlbumsongId;
import com.entertainment.musicpage.dao.models.Song;
import com.entertainment.musicpage.daoimplement.CustomAlbumDAO;
import com.entertainment.musicpage.daoimplement.CustomAlbumDAOImpl;
import com.entertainment.musicpage.daoimplement.CustomAlbumSongDAO;
import com.entertainment.musicpage.daoimplement.CustomAlbumSongDAOImpl;
import com.entertainment.musicpage.daoimplement.CustomSongDAOImpl;

import junit.framework.TestCase;

public class DaoTest extends TestCase{
	public void testFindSongBySource(){
		List<Song> l = new CustomSongDAOImpl().findBySource("http://chiasenhac.com/hd/video/k-video/");
		System.out.println(l.size());
	}
	
	public void testInsertSong(){
		CustomSongDAOImpl s = new CustomSongDAOImpl();
		Integer id = s.insertSong("lele tiếng việt có dấu", "mp3.zing.vn củ chuối chấm vi nen", "zing", null);
		System.out.println("id "+id);
	}
	
	public void testInsertSongDuplicate(){
		CustomSongDAOImpl s = new CustomSongDAOImpl();
		Integer id;
		try {
			id = s.insertWithoutDuplicate("lele", "mp3.zing.vn2", "zing", null);
			System.out.println("id "+id);
		} catch (DuplicateException e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void testInsertAlbumDuplicate(){
		CustomAlbumDAO aDao = new CustomAlbumDAOImpl();
		Integer id;
		try {
			id = aDao.insertAlbumWithoutDuplicated("Title of album", "nay thi source 3", "mp3 fake", null);
			System.out.println("id "+id);
		} catch (DuplicateException e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void testInsertAlbumSong(){
		CustomAlbumSongDAO customAlbumSongDao = new CustomAlbumSongDAOImpl();
		AlbumsongId id = customAlbumSongDao.insertAlbumSong(1, 2);
		
		System.out.println(id.toString());
	}
}
