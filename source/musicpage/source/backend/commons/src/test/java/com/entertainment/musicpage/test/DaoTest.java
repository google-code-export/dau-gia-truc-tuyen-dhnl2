package com.entertainment.musicpage.test;

import java.util.List;

import com.entertainment.musicpage.dao.Song;
import com.entertainment.musicpage.daoimplement.CustomSong;

import junit.framework.TestCase;

public class DaoTest extends TestCase{
	public void testFindSongBySource(){
		List<Song> l = new CustomSong().findBySource("http://chiasenhac.com/hd/video/k-video/");
		System.out.println(l.size());
	}
}
