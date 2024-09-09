package com.bytedance.sdk.openadsdk.a.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final CSJSplashAd.SplashAdListener f31364a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public ok(CSJSplashAd.SplashAdListener splashAdListener) {
        this.f31364a = splashAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f31364a == null) {
            return null;
        }
        switch (i4) {
            case 111101:
                this.f31364a.onSplashAdShow(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111102:
                this.f31364a.onSplashAdClick(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111103:
                this.f31364a.onSplashAdClose(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)), valueSet.intValue(1));
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
