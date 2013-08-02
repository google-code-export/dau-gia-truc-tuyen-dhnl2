package com.entertainment.musicpage.test;

import java.util.List;

import junit.framework.TestCase;

import com.entertainment.musicpage.dao.models.Album;
import com.entertainment.musicpage.daoimplement.CustomAlbumDAOImpl;

public class AlbumTest extends TestCase{
	public void testFindRandNewsAlbum(){
		List<Album> l = new CustomAlbumDAOImpl().findRandNewsAlbum(0, 10);
		
		assertEquals(l.size(), 10);
		System.out.println(l);
	}
}
