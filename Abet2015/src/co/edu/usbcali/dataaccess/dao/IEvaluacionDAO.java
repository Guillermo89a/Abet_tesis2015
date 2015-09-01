package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Evaluacion;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for EvaluacionDAO.
*
*/
public interface IEvaluacionDAO {
    // property constants
    //public static final Long  IDEVALUACION = "idEvaluacion";
    public static final String IDEVALUACION = "idEvaluacion";

    public void save(Evaluacion instance);

    public void delete(Evaluacion instance);

    public void update(Evaluacion instance);

    public Evaluacion findById(Long id);

    public List<Evaluacion> findByExample(Evaluacion instance);

    public List<Evaluacion> findByProperty(String propertyName, Object value);

    public List<Evaluacion> findAll();

    public List<Evaluacion> findByCriteria(String whereCondition);

    public List<Evaluacion> findPageEvaluacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberEvaluacion();

    public List<Evaluacion> findByIdEvaluacion(Object idEvaluacion);
}
