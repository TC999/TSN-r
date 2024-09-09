package xyz.adscope.ad.model.http.response.config;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SplashModel {
    private List<FrequencyModel> frequency;
    private int minTime;

    public List<FrequencyModel> getFrequency() {
        return this.frequency;
    }

    public int getMinTime() {
        return this.minTime;
    }

    public void setFrequency(List<FrequencyModel> list) {
        this.frequency = list;
    }

    public void setMinTime(int i4) {
        this.minTime = i4;
    }
}
