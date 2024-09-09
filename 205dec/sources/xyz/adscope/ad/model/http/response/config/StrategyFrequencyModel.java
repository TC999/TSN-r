package xyz.adscope.ad.model.http.response.config;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StrategyFrequencyModel {
    private ComplainModel complain;
    private List<FrequencyModel> frequency;
    private int minTime;
    private UniteControlModel uniteControl;

    public ComplainModel getComplain() {
        return this.complain;
    }

    public List<FrequencyModel> getFrequency() {
        return this.frequency;
    }

    public int getMinTime() {
        return this.minTime;
    }

    public UniteControlModel getUniteControl() {
        return this.uniteControl;
    }

    public void setComplain(ComplainModel complainModel) {
        this.complain = complainModel;
    }

    public void setFrequency(List<FrequencyModel> list) {
        this.frequency = list;
    }

    public void setMinTime(int i4) {
        this.minTime = i4;
    }

    public void setUniteControl(UniteControlModel uniteControlModel) {
        this.uniteControl = uniteControlModel;
    }

    public String toString() {
        return "{\"minTime\":" + this.minTime + ", \"frequency\":" + this.frequency + ", \"uniteControl\":" + this.uniteControl + ", \"complain\":" + this.complain + '}';
    }
}
