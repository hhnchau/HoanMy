package phuthotech.vn.hospital.model.api.register;

import java.util.List;

import phuthotech.vn.hospital.model.api.patient.Additional;
import phuthotech.vn.hospital.model.api.patient.Health;
import phuthotech.vn.hospital.model.api.patient.Patient;
import phuthotech.vn.hospital.model.api.patient.Private;

/**
 * Created by kingpes on 9/25/18.
 */

public class Register {
    private Dob dob1;
    private Dob dob2;
    private Dob dob3;
    private List<LstDob> lstDOB1;
    private List<LstDob> lstDOB8;
    private List<Combo> Combo1;
    private List<Additional> Combo2;
    private List<Additional> Combo3;
    private List<Additional> Combo4;
    private List<Additional> Combo5;
    private List<Additional> Combo6;
    private List<Additional> Combo7;
    private List<Combo> Combo8;
    private List<Combo> Combo9;
    private List<Combo> Combo10;

    public Register() {
    }

    public Dob getDob1() {
        return dob1;
    }

    public void setDob1(Dob dob1) {
        this.dob1 = dob1;
    }

    public Dob getDob2() {
        return dob2;
    }

    public void setDob2(Dob dob2) {
        this.dob2 = dob2;
    }

    public Dob getDob3() {
        return dob3;
    }

    public void setDob3(Dob dob3) {
        this.dob3 = dob3;
    }

    public List<LstDob> getLstDOB1() {
        return lstDOB1;
    }

    public void setLstDOB1(List<LstDob> lstDOB1) {
        this.lstDOB1 = lstDOB1;
    }

    public List<Combo> getCombo1() {
        return Combo1;
    }

    public void setCombo1(List<Combo> combo1) {
        Combo1 = combo1;
    }

    public List<Additional> getCombo2() {
        return Combo2;
    }

    public void setCombo2(List<Additional> combo2) {
        Combo2 = combo2;
    }

    public List<Additional> getCombo3() {
        return Combo3;
    }

    public void setCombo3(List<Additional> combo3) {
        Combo3 = combo3;
    }

    public List<Additional> getCombo4() {
        return Combo4;
    }

    public void setCombo4(List<Additional> combo4) {
        Combo4 = combo4;
    }

    public List<Additional> getCombo5() {
        return Combo5;
    }

    public void setCombo5(List<Additional> combo5) {
        Combo5 = combo5;
    }

    public List<Additional> getCombo6() {
        return Combo6;
    }

    public void setCombo6(List<Additional> combo6) {
        Combo6 = combo6;
    }

    public List<Additional> getCombo7() {
        return Combo7;
    }

    public void setCombo7(List<Additional> combo7) {
        Combo7 = combo7;
    }

    public List<Combo> getCombo8() {
        return Combo8;
    }

    public void setCombo8(List<Combo> combo8) {
        Combo8 = combo8;
    }

    public List<Combo> getCombo9() {
        return Combo9;
    }

    public void setCombo9(List<Combo> combo9) {
        Combo9 = combo9;
    }

    public List<Combo> getCombo10() {
        return Combo10;
    }

    public void setCombo10(List<Combo> combo10) {
        Combo10 = combo10;
    }

    public List<LstDob> getLstDOB8() {
        return lstDOB8;
    }

    public void setLstDOB8(List<LstDob> lstDOB8) {
        this.lstDOB8 = lstDOB8;
    }
}
