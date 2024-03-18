package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TForums;

/**
 * A data access object (DAO) providing persistence and search support for
 * TForums entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TForums
 * @author MyEclipse Persistence Tools
 */

public class TForumsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TForumsDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String NAME = "name";
	public static final String FUP = "fup";
	public static final String STATUS = "status";

	protected void initDao() {
		// do nothing
	}

	public void save(TForums transientInstance) {
		log.debug("saving TForums instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TForums persistentInstance) {
		log.debug("deleting TForums instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TForums findById(java.lang.Integer id) {
		log.debug("getting TForums instance with id: " + id);
		try {
			TForums instance = (TForums) getHibernateTemplate().get(
					"com.model.TForums", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TForums instance) {
		log.debug("finding TForums instance by example");
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
		log.debug("finding TForums instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TForums as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByFup(Object fup) {
		return findByProperty(FUP, fup);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all TForums instances");
		try {
			String queryString = "from TForums";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TForums merge(TForums detachedInstance) {
		log.debug("merging TForums instance");
		try {
			TForums result = (TForums) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TForums instance) {
		log.debug("attaching dirty TForums instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TForums instance) {
		log.debug("attaching clean TForums instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TForumsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TForumsDAO) ctx.getBean("TForumsDAO");
	}
}