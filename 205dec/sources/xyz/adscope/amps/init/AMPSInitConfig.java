package xyz.adscope.amps.init;

import android.text.TextUtils;
import java.util.List;
import xyz.adscope.amps.config.AMPSPrivacyConfig;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMPSInitConfig {
    private List<String> adapterNameList;
    private String customOAID;
    private boolean debug;
    private AMPSPrivacyConfig privacyConfig;
    private String appId = "";
    private String appName = "";
    private boolean personalRecommend = true;
    private String optionInfo = "";
    private String province = "";
    private String city = "";
    private String region = "";
    private String customGAID = "";
    private String userId = "";
    private boolean isUseHttps = false;

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Builder {
        private List<String> adapterNameList;
        private boolean debug;
        private AMPSPrivacyConfig privacyConfig;
        private String appId = "";
        private String appName = "";
        private String optionInfo = "";
        private String province = "";
        private String city = "";
        private String region = "";
        private String customGAID = "";
        private String userId = "";
        private boolean isUseHttps = false;

        public AMPSInitConfig build() {
            AMPSInitConfig aMPSInitConfig = new AMPSInitConfig();
            aMPSInitConfig.setAppId(this.appId);
            aMPSInitConfig.setAppName(this.appName);
            aMPSInitConfig.setDebug(this.debug);
            AMPSPrivacyConfig aMPSPrivacyConfig = this.privacyConfig;
            if (aMPSPrivacyConfig != null && !aMPSPrivacyConfig.isSupportPersonalized()) {
                aMPSInitConfig.setPersonalRecommend(false);
            }
            aMPSInitConfig.setPrivacyConfig(this.privacyConfig);
            aMPSInitConfig.setAdapterNameList(this.adapterNameList);
            aMPSInitConfig.setOptionInfo(this.optionInfo);
            aMPSInitConfig.setProvince(this.province);
            aMPSInitConfig.setCity(this.city);
            aMPSInitConfig.setUseHttps(this.isUseHttps);
            AMPSPrivacyConfig aMPSPrivacyConfig2 = this.privacyConfig;
            if (aMPSPrivacyConfig2 != null && !TextUtils.isEmpty(aMPSPrivacyConfig2.getDevOaid())) {
                aMPSInitConfig.setCustomOAID(this.privacyConfig.getDevOaid());
            }
            aMPSInitConfig.setCustomGAID(this.customGAID);
            aMPSInitConfig.setUserId(this.userId);
            return aMPSInitConfig;
        }

        public Builder openDebugLog(boolean z3) {
            this.debug = z3;
            return this;
        }

        public Builder setAMPSPrivacyConfig(AMPSPrivacyConfig aMPSPrivacyConfig) {
            this.privacyConfig = aMPSPrivacyConfig;
            return this;
        }

        public Builder setAdapterNameList(List<String> list) {
            this.adapterNameList = list;
            return this;
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setCity(String str) {
            this.city = str;
            return this;
        }

        public Builder setCustomGAID(String str) {
            this.customGAID = str;
            return this;
        }

        public Builder setIsUseHttps(boolean z3) {
            this.isUseHttps = z3;
            return this;
        }

        public Builder setOptionInfoMap(String str) {
            this.optionInfo = str;
            return this;
        }

        public Builder setProvince(String str) {
            this.province = str;
            return this;
        }

        public Builder setRegion(String str) {
            this.region = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdapterNameList(List<String> list) {
        this.adapterNameList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppId(String str) {
        this.appId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppName(String str) {
        this.appName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCity(String str) {
        this.city = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustomGAID(String str) {
        this.customGAID = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustomOAID(String str) {
        this.customOAID = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDebug(boolean z3) {
        this.debug = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptionInfo(String str) {
        this.optionInfo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrivacyConfig(AMPSPrivacyConfig aMPSPrivacyConfig) {
        this.privacyConfig = aMPSPrivacyConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProvince(String str) {
        this.province = str;
    }

    private void setRegion(String str) {
        this.region = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUseHttps(boolean z3) {
        this.isUseHttps = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserId(String str) {
        this.userId = str;
    }

    public void clear() {
        this.privacyConfig = null;
        List<String> list = this.adapterNameList;
        if (list != null) {
            list.clear();
            this.adapterNameList = null;
        }
    }

    public List<String> getAdapterNameList() {
        return this.adapterNameList;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCity() {
        return this.city;
    }

    public String getCustomGAID() {
        return this.customGAID;
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

    public String getProvince() {
        return this.province;
    }

    public String getRegion() {
        return this.region;
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

    public boolean isUseHttps() {
        return this.isUseHttps;
    }

    public void setPersonalRecommend(boolean z3) {
        this.personalRecommend = z3;
    }
}
