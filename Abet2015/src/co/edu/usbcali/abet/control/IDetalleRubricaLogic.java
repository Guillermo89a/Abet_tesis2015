package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.DetalleRubrica;
import co.edu.usbcali.abet.dto.DetalleRubricaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IDetalleRubricaLogic {
    public List<DetalleRubrica> getDetalleRubrica() throws Exception;

    /**
         * Save an new DetalleRubrica entity
         */
    public void saveDetalleRubrica(Long idDetalleRubrica, Long idRubrica_Rubrica)
        throws Exception;

    /**
         * Delete an existing DetalleRubrica entity
         *
         */
    public void deleteDetalleRubrica(Long idDetalleRubrica)
        throws Exception;

    /**
        * Update an existing DetalleRubrica entity
        *
        */
    public void updateDetalleRubrica(Long idDetalleRubrica,
        Long idRubrica_Rubrica) throws Exception;

    /**
         * Load an existing DetalleRubrica entity
         *
         */
    public DetalleRubrica getDetalleRubrica(Long idDetalleRubrica)
        throws Exception;

    public List<DetalleRubrica> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DetalleRubrica> findPageDetalleRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDetalleRubrica() throws Exception;

    public List<DetalleRubricaDTO> getDataDetalleRubrica()
        throws Exception;
}
