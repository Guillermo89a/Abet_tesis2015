package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.ProgramaDTO;
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
public class ProgramaView {
    private InputText txtDescripcion;
    private InputText txtIdPrograma;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ProgramaDTO> data;
    private ProgramaDTO selectedPrograma;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public ProgramaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ProgramaDTO programaDTO = (ProgramaDTO) e.getObject();

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(programaDTO.getDescripcion());

            if (txtIdPrograma == null) {
                txtIdPrograma = new InputText();
            }

            txtIdPrograma.setValue(programaDTO.getIdPrograma());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtIdPrograma != null) {
            txtIdPrograma.setValue(null);
            txtIdPrograma.setDisabled(false);
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
        Programa entity = null;

        try {
            Long idPrograma = new Long(txtIdPrograma.getValue().toString());
            entity = businessDelegatorView.getPrograma(idPrograma);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtIdPrograma.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtIdPrograma.setValue(entity.getIdPrograma());
            txtIdPrograma.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.savePrograma(FacesUtils.checkString(
                    txtDescripcion), FacesUtils.checkLong(txtIdPrograma));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deletePrograma(FacesUtils.checkLong(
                    txtIdPrograma));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updatePrograma(FacesUtils.checkString(
                    txtDescripcion), FacesUtils.checkLong(txtIdPrograma));
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
            if (txtIdPrograma == null) {
                txtIdPrograma = new InputText();
            }

            txtIdPrograma.setValue(selectedPrograma.getIdPrograma());

            businessDelegatorView.deletePrograma(FacesUtils.checkLong(
                    txtIdPrograma));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedPrograma);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String descripcion, Long idPrograma)
        throws Exception {
        try {
            businessDelegatorView.updatePrograma(descripcion, idPrograma);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ProgramaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtIdPrograma() {
        return txtIdPrograma;
    }

    public void setTxtIdPrograma(InputText txtIdPrograma) {
        this.txtIdPrograma = txtIdPrograma;
    }

    public List<ProgramaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPrograma();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ProgramaDTO> programaDTO) {
        this.data = programaDTO;
    }

    public ProgramaDTO getSelectedPrograma() {
        return selectedPrograma;
    }

    public void setSelectedPrograma(ProgramaDTO programa) {
        this.selectedPrograma = programa;
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
