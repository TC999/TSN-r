package xyz.adscope.amps.model.config.response;

import java.util.List;
import xyz.adscope.common.json.util.JsonUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SpaceModel {
    private int adFloorEcpm;
    private long adTimeout;
    private String adType;
    private long adsTimeout;
    private int autoRefreshSwitch;
    private int autoRefreshTime;
    private long bidAdTimeout;
    private int bidDistributionMethod;
    private int bidFloorEcpm;
    private int bidParallelNum;
    private List<AdSourceModel> c2sAdSourceList;
    private int cachedOffersNum;
    private int cachedOffersTimeout;
    private String customData = "";
    private String ext;
    private FilterModel filter;
    private List<AdSourceModel> floorAdSourceList;
    private int floorDelayTime;
    private List<AdSourceModel> s2sAdSourceList;
    private String spaceId;
    private int waterfallParallelNum;
    private int weightRandomNum;
    private List<AdSourceModel> wfAdSourceList;

    public int getAdFloorEcpm() {
        return this.adFloorEcpm;
    }

    public long getAdTimeout() {
        return this.adTimeout;
    }

    public String getAdType() {
        return this.adType;
    }

    public long getAdsTimeout() {
        return this.adsTimeout;
    }

    public int getAutoRefreshSwitch() {
        return this.autoRefreshSwitch;
    }

    public int getAutoRefreshTime() {
        return this.autoRefreshTime;
    }

    public long getBidAdTimeout() {
        return this.bidAdTimeout;
    }

    public int getBidDistributionMethod() {
        return this.bidDistributionMethod;
    }

    public int getBidFloorEcpm() {
        return this.bidFloorEcpm;
    }

    public int getBidParallelNum() {
        return this.bidParallelNum;
    }

    public List<AdSourceModel> getC2sAdSourceList() {
        return this.c2sAdSourceList;
    }

    public int getCachedOffersNum() {
        return this.cachedOffersNum;
    }

    public int getCachedOffersTimeout() {
        return this.cachedOffersTimeout;
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getExt() {
        return this.ext;
    }

    public FilterModel getFilter() {
        return this.filter;
    }

    public List<AdSourceModel> getFloorAdSourceList() {
        return this.floorAdSourceList;
    }

    public int getFloorDelayTime() {
        return this.floorDelayTime;
    }

    public List<AdSourceModel> getS2sAdSourceList() {
        return this.s2sAdSourceList;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public int getWaterfallParallelNum() {
        return this.waterfallParallelNum;
    }

    public int getWeightRandomNum() {
        return this.weightRandomNum;
    }

    public List<AdSourceModel> getWfAdSourceList() {
        return this.wfAdSourceList;
    }

    public void setAdFloorEcpm(int i4) {
        this.adFloorEcpm = i4;
    }

    public void setAdTimeout(long j4) {
        this.adTimeout = j4;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAdsTimeout(long j4) {
        this.adsTimeout = j4;
    }

    public void setAutoRefreshSwitch(int i4) {
        this.autoRefreshSwitch = i4;
    }

    public void setAutoRefreshTime(int i4) {
        this.autoRefreshTime = i4;
    }

    public void setBidAdTimeout(long j4) {
        this.bidAdTimeout = j4;
    }

    public void setBidDistributionMethod(int i4) {
        this.bidDistributionMethod = i4;
    }

    public void setBidFloorEcpm(int i4) {
        this.bidFloorEcpm = i4;
    }

    public void setBidParallelNum(int i4) {
        this.bidParallelNum = i4;
    }

    public void setC2sAdSourceList(List<AdSourceModel> list) {
        this.c2sAdSourceList = list;
    }

    public void setCachedOffersNum(int i4) {
        this.cachedOffersNum = i4;
    }

    public void setCachedOffersTimeout(int i4) {
        this.cachedOffersTimeout = i4;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setFilter(FilterModel filterModel) {
        this.filter = filterModel;
    }

    public void setFloorAdSourceList(List<AdSourceModel> list) {
        this.floorAdSourceList = list;
    }

    public void setFloorDelayTime(int i4) {
        this.floorDelayTime = i4;
    }

    public void setS2sAdSourceList(List<AdSourceModel> list) {
        this.s2sAdSourceList = list;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setWaterfallParallelNum(int i4) {
        this.waterfallParallelNum = i4;
    }

    public void setWeightRandomNum(int i4) {
        this.weightRandomNum = i4;
    }

    public void setWfAdSourceList(List<AdSourceModel> list) {
        this.wfAdSourceList = list;
    }

    public String toString() {
        return "{\"spaceId\":\"" + this.spaceId + "\", \"bidDistributionMethod\":" + this.bidDistributionMethod + ", \"adType\":\"" + this.adType + "\", \"waterfallParallelNum\":" + this.waterfallParallelNum + ", \"adTimeout\":" + this.adTimeout + ", \"adsTimeout\":" + this.adsTimeout + ", \"bidAdTimeout\":" + this.bidAdTimeout + ", \"bidParallelNum\":" + this.bidParallelNum + ", \"adFloorEcpm\":" + this.adFloorEcpm + ", \"bidFloorEcpm\":" + this.bidFloorEcpm + ", \"cachedOffersNum\":" + this.cachedOffersNum + ", \"cachedOffersTimeout\":" + this.cachedOffersTimeout + ", \"autoRefreshSwitch\":" + this.autoRefreshSwitch + ", \"autoRefreshTime\":" + this.autoRefreshTime + ", \"floorDelayTime\":" + this.floorDelayTime + ", \"s2sAdSourceList\":" + this.s2sAdSourceList + ", \"c2sAdSourceList\":" + this.c2sAdSourceList + ", \"wfAdSourceList\":" + this.wfAdSourceList + ", \"floorAdSourceList\":" + this.floorAdSourceList + ", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\", \"filter\":" + this.filter + ", \"ext\":\"" + this.ext + "\"}";
    }
}
