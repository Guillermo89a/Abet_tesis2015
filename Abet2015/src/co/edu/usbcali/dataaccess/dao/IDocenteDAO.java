package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Docente;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for DocenteDAO.
*
*/
public interface IDocenteDAO {
    // property constants
    //public static final Long  IDCODIGODOCENTE = "idCodigoDocente";
    public static final String IDCODIGODOCENTE = "idCodigoDocente";

    //public static final String  NOMBREDOCENTE = "nombreDocente";
    public static final String NOMBREDOCENTE = "nombreDocente";

    public void save(Docente instance);

    public void delete(Docente instance);

    public void update(Docente instance);

    public Docente findById(Long id);

    public List<Docente> findByExample(Docente instance);

    public List<Docente> findByProperty(String propertyName, Object value);

    public List<Docente> findAll();

    public List<Docente> findByCriteria(String whereCondition);

    public List<Docente> findPageDocente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberDocente();

    public List<Docente> findByIdCodigoDocente(Object idCodigoDocente);

    public List<Docente> findByNombreDocente(Object nombreDocente);
}
