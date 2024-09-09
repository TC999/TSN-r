package com.bytedance.sdk.openadsdk.ys.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36440c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTAdNative.CSJSplashAdListener f36441w;

    public xv(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.f36441w = cSJSplashAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36441w == null) {
            return null;
        }
        switch (i4) {
            case 114102:
                Bridge bridge = (Bridge) valueSet.objectValue(0, Bridge.class);
                com.bytedance.sdk.openadsdk.ys.c.c.w wVar = new com.bytedance.sdk.openadsdk.ys.c.c.w(bridge);
                if (bridge != null) {
                    try {
                        if (bridge.values().intValue(1) >= 5700) {
                            this.f36441w.onSplashLoadSuccess(wVar);
                        } else {
                            Method declaredMethod = this.f36441w.getClass().getDeclaredMethod("onSplashLoadSuccess", null);
                            if (declaredMethod != null) {
                                declaredMethod.invoke(this.f36441w, new Object[0]);
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
                this.f36441w.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ys.c.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114104:
                this.f36441w.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.ys.c.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114105:
                this.f36441w.onSplashRenderFail(new com.bytedance.sdk.openadsdk.ys.c.c.w((Bridge) valueSet.objectValue(0, Bridge.class)), new com.bytedance.sdk.openadsdk.ys.c.c.c((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36440c;
    }
}
