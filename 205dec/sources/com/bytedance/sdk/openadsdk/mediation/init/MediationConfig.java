package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationConfig implements IMediationConfig {

    /* renamed from: c  reason: collision with root package name */
    private String f36142c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f36143f;
    private boolean gd;

    /* renamed from: k  reason: collision with root package name */
    private String f36144k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f36145p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f36146r;
    private Map<String, Object> sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f36147w;
    private MediationConfigUserInfoForSegment xv;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class Builder {

        /* renamed from: c  reason: collision with root package name */
        private String f36148c;
        private String ev;

        /* renamed from: f  reason: collision with root package name */
        private JSONObject f36149f;
        private boolean gd;

        /* renamed from: k  reason: collision with root package name */
        private String f36150k;

        /* renamed from: p  reason: collision with root package name */
        private boolean f36151p;

        /* renamed from: r  reason: collision with root package name */
        private boolean f36152r;
        private Map<String, Object> sr;
        private boolean ux;

        /* renamed from: w  reason: collision with root package name */
        private boolean f36153w;
        private MediationConfigUserInfoForSegment xv;

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.f36142c = this.f36148c;
            mediationConfig.f36147w = this.f36153w;
            mediationConfig.xv = this.xv;
            mediationConfig.sr = this.sr;
            mediationConfig.ux = this.ux;
            mediationConfig.f36143f = this.f36149f;
            mediationConfig.f36146r = this.f36152r;
            mediationConfig.ev = this.ev;
            mediationConfig.gd = this.gd;
            mediationConfig.f36145p = this.f36151p;
            mediationConfig.f36144k = this.f36150k;
            return mediationConfig;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.f36149f = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z3) {
            this.ux = z3;
            return this;
        }

        public Builder setLocalExtra(Map<String, Object> map) {
            this.sr = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.xv = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z3) {
            this.f36153w = z3;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.ev = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.f36148c = str;
            return this;
        }

        public Builder setSupportH265(boolean z3) {
            this.gd = z3;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z3) {
            this.f36151p = z3;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.f36150k = str;
            return this;
        }

        public Builder setWxInstalled(boolean z3) {
            this.f36152r = z3;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.f36143f;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.ev;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.f36142c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.f36147w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.gd;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.f36145p;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.f36146r;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.f36144k;
    }

    private MediationConfig() {
    }
}
