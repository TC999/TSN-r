package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class gd extends TTCustomController implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36411c;

    /* renamed from: w  reason: collision with root package name */
    private TTCustomController f36412w;

    public gd(Bridge bridge) {
        this.f36411c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean alist() {
        return ((Boolean) this.f36411c.call(262103, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTCustomController tTCustomController = this.f36412w;
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
                c(i4, valueSet, cls);
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getAndroidId() {
        return (String) this.f36411c.call(262112, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        return (String) this.f36411c.call(262105, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        return (String) this.f36411c.call(262109, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getMacAddress() {
        return (String) this.f36411c.call(262107, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public IMediationPrivacyConfig getMediationPrivacyConfig() {
        return (IMediationPrivacyConfig) this.f36411c.values().objectValue(262113, IMediationPrivacyConfig.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public LocationProvider getTTLocation() {
        return (LocationProvider) this.f36411c.call(262102, b.b(0).l(), LocationProvider.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        return ((Boolean) this.f36411c.call(262110, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        return ((Boolean) this.f36411c.call(262101, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePermissionRecordAudio() {
        return ((Boolean) this.f36411c.call(262111, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return ((Boolean) this.f36411c.call(262104, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        return ((Boolean) this.f36411c.call(262106, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        return ((Boolean) this.f36411c.call(262108, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.f24740c;
    }

    public gd(TTCustomController tTCustomController) {
        this.f36412w = tTCustomController;
        this.f36411c = b.f24741d;
    }
}
