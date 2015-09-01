package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Curso;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for CursoDAO.
*
*/
public interface ICursoDAO {
    // property constants
    //public static final Long  IDCURSO = "idCurso";
    public static final String IDCURSO = "idCurso";

    //public static final String  NOMBRECURSO = "nombreCurso";
    public static final String NOMBRECURSO = "nombreCurso";

    public void save(Curso instance);

    public void delete(Curso instance);

    public void update(Curso instance);

    public Curso findById(Long id);

    public List<Curso> findByExample(Curso instance);

    public List<Curso> findByProperty(String propertyName, Object value);

    public List<Curso> findAll();

    public List<Curso> findByCriteria(String whereCondition);

    public List<Curso> findPageCurso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberCurso();

    public List<Curso> findByIdCurso(Object idCurso);

    public List<Curso> findByNombreCurso(Object nombreCurso);
}
