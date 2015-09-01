package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Outcome;

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
 * Outcome entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Outcome
 */
@Scope("singleton")
@Repository("OutcomeDAO")
public class OutcomeDAO implements IOutcomeDAO {
    private static final Logger log = LoggerFactory.getLogger(OutcomeDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Outcome Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Outcome instance) {
        log.debug("saving Outcome instance");

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
    *            Outcome Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Outcome instance) {
        log.debug("deleting Outcome instance");

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
    *            Outcome Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Outcome instance) {
        log.debug("updating Outcome instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Outcome findById(Long id) {
        log.debug("finding Outcome instance with id: " + id);

        try {
            Outcome instance = (Outcome) sessionFactory.getCurrentSession()
                                                       .get(Outcome.class, id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Outcome failed", re);
            throw re;
        }
    }

    public List<Outcome> findByExample(Outcome instance) {
        log.debug("finding Outcome instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Outcome")
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
    * Find all  Outcome entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Outcome> found by query
        */
    public List<Outcome> findByProperty(String propertyName, Object value) {
        log.debug("finding Outcome instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Outcome as model where model." +
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

    public List<Outcome> findByDetalle(Object detalle) {
        return findByProperty(DETALLE, detalle);
    }

    public List<Outcome> findByIdOutcome(Object idOutcome) {
        return findByProperty(IDOUTCOME, idOutcome);
    }

    /**
    * Find all Outcome entities.
    *
    * @return List<Outcome> all Outcome instances
    */
    public List<Outcome> findAll() {
        log.debug("finding all Outcome instances");

        try {
            String queryString = "from Outcome";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Outcome> findByCriteria(String whereCondition) {
        log.debug("finding Outcome " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Outcome model " +
                where;

            List<Outcome> entitiesList = sessionFactory.getCurrentSession()
                                                       .createQuery(queryString)
                                                       .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Outcome failed", re);
            throw re;
        }
    }

    public List<Outcome> findPageOutcome(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Outcome findPageOutcome");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Outcome model order by model." +
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
                String queryString = "select model from Outcome model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberOutcome() {
        log.debug("finding Outcome count");

        try {
            String queryString = "select count(*) from Outcome model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IOutcomeDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IOutcomeDAO) ctx.getBean("OutcomeDAO");
    }
}
