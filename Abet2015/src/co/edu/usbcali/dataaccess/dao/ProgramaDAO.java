package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Programa;

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
 * Programa entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Programa
 */
@Scope("singleton")
@Repository("ProgramaDAO")
public class ProgramaDAO implements IProgramaDAO {
    private static final Logger log = LoggerFactory.getLogger(ProgramaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Programa Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Programa instance) {
        log.debug("saving Programa instance");

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
    *            Programa Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Programa instance) {
        log.debug("deleting Programa instance");

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
    *            Programa Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Programa instance) {
        log.debug("updating Programa instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Programa findById(Long id) {
        log.debug("finding Programa instance with id: " + id);

        try {
            Programa instance = (Programa) sessionFactory.getCurrentSession()
                                                         .get(Programa.class, id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Programa failed", re);
            throw re;
        }
    }

    public List<Programa> findByExample(Programa instance) {
        log.debug("finding Programa instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Programa")
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
    * Find all  Programa entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Programa> found by query
        */
    public List<Programa> findByProperty(String propertyName, Object value) {
        log.debug("finding Programa instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Programa as model where model." +
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

    public List<Programa> findByDescripcion(Object descripcion) {
        return findByProperty(DESCRIPCION, descripcion);
    }

    public List<Programa> findByIdPrograma(Object idPrograma) {
        return findByProperty(IDPROGRAMA, idPrograma);
    }

    /**
    * Find all Programa entities.
    *
    * @return List<Programa> all Programa instances
    */
    public List<Programa> findAll() {
        log.debug("finding all Programa instances");

        try {
            String queryString = "from Programa";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Programa> findByCriteria(String whereCondition) {
        log.debug("finding Programa " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Programa model " +
                where;

            List<Programa> entitiesList = sessionFactory.getCurrentSession()
                                                        .createQuery(queryString)
                                                        .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Programa failed", re);
            throw re;
        }
    }

    public List<Programa> findPagePrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Programa findPagePrograma");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Programa model order by model." +
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
                String queryString = "select model from Programa model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberPrograma() {
        log.debug("finding Programa count");

        try {
            String queryString = "select count(*) from Programa model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IProgramaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IProgramaDAO) ctx.getBean("ProgramaDAO");
    }
}
