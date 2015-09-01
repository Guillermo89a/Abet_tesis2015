package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.PeriodoAcademico;

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
 * PeriodoAcademico entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.PeriodoAcademico
 */
@Scope("singleton")
@Repository("PeriodoAcademicoDAO")
public class PeriodoAcademicoDAO implements IPeriodoAcademicoDAO {
    private static final Logger log = LoggerFactory.getLogger(PeriodoAcademicoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            PeriodoAcademico Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(PeriodoAcademico instance) {
        log.debug("saving PeriodoAcademico instance");

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
    *            PeriodoAcademico Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(PeriodoAcademico instance) {
        log.debug("deleting PeriodoAcademico instance");

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
    *            PeriodoAcademico Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(PeriodoAcademico instance) {
        log.debug("updating PeriodoAcademico instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public PeriodoAcademico findById(Long id) {
        log.debug("finding PeriodoAcademico instance with id: " + id);

        try {
            PeriodoAcademico instance = (PeriodoAcademico) sessionFactory.getCurrentSession()
                                                                         .get(PeriodoAcademico.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding PeriodoAcademico failed", re);
            throw re;
        }
    }

    public List<PeriodoAcademico> findByExample(PeriodoAcademico instance) {
        log.debug("finding PeriodoAcademico instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.PeriodoAcademico")
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
    * Find all  PeriodoAcademico entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< PeriodoAcademico> found by query
        */
    public List<PeriodoAcademico> findByProperty(String propertyName,
        Object value) {
        log.debug("finding PeriodoAcademico instance with property: " +
            propertyName + ", value: " + value);

        try {
            String queryString = "from PeriodoAcademico as model where model." +
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

    public List<PeriodoAcademico> findByDescripcionPeriodo(
        Object descripcionPeriodo) {
        return findByProperty(DESCRIPCIONPERIODO, descripcionPeriodo);
    }

    public List<PeriodoAcademico> findByIdPeriodoAcademico(
        Object idPeriodoAcademico) {
        return findByProperty(IDPERIODOACADEMICO, idPeriodoAcademico);
    }

    /**
    * Find all PeriodoAcademico entities.
    *
    * @return List<PeriodoAcademico> all PeriodoAcademico instances
    */
    public List<PeriodoAcademico> findAll() {
        log.debug("finding all PeriodoAcademico instances");

        try {
            String queryString = "from PeriodoAcademico";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<PeriodoAcademico> findByCriteria(String whereCondition) {
        log.debug("finding PeriodoAcademico " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from PeriodoAcademico model " +
                where;

            List<PeriodoAcademico> entitiesList = sessionFactory.getCurrentSession()
                                                                .createQuery(queryString)
                                                                .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in PeriodoAcademico failed", re);
            throw re;
        }
    }

    public List<PeriodoAcademico> findPagePeriodoAcademico(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) {
        log.debug("finding PeriodoAcademico findPagePeriodoAcademico");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from PeriodoAcademico model order by model." +
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
                String queryString = "select model from PeriodoAcademico model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberPeriodoAcademico() {
        log.debug("finding PeriodoAcademico count");

        try {
            String queryString = "select count(*) from PeriodoAcademico model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IPeriodoAcademicoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IPeriodoAcademicoDAO) ctx.getBean("PeriodoAcademicoDAO");
    }
}
