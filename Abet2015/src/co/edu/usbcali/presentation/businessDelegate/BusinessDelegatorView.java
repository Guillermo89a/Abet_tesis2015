package co.edu.usbcali.presentation.businessDelegate;

import co.edu.usbcali.abet.Assesment;
import co.edu.usbcali.abet.Categoria;
import co.edu.usbcali.abet.Curso;
import co.edu.usbcali.abet.DetalleRubrica;
import co.edu.usbcali.abet.Docente;
import co.edu.usbcali.abet.Estudiante;
import co.edu.usbcali.abet.Evaluacion;
import co.edu.usbcali.abet.ListaSepia;
import co.edu.usbcali.abet.Materia;
import co.edu.usbcali.abet.Outcome;
import co.edu.usbcali.abet.OutcomePorCurso;
import co.edu.usbcali.abet.OutcomePorPrograma;
import co.edu.usbcali.abet.Pensum;
import co.edu.usbcali.abet.PeriodoAcademico;
import co.edu.usbcali.abet.Programa;
import co.edu.usbcali.abet.Rubrica;
import co.edu.usbcali.abet.RubricaPorCurso;
import co.edu.usbcali.abet.control.AssesmentLogic;
import co.edu.usbcali.abet.control.CategoriaLogic;
import co.edu.usbcali.abet.control.CursoLogic;
import co.edu.usbcali.abet.control.DetalleRubricaLogic;
import co.edu.usbcali.abet.control.DocenteLogic;
import co.edu.usbcali.abet.control.EstudianteLogic;
import co.edu.usbcali.abet.control.EvaluacionLogic;
import co.edu.usbcali.abet.control.IAssesmentLogic;
import co.edu.usbcali.abet.control.ICategoriaLogic;
import co.edu.usbcali.abet.control.ICursoLogic;
import co.edu.usbcali.abet.control.IDetalleRubricaLogic;
import co.edu.usbcali.abet.control.IDocenteLogic;
import co.edu.usbcali.abet.control.IEstudianteLogic;
import co.edu.usbcali.abet.control.IEvaluacionLogic;
import co.edu.usbcali.abet.control.IListaSepiaLogic;
import co.edu.usbcali.abet.control.IMateriaLogic;
import co.edu.usbcali.abet.control.IOutcomeLogic;
import co.edu.usbcali.abet.control.IOutcomePorCursoLogic;
import co.edu.usbcali.abet.control.IOutcomePorProgramaLogic;
import co.edu.usbcali.abet.control.IPensumLogic;
import co.edu.usbcali.abet.control.IPeriodoAcademicoLogic;
import co.edu.usbcali.abet.control.IProgramaLogic;
import co.edu.usbcali.abet.control.IRubricaLogic;
import co.edu.usbcali.abet.control.IRubricaPorCursoLogic;
import co.edu.usbcali.abet.control.ListaSepiaLogic;
import co.edu.usbcali.abet.control.MateriaLogic;
import co.edu.usbcali.abet.control.OutcomeLogic;
import co.edu.usbcali.abet.control.OutcomePorCursoLogic;
import co.edu.usbcali.abet.control.OutcomePorProgramaLogic;
import co.edu.usbcali.abet.control.PensumLogic;
import co.edu.usbcali.abet.control.PeriodoAcademicoLogic;
import co.edu.usbcali.abet.control.ProgramaLogic;
import co.edu.usbcali.abet.control.RubricaLogic;
import co.edu.usbcali.abet.control.RubricaPorCursoLogic;
import co.edu.usbcali.abet.dto.AssesmentDTO;
import co.edu.usbcali.abet.dto.CategoriaDTO;
import co.edu.usbcali.abet.dto.CursoDTO;
import co.edu.usbcali.abet.dto.DetalleRubricaDTO;
import co.edu.usbcali.abet.dto.DocenteDTO;
import co.edu.usbcali.abet.dto.EstudianteDTO;
import co.edu.usbcali.abet.dto.EvaluacionDTO;
import co.edu.usbcali.abet.dto.ListaSepiaDTO;
import co.edu.usbcali.abet.dto.MateriaDTO;
import co.edu.usbcali.abet.dto.OutcomeDTO;
import co.edu.usbcali.abet.dto.OutcomePorCursoDTO;
import co.edu.usbcali.abet.dto.OutcomePorProgramaDTO;
import co.edu.usbcali.abet.dto.PensumDTO;
import co.edu.usbcali.abet.dto.PeriodoAcademicoDTO;
import co.edu.usbcali.abet.dto.ProgramaDTO;
import co.edu.usbcali.abet.dto.RubricaDTO;
import co.edu.usbcali.abet.dto.RubricaPorCursoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    @Autowired
    private IAssesmentLogic assesmentLogic;
    @Autowired
    private ICategoriaLogic categoriaLogic;
    @Autowired
    private ICursoLogic cursoLogic;
    @Autowired
    private IDetalleRubricaLogic detalleRubricaLogic;
    @Autowired
    private IDocenteLogic docenteLogic;
    @Autowired
    private IEstudianteLogic estudianteLogic;
    @Autowired
    private IEvaluacionLogic evaluacionLogic;
    @Autowired
    private IListaSepiaLogic listaSepiaLogic;
    @Autowired
    private IMateriaLogic materiaLogic;
    @Autowired
    private IOutcomeLogic outcomeLogic;
    @Autowired
    private IOutcomePorCursoLogic outcomePorCursoLogic;
    @Autowired
    private IOutcomePorProgramaLogic outcomePorProgramaLogic;
    @Autowired
    private IPensumLogic pensumLogic;
    @Autowired
    private IPeriodoAcademicoLogic periodoAcademicoLogic;
    @Autowired
    private IProgramaLogic programaLogic;
    @Autowired
    private IRubricaLogic rubricaLogic;
    @Autowired
    private IRubricaPorCursoLogic rubricaPorCursoLogic;

    public List<Assesment> getAssesment() throws Exception {
        return assesmentLogic.getAssesment();
    }

    public void saveAssesment(Long calificacion, Long idCodigoAssesment,
        Long idListaSepia_ListaSepia, Long idRubricaPorCurso_RubricaPorCurso)
        throws Exception {
        assesmentLogic.saveAssesment(calificacion, idCodigoAssesment,
            idListaSepia_ListaSepia, idRubricaPorCurso_RubricaPorCurso);
    }

    public void deleteAssesment(Long idCodigoAssesment)
        throws Exception {
        assesmentLogic.deleteAssesment(idCodigoAssesment);
    }

    public void updateAssesment(Long calificacion, Long idCodigoAssesment,
        Long idListaSepia_ListaSepia, Long idRubricaPorCurso_RubricaPorCurso)
        throws Exception {
        assesmentLogic.updateAssesment(calificacion, idCodigoAssesment,
            idListaSepia_ListaSepia, idRubricaPorCurso_RubricaPorCurso);
    }

    public Assesment getAssesment(Long idCodigoAssesment)
        throws Exception {
        Assesment assesment = null;

        try {
            assesment = assesmentLogic.getAssesment(idCodigoAssesment);
        } catch (Exception e) {
            throw e;
        }

        return assesment;
    }

    public List<Assesment> findByCriteriaInAssesment(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return assesmentLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Assesment> findPageAssesment(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return assesmentLogic.findPageAssesment(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberAssesment() throws Exception {
        return assesmentLogic.findTotalNumberAssesment();
    }

    public List<AssesmentDTO> getDataAssesment() throws Exception {
        return assesmentLogic.getDataAssesment();
    }

    public List<Categoria> getCategoria() throws Exception {
        return categoriaLogic.getCategoria();
    }

    public void saveCategoria(Long idCategoria, String nombrecategoria,
        Long idRubrica_Rubrica) throws Exception {
        categoriaLogic.saveCategoria(idCategoria, nombrecategoria,
            idRubrica_Rubrica);
    }

    public void deleteCategoria(Long idCategoria) throws Exception {
        categoriaLogic.deleteCategoria(idCategoria);
    }

    public void updateCategoria(Long idCategoria, String nombrecategoria,
        Long idRubrica_Rubrica) throws Exception {
        categoriaLogic.updateCategoria(idCategoria, nombrecategoria,
            idRubrica_Rubrica);
    }

    public Categoria getCategoria(Long idCategoria) throws Exception {
        Categoria categoria = null;

        try {
            categoria = categoriaLogic.getCategoria(idCategoria);
        } catch (Exception e) {
            throw e;
        }

        return categoria;
    }

    public List<Categoria> findByCriteriaInCategoria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return categoriaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return categoriaLogic.findPageCategoria(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCategoria() throws Exception {
        return categoriaLogic.findTotalNumberCategoria();
    }

    public List<CategoriaDTO> getDataCategoria() throws Exception {
        return categoriaLogic.getDataCategoria();
    }

    public List<Curso> getCurso() throws Exception {
        return cursoLogic.getCurso();
    }

    public void saveCurso(Long idCurso, String nombreCurso,
        Long idCodigoDocente_Docente, Long idCodigoMateria_Materia,
        Long idPeriodoAcademico_PeriodoAcademico) throws Exception {
        cursoLogic.saveCurso(idCurso, nombreCurso, idCodigoDocente_Docente,
            idCodigoMateria_Materia, idPeriodoAcademico_PeriodoAcademico);
    }

    public void deleteCurso(Long idCurso) throws Exception {
        cursoLogic.deleteCurso(idCurso);
    }

    public void updateCurso(Long idCurso, String nombreCurso,
        Long idCodigoDocente_Docente, Long idCodigoMateria_Materia,
        Long idPeriodoAcademico_PeriodoAcademico) throws Exception {
        cursoLogic.updateCurso(idCurso, nombreCurso, idCodigoDocente_Docente,
            idCodigoMateria_Materia, idPeriodoAcademico_PeriodoAcademico);
    }

    public Curso getCurso(Long idCurso) throws Exception {
        Curso curso = null;

        try {
            curso = cursoLogic.getCurso(idCurso);
        } catch (Exception e) {
            throw e;
        }

        return curso;
    }

    public List<Curso> findByCriteriaInCurso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return cursoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Curso> findPageCurso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return cursoLogic.findPageCurso(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCurso() throws Exception {
        return cursoLogic.findTotalNumberCurso();
    }

    public List<CursoDTO> getDataCurso() throws Exception {
        return cursoLogic.getDataCurso();
    }

    public List<DetalleRubrica> getDetalleRubrica() throws Exception {
        return detalleRubricaLogic.getDetalleRubrica();
    }

    public void saveDetalleRubrica(Long idDetalleRubrica, Long idRubrica_Rubrica)
        throws Exception {
        detalleRubricaLogic.saveDetalleRubrica(idDetalleRubrica,
            idRubrica_Rubrica);
    }

    public void deleteDetalleRubrica(Long idDetalleRubrica)
        throws Exception {
        detalleRubricaLogic.deleteDetalleRubrica(idDetalleRubrica);
    }

    public void updateDetalleRubrica(Long idDetalleRubrica,
        Long idRubrica_Rubrica) throws Exception {
        detalleRubricaLogic.updateDetalleRubrica(idDetalleRubrica,
            idRubrica_Rubrica);
    }

    public DetalleRubrica getDetalleRubrica(Long idDetalleRubrica)
        throws Exception {
        DetalleRubrica detalleRubrica = null;

        try {
            detalleRubrica = detalleRubricaLogic.getDetalleRubrica(idDetalleRubrica);
        } catch (Exception e) {
            throw e;
        }

        return detalleRubrica;
    }

    public List<DetalleRubrica> findByCriteriaInDetalleRubrica(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return detalleRubricaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<DetalleRubrica> findPageDetalleRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return detalleRubricaLogic.findPageDetalleRubrica(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberDetalleRubrica() throws Exception {
        return detalleRubricaLogic.findTotalNumberDetalleRubrica();
    }

    public List<DetalleRubricaDTO> getDataDetalleRubrica()
        throws Exception {
        return detalleRubricaLogic.getDataDetalleRubrica();
    }

    public List<Docente> getDocente() throws Exception {
        return docenteLogic.getDocente();
    }

    public void saveDocente(Long idCodigoDocente, String nombreDocente)
        throws Exception {
        docenteLogic.saveDocente(idCodigoDocente, nombreDocente);
    }

    public void deleteDocente(Long idCodigoDocente) throws Exception {
        docenteLogic.deleteDocente(idCodigoDocente);
    }

    public void updateDocente(Long idCodigoDocente, String nombreDocente)
        throws Exception {
        docenteLogic.updateDocente(idCodigoDocente, nombreDocente);
    }

    public Docente getDocente(Long idCodigoDocente) throws Exception {
        Docente docente = null;

        try {
            docente = docenteLogic.getDocente(idCodigoDocente);
        } catch (Exception e) {
            throw e;
        }

        return docente;
    }

    public List<Docente> findByCriteriaInDocente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return docenteLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Docente> findPageDocente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return docenteLogic.findPageDocente(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberDocente() throws Exception {
        return docenteLogic.findTotalNumberDocente();
    }

    public List<DocenteDTO> getDataDocente() throws Exception {
        return docenteLogic.getDataDocente();
    }

    public List<Estudiante> getEstudiante() throws Exception {
        return estudianteLogic.getEstudiante();
    }

    public void saveEstudiante(String direccion, String email,
        Long idCodigoEstudiante, String nombre, String telefono)
        throws Exception {
        estudianteLogic.saveEstudiante(direccion, email, idCodigoEstudiante,
            nombre, telefono);
    }

    public void deleteEstudiante(Long idCodigoEstudiante)
        throws Exception {
        estudianteLogic.deleteEstudiante(idCodigoEstudiante);
    }

    public void updateEstudiante(String direccion, String email,
        Long idCodigoEstudiante, String nombre, String telefono)
        throws Exception {
        estudianteLogic.updateEstudiante(direccion, email, idCodigoEstudiante,
            nombre, telefono);
    }

    public Estudiante getEstudiante(Long idCodigoEstudiante)
        throws Exception {
        Estudiante estudiante = null;

        try {
            estudiante = estudianteLogic.getEstudiante(idCodigoEstudiante);
        } catch (Exception e) {
            throw e;
        }

        return estudiante;
    }

    public List<Estudiante> findByCriteriaInEstudiante(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return estudianteLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Estudiante> findPageEstudiante(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return estudianteLogic.findPageEstudiante(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberEstudiante() throws Exception {
        return estudianteLogic.findTotalNumberEstudiante();
    }

    public List<EstudianteDTO> getDataEstudiante() throws Exception {
        return estudianteLogic.getDataEstudiante();
    }

    public List<Evaluacion> getEvaluacion() throws Exception {
        return evaluacionLogic.getEvaluacion();
    }

    public void saveEvaluacion(Long idEvaluacion, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante, Long idOutcome_Outcome)
        throws Exception {
        evaluacionLogic.saveEvaluacion(idEvaluacion, idCurso_Curso,
            idCodigoEstudiante_Estudiante, idOutcome_Outcome);
    }

    public void deleteEvaluacion(Long idEvaluacion) throws Exception {
        evaluacionLogic.deleteEvaluacion(idEvaluacion);
    }

    public void updateEvaluacion(Long idEvaluacion, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante, Long idOutcome_Outcome)
        throws Exception {
        evaluacionLogic.updateEvaluacion(idEvaluacion, idCurso_Curso,
            idCodigoEstudiante_Estudiante, idOutcome_Outcome);
    }

    public Evaluacion getEvaluacion(Long idEvaluacion)
        throws Exception {
        Evaluacion evaluacion = null;

        try {
            evaluacion = evaluacionLogic.getEvaluacion(idEvaluacion);
        } catch (Exception e) {
            throw e;
        }

        return evaluacion;
    }

    public List<Evaluacion> findByCriteriaInEvaluacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return evaluacionLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Evaluacion> findPageEvaluacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return evaluacionLogic.findPageEvaluacion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberEvaluacion() throws Exception {
        return evaluacionLogic.findTotalNumberEvaluacion();
    }

    public List<EvaluacionDTO> getDataEvaluacion() throws Exception {
        return evaluacionLogic.getDataEvaluacion();
    }

    public List<ListaSepia> getListaSepia() throws Exception {
        return listaSepiaLogic.getListaSepia();
    }

    public void saveListaSepia(Long idListaSepia, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante) throws Exception {
        listaSepiaLogic.saveListaSepia(idListaSepia, idCurso_Curso,
            idCodigoEstudiante_Estudiante);
    }

    public void deleteListaSepia(Long idListaSepia) throws Exception {
        listaSepiaLogic.deleteListaSepia(idListaSepia);
    }

    public void updateListaSepia(Long idListaSepia, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante) throws Exception {
        listaSepiaLogic.updateListaSepia(idListaSepia, idCurso_Curso,
            idCodigoEstudiante_Estudiante);
    }

    public ListaSepia getListaSepia(Long idListaSepia)
        throws Exception {
        ListaSepia listaSepia = null;

        try {
            listaSepia = listaSepiaLogic.getListaSepia(idListaSepia);
        } catch (Exception e) {
            throw e;
        }

        return listaSepia;
    }

    public List<ListaSepia> findByCriteriaInListaSepia(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return listaSepiaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<ListaSepia> findPageListaSepia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return listaSepiaLogic.findPageListaSepia(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberListaSepia() throws Exception {
        return listaSepiaLogic.findTotalNumberListaSepia();
    }

    public List<ListaSepiaDTO> getDataListaSepia() throws Exception {
        return listaSepiaLogic.getDataListaSepia();
    }

    public List<Materia> getMateria() throws Exception {
        return materiaLogic.getMateria();
    }

    public void saveMateria(String creditos, Long idCodigoMateria, String nombre)
        throws Exception {
        materiaLogic.saveMateria(creditos, idCodigoMateria, nombre);
    }

    public void deleteMateria(Long idCodigoMateria) throws Exception {
        materiaLogic.deleteMateria(idCodigoMateria);
    }

    public void updateMateria(String creditos, Long idCodigoMateria,
        String nombre) throws Exception {
        materiaLogic.updateMateria(creditos, idCodigoMateria, nombre);
    }

    public Materia getMateria(Long idCodigoMateria) throws Exception {
        Materia materia = null;

        try {
            materia = materiaLogic.getMateria(idCodigoMateria);
        } catch (Exception e) {
            throw e;
        }

        return materia;
    }

    public List<Materia> findByCriteriaInMateria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return materiaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Materia> findPageMateria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return materiaLogic.findPageMateria(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberMateria() throws Exception {
        return materiaLogic.findTotalNumberMateria();
    }

    public List<MateriaDTO> getDataMateria() throws Exception {
        return materiaLogic.getDataMateria();
    }

    public List<Outcome> getOutcome() throws Exception {
        return outcomeLogic.getOutcome();
    }

    public void saveOutcome(String detalle, Long idOutcome)
        throws Exception {
        outcomeLogic.saveOutcome(detalle, idOutcome);
    }

    public void deleteOutcome(Long idOutcome) throws Exception {
        outcomeLogic.deleteOutcome(idOutcome);
    }

    public void updateOutcome(String detalle, Long idOutcome)
        throws Exception {
        outcomeLogic.updateOutcome(detalle, idOutcome);
    }

    public Outcome getOutcome(Long idOutcome) throws Exception {
        Outcome outcome = null;

        try {
            outcome = outcomeLogic.getOutcome(idOutcome);
        } catch (Exception e) {
            throw e;
        }

        return outcome;
    }

    public List<Outcome> findByCriteriaInOutcome(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return outcomeLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Outcome> findPageOutcome(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return outcomeLogic.findPageOutcome(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberOutcome() throws Exception {
        return outcomeLogic.findTotalNumberOutcome();
    }

    public List<OutcomeDTO> getDataOutcome() throws Exception {
        return outcomeLogic.getDataOutcome();
    }

    public List<OutcomePorCurso> getOutcomePorCurso() throws Exception {
        return outcomePorCursoLogic.getOutcomePorCurso();
    }

    public void saveOutcomePorCurso(String detalle, Long idOutcomePorCurso,
        Long idCurso_Curso, Long idOutcome_Outcome) throws Exception {
        outcomePorCursoLogic.saveOutcomePorCurso(detalle, idOutcomePorCurso,
            idCurso_Curso, idOutcome_Outcome);
    }

    public void deleteOutcomePorCurso(Long idOutcomePorCurso)
        throws Exception {
        outcomePorCursoLogic.deleteOutcomePorCurso(idOutcomePorCurso);
    }

    public void updateOutcomePorCurso(String detalle, Long idOutcomePorCurso,
        Long idCurso_Curso, Long idOutcome_Outcome) throws Exception {
        outcomePorCursoLogic.updateOutcomePorCurso(detalle, idOutcomePorCurso,
            idCurso_Curso, idOutcome_Outcome);
    }

    public OutcomePorCurso getOutcomePorCurso(Long idOutcomePorCurso)
        throws Exception {
        OutcomePorCurso outcomePorCurso = null;

        try {
            outcomePorCurso = outcomePorCursoLogic.getOutcomePorCurso(idOutcomePorCurso);
        } catch (Exception e) {
            throw e;
        }

        return outcomePorCurso;
    }

    public List<OutcomePorCurso> findByCriteriaInOutcomePorCurso(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return outcomePorCursoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<OutcomePorCurso> findPageOutcomePorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return outcomePorCursoLogic.findPageOutcomePorCurso(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberOutcomePorCurso() throws Exception {
        return outcomePorCursoLogic.findTotalNumberOutcomePorCurso();
    }

    public List<OutcomePorCursoDTO> getDataOutcomePorCurso()
        throws Exception {
        return outcomePorCursoLogic.getDataOutcomePorCurso();
    }

    public List<OutcomePorPrograma> getOutcomePorPrograma()
        throws Exception {
        return outcomePorProgramaLogic.getOutcomePorPrograma();
    }

    public void saveOutcomePorPrograma(Long idOutcomePorPrograma,
        Long idOutcome_Outcome, Long idPrograma_Programa)
        throws Exception {
        outcomePorProgramaLogic.saveOutcomePorPrograma(idOutcomePorPrograma,
            idOutcome_Outcome, idPrograma_Programa);
    }

    public void deleteOutcomePorPrograma(Long idOutcomePorPrograma)
        throws Exception {
        outcomePorProgramaLogic.deleteOutcomePorPrograma(idOutcomePorPrograma);
    }

    public void updateOutcomePorPrograma(Long idOutcomePorPrograma,
        Long idOutcome_Outcome, Long idPrograma_Programa)
        throws Exception {
        outcomePorProgramaLogic.updateOutcomePorPrograma(idOutcomePorPrograma,
            idOutcome_Outcome, idPrograma_Programa);
    }

    public OutcomePorPrograma getOutcomePorPrograma(Long idOutcomePorPrograma)
        throws Exception {
        OutcomePorPrograma outcomePorPrograma = null;

        try {
            outcomePorPrograma = outcomePorProgramaLogic.getOutcomePorPrograma(idOutcomePorPrograma);
        } catch (Exception e) {
            throw e;
        }

        return outcomePorPrograma;
    }

    public List<OutcomePorPrograma> findByCriteriaInOutcomePorPrograma(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return outcomePorProgramaLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<OutcomePorPrograma> findPageOutcomePorPrograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return outcomePorProgramaLogic.findPageOutcomePorPrograma(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberOutcomePorPrograma() throws Exception {
        return outcomePorProgramaLogic.findTotalNumberOutcomePorPrograma();
    }

    public List<OutcomePorProgramaDTO> getDataOutcomePorPrograma()
        throws Exception {
        return outcomePorProgramaLogic.getDataOutcomePorPrograma();
    }

    public List<Pensum> getPensum() throws Exception {
        return pensumLogic.getPensum();
    }

    public void savePensum(String creditos, Long idPensum, String semestre,
        Long idCodigoMateria_Materia, Long idPrograma_Programa)
        throws Exception {
        pensumLogic.savePensum(creditos, idPensum, semestre,
            idCodigoMateria_Materia, idPrograma_Programa);
    }

    public void deletePensum(Long idPensum) throws Exception {
        pensumLogic.deletePensum(idPensum);
    }

    public void updatePensum(String creditos, Long idPensum, String semestre,
        Long idCodigoMateria_Materia, Long idPrograma_Programa)
        throws Exception {
        pensumLogic.updatePensum(creditos, idPensum, semestre,
            idCodigoMateria_Materia, idPrograma_Programa);
    }

    public Pensum getPensum(Long idPensum) throws Exception {
        Pensum pensum = null;

        try {
            pensum = pensumLogic.getPensum(idPensum);
        } catch (Exception e) {
            throw e;
        }

        return pensum;
    }

    public List<Pensum> findByCriteriaInPensum(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return pensumLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Pensum> findPagePensum(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return pensumLogic.findPagePensum(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberPensum() throws Exception {
        return pensumLogic.findTotalNumberPensum();
    }

    public List<PensumDTO> getDataPensum() throws Exception {
        return pensumLogic.getDataPensum();
    }

    public List<PeriodoAcademico> getPeriodoAcademico()
        throws Exception {
        return periodoAcademicoLogic.getPeriodoAcademico();
    }

    public void savePeriodoAcademico(String descripcionPeriodo,
        Long idPeriodoAcademico) throws Exception {
        periodoAcademicoLogic.savePeriodoAcademico(descripcionPeriodo,
            idPeriodoAcademico);
    }

    public void deletePeriodoAcademico(Long idPeriodoAcademico)
        throws Exception {
        periodoAcademicoLogic.deletePeriodoAcademico(idPeriodoAcademico);
    }

    public void updatePeriodoAcademico(String descripcionPeriodo,
        Long idPeriodoAcademico) throws Exception {
        periodoAcademicoLogic.updatePeriodoAcademico(descripcionPeriodo,
            idPeriodoAcademico);
    }

    public PeriodoAcademico getPeriodoAcademico(Long idPeriodoAcademico)
        throws Exception {
        PeriodoAcademico periodoAcademico = null;

        try {
            periodoAcademico = periodoAcademicoLogic.getPeriodoAcademico(idPeriodoAcademico);
        } catch (Exception e) {
            throw e;
        }

        return periodoAcademico;
    }

    public List<PeriodoAcademico> findByCriteriaInPeriodoAcademico(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return periodoAcademicoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<PeriodoAcademico> findPagePeriodoAcademico(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return periodoAcademicoLogic.findPagePeriodoAcademico(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberPeriodoAcademico() throws Exception {
        return periodoAcademicoLogic.findTotalNumberPeriodoAcademico();
    }

    public List<PeriodoAcademicoDTO> getDataPeriodoAcademico()
        throws Exception {
        return periodoAcademicoLogic.getDataPeriodoAcademico();
    }

    public List<Programa> getPrograma() throws Exception {
        return programaLogic.getPrograma();
    }

    public void savePrograma(String descripcion, Long idPrograma)
        throws Exception {
        programaLogic.savePrograma(descripcion, idPrograma);
    }

    public void deletePrograma(Long idPrograma) throws Exception {
        programaLogic.deletePrograma(idPrograma);
    }

    public void updatePrograma(String descripcion, Long idPrograma)
        throws Exception {
        programaLogic.updatePrograma(descripcion, idPrograma);
    }

    public Programa getPrograma(Long idPrograma) throws Exception {
        Programa programa = null;

        try {
            programa = programaLogic.getPrograma(idPrograma);
        } catch (Exception e) {
            throw e;
        }

        return programa;
    }

    public List<Programa> findByCriteriaInPrograma(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return programaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Programa> findPagePrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return programaLogic.findPagePrograma(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberPrograma() throws Exception {
        return programaLogic.findTotalNumberPrograma();
    }

    public List<ProgramaDTO> getDataPrograma() throws Exception {
        return programaLogic.getDataPrograma();
    }

    public List<Rubrica> getRubrica() throws Exception {
        return rubricaLogic.getRubrica();
    }

    public void saveRubrica(Long idRubrica, String nombreRubrica)
        throws Exception {
        rubricaLogic.saveRubrica(idRubrica, nombreRubrica);
    }

    public void deleteRubrica(Long idRubrica) throws Exception {
        rubricaLogic.deleteRubrica(idRubrica);
    }

    public void updateRubrica(Long idRubrica, String nombreRubrica)
        throws Exception {
        rubricaLogic.updateRubrica(idRubrica, nombreRubrica);
    }

    public Rubrica getRubrica(Long idRubrica) throws Exception {
        Rubrica rubrica = null;

        try {
            rubrica = rubricaLogic.getRubrica(idRubrica);
        } catch (Exception e) {
            throw e;
        }

        return rubrica;
    }

    public List<Rubrica> findByCriteriaInRubrica(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return rubricaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Rubrica> findPageRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return rubricaLogic.findPageRubrica(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberRubrica() throws Exception {
        return rubricaLogic.findTotalNumberRubrica();
    }

    public List<RubricaDTO> getDataRubrica() throws Exception {
        return rubricaLogic.getDataRubrica();
    }

    public List<RubricaPorCurso> getRubricaPorCurso() throws Exception {
        return rubricaPorCursoLogic.getRubricaPorCurso();
    }

    public void saveRubricaPorCurso(Long idRubricaPorCurso, Long idCurso_Curso,
        Long idOutcomePorPrograma_OutcomePorPrograma, Long idRubrica_Rubrica)
        throws Exception {
        rubricaPorCursoLogic.saveRubricaPorCurso(idRubricaPorCurso,
            idCurso_Curso, idOutcomePorPrograma_OutcomePorPrograma,
            idRubrica_Rubrica);
    }

    public void deleteRubricaPorCurso(Long idRubricaPorCurso)
        throws Exception {
        rubricaPorCursoLogic.deleteRubricaPorCurso(idRubricaPorCurso);
    }

    public void updateRubricaPorCurso(Long idRubricaPorCurso,
        Long idCurso_Curso, Long idOutcomePorPrograma_OutcomePorPrograma,
        Long idRubrica_Rubrica) throws Exception {
        rubricaPorCursoLogic.updateRubricaPorCurso(idRubricaPorCurso,
            idCurso_Curso, idOutcomePorPrograma_OutcomePorPrograma,
            idRubrica_Rubrica);
    }

    public RubricaPorCurso getRubricaPorCurso(Long idRubricaPorCurso)
        throws Exception {
        RubricaPorCurso rubricaPorCurso = null;

        try {
            rubricaPorCurso = rubricaPorCursoLogic.getRubricaPorCurso(idRubricaPorCurso);
        } catch (Exception e) {
            throw e;
        }

        return rubricaPorCurso;
    }

    public List<RubricaPorCurso> findByCriteriaInRubricaPorCurso(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return rubricaPorCursoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<RubricaPorCurso> findPageRubricaPorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return rubricaPorCursoLogic.findPageRubricaPorCurso(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRubricaPorCurso() throws Exception {
        return rubricaPorCursoLogic.findTotalNumberRubricaPorCurso();
    }

    public List<RubricaPorCursoDTO> getDataRubricaPorCurso()
        throws Exception {
        return rubricaPorCursoLogic.getDataRubricaPorCurso();
    }
}
