package com.entertainment.musicpage.daoimplement;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entertainment.musicpage.common.Configuration;
import com.entertainment.musicpage.dao.dao.SongDAO;
import com.entertainment.musicpage.dao.dao.impl.SongDAOImpl;
import com.entertainment.musicpage.dao.models.Song;

public class CustomSongDAOImpl extends SongDAOImpl implements SongDAO,CustomSongDAO{

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(Song.class.getName());

	
	public Integer insertSong(String title, String source, String sourceType, String description){
		Song s = new Song();
		s.setTitle(title);
		s.setSource(source);
		s.setSourceType(sourceType);
		s.setDescription(description);
		s.setCreatedTime(new Date(System.currentTimeMillis()));
		s.setModifyTime(new Date(System.currentTimeMillis()));
		
		Session session = getDAOManager();
		session.beginTransaction();
		
		session. save(s);
		
		
		session.getTransaction().commit();
		session.refresh(s);
		Integer id = s.getId();
		return id;
		
	}
	
	public List<Song> findBySource(String link){
		SessionFactory sessionFac = Configuration.loadHBConfiguration().buildSessionFactory();
		Session session = getDAOManager();
		session.beginTransaction();
		
		Query query = session.createQuery("from Song where source like :link"); // table name is Class Name
		query.setParameter("link", link);
		List<Song> list = query.list();
		
		System.out.println(list.get(0));
		session.getTransaction().commit();
		return list;
		
	}

	
}
