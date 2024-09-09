package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ClickModel {
    @JsonNode(key = "delay")
    private int delay;
    @JsonNode(key = "exposureArea")
    private int exposureArea;
    @JsonNode(key = "exposureTime")
    private long exposureTime;

    public int getDelay() {
        return this.delay;
    }

    public int getExposureArea() {
        return this.exposureArea;
    }

    public long getExposureTime() {
        return this.exposureTime;
    }

    public void setDelay(int i4) {
        this.delay = i4;
    }

    public void setExposureArea(int i4) {
        this.exposureArea = i4;
    }

    public void setExposureTime(long j4) {
        this.exposureTime = j4;
    }
}
