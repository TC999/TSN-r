package com.bytedance.sdk.openadsdk.p130a.p131ok.p132ok.p133ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6372a;

/* renamed from: com.bytedance.sdk.openadsdk.a.ok.ok.ok.bl */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C6277bl implements Bridge {

    /* renamed from: a */
    private final CSJSplashAd.SplashClickEyeListener f22355a;

    /* renamed from: ok */
    private ValueSet f22356ok = C5930a.f21279c;

    public C6277bl(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        this.f22355a = splashClickEyeListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashClickEyeListener splashClickEyeListener = this.f22355a;
        if (splashClickEyeListener == null) {
            return null;
        }
        switch (i) {
            case 113101:
                this.f22355a.onSplashClickEyeReadyToShow(new C6372a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 113102:
                splashClickEyeListener.onSplashClickEyeClick();
                break;
            case 113103:
                splashClickEyeListener.onSplashClickEyeClose();
                break;
        }
        m36788ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36788ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22356ok;
    }
}
