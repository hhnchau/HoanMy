package phuthotech.vn.hospital.model.api.register;

import java.util.List;

/**
 * Created by kingpes on 9/25/18.
 */

public class FormRegister{
    private int Code;
    private List<Register> Data;


    public FormRegister() {
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public List<Register> getData() {
        return Data;
    }

    public void setData(List<Register> data) {
        Data = data;
    }
}
