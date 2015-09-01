package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.PeriodoAcademico;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class PeriodoAcademicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descripcionPeriodo;
    private Long idPeriodoAcademico;

    public String getDescripcionPeriodo() {
        return descripcionPeriodo;
    }

    public void setDescripcionPeriodo(String descripcionPeriodo) {
        this.descripcionPeriodo = descripcionPeriodo;
    }

    public Long getIdPeriodoAcademico() {
        return idPeriodoAcademico;
    }

    public void setIdPeriodoAcademico(Long idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }
}
