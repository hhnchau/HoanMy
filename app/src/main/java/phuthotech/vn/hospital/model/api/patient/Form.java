package phuthotech.vn.hospital.model.api.patient;

import java.util.List;

import phuthotech.vn.hospital.model.api.register.Combo;

public class Form {
    private Patient dob1;   // Patient Info
    private Health dob2;    // Health Insurance
    private Private dob3;   // Private Insurance
    private List<Additional> lstDOB4;   // Cty
    private List<Additional> Combo1;    // Nationality
    private List<Additional> Combo2;    // Nation
    private List<Additional> Combo3;    // Job
    private List<Additional> Combo5;    // District
    private List<Additional> Combo6;    // Ward
    private List<Additional> Combo7;    //
    private List<Additional> Combo8;    //
    private List<Additional> Combo9;    // Insurance Conpany
    private List<Additional> Combo10;   // Insured Company
    private List<Combo> Combo;

    public Form() {
    }

    public Patient getDob1() {
        return dob1;
    }

    public void setDob1(Patient dob1) {
        this.dob1 = dob1;
    }

    public Health getDob2() {
        return dob2;
    }

    public void setDob2(Health dob2) {
        this.dob2 = dob2;
    }

    public Private getDob3() {
        return dob3;
    }

    public void setDob3(Private dob3) {
        this.dob3 = dob3;
    }

    public List<Additional> getLstDob4() {
        return lstDOB4;
    }

    public void setLstDob4(List<Additional> lstDOB4) {
        this.lstDOB4 = lstDOB4;
    }

    public List<Additional> getCombo1() {
        return Combo1;
    }

    public void setCombo1(List<Additional> combo1) {
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

    public List<Additional> getCombo8() {
        return Combo8;
    }

    public void setCombo8(List<Additional> combo8) {
        Combo8 = combo8;
    }

    public List<Additional> getCombo9() {
        return Combo9;
    }

    public void setCombo9(List<Additional> combo9) {
        Combo9 = combo9;
    }

    public List<Additional> getCombo10() {
        return Combo10;
    }

    public void setCombo10(List<Additional> combo10) {
        Combo10 = combo10;
    }

    public List<phuthotech.vn.hospital.model.api.register.Combo> getCombo() {
        return Combo;
    }

    public void setCombo(List<phuthotech.vn.hospital.model.api.register.Combo> combo) {
        Combo = combo;
    }

}
