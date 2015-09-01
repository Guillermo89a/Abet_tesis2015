package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.DetalleRubrica;

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
 * DetalleRubrica entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.DetalleRubrica
 */
@Scope("singleton")
@Repository("DetalleRubricaDAO")
public class DetalleRubricaDAO implements IDetalleRubricaDAO {
    private static final Logger log = LoggerFactory.getLogger(DetalleRubricaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            DetalleRubrica Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(DetalleRubrica instance) {
        log.debug("saving DetalleRubrica instance");

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
    *            DetalleRubrica Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(DetalleRubrica instance) {
        log.debug("deleting DetalleRubrica instance");

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
    *            DetalleRubrica Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(DetalleRubrica instance) {
        log.debug("updating DetalleRubrica instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public DetalleRubrica findById(Long id) {
        log.debug("finding DetalleRubrica instance with id: " + id);

        try {
            DetalleRubrica instance = (DetalleRubrica) sessionFactory.getCurrentSession()
                                                                     .get(DetalleRubrica.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding DetalleRubrica failed", re);
            throw re;
        }
    }

    public List<DetalleRubrica> findByExample(DetalleRubrica instance) {
        log.debug("finding DetalleRubrica instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.DetalleRubrica")
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
    * Find all  DetalleRubrica entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< DetalleRubrica> found by query
        */
    public List<DetalleRubrica> findByProperty(String propertyName, Object value) {
        log.debug("finding DetalleRubrica instance with property: " +
            propertyName + ", value: " + value);

        try {
            String queryString = "from DetalleRubrica as model where model." +
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

    public List<DetalleRubrica> findByIdDetalleRubrica(Object idDetalleRubrica) {
        return findByProperty(IDDETALLERUBRICA, idDetalleRubrica);
    }

    /**
    * Find all DetalleRubrica entities.
    *
    * @return List<DetalleRubrica> all DetalleRubrica instances
    */
    public List<DetalleRubrica> findAll() {
        log.debug("finding all DetalleRubrica instances");

        try {
            String queryString = "from DetalleRubrica";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<DetalleRubrica> findByCriteria(String whereCondition) {
        log.debug("finding DetalleRubrica " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from DetalleRubrica model " +
                where;

            List<DetalleRubrica> entitiesList = sessionFactory.getCurrentSession()
                                                              .createQuery(queryString)
                                                              .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in DetalleRubrica failed", re);
            throw re;
        }
    }

    public List<DetalleRubrica> findPageDetalleRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding DetalleRubrica findPageDetalleRubrica");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from DetalleRubrica model order by model." +
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
                String queryString = "select model from DetalleRubrica model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberDetalleRubrica() {
        log.debug("finding DetalleRubrica count");

        try {
            String queryString = "select count(*) from DetalleRubrica model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IDetalleRubricaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IDetalleRubricaDAO) ctx.getBean("DetalleRubricaDAO");
    }
}
