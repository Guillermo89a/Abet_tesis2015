package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.OutcomePorCurso;
import co.edu.usbcali.abet.dto.OutcomePorCursoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IOutcomePorCursoLogic {
    public List<OutcomePorCurso> getOutcomePorCurso() throws Exception;

    /**
         * Save an new OutcomePorCurso entity
         */
    public void saveOutcomePorCurso(String detalle, Long idOutcomePorCurso,
        Long idCurso_Curso, Long idOutcome_Outcome) throws Exception;

    /**
         * Delete an existing OutcomePorCurso entity
         *
         */
    public void deleteOutcomePorCurso(Long idOutcomePorCurso)
        throws Exception;

    /**
        * Update an existing OutcomePorCurso entity
        *
        */
    public void updateOutcomePorCurso(String detalle, Long idOutcomePorCurso,
        Long idCurso_Curso, Long idOutcome_Outcome) throws Exception;

    /**
         * Load an existing OutcomePorCurso entity
         *
         */
    public OutcomePorCurso getOutcomePorCurso(Long idOutcomePorCurso)
        throws Exception;

    public List<OutcomePorCurso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<OutcomePorCurso> findPageOutcomePorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberOutcomePorCurso() throws Exception;

    public List<OutcomePorCursoDTO> getDataOutcomePorCurso()
        throws Exception;
}
