package com.entertainment.musicpage.dao.models;
// default package
// Generated Jun 6, 2013 11:46:43 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Albumsong.
 * @see .Albumsong
 * @author Hibernate Tools
 */
@Stateless
public class AlbumsongHome {

	private static final Log log = LogFactory.getLog(AlbumsongHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Albumsong transientInstance) {
		log.debug("persisting Albumsong instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Albumsong persistentInstance) {
		log.debug("removing Albumsong instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Albumsong merge(Albumsong detachedInstance) {
		log.debug("merging Albumsong instance");
		try {
			Albumsong result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Albumsong findById(AlbumsongId id) {
		log.debug("getting Albumsong instance with id: " + id);
		try {
			Albumsong instance = entityManager.find(Albumsong.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
