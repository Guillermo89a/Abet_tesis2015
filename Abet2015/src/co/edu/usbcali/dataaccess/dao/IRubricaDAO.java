package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Rubrica;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for RubricaDAO.
*
*/
public interface IRubricaDAO {
    // property constants
    //public static final Long  IDRUBRICA = "idRubrica";
    public static final String IDRUBRICA = "idRubrica";

    //public static final String  NOMBRERUBRICA = "nombreRubrica";
    public static final String NOMBRERUBRICA = "nombreRubrica";

    public void save(Rubrica instance);

    public void delete(Rubrica instance);

    public void update(Rubrica instance);

    public Rubrica findById(Long id);

    public List<Rubrica> findByExample(Rubrica instance);

    public List<Rubrica> findByProperty(String propertyName, Object value);

    public List<Rubrica> findAll();

    public List<Rubrica> findByCriteria(String whereCondition);

    public List<Rubrica> findPageRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberRubrica();

    public List<Rubrica> findByIdRubrica(Object idRubrica);

    public List<Rubrica> findByNombreRubrica(Object nombreRubrica);
}
