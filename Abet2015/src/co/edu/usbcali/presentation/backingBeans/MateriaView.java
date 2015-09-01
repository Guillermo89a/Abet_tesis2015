package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.MateriaDTO;
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
public class MateriaView {
    private InputText txtCreditos;
    private InputText txtNombre;
    private InputText txtIdCodigoMateria;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<MateriaDTO> data;
    private MateriaDTO selectedMateria;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public MateriaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            MateriaDTO materiaDTO = (MateriaDTO) e.getObject();

            if (txtCreditos == null) {
                txtCreditos = new InputText();
            }

            txtCreditos.setValue(materiaDTO.getCreditos());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(materiaDTO.getNombre());

            if (txtIdCodigoMateria == null) {
                txtIdCodigoMateria = new InputText();
            }

            txtIdCodigoMateria.setValue(materiaDTO.getIdCodigoMateria());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtCreditos != null) {
            txtCreditos.setValue(null);
            txtCreditos.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtIdCodigoMateria != null) {
            txtIdCodigoMateria.setValue(null);
            txtIdCodigoMateria.setDisabled(false);
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
        Materia entity = null;

        try {
            Long idCodigoMateria = new Long(txtIdCodigoMateria.getValue()
                                                              .toString());
            entity = businessDelegatorView.getMateria(idCodigoMateria);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtCreditos.setDisabled(false);
            txtNombre.setDisabled(false);
            txtIdCodigoMateria.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtCreditos.setValue(entity.getCreditos());
            txtCreditos.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtIdCodigoMateria.setValue(entity.getIdCodigoMateria());
            txtIdCodigoMateria.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveMateria(FacesUtils.checkString(
                    txtCreditos), FacesUtils.checkLong(txtIdCodigoMateria),
                FacesUtils.checkString(txtNombre));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteMateria(FacesUtils.checkLong(
                    txtIdCodigoMateria));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateMateria(FacesUtils.checkString(
                    txtCreditos), FacesUtils.checkLong(txtIdCodigoMateria),
                FacesUtils.checkString(txtNombre));
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
            if (txtIdCodigoMateria == null) {
                txtIdCodigoMateria = new InputText();
            }

            txtIdCodigoMateria.setValue(selectedMateria.getIdCodigoMateria());

            businessDelegatorView.deleteMateria(FacesUtils.checkLong(
                    txtIdCodigoMateria));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedMateria);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String creditos, Long idCodigoMateria,
        String nombre) throws Exception {
        try {
            businessDelegatorView.updateMateria(creditos, idCodigoMateria,
                nombre);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("MateriaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCreditos() {
        return txtCreditos;
    }

    public void setTxtCreditos(InputText txtCreditos) {
        this.txtCreditos = txtCreditos;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtIdCodigoMateria() {
        return txtIdCodigoMateria;
    }

    public void setTxtIdCodigoMateria(InputText txtIdCodigoMateria) {
        this.txtIdCodigoMateria = txtIdCodigoMateria;
    }

    public List<MateriaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataMateria();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<MateriaDTO> materiaDTO) {
        this.data = materiaDTO;
    }

    public MateriaDTO getSelectedMateria() {
        return selectedMateria;
    }

    public void setSelectedMateria(MateriaDTO materia) {
        this.selectedMateria = materia;
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
