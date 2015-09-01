package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Curso;

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
 * Curso entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Curso
 */
@Scope("singleton")
@Repository("CursoDAO")
public class CursoDAO implements ICursoDAO {
    private static final Logger log = LoggerFactory.getLogger(CursoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Curso Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Curso instance) {
        log.debug("saving Curso instance");

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
    *            Curso Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Curso instance) {
        log.debug("deleting Curso instance");

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
    *            Curso Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Curso instance) {
        log.debug("updating Curso instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Curso findById(Long id) {
        log.debug("finding Curso instance with id: " + id);

        try {
            Curso instance = (Curso) sessionFactory.getCurrentSession()
                                                   .get(Curso.class, id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Curso failed", re);
            throw re;
        }
    }

    public List<Curso> findByExample(Curso instance) {
        log.debug("finding Curso instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Curso")
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
    * Find all  Curso entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Curso> found by query
        */
    public List<Curso> findByProperty(String propertyName, Object value) {
        log.debug("finding Curso instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Curso as model where model." +
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

    public List<Curso> findByIdCurso(Object idCurso) {
        return findByProperty(IDCURSO, idCurso);
    }

    public List<Curso> findByNombreCurso(Object nombreCurso) {
        return findByProperty(NOMBRECURSO, nombreCurso);
    }

    /**
    * Find all Curso entities.
    *
    * @return List<Curso> all Curso instances
    */
    public List<Curso> findAll() {
        log.debug("finding all Curso instances");

        try {
            String queryString = "from Curso";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Curso> findByCriteria(String whereCondition) {
        log.debug("finding Curso " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Curso model " +
                where;

            List<Curso> entitiesList = sessionFactory.getCurrentSession()
                                                     .createQuery(queryString)
                                                     .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Curso failed", re);
            throw re;
        }
    }

    public List<Curso> findPageCurso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Curso findPageCurso");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Curso model order by model." +
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
                String queryString = "select model from Curso model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberCurso() {
        log.debug("finding Curso count");

        try {
            String queryString = "select count(*) from Curso model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static ICursoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (ICursoDAO) ctx.getBean("CursoDAO");
    }
}
