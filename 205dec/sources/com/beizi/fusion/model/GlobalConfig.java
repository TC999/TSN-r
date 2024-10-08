package com.beizi.fusion.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GlobalConfig {
    @JsonNode(key = "adPlusConfig")
    private AdPlusConfig adPlusConfig;
    @JsonNode(key = "bannerExcutorForLieYing")
    private Object bannerExcutorForLieYing;
    @JsonNode(key = "configVersion")
    private String configVersion;
    @JsonNode(key = "configurator")
    private Configurator configurator;
    @JsonNode(key = "crashUrl")
    private String crashUrl;
    @JsonNode(key = "expireTime")
    private int expireTime;
    @JsonNode(key = "hr")
    private Object hr;
    @JsonNode(key = "incentiveConfig")
    private IncentiveConfig incentiveConfig;
    @JsonNode(key = "lastUpdateTime")
    private long lastUpdateTime;
    @JsonNode(key = "manager")
    private Manager manager;
    @JsonNode(key = "maxValidTime")
    private long maxValidTime;
    @JsonNode(key = "messenger")
    private Messenger messenger;
    @JsonNode(key = "smFlag")
    private String smFlag;
    @JsonNode(key = "taskConfig")
    private TaskConfig taskConfig;

    public static GlobalConfig objectFromData(String str) {
        try {
            return (GlobalConfig) JsonResolver.fromJson(str, (Class<Object>) GlobalConfig.class);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String objectToJson(Object obj) {
        try {
            return JsonResolver.toJson(obj, GlobalConfig.class);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public AdPlusConfig getAdPlusConfig() {
        return this.adPlusConfig;
    }

    public Object getBannerExcutorForLieYing() {
        return this.bannerExcutorForLieYing;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public Configurator getConfigurator() {
        return this.configurator;
    }

    public String getCrashUrl() {
        return this.crashUrl;
    }

    public int getExpireTime() {
        return this.expireTime;
    }

    public Object getHr() {
        return this.hr;
    }

    public IncentiveConfig getIncentiveConfig() {
        return this.incentiveConfig;
    }

    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public Manager getManager() {
        return this.manager;
    }

    public long getMaxValidTime() {
        return this.maxValidTime;
    }

    public Messenger getMessenger() {
        return this.messenger;
    }

    public String getSmFlag() {
        return this.smFlag;
    }

    public TaskConfig getTaskConfig() {
        return this.taskConfig;
    }

    public void setAdPlusConfig(AdPlusConfig adPlusConfig) {
        this.adPlusConfig = adPlusConfig;
    }

    public void setBannerExcutorForLieYing(Object obj) {
        this.bannerExcutorForLieYing = obj;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setConfigurator(Configurator configurator) {
        this.configurator = configurator;
    }

    public void setCrashUrl(String str) {
        this.crashUrl = str;
    }

    public void setExpireTime(int i4) {
        this.expireTime = i4;
    }

    public void setHr(Object obj) {
        this.hr = obj;
    }

    public void setIncentiveConfig(IncentiveConfig incentiveConfig) {
        this.incentiveConfig = incentiveConfig;
    }

    public void setLastUpdateTime(long j4) {
        this.lastUpdateTime = j4;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setMaxValidTime(long j4) {
        this.maxValidTime = j4;
    }

    public void setMessenger(Messenger messenger) {
        this.messenger = messenger;
    }

    public void setSmFlag(String str) {
        this.smFlag = str;
    }

    public void setTaskConfig(TaskConfig taskConfig) {
        this.taskConfig = taskConfig;
    }

    public static GlobalConfig objectFromData(String str, String str2) {
        try {
            return (GlobalConfig) JsonResolver.fromJson(new JSONObject(str).getString(str), (Class<Object>) GlobalConfig.class);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
