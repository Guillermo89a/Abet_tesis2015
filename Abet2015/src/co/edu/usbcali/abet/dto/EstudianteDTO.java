package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Estudiante;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class EstudianteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String direccion;
    private String email;
    private Long idCodigoEstudiante;
    private String nombre;
    private String telefono;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdCodigoEstudiante() {
        return idCodigoEstudiante;
    }

    public void setIdCodigoEstudiante(Long idCodigoEstudiante) {
        this.idCodigoEstudiante = idCodigoEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
