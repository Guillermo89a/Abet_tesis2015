package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.DetalleRubrica;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class DetalleRubricaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idDetalleRubrica;
    private Long idRubrica_Rubrica;

    public Long getIdDetalleRubrica() {
        return idDetalleRubrica;
    }

    public void setIdDetalleRubrica(Long idDetalleRubrica) {
        this.idDetalleRubrica = idDetalleRubrica;
    }

    public Long getIdRubrica_Rubrica() {
        return idRubrica_Rubrica;
    }

    public void setIdRubrica_Rubrica(Long idRubrica_Rubrica) {
        this.idRubrica_Rubrica = idRubrica_Rubrica;
    }
}
