package com.entertainment.musicpage.test;

import java.util.List;

import com.entertainment.musicpage.dao.Song;
import com.entertainment.musicpage.daoimplement.SongHomImpl;

import junit.framework.TestCase;

public class DaoTest extends TestCase{
	public void testFindSongBySource(){
		List<Song> l = new SongHomImpl().findBySource("http://chiasenhac.com/hd/video/k-video/");
		System.out.println(l.size());
	}
	
	public void testInsertSong(){
		SongHomImpl s = new SongHomImpl();
		Integer id = s.insertSong("lele", "mp3.zing.vn", "zing", null);
		System.out.println("id "+id);
	}
}
