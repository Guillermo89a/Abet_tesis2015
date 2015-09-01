package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.RubricaPorCurso;
import co.edu.usbcali.abet.dto.RubricaPorCursoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IRubricaPorCursoLogic {
    public List<RubricaPorCurso> getRubricaPorCurso() throws Exception;

    /**
         * Save an new RubricaPorCurso entity
         */
    public void saveRubricaPorCurso(Long idRubricaPorCurso, Long idCurso_Curso,
        Long idOutcomePorPrograma_OutcomePorPrograma, Long idRubrica_Rubrica)
        throws Exception;

    /**
         * Delete an existing RubricaPorCurso entity
         *
         */
    public void deleteRubricaPorCurso(Long idRubricaPorCurso)
        throws Exception;

    /**
        * Update an existing RubricaPorCurso entity
        *
        */
    public void updateRubricaPorCurso(Long idRubricaPorCurso,
        Long idCurso_Curso, Long idOutcomePorPrograma_OutcomePorPrograma,
        Long idRubrica_Rubrica) throws Exception;

    /**
         * Load an existing RubricaPorCurso entity
         *
         */
    public RubricaPorCurso getRubricaPorCurso(Long idRubricaPorCurso)
        throws Exception;

    public List<RubricaPorCurso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<RubricaPorCurso> findPageRubricaPorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRubricaPorCurso() throws Exception;

    public List<RubricaPorCursoDTO> getDataRubricaPorCurso()
        throws Exception;
}
