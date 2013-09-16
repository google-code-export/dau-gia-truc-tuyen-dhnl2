package com.entertainment.musicpage.test;

import java.util.Iterator;
import java.util.List;

import com.entertainment.musicpage.dao.models.Song;
import com.entertainment.musicpage.daoimplement.CustomSongDAOImpl;

import junit.framework.TestCase;

public class SongTest extends TestCase {
	public void testFindSongTopDownWithPaging(){
		List<Song> l = new CustomSongDAOImpl().findOrderById(0, 10);
		System.out.println(l);
		Iterator<Song> it = l.iterator();
		while(it.hasNext()){
			Song s = it.next();
			System.out.println(s.getId());
			System.out.println("----");
		}
	
	}
}
