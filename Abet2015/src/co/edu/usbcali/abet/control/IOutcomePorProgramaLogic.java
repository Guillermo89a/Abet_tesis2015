package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.OutcomePorPrograma;
import co.edu.usbcali.abet.dto.OutcomePorProgramaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IOutcomePorProgramaLogic {
    public List<OutcomePorPrograma> getOutcomePorPrograma()
        throws Exception;

    /**
         * Save an new OutcomePorPrograma entity
         */
    public void saveOutcomePorPrograma(Long idOutcomePorPrograma,
        Long idOutcome_Outcome, Long idPrograma_Programa)
        throws Exception;

    /**
         * Delete an existing OutcomePorPrograma entity
         *
         */
    public void deleteOutcomePorPrograma(Long idOutcomePorPrograma)
        throws Exception;

    /**
        * Update an existing OutcomePorPrograma entity
        *
        */
    public void updateOutcomePorPrograma(Long idOutcomePorPrograma,
        Long idOutcome_Outcome, Long idPrograma_Programa)
        throws Exception;

    /**
         * Load an existing OutcomePorPrograma entity
         *
         */
    public OutcomePorPrograma getOutcomePorPrograma(Long idOutcomePorPrograma)
        throws Exception;

    public List<OutcomePorPrograma> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<OutcomePorPrograma> findPageOutcomePorPrograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberOutcomePorPrograma() throws Exception;

    public List<OutcomePorProgramaDTO> getDataOutcomePorPrograma()
        throws Exception;
}
