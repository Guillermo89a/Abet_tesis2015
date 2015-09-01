package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.OutcomePorCursoDTO;
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
public class OutcomePorCursoView {
    private InputText txtDetalle;
    private InputText txtIdCurso_Curso;
    private InputText txtIdOutcome_Outcome;
    private InputText txtIdOutcomePorCurso;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<OutcomePorCursoDTO> data;
    private OutcomePorCursoDTO selectedOutcomePorCurso;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public OutcomePorCursoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            OutcomePorCursoDTO outcomePorCursoDTO = (OutcomePorCursoDTO) e.getObject();

            if (txtDetalle == null) {
                txtDetalle = new InputText();
            }

            txtDetalle.setValue(outcomePorCursoDTO.getDetalle());

            if (txtIdCurso_Curso == null) {
                txtIdCurso_Curso = new InputText();
            }

            txtIdCurso_Curso.setValue(outcomePorCursoDTO.getIdCurso_Curso());

            if (txtIdOutcome_Outcome == null) {
                txtIdOutcome_Outcome = new InputText();
            }

            txtIdOutcome_Outcome.setValue(outcomePorCursoDTO.getIdOutcome_Outcome());

            if (txtIdOutcomePorCurso == null) {
                txtIdOutcomePorCurso = new InputText();
            }

            txtIdOutcomePorCurso.setValue(outcomePorCursoDTO.getIdOutcomePorCurso());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtDetalle != null) {
            txtDetalle.setValue(null);
            txtDetalle.setDisabled(true);
        }

        if (txtIdCurso_Curso != null) {
            txtIdCurso_Curso.setValue(null);
            txtIdCurso_Curso.setDisabled(true);
        }

        if (txtIdOutcome_Outcome != null) {
            txtIdOutcome_Outcome.setValue(null);
            txtIdOutcome_Outcome.setDisabled(true);
        }

        if (txtIdOutcomePorCurso != null) {
            txtIdOutcomePorCurso.setValue(null);
            txtIdOutcomePorCurso.setDisabled(false);
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
        OutcomePorCurso entity = null;

        try {
            Long idOutcomePorCurso = new Long(txtIdOutcomePorCurso.getValue()
                                                                  .toString());
            entity = businessDelegatorView.getOutcomePorCurso(idOutcomePorCurso);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtDetalle.setDisabled(false);
            txtIdCurso_Curso.setDisabled(false);
            txtIdOutcome_Outcome.setDisabled(false);
            txtIdOutcomePorCurso.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtDetalle.setValue(entity.getDetalle());
            txtDetalle.setDisabled(false);
            txtIdCurso_Curso.setValue(entity.getCurso().getIdCurso());
            txtIdCurso_Curso.setDisabled(false);
            txtIdOutcome_Outcome.setValue(entity.getOutcome().getIdOutcome());
            txtIdOutcome_Outcome.setDisabled(false);
            txtIdOutcomePorCurso.setValue(entity.getIdOutcomePorCurso());
            txtIdOutcomePorCurso.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveOutcomePorCurso(FacesUtils.checkString(
                    txtDetalle), FacesUtils.checkLong(txtIdOutcomePorCurso),
                FacesUtils.checkLong(txtIdCurso_Curso),
                FacesUtils.checkLong(txtIdOutcome_Outcome));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteOutcomePorCurso(FacesUtils.checkLong(
                    txtIdOutcomePorCurso));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateOutcomePorCurso(FacesUtils.checkString(
                    txtDetalle), FacesUtils.checkLong(txtIdOutcomePorCurso),
                FacesUtils.checkLong(txtIdCurso_Curso),
                FacesUtils.checkLong(txtIdOutcome_Outcome));
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
            if (txtIdOutcomePorCurso == null) {
                txtIdOutcomePorCurso = new InputText();
            }

            txtIdOutcomePorCurso.setValue(selectedOutcomePorCurso.getIdOutcomePorCurso());

            businessDelegatorView.deleteOutcomePorCurso(FacesUtils.checkLong(
                    txtIdOutcomePorCurso));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedOutcomePorCurso);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String detalle, Long idOutcomePorCurso,
        Long idCurso_Curso, Long idOutcome_Outcome) throws Exception {
        try {
            businessDelegatorView.updateOutcomePorCurso(detalle,
                idOutcomePorCurso, idCurso_Curso, idOutcome_Outcome);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("OutcomePorCursoView").requestRender();
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

    public InputText getTxtIdCurso_Curso() {
        return txtIdCurso_Curso;
    }

    public void setTxtIdCurso_Curso(InputText txtIdCurso_Curso) {
        this.txtIdCurso_Curso = txtIdCurso_Curso;
    }

    public InputText getTxtIdOutcome_Outcome() {
        return txtIdOutcome_Outcome;
    }

    public void setTxtIdOutcome_Outcome(InputText txtIdOutcome_Outcome) {
        this.txtIdOutcome_Outcome = txtIdOutcome_Outcome;
    }

    public InputText getTxtIdOutcomePorCurso() {
        return txtIdOutcomePorCurso;
    }

    public void setTxtIdOutcomePorCurso(InputText txtIdOutcomePorCurso) {
        this.txtIdOutcomePorCurso = txtIdOutcomePorCurso;
    }

    public List<OutcomePorCursoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataOutcomePorCurso();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<OutcomePorCursoDTO> outcomePorCursoDTO) {
        this.data = outcomePorCursoDTO;
    }

    public OutcomePorCursoDTO getSelectedOutcomePorCurso() {
        return selectedOutcomePorCurso;
    }

    public void setSelectedOutcomePorCurso(OutcomePorCursoDTO outcomePorCurso) {
        this.selectedOutcomePorCurso = outcomePorCurso;
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
