package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Materia;
import co.edu.usbcali.abet.dto.MateriaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IMateriaLogic {
    public List<Materia> getMateria() throws Exception;

    /**
         * Save an new Materia entity
         */
    public void saveMateria(String creditos, Long idCodigoMateria, String nombre)
        throws Exception;

    /**
         * Delete an existing Materia entity
         *
         */
    public void deleteMateria(Long idCodigoMateria) throws Exception;

    /**
        * Update an existing Materia entity
        *
        */
    public void updateMateria(String creditos, Long idCodigoMateria,
        String nombre) throws Exception;

    /**
         * Load an existing Materia entity
         *
         */
    public Materia getMateria(Long idCodigoMateria) throws Exception;

    public List<Materia> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Materia> findPageMateria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMateria() throws Exception;

    public List<MateriaDTO> getDataMateria() throws Exception;
}
