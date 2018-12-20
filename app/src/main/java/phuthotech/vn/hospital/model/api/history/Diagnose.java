package phuthotech.vn.hospital.model.api.history;

/**
 * Created by kingpes on 9/19/18.
 */

public class Diagnose {
    private int siterf;
    private int patid;

    private int idicdx;
    private int primary;
    private String usercr;
    private String timecr;
    private String code;
    private String name;

    public Diagnose() {
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

    public int getIdicdx() {
        return idicdx;
    }

    public void setIdicdx(int idicdx) {
        this.idicdx = idicdx;
    }

    public int getPrimary() {
        return primary;
    }

    public void setPrimary(int primary) {
        this.primary = primary;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
