package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Assesment;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class AssesmentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long calificacion;
    private Long idCodigoAssesment;
    private Long idListaSepia_ListaSepia;
    private Long idRubricaPorCurso_RubricaPorCurso;

    public Long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    public Long getIdCodigoAssesment() {
        return idCodigoAssesment;
    }

    public void setIdCodigoAssesment(Long idCodigoAssesment) {
        this.idCodigoAssesment = idCodigoAssesment;
    }

    public Long getIdListaSepia_ListaSepia() {
        return idListaSepia_ListaSepia;
    }

    public void setIdListaSepia_ListaSepia(Long idListaSepia_ListaSepia) {
        this.idListaSepia_ListaSepia = idListaSepia_ListaSepia;
    }

    public Long getIdRubricaPorCurso_RubricaPorCurso() {
        return idRubricaPorCurso_RubricaPorCurso;
    }

    public void setIdRubricaPorCurso_RubricaPorCurso(
        Long idRubricaPorCurso_RubricaPorCurso) {
        this.idRubricaPorCurso_RubricaPorCurso = idRubricaPorCurso_RubricaPorCurso;
    }
}
