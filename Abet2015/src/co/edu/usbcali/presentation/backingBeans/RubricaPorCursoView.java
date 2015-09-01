package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.RubricaPorCursoDTO;
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
public class RubricaPorCursoView {
    private InputText txtIdCurso_Curso;
    private InputText txtIdOutcomePorPrograma_OutcomePorPrograma;
    private InputText txtIdRubrica_Rubrica;
    private InputText txtIdRubricaPorCurso;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RubricaPorCursoDTO> data;
    private RubricaPorCursoDTO selectedRubricaPorCurso;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public RubricaPorCursoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            RubricaPorCursoDTO rubricaPorCursoDTO = (RubricaPorCursoDTO) e.getObject();

            if (txtIdCurso_Curso == null) {
                txtIdCurso_Curso = new InputText();
            }

            txtIdCurso_Curso.setValue(rubricaPorCursoDTO.getIdCurso_Curso());

            if (txtIdOutcomePorPrograma_OutcomePorPrograma == null) {
                txtIdOutcomePorPrograma_OutcomePorPrograma = new InputText();
            }

            txtIdOutcomePorPrograma_OutcomePorPrograma.setValue(rubricaPorCursoDTO.getIdOutcomePorPrograma_OutcomePorPrograma());

            if (txtIdRubrica_Rubrica == null) {
                txtIdRubrica_Rubrica = new InputText();
            }

            txtIdRubrica_Rubrica.setValue(rubricaPorCursoDTO.getIdRubrica_Rubrica());

            if (txtIdRubricaPorCurso == null) {
                txtIdRubricaPorCurso = new InputText();
            }

            txtIdRubricaPorCurso.setValue(rubricaPorCursoDTO.getIdRubricaPorCurso());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtIdCurso_Curso != null) {
            txtIdCurso_Curso.setValue(null);
            txtIdCurso_Curso.setDisabled(true);
        }

        if (txtIdOutcomePorPrograma_OutcomePorPrograma != null) {
            txtIdOutcomePorPrograma_OutcomePorPrograma.setValue(null);
            txtIdOutcomePorPrograma_OutcomePorPrograma.setDisabled(true);
        }

        if (txtIdRubrica_Rubrica != null) {
            txtIdRubrica_Rubrica.setValue(null);
            txtIdRubrica_Rubrica.setDisabled(true);
        }

        if (txtIdRubricaPorCurso != null) {
            txtIdRubricaPorCurso.setValue(null);
            txtIdRubricaPorCurso.setDisabled(false);
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
        RubricaPorCurso entity = null;

        try {
            Long idRubricaPorCurso = new Long(txtIdRubricaPorCurso.getValue()
                                                                  .toString());
            entity = businessDelegatorView.getRubricaPorCurso(idRubricaPorCurso);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtIdCurso_Curso.setDisabled(false);
            txtIdOutcomePorPrograma_OutcomePorPrograma.setDisabled(false);
            txtIdRubrica_Rubrica.setDisabled(false);
            txtIdRubricaPorCurso.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtIdCurso_Curso.setValue(entity.getCurso().getIdCurso());
            txtIdCurso_Curso.setDisabled(false);
            txtIdOutcomePorPrograma_OutcomePorPrograma.setValue(entity.getOutcomePorPrograma()
                                                                      .getIdOutcomePorPrograma());
            txtIdOutcomePorPrograma_OutcomePorPrograma.setDisabled(false);
            txtIdRubrica_Rubrica.setValue(entity.getRubrica().getIdRubrica());
            txtIdRubrica_Rubrica.setDisabled(false);
            txtIdRubricaPorCurso.setValue(entity.getIdRubricaPorCurso());
            txtIdRubricaPorCurso.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveRubricaPorCurso(FacesUtils.checkLong(
                    txtIdRubricaPorCurso),
                FacesUtils.checkLong(txtIdCurso_Curso),
                FacesUtils.checkLong(txtIdOutcomePorPrograma_OutcomePorPrograma),
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
            businessDelegatorView.deleteRubricaPorCurso(FacesUtils.checkLong(
                    txtIdRubricaPorCurso));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateRubricaPorCurso(FacesUtils.checkLong(
                    txtIdRubricaPorCurso),
                FacesUtils.checkLong(txtIdCurso_Curso),
                FacesUtils.checkLong(txtIdOutcomePorPrograma_OutcomePorPrograma),
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
            if (txtIdRubricaPorCurso == null) {
                txtIdRubricaPorCurso = new InputText();
            }

            txtIdRubricaPorCurso.setValue(selectedRubricaPorCurso.getIdRubricaPorCurso());

            businessDelegatorView.deleteRubricaPorCurso(FacesUtils.checkLong(
                    txtIdRubricaPorCurso));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedRubricaPorCurso);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long idRubricaPorCurso,
        Long idCurso_Curso, Long idOutcomePorPrograma_OutcomePorPrograma,
        Long idRubrica_Rubrica) throws Exception {
        try {
            businessDelegatorView.updateRubricaPorCurso(idRubricaPorCurso,
                idCurso_Curso, idOutcomePorPrograma_OutcomePorPrograma,
                idRubrica_Rubrica);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RubricaPorCursoView").requestRender();
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

    public InputText getTxtIdOutcomePorPrograma_OutcomePorPrograma() {
        return txtIdOutcomePorPrograma_OutcomePorPrograma;
    }

    public void setTxtIdOutcomePorPrograma_OutcomePorPrograma(
        InputText txtIdOutcomePorPrograma_OutcomePorPrograma) {
        this.txtIdOutcomePorPrograma_OutcomePorPrograma = txtIdOutcomePorPrograma_OutcomePorPrograma;
    }

    public InputText getTxtIdRubrica_Rubrica() {
        return txtIdRubrica_Rubrica;
    }

    public void setTxtIdRubrica_Rubrica(InputText txtIdRubrica_Rubrica) {
        this.txtIdRubrica_Rubrica = txtIdRubrica_Rubrica;
    }

    public InputText getTxtIdRubricaPorCurso() {
        return txtIdRubricaPorCurso;
    }

    public void setTxtIdRubricaPorCurso(InputText txtIdRubricaPorCurso) {
        this.txtIdRubricaPorCurso = txtIdRubricaPorCurso;
    }

    public List<RubricaPorCursoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRubricaPorCurso();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RubricaPorCursoDTO> rubricaPorCursoDTO) {
        this.data = rubricaPorCursoDTO;
    }

    public RubricaPorCursoDTO getSelectedRubricaPorCurso() {
        return selectedRubricaPorCurso;
    }

    public void setSelectedRubricaPorCurso(RubricaPorCursoDTO rubricaPorCurso) {
        this.selectedRubricaPorCurso = rubricaPorCurso;
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
