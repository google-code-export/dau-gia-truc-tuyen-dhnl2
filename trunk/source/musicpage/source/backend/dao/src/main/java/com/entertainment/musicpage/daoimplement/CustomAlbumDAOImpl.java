package com.entertainment.musicpage.daoimplement;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entertainment.musicpage.dao.dao.impl.AlbumDAOImpl;
import com.entertainment.musicpage.dao.error.DuplicateException;
import com.entertainment.musicpage.dao.models.Album;

public class CustomAlbumDAOImpl extends AlbumDAOImpl implements CustomAlbumDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CustomAlbumDAOImpl.class.getName());

	
	public Integer insertAlbum(String title, String source, String sourceType,
			String description) {
		Album a = new Album();
		a.setTitle(title);
		a.setSource(source);
		a.setSourceType(sourceType);
		a.setDescription(description);
		a.setCreatedTime(new Date(System.currentTimeMillis()));
		a.setModifyTime(new Date(System.currentTimeMillis()));
		
		Session session = getDAOManager();
		session.beginTransaction();
		
		session. save(a);
		
		session.getTransaction().commit();
		Integer id = a.getId();
		log.info("insert success Album with id ".concat(id+""));
		return id;
	}

	public Integer insertAlbumWithoutDuplicated(String title, String source,
			String sourceType, String description) throws DuplicateException {
		
		List<Album> liAls = this.findBySource(source);
		if(liAls!=null) throw new DuplicateException("Duplicate Album with source: ".concat(source));
		log.info("insert success Album no duplicate with src ".concat(source));
		return insertAlbum(title, source, sourceType, description);
	}

	public List<Album> findBySource(String source) {
		
		Query query = getDAOManager().createQuery(" select t from Album t where t.source = :source ");
		query.setParameter("source", source);
		List<Album> results = query.list();
		log.info("findBySource success with src ".concat( source));
		if (results !=null && results.size() > 0) {
			return results;
		}
		return null;
	}

	public List<Album> findAllByLimit(int start, int amount) {
		Query query = getDAOManager().createQuery(" select t from Album t");
		query.setMaxResults(amount);
		query.setFirstResult(start);
		List<Album> results = query.list();
		log.info(String.format("findAllByLimit with start %s amount %s", start,amount));
		if (results !=null && results.size() > 0) {
			return results;
		}
		return null;
	}
	
	@Override
	public void update(Album arg0) {
		Transaction trs = getDAOManager().beginTransaction();
		super.update(arg0);
		trs.commit();
	}

	public List<Album> findRandNewsAlbum(int start, int amount) {
		Query query = getDAOManager().createQuery(" select t from Album t group by urlImage");
		query.setMaxResults(amount);
		query.setFirstResult(start);
		List<Album> results = query.list();
		log.info(String.format("findRandNewsAlbum with start %s amount %s", start,amount));
		if (results !=null && results.size() > 0) {
			return results;
		}
		return null;
	}
}
