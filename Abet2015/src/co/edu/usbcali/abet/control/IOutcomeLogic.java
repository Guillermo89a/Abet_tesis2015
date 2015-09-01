package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Outcome;
import co.edu.usbcali.abet.dto.OutcomeDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IOutcomeLogic {
    public List<Outcome> getOutcome() throws Exception;

    /**
         * Save an new Outcome entity
         */
    public void saveOutcome(String detalle, Long idOutcome)
        throws Exception;

    /**
         * Delete an existing Outcome entity
         *
         */
    public void deleteOutcome(Long idOutcome) throws Exception;

    /**
        * Update an existing Outcome entity
        *
        */
    public void updateOutcome(String detalle, Long idOutcome)
        throws Exception;

    /**
         * Load an existing Outcome entity
         *
         */
    public Outcome getOutcome(Long idOutcome) throws Exception;

    public List<Outcome> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Outcome> findPageOutcome(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberOutcome() throws Exception;

    public List<OutcomeDTO> getDataOutcome() throws Exception;
}
