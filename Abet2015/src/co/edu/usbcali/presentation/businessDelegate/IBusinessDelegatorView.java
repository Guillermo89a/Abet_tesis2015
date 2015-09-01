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

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public interface IBusinessDelegatorView {
    public List<Assesment> getAssesment() throws Exception;

    public void saveAssesment(Long calificacion, Long idCodigoAssesment,
        Long idListaSepia_ListaSepia, Long idRubricaPorCurso_RubricaPorCurso)
        throws Exception;

    public void deleteAssesment(Long idCodigoAssesment)
        throws Exception;

    public void updateAssesment(Long calificacion, Long idCodigoAssesment,
        Long idListaSepia_ListaSepia, Long idRubricaPorCurso_RubricaPorCurso)
        throws Exception;

    public Assesment getAssesment(Long idCodigoAssesment)
        throws Exception;

    public List<Assesment> findByCriteriaInAssesment(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Assesment> findPageAssesment(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAssesment() throws Exception;

    public List<AssesmentDTO> getDataAssesment() throws Exception;

    public List<Categoria> getCategoria() throws Exception;

    public void saveCategoria(Long idCategoria, String nombrecategoria,
        Long idRubrica_Rubrica) throws Exception;

    public void deleteCategoria(Long idCategoria) throws Exception;

    public void updateCategoria(Long idCategoria, String nombrecategoria,
        Long idRubrica_Rubrica) throws Exception;

    public Categoria getCategoria(Long idCategoria) throws Exception;

    public List<Categoria> findByCriteriaInCategoria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCategoria() throws Exception;

    public List<CategoriaDTO> getDataCategoria() throws Exception;

    public List<Curso> getCurso() throws Exception;

    public void saveCurso(Long idCurso, String nombreCurso,
        Long idCodigoDocente_Docente, Long idCodigoMateria_Materia,
        Long idPeriodoAcademico_PeriodoAcademico) throws Exception;

    public void deleteCurso(Long idCurso) throws Exception;

    public void updateCurso(Long idCurso, String nombreCurso,
        Long idCodigoDocente_Docente, Long idCodigoMateria_Materia,
        Long idPeriodoAcademico_PeriodoAcademico) throws Exception;

    public Curso getCurso(Long idCurso) throws Exception;

    public List<Curso> findByCriteriaInCurso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Curso> findPageCurso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCurso() throws Exception;

    public List<CursoDTO> getDataCurso() throws Exception;

    public List<DetalleRubrica> getDetalleRubrica() throws Exception;

    public void saveDetalleRubrica(Long idDetalleRubrica, Long idRubrica_Rubrica)
        throws Exception;

    public void deleteDetalleRubrica(Long idDetalleRubrica)
        throws Exception;

    public void updateDetalleRubrica(Long idDetalleRubrica,
        Long idRubrica_Rubrica) throws Exception;

    public DetalleRubrica getDetalleRubrica(Long idDetalleRubrica)
        throws Exception;

    public List<DetalleRubrica> findByCriteriaInDetalleRubrica(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<DetalleRubrica> findPageDetalleRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDetalleRubrica() throws Exception;

    public List<DetalleRubricaDTO> getDataDetalleRubrica()
        throws Exception;

    public List<Docente> getDocente() throws Exception;

    public void saveDocente(Long idCodigoDocente, String nombreDocente)
        throws Exception;

    public void deleteDocente(Long idCodigoDocente) throws Exception;

    public void updateDocente(Long idCodigoDocente, String nombreDocente)
        throws Exception;

    public Docente getDocente(Long idCodigoDocente) throws Exception;

    public List<Docente> findByCriteriaInDocente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Docente> findPageDocente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDocente() throws Exception;

    public List<DocenteDTO> getDataDocente() throws Exception;

    public List<Estudiante> getEstudiante() throws Exception;

    public void saveEstudiante(String direccion, String email,
        Long idCodigoEstudiante, String nombre, String telefono)
        throws Exception;

    public void deleteEstudiante(Long idCodigoEstudiante)
        throws Exception;

    public void updateEstudiante(String direccion, String email,
        Long idCodigoEstudiante, String nombre, String telefono)
        throws Exception;

    public Estudiante getEstudiante(Long idCodigoEstudiante)
        throws Exception;

    public List<Estudiante> findByCriteriaInEstudiante(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Estudiante> findPageEstudiante(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstudiante() throws Exception;

    public List<EstudianteDTO> getDataEstudiante() throws Exception;

    public List<Evaluacion> getEvaluacion() throws Exception;

    public void saveEvaluacion(Long idEvaluacion, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante, Long idOutcome_Outcome)
        throws Exception;

    public void deleteEvaluacion(Long idEvaluacion) throws Exception;

    public void updateEvaluacion(Long idEvaluacion, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante, Long idOutcome_Outcome)
        throws Exception;

    public Evaluacion getEvaluacion(Long idEvaluacion)
        throws Exception;

    public List<Evaluacion> findByCriteriaInEvaluacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Evaluacion> findPageEvaluacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEvaluacion() throws Exception;

    public List<EvaluacionDTO> getDataEvaluacion() throws Exception;

    public List<ListaSepia> getListaSepia() throws Exception;

    public void saveListaSepia(Long idListaSepia, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante) throws Exception;

    public void deleteListaSepia(Long idListaSepia) throws Exception;

    public void updateListaSepia(Long idListaSepia, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante) throws Exception;

    public ListaSepia getListaSepia(Long idListaSepia)
        throws Exception;

    public List<ListaSepia> findByCriteriaInListaSepia(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ListaSepia> findPageListaSepia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberListaSepia() throws Exception;

    public List<ListaSepiaDTO> getDataListaSepia() throws Exception;

    public List<Materia> getMateria() throws Exception;

    public void saveMateria(String creditos, Long idCodigoMateria, String nombre)
        throws Exception;

    public void deleteMateria(Long idCodigoMateria) throws Exception;

    public void updateMateria(String creditos, Long idCodigoMateria,
        String nombre) throws Exception;

    public Materia getMateria(Long idCodigoMateria) throws Exception;

    public List<Materia> findByCriteriaInMateria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Materia> findPageMateria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMateria() throws Exception;

    public List<MateriaDTO> getDataMateria() throws Exception;

    public List<Outcome> getOutcome() throws Exception;

    public void saveOutcome(String detalle, Long idOutcome)
        throws Exception;

    public void deleteOutcome(Long idOutcome) throws Exception;

    public void updateOutcome(String detalle, Long idOutcome)
        throws Exception;

    public Outcome getOutcome(Long idOutcome) throws Exception;

    public List<Outcome> findByCriteriaInOutcome(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Outcome> findPageOutcome(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberOutcome() throws Exception;

    public List<OutcomeDTO> getDataOutcome() throws Exception;

    public List<OutcomePorCurso> getOutcomePorCurso() throws Exception;

    public void saveOutcomePorCurso(String detalle, Long idOutcomePorCurso,
        Long idCurso_Curso, Long idOutcome_Outcome) throws Exception;

    public void deleteOutcomePorCurso(Long idOutcomePorCurso)
        throws Exception;

    public void updateOutcomePorCurso(String detalle, Long idOutcomePorCurso,
        Long idCurso_Curso, Long idOutcome_Outcome) throws Exception;

    public OutcomePorCurso getOutcomePorCurso(Long idOutcomePorCurso)
        throws Exception;

    public List<OutcomePorCurso> findByCriteriaInOutcomePorCurso(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<OutcomePorCurso> findPageOutcomePorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberOutcomePorCurso() throws Exception;

    public List<OutcomePorCursoDTO> getDataOutcomePorCurso()
        throws Exception;

    public List<OutcomePorPrograma> getOutcomePorPrograma()
        throws Exception;

    public void saveOutcomePorPrograma(Long idOutcomePorPrograma,
        Long idOutcome_Outcome, Long idPrograma_Programa)
        throws Exception;

    public void deleteOutcomePorPrograma(Long idOutcomePorPrograma)
        throws Exception;

    public void updateOutcomePorPrograma(Long idOutcomePorPrograma,
        Long idOutcome_Outcome, Long idPrograma_Programa)
        throws Exception;

    public OutcomePorPrograma getOutcomePorPrograma(Long idOutcomePorPrograma)
        throws Exception;

    public List<OutcomePorPrograma> findByCriteriaInOutcomePorPrograma(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<OutcomePorPrograma> findPageOutcomePorPrograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberOutcomePorPrograma() throws Exception;

    public List<OutcomePorProgramaDTO> getDataOutcomePorPrograma()
        throws Exception;

    public List<Pensum> getPensum() throws Exception;

    public void savePensum(String creditos, Long idPensum, String semestre,
        Long idCodigoMateria_Materia, Long idPrograma_Programa)
        throws Exception;

    public void deletePensum(Long idPensum) throws Exception;

    public void updatePensum(String creditos, Long idPensum, String semestre,
        Long idCodigoMateria_Materia, Long idPrograma_Programa)
        throws Exception;

    public Pensum getPensum(Long idPensum) throws Exception;

    public List<Pensum> findByCriteriaInPensum(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Pensum> findPagePensum(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPensum() throws Exception;

    public List<PensumDTO> getDataPensum() throws Exception;

    public List<PeriodoAcademico> getPeriodoAcademico()
        throws Exception;

    public void savePeriodoAcademico(String descripcionPeriodo,
        Long idPeriodoAcademico) throws Exception;

    public void deletePeriodoAcademico(Long idPeriodoAcademico)
        throws Exception;

    public void updatePeriodoAcademico(String descripcionPeriodo,
        Long idPeriodoAcademico) throws Exception;

    public PeriodoAcademico getPeriodoAcademico(Long idPeriodoAcademico)
        throws Exception;

    public List<PeriodoAcademico> findByCriteriaInPeriodoAcademico(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<PeriodoAcademico> findPagePeriodoAcademico(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPeriodoAcademico() throws Exception;

    public List<PeriodoAcademicoDTO> getDataPeriodoAcademico()
        throws Exception;

    public List<Programa> getPrograma() throws Exception;

    public void savePrograma(String descripcion, Long idPrograma)
        throws Exception;

    public void deletePrograma(Long idPrograma) throws Exception;

    public void updatePrograma(String descripcion, Long idPrograma)
        throws Exception;

    public Programa getPrograma(Long idPrograma) throws Exception;

    public List<Programa> findByCriteriaInPrograma(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Programa> findPagePrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPrograma() throws Exception;

    public List<ProgramaDTO> getDataPrograma() throws Exception;

    public List<Rubrica> getRubrica() throws Exception;

    public void saveRubrica(Long idRubrica, String nombreRubrica)
        throws Exception;

    public void deleteRubrica(Long idRubrica) throws Exception;

    public void updateRubrica(Long idRubrica, String nombreRubrica)
        throws Exception;

    public Rubrica getRubrica(Long idRubrica) throws Exception;

    public List<Rubrica> findByCriteriaInRubrica(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Rubrica> findPageRubrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRubrica() throws Exception;

    public List<RubricaDTO> getDataRubrica() throws Exception;

    public List<RubricaPorCurso> getRubricaPorCurso() throws Exception;

    public void saveRubricaPorCurso(Long idRubricaPorCurso, Long idCurso_Curso,
        Long idOutcomePorPrograma_OutcomePorPrograma, Long idRubrica_Rubrica)
        throws Exception;

    public void deleteRubricaPorCurso(Long idRubricaPorCurso)
        throws Exception;

    public void updateRubricaPorCurso(Long idRubricaPorCurso,
        Long idCurso_Curso, Long idOutcomePorPrograma_OutcomePorPrograma,
        Long idRubrica_Rubrica) throws Exception;

    public RubricaPorCurso getRubricaPorCurso(Long idRubricaPorCurso)
        throws Exception;

    public List<RubricaPorCurso> findByCriteriaInRubricaPorCurso(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<RubricaPorCurso> findPageRubricaPorCurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRubricaPorCurso() throws Exception;

    public List<RubricaPorCursoDTO> getDataRubricaPorCurso()
        throws Exception;
}
