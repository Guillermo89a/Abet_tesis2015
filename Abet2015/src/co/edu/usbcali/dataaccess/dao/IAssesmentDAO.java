package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Assesment;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for AssesmentDAO.
*
*/
public interface IAssesmentDAO {
    // property constants
    //public static final Long  CALIFICACION = "calificacion";
    public static final String CALIFICACION = "calificacion";

    //public static final Long  IDCODIGOASSESMENT = "idCodigoAssesment";
    public static final String IDCODIGOASSESMENT = "idCodigoAssesment";

    public void save(Assesment instance);

    public void delete(Assesment instance);

    public void update(Assesment instance);

    public Assesment findById(Long id);

    public List<Assesment> findByExample(Assesment instance);

    public List<Assesment> findByProperty(String propertyName, Object value);

    public List<Assesment> findAll();

    public List<Assesment> findByCriteria(String whereCondition);

    public List<Assesment> findPageAssesment(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberAssesment();

    public List<Assesment> findByCalificacion(Object calificacion);

    public List<Assesment> findByIdCodigoAssesment(Object idCodigoAssesment);
}
