package com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6376j;

/* renamed from: com.bytedance.sdk.openadsdk.h.ok.ok.ok.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6414bl implements Bridge {

    /* renamed from: a */
    private final TTAdNative.FullScreenVideoAdListener f22573a;

    /* renamed from: ok */
    private ValueSet f22574ok = C5930a.f21279c;

    public C6414bl(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.f22573a = fullScreenVideoAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = this.f22573a;
        if (fullScreenVideoAdListener == null) {
            return null;
        }
        switch (i) {
            case 132101:
                this.f22573a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 132102:
                this.f22573a.onFullScreenVideoAdLoad(new C6376j((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132103:
                this.f22573a.onFullScreenVideoCached(new C6376j((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132104:
                fullScreenVideoAdListener.onFullScreenVideoCached();
                break;
        }
        m36326ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36326ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22574ok;
    }
}
