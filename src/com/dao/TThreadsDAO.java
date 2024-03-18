package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TThreads;

/**
 * A data access object (DAO) providing persistence and search support for
 * TThreads entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TThreads
 * @author MyEclipse Persistence Tools
 */

public class TThreadsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TThreadsDAO.class);
	// property constants
	public static final String PID = "pid";
	public static final String FID = "fid";
	public static final String FTYPE = "ftype";
	public static final String AUTHOR = "author";
	public static final String AUTHORID = "authorid";
	public static final String SUBJECT = "subject";
	public static final String CONTENT = "content";
	public static final String TNUM = "tnum";

	protected void initDao() {
		// do nothing
	}

	public void save(TThreads transientInstance) {
		log.debug("saving TThreads instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TThreads persistentInstance) {
		log.debug("deleting TThreads instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TThreads findById(java.lang.Integer id) {
		log.debug("getting TThreads instance with id: " + id);
		try {
			TThreads instance = (TThreads) getHibernateTemplate().get(
					"com.model.TThreads", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TThreads instance) {
		log.debug("finding TThreads instance by example");
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
		log.debug("finding TThreads instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TThreads as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPid(Object pid) {
		return findByProperty(PID, pid);
	}

	public List findByFid(Object fid) {
		return findByProperty(FID, fid);
	}

	public List findByFtype(Object ftype) {
		return findByProperty(FTYPE, ftype);
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

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByTnum(Object tnum) {
		return findByProperty(TNUM, tnum);
	}

	public List findAll() {
		log.debug("finding all TThreads instances");
		try {
			String queryString = "from TThreads";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TThreads merge(TThreads detachedInstance) {
		log.debug("merging TThreads instance");
		try {
			TThreads result = (TThreads) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TThreads instance) {
		log.debug("attaching dirty TThreads instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TThreads instance) {
		log.debug("attaching clean TThreads instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TThreadsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TThreadsDAO) ctx.getBean("TThreadsDAO");
	}
}