package phuthotech.vn.hospital.model.api;

/**
 * Created by kingpes on 9/5/18.
 */

public class Result {
    private int Code;
    private boolean Data;

    public Result() {
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public boolean isData() {
        return Data;
    }

    public void setData(boolean data) {
        Data = data;
    }
}
