package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RuleModel {
    @JsonNode(key = "calExposureTime")
    private int calExposureTime;
    @JsonNode(key = "calRandomNum")
    private int calRandomNum;
    @JsonNode(key = "repDelay")
    private String repDelay;
    @JsonNode(key = "repRandomDelay")
    private int repRandomDelay;
    @JsonNode(key = "type")
    private int type;

    public int getCalExposureTime() {
        return this.calExposureTime;
    }

    public int getCalRandomNum() {
        return this.calRandomNum;
    }

    public String getRepDelay() {
        return this.repDelay;
    }

    public int getRepRandomDelay() {
        return this.repRandomDelay;
    }

    public int getType() {
        return this.type;
    }

    public void setCalExposureTime(int i4) {
        this.calExposureTime = i4;
    }

    public void setCalRandomNum(int i4) {
        this.calRandomNum = i4;
    }

    public void setRepDelay(String str) {
        this.repDelay = str;
    }

    public void setRepRandomDelay(int i4) {
        this.repRandomDelay = i4;
    }

    public void setType(int i4) {
        this.type = i4;
    }
}
