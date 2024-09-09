package xyz.adscope.ad.model.http.response.config;

import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StrategyModel {
    private List<StrategyFrequencyModel> banner;
    private List<StrategyFrequencyModel> interstitial;
    @JsonNode(key = AMPSConstants.AdType.AD_TYPE_NATIVE)
    private List<StrategyFrequencyModel> nativeModel;
    private List<StrategyFrequencyModel> splash;

    public List<StrategyFrequencyModel> getBanner() {
        return this.banner;
    }

    public List<StrategyFrequencyModel> getInterstitial() {
        return this.interstitial;
    }

    public List<StrategyFrequencyModel> getNativeModel() {
        return this.nativeModel;
    }

    public List<StrategyFrequencyModel> getSplash() {
        return this.splash;
    }

    public void setBanner(List<StrategyFrequencyModel> list) {
        this.banner = list;
    }

    public void setInterstitial(List<StrategyFrequencyModel> list) {
        this.interstitial = list;
    }

    public void setNativeModel(List<StrategyFrequencyModel> list) {
        this.nativeModel = list;
    }

    public void setSplash(List<StrategyFrequencyModel> list) {
        this.splash = list;
    }

    public String toString() {
        return "{\"splash\":" + this.splash + ", \"native\":" + this.nativeModel + ", \"interstitial\":" + this.interstitial + ", \"banner\":" + this.banner + '}';
    }
}
