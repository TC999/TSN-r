package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl extends MediationNativeAdAppInfo {
    private final Bridge ok;

    public bl(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, Object> getAppInfoExtra() {
        return (Map) this.ok.call(271042, com.bykv.ok.ok.ok.ok.a.c(0).a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAppName() {
        return (String) this.ok.call(271035, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAuthorName() {
        return (String) this.ok.call(271036, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getFunctionDescUrl() {
        return (String) this.ok.call(271047, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public long getPackageSizeBytes() {
        return ((Long) this.ok.call(271037, com.bykv.ok.ok.ok.ok.a.c(0).a(), Long.TYPE)).longValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.ok.call(271039, com.bykv.ok.ok.ok.ok.a.c(0).a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPermissionsUrl() {
        return (String) this.ok.call(271038, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPrivacyAgreement() {
        return (String) this.ok.call(271040, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getVersionName() {
        return (String) this.ok.call(271041, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }
}
