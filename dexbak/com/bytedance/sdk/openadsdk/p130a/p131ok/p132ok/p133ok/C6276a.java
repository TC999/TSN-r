package com.bytedance.sdk.openadsdk.p130a.p131ok.p132ok.p133ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6372a;

/* renamed from: com.bytedance.sdk.openadsdk.a.ok.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C6276a implements Bridge {

    /* renamed from: a */
    private final CSJSplashAd.SplashCardListener f22353a;

    /* renamed from: ok */
    private ValueSet f22354ok = C5930a.f21279c;

    public C6276a(CSJSplashAd.SplashCardListener splashCardListener) {
        this.f22353a = splashCardListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashCardListener splashCardListener = this.f22353a;
        if (splashCardListener == null) {
            return null;
        }
        switch (i) {
            case 112102:
                splashCardListener.onSplashCardClick();
                break;
            case 112103:
                splashCardListener.onSplashCardClose();
                break;
            case 121201:
                this.f22353a.onSplashCardReadyToShow(new C6372a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        m36789ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36789ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22354ok;
    }
}
