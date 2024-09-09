package xyz.adscope.amps.report.model.request;

import xyz.adscope.common.json.util.JsonUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class EventModel {
    private String accessKey;
    private String adSourceAppId;
    private String adSourceId;
    private String adSourceSpaceId;
    private String adsCustomData;
    private String affiliated;
    private String biddingType;
    private String cfgCustomData;
    private String cfgVersion;
    private String customId;
    private String customLogger;
    private String ecpm;
    private String errorCode;
    private String errorInfo;
    private String eventCode;
    private String eventCustomData;
    private String eventId;
    private long eventTime;
    private String eventVersion;
    private String exception;
    private String logTime;
    private String logVersion;
    private String mdCustomData;
    private String mdVersion;
    private String mediationAppId;
    private String mediationSpaceId;
    private String roundTripTime;
    private String sessionId;
    private String startId;

    public EventModel() {
        this.logVersion = "";
        this.startId = "";
        this.sessionId = "";
        this.accessKey = "";
        this.customId = "";
        this.customLogger = "";
        this.mediationAppId = "";
        this.mediationSpaceId = "";
        this.adSourceId = "";
        this.adSourceAppId = "";
        this.adSourceSpaceId = "";
        this.ecpm = "";
        this.eventCode = "";
        this.eventId = "";
        this.eventTime = 0L;
        this.errorCode = "";
        this.errorInfo = "";
        this.logTime = "";
        this.cfgCustomData = "";
        this.eventCustomData = "";
        this.mdCustomData = "";
        this.adsCustomData = "";
        this.cfgVersion = "";
        this.eventVersion = "";
        this.mdVersion = "";
        this.roundTripTime = "";
        this.biddingType = "";
        this.affiliated = "";
        this.exception = "";
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getAdSourceAppId() {
        return this.adSourceAppId;
    }

    public String getAdSourceId() {
        return this.adSourceId;
    }

    public String getAdSourceSpaceId() {
        return this.adSourceSpaceId;
    }

    public String getAdsCustomData() {
        return this.adsCustomData;
    }

    public String getAffiliated() {
        return this.affiliated;
    }

    public String getBiddingType() {
        return this.biddingType;
    }

    public String getCfgCustomData() {
        return this.cfgCustomData;
    }

    public String getCfgVersion() {
        return this.cfgVersion;
    }

    public String getCustomId() {
        return this.customId;
    }

    public String getCustomLogger() {
        return this.customLogger;
    }

    public String getEcpm() {
        return this.ecpm;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public String getEventCustomData() {
        return this.eventCustomData;
    }

    public String getEventId() {
        return this.eventId;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public String getEventVersion() {
        return this.eventVersion;
    }

    public String getException() {
        return this.exception;
    }

    public String getLogTime() {
        return this.logTime;
    }

    public String getLogVersion() {
        return this.logVersion;
    }

    public String getMdCustomData() {
        return this.mdCustomData;
    }

    public String getMdVersion() {
        return this.mdVersion;
    }

    public String getMediationAppId() {
        return this.mediationAppId;
    }

    public String getMediationSpaceId() {
        return this.mediationSpaceId;
    }

    public String getRoundTripTime() {
        return this.roundTripTime;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getStartId() {
        return this.startId;
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public void setAdSourceAppId(String str) {
        this.adSourceAppId = str;
    }

    public void setAdSourceId(String str) {
        this.adSourceId = str;
    }

    public void setAdSourceSpaceId(String str) {
        this.adSourceSpaceId = str;
    }

    public void setAdsCustomData(String str) {
        this.adsCustomData = str;
    }

    public void setAffiliated(String str) {
        this.affiliated = str;
    }

    public void setBiddingType(String str) {
        this.biddingType = str;
    }

    public void setCfgCustomData(String str) {
        this.cfgCustomData = str;
    }

    public void setCfgVersion(String str) {
        this.cfgVersion = str;
    }

    public void setCustomId(String str) {
        this.customId = str;
    }

    public void setCustomLogger(String str) {
        this.customLogger = str;
    }

    public void setEcpm(String str) {
        this.ecpm = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorInfo(String str) {
        this.errorInfo = str;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setEventCustomData(String str) {
        this.eventCustomData = str;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventTime(long j4) {
        this.eventTime = j4;
    }

    public void setEventVersion(String str) {
        this.eventVersion = str;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void setLogTime(String str) {
        this.logTime = str;
    }

    public void setLogVersion(String str) {
        this.logVersion = str;
    }

    public void setMdCustomData(String str) {
        this.mdCustomData = str;
    }

    public void setMdVersion(String str) {
        this.mdVersion = str;
    }

    public void setMediationAppId(String str) {
        this.mediationAppId = str;
    }

    public void setMediationSpaceId(String str) {
        this.mediationSpaceId = str;
    }

    public void setRoundTripTime(String str) {
        this.roundTripTime = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setStartId(String str) {
        this.startId = str;
    }

    public String toString() {
        return "{\"startId\":\"" + this.startId + "\",\"logVersion\":\"" + this.logVersion + "\",\"sessionId\":\"" + this.sessionId + "\",\"accessKey\":\"" + this.accessKey + "\",\"customId\":\"" + this.customId + "\",\"customLogger\":\"" + this.customLogger + "\",\"mediationAppId\":\"" + this.mediationAppId + "\",\"mediationSpaceId\":\"" + this.mediationSpaceId + "\",\"adSourceId\":\"" + this.adSourceId + "\",\"adSourceAppId\":\"" + this.adSourceAppId + "\",\"adSourceSpaceId\":\"" + this.adSourceSpaceId + "\",\"ecpm\":\"" + this.ecpm + "\",\"eventCode\":\"" + this.eventCode + "\",\"eventId\":\"" + this.eventId + "\",\"eventTime\":" + this.eventTime + ",\"errorCode\":\"" + this.errorCode + "\",\"errorInfo\":\"" + this.errorInfo + "\",\"logTime\":\"" + this.logTime + "\",\"cfgCustomData\":\"" + JsonUtil.addEscapeChar(this.cfgCustomData) + "\",\"eventCustomData\":\"" + JsonUtil.addEscapeChar(this.eventCustomData) + "\",\"mdCustomData\":\"" + JsonUtil.addEscapeChar(this.mdCustomData) + "\",\"adsCustomData\":\"" + JsonUtil.addEscapeChar(this.adsCustomData) + "\",\"cfgVersion\":\"" + this.cfgVersion + "\",\"eventVersion\":\"" + this.eventVersion + "\",\"mdVersion\":\"" + this.mdVersion + "\",\"roundTripTime\":\"" + this.roundTripTime + "\",\"affiliated\":\"" + this.affiliated + "\",\"exception\":\"" + this.exception + "\",\"biddingType\":\"" + this.biddingType + "\"}";
    }

    public EventModel(EventModel eventModel) {
        this.logVersion = "";
        this.startId = "";
        this.sessionId = "";
        this.accessKey = "";
        this.customId = "";
        this.customLogger = "";
        this.mediationAppId = "";
        this.mediationSpaceId = "";
        this.adSourceId = "";
        this.adSourceAppId = "";
        this.adSourceSpaceId = "";
        this.ecpm = "";
        this.eventCode = "";
        this.eventId = "";
        this.eventTime = 0L;
        this.errorCode = "";
        this.errorInfo = "";
        this.logTime = "";
        this.cfgCustomData = "";
        this.eventCustomData = "";
        this.mdCustomData = "";
        this.adsCustomData = "";
        this.cfgVersion = "";
        this.eventVersion = "";
        this.mdVersion = "";
        this.roundTripTime = "";
        this.biddingType = "";
        this.affiliated = "";
        this.exception = "";
        this.logVersion = eventModel.getLogVersion();
        this.startId = eventModel.getStartId();
        this.sessionId = eventModel.getSessionId();
        this.accessKey = eventModel.getAccessKey();
        this.customId = eventModel.getCustomId();
        this.customLogger = eventModel.getCustomLogger();
        this.mediationAppId = eventModel.getMediationAppId();
        this.mediationSpaceId = eventModel.getMediationSpaceId();
        this.adSourceId = eventModel.getAdSourceId();
        this.adSourceAppId = eventModel.getAdSourceAppId();
        this.adSourceSpaceId = eventModel.getAdSourceSpaceId();
        this.ecpm = eventModel.getEcpm();
        this.eventCode = eventModel.getEventCode();
        this.eventId = eventModel.getEventId();
        this.eventTime = eventModel.getEventTime();
        this.errorCode = eventModel.getErrorCode();
        this.errorInfo = eventModel.getErrorInfo();
        this.logTime = eventModel.getLogTime();
        this.cfgCustomData = eventModel.getCfgCustomData();
        this.eventCustomData = eventModel.getEventCustomData();
        this.mdCustomData = eventModel.getMdCustomData();
        this.adsCustomData = eventModel.getAdsCustomData();
        this.cfgVersion = eventModel.getCfgVersion();
        this.eventVersion = eventModel.getEventVersion();
        this.mdVersion = eventModel.getMdVersion();
        this.roundTripTime = eventModel.getRoundTripTime();
        this.biddingType = eventModel.getBiddingType();
        this.affiliated = eventModel.getAffiliated();
        this.exception = eventModel.getException();
    }
}
