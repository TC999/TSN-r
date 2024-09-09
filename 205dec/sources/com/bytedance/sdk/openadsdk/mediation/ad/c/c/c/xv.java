package com.bytedance.sdk.openadsdk.mediation.ad.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv extends MediationNativeAdAppInfo {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36024c;

    public xv(Bridge bridge) {
        this.f36024c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, Object> getAppInfoExtra() {
        return (Map) this.f36024c.call(271042, b.b(0).l(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAppName() {
        return (String) this.f36024c.call(271035, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAuthorName() {
        return (String) this.f36024c.call(271036, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getFunctionDescUrl() {
        return (String) this.f36024c.call(271047, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public long getPackageSizeBytes() {
        return ((Long) this.f36024c.call(271037, b.b(0).l(), Long.TYPE)).longValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.f36024c.call(271039, b.b(0).l(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPermissionsUrl() {
        return (String) this.f36024c.call(271038, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPrivacyAgreement() {
        return (String) this.f36024c.call(271040, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getVersionName() {
        return (String) this.f36024c.call(271041, b.b(0).l(), String.class);
    }
}
