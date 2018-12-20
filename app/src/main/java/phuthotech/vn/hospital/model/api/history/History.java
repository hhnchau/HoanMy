package phuthotech.vn.hospital.model.api.history;

import java.util.List;

import phuthotech.vn.hospital.model.api.history.Clinic;
import phuthotech.vn.hospital.model.api.patient.Patient;

/**
 * Created by kingpes on 9/19/18.
 */

public class History {
    private Patient doPatientDomain;
    private List<Clinic> lstClinicDomain;

    public History() {
    }

    public Patient getDoPatientDomain() {
        return doPatientDomain;
    }

    public void setDoPatientDomain(Patient doPatientDomain) {
        this.doPatientDomain = doPatientDomain;
    }

    public List<Clinic> getLstClinicDomain() {
        return lstClinicDomain;
    }

    public void setLstClinicDomain(List<Clinic> lstClinicDomain) {
        this.lstClinicDomain = lstClinicDomain;
    }
}
