package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Estudiante;

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
 * Estudiante entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Estudiante
 */
@Scope("singleton")
@Repository("EstudianteDAO")
public class EstudianteDAO implements IEstudianteDAO {
    private static final Logger log = LoggerFactory.getLogger(EstudianteDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    /**
    *
    * @param Instance
    *            Estudiante Instance to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(Estudiante instance) {
        log.debug("saving Estudiante instance");

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
    *            Estudiante Instance to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(Estudiante instance) {
        log.debug("deleting Estudiante instance");

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
    *            Estudiante Instance to update
    * @throws RuntimeException
    *             when the operation fails
    */
    public void update(Estudiante instance) {
        log.debug("updating Estudiante instance");

        try {
            sessionFactory.getCurrentSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public Estudiante findById(Long id) {
        log.debug("finding Estudiante instance with id: " + id);

        try {
            Estudiante instance = (Estudiante) sessionFactory.getCurrentSession()
                                                             .get(Estudiante.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            log.error("finding Estudiante failed", re);
            throw re;
        }
    }

    public List<Estudiante> findByExample(Estudiante instance) {
        log.debug("finding Estudiante instance by example");

        try {
            List results = sessionFactory.getCurrentSession()
                                         .createCriteria("co.edu.usbcali.abet.Estudiante")
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
    * Find all  Estudiante entities with a specific property value.
    *
    * @param value
    *            the property value to match
    * @param propertyName
    *            the property to search in the instance
    * @return List< Estudiante> found by query
        */
    public List<Estudiante> findByProperty(String propertyName, Object value) {
        log.debug("finding Estudiante instance with property: " + propertyName +
            ", value: " + value);

        try {
            String queryString = "from Estudiante as model where model." +
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

    public List<Estudiante> findByDireccion(Object direccion) {
        return findByProperty(DIRECCION, direccion);
    }

    public List<Estudiante> findByEmail(Object email) {
        return findByProperty(EMAIL, email);
    }

    public List<Estudiante> findByIdCodigoEstudiante(Object idCodigoEstudiante) {
        return findByProperty(IDCODIGOESTUDIANTE, idCodigoEstudiante);
    }

    public List<Estudiante> findByNombre(Object nombre) {
        return findByProperty(NOMBRE, nombre);
    }

    public List<Estudiante> findByTelefono(Object telefono) {
        return findByProperty(TELEFONO, telefono);
    }

    /**
    * Find all Estudiante entities.
    *
    * @return List<Estudiante> all Estudiante instances
    */
    public List<Estudiante> findAll() {
        log.debug("finding all Estudiante instances");

        try {
            String queryString = "from Estudiante";
            Query queryObject = sessionFactory.getCurrentSession()
                                              .createQuery(queryString);

            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List<Estudiante> findByCriteria(String whereCondition) {
        log.debug("finding Estudiante " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from Estudiante model " +
                where;

            List<Estudiante> entitiesList = sessionFactory.getCurrentSession()
                                                          .createQuery(queryString)
                                                          .list();

            return entitiesList;
        } catch (RuntimeException re) {
            log.error("find By Criteria in Estudiante failed", re);
            throw re;
        }
    }

    public List<Estudiante> findPageEstudiante(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        log.debug("finding Estudiante findPageEstudiante");

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from Estudiante model order by model." +
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
                String queryString = "select model from Estudiante model";

                return sessionFactory.getCurrentSession()
                                     .createQuery(queryString)
                                     .setFirstResult(startRow)
                                     .setMaxResults(maxResults).list();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    public Long findTotalNumberEstudiante() {
        log.debug("finding Estudiante count");

        try {
            String queryString = "select count(*) from Estudiante model";

            return (Long) sessionFactory.getCurrentSession()
                                        .createQuery(queryString).list().get(0);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public static IEstudianteDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IEstudianteDAO) ctx.getBean("EstudianteDAO");
    }
}
