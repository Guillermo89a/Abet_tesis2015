package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.EvaluacionDTO;
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
public class EvaluacionView {
    private InputText txtIdCurso_Curso;
    private InputText txtIdCodigoEstudiante_Estudiante;
    private InputText txtIdOutcome_Outcome;
    private InputText txtIdEvaluacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<EvaluacionDTO> data;
    private EvaluacionDTO selectedEvaluacion;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public EvaluacionView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            EvaluacionDTO evaluacionDTO = (EvaluacionDTO) e.getObject();

            if (txtIdCurso_Curso == null) {
                txtIdCurso_Curso = new InputText();
            }

            txtIdCurso_Curso.setValue(evaluacionDTO.getIdCurso_Curso());

            if (txtIdCodigoEstudiante_Estudiante == null) {
                txtIdCodigoEstudiante_Estudiante = new InputText();
            }

            txtIdCodigoEstudiante_Estudiante.setValue(evaluacionDTO.getIdCodigoEstudiante_Estudiante());

            if (txtIdOutcome_Outcome == null) {
                txtIdOutcome_Outcome = new InputText();
            }

            txtIdOutcome_Outcome.setValue(evaluacionDTO.getIdOutcome_Outcome());

            if (txtIdEvaluacion == null) {
                txtIdEvaluacion = new InputText();
            }

            txtIdEvaluacion.setValue(evaluacionDTO.getIdEvaluacion());

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

        if (txtIdOutcome_Outcome != null) {
            txtIdOutcome_Outcome.setValue(null);
            txtIdOutcome_Outcome.setDisabled(true);
        }

        if (txtIdEvaluacion != null) {
            txtIdEvaluacion.setValue(null);
            txtIdEvaluacion.setDisabled(false);
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
        Evaluacion entity = null;

        try {
            Long idEvaluacion = new Long(txtIdEvaluacion.getValue().toString());
            entity = businessDelegatorView.getEvaluacion(idEvaluacion);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtIdCurso_Curso.setDisabled(false);
            txtIdCodigoEstudiante_Estudiante.setDisabled(false);
            txtIdOutcome_Outcome.setDisabled(false);
            txtIdEvaluacion.setDisabled(false);
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
            txtIdOutcome_Outcome.setValue(entity.getOutcome().getIdOutcome());
            txtIdOutcome_Outcome.setDisabled(false);
            txtIdEvaluacion.setValue(entity.getIdEvaluacion());
            txtIdEvaluacion.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveEvaluacion(FacesUtils.checkLong(
                    txtIdEvaluacion), FacesUtils.checkLong(txtIdCurso_Curso),
                FacesUtils.checkLong(txtIdCodigoEstudiante_Estudiante),
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
            businessDelegatorView.deleteEvaluacion(FacesUtils.checkLong(
                    txtIdEvaluacion));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateEvaluacion(FacesUtils.checkLong(
                    txtIdEvaluacion), FacesUtils.checkLong(txtIdCurso_Curso),
                FacesUtils.checkLong(txtIdCodigoEstudiante_Estudiante),
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
            if (txtIdEvaluacion == null) {
                txtIdEvaluacion = new InputText();
            }

            txtIdEvaluacion.setValue(selectedEvaluacion.getIdEvaluacion());

            businessDelegatorView.deleteEvaluacion(FacesUtils.checkLong(
                    txtIdEvaluacion));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedEvaluacion);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long idEvaluacion, Long idCurso_Curso,
        Long idCodigoEstudiante_Estudiante, Long idOutcome_Outcome)
        throws Exception {
        try {
            businessDelegatorView.updateEvaluacion(idEvaluacion, idCurso_Curso,
                idCodigoEstudiante_Estudiante, idOutcome_Outcome);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("EvaluacionView").requestRender();
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

    public InputText getTxtIdOutcome_Outcome() {
        return txtIdOutcome_Outcome;
    }

    public void setTxtIdOutcome_Outcome(InputText txtIdOutcome_Outcome) {
        this.txtIdOutcome_Outcome = txtIdOutcome_Outcome;
    }

    public InputText getTxtIdEvaluacion() {
        return txtIdEvaluacion;
    }

    public void setTxtIdEvaluacion(InputText txtIdEvaluacion) {
        this.txtIdEvaluacion = txtIdEvaluacion;
    }

    public List<EvaluacionDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataEvaluacion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<EvaluacionDTO> evaluacionDTO) {
        this.data = evaluacionDTO;
    }

    public EvaluacionDTO getSelectedEvaluacion() {
        return selectedEvaluacion;
    }

    public void setSelectedEvaluacion(EvaluacionDTO evaluacion) {
        this.selectedEvaluacion = evaluacion;
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
