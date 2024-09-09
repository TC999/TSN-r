package com.bytedance.sdk.openadsdk.sr.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36278c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final CSJSplashAd.SplashCardListener f36279w;

    public w(CSJSplashAd.SplashCardListener splashCardListener) {
        this.f36279w = splashCardListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashCardListener splashCardListener = this.f36279w;
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
                this.f36279w.onSplashCardReadyToShow(new com.bytedance.sdk.openadsdk.ys.c.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36278c;
    }
}
