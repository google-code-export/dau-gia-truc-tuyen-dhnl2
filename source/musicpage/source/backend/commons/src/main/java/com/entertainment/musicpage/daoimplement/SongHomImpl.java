package com.entertainment.musicpage.daoimplement;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entertainment.musicpage.common.Configuration;
import com.entertainment.musicpage.dao.Song;
import com.entertainment.musicpage.dao.SongHome;

public class SongHomImpl extends SongHome{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(Song.class.getName());

	
	public Integer insertSong(String title, String source, String sourceType, String description){
		Song s = new Song();
		s.setTitle(title);
		s.setSource(source);
		s.setSourceType(sourceType);
		s.setDescription(description);
		
		SessionFactory sessionFac = Configuration.loadHBConfiguration().buildSessionFactory();
		Session session = sessionFac.openSession();
		session.beginTransaction();
		
		session. save(s);
		
		
		session.getTransaction().commit();
		session.refresh(s);
		session.close();
		Integer id = s.getId();
		return id;
		
	}
	
	public List<Song> findBySource(String link){
		SessionFactory sessionFac = Configuration.loadHBConfiguration().buildSessionFactory();
		Session session = sessionFac.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Song where source like :link"); // table name is Class Name
		query.setParameter("link", link);
		List<Song> list = query.list();
		
		session.getTransaction().commit();
		session.close();
		return list;
		
	}
	
	
}
