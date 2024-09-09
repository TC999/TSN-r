package com.bytedance.sdk.openadsdk.a.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final CSJSplashAd.SplashCardListener f31362a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(CSJSplashAd.SplashCardListener splashCardListener) {
        this.f31362a = splashCardListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashCardListener splashCardListener = this.f31362a;
        if (splashCardListener == null) {
            return null;
        }
        switch (i4) {
            case 112102:
                splashCardListener.onSplashCardClick();
                break;
            case 112103:
                splashCardListener.onSplashCardClose();
                break;
            case 121201:
                this.f31362a.onSplashCardReadyToShow(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
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
