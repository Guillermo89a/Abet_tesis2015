package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Pensum;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class PensumDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String creditos;
    private Long idPensum;
    private String semestre;
    private Long idCodigoMateria_Materia;
    private Long idPrograma_Programa;

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public Long getIdPensum() {
        return idPensum;
    }

    public void setIdPensum(Long idPensum) {
        this.idPensum = idPensum;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Long getIdCodigoMateria_Materia() {
        return idCodigoMateria_Materia;
    }

    public void setIdCodigoMateria_Materia(Long idCodigoMateria_Materia) {
        this.idCodigoMateria_Materia = idCodigoMateria_Materia;
    }

    public Long getIdPrograma_Programa() {
        return idPrograma_Programa;
    }

    public void setIdPrograma_Programa(Long idPrograma_Programa) {
        this.idPrograma_Programa = idPrograma_Programa;
    }
}
