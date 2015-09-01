package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Categoria;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idCategoria;
    private String nombrecategoria;
    private Long idRubrica_Rubrica;

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    public Long getIdRubrica_Rubrica() {
        return idRubrica_Rubrica;
    }

    public void setIdRubrica_Rubrica(Long idRubrica_Rubrica) {
        this.idRubrica_Rubrica = idRubrica_Rubrica;
    }
}
