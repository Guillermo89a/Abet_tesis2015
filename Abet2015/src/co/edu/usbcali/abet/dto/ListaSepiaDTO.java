package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.ListaSepia;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class ListaSepiaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idListaSepia;
    private Long idCurso_Curso;
    private Long idCodigoEstudiante_Estudiante;

    public Long getIdListaSepia() {
        return idListaSepia;
    }

    public void setIdListaSepia(Long idListaSepia) {
        this.idListaSepia = idListaSepia;
    }

    public Long getIdCurso_Curso() {
        return idCurso_Curso;
    }

    public void setIdCurso_Curso(Long idCurso_Curso) {
        this.idCurso_Curso = idCurso_Curso;
    }

    public Long getIdCodigoEstudiante_Estudiante() {
        return idCodigoEstudiante_Estudiante;
    }

    public void setIdCodigoEstudiante_Estudiante(
        Long idCodigoEstudiante_Estudiante) {
        this.idCodigoEstudiante_Estudiante = idCodigoEstudiante_Estudiante;
    }
}
