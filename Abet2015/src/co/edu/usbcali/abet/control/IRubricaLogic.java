package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Rubrica;
import co.edu.usbcali.abet.dto.RubricaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IRubricaLogic {
    public List<Rubrica> getRubrica() throws Exception;

    /**
         * Save an new Rubrica entity
         */
    public void saveRubrica(Long idRubrica, String nombreRubrica)
        throws Exception;

    /**
         * Delete an existing Rubrica entity
         *
         */
    public void deleteRubrica(Long idRubrica) throws Exception;

    /**
        * Update an existing Rubrica entity
        *
        */
    public void updateRubrica(Long idRubrica, String nombreRubrica)
        throws Exception;

    /**
         * Load an existing Rubrica entity
         *
         */
    public Rubrica getRubrica(Long idRubrica) throws Exception;

    public List<Rubrica> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Rubrica> findPageRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRubrica() throws Exception;

    public List<RubricaDTO> getDataRubrica() throws Exception;
}
