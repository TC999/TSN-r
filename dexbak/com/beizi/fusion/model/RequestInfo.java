package com.beizi.fusion.model;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p072g.C3138av;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestInfo {
    private static RequestInfo mInstance;
    private String adConfigVersion;
    private String appId;
    private String appVersion;
    private String appVersionCode;
    private String channelStr;
    private String configVersion;
    private Context context;
    private String customOaid;
    private DevInfo devInfo;
    private EnvInfo envInfo;
    private String eventVersion;
    private String installTime;
    public boolean isInit = false;
    private String nowTime;
    private String packageName;
    private String sdkVersion;
    private String taskVersion;
    private String updateTime;

    private RequestInfo(Context context) {
        this.context = context;
    }

    public static RequestInfo getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RequestInfo.class) {
                if (mInstance == null) {
                    mInstance = new RequestInfo(context);
                }
            }
        }
        return mInstance;
    }

    public String getAdConfigVersion() {
        return this.adConfigVersion;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getChannelStr() {
        return this.channelStr;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public String getCustomOaid() {
        return this.customOaid;
    }

    public DevInfo getDevInfo() {
        return this.devInfo;
    }

    public EnvInfo getEnvInfo() {
        return this.envInfo;
    }

    public String getEventVersion() {
        return this.eventVersion;
    }

    public String getInstallTime() {
        return this.installTime;
    }

    public String getNowTime() {
        return this.nowTime;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getTaskVersion() {
        return this.taskVersion;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public RequestInfo init() {
        this.appId = AdManager.m48786a().m48782b();
        this.channelStr = AdManager.m48786a().m48780c();
        if (!TextUtils.isEmpty(AdManager.m48786a().m48779d())) {
            this.customOaid = AdManager.m48786a().m48779d();
        } else if (BeiZis.getCustomController() != null) {
            String devOaid = BeiZis.getCustomController().getDevOaid();
            if (!TextUtils.isEmpty(devOaid)) {
                this.customOaid = devOaid;
            }
        }
        this.packageName = C3138av.m48296c(this.context);
        this.installTime = String.valueOf(C3138av.m48305a(this.context));
        this.updateTime = String.valueOf(C3138av.m48299b(this.context));
        this.appVersion = C3138av.m48294d(this.context);
        this.appVersionCode = String.valueOf(C3138av.m48293e(this.context));
        this.sdkVersion = "4.90.4.5";
        this.devInfo = new DevInfo(this.context);
        this.envInfo = new EnvInfo(this.context);
        this.isInit = true;
        return mInstance;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void setAdConfigVersion(String str) {
        this.adConfigVersion = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setAppVersionCode(String str) {
        this.appVersionCode = str;
    }

    public void setChannelStr(String str) {
        this.channelStr = str;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setCustomOaid(String str) {
        this.customOaid = str;
    }

    public void setDevInfo(DevInfo devInfo) {
        this.devInfo = devInfo;
    }

    public void setEnvInfo(EnvInfo envInfo) {
        this.envInfo = envInfo;
    }

    public void setEventVersion(String str) {
        this.eventVersion = str;
    }

    public void setInstallTime(String str) {
        this.installTime = str;
    }

    public void setNowTime(String str) {
        this.nowTime = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setTaskVersion(String str) {
        this.taskVersion = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }
}
