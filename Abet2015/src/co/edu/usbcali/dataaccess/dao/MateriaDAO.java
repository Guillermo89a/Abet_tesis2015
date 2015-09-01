package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Materia;

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
 * Materia entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Materia
 */
@Scope("singleton")
@Repository("MateriaDAO")
public class MateriaDAO implements IMateriaDAO {
    private static final Logger log = LoggerFactory.getLogger(MateriaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Materia Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Materia instance) {
        log.debug("saving Materia instance");

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
    *            Materia Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Materia instance) {
        log.debug("deleting Materia instance");

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
    *            Materia Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Materia instance) {
        log.debug("updating Materia instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Materia findById(Long id) {
        log.debug("finding Materia instance with id: " + id);

        try {
            Materia instance = (Materia) sessionFactory.getCurrentSession()
                                                       .get(Materia.class, id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Materia failed", re);
            throw re;
        }
    }

    public List<Materia> findByExample(Materia instance) {
        log.debug("finding Materia instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Materia")
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
    * Find all  Materia entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Materia> found by query
        */
    public List<Materia> findByProperty(String propertyName, Object value) {
        log.debug("finding Materia instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Materia as model where model." +
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

    public List<Materia> findByCreditos(Object creditos) {
        return findByProperty(CREDITOS, creditos);
    }

    public List<Materia> findByIdCodigoMateria(Object idCodigoMateria) {
        return findByProperty(IDCODIGOMATERIA, idCodigoMateria);
    }

    public List<Materia> findByNombre(Object nombre) {
        return findByProperty(NOMBRE, nombre);
    }

    /**
    * Find all Materia entities.
    *
    * @return List<Materia> all Materia instances
    */
    public List<Materia> findAll() {
        log.debug("finding all Materia instances");

        try {
            String queryString = "from Materia";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Materia> findByCriteria(String whereCondition) {
        log.debug("finding Materia " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Materia model " +
                where;

            List<Materia> entitiesList = sessionFactory.getCurrentSession()
                                                       .createQuery(queryString)
                                                       .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Materia failed", re);
            throw re;
        }
    }

    public List<Materia> findPageMateria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Materia findPageMateria");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Materia model order by model." +
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
                String queryString = "select model from Materia model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberMateria() {
        log.debug("finding Materia count");

        try {
            String queryString = "select count(*) from Materia model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IMateriaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IMateriaDAO) ctx.getBean("MateriaDAO");
    }
}
