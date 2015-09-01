package co.edu.usbcali.abet;
// Generated 31/08/2015 10:03:06 PM by Zathura powered by Hibernate Tools 3.2.4.GA


import java.util.HashSet;
import java.util.Set;

/**
 * PeriodoAcademico generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class PeriodoAcademico  implements java.io.Serializable {


     private Long idPeriodoAcademico;
     private String descripcionPeriodo;
     private Set<Curso> cursos = new HashSet<Curso>(0);

    public PeriodoAcademico() {
    }

	
    public PeriodoAcademico(Long idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }
    public PeriodoAcademico(Long idPeriodoAcademico, String descripcionPeriodo, Set<Curso> cursos) {
       this.idPeriodoAcademico = idPeriodoAcademico;
       this.descripcionPeriodo = descripcionPeriodo;
       this.cursos = cursos;
    }
   
    public Long getIdPeriodoAcademico() {
        return this.idPeriodoAcademico;
    }
    
    public void setIdPeriodoAcademico(Long idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }
    public String getDescripcionPeriodo() {
        return this.descripcionPeriodo;
    }
    
    public void setDescripcionPeriodo(String descripcionPeriodo) {
        this.descripcionPeriodo = descripcionPeriodo;
    }
    public Set<Curso> getCursos() {
        return this.cursos;
    }
    
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }




}


