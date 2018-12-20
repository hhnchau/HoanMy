package phuthotech.vn.hospital.model.api.patient;

/**
 * Created by kingpes on 9/5/18.
 */

public class Health {
    private int siterf;
    private int patid;
    private double idlink;
    private double idline;
    private String nohicd; //So The
    private String strday; //Tu Ngay
    private String endday; //Den Ngay
    private int hoptlc; //Ma Benh Vien
    private String addrhi; //Dia Chi The
    private String livpla; //Ma Noi Sinh Song
    private String time5y; //Thoi Gian Du 5 Nam
    private String imgpth; //url Hinh
    private String ratepay; //Ti Le
    private String timeup; //Thoi Gian Update
    private String userup; //User Update
    private int active; //Dang Su Dung
    private String hopname;

    public Health() {
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

    public String getNohicd() {
        return nohicd;
    }

    public void setNohicd(String nohicd) {
        this.nohicd = nohicd;
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

    public int getHoptlc() {
        return hoptlc;
    }

    public void setHoptlc(int hoptlc) {
        this.hoptlc = hoptlc;
    }

    public String getAddrhi() {
        return addrhi;
    }

    public void setAddrhi(String addrhi) {
        this.addrhi = addrhi;
    }

    public String getLivpla() {
        return livpla;
    }

    public void setLivpla(String livpla) {
        this.livpla = livpla;
    }

    public String getTime5y() {
        return time5y;
    }

    public void setTime5y(String time5y) {
        this.time5y = time5y;
    }

    public String getImgpth() {
        return imgpth;
    }

    public void setImgpth(String imgpth) {
        this.imgpth = imgpth;
    }

    public String getRatepay() {
        return ratepay;
    }

    public void setRatepay(String ratepay) {
        this.ratepay = ratepay;
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

    public String getHopname() {
        return hopname;
    }

    public void setHopname(String hopname) {
        this.hopname = hopname;
    }
}
