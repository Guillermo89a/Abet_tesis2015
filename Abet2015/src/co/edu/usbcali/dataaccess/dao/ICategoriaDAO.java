package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Categoria;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for CategoriaDAO.
*
*/
public interface ICategoriaDAO {
    // property constants
    //public static final Long  IDCATEGORIA = "idCategoria";
    public static final String IDCATEGORIA = "idCategoria";

    //public static final String  NOMBRECATEGORIA = "nombrecategoria";
    public static final String NOMBRECATEGORIA = "nombrecategoria";

    public void save(Categoria instance);

    public void delete(Categoria instance);

    public void update(Categoria instance);

    public Categoria findById(Long id);

    public List<Categoria> findByExample(Categoria instance);

    public List<Categoria> findByProperty(String propertyName, Object value);

    public List<Categoria> findAll();

    public List<Categoria> findByCriteria(String whereCondition);

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberCategoria();

    public List<Categoria> findByIdCategoria(Object idCategoria);

    public List<Categoria> findByNombrecategoria(Object nombrecategoria);
}
