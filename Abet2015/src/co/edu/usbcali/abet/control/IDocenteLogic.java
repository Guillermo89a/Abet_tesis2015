package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Docente;
import co.edu.usbcali.abet.dto.DocenteDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IDocenteLogic {
    public List<Docente> getDocente() throws Exception;

    /**
         * Save an new Docente entity
         */
    public void saveDocente(Long idCodigoDocente, String nombreDocente)
        throws Exception;

    /**
         * Delete an existing Docente entity
         *
         */
    public void deleteDocente(Long idCodigoDocente) throws Exception;

    /**
        * Update an existing Docente entity
        *
        */
    public void updateDocente(Long idCodigoDocente, String nombreDocente)
        throws Exception;

    /**
         * Load an existing Docente entity
         *
         */
    public Docente getDocente(Long idCodigoDocente) throws Exception;

    public List<Docente> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Docente> findPageDocente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDocente() throws Exception;

    public List<DocenteDTO> getDataDocente() throws Exception;
}
