package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.RubricaPorCurso;

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
 * RubricaPorCurso entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.RubricaPorCurso
 */
@Scope("singleton")
@Repository("RubricaPorCursoDAO")
public class RubricaPorCursoDAO implements IRubricaPorCursoDAO {
    private static final Logger log = LoggerFactory.getLogger(RubricaPorCursoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            RubricaPorCurso Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(RubricaPorCurso instance) {
        log.debug("saving RubricaPorCurso instance");

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
    *            RubricaPorCurso Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(RubricaPorCurso instance) {
        log.debug("deleting RubricaPorCurso instance");

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
    *            RubricaPorCurso Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(RubricaPorCurso instance) {
        log.debug("updating RubricaPorCurso instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public RubricaPorCurso findById(Long id) {
        log.debug("finding RubricaPorCurso instance with id: " + id);

        try {
            RubricaPorCurso instance = (RubricaPorCurso) sessionFactory.getCurrentSession()
                                                                       .get(RubricaPorCurso.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding RubricaPorCurso failed", re);
            throw re;
        }
    }

    public List<RubricaPorCurso> findByExample(RubricaPorCurso instance) {
        log.debug("finding RubricaPorCurso instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.RubricaPorCurso")
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
    * Find all  RubricaPorCurso entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< RubricaPorCurso> found by query
        */
    public List<RubricaPorCurso> findByProperty(String propertyName,
        Object value) {
        log.debug("finding RubricaPorCurso instance with property: " +
            propertyName + ", value: " + value);

        try {
            String queryString = "from RubricaPorCurso as model where model." +
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

    public List<RubricaPorCurso> findByIdRubricaPorCurso(
        Object idRubricaPorCurso) {
        return findByProperty(IDRUBRICAPORCURSO, idRubricaPorCurso);
    }

    /**
    * Find all RubricaPorCurso entities.
    *
    * @return List<RubricaPorCurso> all RubricaPorCurso instances
    */
    public List<RubricaPorCurso> findAll() {
        log.debug("finding all RubricaPorCurso instances");

        try {
            String queryString = "from RubricaPorCurso";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<RubricaPorCurso> findByCriteria(String whereCondition) {
        log.debug("finding RubricaPorCurso " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from RubricaPorCurso model " +
                where;

            List<RubricaPorCurso> entitiesList = sessionFactory.getCurrentSession()
                                                               .createQuery(queryString)
                                                               .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in RubricaPorCurso failed", re);
            throw re;
        }
    }

    public List<RubricaPorCurso> findPageRubricaPorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) {
        log.debug("finding RubricaPorCurso findPageRubricaPorCurso");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from RubricaPorCurso model order by model." +
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
                String queryString = "select model from RubricaPorCurso model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberRubricaPorCurso() {
        log.debug("finding RubricaPorCurso count");

        try {
            String queryString = "select count(*) from RubricaPorCurso model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IRubricaPorCursoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IRubricaPorCursoDAO) ctx.getBean("RubricaPorCursoDAO");
    }
}
