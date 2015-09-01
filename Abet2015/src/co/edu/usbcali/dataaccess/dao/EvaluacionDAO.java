package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Evaluacion;

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
 * Evaluacion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Evaluacion
 */
@Scope("singleton")
@Repository("EvaluacionDAO")
public class EvaluacionDAO implements IEvaluacionDAO {
    private static final Logger log = LoggerFactory.getLogger(EvaluacionDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Evaluacion Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Evaluacion instance) {
        log.debug("saving Evaluacion instance");

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
    *            Evaluacion Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Evaluacion instance) {
        log.debug("deleting Evaluacion instance");

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
    *            Evaluacion Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Evaluacion instance) {
        log.debug("updating Evaluacion instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Evaluacion findById(Long id) {
        log.debug("finding Evaluacion instance with id: " + id);

        try {
            Evaluacion instance = (Evaluacion) sessionFactory.getCurrentSession()
                                                             .get(Evaluacion.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Evaluacion failed", re);
            throw re;
        }
    }

    public List<Evaluacion> findByExample(Evaluacion instance) {
        log.debug("finding Evaluacion instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Evaluacion")
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
    * Find all  Evaluacion entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Evaluacion> found by query
        */
    public List<Evaluacion> findByProperty(String propertyName, Object value) {
        log.debug("finding Evaluacion instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Evaluacion as model where model." +
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

    public List<Evaluacion> findByIdEvaluacion(Object idEvaluacion) {
        return findByProperty(IDEVALUACION, idEvaluacion);
    }

    /**
    * Find all Evaluacion entities.
    *
    * @return List<Evaluacion> all Evaluacion instances
    */
    public List<Evaluacion> findAll() {
        log.debug("finding all Evaluacion instances");

        try {
            String queryString = "from Evaluacion";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Evaluacion> findByCriteria(String whereCondition) {
        log.debug("finding Evaluacion " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Evaluacion model " +
                where;

            List<Evaluacion> entitiesList = sessionFactory.getCurrentSession()
                                                          .createQuery(queryString)
                                                          .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Evaluacion failed", re);
            throw re;
        }
    }

    public List<Evaluacion> findPageEvaluacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Evaluacion findPageEvaluacion");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Evaluacion model order by model." +
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
                String queryString = "select model from Evaluacion model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberEvaluacion() {
        log.debug("finding Evaluacion count");

        try {
            String queryString = "select count(*) from Evaluacion model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IEvaluacionDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IEvaluacionDAO) ctx.getBean("EvaluacionDAO");
    }
}
