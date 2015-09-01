package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.ListaSepia;

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
 * ListaSepia entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.ListaSepia
 */
@Scope("singleton")
@Repository("ListaSepiaDAO")
public class ListaSepiaDAO implements IListaSepiaDAO {
    private static final Logger log = LoggerFactory.getLogger(ListaSepiaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            ListaSepia Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(ListaSepia instance) {
        log.debug("saving ListaSepia instance");

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
    *            ListaSepia Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(ListaSepia instance) {
        log.debug("deleting ListaSepia instance");

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
    *            ListaSepia Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(ListaSepia instance) {
        log.debug("updating ListaSepia instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public ListaSepia findById(Long id) {
        log.debug("finding ListaSepia instance with id: " + id);

        try {
            ListaSepia instance = (ListaSepia) sessionFactory.getCurrentSession()
                                                             .get(ListaSepia.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding ListaSepia failed", re);
            throw re;
        }
    }

    public List<ListaSepia> findByExample(ListaSepia instance) {
        log.debug("finding ListaSepia instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.ListaSepia")
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
    * Find all  ListaSepia entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< ListaSepia> found by query
        */
    public List<ListaSepia> findByProperty(String propertyName, Object value) {
        log.debug("finding ListaSepia instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from ListaSepia as model where model." +
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

    public List<ListaSepia> findByIdListaSepia(Object idListaSepia) {
        return findByProperty(IDLISTASEPIA, idListaSepia);
    }

    /**
    * Find all ListaSepia entities.
    *
    * @return List<ListaSepia> all ListaSepia instances
    */
    public List<ListaSepia> findAll() {
        log.debug("finding all ListaSepia instances");

        try {
            String queryString = "from ListaSepia";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<ListaSepia> findByCriteria(String whereCondition) {
        log.debug("finding ListaSepia " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from ListaSepia model " +
                where;

            List<ListaSepia> entitiesList = sessionFactory.getCurrentSession()
                                                          .createQuery(queryString)
                                                          .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in ListaSepia failed", re);
            throw re;
        }
    }

    public List<ListaSepia> findPageListaSepia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding ListaSepia findPageListaSepia");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from ListaSepia model order by model." +
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
                String queryString = "select model from ListaSepia model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberListaSepia() {
        log.debug("finding ListaSepia count");

        try {
            String queryString = "select count(*) from ListaSepia model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IListaSepiaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IListaSepiaDAO) ctx.getBean("ListaSepiaDAO");
    }
}
