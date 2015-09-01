package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.RubricaPorCurso;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class RubricaPorCursoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idRubricaPorCurso;
    private Long idCurso_Curso;
    private Long idOutcomePorPrograma_OutcomePorPrograma;
    private Long idRubrica_Rubrica;

    public Long getIdRubricaPorCurso() {
        return idRubricaPorCurso;
    }

    public void setIdRubricaPorCurso(Long idRubricaPorCurso) {
        this.idRubricaPorCurso = idRubricaPorCurso;
    }

    public Long getIdCurso_Curso() {
        return idCurso_Curso;
    }

    public void setIdCurso_Curso(Long idCurso_Curso) {
        this.idCurso_Curso = idCurso_Curso;
    }

    public Long getIdOutcomePorPrograma_OutcomePorPrograma() {
        return idOutcomePorPrograma_OutcomePorPrograma;
    }

    public void setIdOutcomePorPrograma_OutcomePorPrograma(
        Long idOutcomePorPrograma_OutcomePorPrograma) {
        this.idOutcomePorPrograma_OutcomePorPrograma = idOutcomePorPrograma_OutcomePorPrograma;
    }

    public Long getIdRubrica_Rubrica() {
        return idRubrica_Rubrica;
    }

    public void setIdRubrica_Rubrica(Long idRubrica_Rubrica) {
        this.idRubrica_Rubrica = idRubrica_Rubrica;
    }
}
