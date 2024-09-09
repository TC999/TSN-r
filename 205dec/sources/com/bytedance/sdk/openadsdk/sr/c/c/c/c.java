package com.bytedance.sdk.openadsdk.sr.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36276c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final CSJSplashAd.SplashAdListener f36277w;

    public c(CSJSplashAd.SplashAdListener splashAdListener) {
        this.f36277w = splashAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36277w == null) {
            return null;
        }
        switch (i4) {
            case 111101:
                this.f36277w.onSplashAdShow(new com.bytedance.sdk.openadsdk.ys.c.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111102:
                this.f36277w.onSplashAdClick(new com.bytedance.sdk.openadsdk.ys.c.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111103:
                this.f36277w.onSplashAdClose(new com.bytedance.sdk.openadsdk.ys.c.c.w((Bridge) valueSet.objectValue(0, Bridge.class)), valueSet.intValue(1));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36276c;
    }
}
