package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TTopic;

/**
 * A data access object (DAO) providing persistence and search support for
 * TTopic entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TTopic
 * @author MyEclipse Persistence Tools
 */

public class TTopicDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TTopicDAO.class);
	// property constants
	public static final String FID = "fid";
	public static final String AUTHOR = "author";
	public static final String AUTHORID = "authorid";
	public static final String SUBJECT = "subject";
	public static final String VIEW = "view";
	public static final String REPLIES = "replies";

	protected void initDao() {
		// do nothing
	}

	public void save(TTopic transientInstance) {
		log.debug("saving TTopic instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TTopic persistentInstance) {
		log.debug("deleting TTopic instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TTopic findById(java.lang.Integer id) {
		log.debug("getting TTopic instance with id: " + id);
		try {
			TTopic instance = (TTopic) getHibernateTemplate().get(
					"com.model.TTopic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TTopic instance) {
		log.debug("finding TTopic instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TTopic instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TTopic as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFid(Object fid) {
		return findByProperty(FID, fid);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByAuthorid(Object authorid) {
		return findByProperty(AUTHORID, authorid);
	}

	public List findBySubject(Object subject) {
		return findByProperty(SUBJECT, subject);
	}

	public List findByView(Object view) {
		return findByProperty(VIEW, view);
	}

	public List findByReplies(Object replies) {
		return findByProperty(REPLIES, replies);
	}

	public List findAll() {
		log.debug("finding all TTopic instances");
		try {
			String queryString = "from TTopic";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TTopic merge(TTopic detachedInstance) {
		log.debug("merging TTopic instance");
		try {
			TTopic result = (TTopic) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TTopic instance) {
		log.debug("attaching dirty TTopic instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TTopic instance) {
		log.debug("attaching clean TTopic instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TTopicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TTopicDAO) ctx.getBean("TTopicDAO");
	}
}