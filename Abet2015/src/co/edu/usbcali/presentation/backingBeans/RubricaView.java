package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.RubricaDTO;
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
public class RubricaView {
    private InputText txtNombreRubrica;
    private InputText txtIdRubrica;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RubricaDTO> data;
    private RubricaDTO selectedRubrica;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public RubricaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            RubricaDTO rubricaDTO = (RubricaDTO) e.getObject();

            if (txtNombreRubrica == null) {
                txtNombreRubrica = new InputText();
            }

            txtNombreRubrica.setValue(rubricaDTO.getNombreRubrica());

            if (txtIdRubrica == null) {
                txtIdRubrica = new InputText();
            }

            txtIdRubrica.setValue(rubricaDTO.getIdRubrica());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtNombreRubrica != null) {
            txtNombreRubrica.setValue(null);
            txtNombreRubrica.setDisabled(true);
        }

        if (txtIdRubrica != null) {
            txtIdRubrica.setValue(null);
            txtIdRubrica.setDisabled(false);
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
        Rubrica entity = null;

        try {
            Long idRubrica = new Long(txtIdRubrica.getValue().toString());
            entity = businessDelegatorView.getRubrica(idRubrica);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtNombreRubrica.setDisabled(false);
            txtIdRubrica.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtNombreRubrica.setValue(entity.getNombreRubrica());
            txtNombreRubrica.setDisabled(false);
            txtIdRubrica.setValue(entity.getIdRubrica());
            txtIdRubrica.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveRubrica(FacesUtils.checkLong(txtIdRubrica),
                FacesUtils.checkString(txtNombreRubrica));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteRubrica(FacesUtils.checkLong(
                    txtIdRubrica));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateRubrica(FacesUtils.checkLong(
                    txtIdRubrica), FacesUtils.checkString(txtNombreRubrica));
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
            if (txtIdRubrica == null) {
                txtIdRubrica = new InputText();
            }

            txtIdRubrica.setValue(selectedRubrica.getIdRubrica());

            businessDelegatorView.deleteRubrica(FacesUtils.checkLong(
                    txtIdRubrica));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedRubrica);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long idRubrica, String nombreRubrica)
        throws Exception {
        try {
            businessDelegatorView.updateRubrica(idRubrica, nombreRubrica);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RubricaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreRubrica() {
        return txtNombreRubrica;
    }

    public void setTxtNombreRubrica(InputText txtNombreRubrica) {
        this.txtNombreRubrica = txtNombreRubrica;
    }

    public InputText getTxtIdRubrica() {
        return txtIdRubrica;
    }

    public void setTxtIdRubrica(InputText txtIdRubrica) {
        this.txtIdRubrica = txtIdRubrica;
    }

    public List<RubricaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRubrica();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RubricaDTO> rubricaDTO) {
        this.data = rubricaDTO;
    }

    public RubricaDTO getSelectedRubrica() {
        return selectedRubrica;
    }

    public void setSelectedRubrica(RubricaDTO rubrica) {
        this.selectedRubrica = rubrica;
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
