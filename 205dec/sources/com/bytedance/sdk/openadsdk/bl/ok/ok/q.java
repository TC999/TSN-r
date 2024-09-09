package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class q extends TTCustomController implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private TTCustomController f31642a;
    private final Bridge ok;

    public q(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean alist() {
        return ((Boolean) this.ok.call(262103, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTCustomController tTCustomController = this.f31642a;
        if (tTCustomController == null) {
            return null;
        }
        switch (i4) {
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
                ok(i4, valueSet, cls);
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getAndroidId() {
        return (String) this.ok.call(262112, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        return (String) this.ok.call(262105, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        return (String) this.ok.call(262109, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getMacAddress() {
        return (String) this.ok.call(262107, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public IMediationPrivacyConfig getMediationPrivacyConfig() {
        return (IMediationPrivacyConfig) this.ok.values().objectValue(262113, IMediationPrivacyConfig.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public LocationProvider getTTLocation() {
        return (LocationProvider) this.ok.call(262102, com.bykv.ok.ok.ok.ok.a.c(0).a(), LocationProvider.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        return ((Boolean) this.ok.call(262110, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        return ((Boolean) this.ok.call(262101, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePermissionRecordAudio() {
        return ((Boolean) this.ok.call(262111, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return ((Boolean) this.ok.call(262104, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        return ((Boolean) this.ok.call(262106, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        return ((Boolean) this.ok.call(262108, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ok.ok.ok.ok.a.f24747c;
    }

    public q(TTCustomController tTCustomController) {
        this.f31642a = tTCustomController;
        this.ok = com.bykv.ok.ok.ok.ok.a.f24748d;
    }
}
