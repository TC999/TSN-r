package com.bytedance.sdk.openadsdk.a.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class bl implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final CSJSplashAd.SplashClickEyeListener f31363a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public bl(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        this.f31363a = splashClickEyeListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashClickEyeListener splashClickEyeListener = this.f31363a;
        if (splashClickEyeListener == null) {
            return null;
        }
        switch (i4) {
            case 113101:
                this.f31363a.onSplashClickEyeReadyToShow(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 113102:
                splashClickEyeListener.onSplashClickEyeClick();
                break;
            case 113103:
                splashClickEyeListener.onSplashClickEyeClose();
                break;
        }
        ok(i4, valueSet, cls);
        return null;
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
