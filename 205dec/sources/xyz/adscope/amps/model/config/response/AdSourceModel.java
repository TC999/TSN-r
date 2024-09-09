package xyz.adscope.amps.model.config.response;

import java.util.List;
import xyz.adscope.common.json.util.JsonUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdSourceModel {
    private int adComparePriceStatus;
    private int adStatus;
    private int adsTimeout;
    private int autoRefreshSwitch;
    private int biddingTimeout;
    private int cachedOffersTimeout;
    private int ecpm;
    private int endWeight;
    private FilterModel filter;
    private int floorEcpm;
    private boolean isCache;
    private int isFloor;
    private int isSendBidData;
    private int priority;
    private int startWeight;
    private List<Integer> templateTypes;
    private int videoAutoPlay;
    private int videoMaxTime;
    private int videoSound;
    private String appId = "";
    private String spaceId = "";
    private String adType = "";
    private String seatId = "";
    private String adapterManagerClass = "";
    private String adapterClass = "";
    private String biddingType = "";
    private String renderType = "";
    private String orientation = "";
    private String zoomout = "";
    private String errorCode = "";
    private String errorMsg = "";
    private String customData = "";
    private long durationTime = 0;

    public int getAdComparePriceStatus() {
        return this.adComparePriceStatus;
    }

    public int getAdStatus() {
        return this.adStatus;
    }

    public String getAdType() {
        return this.adType;
    }

    public String getAdapterClass() {
        return this.adapterClass;
    }

    public String getAdapterManagerClass() {
        return this.adapterManagerClass;
    }

    public int getAdsTimeout() {
        return this.adsTimeout;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getAutoRefreshSwitch() {
        return this.autoRefreshSwitch;
    }

    public int getBiddingTimeout() {
        return this.biddingTimeout;
    }

    public String getBiddingType() {
        return this.biddingType;
    }

    public int getCachedOffersTimeout() {
        return this.cachedOffersTimeout;
    }

    public String getCustomData() {
        return this.customData;
    }

    public long getDurationTime() {
        return this.durationTime;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public int getEndWeight() {
        return this.endWeight;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public FilterModel getFilter() {
        return this.filter;
    }

    public int getFloorEcpm() {
        return this.floorEcpm;
    }

    public int getIsFloor() {
        return this.isFloor;
    }

    public int getIsSendBidData() {
        return this.isSendBidData;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getRenderType() {
        return this.renderType;
    }

    public String getSeatId() {
        return this.seatId;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public int getStartWeight() {
        return this.startWeight;
    }

    public List<Integer> getTemplateTypes() {
        return this.templateTypes;
    }

    public int getVideoAutoPlay() {
        return this.videoAutoPlay;
    }

    public int getVideoMaxTime() {
        return this.videoMaxTime;
    }

    public int getVideoSound() {
        return this.videoSound;
    }

    public String getZoomout() {
        return this.zoomout;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public void setAdComparePriceStatus(int i4) {
        this.adComparePriceStatus = i4;
    }

    public void setAdStatus(int i4) {
        this.adStatus = i4;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAdapterClass(String str) {
        this.adapterClass = str;
    }

    public void setAdapterManagerClass(String str) {
        this.adapterManagerClass = str;
    }

    public void setAdsTimeout(int i4) {
        this.adsTimeout = i4;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAutoRefreshSwitch(int i4) {
        this.autoRefreshSwitch = i4;
    }

    public void setBiddingTimeout(int i4) {
        this.biddingTimeout = i4;
    }

    public void setBiddingType(String str) {
        this.biddingType = str;
    }

    public void setCache(boolean z3) {
        this.isCache = z3;
    }

    public void setCachedOffersTimeout(int i4) {
        this.cachedOffersTimeout = i4;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setDurationTime(long j4) {
        this.durationTime = j4;
    }

    public void setEcpm(int i4) {
        this.ecpm = i4;
    }

    public void setEndWeight(int i4) {
        this.endWeight = i4;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setFilter(FilterModel filterModel) {
        this.filter = filterModel;
    }

    public void setFloorEcpm(int i4) {
        this.floorEcpm = i4;
    }

    public void setIsFloor(int i4) {
        this.isFloor = i4;
    }

    public void setIsSendBidData(int i4) {
        this.isSendBidData = i4;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setPriority(int i4) {
        this.priority = i4;
    }

    public void setRenderType(String str) {
        this.renderType = str;
    }

    public void setSeatId(String str) {
        this.seatId = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setStartWeight(int i4) {
        this.startWeight = i4;
    }

    public void setTemplateTypes(List<Integer> list) {
        this.templateTypes = list;
    }

    public void setVideoAutoPlay(int i4) {
        this.videoAutoPlay = i4;
    }

    public void setVideoMaxTime(int i4) {
        this.videoMaxTime = i4;
    }

    public void setVideoSound(int i4) {
        this.videoSound = i4;
    }

    public void setZoomout(String str) {
        this.zoomout = str;
    }

    public String toString() {
        return "{\"appId\":\"" + this.appId + "\", \"spaceId\":\"" + this.spaceId + "\", \"adType\":\"" + this.adType + "\", \"seatId\":\"" + this.seatId + "\", \"adapterManagerClass\":\"" + this.adapterManagerClass + "\", \"adapterClass\":\"" + this.adapterClass + "\", \"biddingType\":\"" + this.biddingType + "\", \"renderType\":\"" + this.renderType + "\", \"ecpm\":" + this.ecpm + ", \"floorEcpm\":" + this.floorEcpm + ", \"isFloor\":" + this.isFloor + ", \"priority\":" + this.priority + ", \"adsTimeout\":" + this.adsTimeout + ", \"biddingTimeout\":" + this.biddingTimeout + ", \"cachedOffersTimeout\":" + this.cachedOffersTimeout + ", \"autoRefreshSwitch\":" + this.autoRefreshSwitch + ", \"orientation\":\"" + this.orientation + "\", \"zoomout\":\"" + this.zoomout + "\", \"videoSound\":" + this.videoSound + ", \"videoMaxTime\":" + this.videoMaxTime + ", \"videoAutoPlay\":" + this.videoAutoPlay + ", \"filter\":" + this.filter + ", \"startWeight\":" + this.startWeight + ", \"endWeight\":" + this.endWeight + ", \"templateTypes\":" + this.templateTypes + ", \"adStatus\":" + this.adStatus + ", \"isCache\":" + this.isCache + ", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\", \"errorCode\":\"" + this.errorCode + "\", \"errorMsg\":\"" + this.errorMsg + "\"}";
    }
}
