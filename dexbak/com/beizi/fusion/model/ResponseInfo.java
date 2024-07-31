package com.beizi.fusion.model;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.EventCar;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p066d.selfAdManagerHolder;
import com.beizi.fusion.p072g.AesUtils;
import com.beizi.fusion.p072g.C3112ad;
import com.beizi.fusion.p072g.C3137at;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
        EventCar.m48869a(this.context).m48868a(new EventBean(AdManager.f11053b, "", "410.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
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
        EventCar.m48869a(this.context).m48868a(new EventBean(AdManager.f11053b, "", "410.000", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        String str = (String) C3137at.m48313b(this.context, "globalConfig", BeiZis.getTransferProtocol() ? DEFAULT_HTTPS_CONFIG_FILE : DEFAULT_CONFIG_FILE);
        if (!TextUtils.isEmpty(str)) {
            String m48269b = AesUtils.m48269b(C3112ad.m48504a(), str);
            if (m48269b != null) {
                GlobalConfig objectFromData = GlobalConfig.objectFromData(m48269b);
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
                    selfAdManagerHolder.m48577a(this.context);
                    selfAdManagerHolder.m48576a(this.context, this.incentiveConfig);
                    EventCar.m48869a(this.context).m48868a(new EventBean(AdManager.f11053b, "", "410.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
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

    public void setExpireTime(long j) {
        this.expireTime = j;
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

    public void setMaxValidTime(long j) {
        this.maxValidTime = j;
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
