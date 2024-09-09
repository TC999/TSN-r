package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ClickModelX {
    @JsonNode(key = "delay")
    private int exposureArea;
    @JsonNode(key = "exposureTime")
    private long exposureTime;
    @JsonNode(key = "randomNum")
    private int randomNum;

    public int getExposureArea() {
        return this.exposureArea;
    }

    public long getExposureTime() {
        return this.exposureTime;
    }

    public int getRandomNum() {
        return this.randomNum;
    }

    public void setExposureArea(int i4) {
        this.exposureArea = i4;
    }

    public void setExposureTime(long j4) {
        this.exposureTime = j4;
    }

    public void setRandomNum(int i4) {
        this.randomNum = i4;
    }
}
