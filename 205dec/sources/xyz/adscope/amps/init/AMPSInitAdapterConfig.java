package xyz.adscope.amps.init;

import xyz.adscope.amps.config.AMPSPrivacyConfig;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSInitAdapterConfig {
    private AMPSInitChannelAdapterConfig ampsInitChannelAdapterConfig;
    private String appId;

    public AMPSInitChannelAdapterConfig getAmpsInitChannelAdapterConfig() {
        return this.ampsInitChannelAdapterConfig;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        return aMPSInitChannelAdapterConfig != null ? aMPSInitChannelAdapterConfig.getAppName() : "";
    }

    public String getCustomOAID() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        return aMPSInitChannelAdapterConfig != null ? aMPSInitChannelAdapterConfig.getCustomOAID() : "";
    }

    public String getOptionInfo() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        if (aMPSInitChannelAdapterConfig != null) {
            return aMPSInitChannelAdapterConfig.getOptionInfo();
        }
        return null;
    }

    public AMPSPrivacyConfig getPrivacyConfig() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        if (aMPSInitChannelAdapterConfig != null) {
            return aMPSInitChannelAdapterConfig.getPrivacyConfig();
        }
        return null;
    }

    public String getUserId() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        return aMPSInitChannelAdapterConfig != null ? aMPSInitChannelAdapterConfig.getUserId() : "";
    }

    public boolean isDebug() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        if (aMPSInitChannelAdapterConfig != null) {
            return aMPSInitChannelAdapterConfig.isDebug();
        }
        return false;
    }

    public boolean isPersonalRecommend() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        if (aMPSInitChannelAdapterConfig != null) {
            return aMPSInitChannelAdapterConfig.isPersonalRecommend();
        }
        return false;
    }

    public void setAmpsInitChannelAdapterConfig(AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig) {
        this.ampsInitChannelAdapterConfig = aMPSInitChannelAdapterConfig;
    }

    public void setAppId(String str) {
        this.appId = str;
    }
}
