package co.edu.usbcali.abet.dto;

import co.edu.usbcali.abet.Evaluacion;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class EvaluacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idEvaluacion;
    private Long idCurso_Curso;
    private Long idCodigoEstudiante_Estudiante;
    private Long idOutcome_Outcome;

    public Long getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Long getIdCurso_Curso() {
        return idCurso_Curso;
    }

    public void setIdCurso_Curso(Long idCurso_Curso) {
        this.idCurso_Curso = idCurso_Curso;
    }

    public Long getIdCodigoEstudiante_Estudiante() {
        return idCodigoEstudiante_Estudiante;
    }

    public void setIdCodigoEstudiante_Estudiante(
        Long idCodigoEstudiante_Estudiante) {
        this.idCodigoEstudiante_Estudiante = idCodigoEstudiante_Estudiante;
    }

    public Long getIdOutcome_Outcome() {
        return idOutcome_Outcome;
    }

    public void setIdOutcome_Outcome(Long idOutcome_Outcome) {
        this.idOutcome_Outcome = idOutcome_Outcome;
    }
}
