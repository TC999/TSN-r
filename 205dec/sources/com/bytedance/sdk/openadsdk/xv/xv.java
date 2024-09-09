package com.bytedance.sdk.openadsdk.xv;

import android.app.Application;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.xv.c;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f36395c;

    /* renamed from: w  reason: collision with root package name */
    private w f36396w;
    private c xv = new c();

    private xv() {
    }

    public static xv c() {
        if (f36395c == null) {
            synchronized (xv.class) {
                if (f36395c == null) {
                    f36395c = new xv();
                }
            }
        }
        return f36395c;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        Bridge c4;
        switch (i4) {
            case 2:
                return (T) this.xv.c();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                w wVar = this.f36396w;
                if (wVar == null || (c4 = wVar.c(4)) == null) {
                    return null;
                }
                return (T) c4.call(i4, valueSet, cls);
            case 9:
                Object objectValue = valueSet.objectValue(0, Object.class);
                if (objectValue instanceof EventListener) {
                    c((EventListener) objectValue);
                    break;
                }
                break;
            case 10:
                w wVar2 = this.f36396w;
                if (wVar2 == null) {
                    return null;
                }
                return (T) wVar2.c(valueSet.intValue(0));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.a().e(10000, 5).l();
    }

    public Application.ActivityLifecycleCallbacks w() {
        return this.xv;
    }

    public void c(w wVar) {
        this.f36396w = wVar;
    }

    private void c(final EventListener eventListener) {
        this.xv.c(new c.InterfaceC0534c() { // from class: com.bytedance.sdk.openadsdk.xv.xv.1
            @Override // com.bytedance.sdk.openadsdk.xv.c.InterfaceC0534c
            public void c() {
                eventListener.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.xv.c.InterfaceC0534c
            public void w() {
                eventListener.onEvent(1, null);
            }
        });
    }
}
