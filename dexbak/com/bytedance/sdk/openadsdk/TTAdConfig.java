package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TTAdConfig extends CSJConfig {

    /* renamed from: ok */
    private ITTLiveTokenInjectionAuth f22338ok;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Builder {

        /* renamed from: a */
        private CSJConfig.C6264ok f22339a = new CSJConfig.C6264ok();

        /* renamed from: ok */
        private ITTLiveTokenInjectionAuth f22340ok;

        public Builder allowShowNotify(boolean z) {
            this.f22339a.m36828a(z);
            return this;
        }

        public Builder appId(String str) {
            this.f22339a.m36811ok(str);
            return this;
        }

        public Builder appName(String str) {
            this.f22339a.m36829a(str);
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig(this.f22339a);
            tTAdConfig.setInjectionAuth(this.f22340ok);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.f22339a.m36813ok(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.f22339a.m36802s(str);
            return this;
        }

        public Builder debug(boolean z) {
            this.f22339a.m36824bl(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f22339a.m36809ok(iArr);
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.f22340ok = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.f22339a.m36825bl(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.f22339a.m36810ok(z);
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.f22339a.m36804s(i);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.f22339a.m36812ok(iMediationConfig);
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.f22339a.m36827bl(i);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.f22339a.m36816n(z);
            return this;
        }

        public Builder themeStatus(int i) {
            this.f22339a.m36831a(i);
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.f22339a.m36815ok(i);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.f22339a.m36818kf(z);
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.f22339a.m36801s(z);
            return this;
        }
    }

    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.f22338ok;
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f22338ok = iTTLiveTokenInjectionAuth;
    }

    private TTAdConfig(CSJConfig.C6264ok c6264ok) {
        super(c6264ok);
    }
}
