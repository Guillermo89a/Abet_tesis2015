package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Pensum;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for PensumDAO.
*
*/
public interface IPensumDAO {
    // property constants
    //public static final String  CREDITOS = "creditos";
    public static final String CREDITOS = "creditos";

    //public static final Long  IDPENSUM = "idPensum";
    public static final String IDPENSUM = "idPensum";

    //public static final String  SEMESTRE = "semestre";
    public static final String SEMESTRE = "semestre";

    public void save(Pensum instance);

    public void delete(Pensum instance);

    public void update(Pensum instance);

    public Pensum findById(Long id);

    public List<Pensum> findByExample(Pensum instance);

    public List<Pensum> findByProperty(String propertyName, Object value);

    public List<Pensum> findAll();

    public List<Pensum> findByCriteria(String whereCondition);

    public List<Pensum> findPagePensum(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberPensum();

    public List<Pensum> findByCreditos(Object creditos);

    public List<Pensum> findByIdPensum(Object idPensum);

    public List<Pensum> findBySemestre(Object semestre);
}
