package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.Curso;
import co.edu.usbcali.abet.dto.CursoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface ICursoLogic {
    public List<Curso> getCurso() throws Exception;

    /**
         * Save an new Curso entity
         */
    public void saveCurso(Long idCurso, String nombreCurso,
        Long idCodigoDocente_Docente, Long idCodigoMateria_Materia,
        Long idPeriodoAcademico_PeriodoAcademico) throws Exception;

    /**
         * Delete an existing Curso entity
         *
         */
    public void deleteCurso(Long idCurso) throws Exception;

    /**
        * Update an existing Curso entity
        *
        */
    public void updateCurso(Long idCurso, String nombreCurso,
        Long idCodigoDocente_Docente, Long idCodigoMateria_Materia,
        Long idPeriodoAcademico_PeriodoAcademico) throws Exception;

    /**
         * Load an existing Curso entity
         *
         */
    public Curso getCurso(Long idCurso) throws Exception;

    public List<Curso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Curso> findPageCurso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCurso() throws Exception;

    public List<CursoDTO> getDataCurso() throws Exception;
}
