package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Programa;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class ProgramaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descripcion;
    private Long idPrograma;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }
}
