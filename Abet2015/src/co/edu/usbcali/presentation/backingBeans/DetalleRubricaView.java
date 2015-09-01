package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.DetalleRubricaDTO;
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
public class DetalleRubricaView {
    private InputText txtIdRubrica_Rubrica;
    private InputText txtIdDetalleRubrica;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DetalleRubricaDTO> data;
    private DetalleRubricaDTO selectedDetalleRubrica;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public DetalleRubricaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            DetalleRubricaDTO detalleRubricaDTO = (DetalleRubricaDTO) e.getObject();

            if (txtIdRubrica_Rubrica == null) {
                txtIdRubrica_Rubrica = new InputText();
            }

            txtIdRubrica_Rubrica.setValue(detalleRubricaDTO.getIdRubrica_Rubrica());

            if (txtIdDetalleRubrica == null) {
                txtIdDetalleRubrica = new InputText();
            }

            txtIdDetalleRubrica.setValue(detalleRubricaDTO.getIdDetalleRubrica());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtIdRubrica_Rubrica != null) {
            txtIdRubrica_Rubrica.setValue(null);
            txtIdRubrica_Rubrica.setDisabled(true);
        }

        if (txtIdDetalleRubrica != null) {
            txtIdDetalleRubrica.setValue(null);
            txtIdDetalleRubrica.setDisabled(false);
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
        DetalleRubrica entity = null;

        try {
            Long idDetalleRubrica = new Long(txtIdDetalleRubrica.getValue()
                                                                .toString());
            entity = businessDelegatorView.getDetalleRubrica(idDetalleRubrica);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtIdRubrica_Rubrica.setDisabled(false);
            txtIdDetalleRubrica.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtIdRubrica_Rubrica.setValue(entity.getRubrica().getIdRubrica());
            txtIdRubrica_Rubrica.setDisabled(false);
            txtIdDetalleRubrica.setValue(entity.getIdDetalleRubrica());
            txtIdDetalleRubrica.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveDetalleRubrica(FacesUtils.checkLong(
                    txtIdDetalleRubrica),
                FacesUtils.checkLong(txtIdRubrica_Rubrica));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteDetalleRubrica(FacesUtils.checkLong(
                    txtIdDetalleRubrica));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateDetalleRubrica(FacesUtils.checkLong(
                    txtIdDetalleRubrica),
                FacesUtils.checkLong(txtIdRubrica_Rubrica));
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
            if (txtIdDetalleRubrica == null) {
                txtIdDetalleRubrica = new InputText();
            }

            txtIdDetalleRubrica.setValue(selectedDetalleRubrica.getIdDetalleRubrica());

            businessDelegatorView.deleteDetalleRubrica(FacesUtils.checkLong(
                    txtIdDetalleRubrica));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedDetalleRubrica);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long idDetalleRubrica,
        Long idRubrica_Rubrica) throws Exception {
        try {
            businessDelegatorView.updateDetalleRubrica(idDetalleRubrica,
                idRubrica_Rubrica);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DetalleRubricaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtIdRubrica_Rubrica() {
        return txtIdRubrica_Rubrica;
    }

    public void setTxtIdRubrica_Rubrica(InputText txtIdRubrica_Rubrica) {
        this.txtIdRubrica_Rubrica = txtIdRubrica_Rubrica;
    }

    public InputText getTxtIdDetalleRubrica() {
        return txtIdDetalleRubrica;
    }

    public void setTxtIdDetalleRubrica(InputText txtIdDetalleRubrica) {
        this.txtIdDetalleRubrica = txtIdDetalleRubrica;
    }

    public List<DetalleRubricaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataDetalleRubrica();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DetalleRubricaDTO> detalleRubricaDTO) {
        this.data = detalleRubricaDTO;
    }

    public DetalleRubricaDTO getSelectedDetalleRubrica() {
        return selectedDetalleRubrica;
    }

    public void setSelectedDetalleRubrica(DetalleRubricaDTO detalleRubrica) {
        this.selectedDetalleRubrica = detalleRubrica;
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
