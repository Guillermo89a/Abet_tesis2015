package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.PensumDTO;
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
public class PensumView {
    private InputText txtCreditos;
    private InputText txtSemestre;
    private InputText txtIdCodigoMateria_Materia;
    private InputText txtIdPrograma_Programa;
    private InputText txtIdPensum;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PensumDTO> data;
    private PensumDTO selectedPensum;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public PensumView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            PensumDTO pensumDTO = (PensumDTO) e.getObject();

            if (txtCreditos == null) {
                txtCreditos = new InputText();
            }

            txtCreditos.setValue(pensumDTO.getCreditos());

            if (txtSemestre == null) {
                txtSemestre = new InputText();
            }

            txtSemestre.setValue(pensumDTO.getSemestre());

            if (txtIdCodigoMateria_Materia == null) {
                txtIdCodigoMateria_Materia = new InputText();
            }

            txtIdCodigoMateria_Materia.setValue(pensumDTO.getIdCodigoMateria_Materia());

            if (txtIdPrograma_Programa == null) {
                txtIdPrograma_Programa = new InputText();
            }

            txtIdPrograma_Programa.setValue(pensumDTO.getIdPrograma_Programa());

            if (txtIdPensum == null) {
                txtIdPensum = new InputText();
            }

            txtIdPensum.setValue(pensumDTO.getIdPensum());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtCreditos != null) {
            txtCreditos.setValue(null);
            txtCreditos.setDisabled(true);
        }

        if (txtSemestre != null) {
            txtSemestre.setValue(null);
            txtSemestre.setDisabled(true);
        }

        if (txtIdCodigoMateria_Materia != null) {
            txtIdCodigoMateria_Materia.setValue(null);
            txtIdCodigoMateria_Materia.setDisabled(true);
        }

        if (txtIdPrograma_Programa != null) {
            txtIdPrograma_Programa.setValue(null);
            txtIdPrograma_Programa.setDisabled(true);
        }

        if (txtIdPensum != null) {
            txtIdPensum.setValue(null);
            txtIdPensum.setDisabled(false);
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
        Pensum entity = null;

        try {
            Long idPensum = new Long(txtIdPensum.getValue().toString());
            entity = businessDelegatorView.getPensum(idPensum);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtCreditos.setDisabled(false);
            txtSemestre.setDisabled(false);
            txtIdCodigoMateria_Materia.setDisabled(false);
            txtIdPrograma_Programa.setDisabled(false);
            txtIdPensum.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtCreditos.setValue(entity.getCreditos());
            txtCreditos.setDisabled(false);
            txtSemestre.setValue(entity.getSemestre());
            txtSemestre.setDisabled(false);
            txtIdCodigoMateria_Materia.setValue(entity.getMateria()
                                                      .getIdCodigoMateria());
            txtIdCodigoMateria_Materia.setDisabled(false);
            txtIdPrograma_Programa.setValue(entity.getPrograma().getIdPrograma());
            txtIdPrograma_Programa.setDisabled(false);
            txtIdPensum.setValue(entity.getIdPensum());
            txtIdPensum.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.savePensum(FacesUtils.checkString(txtCreditos),
                FacesUtils.checkLong(txtIdPensum),
                FacesUtils.checkString(txtSemestre),
                FacesUtils.checkLong(txtIdCodigoMateria_Materia),
                FacesUtils.checkLong(txtIdPrograma_Programa));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deletePensum(FacesUtils.checkLong(txtIdPensum));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updatePensum(FacesUtils.checkString(
                    txtCreditos), FacesUtils.checkLong(txtIdPensum),
                FacesUtils.checkString(txtSemestre),
                FacesUtils.checkLong(txtIdCodigoMateria_Materia),
                FacesUtils.checkLong(txtIdPrograma_Programa));
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
            if (txtIdPensum == null) {
                txtIdPensum = new InputText();
            }

            txtIdPensum.setValue(selectedPensum.getIdPensum());

            businessDelegatorView.deletePensum(FacesUtils.checkLong(txtIdPensum));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedPensum);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String creditos, Long idPensum,
        String semestre, Long idCodigoMateria_Materia, Long idPrograma_Programa)
        throws Exception {
        try {
            businessDelegatorView.updatePensum(creditos, idPensum, semestre,
                idCodigoMateria_Materia, idPrograma_Programa);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PensumView").requestRender();
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

    public InputText getTxtSemestre() {
        return txtSemestre;
    }

    public void setTxtSemestre(InputText txtSemestre) {
        this.txtSemestre = txtSemestre;
    }

    public InputText getTxtIdCodigoMateria_Materia() {
        return txtIdCodigoMateria_Materia;
    }

    public void setTxtIdCodigoMateria_Materia(
        InputText txtIdCodigoMateria_Materia) {
        this.txtIdCodigoMateria_Materia = txtIdCodigoMateria_Materia;
    }

    public InputText getTxtIdPrograma_Programa() {
        return txtIdPrograma_Programa;
    }

    public void setTxtIdPrograma_Programa(InputText txtIdPrograma_Programa) {
        this.txtIdPrograma_Programa = txtIdPrograma_Programa;
    }

    public InputText getTxtIdPensum() {
        return txtIdPensum;
    }

    public void setTxtIdPensum(InputText txtIdPensum) {
        this.txtIdPensum = txtIdPensum;
    }

    public List<PensumDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPensum();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<PensumDTO> pensumDTO) {
        this.data = pensumDTO;
    }

    public PensumDTO getSelectedPensum() {
        return selectedPensum;
    }

    public void setSelectedPensum(PensumDTO pensum) {
        this.selectedPensum = pensum;
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
