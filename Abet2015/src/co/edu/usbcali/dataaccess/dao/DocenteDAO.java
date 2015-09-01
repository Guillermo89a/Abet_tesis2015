package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Docente;

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
 * Docente entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Docente
 */
@Scope("singleton")
@Repository("DocenteDAO")
public class DocenteDAO implements IDocenteDAO {
    private static final Logger log = LoggerFactory.getLogger(DocenteDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Docente Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Docente instance) {
        log.debug("saving Docente instance");

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
    *            Docente Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Docente instance) {
        log.debug("deleting Docente instance");

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
    *            Docente Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Docente instance) {
        log.debug("updating Docente instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Docente findById(Long id) {
        log.debug("finding Docente instance with id: " + id);

        try {
            Docente instance = (Docente) sessionFactory.getCurrentSession()
                                                       .get(Docente.class, id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Docente failed", re);
            throw re;
        }
    }

    public List<Docente> findByExample(Docente instance) {
        log.debug("finding Docente instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Docente")
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
    * Find all  Docente entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Docente> found by query
        */
    public List<Docente> findByProperty(String propertyName, Object value) {
        log.debug("finding Docente instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Docente as model where model." +
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

    public List<Docente> findByIdCodigoDocente(Object idCodigoDocente) {
        return findByProperty(IDCODIGODOCENTE, idCodigoDocente);
    }

    public List<Docente> findByNombreDocente(Object nombreDocente) {
        return findByProperty(NOMBREDOCENTE, nombreDocente);
    }

    /**
    * Find all Docente entities.
    *
    * @return List<Docente> all Docente instances
    */
    public List<Docente> findAll() {
        log.debug("finding all Docente instances");

        try {
            String queryString = "from Docente";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Docente> findByCriteria(String whereCondition) {
        log.debug("finding Docente " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Docente model " +
                where;

            List<Docente> entitiesList = sessionFactory.getCurrentSession()
                                                       .createQuery(queryString)
                                                       .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Docente failed", re);
            throw re;
        }
    }

    public List<Docente> findPageDocente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Docente findPageDocente");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Docente model order by model." +
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
                String queryString = "select model from Docente model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberDocente() {
        log.debug("finding Docente count");

        try {
            String queryString = "select count(*) from Docente model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IDocenteDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IDocenteDAO) ctx.getBean("DocenteDAO");
    }
}
