package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.CursoDTO;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.presentation.businessDelegate.*;
import co.edu.usbcali.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *
 */
@Component
@ManagedBean
@ViewScoped
public class CursoView {
    private InputText txtNombreCurso;
    private InputText txtIdCodigoDocente_Docente;
    private InputText txtIdCodigoMateria_Materia;
    private InputText txtIdPeriodoAcademico_PeriodoAcademico;
    private InputText txtIdCurso;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CursoDTO> data;
    private CursoDTO selectedCurso;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public CursoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            CursoDTO cursoDTO = (CursoDTO) e.getObject();

            if (txtNombreCurso == null) {
                txtNombreCurso = new InputText();
            }

            txtNombreCurso.setValue(cursoDTO.getNombreCurso());

            if (txtIdCodigoDocente_Docente == null) {
                txtIdCodigoDocente_Docente = new InputText();
            }

            txtIdCodigoDocente_Docente.setValue(cursoDTO.getIdCodigoDocente_Docente());

            if (txtIdCodigoMateria_Materia == null) {
                txtIdCodigoMateria_Materia = new InputText();
            }

            txtIdCodigoMateria_Materia.setValue(cursoDTO.getIdCodigoMateria_Materia());

            if (txtIdPeriodoAcademico_PeriodoAcademico == null) {
                txtIdPeriodoAcademico_PeriodoAcademico = new InputText();
            }

            txtIdPeriodoAcademico_PeriodoAcademico.setValue(cursoDTO.getIdPeriodoAcademico_PeriodoAcademico());

            if (txtIdCurso == null) {
                txtIdCurso = new InputText();
            }

            txtIdCurso.setValue(cursoDTO.getIdCurso());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtNombreCurso != null) {
            txtNombreCurso.setValue(null);
            txtNombreCurso.setDisabled(true);
        }

        if (txtIdCodigoDocente_Docente != null) {
            txtIdCodigoDocente_Docente.setValue(null);
            txtIdCodigoDocente_Docente.setDisabled(true);
        }

        if (txtIdCodigoMateria_Materia != null) {
            txtIdCodigoMateria_Materia.setValue(null);
            txtIdCodigoMateria_Materia.setDisabled(true);
        }

        if (txtIdPeriodoAcademico_PeriodoAcademico != null) {
            txtIdPeriodoAcademico_PeriodoAcademico.setValue(null);
            txtIdPeriodoAcademico_PeriodoAcademico.setDisabled(true);
        }

        if (txtIdCurso != null) {
            txtIdCurso.setValue(null);
            txtIdCurso.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        if (btnModify != null) {
            btnModify.setDisabled(true);
        }

        if (btnClear != null) {
            btnClear.setDisabled(false);
        }

        return "";
    }

    public void listener_txtId() {
        Curso entity = null;

        try {
            Long idCurso = new Long(txtIdCurso.getValue().toString());
            entity = businessDelegatorView.getCurso(idCurso);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtNombreCurso.setDisabled(false);
            txtIdCodigoDocente_Docente.setDisabled(false);
            txtIdCodigoMateria_Materia.setDisabled(false);
            txtIdPeriodoAcademico_PeriodoAcademico.setDisabled(false);
            txtIdCurso.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtNombreCurso.setValue(entity.getNombreCurso());
            txtNombreCurso.setDisabled(false);
            txtIdCodigoDocente_Docente.setValue(entity.getDocente()
                                                      .getIdCodigoDocente());
            txtIdCodigoDocente_Docente.setDisabled(false);
            txtIdCodigoMateria_Materia.setValue(entity.getMateria()
                                                      .getIdCodigoMateria());
            txtIdCodigoMateria_Materia.setDisabled(false);
            txtIdPeriodoAcademico_PeriodoAcademico.setValue(entity.getPeriodoAcademico()
                                                                  .getIdPeriodoAcademico());
            txtIdPeriodoAcademico_PeriodoAcademico.setDisabled(false);
            txtIdCurso.setValue(entity.getIdCurso());
            txtIdCurso.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveCurso(FacesUtils.checkLong(txtIdCurso),
                FacesUtils.checkString(txtNombreCurso),
                FacesUtils.checkLong(txtIdCodigoDocente_Docente),
                FacesUtils.checkLong(txtIdCodigoMateria_Materia),
                FacesUtils.checkLong(txtIdPeriodoAcademico_PeriodoAcademico));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteCurso(FacesUtils.checkLong(txtIdCurso));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateCurso(FacesUtils.checkLong(txtIdCurso),
                FacesUtils.checkString(txtNombreCurso),
                FacesUtils.checkLong(txtIdCodigoDocente_Docente),
                FacesUtils.checkLong(txtIdCodigoMateria_Materia),
                FacesUtils.checkLong(txtIdPeriodoAcademico_PeriodoAcademico));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
            action_clear();
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String actionDeleteDataTableEditable() {
        try {
            if (txtIdCurso == null) {
                txtIdCurso = new InputText();
            }

            txtIdCurso.setValue(selectedCurso.getIdCurso());

            businessDelegatorView.deleteCurso(FacesUtils.checkLong(txtIdCurso));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedCurso);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long idCurso, String nombreCurso,
        Long idCodigoDocente_Docente, Long idCodigoMateria_Materia,
        Long idPeriodoAcademico_PeriodoAcademico) throws Exception {
        try {
            businessDelegatorView.updateCurso(idCurso, nombreCurso,
                idCodigoDocente_Docente, idCodigoMateria_Materia,
                idPeriodoAcademico_PeriodoAcademico);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CursoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreCurso() {
        return txtNombreCurso;
    }

    public void setTxtNombreCurso(InputText txtNombreCurso) {
        this.txtNombreCurso = txtNombreCurso;
    }

    public InputText getTxtIdCodigoDocente_Docente() {
        return txtIdCodigoDocente_Docente;
    }

    public void setTxtIdCodigoDocente_Docente(
        InputText txtIdCodigoDocente_Docente) {
        this.txtIdCodigoDocente_Docente = txtIdCodigoDocente_Docente;
    }

    public InputText getTxtIdCodigoMateria_Materia() {
        return txtIdCodigoMateria_Materia;
    }

    public void setTxtIdCodigoMateria_Materia(
        InputText txtIdCodigoMateria_Materia) {
        this.txtIdCodigoMateria_Materia = txtIdCodigoMateria_Materia;
    }

    public InputText getTxtIdPeriodoAcademico_PeriodoAcademico() {
        return txtIdPeriodoAcademico_PeriodoAcademico;
    }

    public void setTxtIdPeriodoAcademico_PeriodoAcademico(
        InputText txtIdPeriodoAcademico_PeriodoAcademico) {
        this.txtIdPeriodoAcademico_PeriodoAcademico = txtIdPeriodoAcademico_PeriodoAcademico;
    }

    public InputText getTxtIdCurso() {
        return txtIdCurso;
    }

    public void setTxtIdCurso(InputText txtIdCurso) {
        this.txtIdCurso = txtIdCurso;
    }

    public List<CursoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCurso();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CursoDTO> cursoDTO) {
        this.data = cursoDTO;
    }

    public CursoDTO getSelectedCurso() {
        return selectedCurso;
    }

    public void setSelectedCurso(CursoDTO curso) {
        this.selectedCurso = curso;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }
}
