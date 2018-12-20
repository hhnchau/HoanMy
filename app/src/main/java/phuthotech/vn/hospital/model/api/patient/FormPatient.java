package phuthotech.vn.hospital.model.api.patient;


import java.util.List;

import phuthotech.vn.hospital.model.api.patient.Form;

/**
 * Created by kingpes on 8/31/18.
 */

public class FormPatient {
    private int Code;
    private List<Form> Data;


    public FormPatient() {
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public List<Form> getData() {
        return Data;
    }

    public void setData(List<Form> data) {
        Data = data;
    }
}


