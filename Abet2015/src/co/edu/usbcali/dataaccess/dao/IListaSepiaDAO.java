package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.ListaSepia;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for ListaSepiaDAO.
*
*/
public interface IListaSepiaDAO {
    // property constants
    //public static final Long  IDLISTASEPIA = "idListaSepia";
    public static final String IDLISTASEPIA = "idListaSepia";

    public void save(ListaSepia instance);

    public void delete(ListaSepia instance);

    public void update(ListaSepia instance);

    public ListaSepia findById(Long id);

    public List<ListaSepia> findByExample(ListaSepia instance);

    public List<ListaSepia> findByProperty(String propertyName, Object value);

    public List<ListaSepia> findAll();

    public List<ListaSepia> findByCriteria(String whereCondition);

    public List<ListaSepia> findPageListaSepia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberListaSepia();

    public List<ListaSepia> findByIdListaSepia(Object idListaSepia);
}
