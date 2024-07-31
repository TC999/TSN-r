package com.bytedance.sdk.openadsdk.p130a.p131ok.p132ok.p133ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6372a;

/* renamed from: com.bytedance.sdk.openadsdk.a.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C6278ok implements Bridge {

    /* renamed from: a */
    private final CSJSplashAd.SplashAdListener f22357a;

    /* renamed from: ok */
    private ValueSet f22358ok = C5930a.f21279c;

    public C6278ok(CSJSplashAd.SplashAdListener splashAdListener) {
        this.f22357a = splashAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22357a == null) {
            return null;
        }
        switch (i) {
            case 111101:
                this.f22357a.onSplashAdShow(new C6372a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111102:
                this.f22357a.onSplashAdClick(new C6372a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111103:
                this.f22357a.onSplashAdClose(new C6372a((Bridge) valueSet.objectValue(0, Bridge.class)), valueSet.intValue(1));
                break;
        }
        m36787ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36787ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22358ok;
    }
}
