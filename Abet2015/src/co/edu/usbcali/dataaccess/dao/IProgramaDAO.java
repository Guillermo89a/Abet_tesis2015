package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Programa;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for ProgramaDAO.
*
*/
public interface IProgramaDAO {
    // property constants
    //public static final String  DESCRIPCION = "descripcion";
    public static final String DESCRIPCION = "descripcion";

    //public static final Long  IDPROGRAMA = "idPrograma";
    public static final String IDPROGRAMA = "idPrograma";

    public void save(Programa instance);

    public void delete(Programa instance);

    public void update(Programa instance);

    public Programa findById(Long id);

    public List<Programa> findByExample(Programa instance);

    public List<Programa> findByProperty(String propertyName, Object value);

    public List<Programa> findAll();

    public List<Programa> findByCriteria(String whereCondition);

    public List<Programa> findPagePrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberPrograma();

    public List<Programa> findByDescripcion(Object descripcion);

    public List<Programa> findByIdPrograma(Object idPrograma);
}
