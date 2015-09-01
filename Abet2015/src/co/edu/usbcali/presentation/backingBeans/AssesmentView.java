package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.AssesmentDTO;
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
public class AssesmentView {
    private InputText txtCalificacion;
    private InputText txtIdListaSepia_ListaSepia;
    private InputText txtIdRubricaPorCurso_RubricaPorCurso;
    private InputText txtIdCodigoAssesment;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<AssesmentDTO> data;
    private AssesmentDTO selectedAssesment;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public AssesmentView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            AssesmentDTO assesmentDTO = (AssesmentDTO) e.getObject();

            if (txtCalificacion == null) {
                txtCalificacion = new InputText();
            }

            txtCalificacion.setValue(assesmentDTO.getCalificacion());

            if (txtIdListaSepia_ListaSepia == null) {
                txtIdListaSepia_ListaSepia = new InputText();
            }

            txtIdListaSepia_ListaSepia.setValue(assesmentDTO.getIdListaSepia_ListaSepia());

            if (txtIdRubricaPorCurso_RubricaPorCurso == null) {
                txtIdRubricaPorCurso_RubricaPorCurso = new InputText();
            }

            txtIdRubricaPorCurso_RubricaPorCurso.setValue(assesmentDTO.getIdRubricaPorCurso_RubricaPorCurso());

            if (txtIdCodigoAssesment == null) {
                txtIdCodigoAssesment = new InputText();
            }

            txtIdCodigoAssesment.setValue(assesmentDTO.getIdCodigoAssesment());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtCalificacion != null) {
            txtCalificacion.setValue(null);
            txtCalificacion.setDisabled(true);
        }

        if (txtIdListaSepia_ListaSepia != null) {
            txtIdListaSepia_ListaSepia.setValue(null);
            txtIdListaSepia_ListaSepia.setDisabled(true);
        }

        if (txtIdRubricaPorCurso_RubricaPorCurso != null) {
            txtIdRubricaPorCurso_RubricaPorCurso.setValue(null);
            txtIdRubricaPorCurso_RubricaPorCurso.setDisabled(true);
        }

        if (txtIdCodigoAssesment != null) {
            txtIdCodigoAssesment.setValue(null);
            txtIdCodigoAssesment.setDisabled(false);
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
        Assesment entity = null;

        try {
            Long idCodigoAssesment = new Long(txtIdCodigoAssesment.getValue()
                                                                  .toString());
            entity = businessDelegatorView.getAssesment(idCodigoAssesment);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtCalificacion.setDisabled(false);
            txtIdListaSepia_ListaSepia.setDisabled(false);
            txtIdRubricaPorCurso_RubricaPorCurso.setDisabled(false);
            txtIdCodigoAssesment.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtCalificacion.setValue(entity.getCalificacion());
            txtCalificacion.setDisabled(false);
            txtIdListaSepia_ListaSepia.setValue(entity.getListaSepia()
                                                      .getIdListaSepia());
            txtIdListaSepia_ListaSepia.setDisabled(false);
            txtIdRubricaPorCurso_RubricaPorCurso.setValue(entity.getRubricaPorCurso()
                                                                .getIdRubricaPorCurso());
            txtIdRubricaPorCurso_RubricaPorCurso.setDisabled(false);
            txtIdCodigoAssesment.setValue(entity.getIdCodigoAssesment());
            txtIdCodigoAssesment.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveAssesment(FacesUtils.checkLong(
                    txtCalificacion),
                FacesUtils.checkLong(txtIdCodigoAssesment),
                FacesUtils.checkLong(txtIdListaSepia_ListaSepia),
                FacesUtils.checkLong(txtIdRubricaPorCurso_RubricaPorCurso));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteAssesment(FacesUtils.checkLong(
                    txtIdCodigoAssesment));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateAssesment(FacesUtils.checkLong(
                    txtCalificacion),
                FacesUtils.checkLong(txtIdCodigoAssesment),
                FacesUtils.checkLong(txtIdListaSepia_ListaSepia),
                FacesUtils.checkLong(txtIdRubricaPorCurso_RubricaPorCurso));
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
            if (txtIdCodigoAssesment == null) {
                txtIdCodigoAssesment = new InputText();
            }

            txtIdCodigoAssesment.setValue(selectedAssesment.getIdCodigoAssesment());

            businessDelegatorView.deleteAssesment(FacesUtils.checkLong(
                    txtIdCodigoAssesment));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedAssesment);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long calificacion,
        Long idCodigoAssesment, Long idListaSepia_ListaSepia,
        Long idRubricaPorCurso_RubricaPorCurso) throws Exception {
        try {
            businessDelegatorView.updateAssesment(calificacion,
                idCodigoAssesment, idListaSepia_ListaSepia,
                idRubricaPorCurso_RubricaPorCurso);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("AssesmentView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCalificacion() {
        return txtCalificacion;
    }

    public void setTxtCalificacion(InputText txtCalificacion) {
        this.txtCalificacion = txtCalificacion;
    }

    public InputText getTxtIdListaSepia_ListaSepia() {
        return txtIdListaSepia_ListaSepia;
    }

    public void setTxtIdListaSepia_ListaSepia(
        InputText txtIdListaSepia_ListaSepia) {
        this.txtIdListaSepia_ListaSepia = txtIdListaSepia_ListaSepia;
    }

    public InputText getTxtIdRubricaPorCurso_RubricaPorCurso() {
        return txtIdRubricaPorCurso_RubricaPorCurso;
    }

    public void setTxtIdRubricaPorCurso_RubricaPorCurso(
        InputText txtIdRubricaPorCurso_RubricaPorCurso) {
        this.txtIdRubricaPorCurso_RubricaPorCurso = txtIdRubricaPorCurso_RubricaPorCurso;
    }

    public InputText getTxtIdCodigoAssesment() {
        return txtIdCodigoAssesment;
    }

    public void setTxtIdCodigoAssesment(InputText txtIdCodigoAssesment) {
        this.txtIdCodigoAssesment = txtIdCodigoAssesment;
    }

    public List<AssesmentDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataAssesment();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<AssesmentDTO> assesmentDTO) {
        this.data = assesmentDTO;
    }

    public AssesmentDTO getSelectedAssesment() {
        return selectedAssesment;
    }

    public void setSelectedAssesment(AssesmentDTO assesment) {
        this.selectedAssesment = assesment;
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
