package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Pensum;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;


/**
 * A data access object (DAO) providing persistence and search support for
 * Pensum entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Pensum
 */
@Scope("singleton")
@Repository("PensumDAO")
public class PensumDAO implements IPensumDAO {
    private static final Logger log = LoggerFactory.getLogger(PensumDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Pensum Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Pensum instance) {
        log.debug("saving Pensum instance");

        try {
            sessionFactory.getCurrentSession().save(instance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    /**
    * @param Instance
    *            Pensum Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Pensum instance) {
        log.debug("deleting Pensum instance");

        try {
            sessionFactory.getCurrentSession().delete(instance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    /**
    *
    * @param Instance
    *            Pensum Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Pensum instance) {
        log.debug("updating Pensum instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Pensum findById(Long id) {
        log.debug("finding Pensum instance with id: " + id);

        try {
            Pensum instance = (Pensum) sessionFactory.getCurrentSession()
                                                     .get(Pensum.class, id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Pensum failed", re);
            throw re;
        }
    }

    public List<Pensum> findByExample(Pensum instance) {
        log.debug("finding Pensum instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Pensum")
                                         .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " +
                results.size());

            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    /**
    * Find all  Pensum entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Pensum> found by query
        */
    public List<Pensum> findByProperty(String propertyName, Object value) {
        log.debug("finding Pensum instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Pensum as model where model." +
                propertyName + "= ?";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);
            queryObject.setParameter(0, value);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<Pensum> findByCreditos(Object creditos) {
        return findByProperty(CREDITOS, creditos);
    }

    public List<Pensum> findByIdPensum(Object idPensum) {
        return findByProperty(IDPENSUM, idPensum);
    }

    public List<Pensum> findBySemestre(Object semestre) {
        return findByProperty(SEMESTRE, semestre);
    }

    /**
    * Find all Pensum entities.
    *
    * @return List<Pensum> all Pensum instances
    */
    public List<Pensum> findAll() {
        log.debug("finding all Pensum instances");

        try {
            String queryString = "from Pensum";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Pensum> findByCriteria(String whereCondition) {
        log.debug("finding Pensum " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Pensum model " +
                where;

            List<Pensum> entitiesList = sessionFactory.getCurrentSession()
                                                      .createQuery(queryString)
                                                      .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Pensum failed", re);
            throw re;
        }
    }

    public List<Pensum> findPagePensum(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Pensum findPagePensum");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Pensum model order by model." +
                    sortColumnName + " " + (sortAscending ? "asc" : "desc");

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        } else {
            try {
                String queryString = "select model from Pensum model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberPensum() {
        log.debug("finding Pensum count");

        try {
            String queryString = "select count(*) from Pensum model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IPensumDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IPensumDAO) ctx.getBean("PensumDAO");
    }
}
