package phuthotech.vn.hospital.model.api;

/**
 * Created by kingpes on 8/31/18.
 */

public class Request {
    private int siterf;
    private String form;
    private int patcde;

    public Request(int siterf, String form, int patcde) {
        this.siterf = siterf;
        this.form = form;
        this.patcde = patcde;
    }

    public Request(int siterf, String form) {
        this.siterf = siterf;
        this.form = form;
    }

    public Request(int siterf) {
        this.siterf = siterf;
    }

    public Request() {
    }

    public int getSiterf() {
        return siterf;
    }

    public void setSiterf(int siterf) {
        this.siterf = siterf;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getPatcde() {
        return patcde;
    }

    public void setPatcde(int patcde) {
        this.patcde = patcde;
    }
}
