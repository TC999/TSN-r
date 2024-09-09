package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class TTAdConfig extends CSJConfig {
    private ITTLiveTokenInjectionAuth ok;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private CSJConfig.ok f31355a = new CSJConfig.ok();
        private ITTLiveTokenInjectionAuth ok;

        public Builder allowShowNotify(boolean z3) {
            this.f31355a.a(z3);
            return this;
        }

        public Builder appId(String str) {
            this.f31355a.ok(str);
            return this;
        }

        public Builder appName(String str) {
            this.f31355a.a(str);
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig(this.f31355a);
            tTAdConfig.setInjectionAuth(this.ok);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.f31355a.ok(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.f31355a.s(str);
            return this;
        }

        public Builder debug(boolean z3) {
            this.f31355a.bl(z3);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f31355a.ok(iArr);
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.ok = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.f31355a.bl(str);
            return this;
        }

        public Builder paid(boolean z3) {
            this.f31355a.ok(z3);
            return this;
        }

        public Builder setAgeGroup(int i4) {
            this.f31355a.s(i4);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.f31355a.ok(iMediationConfig);
            return this;
        }

        public Builder setPluginUpdateConfig(int i4) {
            this.f31355a.bl(i4);
            return this;
        }

        public Builder supportMultiProcess(boolean z3) {
            this.f31355a.n(z3);
            return this;
        }

        public Builder themeStatus(int i4) {
            this.f31355a.a(i4);
            return this;
        }

        public Builder titleBarTheme(int i4) {
            this.f31355a.ok(i4);
            return this;
        }

        public Builder useMediation(boolean z3) {
            this.f31355a.kf(z3);
            return this;
        }

        public Builder useTextureView(boolean z3) {
            this.f31355a.s(z3);
            return this;
        }
    }

    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.ok;
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.ok = iTTLiveTokenInjectionAuth;
    }

    private TTAdConfig(CSJConfig.ok okVar) {
        super(okVar);
    }
}
