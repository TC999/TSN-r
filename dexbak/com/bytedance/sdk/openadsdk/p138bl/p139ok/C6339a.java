package com.bytedance.sdk.openadsdk.p138bl.p139ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6372a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6380ok;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6339a implements Bridge {

    /* renamed from: a */
    private final TTAdNative.CSJSplashAdListener f22475a;

    /* renamed from: ok */
    private ValueSet f22476ok = C5930a.f21279c;

    public C6339a(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.f22475a = cSJSplashAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22475a == null) {
            return null;
        }
        switch (i) {
            case 114102:
                Bridge bridge = (Bridge) valueSet.objectValue(0, Bridge.class);
                C6372a c6372a = new C6372a(bridge);
                if (bridge != null) {
                    try {
                        if (bridge.values().intValue(1) >= 5700) {
                            this.f22475a.onSplashLoadSuccess(c6372a);
                        } else {
                            Method declaredMethod = this.f22475a.getClass().getDeclaredMethod("onSplashLoadSuccess", null);
                            if (declaredMethod != null) {
                                declaredMethod.invoke(this.f22475a, new Object[0]);
                            }
                        }
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
                break;
            case 114103:
                this.f22475a.onSplashLoadFail(new C6380ok((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114104:
                this.f22475a.onSplashRenderSuccess(new C6372a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114105:
                this.f22475a.onSplashRenderFail(new C6372a((Bridge) valueSet.objectValue(0, Bridge.class)), new C6380ok((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
        }
        m36539ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36539ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22476ok;
    }
}
