package com.entertainment.musicpage.dao.models;
// default package
// Generated May 28, 2013 11:52:59 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Song.
 * @see .Song
 * @author Hibernate Tools
 */
@Stateless
public class SongHome {

	private static final Log log = LogFactory.getLog(SongHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Song transientInstance) {
		log.debug("persisting Song instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Song persistentInstance) {
		log.debug("removing Song instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Song merge(Song detachedInstance) {
		log.debug("merging Song instance");
		try {
			Song result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Song findById(Integer id) {
		log.debug("getting Song instance with id: " + id);
		try {
			Song instance = entityManager.find(Song.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
