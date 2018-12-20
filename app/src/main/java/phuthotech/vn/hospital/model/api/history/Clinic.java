package phuthotech.vn.hospital.model.api.history;

import java.util.List;

/**
 * Created by kingpes on 9/19/18.
 */

public class Clinic {
    private int siterf;
    private int patid;
    private int servcd;
    private String docdte; //Ngay kham
    private String circui; //Mach
    private int blomax; //Huyet ap toi da
    private int blomin; //Huyet ap toi thieu
    private int temper; //Nhiet do
    private int heartb; //Nhip tim
    private int weight; //Can nang
    private String predia; //Chuan doan so bo
    private int reason; //Ly do
    private int medexa; //Khoa/Phong Kham
    private int status; //Trang thai
    private String usercr; //User tao
    private String timecr; //Ngay tao
    private String userup; //User update
    private String timeup; //Ngay update
    private String phuongphapdieutri;
    private String xutri;
    private List<Diagnose> lstDiagnoseDomain;

    public Clinic() {
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



    public int getServcd() {
        return servcd;
    }

    public void setServcd(int servcd) {
        this.servcd = servcd;
    }

    public String getDocdte() {
        return docdte;
    }

    public void setDocdte(String docdte) {
        this.docdte = docdte;
    }

    public String getCircui() {
        return circui;
    }

    public void setCircui(String circui) {
        this.circui = circui;
    }

    public int getBlomax() {
        return blomax;
    }

    public void setBlomax(int blomax) {
        this.blomax = blomax;
    }

    public int getBlomin() {
        return blomin;
    }

    public void setBlomin(int blomin) {
        this.blomin = blomin;
    }

    public int getTemper() {
        return temper;
    }

    public void setTemper(int temper) {
        this.temper = temper;
    }

    public int getHeartb() {
        return heartb;
    }

    public void setHeartb(int heartb) {
        this.heartb = heartb;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPredia() {
        return predia;
    }

    public void setPredia(String predia) {
        this.predia = predia;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }

    public int getMedexa() {
        return medexa;
    }

    public void setMedexa(int medexa) {
        this.medexa = medexa;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsercr() {
        return usercr;
    }

    public void setUsercr(String usercr) {
        this.usercr = usercr;
    }

    public String getTimecr() {
        return timecr;
    }

    public void setTimecr(String timecr) {
        this.timecr = timecr;
    }

    public String getUserup() {
        return userup;
    }

    public void setUserup(String userup) {
        this.userup = userup;
    }

    public String getTimeup() {
        return timeup;
    }

    public void setTimeup(String timeup) {
        this.timeup = timeup;
    }

    public String getPhuongphapdieutri() {
        return phuongphapdieutri;
    }

    public void setPhuongphapdieutri(String phuongphapdieutri) {
        this.phuongphapdieutri = phuongphapdieutri;
    }

    public String getXutri() {
        return xutri;
    }

    public void setXutri(String xutri) {
        this.xutri = xutri;
    }

    public List<Diagnose> getLstDiagnoseDomain() {
        return lstDiagnoseDomain;
    }

    public void setLstDiagnoseDomain(List<Diagnose> lstDiagnoseDomain) {
        this.lstDiagnoseDomain = lstDiagnoseDomain;
    }
}
