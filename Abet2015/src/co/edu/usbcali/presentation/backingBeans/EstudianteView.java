package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.EstudianteDTO;
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
public class EstudianteView {
    private InputText txtDireccion;
    private InputText txtEmail;
    private InputText txtNombre;
    private InputText txtTelefono;
    private InputText txtIdCodigoEstudiante;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<EstudianteDTO> data;
    private EstudianteDTO selectedEstudiante;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public EstudianteView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            EstudianteDTO estudianteDTO = (EstudianteDTO) e.getObject();

            if (txtDireccion == null) {
                txtDireccion = new InputText();
            }

            txtDireccion.setValue(estudianteDTO.getDireccion());

            if (txtEmail == null) {
                txtEmail = new InputText();
            }

            txtEmail.setValue(estudianteDTO.getEmail());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(estudianteDTO.getNombre());

            if (txtTelefono == null) {
                txtTelefono = new InputText();
            }

            txtTelefono.setValue(estudianteDTO.getTelefono());

            if (txtIdCodigoEstudiante == null) {
                txtIdCodigoEstudiante = new InputText();
            }

            txtIdCodigoEstudiante.setValue(estudianteDTO.getIdCodigoEstudiante());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtDireccion != null) {
            txtDireccion.setValue(null);
            txtDireccion.setDisabled(true);
        }

        if (txtEmail != null) {
            txtEmail.setValue(null);
            txtEmail.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtTelefono != null) {
            txtTelefono.setValue(null);
            txtTelefono.setDisabled(true);
        }

        if (txtIdCodigoEstudiante != null) {
            txtIdCodigoEstudiante.setValue(null);
            txtIdCodigoEstudiante.setDisabled(false);
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
        Estudiante entity = null;

        try {
            Long idCodigoEstudiante = new Long(txtIdCodigoEstudiante.getValue()
                                                                    .toString());
            entity = businessDelegatorView.getEstudiante(idCodigoEstudiante);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtDireccion.setDisabled(false);
            txtEmail.setDisabled(false);
            txtNombre.setDisabled(false);
            txtTelefono.setDisabled(false);
            txtIdCodigoEstudiante.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtDireccion.setValue(entity.getDireccion());
            txtDireccion.setDisabled(false);
            txtEmail.setValue(entity.getEmail());
            txtEmail.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtTelefono.setValue(entity.getTelefono());
            txtTelefono.setDisabled(false);
            txtIdCodigoEstudiante.setValue(entity.getIdCodigoEstudiante());
            txtIdCodigoEstudiante.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveEstudiante(FacesUtils.checkString(
                    txtDireccion), FacesUtils.checkString(txtEmail),
                FacesUtils.checkLong(txtIdCodigoEstudiante),
                FacesUtils.checkString(txtNombre),
                FacesUtils.checkString(txtTelefono));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteEstudiante(FacesUtils.checkLong(
                    txtIdCodigoEstudiante));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateEstudiante(FacesUtils.checkString(
                    txtDireccion), FacesUtils.checkString(txtEmail),
                FacesUtils.checkLong(txtIdCodigoEstudiante),
                FacesUtils.checkString(txtNombre),
                FacesUtils.checkString(txtTelefono));
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
            if (txtIdCodigoEstudiante == null) {
                txtIdCodigoEstudiante = new InputText();
            }

            txtIdCodigoEstudiante.setValue(selectedEstudiante.getIdCodigoEstudiante());

            businessDelegatorView.deleteEstudiante(FacesUtils.checkLong(
                    txtIdCodigoEstudiante));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedEstudiante);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String direccion, String email,
        Long idCodigoEstudiante, String nombre, String telefono)
        throws Exception {
        try {
            businessDelegatorView.updateEstudiante(direccion, email,
                idCodigoEstudiante, nombre, telefono);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("EstudianteView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(InputText txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public InputText getTxtIdCodigoEstudiante() {
        return txtIdCodigoEstudiante;
    }

    public void setTxtIdCodigoEstudiante(InputText txtIdCodigoEstudiante) {
        this.txtIdCodigoEstudiante = txtIdCodigoEstudiante;
    }

    public List<EstudianteDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataEstudiante();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<EstudianteDTO> estudianteDTO) {
        this.data = estudianteDTO;
    }

    public EstudianteDTO getSelectedEstudiante() {
        return selectedEstudiante;
    }

    public void setSelectedEstudiante(EstudianteDTO estudiante) {
        this.selectedEstudiante = estudiante;
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
