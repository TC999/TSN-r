package xyz.adscope.amps.model;

import xyz.adscope.amps.tool.util.AMPSStringUtil;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSCycleModel {
    private String mediationAppId = "";
    private String mediationSpaceId = "";
    private String adSourceId = "";
    private String adSourceAppId = "";
    private String adSourceSpaceId = "";
    private String ecpm = "";
    private String errorCode = "";
    private String errorMsg = "";
    private long roundTripTime = 0;
    private String spaceCustomData = "";
    private String adSourceCustomData = "";
    private String adType = "";
    private String bidType = "";
    private String floorPrice = "";
    private String loadType = "";
    private String adCount = "";
    private String maxWaitTime = "";
    private String sessionId = "";

    public String getAdCount() {
        return this.adCount;
    }

    public String getAdSourceAppId() {
        return this.adSourceAppId;
    }

    public String getAdSourceCustomData() {
        return this.adSourceCustomData;
    }

    public String getAdSourceId() {
        return this.adSourceId;
    }

    public String getAdSourceSpaceId() {
        return this.adSourceSpaceId;
    }

    public String getAdType() {
        return this.adType;
    }

    public String getBidType() {
        return this.bidType;
    }

    public String getEcpm() {
        return this.ecpm;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getEventId() {
        return AMPSStringUtil.createRequestId();
    }

    public long getEventTime() {
        return DeviceInfoUtil.getTimeStamp();
    }

    public String getFloorPrice() {
        return this.floorPrice;
    }

    public String getLoadType() {
        return this.loadType;
    }

    public String getLogTime() {
        return DeviceInfoUtil.getTimeStamp() + "";
    }

    public String getMaxWaitTime() {
        return this.maxWaitTime;
    }

    public String getMediationAppId() {
        return this.mediationAppId;
    }

    public String getMediationSpaceId() {
        return this.mediationSpaceId;
    }

    public long getRoundTripTime() {
        return this.roundTripTime;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSpaceCustomData() {
        return this.spaceCustomData;
    }

    public void setAdCount(String str) {
        this.adCount = str;
    }

    public void setAdSourceAppId(String str) {
        this.adSourceAppId = str;
    }

    public void setAdSourceCustomData(String str) {
        this.adSourceCustomData = str;
    }

    public void setAdSourceId(String str) {
        this.adSourceId = str;
    }

    public void setAdSourceSpaceId(String str) {
        this.adSourceSpaceId = str;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setBidType(String str) {
        this.bidType = str;
    }

    public void setEcpm(String str) {
        this.ecpm = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setFloorPrice(String str) {
        this.floorPrice = str;
    }

    public void setLoadType(String str) {
        this.loadType = str;
    }

    public void setMaxWaitTime(String str) {
        this.maxWaitTime = str;
    }

    public void setMediationAppId(String str) {
        this.mediationAppId = str;
    }

    public void setMediationSpaceId(String str) {
        this.mediationSpaceId = str;
    }

    public void setRoundTripTime(long j4) {
        this.roundTripTime = j4;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSpaceCustomData(String str) {
        this.spaceCustomData = str;
    }
}
