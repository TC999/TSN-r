package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationConfig implements IMediationConfig {

    /* renamed from: a */
    private boolean f22773a;

    /* renamed from: bl */
    private MediationConfigUserInfoForSegment f22774bl;

    /* renamed from: h */
    private boolean f22775h;

    /* renamed from: k */
    private boolean f22776k;

    /* renamed from: kf */
    private JSONObject f22777kf;

    /* renamed from: n */
    private boolean f22778n;

    /* renamed from: ok */
    private String f22779ok;

    /* renamed from: p */
    private String f22780p;

    /* renamed from: q */
    private boolean f22781q;

    /* renamed from: r */
    private String f22782r;

    /* renamed from: s */
    private Map<String, Object> f22783s;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class Builder {

        /* renamed from: a */
        private boolean f22784a;

        /* renamed from: bl */
        private MediationConfigUserInfoForSegment f22785bl;

        /* renamed from: h */
        private boolean f22786h;

        /* renamed from: k */
        private boolean f22787k;

        /* renamed from: kf */
        private JSONObject f22788kf;

        /* renamed from: n */
        private boolean f22789n;

        /* renamed from: ok */
        private String f22790ok;

        /* renamed from: p */
        private String f22791p;

        /* renamed from: q */
        private boolean f22792q;

        /* renamed from: r */
        private String f22793r;

        /* renamed from: s */
        private Map<String, Object> f22794s;

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.f22779ok = this.f22790ok;
            mediationConfig.f22773a = this.f22784a;
            mediationConfig.f22774bl = this.f22785bl;
            mediationConfig.f22783s = this.f22794s;
            mediationConfig.f22778n = this.f22789n;
            mediationConfig.f22777kf = this.f22788kf;
            mediationConfig.f22775h = this.f22786h;
            mediationConfig.f22780p = this.f22791p;
            mediationConfig.f22781q = this.f22792q;
            mediationConfig.f22776k = this.f22787k;
            mediationConfig.f22782r = this.f22793r;
            return mediationConfig;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.f22788kf = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.f22789n = z;
            return this;
        }

        public Builder setLocalExtra(Map<String, Object> map) {
            this.f22794s = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.f22785bl = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.f22784a = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.f22791p = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.f22790ok = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.f22792q = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.f22787k = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.f22793r = str;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.f22786h = z;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.f22777kf;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.f22778n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.f22783s;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.f22774bl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.f22780p;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.f22779ok;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.f22773a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.f22781q;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.f22776k;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.f22775h;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.f22782r;
    }

    private MediationConfig() {
    }
}
