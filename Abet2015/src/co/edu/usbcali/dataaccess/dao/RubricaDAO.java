package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Rubrica;

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
 * Rubrica entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Rubrica
 */
@Scope("singleton")
@Repository("RubricaDAO")
public class RubricaDAO implements IRubricaDAO {
    private static final Logger log = LoggerFactory.getLogger(RubricaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Rubrica Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Rubrica instance) {
        log.debug("saving Rubrica instance");

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
    *            Rubrica Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Rubrica instance) {
        log.debug("deleting Rubrica instance");

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
    *            Rubrica Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Rubrica instance) {
        log.debug("updating Rubrica instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Rubrica findById(Long id) {
        log.debug("finding Rubrica instance with id: " + id);

        try {
            Rubrica instance = (Rubrica) sessionFactory.getCurrentSession()
                                                       .get(Rubrica.class, id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Rubrica failed", re);
            throw re;
        }
    }

    public List<Rubrica> findByExample(Rubrica instance) {
        log.debug("finding Rubrica instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Rubrica")
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
    * Find all  Rubrica entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Rubrica> found by query
        */
    public List<Rubrica> findByProperty(String propertyName, Object value) {
        log.debug("finding Rubrica instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Rubrica as model where model." +
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

    public List<Rubrica> findByIdRubrica(Object idRubrica) {
        return findByProperty(IDRUBRICA, idRubrica);
    }

    public List<Rubrica> findByNombreRubrica(Object nombreRubrica) {
        return findByProperty(NOMBRERUBRICA, nombreRubrica);
    }

    /**
    * Find all Rubrica entities.
    *
    * @return List<Rubrica> all Rubrica instances
    */
    public List<Rubrica> findAll() {
        log.debug("finding all Rubrica instances");

        try {
            String queryString = "from Rubrica";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Rubrica> findByCriteria(String whereCondition) {
        log.debug("finding Rubrica " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Rubrica model " +
                where;

            List<Rubrica> entitiesList = sessionFactory.getCurrentSession()
                                                       .createQuery(queryString)
                                                       .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Rubrica failed", re);
            throw re;
        }
    }

    public List<Rubrica> findPageRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Rubrica findPageRubrica");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Rubrica model order by model." +
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
                String queryString = "select model from Rubrica model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberRubrica() {
        log.debug("finding Rubrica count");

        try {
            String queryString = "select count(*) from Rubrica model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IRubricaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IRubricaDAO) ctx.getBean("RubricaDAO");
    }
}
