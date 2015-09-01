package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Assesment;
import co.edu.usbcali.abet.dto.AssesmentDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IAssesmentLogic {
    public List<Assesment> getAssesment() throws Exception;

    /**
         * Save an new Assesment entity
         */
    public void saveAssesment(Long calificacion, Long idCodigoAssesment,
        Long idListaSepia_ListaSepia, Long idRubricaPorCurso_RubricaPorCurso)
        throws Exception;

    /**
         * Delete an existing Assesment entity
         *
         */
    public void deleteAssesment(Long idCodigoAssesment)
        throws Exception;

    /**
        * Update an existing Assesment entity
        *
        */
    public void updateAssesment(Long calificacion, Long idCodigoAssesment,
        Long idListaSepia_ListaSepia, Long idRubricaPorCurso_RubricaPorCurso)
        throws Exception;

    /**
         * Load an existing Assesment entity
         *
         */
    public Assesment getAssesment(Long idCodigoAssesment)
        throws Exception;

    public List<Assesment> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Assesment> findPageAssesment(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAssesment() throws Exception;

    public List<AssesmentDTO> getDataAssesment() throws Exception;
}
