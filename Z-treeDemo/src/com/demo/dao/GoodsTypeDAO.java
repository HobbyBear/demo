package com.demo.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.pojo.GoodsType;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.demo.pojo.GoodsType
 * @author MyEclipse Persistence Tools
 */
public class GoodsTypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GoodsTypeDAO.class);
	// property constants
	public static final String TYPE_NAME = "typeName";
	public static final String TYPE_LV = "typeLv";
	public static final String TYPE_PATH = "typePath";

	public void save(GoodsType transientInstance) {
		log.debug("saving GoodsType instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GoodsType persistentInstance) {
		log.debug("deleting GoodsType instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GoodsType findById(java.lang.Integer id) {
		log.debug("getting GoodsType instance with id: " + id);
		try {
			GoodsType instance = (GoodsType) getSession().get("com.demo.pojo.GoodsType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(GoodsType instance) {
		log.debug("finding GoodsType instance by example");
		try {
			List results = getSession().createCriteria("com.demo.pojo.GoodsType").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding GoodsType instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from GoodsType as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTypeName(Object typeName) {
		return findByProperty(TYPE_NAME, typeName);
	}

	public List findByTypeLv(Object typeLv) {
		return findByProperty(TYPE_LV, typeLv);
	}

	public List findByTypePath(Object typePath) {
		return findByProperty(TYPE_PATH, typePath);
	}

	public List findAll() {
		log.debug("finding all GoodsType instances");
		try {
			String queryString = "from GoodsType";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GoodsType merge(GoodsType detachedInstance) {
		log.debug("merging GoodsType instance");
		try {
			GoodsType result = (GoodsType) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GoodsType instance) {
		log.debug("attaching dirty GoodsType instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GoodsType instance) {
		log.debug("attaching clean GoodsType instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}