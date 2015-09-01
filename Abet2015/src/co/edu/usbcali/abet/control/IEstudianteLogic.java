package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Estudiante;
import co.edu.usbcali.abet.dto.EstudianteDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IEstudianteLogic {
    public List<Estudiante> getEstudiante() throws Exception;

    /**
         * Save an new Estudiante entity
         */
    public void saveEstudiante(String direccion, String email,
        Long idCodigoEstudiante, String nombre, String telefono)
        throws Exception;

    /**
         * Delete an existing Estudiante entity
         *
         */
    public void deleteEstudiante(Long idCodigoEstudiante)
        throws Exception;

    /**
        * Update an existing Estudiante entity
        *
        */
    public void updateEstudiante(String direccion, String email,
        Long idCodigoEstudiante, String nombre, String telefono)
        throws Exception;

    /**
         * Load an existing Estudiante entity
         *
         */
    public Estudiante getEstudiante(Long idCodigoEstudiante)
        throws Exception;

    public List<Estudiante> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Estudiante> findPageEstudiante(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstudiante() throws Exception;

    public List<EstudianteDTO> getDataEstudiante() throws Exception;
}
