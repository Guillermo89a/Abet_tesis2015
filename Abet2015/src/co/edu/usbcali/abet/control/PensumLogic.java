package co.edu.usbcali.abet.control;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.PensumDTO;
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
@Service("PensumLogic")
public class PensumLogic implements IPensumLogic {
    /**
     * DAO injected by Spring that manages Pensum entities
     *
     */
    @Autowired
    private IPensumDAO pensumDAO;

    /**
    * Logic injected by Spring that manages Materia entities
    *
    */
    @Autowired
    IMateriaLogic logicMateria1;

    /**
    * Logic injected by Spring that manages Programa entities
    *
    */
    @Autowired
    IProgramaLogic logicPrograma2;

    @Transactional(readOnly = true)
    public List<Pensum> getPensum() throws Exception {
        List<Pensum> list = new ArrayList<Pensum>();

        try {
            list = pensumDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Pensum");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void savePensum(String creditos, Long idPensum, String semestre,
        Long idCodigoMateria_Materia, Long idPrograma_Programa)
        throws Exception {
        Pensum entity = null;

        try {
            if ((creditos != null) &&
                    (Utilities.checkWordAndCheckWithlength(creditos, 2) == false)) {
                throw new ZMessManager().new NotValidFormatException("creditos");
            }

            if (idPensum == null) {
                throw new ZMessManager().new EmptyFieldException("idPensum");
            }

            if ((idPensum != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idPensum, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("idPensum");
            }

            if ((semestre != null) &&
                    (Utilities.checkWordAndCheckWithlength(semestre, 100) == false)) {
                throw new ZMessManager().new NotValidFormatException("semestre");
            }

            if (idCodigoMateria_Materia == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idCodigoMateria_Materia");
            }

            if ((idCodigoMateria_Materia != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idCodigoMateria_Materia, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idCodigoMateria_Materia");
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

            Materia materiaClass = logicMateria1.getMateria(idCodigoMateria_Materia);
            Programa programaClass = logicPrograma2.getPrograma(idPrograma_Programa);

            if (materiaClass == null) {
                throw new ZMessManager().new ForeignException("materia");
            }

            if (programaClass == null) {
                throw new ZMessManager().new ForeignException("programa");
            }

            entity = getPensum(idPensum);

            if (entity != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            entity = new Pensum();
            entity.setCreditos(creditos);
            entity.setIdPensum(idPensum);
            entity.setSemestre(semestre);
            entity.setMateria(materiaClass);
            entity.setPrograma(programaClass);
            pensumDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePensum(Long idPensum) throws Exception {
        Pensum entity = null;

        if (idPensum == null) {
            throw new ZMessManager().new EmptyFieldException("idPensum");
        }

        entity = getPensum(idPensum);

        if (entity == null) {
            throw new ZMessManager().new EmptyFieldException("Pensum");
        }

        try {
            pensumDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePensum(String creditos, Long idPensum, String semestre,
        Long idCodigoMateria_Materia, Long idPrograma_Programa)
        throws Exception {
        Pensum entity = null;

        try {
            if ((creditos != null) &&
                    (Utilities.checkWordAndCheckWithlength(creditos, 2) == false)) {
                throw new ZMessManager().new NotValidFormatException("creditos");
            }

            if (idPensum == null) {
                throw new ZMessManager().new EmptyFieldException("idPensum");
            }

            if ((idPensum != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idPensum, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("idPensum");
            }

            if ((semestre != null) &&
                    (Utilities.checkWordAndCheckWithlength(semestre, 100) == false)) {
                throw new ZMessManager().new NotValidFormatException("semestre");
            }

            if (idCodigoMateria_Materia == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idCodigoMateria_Materia");
            }

            if ((idCodigoMateria_Materia != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idCodigoMateria_Materia, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idCodigoMateria_Materia");
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

            Materia materiaClass = logicMateria1.getMateria(idCodigoMateria_Materia);
            Programa programaClass = logicPrograma2.getPrograma(idPrograma_Programa);

            if (materiaClass == null) {
                throw new ZMessManager().new ForeignException("materia");
            }

            if (programaClass == null) {
                throw new ZMessManager().new ForeignException("programa");
            }

            entity = getPensum(idPensum);

            if (entity == null) {
                throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
            }

            entity.setCreditos(creditos);
            entity.setIdPensum(idPensum);
            entity.setSemestre(semestre);
            entity.setMateria(materiaClass);
            entity.setPrograma(programaClass);
            pensumDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<PensumDTO> getDataPensum() throws Exception {
        try {
            List<Pensum> pensum = pensumDAO.findAll();

            List<PensumDTO> pensumDTO = new ArrayList<PensumDTO>();

            for (Pensum pensumTmp : pensum) {
                PensumDTO pensumDTO2 = new PensumDTO();

                pensumDTO2.setIdPensum(pensumTmp.getIdPensum());
                pensumDTO2.setCreditos((pensumTmp.getCreditos() != null)
                    ? pensumTmp.getCreditos() : null);
                pensumDTO2.setSemestre((pensumTmp.getSemestre() != null)
                    ? pensumTmp.getSemestre() : null);

                if (pensumTmp.getMateria() != null) {
                    pensumDTO2.setIdCodigoMateria_Materia(pensumTmp.getMateria()
                                                                   .getIdCodigoMateria());
                } else {
                    pensumDTO2.setIdCodigoMateria_Materia(null);
                }

                if (pensumTmp.getPrograma() != null) {
                    pensumDTO2.setIdPrograma_Programa(pensumTmp.getPrograma()
                                                               .getIdPrograma());
                } else {
                    pensumDTO2.setIdPrograma_Programa(null);
                }

                pensumDTO.add(pensumDTO2);
            }

            return pensumDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Pensum getPensum(Long idPensum) throws Exception {
        Pensum entity = null;

        try {
            entity = pensumDAO.findById(idPensum);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Pensum");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Pensum> findPagePensum(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Pensum> entity = null;

        try {
            entity = pensumDAO.findPagePensum(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Pensum Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberPensum() throws Exception {
        Long entity = null;

        try {
            entity = pensumDAO.findTotalNumberPensum();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Pensum Count");
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
    public List<Pensum> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Pensum> list = new ArrayList<Pensum>();
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
            list = pensumDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
