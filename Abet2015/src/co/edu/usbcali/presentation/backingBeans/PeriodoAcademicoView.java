package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.PeriodoAcademicoDTO;
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
public class PeriodoAcademicoView {
    private InputText txtDescripcionPeriodo;
    private InputText txtIdPeriodoAcademico;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PeriodoAcademicoDTO> data;
    private PeriodoAcademicoDTO selectedPeriodoAcademico;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public PeriodoAcademicoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            PeriodoAcademicoDTO periodoAcademicoDTO = (PeriodoAcademicoDTO) e.getObject();

            if (txtDescripcionPeriodo == null) {
                txtDescripcionPeriodo = new InputText();
            }

            txtDescripcionPeriodo.setValue(periodoAcademicoDTO.getDescripcionPeriodo());

            if (txtIdPeriodoAcademico == null) {
                txtIdPeriodoAcademico = new InputText();
            }

            txtIdPeriodoAcademico.setValue(periodoAcademicoDTO.getIdPeriodoAcademico());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtDescripcionPeriodo != null) {
            txtDescripcionPeriodo.setValue(null);
            txtDescripcionPeriodo.setDisabled(true);
        }

        if (txtIdPeriodoAcademico != null) {
            txtIdPeriodoAcademico.setValue(null);
            txtIdPeriodoAcademico.setDisabled(false);
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
        PeriodoAcademico entity = null;

        try {
            Long idPeriodoAcademico = new Long(txtIdPeriodoAcademico.getValue()
                                                                    .toString());
            entity = businessDelegatorView.getPeriodoAcademico(idPeriodoAcademico);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtDescripcionPeriodo.setDisabled(false);
            txtIdPeriodoAcademico.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtDescripcionPeriodo.setValue(entity.getDescripcionPeriodo());
            txtDescripcionPeriodo.setDisabled(false);
            txtIdPeriodoAcademico.setValue(entity.getIdPeriodoAcademico());
            txtIdPeriodoAcademico.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.savePeriodoAcademico(FacesUtils.checkString(
                    txtDescripcionPeriodo),
                FacesUtils.checkLong(txtIdPeriodoAcademico));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deletePeriodoAcademico(FacesUtils.checkLong(
                    txtIdPeriodoAcademico));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updatePeriodoAcademico(FacesUtils.checkString(
                    txtDescripcionPeriodo),
                FacesUtils.checkLong(txtIdPeriodoAcademico));
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
            if (txtIdPeriodoAcademico == null) {
                txtIdPeriodoAcademico = new InputText();
            }

            txtIdPeriodoAcademico.setValue(selectedPeriodoAcademico.getIdPeriodoAcademico());

            businessDelegatorView.deletePeriodoAcademico(FacesUtils.checkLong(
                    txtIdPeriodoAcademico));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedPeriodoAcademico);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String descripcionPeriodo,
        Long idPeriodoAcademico) throws Exception {
        try {
            businessDelegatorView.updatePeriodoAcademico(descripcionPeriodo,
                idPeriodoAcademico);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PeriodoAcademicoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDescripcionPeriodo() {
        return txtDescripcionPeriodo;
    }

    public void setTxtDescripcionPeriodo(InputText txtDescripcionPeriodo) {
        this.txtDescripcionPeriodo = txtDescripcionPeriodo;
    }

    public InputText getTxtIdPeriodoAcademico() {
        return txtIdPeriodoAcademico;
    }

    public void setTxtIdPeriodoAcademico(InputText txtIdPeriodoAcademico) {
        this.txtIdPeriodoAcademico = txtIdPeriodoAcademico;
    }

    public List<PeriodoAcademicoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPeriodoAcademico();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<PeriodoAcademicoDTO> periodoAcademicoDTO) {
        this.data = periodoAcademicoDTO;
    }

    public PeriodoAcademicoDTO getSelectedPeriodoAcademico() {
        return selectedPeriodoAcademico;
    }

    public void setSelectedPeriodoAcademico(
        PeriodoAcademicoDTO periodoAcademico) {
        this.selectedPeriodoAcademico = periodoAcademico;
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
