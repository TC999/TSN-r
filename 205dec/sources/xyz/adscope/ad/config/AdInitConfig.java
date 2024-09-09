package xyz.adscope.ad.config;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import xyz.adscope.ad.config.inter.IAdInitConfig;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestEnum;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdInitConfig implements IAdInitConfig {
    public static final String AD_SCOPE_ADN = "AdScopeADN";
    private AdscopeCustomController adscopeCustomController;
    private Builder builder;
    private String darkColor;
    private boolean isDebugSetting;
    private String lightColor;
    private Map<String, String> optionalFields;
    private int testAd;
    private int uiMode;
    private String KEY_LIGHT_COLOR = "lightColor";
    private String KEY_DARK_COLOR = "darkColor";
    private String appId = "";
    private String appName = "";
    private String apiKey = "";
    private String cgaid = "";
    private int coppa = AdRequestEnum.COPPA_TYPE.COPPA_PERMITTED_TYPE.getCode();
    private int GDPR = AdRequestEnum.GDPR_TYPE.GDPR_PERMITTED_TYPE.getCode();
    private int CCPA = AdRequestEnum.CCPA_TYPE.CCPA_ADULT_TYPE.getCode();
    private boolean isSyncInit = true;
    private boolean isUseHttps = false;
    private String userId = "";
    private int country_CN = 0;
    private String currency = "";

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {
        private WeakReference<AdscopeCustomController> adscopeCustomController;
        private int countryCN;
        private boolean isDebugSetting;
        private boolean isSyncInit;
        private boolean isUseHttps;
        private Map<String, String> optionalFields;
        private int testAd;
        private int uiMode;
        private String appId = "";
        private String appName = "";
        private String apiKey = "";
        private String userId = "";
        private String cgaid = "";
        private String currency = "";

        public Builder apiKey(String str) {
            this.apiKey = str;
            return this;
        }

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        public AdInitConfig build() {
            AdInitConfig adInitConfig = new AdInitConfig();
            adInitConfig.setAppId(this.appId);
            adInitConfig.setAppName(this.appName);
            adInitConfig.setApiKey(this.apiKey);
            adInitConfig.setIsDebugSetting(this.isDebugSetting);
            adInitConfig.setSyncInit(this.isSyncInit);
            adInitConfig.setIsUseHttps(this.isUseHttps);
            adInitConfig.setUserId(this.userId);
            adInitConfig.setCgaid(this.cgaid);
            adInitConfig.setCurrency(this.currency);
            adInitConfig.setOptionalFields(this.optionalFields);
            adInitConfig.setAdscopeCustomController(this.adscopeCustomController.get());
            adInitConfig.setCountry_CN(this.countryCN);
            adInitConfig.setTestAd(this.testAd);
            adInitConfig.setUiMode(this.uiMode);
            adInitConfig.setBuilder(this);
            return adInitConfig;
        }

        public Builder cgaid(String str) {
            this.cgaid = str;
            return this;
        }

        public Builder countryCN(int i4) {
            this.countryCN = i4;
            return this;
        }

        public Builder currency(String str) {
            this.currency = this.currency;
            return this;
        }

        public Builder isDebugSetting(boolean z3) {
            this.isDebugSetting = z3;
            return this;
        }

        public Builder isSyncInit(boolean z3) {
            this.isSyncInit = z3;
            return this;
        }

        public Builder isUseHttps(boolean z3) {
            this.isUseHttps = z3;
            return this;
        }

        public Builder optionalFields(Map<String, String> map) {
            this.optionalFields = map;
            return this;
        }

        public Builder setAdscopeCustomController(AdscopeCustomController adscopeCustomController) {
            this.adscopeCustomController = new WeakReference<>(adscopeCustomController);
            return this;
        }

        public Builder testAd(int i4) {
            this.testAd = i4;
            return this;
        }

        public Builder uiMode(int i4) {
            this.uiMode = i4;
            return this;
        }

        public Builder userId(String str) {
            this.userId = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApiKey(String str) {
        this.apiKey = str;
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
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsDebugSetting(boolean z3) {
        this.isDebugSetting = z3;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public int CCPA() {
        AdscopeCustomController adscopeCustomController = this.adscopeCustomController;
        if (adscopeCustomController != null) {
            int tagForUnderAgeOfConsent = adscopeCustomController.getTagForUnderAgeOfConsent();
            AdRequestEnum.CCPA_TYPE ccpa_type = AdRequestEnum.CCPA_TYPE.CCPA_ADULT_TYPE;
            AdRequestEnum.CCPA_TYPE ccpa_type2 = AdRequestEnum.CCPA_TYPE.CCPA_CHILD_TYPE;
            if (tagForUnderAgeOfConsent == ccpa_type2.getCode()) {
                return ccpa_type2.getCode();
            }
        }
        return this.CCPA;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public int GDPR() {
        AdscopeCustomController adscopeCustomController = this.adscopeCustomController;
        if (adscopeCustomController != null) {
            int tagForUnderAgeOfConsent = adscopeCustomController.getTagForUnderAgeOfConsent();
            AdRequestEnum.GDPR_TYPE gdpr_type = AdRequestEnum.GDPR_TYPE.GDPR_NOT_PERMITTED_TYPE;
            if (tagForUnderAgeOfConsent == gdpr_type.getCode()) {
                return gdpr_type.getCode();
            }
        }
        return this.GDPR;
    }

    public void clear() {
        this.adscopeCustomController = null;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public int coppa() {
        AdscopeCustomController adscopeCustomController = this.adscopeCustomController;
        if (adscopeCustomController != null) {
            int tagForUnderAgeOfConsent = adscopeCustomController.getTagForUnderAgeOfConsent();
            AdRequestEnum.COPPA_TYPE coppa_type = AdRequestEnum.COPPA_TYPE.COPPA_NOT_PERMITTED_TYPE;
            if (tagForUnderAgeOfConsent == coppa_type.getCode()) {
                return coppa_type.getCode();
            }
        }
        return this.coppa;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public int countryCN() {
        return this.country_CN;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public AdscopeCustomController getAdscopeCustomController() {
        return this.adscopeCustomController;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public String getApiKey() {
        return this.apiKey;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public String getAppId() {
        return this.appId;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public String getAppName() {
        return this.appName;
    }

    public Builder getBuilder() {
        return this.builder;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public String getCgaid() {
        return this.cgaid;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public String getChannel() {
        return this.apiKey + "_" + this.appId;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public String getCoaid() {
        AdscopeCustomController adscopeCustomController = this.adscopeCustomController;
        return adscopeCustomController != null ? adscopeCustomController.getOaid() : "";
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public String getCurrency() {
        return this.currency;
    }

    public String getDarkColor() {
        if (!TextUtils.isEmpty(this.darkColor)) {
            return this.darkColor;
        }
        Map<String, String> map = this.optionalFields;
        if (map != null && map.containsKey(this.KEY_DARK_COLOR)) {
            this.darkColor = this.optionalFields.get(this.KEY_DARK_COLOR);
        }
        return this.darkColor;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public boolean getDebugSetting() {
        return this.isDebugSetting;
    }

    public String getLightColor() {
        if (!TextUtils.isEmpty(this.lightColor)) {
            return this.lightColor;
        }
        Map<String, String> map = this.optionalFields;
        if (map != null && map.containsKey(this.KEY_LIGHT_COLOR)) {
            this.lightColor = this.optionalFields.get(this.KEY_LIGHT_COLOR);
        }
        return this.lightColor;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public Map<String, String> getOptionalFields() {
        return this.optionalFields;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public boolean getPersonalRecommend() {
        AdscopeCustomController adscopeCustomController = this.adscopeCustomController;
        if (adscopeCustomController != null) {
            return adscopeCustomController.isSupportPersonalized();
        }
        return true;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public int getTestAd() {
        return this.testAd;
    }

    public int getUiMode() {
        return this.uiMode;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public String getUserId() {
        return this.userId;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public boolean isSyncInit() {
        return this.isSyncInit;
    }

    @Override // xyz.adscope.ad.config.inter.IAdInitConfig
    public boolean isUseHttps() {
        return this.isUseHttps;
    }

    public void setAdscopeCustomController(AdscopeCustomController adscopeCustomController) {
        this.adscopeCustomController = adscopeCustomController;
    }

    public void setCgaid(String str) {
        this.cgaid = str;
    }

    public void setCountry_CN(int i4) {
        this.country_CN = i4;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setIsUseHttps(boolean z3) {
        this.isUseHttps = z3;
    }

    public void setOptionalFields(Map<String, String> map) {
        this.optionalFields = map;
    }

    public void setSyncInit(boolean z3) {
        this.isSyncInit = z3;
    }

    public void setTestAd(int i4) {
        this.testAd = i4;
    }

    public void setUiMode(int i4) {
        this.uiMode = i4;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
