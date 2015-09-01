package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Programa;
import co.edu.usbcali.abet.dto.ProgramaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IProgramaLogic {
    public List<Programa> getPrograma() throws Exception;

    /**
         * Save an new Programa entity
         */
    public void savePrograma(String descripcion, Long idPrograma)
        throws Exception;

    /**
         * Delete an existing Programa entity
         *
         */
    public void deletePrograma(Long idPrograma) throws Exception;

    /**
        * Update an existing Programa entity
        *
        */
    public void updatePrograma(String descripcion, Long idPrograma)
        throws Exception;

    /**
         * Load an existing Programa entity
         *
         */
    public Programa getPrograma(Long idPrograma) throws Exception;

    public List<Programa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Programa> findPagePrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPrograma() throws Exception;

    public List<ProgramaDTO> getDataPrograma() throws Exception;
}
