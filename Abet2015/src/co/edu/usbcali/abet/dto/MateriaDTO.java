package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Materia;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class MateriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String creditos;
    private Long idCodigoMateria;
    private String nombre;

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public Long getIdCodigoMateria() {
        return idCodigoMateria;
    }

    public void setIdCodigoMateria(Long idCodigoMateria) {
        this.idCodigoMateria = idCodigoMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
