package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.RubricaPorCurso;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for RubricaPorCursoDAO.
*
*/
public interface IRubricaPorCursoDAO {
    // property constants
    //public static final Long  IDRUBRICAPORCURSO = "idRubricaPorCurso";
    public static final String IDRUBRICAPORCURSO = "idRubricaPorCurso";

    public void save(RubricaPorCurso instance);

    public void delete(RubricaPorCurso instance);

    public void update(RubricaPorCurso instance);

    public RubricaPorCurso findById(Long id);

    public List<RubricaPorCurso> findByExample(RubricaPorCurso instance);

    public List<RubricaPorCurso> findByProperty(String propertyName,
        Object value);

    public List<RubricaPorCurso> findAll();

    public List<RubricaPorCurso> findByCriteria(String whereCondition);

    public List<RubricaPorCurso> findPageRubricaPorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults);

    public Long findTotalNumberRubricaPorCurso();

    public List<RubricaPorCurso> findByIdRubricaPorCurso(
        Object idRubricaPorCurso);
}
