package xyz.adscope.amps.model;

import java.util.List;
import java.util.Map;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSAdapterModel {
    private int adCount;
    private AMPSInitAdapterConfig ampsInitAdapterConfig;
    private String appId;
    private int expressViewHeight;
    private int expressViewWidth;
    private String extra;
    private int isSendBidData;
    private String orientation;
    private Map<String, String> parameter;
    private String spaceId;
    private List<Integer> templateTypes;
    private int timeOut;
    private String userId;
    private int videoAutoPlay;
    private long videoMaxTime;
    private int videoSound = 0;
    private String zoomOut;

    public int getAdCount() {
        return this.adCount;
    }

    public AMPSInitAdapterConfig getAmpsInitAdapterConfig() {
        return this.ampsInitAdapterConfig;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getExpressViewHeight() {
        return this.expressViewHeight;
    }

    public int getExpressViewWidth() {
        return this.expressViewWidth;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getIsSendBidData() {
        return this.isSendBidData;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public Map<String, String> getParameter() {
        return this.parameter;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public List<Integer> getTemplateTypes() {
        return this.templateTypes;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public String getUserId() {
        return this.userId;
    }

    public int getVideoAutoPlay() {
        return this.videoAutoPlay;
    }

    public long getVideoMaxTime() {
        return this.videoMaxTime;
    }

    public int getVideoSound() {
        return this.videoSound;
    }

    public String getZoomOut() {
        return this.zoomOut;
    }

    public void setAdCount(int i4) {
        this.adCount = i4;
    }

    public void setAmpsInitAdapterConfig(AMPSInitAdapterConfig aMPSInitAdapterConfig) {
        this.ampsInitAdapterConfig = aMPSInitAdapterConfig;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setExpressViewHeight(int i4) {
        this.expressViewHeight = i4;
    }

    public void setExpressViewWidth(int i4) {
        this.expressViewWidth = i4;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setIsSendBidData(int i4) {
        this.isSendBidData = i4;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setParameter(Map<String, String> map) {
        this.parameter = map;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setTemplateTypes(List<Integer> list) {
        this.templateTypes = list;
    }

    public void setTimeOut(int i4) {
        this.timeOut = i4;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVideoAutoPlay(int i4) {
        this.videoAutoPlay = i4;
    }

    public void setVideoMaxTime(long j4) {
        this.videoMaxTime = j4;
    }

    public void setVideoSound(int i4) {
        this.videoSound = i4;
    }

    public void setZoomOut(String str) {
        this.zoomOut = str;
    }
}
