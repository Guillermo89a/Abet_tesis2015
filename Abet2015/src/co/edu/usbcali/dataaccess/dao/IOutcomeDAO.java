package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.Outcome;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for OutcomeDAO.
*
*/
public interface IOutcomeDAO {
    // property constants
    //public static final String  DETALLE = "detalle";
    public static final String DETALLE = "detalle";

    //public static final Long  IDOUTCOME = "idOutcome";
    public static final String IDOUTCOME = "idOutcome";

    public void save(Outcome instance);

    public void delete(Outcome instance);

    public void update(Outcome instance);

    public Outcome findById(Long id);

    public List<Outcome> findByExample(Outcome instance);

    public List<Outcome> findByProperty(String propertyName, Object value);

    public List<Outcome> findAll();

    public List<Outcome> findByCriteria(String whereCondition);

    public List<Outcome> findPageOutcome(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberOutcome();

    public List<Outcome> findByDetalle(Object detalle);

    public List<Outcome> findByIdOutcome(Object idOutcome);
}
