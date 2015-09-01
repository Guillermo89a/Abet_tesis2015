package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.ListaSepiaDTO;
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
public class ListaSepiaView {
    private InputText txtIdCurso_Curso;
    private InputText txtIdCodigoEstudiante_Estudiante;
    private InputText txtIdListaSepia;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ListaSepiaDTO> data;
    private ListaSepiaDTO selectedListaSepia;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public ListaSepiaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ListaSepiaDTO listaSepiaDTO = (ListaSepiaDTO) e.getObject();

            if (txtIdCurso_Curso == null) {
                txtIdCurso_Curso = new InputText();
            }

            txtIdCurso_Curso.setValue(listaSepiaDTO.getIdCurso_Curso());

            if (txtIdCodigoEstudiante_Estudiante == null) {
                txtIdCodigoEstudiante_Estudiante = new InputText();
            }

            txtIdCodigoEstudiante_Estudiante.setValue(listaSepiaDTO.getIdCodigoEstudiante_Estudiante());

            if (txtIdListaSepia == null) {
                txtIdListaSepia = new InputText();
            }

            txtIdListaSepia.setValue(listaSepiaDTO.getIdListaSepia());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtIdCurso_Curso != null) {
            txtIdCurso_Curso.setValue(null);
            txtIdCurso_Curso.setDisabled(true);
        }

        if (txtIdCodigoEstudiante_Estudiante != null) {
            txtIdCodigoEstudiante_Estudiante.setValue(null);
            txtIdCodigoEstudiante_Estudiante.setDisabled(true);
        }

        if (txtIdListaSepia != null) {
            txtIdListaSepia.setValue(null);
            txtIdListaSepia.setDisabled(false);
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
        ListaSepia entity = null;

        try {
            Long idListaSepia = new Long(txtIdListaSepia.getValue().toString());
            entity = businessDelegatorView.getListaSepia(idListaSepia);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtIdCurso_Curso.setDisabled(false);
            txtIdCodigoEstudiante_Estudiante.setDisabled(false);
            txtIdListaSepia.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtIdCurso_Curso.setValue(entity.getCurso().getIdCurso());
            txtIdCurso_Curso.setDisabled(false);
            txtIdCodigoEstudiante_Estudiante.setValue(entity.getEstudiante()
                                                            .getIdCodigoEstudiante());
            txtIdCodigoEstudiante_Estudiante.setDisabled(false);
            txtIdListaSepia.setValue(entity.getIdListaSepia());
            txtIdListaSepia.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveListaSepia(FacesUtils.checkLong(
                    txtIdListaSepia), FacesUtils.checkLong(txtIdCurso_Curso),
                FacesUtils.checkLong(txtIdCodigoEstudiante_Estudiante));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteListaSepia(FacesUtils.checkLong(
                    txtIdListaSepia));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateListaSepia(FacesUtils.checkLong(
                    txtIdListaSepia), FacesUtils.checkLong(txtIdCurso_Curso),
                FacesUtils.checkLong(txtIdCodigoEstudiante_Estudiante));
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
            if (txtIdListaSepia == null) {
                txtIdListaSepia = new InputText();
            }

            txtIdListaSepia.setValue(selectedListaSepia.getIdListaSepia());

            businessDelegatorView.deleteListaSepia(FacesUtils.checkLong(
                    txtIdListaSepia));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedListaSepia);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long idListaSepia, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante) throws Exception {
        try {
            businessDelegatorView.updateListaSepia(idListaSepia, idCurso_Curso,
                idCodigoEstudiante_Estudiante);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ListaSepiaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtIdCurso_Curso() {
        return txtIdCurso_Curso;
    }

    public void setTxtIdCurso_Curso(InputText txtIdCurso_Curso) {
        this.txtIdCurso_Curso = txtIdCurso_Curso;
    }

    public InputText getTxtIdCodigoEstudiante_Estudiante() {
        return txtIdCodigoEstudiante_Estudiante;
    }

    public void setTxtIdCodigoEstudiante_Estudiante(
        InputText txtIdCodigoEstudiante_Estudiante) {
        this.txtIdCodigoEstudiante_Estudiante = txtIdCodigoEstudiante_Estudiante;
    }

    public InputText getTxtIdListaSepia() {
        return txtIdListaSepia;
    }

    public void setTxtIdListaSepia(InputText txtIdListaSepia) {
        this.txtIdListaSepia = txtIdListaSepia;
    }

    public List<ListaSepiaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataListaSepia();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ListaSepiaDTO> listaSepiaDTO) {
        this.data = listaSepiaDTO;
    }

    public ListaSepiaDTO getSelectedListaSepia() {
        return selectedListaSepia;
    }

    public void setSelectedListaSepia(ListaSepiaDTO listaSepia) {
        this.selectedListaSepia = listaSepia;
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
