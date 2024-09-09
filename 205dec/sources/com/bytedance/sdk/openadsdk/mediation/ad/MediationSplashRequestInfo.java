package com.bytedance.sdk.openadsdk.mediation.ad;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {

    /* renamed from: c  reason: collision with root package name */
    private String f36012c;
    private String sr;

    /* renamed from: w  reason: collision with root package name */
    private String f36013w;
    private String xv;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.f36012c = str;
        this.f36013w = str2;
        this.xv = str3;
        this.sr = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnName() {
        return this.f36012c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnSlotId() {
        return this.f36013w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppId() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppkey() {
        return this.sr;
    }
}
