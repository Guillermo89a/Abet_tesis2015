package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.OutcomePorPrograma;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for OutcomePorProgramaDAO.
*
*/
public interface IOutcomePorProgramaDAO {
    // property constants
    //public static final Long  IDOUTCOMEPORPROGRAMA = "idOutcomePorPrograma";
    public static final String IDOUTCOMEPORPROGRAMA = "idOutcomePorPrograma";

    public void save(OutcomePorPrograma instance);

    public void delete(OutcomePorPrograma instance);

    public void update(OutcomePorPrograma instance);

    public OutcomePorPrograma findById(Long id);

    public List<OutcomePorPrograma> findByExample(OutcomePorPrograma instance);

    public List<OutcomePorPrograma> findByProperty(String propertyName,
        Object value);

    public List<OutcomePorPrograma> findAll();

    public List<OutcomePorPrograma> findByCriteria(String whereCondition);

    public List<OutcomePorPrograma> findPageOutcomePorPrograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults);

    public Long findTotalNumberOutcomePorPrograma();

    public List<OutcomePorPrograma> findByIdOutcomePorPrograma(
        Object idOutcomePorPrograma);
}
