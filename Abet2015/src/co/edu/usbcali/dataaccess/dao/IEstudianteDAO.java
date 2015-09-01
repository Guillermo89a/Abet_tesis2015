package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Estudiante;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for EstudianteDAO.
*
*/
public interface IEstudianteDAO {
    // property constants
    //public static final String  DIRECCION = "direccion";
    public static final String DIRECCION = "direccion";

    //public static final String  EMAIL = "email";
    public static final String EMAIL = "email";

    //public static final Long  IDCODIGOESTUDIANTE = "idCodigoEstudiante";
    public static final String IDCODIGOESTUDIANTE = "idCodigoEstudiante";

    //public static final String  NOMBRE = "nombre";
    public static final String NOMBRE = "nombre";

    //public static final String  TELEFONO = "telefono";
    public static final String TELEFONO = "telefono";

    public void save(Estudiante instance);

    public void delete(Estudiante instance);

    public void update(Estudiante instance);

    public Estudiante findById(Long id);

    public List<Estudiante> findByExample(Estudiante instance);

    public List<Estudiante> findByProperty(String propertyName, Object value);

    public List<Estudiante> findAll();

    public List<Estudiante> findByCriteria(String whereCondition);

    public List<Estudiante> findPageEstudiante(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberEstudiante();

    public List<Estudiante> findByDireccion(Object direccion);

    public List<Estudiante> findByEmail(Object email);

    public List<Estudiante> findByIdCodigoEstudiante(Object idCodigoEstudiante);

    public List<Estudiante> findByNombre(Object nombre);

    public List<Estudiante> findByTelefono(Object telefono);
}
