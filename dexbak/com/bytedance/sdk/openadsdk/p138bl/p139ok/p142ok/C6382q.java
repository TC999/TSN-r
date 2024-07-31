package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.q */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6382q extends TTCustomController implements Bridge {

    /* renamed from: a */
    private TTCustomController f22524a;

    /* renamed from: ok */
    private final Bridge f22525ok;

    public C6382q(Bridge bridge) {
        this.f22525ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean alist() {
        return ((Boolean) this.f22525ok.call(262103, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTCustomController tTCustomController = this.f22524a;
        if (tTCustomController == null) {
            return null;
        }
        switch (i) {
            case 262101:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseLocation()));
            case 262102:
                return (T) tTCustomController.getTTLocation();
            case 262103:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.alist()));
            case 262104:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUsePhoneState()));
            case 262105:
                return (T) tTCustomController.getDevImei();
            case 262106:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseWifiState()));
            case 262107:
                return (T) tTCustomController.getMacAddress();
            case 262108:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseWriteExternal()));
            case 262109:
                return (T) tTCustomController.getDevOaid();
            case 262110:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseAndroidId()));
            case 262111:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUsePermissionRecordAudio()));
            case 262112:
                return (T) tTCustomController.getAndroidId();
            default:
                m36498ok(i, valueSet, cls);
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getAndroidId() {
        return (String) this.f22525ok.call(262112, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        return (String) this.f22525ok.call(262105, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        return (String) this.f22525ok.call(262109, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getMacAddress() {
        return (String) this.f22525ok.call(262107, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public IMediationPrivacyConfig getMediationPrivacyConfig() {
        return (IMediationPrivacyConfig) this.f22525ok.values().objectValue(262113, IMediationPrivacyConfig.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public LocationProvider getTTLocation() {
        return (LocationProvider) this.f22525ok.call(262102, C5930a.m37924c(0).m37926a(), LocationProvider.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        return ((Boolean) this.f22525ok.call(262110, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        return ((Boolean) this.f22525ok.call(262101, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePermissionRecordAudio() {
        return ((Boolean) this.f22525ok.call(262111, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return ((Boolean) this.f22525ok.call(262104, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        return ((Boolean) this.f22525ok.call(262106, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        return ((Boolean) this.f22525ok.call(262108, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    /* renamed from: ok */
    protected void m36498ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.f21279c;
    }

    public C6382q(TTCustomController tTCustomController) {
        this.f22524a = tTCustomController;
        this.f22525ok = C5930a.f21280d;
    }
}
