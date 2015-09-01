package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.abet.PeriodoAcademico;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for PeriodoAcademicoDAO.
*
*/
public interface IPeriodoAcademicoDAO {
    // property constants
    //public static final String  DESCRIPCIONPERIODO = "descripcionPeriodo";
    public static final String DESCRIPCIONPERIODO = "descripcionPeriodo";

    //public static final Long  IDPERIODOACADEMICO = "idPeriodoAcademico";
    public static final String IDPERIODOACADEMICO = "idPeriodoAcademico";

    public void save(PeriodoAcademico instance);

    public void delete(PeriodoAcademico instance);

    public void update(PeriodoAcademico instance);

    public PeriodoAcademico findById(Long id);

    public List<PeriodoAcademico> findByExample(PeriodoAcademico instance);

    public List<PeriodoAcademico> findByProperty(String propertyName,
        Object value);

    public List<PeriodoAcademico> findAll();

    public List<PeriodoAcademico> findByCriteria(String whereCondition);

    public List<PeriodoAcademico> findPagePeriodoAcademico(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults);

    public Long findTotalNumberPeriodoAcademico();

    public List<PeriodoAcademico> findByDescripcionPeriodo(
        Object descripcionPeriodo);

    public List<PeriodoAcademico> findByIdPeriodoAcademico(
        Object idPeriodoAcademico);
}
