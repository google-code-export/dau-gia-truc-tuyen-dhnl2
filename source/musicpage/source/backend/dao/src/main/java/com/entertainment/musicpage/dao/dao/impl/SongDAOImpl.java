
 /***************************************************
 * Generated by DAOGenerator http://daogenerator.u-db.com
 * http://daogenerator.u-db.com email: buraksrc@gmail.com
 ***************************************************/
 
 
 package com.entertainment.musicpage.dao.dao.impl;
 
 
 import com.entertainment.musicpage.dao.dao.SongDAO;
 
 
 
 import java.io.Serializable;
 import com.entertainment.musicpage.dao.customdaosupport.CustomDAOSupport;
 import org.hibernate.Query;
 import java.util.List;
 import com.entertainment.musicpage.dao.models.Song;
 import java.lang.Integer;
 import java.lang.String;
 import java.util.Date;
 
 
 /***************************************************
 *DAO class of song table.
 *Generated on Sat Jun 01 01:50:25 ICT 2013
 ***************************************************/
 
 
 public class SongDAOImpl extends CustomDAOSupport implements Serializable, SongDAO {
 
 /**
 * @return Song
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> findAll(){

		Query query = getDAOManager().createQuery(" select t from Song t");

		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 /**
 * Inserts Song
 * @param: Song
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public void save(Song arg0){

		getDAOManager().persist(arg0);

	}
 
 /**
 * Updates Song
 * @param: Song
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public void update(Song arg0){

		getDAOManager().merge(arg0);

	}
 
 /**
 * Removes Song
 * @param: Song
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public void delete(Song arg0){

		getDAOManager().delete(arg0);

	}
 
 /**
 * @return Song
 * @param: java.lang.Integer Id
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongById(Integer id){

		Query query = getDAOManager().createQuery(" select t from Song t where t.id = ?1 ");

		query.setParameter(1, id);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}

/**
 * @return Song
 * @param: java.lang.Integer id
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongById(Integer id, int startPosition, int maxResult){

		Query query = getDAOManager().createQuery(" select t from Song t where t.id = ?1 ");

		if(startPosition > 0 && startPosition < maxResult){
			query.setMaxResults(maxResult);
			query.setFirstResult(startPosition);
		}

			query.setParameter(1, id);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 /**
 * @return Song
 * @param: java.lang.String Title
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongByTitle(String title){

		Query query = getDAOManager().createQuery(" select t from Song t where t.title = ?1 ");

		query.setParameter(1, title);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}

/**
 * @return Song
 * @param: java.lang.String title
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongByTitle(String title, int startPosition, int maxResult){

		Query query = getDAOManager().createQuery(" select t from Song t where t.title = ?1 ");

		if(startPosition > 0 && startPosition < maxResult){
			query.setMaxResults(maxResult);
			query.setFirstResult(startPosition);
		}

			query.setParameter(1, title);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 /**
 * @return Song
 * @param: java.lang.String Source
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongBySource(String source){

		Query query = getDAOManager().createQuery(" select t from Song t where t.source = ?1 ");

		query.setParameter(1, source);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}

/**
 * @return Song
 * @param: java.lang.String source
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongBySource(String source, int startPosition, int maxResult){

		Query query = getDAOManager().createQuery(" select t from Song t where t.source = ?1 ");

		if(startPosition > 0 && startPosition < maxResult){
			query.setMaxResults(maxResult);
			query.setFirstResult(startPosition);
		}

			query.setParameter(1, source);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 /**
 * @return Song
 * @param: java.lang.String Sourcetype
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongBySourcetype(String sourcetype){

		Query query = getDAOManager().createQuery(" select t from Song t where t.sourcetype = ?1 ");

		query.setParameter(1, sourcetype);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}

/**
 * @return Song
 * @param: java.lang.String sourcetype
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongBySourcetype(String sourcetype, int startPosition, int maxResult){

		Query query = getDAOManager().createQuery(" select t from Song t where t.sourcetype = ?1 ");

		if(startPosition > 0 && startPosition < maxResult){
			query.setMaxResults(maxResult);
			query.setFirstResult(startPosition);
		}

			query.setParameter(1, sourcetype);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 /**
 * @return Song
 * @param: java.lang.String Description
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongByDescription(String description){

		Query query = getDAOManager().createQuery(" select t from Song t where t.description = ?1 ");

		query.setParameter(1, description);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}

/**
 * @return Song
 * @param: java.lang.String description
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongByDescription(String description, int startPosition, int maxResult){

		Query query = getDAOManager().createQuery(" select t from Song t where t.description = ?1 ");

		if(startPosition > 0 && startPosition < maxResult){
			query.setMaxResults(maxResult);
			query.setFirstResult(startPosition);
		}

			query.setParameter(1, description);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 /**
 * @return Song
 * @param: java.util.Date Createdtime
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongByCreatedtime(Date createdtime){

		Query query = getDAOManager().createQuery(" select t from Song t where t.createdtime = ?1 ");

		query.setParameter(1, createdtime);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}

/**
 * @return Song
 * @param: java.util.Date createdtime
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongByCreatedtime(Date createdtime, int startPosition, int maxResult){

		Query query = getDAOManager().createQuery(" select t from Song t where t.createdtime = ?1 ");

		if(startPosition > 0 && startPosition < maxResult){
			query.setMaxResults(maxResult);
			query.setFirstResult(startPosition);
		}

			query.setParameter(1, createdtime);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 /**
 * @return Song
 * @param: java.util.Date Modifytime
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongByModifytime(Date modifytime){

		Query query = getDAOManager().createQuery(" select t from Song t where t.modifytime = ?1 ");

		query.setParameter(1, modifytime);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}

/**
 * @return Song
 * @param: java.util.Date modifytime
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Sat Jun 01 01:50:25 ICT 2013
 * @See Song
 */
	public List<Song> getSongByModifytime(Date modifytime, int startPosition, int maxResult){

		Query query = getDAOManager().createQuery(" select t from Song t where t.modifytime = ?1 ");

		if(startPosition > 0 && startPosition < maxResult){
			query.setMaxResults(maxResult);
			query.setFirstResult(startPosition);
		}

			query.setParameter(1, modifytime);


		List<Song> results = query.list();

		if (results !=null && results.size() > 0) {
			return results;
		}

		return null;
	}
 
 
 
 
 }