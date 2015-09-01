package co.edu.usbcali.abet;
// Generated 31/08/2015 10:03:06 PM by Zathura powered by Hibernate Tools 3.2.4.GA


import java.util.HashSet;
import java.util.Set;

/**
 * ListaSepia generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class ListaSepia  implements java.io.Serializable {


     private Long idListaSepia;
     private Curso curso;
     private Estudiante estudiante;
     private Set<Assesment> assesments = new HashSet<Assesment>(0);

    public ListaSepia() {
    }

	
    public ListaSepia(Long idListaSepia) {
        this.idListaSepia = idListaSepia;
    }
    public ListaSepia(Long idListaSepia, Curso curso, Estudiante estudiante, Set<Assesment> assesments) {
       this.idListaSepia = idListaSepia;
       this.curso = curso;
       this.estudiante = estudiante;
       this.assesments = assesments;
    }
   
    public Long getIdListaSepia() {
        return this.idListaSepia;
    }
    
    public void setIdListaSepia(Long idListaSepia) {
        this.idListaSepia = idListaSepia;
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
    public Set<Assesment> getAssesments() {
        return this.assesments;
    }
    
    public void setAssesments(Set<Assesment> assesments) {
        this.assesments = assesments;
    }




}


