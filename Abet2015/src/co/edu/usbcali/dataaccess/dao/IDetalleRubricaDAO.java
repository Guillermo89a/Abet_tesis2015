package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.DetalleRubrica;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for DetalleRubricaDAO.
*
*/
public interface IDetalleRubricaDAO {
    // property constants
    //public static final Long  IDDETALLERUBRICA = "idDetalleRubrica";
    public static final String IDDETALLERUBRICA = "idDetalleRubrica";

    public void save(DetalleRubrica instance);

    public void delete(DetalleRubrica instance);

    public void update(DetalleRubrica instance);

    public DetalleRubrica findById(Long id);

    public List<DetalleRubrica> findByExample(DetalleRubrica instance);

    public List<DetalleRubrica> findByProperty(String propertyName, Object value);

    public List<DetalleRubrica> findAll();

    public List<DetalleRubrica> findByCriteria(String whereCondition);

    public List<DetalleRubrica> findPageDetalleRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberDetalleRubrica();

    public List<DetalleRubrica> findByIdDetalleRubrica(Object idDetalleRubrica);
}
