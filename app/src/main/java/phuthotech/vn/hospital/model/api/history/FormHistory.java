package phuthotech.vn.hospital.model.api.history;

import java.util.List;

/**
 * Created by kingpes on 9/18/18.
 */

public class FormHistory {
    private List<History> lstHistoryDomain;

    public FormHistory(List<History> lstHistoryDomain) {
        this.lstHistoryDomain = lstHistoryDomain;
    }

    public List<History> getLstHistoryDomain() {
        return lstHistoryDomain;
    }

    public void setLstHistoryDomain(List<History> lstHistoryDomain) {
        this.lstHistoryDomain = lstHistoryDomain;
    }
}
