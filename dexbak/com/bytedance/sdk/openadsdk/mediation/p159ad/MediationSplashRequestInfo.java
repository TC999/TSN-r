package com.bytedance.sdk.openadsdk.mediation.p159ad;

import androidx.annotation.Nullable;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.MediationSplashRequestInfo */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {

    /* renamed from: a */
    private String f22672a;

    /* renamed from: bl */
    private String f22673bl;

    /* renamed from: ok */
    private String f22674ok;

    /* renamed from: s */
    private String f22675s;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.f22674ok = str;
        this.f22672a = str2;
        this.f22673bl = str3;
        this.f22675s = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnName() {
        return this.f22674ok;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnSlotId() {
        return this.f22672a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppId() {
        return this.f22673bl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppkey() {
        return this.f22675s;
    }
}
