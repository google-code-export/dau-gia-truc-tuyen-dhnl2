package com.entertainment.musicpage.test;

import java.util.List;
import java.util.Random;

import com.entertainment.musicpage.dao.error.DuplicateException;
import com.entertainment.musicpage.dao.models.Album;
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
		AlbumsongId id = customAlbumSongDao.insertAlbumSong(new Random().nextInt(999999), new Random().nextInt(999999));
		
		System.out.println(id.toString());
	}
	
	/**
	 * this test for performances test
	 */
	public void testInsertMultiSong(){
		for (int i = 0; i < 2500; i++) {
			this.testInsertSong();
		}
	}
	
	/**
	 * this test for performances test
	 */
	public void testInsertMultiAlbum(){
		for (int i = 0; i < 2500; i++) {
			this.testInsertAlbumSong();
		}
	}
	
	public void testPerformance(){
		for (int i = 0; i < 2500; i++) {
			this.testInsertAlbumSong();
			this.testInsertSong();
			this.testInsertSong();
		}
	}
	
	public void testSelectUpdate10ItemAlbum(){
		CustomAlbumDAO aDao = new CustomAlbumDAOImpl();
		List<Album >lA = aDao.findAllByLimit(10, 5);
		
		for (int i = 0; i < lA.size(); i++) {
			Album a = lA.get(i);
			System.out.println(a.getTitle());
			a.setUrlImage("FUUUU");
			aDao.update(a);
			
		}
		assertNotNull(lA);
	}
}
