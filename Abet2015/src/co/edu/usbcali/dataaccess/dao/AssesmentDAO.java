package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Assesment;

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
 * Assesment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Assesment
 */
@Scope("singleton")
@Repository("AssesmentDAO")
public class AssesmentDAO implements IAssesmentDAO {
    private static final Logger log = LoggerFactory.getLogger(AssesmentDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Assesment Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Assesment instance) {
        log.debug("saving Assesment instance");

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
    *            Assesment Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Assesment instance) {
        log.debug("deleting Assesment instance");

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
    *            Assesment Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Assesment instance) {
        log.debug("updating Assesment instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Assesment findById(Long id) {
        log.debug("finding Assesment instance with id: " + id);

        try {
            Assesment instance = (Assesment) sessionFactory.getCurrentSession()
                                                           .get(Assesment.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Assesment failed", re);
            throw re;
        }
    }

    public List<Assesment> findByExample(Assesment instance) {
        log.debug("finding Assesment instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Assesment")
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
    * Find all  Assesment entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Assesment> found by query
        */
    public List<Assesment> findByProperty(String propertyName, Object value) {
        log.debug("finding Assesment instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Assesment as model where model." +
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

    public List<Assesment> findByCalificacion(Object calificacion) {
        return findByProperty(CALIFICACION, calificacion);
    }

    public List<Assesment> findByIdCodigoAssesment(Object idCodigoAssesment) {
        return findByProperty(IDCODIGOASSESMENT, idCodigoAssesment);
    }

    /**
    * Find all Assesment entities.
    *
    * @return List<Assesment> all Assesment instances
    */
    public List<Assesment> findAll() {
        log.debug("finding all Assesment instances");

        try {
            String queryString = "from Assesment";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Assesment> findByCriteria(String whereCondition) {
        log.debug("finding Assesment " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Assesment model " +
                where;

            List<Assesment> entitiesList = sessionFactory.getCurrentSession()
                                                         .createQuery(queryString)
                                                         .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Assesment failed", re);
            throw re;
        }
    }

    public List<Assesment> findPageAssesment(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Assesment findPageAssesment");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Assesment model order by model." +
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
                String queryString = "select model from Assesment model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberAssesment() {
        log.debug("finding Assesment count");

        try {
            String queryString = "select count(*) from Assesment model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IAssesmentDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IAssesmentDAO) ctx.getBean("AssesmentDAO");
    }
}
