package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Categoria;

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
 * Categoria entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Categoria
 */
@Scope("singleton")
@Repository("CategoriaDAO")
public class CategoriaDAO implements ICategoriaDAO {
    private static final Logger log = LoggerFactory.getLogger(CategoriaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Categoria Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Categoria instance) {
        log.debug("saving Categoria instance");

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
    *            Categoria Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Categoria instance) {
        log.debug("deleting Categoria instance");

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
    *            Categoria Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Categoria instance) {
        log.debug("updating Categoria instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Categoria findById(Long id) {
        log.debug("finding Categoria instance with id: " + id);

        try {
            Categoria instance = (Categoria) sessionFactory.getCurrentSession()
                                                           .get(Categoria.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Categoria failed", re);
            throw re;
        }
    }

    public List<Categoria> findByExample(Categoria instance) {
        log.debug("finding Categoria instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Categoria")
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
    * Find all  Categoria entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Categoria> found by query
        */
    public List<Categoria> findByProperty(String propertyName, Object value) {
        log.debug("finding Categoria instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Categoria as model where model." +
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

    public List<Categoria> findByIdCategoria(Object idCategoria) {
        return findByProperty(IDCATEGORIA, idCategoria);
    }

    public List<Categoria> findByNombrecategoria(Object nombrecategoria) {
        return findByProperty(NOMBRECATEGORIA, nombrecategoria);
    }

    /**
    * Find all Categoria entities.
    *
    * @return List<Categoria> all Categoria instances
    */
    public List<Categoria> findAll() {
        log.debug("finding all Categoria instances");

        try {
            String queryString = "from Categoria";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Categoria> findByCriteria(String whereCondition) {
        log.debug("finding Categoria " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Categoria model " +
                where;

            List<Categoria> entitiesList = sessionFactory.getCurrentSession()
                                                         .createQuery(queryString)
                                                         .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Categoria failed", re);
            throw re;
        }
    }

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Categoria findPageCategoria");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Categoria model order by model." +
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
                String queryString = "select model from Categoria model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberCategoria() {
        log.debug("finding Categoria count");

        try {
            String queryString = "select count(*) from Categoria model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static ICategoriaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ICategoriaDAO) ctx.getBean("CategoriaDAO");
    }
}
