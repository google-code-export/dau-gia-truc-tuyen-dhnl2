
 /***************************************************
 * Generated by DAOGenerator http://daogenerator.u-db.com
 * http://daogenerator.u-db.com email: buraksrc@gmail.com
 ***************************************************/
 
 
 package com.entertainment.musicpage.dao.bo.impl;
 
 
 import com.entertainment.musicpage.dao.bo.SongBO;
 import com.entertainment.musicpage.dao.dao.impl.SongDAOImpl;
 
 import java.io.Serializable;
 import java.util.List;
 import com.entertainment.musicpage.dao.models.Song;
 import java.lang.Integer;
 import java.lang.String;
 import java.util.Date;
 
 
 /***************************************************
 *BO interface of song table.
 *Generated on Tue May 28 23:59:52 ICT 2013
 ***************************************************/
 
 
 public class SongBOImpl implements SongBO {
 
 
 
 		 SongDAOImpl songDAO;
 
 /**
 * @return Song
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> findAll(){
		return songDAO.findAll();

	}
 
 /**
 * Inserts Song
 * @param: Song
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public void save(Song arg0){
		songDAO.save(arg0);

	}
 
 /**
 * Updates Song
 * @param: Song
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public void update(Song arg0){
		songDAO.update(arg0);

	}
 
 /**
 * Removes Song
 * @param: Song
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public void delete(Song arg0){
		songDAO.delete(arg0);

	}
 
 /**
 * @return Song
 * @param: java.lang.Integer Id
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongById(Integer id){
		return songDAO.getSongById(id);

	}

/**
 * @return Song
 * @param: java.lang.Integer id
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongById(Integer id, int startPosition, int maxResult){
		return songDAO.getSongById(id, startPosition, maxResult);

	}
 
 /**
 * @return Song
 * @param: java.lang.String Title
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongByTitle(String title){
		return songDAO.getSongByTitle(title);

	}

/**
 * @return Song
 * @param: java.lang.String title
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongByTitle(String title, int startPosition, int maxResult){
		return songDAO.getSongByTitle(title, startPosition, maxResult);

	}
 
 /**
 * @return Song
 * @param: java.lang.String Source
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongBySource(String source){
		return songDAO.getSongBySource(source);

	}

/**
 * @return Song
 * @param: java.lang.String source
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongBySource(String source, int startPosition, int maxResult){
		return songDAO.getSongBySource(source, startPosition, maxResult);

	}
 
 /**
 * @return Song
 * @param: java.lang.String Sourcetype
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongBySourcetype(String sourcetype){
		return songDAO.getSongBySourcetype(sourcetype);

	}

/**
 * @return Song
 * @param: java.lang.String sourcetype
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongBySourcetype(String sourcetype, int startPosition, int maxResult){
		return songDAO.getSongBySourcetype(sourcetype, startPosition, maxResult);

	}
 
 /**
 * @return Song
 * @param: java.lang.String Description
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongByDescription(String description){
		return songDAO.getSongByDescription(description);

	}

/**
 * @return Song
 * @param: java.lang.String description
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongByDescription(String description, int startPosition, int maxResult){
		return songDAO.getSongByDescription(description, startPosition, maxResult);

	}
 
 /**
 * @return Song
 * @param: java.util.Date Createdtime
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongByCreatedtime(Date createdtime){
		return songDAO.getSongByCreatedtime(createdtime);

	}

/**
 * @return Song
 * @param: java.util.Date createdtime
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongByCreatedtime(Date createdtime, int startPosition, int maxResult){
		return songDAO.getSongByCreatedtime(createdtime, startPosition, maxResult);

	}
 
 /**
 * @return Song
 * @param: java.util.Date Modifytime
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongByModifytime(Date modifytime){
		return songDAO.getSongByModifytime(modifytime);

	}

/**
 * @return Song
 * @param: java.util.Date modifytime
 * @param: int startposition
 * @param: int maxresults
 * Generated on: Tue May 28 23:59:52 ICT 2013
 * @See Song
 */
	public List<Song> getSongByModifytime(Date modifytime, int startPosition, int maxResult){
		return songDAO.getSongByModifytime(modifytime, startPosition, maxResult);

	}
 
 
 
 
 }