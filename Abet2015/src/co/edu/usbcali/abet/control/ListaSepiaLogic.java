package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.ListaSepiaDTO;
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
@Service("ListaSepiaLogic")
public class ListaSepiaLogic implements IListaSepiaLogic {
    /**
     * DAO injected by Spring that manages ListaSepia entities
     *
     */
    @Autowired
    private IListaSepiaDAO listaSepiaDAO;

    /**
    * DAO injected by Spring that manages Assesment entities
    *
    */
    @Autowired
    private IAssesmentDAO assesmentDAO;

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

    @Transactional(readOnly = true)
    public List<ListaSepia> getListaSepia() throws Exception {
        List<ListaSepia> list = new ArrayList<ListaSepia>();

        try {
            list = listaSepiaDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "ListaSepia");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveListaSepia(Long idListaSepia, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante) throws Exception {
        ListaSepia entity = null;

        try {
            if (idListaSepia == null) {
                throw new ZMessManager().new EmptyFieldException("idListaSepia");
            }

            if ((idListaSepia != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idListaSepia, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idListaSepia");
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

            Curso cursoClass = logicCurso1.getCurso(idCurso_Curso);
            Estudiante estudianteClass = logicEstudiante2.getEstudiante(idCodigoEstudiante_Estudiante);

            if (cursoClass == null) {
                throw new ZMessManager().new ForeignException("curso");
            }

            if (estudianteClass == null) {
                throw new ZMessManager().new ForeignException("estudiante");
            }

            entity = getListaSepia(idListaSepia);

            if (entity != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            entity = new ListaSepia();
            entity.setIdListaSepia(idListaSepia);
            entity.setCurso(cursoClass);
            entity.setEstudiante(estudianteClass);
            listaSepiaDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteListaSepia(Long idListaSepia) throws Exception {
        ListaSepia entity = null;

        if (idListaSepia == null) {
            throw new ZMessManager().new EmptyFieldException("idListaSepia");
        }

        List<Assesment> assesments = null;
        entity = getListaSepia(idListaSepia);

        if (entity == null) {
            throw new ZMessManager().new EmptyFieldException("ListaSepia");
        }

        try {
            assesments = assesmentDAO.findByProperty("listaSepia.idListaSepia",
                    idListaSepia);

            if (Utilities.validationsList(assesments) == true) {
                throw new ZMessManager().new DeletingException("assesments");
            }

            listaSepiaDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateListaSepia(Long idListaSepia, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante) throws Exception {
        ListaSepia entity = null;

        try {
            if (idListaSepia == null) {
                throw new ZMessManager().new EmptyFieldException("idListaSepia");
            }

            if ((idListaSepia != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idListaSepia, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idListaSepia");
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

            Curso cursoClass = logicCurso1.getCurso(idCurso_Curso);
            Estudiante estudianteClass = logicEstudiante2.getEstudiante(idCodigoEstudiante_Estudiante);

            if (cursoClass == null) {
                throw new ZMessManager().new ForeignException("curso");
            }

            if (estudianteClass == null) {
                throw new ZMessManager().new ForeignException("estudiante");
            }

            entity = getListaSepia(idListaSepia);

            if (entity == null) {
                throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
            }

            entity.setIdListaSepia(idListaSepia);
            entity.setCurso(cursoClass);
            entity.setEstudiante(estudianteClass);
            listaSepiaDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<ListaSepiaDTO> getDataListaSepia() throws Exception {
        try {
            List<ListaSepia> listaSepia = listaSepiaDAO.findAll();

            List<ListaSepiaDTO> listaSepiaDTO = new ArrayList<ListaSepiaDTO>();

            for (ListaSepia listaSepiaTmp : listaSepia) {
                ListaSepiaDTO listaSepiaDTO2 = new ListaSepiaDTO();

                listaSepiaDTO2.setIdListaSepia(listaSepiaTmp.getIdListaSepia());

                if (listaSepiaTmp.getCurso() != null) {
                    listaSepiaDTO2.setIdCurso_Curso(listaSepiaTmp.getCurso()
                                                                 .getIdCurso());
                } else {
                    listaSepiaDTO2.setIdCurso_Curso(null);
                }

                if (listaSepiaTmp.getEstudiante() != null) {
                    listaSepiaDTO2.setIdCodigoEstudiante_Estudiante(listaSepiaTmp.getEstudiante()
                                                                                 .getIdCodigoEstudiante());
                } else {
                    listaSepiaDTO2.setIdCodigoEstudiante_Estudiante(null);
                }

                listaSepiaDTO.add(listaSepiaDTO2);
            }

            return listaSepiaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ListaSepia getListaSepia(Long idListaSepia)
        throws Exception {
        ListaSepia entity = null;

        try {
            entity = listaSepiaDAO.findById(idListaSepia);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("ListaSepia");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<ListaSepia> findPageListaSepia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<ListaSepia> entity = null;

        try {
            entity = listaSepiaDAO.findPageListaSepia(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("ListaSepia Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberListaSepia() throws Exception {
        Long entity = null;

        try {
            entity = listaSepiaDAO.findTotalNumberListaSepia();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("ListaSepia Count");
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
    public List<ListaSepia> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<ListaSepia> list = new ArrayList<ListaSepia>();
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
            list = listaSepiaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
