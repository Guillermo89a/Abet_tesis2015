package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Docente;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class DocenteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idCodigoDocente;
    private String nombreDocente;

    public Long getIdCodigoDocente() {
        return idCodigoDocente;
    }

    public void setIdCodigoDocente(Long idCodigoDocente) {
        this.idCodigoDocente = idCodigoDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }
}
