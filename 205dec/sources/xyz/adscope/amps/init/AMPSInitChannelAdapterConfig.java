package xyz.adscope.amps.init;

import xyz.adscope.amps.config.AMPSPrivacyConfig;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSInitChannelAdapterConfig {
    private String appName;
    private String customOAID;
    private boolean debug;
    private String optionInfo;
    private boolean personalRecommend;
    private AMPSPrivacyConfig privacyConfig;
    private String userId;

    public void clear() {
        this.privacyConfig = null;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCustomOAID() {
        return this.customOAID;
    }

    public String getOptionInfo() {
        return this.optionInfo;
    }

    public AMPSPrivacyConfig getPrivacyConfig() {
        return this.privacyConfig;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isPersonalRecommend() {
        return this.personalRecommend;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCustomOAID(String str) {
        this.customOAID = str;
    }

    public void setDebug(boolean z3) {
        this.debug = z3;
    }

    public void setOptionInfo(String str) {
        this.optionInfo = str;
    }

    public void setPersonalRecommend(boolean z3) {
        this.personalRecommend = z3;
    }

    public void setPrivacyConfig(AMPSPrivacyConfig aMPSPrivacyConfig) {
        this.privacyConfig = aMPSPrivacyConfig;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
