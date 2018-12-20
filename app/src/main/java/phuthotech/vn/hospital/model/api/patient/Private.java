package phuthotech.vn.hospital.model.api.patient;

/**
 * Created by kingpes on 9/5/18.
 */

public class Private {
    private int siterf;
    private int patid;
    private double idlink;
    private double idline;
    private String nobhi;  //So The
    private String strday; //Tu Ngay
    private String endday; //Den Ngay
    private int idcom; //ID Cong Ty
    private String address; //Dia Chi Cong Ty
    private int idcombhi; //ID Cong Ty Bao Hiem
    private String phone; //So Dien Thoai
    private String timeup; //Thoi Gian Update
    private String userup; //User Update
    private int active;
    private String comname;
    private String combhiname;

    public Private() {
    }

    public int getSiterf() {
        return siterf;
    }

    public void setSiterf(int siterf) {
        this.siterf = siterf;
    }

    public int getPatid() {
        return patid;
    }

    public void setPatid(int patid) {
        this.patid = patid;
    }

    public double getIdlink() {
        return idlink;
    }

    public void setIdlink(double idlink) {
        this.idlink = idlink;
    }

    public double getIdline() {
        return idline;
    }

    public void setIdline(double idline) {
        this.idline = idline;
    }

    public String getNobhi() {
        return nobhi;
    }

    public void setNobhi(String nobhi) {
        this.nobhi = nobhi;
    }

    public String getStrday() {
        return strday;
    }

    public void setStrday(String strday) {
        this.strday = strday;
    }

    public String getEndday() {
        return endday;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    public int getIdcom() {
        return idcom;
    }

    public void setIdcom(int idcom) {
        this.idcom = idcom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdcombhi() {
        return idcombhi;
    }

    public void setIdcombhi(int idcombhi) {
        this.idcombhi = idcombhi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTimeup() {
        return timeup;
    }

    public void setTimeup(String timeup) {
        this.timeup = timeup;
    }

    public String getUserup() {
        return userup;
    }

    public void setUserup(String userup) {
        this.userup = userup;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getCombhiname() {
        return combhiname;
    }

    public void setCombhiname(String combhiname) {
        this.combhiname = combhiname;
    }
}
