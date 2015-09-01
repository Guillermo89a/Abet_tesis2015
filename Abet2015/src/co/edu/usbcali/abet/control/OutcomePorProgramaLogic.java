package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.OutcomePorProgramaDTO;
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
@Service("OutcomePorProgramaLogic")
public class OutcomePorProgramaLogic implements IOutcomePorProgramaLogic {
    /**
     * DAO injected by Spring that manages OutcomePorPrograma entities
     *
     */
    @Autowired
    private IOutcomePorProgramaDAO outcomePorProgramaDAO;

    /**
    * DAO injected by Spring that manages RubricaPorCurso entities
    *
    */
    @Autowired
    private IRubricaPorCursoDAO rubricaPorCursoDAO;

    /**
    * Logic injected by Spring that manages Outcome entities
    *
    */
    @Autowired
    IOutcomeLogic logicOutcome1;

    /**
    * Logic injected by Spring that manages Programa entities
    *
    */
    @Autowired
    IProgramaLogic logicPrograma2;

    @Transactional(readOnly = true)
    public List<OutcomePorPrograma> getOutcomePorPrograma()
        throws Exception {
        List<OutcomePorPrograma> list = new ArrayList<OutcomePorPrograma>();

        try {
            list = outcomePorProgramaDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "OutcomePorPrograma");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveOutcomePorPrograma(Long idOutcomePorPrograma,
        Long idOutcome_Outcome, Long idPrograma_Programa)
        throws Exception {
        OutcomePorPrograma entity = null;

        try {
            if (idOutcomePorPrograma == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idOutcomePorPrograma");
            }

            if ((idOutcomePorPrograma != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idOutcomePorPrograma, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idOutcomePorPrograma");
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

            if (idPrograma_Programa == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idPrograma_Programa");
            }

            if ((idPrograma_Programa != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idPrograma_Programa, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idPrograma_Programa");
            }

            Outcome outcomeClass = logicOutcome1.getOutcome(idOutcome_Outcome);
            Programa programaClass = logicPrograma2.getPrograma(idPrograma_Programa);

            if (outcomeClass == null) {
                throw new ZMessManager().new ForeignException("outcome");
            }

            if (programaClass == null) {
                throw new ZMessManager().new ForeignException("programa");
            }

            entity = getOutcomePorPrograma(idOutcomePorPrograma);

            if (entity != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            entity = new OutcomePorPrograma();
            entity.setIdOutcomePorPrograma(idOutcomePorPrograma);
            entity.setOutcome(outcomeClass);
            entity.setPrograma(programaClass);
            outcomePorProgramaDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteOutcomePorPrograma(Long idOutcomePorPrograma)
        throws Exception {
        OutcomePorPrograma entity = null;

        if (idOutcomePorPrograma == null) {
            throw new ZMessManager().new EmptyFieldException(
                "idOutcomePorPrograma");
        }

        List<RubricaPorCurso> rubricaPorCursos = null;
        entity = getOutcomePorPrograma(idOutcomePorPrograma);

        if (entity == null) {
            throw new ZMessManager().new EmptyFieldException(
                "OutcomePorPrograma");
        }

        try {
            rubricaPorCursos = rubricaPorCursoDAO.findByProperty("outcomePorPrograma.idOutcomePorPrograma",
                    idOutcomePorPrograma);

            if (Utilities.validationsList(rubricaPorCursos) == true) {
                throw new ZMessManager().new DeletingException(
                    "rubricaPorCursos");
            }

            outcomePorProgramaDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateOutcomePorPrograma(Long idOutcomePorPrograma,
        Long idOutcome_Outcome, Long idPrograma_Programa)
        throws Exception {
        OutcomePorPrograma entity = null;

        try {
            if (idOutcomePorPrograma == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idOutcomePorPrograma");
            }

            if ((idOutcomePorPrograma != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idOutcomePorPrograma, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idOutcomePorPrograma");
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

            if (idPrograma_Programa == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idPrograma_Programa");
            }

            if ((idPrograma_Programa != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idPrograma_Programa, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idPrograma_Programa");
            }

            Outcome outcomeClass = logicOutcome1.getOutcome(idOutcome_Outcome);
            Programa programaClass = logicPrograma2.getPrograma(idPrograma_Programa);

            if (outcomeClass == null) {
                throw new ZMessManager().new ForeignException("outcome");
            }

            if (programaClass == null) {
                throw new ZMessManager().new ForeignException("programa");
            }

            entity = getOutcomePorPrograma(idOutcomePorPrograma);

            if (entity == null) {
                throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
            }

            entity.setIdOutcomePorPrograma(idOutcomePorPrograma);
            entity.setOutcome(outcomeClass);
            entity.setPrograma(programaClass);
            outcomePorProgramaDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<OutcomePorProgramaDTO> getDataOutcomePorPrograma()
        throws Exception {
        try {
            List<OutcomePorPrograma> outcomePorPrograma = outcomePorProgramaDAO.findAll();

            List<OutcomePorProgramaDTO> outcomePorProgramaDTO = new ArrayList<OutcomePorProgramaDTO>();

            for (OutcomePorPrograma outcomePorProgramaTmp : outcomePorPrograma) {
                OutcomePorProgramaDTO outcomePorProgramaDTO2 = new OutcomePorProgramaDTO();

                outcomePorProgramaDTO2.setIdOutcomePorPrograma(outcomePorProgramaTmp.getIdOutcomePorPrograma());

                if (outcomePorProgramaTmp.getOutcome() != null) {
                    outcomePorProgramaDTO2.setIdOutcome_Outcome(outcomePorProgramaTmp.getOutcome()
                                                                                     .getIdOutcome());
                } else {
                    outcomePorProgramaDTO2.setIdOutcome_Outcome(null);
                }

                if (outcomePorProgramaTmp.getPrograma() != null) {
                    outcomePorProgramaDTO2.setIdPrograma_Programa(outcomePorProgramaTmp.getPrograma()
                                                                                       .getIdPrograma());
                } else {
                    outcomePorProgramaDTO2.setIdPrograma_Programa(null);
                }

                outcomePorProgramaDTO.add(outcomePorProgramaDTO2);
            }

            return outcomePorProgramaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public OutcomePorPrograma getOutcomePorPrograma(Long idOutcomePorPrograma)
        throws Exception {
        OutcomePorPrograma entity = null;

        try {
            entity = outcomePorProgramaDAO.findById(idOutcomePorPrograma);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("OutcomePorPrograma");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<OutcomePorPrograma> findPageOutcomePorPrograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<OutcomePorPrograma> entity = null;

        try {
            entity = outcomePorProgramaDAO.findPageOutcomePorPrograma(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "OutcomePorPrograma Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberOutcomePorPrograma() throws Exception {
        Long entity = null;

        try {
            entity = outcomePorProgramaDAO.findTotalNumberOutcomePorPrograma();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "OutcomePorPrograma Count");
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
    public List<OutcomePorPrograma> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<OutcomePorPrograma> list = new ArrayList<OutcomePorPrograma>();
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
            list = outcomePorProgramaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
