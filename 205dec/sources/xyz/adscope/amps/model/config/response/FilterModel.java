package xyz.adscope.amps.model.config.response;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FilterModel {
    private List<FrequencyModel> frequency;
    private long minLoadTime;

    public List<FrequencyModel> getFrequency() {
        return this.frequency;
    }

    public long getMinLoadTime() {
        return this.minLoadTime;
    }

    public void setFrequency(List<FrequencyModel> list) {
        this.frequency = list;
    }

    public void setMinLoadTime(long j4) {
        this.minLoadTime = j4;
    }

    public String toString() {
        return "{\"minLoadTime\":" + this.minLoadTime + ", \"frequency\":" + this.frequency + '}';
    }
}
