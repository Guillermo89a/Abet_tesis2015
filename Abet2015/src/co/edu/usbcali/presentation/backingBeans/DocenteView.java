package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.DocenteDTO;
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
public class DocenteView {
    private InputText txtNombreDocente;
    private InputText txtIdCodigoDocente;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DocenteDTO> data;
    private DocenteDTO selectedDocente;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public DocenteView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            DocenteDTO docenteDTO = (DocenteDTO) e.getObject();

            if (txtNombreDocente == null) {
                txtNombreDocente = new InputText();
            }

            txtNombreDocente.setValue(docenteDTO.getNombreDocente());

            if (txtIdCodigoDocente == null) {
                txtIdCodigoDocente = new InputText();
            }

            txtIdCodigoDocente.setValue(docenteDTO.getIdCodigoDocente());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtNombreDocente != null) {
            txtNombreDocente.setValue(null);
            txtNombreDocente.setDisabled(true);
        }

        if (txtIdCodigoDocente != null) {
            txtIdCodigoDocente.setValue(null);
            txtIdCodigoDocente.setDisabled(false);
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
        Docente entity = null;

        try {
            Long idCodigoDocente = new Long(txtIdCodigoDocente.getValue()
                                                              .toString());
            entity = businessDelegatorView.getDocente(idCodigoDocente);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtNombreDocente.setDisabled(false);
            txtIdCodigoDocente.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtNombreDocente.setValue(entity.getNombreDocente());
            txtNombreDocente.setDisabled(false);
            txtIdCodigoDocente.setValue(entity.getIdCodigoDocente());
            txtIdCodigoDocente.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveDocente(FacesUtils.checkLong(
                    txtIdCodigoDocente),
                FacesUtils.checkString(txtNombreDocente));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteDocente(FacesUtils.checkLong(
                    txtIdCodigoDocente));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateDocente(FacesUtils.checkLong(
                    txtIdCodigoDocente),
                FacesUtils.checkString(txtNombreDocente));
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
            if (txtIdCodigoDocente == null) {
                txtIdCodigoDocente = new InputText();
            }

            txtIdCodigoDocente.setValue(selectedDocente.getIdCodigoDocente());

            businessDelegatorView.deleteDocente(FacesUtils.checkLong(
                    txtIdCodigoDocente));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedDocente);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long idCodigoDocente, String nombreDocente)
        throws Exception {
        try {
            businessDelegatorView.updateDocente(idCodigoDocente, nombreDocente);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DocenteView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreDocente() {
        return txtNombreDocente;
    }

    public void setTxtNombreDocente(InputText txtNombreDocente) {
        this.txtNombreDocente = txtNombreDocente;
    }

    public InputText getTxtIdCodigoDocente() {
        return txtIdCodigoDocente;
    }

    public void setTxtIdCodigoDocente(InputText txtIdCodigoDocente) {
        this.txtIdCodigoDocente = txtIdCodigoDocente;
    }

    public List<DocenteDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataDocente();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DocenteDTO> docenteDTO) {
        this.data = docenteDTO;
    }

    public DocenteDTO getSelectedDocente() {
        return selectedDocente;
    }

    public void setSelectedDocente(DocenteDTO docente) {
        this.selectedDocente = docente;
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
