package com.beizi.fusion.model;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.b.b;
import com.beizi.fusion.b.c;
import com.beizi.fusion.d.w;
import com.beizi.fusion.g.ad;
import com.beizi.fusion.g.au;
import com.beizi.fusion.g.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ResponseInfo {
    public static final String DEFAULT_CONFIG_FILE = "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";
    public static final String DEFAULT_HTTPS_CONFIG_FILE = "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";
    private static volatile ResponseInfo mInstance;
    private AdPlusConfig adPlusConfig;
    private String configVersion;
    private Configurator configurator;
    private Context context;
    private String crashUrl;
    private long expireTime;
    private GlobalConfig globalConfig;
    private IncentiveConfig incentiveConfig;
    private volatile boolean isInit = false;
    private Manager manager;
    private long maxValidTime;
    private Messenger messenger;
    private S2SBiddingConfig s2SBiddingConfig;
    private String smFlag;
    private TaskConfig taskConfig;

    private ResponseInfo(Context context) {
        this.context = context;
    }

    public static ResponseInfo getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ResponseInfo.class) {
                if (mInstance == null) {
                    mInstance = new ResponseInfo(context);
                }
            }
        }
        return mInstance;
    }

    private void initFail() {
        this.isInit = false;
        c.a(this.context).a(new b(com.beizi.fusion.d.b.f14592b, "", "410.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    public AdPlusConfig getAdPlusConfig() {
        return this.adPlusConfig;
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

    public long getExpireTime() {
        return this.expireTime;
    }

    public GlobalConfig getGlobalConfig() {
        return this.globalConfig;
    }

    public IncentiveConfig getIncentiveConfig() {
        return this.incentiveConfig;
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

    public S2SBiddingConfig getS2SBiddingConfig() {
        return this.s2SBiddingConfig;
    }

    public String getSmFlag() {
        return this.smFlag;
    }

    public TaskConfig getTaskConfig() {
        return this.taskConfig;
    }

    public synchronized ResponseInfo init() {
        c.a(this.context).a(new b(com.beizi.fusion.d.b.f14592b, "", "410.000", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        String str = (String) au.b(this.context, "globalConfig", BeiZis.getTransferProtocol() ? DEFAULT_HTTPS_CONFIG_FILE : DEFAULT_CONFIG_FILE);
        if (!TextUtils.isEmpty(str)) {
            String b4 = d.b(ad.a(), str);
            if (b4 != null) {
                GlobalConfig objectFromData = GlobalConfig.objectFromData(b4);
                this.globalConfig = objectFromData;
                if (objectFromData != null) {
                    this.configVersion = objectFromData.getConfigVersion();
                    this.expireTime = this.globalConfig.getExpireTime();
                    this.configurator = this.globalConfig.getConfigurator();
                    this.messenger = this.globalConfig.getMessenger();
                    this.manager = this.globalConfig.getManager();
                    this.taskConfig = this.globalConfig.getTaskConfig();
                    Configurator configurator = this.configurator;
                    if (configurator != null) {
                        this.s2SBiddingConfig = configurator.getS2sbidding();
                    }
                    this.adPlusConfig = this.globalConfig.getAdPlusConfig();
                    this.incentiveConfig = this.globalConfig.getIncentiveConfig();
                    this.crashUrl = this.globalConfig.getCrashUrl();
                    if (!TextUtils.isEmpty(this.globalConfig.getSmFlag())) {
                        this.smFlag = this.globalConfig.getSmFlag();
                    } else {
                        this.smFlag = "0";
                    }
                    this.isInit = true;
                    w.a(this.context);
                    c.a(this.context).a(new b(com.beizi.fusion.d.b.f14592b, "", "410.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                } else {
                    initFail();
                }
            } else {
                initFail();
            }
        } else {
            initFail();
        }
        return mInstance;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void setAdPlusConfig(AdPlusConfig adPlusConfig) {
        this.adPlusConfig = adPlusConfig;
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

    public void setExpireTime(long j4) {
        this.expireTime = j4;
    }

    public void setGlobalConfig(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    public void setIncentiveConfig(IncentiveConfig incentiveConfig) {
        this.incentiveConfig = incentiveConfig;
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

    public void setS2SBiddingConfig(S2SBiddingConfig s2SBiddingConfig) {
        this.s2SBiddingConfig = s2SBiddingConfig;
    }

    public void setSmFlag(String str) {
        this.smFlag = str;
    }

    public void setTaskConfig(TaskConfig taskConfig) {
        this.taskConfig = taskConfig;
    }
}
