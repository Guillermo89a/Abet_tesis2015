package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Pensum;
import co.edu.usbcali.abet.dto.PensumDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IPensumLogic {
    public List<Pensum> getPensum() throws Exception;

    /**
         * Save an new Pensum entity
         */
    public void savePensum(String creditos, Long idPensum, String semestre,
        Long idCodigoMateria_Materia, Long idPrograma_Programa)
        throws Exception;

    /**
         * Delete an existing Pensum entity
         *
         */
    public void deletePensum(Long idPensum) throws Exception;

    /**
        * Update an existing Pensum entity
        *
        */
    public void updatePensum(String creditos, Long idPensum, String semestre,
        Long idCodigoMateria_Materia, Long idPrograma_Programa)
        throws Exception;

    /**
         * Load an existing Pensum entity
         *
         */
    public Pensum getPensum(Long idPensum) throws Exception;

    public List<Pensum> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Pensum> findPagePensum(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPensum() throws Exception;

    public List<PensumDTO> getDataPensum() throws Exception;
}
