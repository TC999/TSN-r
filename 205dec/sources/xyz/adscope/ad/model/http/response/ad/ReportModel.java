package xyz.adscope.ad.model.http.response.ad;

import java.util.List;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ReportModel {
    @JsonNode(key = "exposureArea")
    private int exposureArea;
    @JsonNode(key = "id")
    private int id;
    @JsonNode(key = "rule")
    private List<RuleModel> rule;

    public int getExposureArea() {
        return this.exposureArea;
    }

    public int getId() {
        return this.id;
    }

    public List<RuleModel> getRule() {
        return this.rule;
    }

    public void setExposureArea(int i4) {
        this.exposureArea = i4;
    }

    public void setId(int i4) {
        this.id = i4;
    }

    public void setRule(List<RuleModel> list) {
        this.rule = list;
    }
}
