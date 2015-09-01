package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Outcome;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class OutcomeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String detalle;
    private Long idOutcome;

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Long getIdOutcome() {
        return idOutcome;
    }

    public void setIdOutcome(Long idOutcome) {
        this.idOutcome = idOutcome;
    }
}
