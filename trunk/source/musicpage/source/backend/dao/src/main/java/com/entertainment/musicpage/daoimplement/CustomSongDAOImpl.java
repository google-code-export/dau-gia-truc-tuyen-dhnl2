package com.entertainment.musicpage.daoimplement;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.entertainment.musicpage.dao.dao.SongDAO;
import com.entertainment.musicpage.dao.dao.impl.SongDAOImpl;
import com.entertainment.musicpage.dao.error.DuplicateException;
import com.entertainment.musicpage.dao.models.Song;

public class CustomSongDAOImpl extends SongDAOImpl implements SongDAO,CustomSongDAO{

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CustomSongDAOImpl.class.getName());

	
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
		log.info("success insert song with id ".concat(id+""));
		return id;
		
	}
	
	public List<Song> findBySource(String source){
		Query query = getDAOManager().createQuery(" select t from Song t where t.source = :source ");
		query.setParameter("source", source);

		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
		
	}

	public Integer insertWithoutDuplicate(String title, String source, String sourceType, String description) throws DuplicateException{
		
		List<Song> listToChecking = findBySource(source);
		if(listToChecking != null) throw new DuplicateException("Duplicate entry with source: ".concat(source));
		log.info("success insert song without duplicated src ".concat(source));
		return insertSong(title, source, sourceType, description);
		
	}
	
}
