package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.PeriodoAcademico;
import co.edu.usbcali.abet.dto.PeriodoAcademicoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IPeriodoAcademicoLogic {
    public List<PeriodoAcademico> getPeriodoAcademico()
        throws Exception;

    /**
         * Save an new PeriodoAcademico entity
         */
    public void savePeriodoAcademico(String descripcionPeriodo,
        Long idPeriodoAcademico) throws Exception;

    /**
         * Delete an existing PeriodoAcademico entity
         *
         */
    public void deletePeriodoAcademico(Long idPeriodoAcademico)
        throws Exception;

    /**
        * Update an existing PeriodoAcademico entity
        *
        */
    public void updatePeriodoAcademico(String descripcionPeriodo,
        Long idPeriodoAcademico) throws Exception;

    /**
         * Load an existing PeriodoAcademico entity
         *
         */
    public PeriodoAcademico getPeriodoAcademico(Long idPeriodoAcademico)
        throws Exception;

    public List<PeriodoAcademico> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PeriodoAcademico> findPagePeriodoAcademico(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPeriodoAcademico() throws Exception;

    public List<PeriodoAcademicoDTO> getDataPeriodoAcademico()
        throws Exception;
}
