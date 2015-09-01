package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.OutcomePorCurso;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class OutcomePorCursoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String detalle;
    private Long idOutcomePorCurso;
    private Long idCurso_Curso;
    private Long idOutcome_Outcome;

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Long getIdOutcomePorCurso() {
        return idOutcomePorCurso;
    }

    public void setIdOutcomePorCurso(Long idOutcomePorCurso) {
        this.idOutcomePorCurso = idOutcomePorCurso;
    }

    public Long getIdCurso_Curso() {
        return idCurso_Curso;
    }

    public void setIdCurso_Curso(Long idCurso_Curso) {
        this.idCurso_Curso = idCurso_Curso;
    }

    public Long getIdOutcome_Outcome() {
        return idOutcome_Outcome;
    }

    public void setIdOutcome_Outcome(Long idOutcome_Outcome) {
        this.idOutcome_Outcome = idOutcome_Outcome;
    }
}
