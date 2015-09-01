package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.OutcomeDTO;
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
public class OutcomeView {
    private InputText txtDetalle;
    private InputText txtIdOutcome;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<OutcomeDTO> data;
    private OutcomeDTO selectedOutcome;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public OutcomeView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            OutcomeDTO outcomeDTO = (OutcomeDTO) e.getObject();

            if (txtDetalle == null) {
                txtDetalle = new InputText();
            }

            txtDetalle.setValue(outcomeDTO.getDetalle());

            if (txtIdOutcome == null) {
                txtIdOutcome = new InputText();
            }

            txtIdOutcome.setValue(outcomeDTO.getIdOutcome());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtDetalle != null) {
            txtDetalle.setValue(null);
            txtDetalle.setDisabled(true);
        }

        if (txtIdOutcome != null) {
            txtIdOutcome.setValue(null);
            txtIdOutcome.setDisabled(false);
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
        Outcome entity = null;

        try {
            Long idOutcome = new Long(txtIdOutcome.getValue().toString());
            entity = businessDelegatorView.getOutcome(idOutcome);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtDetalle.setDisabled(false);
            txtIdOutcome.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtDetalle.setValue(entity.getDetalle());
            txtDetalle.setDisabled(false);
            txtIdOutcome.setValue(entity.getIdOutcome());
            txtIdOutcome.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveOutcome(FacesUtils.checkString(txtDetalle),
                FacesUtils.checkLong(txtIdOutcome));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteOutcome(FacesUtils.checkLong(
                    txtIdOutcome));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateOutcome(FacesUtils.checkString(
                    txtDetalle), FacesUtils.checkLong(txtIdOutcome));
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
            if (txtIdOutcome == null) {
                txtIdOutcome = new InputText();
            }

            txtIdOutcome.setValue(selectedOutcome.getIdOutcome());

            businessDelegatorView.deleteOutcome(FacesUtils.checkLong(
                    txtIdOutcome));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedOutcome);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String detalle, Long idOutcome)
        throws Exception {
        try {
            businessDelegatorView.updateOutcome(detalle, idOutcome);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("OutcomeView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDetalle() {
        return txtDetalle;
    }

    public void setTxtDetalle(InputText txtDetalle) {
        this.txtDetalle = txtDetalle;
    }

    public InputText getTxtIdOutcome() {
        return txtIdOutcome;
    }

    public void setTxtIdOutcome(InputText txtIdOutcome) {
        this.txtIdOutcome = txtIdOutcome;
    }

    public List<OutcomeDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataOutcome();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<OutcomeDTO> outcomeDTO) {
        this.data = outcomeDTO;
    }

    public OutcomeDTO getSelectedOutcome() {
        return selectedOutcome;
    }

    public void setSelectedOutcome(OutcomeDTO outcome) {
        this.selectedOutcome = outcome;
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
