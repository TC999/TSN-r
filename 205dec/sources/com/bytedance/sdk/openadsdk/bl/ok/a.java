package com.bytedance.sdk.openadsdk.bl.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTAdNative.CSJSplashAdListener f31632a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.f31632a = cSJSplashAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f31632a == null) {
            return null;
        }
        switch (i4) {
            case 114102:
                Bridge bridge = (Bridge) valueSet.objectValue(0, Bridge.class);
                com.bytedance.sdk.openadsdk.bl.ok.ok.a aVar = new com.bytedance.sdk.openadsdk.bl.ok.ok.a(bridge);
                if (bridge != null) {
                    try {
                        if (bridge.values().intValue(1) >= 5700) {
                            this.f31632a.onSplashLoadSuccess(aVar);
                        } else {
                            Method declaredMethod = this.f31632a.getClass().getDeclaredMethod("onSplashLoadSuccess", null);
                            if (declaredMethod != null) {
                                declaredMethod.invoke(this.f31632a, new Object[0]);
                            }
                        }
                        break;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        break;
                    }
                }
                break;
            case 114103:
                this.f31632a.onSplashLoadFail(new com.bytedance.sdk.openadsdk.bl.ok.ok.ok((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114104:
                this.f31632a.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114105:
                this.f31632a.onSplashRenderFail(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)), new com.bytedance.sdk.openadsdk.bl.ok.ok.ok((Bridge) valueSet.objectValue(1, Bridge.class)));
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
