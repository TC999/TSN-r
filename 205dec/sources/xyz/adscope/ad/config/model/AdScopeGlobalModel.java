package xyz.adscope.ad.config.model;

import xyz.adscope.ad.config.AdInitConfig;
import xyz.adscope.ad.model.http.response.config.ConfigureResponseModel;
import xyz.adscope.ad.tool.event.ASNPUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeGlobalModel {
    private String appId;
    private ConfigureResponseModel configureModel;
    private boolean isInitSuccess;
    private boolean isUpdateConfigure;
    private String roundTripTime;
    private long sdkInitEndTime;
    private long sdkInitStartTime;
    private AdInitConfig settings;
    private String startId;
    private boolean waitResults;

    public String getAppId() {
        return this.appId;
    }

    public ConfigureResponseModel getConfigureModel() {
        return this.configureModel;
    }

    public String getEventId() {
        return ASNPUtil.createRequestId();
    }

    public String getRoundTripTime() {
        return this.roundTripTime;
    }

    public long getSdkInitEndTime() {
        return this.sdkInitEndTime;
    }

    public long getSdkInitStartTime() {
        return this.sdkInitStartTime;
    }

    public String getSessionId() {
        return "";
    }

    public AdInitConfig getSettings() {
        return this.settings;
    }

    public String getStartId() {
        return this.startId;
    }

    public boolean isInitSuccess() {
        return this.isInitSuccess;
    }

    public boolean isUpdateConfigure() {
        return this.isUpdateConfigure;
    }

    public boolean isWaitResults() {
        return this.waitResults;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setConfigureModel(ConfigureResponseModel configureResponseModel) {
        this.configureModel = configureResponseModel;
    }

    public void setInitSuccess(boolean z3) {
        this.isInitSuccess = z3;
    }

    public void setRoundTripTime(String str) {
        this.roundTripTime = str;
    }

    public void setSdkInitEndTime(long j4) {
        this.sdkInitEndTime = j4;
    }

    public void setSdkInitStartTime(long j4) {
        this.sdkInitStartTime = j4;
    }

    public void setSettings(AdInitConfig adInitConfig) {
        this.settings = adInitConfig;
    }

    public void setStartId(String str) {
        this.startId = str;
    }

    public void setUpdateConfigure(boolean z3) {
        this.isUpdateConfigure = z3;
    }

    public void setWaitResults(boolean z3) {
        this.waitResults = z3;
    }
}
