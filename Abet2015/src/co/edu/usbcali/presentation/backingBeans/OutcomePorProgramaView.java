package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.OutcomePorProgramaDTO;
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
public class OutcomePorProgramaView {
    private InputText txtIdOutcome_Outcome;
    private InputText txtIdPrograma_Programa;
    private InputText txtIdOutcomePorPrograma;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<OutcomePorProgramaDTO> data;
    private OutcomePorProgramaDTO selectedOutcomePorPrograma;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public OutcomePorProgramaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            OutcomePorProgramaDTO outcomePorProgramaDTO = (OutcomePorProgramaDTO) e.getObject();

            if (txtIdOutcome_Outcome == null) {
                txtIdOutcome_Outcome = new InputText();
            }

            txtIdOutcome_Outcome.setValue(outcomePorProgramaDTO.getIdOutcome_Outcome());

            if (txtIdPrograma_Programa == null) {
                txtIdPrograma_Programa = new InputText();
            }

            txtIdPrograma_Programa.setValue(outcomePorProgramaDTO.getIdPrograma_Programa());

            if (txtIdOutcomePorPrograma == null) {
                txtIdOutcomePorPrograma = new InputText();
            }

            txtIdOutcomePorPrograma.setValue(outcomePorProgramaDTO.getIdOutcomePorPrograma());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtIdOutcome_Outcome != null) {
            txtIdOutcome_Outcome.setValue(null);
            txtIdOutcome_Outcome.setDisabled(true);
        }

        if (txtIdPrograma_Programa != null) {
            txtIdPrograma_Programa.setValue(null);
            txtIdPrograma_Programa.setDisabled(true);
        }

        if (txtIdOutcomePorPrograma != null) {
            txtIdOutcomePorPrograma.setValue(null);
            txtIdOutcomePorPrograma.setDisabled(false);
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
        OutcomePorPrograma entity = null;

        try {
            Long idOutcomePorPrograma = new Long(txtIdOutcomePorPrograma.getValue()
                                                                        .toString());
            entity = businessDelegatorView.getOutcomePorPrograma(idOutcomePorPrograma);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtIdOutcome_Outcome.setDisabled(false);
            txtIdPrograma_Programa.setDisabled(false);
            txtIdOutcomePorPrograma.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtIdOutcome_Outcome.setValue(entity.getOutcome().getIdOutcome());
            txtIdOutcome_Outcome.setDisabled(false);
            txtIdPrograma_Programa.setValue(entity.getPrograma().getIdPrograma());
            txtIdPrograma_Programa.setDisabled(false);
            txtIdOutcomePorPrograma.setValue(entity.getIdOutcomePorPrograma());
            txtIdOutcomePorPrograma.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveOutcomePorPrograma(FacesUtils.checkLong(
                    txtIdOutcomePorPrograma),
                FacesUtils.checkLong(txtIdOutcome_Outcome),
                FacesUtils.checkLong(txtIdPrograma_Programa));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteOutcomePorPrograma(FacesUtils.checkLong(
                    txtIdOutcomePorPrograma));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateOutcomePorPrograma(FacesUtils.checkLong(
                    txtIdOutcomePorPrograma),
                FacesUtils.checkLong(txtIdOutcome_Outcome),
                FacesUtils.checkLong(txtIdPrograma_Programa));
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
            if (txtIdOutcomePorPrograma == null) {
                txtIdOutcomePorPrograma = new InputText();
            }

            txtIdOutcomePorPrograma.setValue(selectedOutcomePorPrograma.getIdOutcomePorPrograma());

            businessDelegatorView.deleteOutcomePorPrograma(FacesUtils.checkLong(
                    txtIdOutcomePorPrograma));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedOutcomePorPrograma);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long idOutcomePorPrograma,
        Long idOutcome_Outcome, Long idPrograma_Programa)
        throws Exception {
        try {
            businessDelegatorView.updateOutcomePorPrograma(idOutcomePorPrograma,
                idOutcome_Outcome, idPrograma_Programa);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("OutcomePorProgramaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtIdOutcome_Outcome() {
        return txtIdOutcome_Outcome;
    }

    public void setTxtIdOutcome_Outcome(InputText txtIdOutcome_Outcome) {
        this.txtIdOutcome_Outcome = txtIdOutcome_Outcome;
    }

    public InputText getTxtIdPrograma_Programa() {
        return txtIdPrograma_Programa;
    }

    public void setTxtIdPrograma_Programa(InputText txtIdPrograma_Programa) {
        this.txtIdPrograma_Programa = txtIdPrograma_Programa;
    }

    public InputText getTxtIdOutcomePorPrograma() {
        return txtIdOutcomePorPrograma;
    }

    public void setTxtIdOutcomePorPrograma(InputText txtIdOutcomePorPrograma) {
        this.txtIdOutcomePorPrograma = txtIdOutcomePorPrograma;
    }

    public List<OutcomePorProgramaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataOutcomePorPrograma();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<OutcomePorProgramaDTO> outcomePorProgramaDTO) {
        this.data = outcomePorProgramaDTO;
    }

    public OutcomePorProgramaDTO getSelectedOutcomePorPrograma() {
        return selectedOutcomePorPrograma;
    }

    public void setSelectedOutcomePorPrograma(
        OutcomePorProgramaDTO outcomePorPrograma) {
        this.selectedOutcomePorPrograma = outcomePorPrograma;
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
