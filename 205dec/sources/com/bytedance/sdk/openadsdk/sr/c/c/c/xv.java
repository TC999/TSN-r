package com.bytedance.sdk.openadsdk.sr.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36280c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final CSJSplashAd.SplashClickEyeListener f36281w;

    public xv(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        this.f36281w = splashClickEyeListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashClickEyeListener splashClickEyeListener = this.f36281w;
        if (splashClickEyeListener == null) {
            return null;
        }
        switch (i4) {
            case 113101:
                this.f36281w.onSplashClickEyeReadyToShow(new com.bytedance.sdk.openadsdk.ys.c.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 113102:
                splashClickEyeListener.onSplashClickEyeClick();
                break;
            case 113103:
                splashClickEyeListener.onSplashClickEyeClose();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36280c;
    }
}
