package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.EvaluacionDTO;
import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.utilities.Utilities;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
@Scope("singleton")
@Service("EvaluacionLogic")
public class EvaluacionLogic implements IEvaluacionLogic {
    /**
     * DAO injected by Spring that manages Evaluacion entities
     *
     */
    @Autowired
    private IEvaluacionDAO evaluacionDAO;

    /**
    * Logic injected by Spring that manages Curso entities
    *
    */
    @Autowired
    ICursoLogic logicCurso1;

    /**
    * Logic injected by Spring that manages Estudiante entities
    *
    */
    @Autowired
    IEstudianteLogic logicEstudiante2;

    /**
    * Logic injected by Spring that manages Outcome entities
    *
    */
    @Autowired
    IOutcomeLogic logicOutcome3;

    @Transactional(readOnly = true)
    public List<Evaluacion> getEvaluacion() throws Exception {
        List<Evaluacion> list = new ArrayList<Evaluacion>();

        try {
            list = evaluacionDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Evaluacion");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveEvaluacion(Long idEvaluacion, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante, Long idOutcome_Outcome)
        throws Exception {
        Evaluacion entity = null;

        try {
            if (idEvaluacion == null) {
                throw new ZMessManager().new EmptyFieldException("idEvaluacion");
            }

            if ((idEvaluacion != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idEvaluacion, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idEvaluacion");
            }

            if (idCurso_Curso == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idCurso_Curso");
            }

            if ((idCurso_Curso != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idCurso_Curso, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idCurso_Curso");
            }

            if (idCodigoEstudiante_Estudiante == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idCodigoEstudiante_Estudiante");
            }

            if ((idCodigoEstudiante_Estudiante != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idCodigoEstudiante_Estudiante, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idCodigoEstudiante_Estudiante");
            }

            if (idOutcome_Outcome == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idOutcome_Outcome");
            }

            if ((idOutcome_Outcome != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idOutcome_Outcome, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idOutcome_Outcome");
            }

            Curso cursoClass = logicCurso1.getCurso(idCurso_Curso);
            Estudiante estudianteClass = logicEstudiante2.getEstudiante(idCodigoEstudiante_Estudiante);
            Outcome outcomeClass = logicOutcome3.getOutcome(idOutcome_Outcome);

            if (cursoClass == null) {
                throw new ZMessManager().new ForeignException("curso");
            }

            if (estudianteClass == null) {
                throw new ZMessManager().new ForeignException("estudiante");
            }

            if (outcomeClass == null) {
                throw new ZMessManager().new ForeignException("outcome");
            }

            entity = getEvaluacion(idEvaluacion);

            if (entity != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            entity = new Evaluacion();
            entity.setIdEvaluacion(idEvaluacion);
            entity.setCurso(cursoClass);
            entity.setEstudiante(estudianteClass);
            entity.setOutcome(outcomeClass);
            evaluacionDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteEvaluacion(Long idEvaluacion) throws Exception {
        Evaluacion entity = null;

        if (idEvaluacion == null) {
            throw new ZMessManager().new EmptyFieldException("idEvaluacion");
        }

        entity = getEvaluacion(idEvaluacion);

        if (entity == null) {
            throw new ZMessManager().new EmptyFieldException("Evaluacion");
        }

        try {
            evaluacionDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateEvaluacion(Long idEvaluacion, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante, Long idOutcome_Outcome)
        throws Exception {
        Evaluacion entity = null;

        try {
            if (idEvaluacion == null) {
                throw new ZMessManager().new EmptyFieldException("idEvaluacion");
            }

            if ((idEvaluacion != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idEvaluacion, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idEvaluacion");
            }

            if (idCurso_Curso == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idCurso_Curso");
            }

            if ((idCurso_Curso != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idCurso_Curso, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idCurso_Curso");
            }

            if (idCodigoEstudiante_Estudiante == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idCodigoEstudiante_Estudiante");
            }

            if ((idCodigoEstudiante_Estudiante != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idCodigoEstudiante_Estudiante, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idCodigoEstudiante_Estudiante");
            }

            if (idOutcome_Outcome == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idOutcome_Outcome");
            }

            if ((idOutcome_Outcome != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idOutcome_Outcome, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idOutcome_Outcome");
            }

            Curso cursoClass = logicCurso1.getCurso(idCurso_Curso);
            Estudiante estudianteClass = logicEstudiante2.getEstudiante(idCodigoEstudiante_Estudiante);
            Outcome outcomeClass = logicOutcome3.getOutcome(idOutcome_Outcome);

            if (cursoClass == null) {
                throw new ZMessManager().new ForeignException("curso");
            }

            if (estudianteClass == null) {
                throw new ZMessManager().new ForeignException("estudiante");
            }

            if (outcomeClass == null) {
                throw new ZMessManager().new ForeignException("outcome");
            }

            entity = getEvaluacion(idEvaluacion);

            if (entity == null) {
                throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
            }

            entity.setIdEvaluacion(idEvaluacion);
            entity.setCurso(cursoClass);
            entity.setEstudiante(estudianteClass);
            entity.setOutcome(outcomeClass);
            evaluacionDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<EvaluacionDTO> getDataEvaluacion() throws Exception {
        try {
            List<Evaluacion> evaluacion = evaluacionDAO.findAll();

            List<EvaluacionDTO> evaluacionDTO = new ArrayList<EvaluacionDTO>();

            for (Evaluacion evaluacionTmp : evaluacion) {
                EvaluacionDTO evaluacionDTO2 = new EvaluacionDTO();

                evaluacionDTO2.setIdEvaluacion(evaluacionTmp.getIdEvaluacion());

                if (evaluacionTmp.getCurso() != null) {
                    evaluacionDTO2.setIdCurso_Curso(evaluacionTmp.getCurso()
                                                                 .getIdCurso());
                } else {
                    evaluacionDTO2.setIdCurso_Curso(null);
                }

                if (evaluacionTmp.getEstudiante() != null) {
                    evaluacionDTO2.setIdCodigoEstudiante_Estudiante(evaluacionTmp.getEstudiante()
                                                                                 .getIdCodigoEstudiante());
                } else {
                    evaluacionDTO2.setIdCodigoEstudiante_Estudiante(null);
                }

                if (evaluacionTmp.getOutcome() != null) {
                    evaluacionDTO2.setIdOutcome_Outcome(evaluacionTmp.getOutcome()
                                                                     .getIdOutcome());
                } else {
                    evaluacionDTO2.setIdOutcome_Outcome(null);
                }

                evaluacionDTO.add(evaluacionDTO2);
            }

            return evaluacionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Evaluacion getEvaluacion(Long idEvaluacion)
        throws Exception {
        Evaluacion entity = null;

        try {
            entity = evaluacionDAO.findById(idEvaluacion);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Evaluacion");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Evaluacion> findPageEvaluacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Evaluacion> entity = null;

        try {
            entity = evaluacionDAO.findPageEvaluacion(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Evaluacion Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberEvaluacion() throws Exception {
        Long entity = null;

        try {
            entity = evaluacionDAO.findTotalNumberEvaluacion();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Evaluacion Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Evaluacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Evaluacion> list = new ArrayList<Evaluacion>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = evaluacionDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
