package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Materia;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for MateriaDAO.
*
*/
public interface IMateriaDAO {
    // property constants
    //public static final String  CREDITOS = "creditos";
    public static final String CREDITOS = "creditos";

    //public static final Long  IDCODIGOMATERIA = "idCodigoMateria";
    public static final String IDCODIGOMATERIA = "idCodigoMateria";

    //public static final String  NOMBRE = "nombre";
    public static final String NOMBRE = "nombre";

    public void save(Materia instance);

    public void delete(Materia instance);

    public void update(Materia instance);

    public Materia findById(Long id);

    public List<Materia> findByExample(Materia instance);

    public List<Materia> findByProperty(String propertyName, Object value);

    public List<Materia> findAll();

    public List<Materia> findByCriteria(String whereCondition);

    public List<Materia> findPageMateria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberMateria();

    public List<Materia> findByCreditos(Object creditos);

    public List<Materia> findByIdCodigoMateria(Object idCodigoMateria);

    public List<Materia> findByNombre(Object nombre);
}
