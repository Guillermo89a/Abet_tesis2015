package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.ListaSepia;
import co.edu.usbcali.abet.dto.ListaSepiaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IListaSepiaLogic {
    public List<ListaSepia> getListaSepia() throws Exception;

    /**
         * Save an new ListaSepia entity
         */
    public void saveListaSepia(Long idListaSepia, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante) throws Exception;

    /**
         * Delete an existing ListaSepia entity
         *
         */
    public void deleteListaSepia(Long idListaSepia) throws Exception;

    /**
        * Update an existing ListaSepia entity
        *
        */
    public void updateListaSepia(Long idListaSepia, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante) throws Exception;

    /**
         * Load an existing ListaSepia entity
         *
         */
    public ListaSepia getListaSepia(Long idListaSepia)
        throws Exception;

    public List<ListaSepia> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ListaSepia> findPageListaSepia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberListaSepia() throws Exception;

    public List<ListaSepiaDTO> getDataListaSepia() throws Exception;
}
