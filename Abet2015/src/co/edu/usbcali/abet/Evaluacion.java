package co.edu.usbcali.abet;
// Generated 31/08/2015 10:03:06 PM by Zathura powered by Hibernate Tools 3.2.4.GA



/**
 * Evaluacion generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Evaluacion  implements java.io.Serializable {


     private Long idEvaluacion;
     private Outcome outcome;
     private Curso curso;
     private Estudiante estudiante;

    public Evaluacion() {
    }

	
    public Evaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    public Evaluacion(Long idEvaluacion, Outcome outcome, Curso curso, Estudiante estudiante) {
       this.idEvaluacion = idEvaluacion;
       this.outcome = outcome;
       this.curso = curso;
       this.estudiante = estudiante;
    }
   
    public Long getIdEvaluacion() {
        return this.idEvaluacion;
    }
    
    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    public Outcome getOutcome() {
        return this.outcome;
    }
    
    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Estudiante getEstudiante() {
        return this.estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }




}


