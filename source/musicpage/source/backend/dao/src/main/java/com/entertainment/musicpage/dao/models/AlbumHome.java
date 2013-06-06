package com.entertainment.musicpage.dao.models;
// default package
// Generated Jun 6, 2013 11:46:43 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Album.
 * @see .Album
 * @author Hibernate Tools
 */
@Stateless
public class AlbumHome {

	private static final Log log = LogFactory.getLog(AlbumHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Album transientInstance) {
		log.debug("persisting Album instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Album persistentInstance) {
		log.debug("removing Album instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Album merge(Album detachedInstance) {
		log.debug("merging Album instance");
		try {
			Album result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Album findById(Integer id) {
		log.debug("getting Album instance with id: " + id);
		try {
			Album instance = entityManager.find(Album.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
