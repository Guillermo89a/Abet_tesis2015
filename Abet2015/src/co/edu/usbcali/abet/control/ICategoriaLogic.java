package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Categoria;
import co.edu.usbcali.abet.dto.CategoriaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface ICategoriaLogic {
    public List<Categoria> getCategoria() throws Exception;

    /**
         * Save an new Categoria entity
         */
    public void saveCategoria(Long idCategoria, String nombrecategoria,
        Long idRubrica_Rubrica) throws Exception;

    /**
         * Delete an existing Categoria entity
         *
         */
    public void deleteCategoria(Long idCategoria) throws Exception;

    /**
        * Update an existing Categoria entity
        *
        */
    public void updateCategoria(Long idCategoria, String nombrecategoria,
        Long idRubrica_Rubrica) throws Exception;

    /**
         * Load an existing Categoria entity
         *
         */
    public Categoria getCategoria(Long idCategoria) throws Exception;

    public List<Categoria> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCategoria() throws Exception;

    public List<CategoriaDTO> getDataCategoria() throws Exception;
}
