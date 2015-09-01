package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.OutcomePorPrograma;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class OutcomePorProgramaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idOutcomePorPrograma;
    private Long idOutcome_Outcome;
    private Long idPrograma_Programa;

    public Long getIdOutcomePorPrograma() {
        return idOutcomePorPrograma;
    }

    public void setIdOutcomePorPrograma(Long idOutcomePorPrograma) {
        this.idOutcomePorPrograma = idOutcomePorPrograma;
    }

    public Long getIdOutcome_Outcome() {
        return idOutcome_Outcome;
    }

    public void setIdOutcome_Outcome(Long idOutcome_Outcome) {
        this.idOutcome_Outcome = idOutcome_Outcome;
    }

    public Long getIdPrograma_Programa() {
        return idPrograma_Programa;
    }

    public void setIdPrograma_Programa(Long idPrograma_Programa) {
        this.idPrograma_Programa = idPrograma_Programa;
    }
}
