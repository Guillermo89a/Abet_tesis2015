package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Curso;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class CursoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idCurso;
    private String nombreCurso;
    private Long idCodigoDocente_Docente;
    private Long idCodigoMateria_Materia;
    private Long idPeriodoAcademico_PeriodoAcademico;

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Long getIdCodigoDocente_Docente() {
        return idCodigoDocente_Docente;
    }

    public void setIdCodigoDocente_Docente(Long idCodigoDocente_Docente) {
        this.idCodigoDocente_Docente = idCodigoDocente_Docente;
    }

    public Long getIdCodigoMateria_Materia() {
        return idCodigoMateria_Materia;
    }

    public void setIdCodigoMateria_Materia(Long idCodigoMateria_Materia) {
        this.idCodigoMateria_Materia = idCodigoMateria_Materia;
    }

    public Long getIdPeriodoAcademico_PeriodoAcademico() {
        return idPeriodoAcademico_PeriodoAcademico;
    }

    public void setIdPeriodoAcademico_PeriodoAcademico(
        Long idPeriodoAcademico_PeriodoAcademico) {
        this.idPeriodoAcademico_PeriodoAcademico = idPeriodoAcademico_PeriodoAcademico;
    }
}
