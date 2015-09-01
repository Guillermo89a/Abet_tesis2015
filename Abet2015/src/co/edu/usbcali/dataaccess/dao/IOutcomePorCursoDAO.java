package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.OutcomePorCurso;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for OutcomePorCursoDAO.
*
*/
public interface IOutcomePorCursoDAO {
    // property constants
    //public static final String  DETALLE = "detalle";
    public static final String DETALLE = "detalle";

    //public static final Long  IDOUTCOMEPORCURSO = "idOutcomePorCurso";
    public static final String IDOUTCOMEPORCURSO = "idOutcomePorCurso";

    public void save(OutcomePorCurso instance);

    public void delete(OutcomePorCurso instance);

    public void update(OutcomePorCurso instance);

    public OutcomePorCurso findById(Long id);

    public List<OutcomePorCurso> findByExample(OutcomePorCurso instance);

    public List<OutcomePorCurso> findByProperty(String propertyName,
        Object value);

    public List<OutcomePorCurso> findAll();

    public List<OutcomePorCurso> findByCriteria(String whereCondition);

    public List<OutcomePorCurso> findPageOutcomePorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults);

    public Long findTotalNumberOutcomePorCurso();

    public List<OutcomePorCurso> findByDetalle(Object detalle);

    public List<OutcomePorCurso> findByIdOutcomePorCurso(
        Object idOutcomePorCurso);
}
