package com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p163ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6445bl extends MediationNativeAdAppInfo {

    /* renamed from: ok */
    private final Bridge f22705ok;

    public C6445bl(Bridge bridge) {
        this.f22705ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo
    public Map<String, Object> getAppInfoExtra() {
        return (Map) this.f22705ok.call(271042, C5930a.m37924c(0).m37926a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo
    public String getAppName() {
        return (String) this.f22705ok.call(271035, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo
    public String getAuthorName() {
        return (String) this.f22705ok.call(271036, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo
    public String getFunctionDescUrl() {
        return (String) this.f22705ok.call(271047, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo
    public long getPackageSizeBytes() {
        return ((Long) this.f22705ok.call(271037, C5930a.m37924c(0).m37926a(), Long.TYPE)).longValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.f22705ok.call(271039, C5930a.m37924c(0).m37926a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo
    public String getPermissionsUrl() {
        return (String) this.f22705ok.call(271038, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo
    public String getPrivacyAgreement() {
        return (String) this.f22705ok.call(271040, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo
    public String getVersionName() {
        return (String) this.f22705ok.call(271041, C5930a.m37924c(0).m37926a(), String.class);
    }
}
