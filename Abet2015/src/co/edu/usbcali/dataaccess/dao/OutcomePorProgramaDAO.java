package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.OutcomePorPrograma;

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
 * OutcomePorPrograma entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.OutcomePorPrograma
 */
@Scope("singleton")
@Repository("OutcomePorProgramaDAO")
public class OutcomePorProgramaDAO implements IOutcomePorProgramaDAO {
    private static final Logger log = LoggerFactory.getLogger(OutcomePorProgramaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            OutcomePorPrograma Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(OutcomePorPrograma instance) {
        log.debug("saving OutcomePorPrograma instance");

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
    *            OutcomePorPrograma Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(OutcomePorPrograma instance) {
        log.debug("deleting OutcomePorPrograma instance");

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
    *            OutcomePorPrograma Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(OutcomePorPrograma instance) {
        log.debug("updating OutcomePorPrograma instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public OutcomePorPrograma findById(Long id) {
        log.debug("finding OutcomePorPrograma instance with id: " + id);

        try {
            OutcomePorPrograma instance = (OutcomePorPrograma) sessionFactory.getCurrentSession()
                                                                             .get(OutcomePorPrograma.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding OutcomePorPrograma failed", re);
            throw re;
        }
    }

    public List<OutcomePorPrograma> findByExample(OutcomePorPrograma instance) {
        log.debug("finding OutcomePorPrograma instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.OutcomePorPrograma")
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
    * Find all  OutcomePorPrograma entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< OutcomePorPrograma> found by query
        */
    public List<OutcomePorPrograma> findByProperty(String propertyName,
        Object value) {
        log.debug("finding OutcomePorPrograma instance with property: " +
            propertyName + ", value: " + value);

        try {
            String queryString = "from OutcomePorPrograma as model where model." +
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

    public List<OutcomePorPrograma> findByIdOutcomePorPrograma(
        Object idOutcomePorPrograma) {
        return findByProperty(IDOUTCOMEPORPROGRAMA, idOutcomePorPrograma);
    }

    /**
    * Find all OutcomePorPrograma entities.
    *
    * @return List<OutcomePorPrograma> all OutcomePorPrograma instances
    */
    public List<OutcomePorPrograma> findAll() {
        log.debug("finding all OutcomePorPrograma instances");

        try {
            String queryString = "from OutcomePorPrograma";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<OutcomePorPrograma> findByCriteria(String whereCondition) {
        log.debug("finding OutcomePorPrograma " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from OutcomePorPrograma model " +
                where;

            List<OutcomePorPrograma> entitiesList = sessionFactory.getCurrentSession()
                                                                  .createQuery(queryString)
                                                                  .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in OutcomePorPrograma failed", re);
            throw re;
        }
    }

    public List<OutcomePorPrograma> findPageOutcomePorPrograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) {
        log.debug("finding OutcomePorPrograma findPageOutcomePorPrograma");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from OutcomePorPrograma model order by model." +
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
                String queryString = "select model from OutcomePorPrograma model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberOutcomePorPrograma() {
        log.debug("finding OutcomePorPrograma count");

        try {
            String queryString = "select count(*) from OutcomePorPrograma model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IOutcomePorProgramaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IOutcomePorProgramaDAO) ctx.getBean("OutcomePorProgramaDAO");
    }
}
