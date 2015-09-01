package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.OutcomePorCurso;

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
 * OutcomePorCurso entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.OutcomePorCurso
 */
@Scope("singleton")
@Repository("OutcomePorCursoDAO")
public class OutcomePorCursoDAO implements IOutcomePorCursoDAO {
    private static final Logger log = LoggerFactory.getLogger(OutcomePorCursoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            OutcomePorCurso Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(OutcomePorCurso instance) {
        log.debug("saving OutcomePorCurso instance");

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
    *            OutcomePorCurso Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(OutcomePorCurso instance) {
        log.debug("deleting OutcomePorCurso instance");

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
    *            OutcomePorCurso Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(OutcomePorCurso instance) {
        log.debug("updating OutcomePorCurso instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public OutcomePorCurso findById(Long id) {
        log.debug("finding OutcomePorCurso instance with id: " + id);

        try {
            OutcomePorCurso instance = (OutcomePorCurso) sessionFactory.getCurrentSession()
                                                                       .get(OutcomePorCurso.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding OutcomePorCurso failed", re);
            throw re;
        }
    }

    public List<OutcomePorCurso> findByExample(OutcomePorCurso instance) {
        log.debug("finding OutcomePorCurso instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.OutcomePorCurso")
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
    * Find all  OutcomePorCurso entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< OutcomePorCurso> found by query
        */
    public List<OutcomePorCurso> findByProperty(String propertyName,
        Object value) {
        log.debug("finding OutcomePorCurso instance with property: " +
            propertyName + ", value: " + value);

        try {
            String queryString = "from OutcomePorCurso as model where model." +
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

    public List<OutcomePorCurso> findByDetalle(Object detalle) {
        return findByProperty(DETALLE, detalle);
    }

    public List<OutcomePorCurso> findByIdOutcomePorCurso(
        Object idOutcomePorCurso) {
        return findByProperty(IDOUTCOMEPORCURSO, idOutcomePorCurso);
    }

    /**
    * Find all OutcomePorCurso entities.
    *
    * @return List<OutcomePorCurso> all OutcomePorCurso instances
    */
    public List<OutcomePorCurso> findAll() {
        log.debug("finding all OutcomePorCurso instances");

        try {
            String queryString = "from OutcomePorCurso";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<OutcomePorCurso> findByCriteria(String whereCondition) {
        log.debug("finding OutcomePorCurso " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from OutcomePorCurso model " +
                where;

            List<OutcomePorCurso> entitiesList = sessionFactory.getCurrentSession()
                                                               .createQuery(queryString)
                                                               .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in OutcomePorCurso failed", re);
            throw re;
        }
    }

    public List<OutcomePorCurso> findPageOutcomePorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) {
        log.debug("finding OutcomePorCurso findPageOutcomePorCurso");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from OutcomePorCurso model order by model." +
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
                String queryString = "select model from OutcomePorCurso model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberOutcomePorCurso() {
        log.debug("finding OutcomePorCurso count");

        try {
            String queryString = "select count(*) from OutcomePorCurso model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IOutcomePorCursoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IOutcomePorCursoDAO) ctx.getBean("OutcomePorCursoDAO");
    }
}
