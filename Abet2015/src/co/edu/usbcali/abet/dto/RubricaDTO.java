package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Rubrica;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class RubricaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idRubrica;
    private String nombreRubrica;

    public Long getIdRubrica() {
        return idRubrica;
    }

    public void setIdRubrica(Long idRubrica) {
        this.idRubrica = idRubrica;
    }

    public String getNombreRubrica() {
        return nombreRubrica;
    }

    public void setNombreRubrica(String nombreRubrica) {
        this.nombreRubrica = nombreRubrica;
    }
}
