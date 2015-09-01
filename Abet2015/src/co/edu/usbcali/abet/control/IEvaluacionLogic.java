package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Evaluacion;
import co.edu.usbcali.abet.dto.EvaluacionDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IEvaluacionLogic {
    public List<Evaluacion> getEvaluacion() throws Exception;

    /**
         * Save an new Evaluacion entity
         */
    public void saveEvaluacion(Long idEvaluacion, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante, Long idOutcome_Outcome)
        throws Exception;

    /**
         * Delete an existing Evaluacion entity
         *
         */
    public void deleteEvaluacion(Long idEvaluacion) throws Exception;

    /**
        * Update an existing Evaluacion entity
        *
        */
    public void updateEvaluacion(Long idEvaluacion, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante, Long idOutcome_Outcome)
        throws Exception;

    /**
         * Load an existing Evaluacion entity
         *
         */
    public Evaluacion getEvaluacion(Long idEvaluacion)
        throws Exception;

    public List<Evaluacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Evaluacion> findPageEvaluacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEvaluacion() throws Exception;

    public List<EvaluacionDTO> getDataEvaluacion() throws Exception;
}
