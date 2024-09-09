package com.bytedance.sdk.openadsdk.ok;

import android.app.Application;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.ok.ok;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class bl implements Bridge {
    private static volatile bl ok;

    /* renamed from: a  reason: collision with root package name */
    private a f36252a;
    private ok bl = new ok();

    private bl() {
    }

    public static bl ok() {
        if (ok == null) {
            synchronized (bl.class) {
                if (ok == null) {
                    ok = new bl();
                }
            }
        }
        return ok;
    }

    public Application.ActivityLifecycleCallbacks a() {
        return this.bl;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        Bridge ok2;
        switch (i4) {
            case 2:
                return (T) this.bl.ok();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                a aVar = this.f36252a;
                if (aVar == null || (ok2 = aVar.ok(4)) == null) {
                    return null;
                }
                return (T) ok2.call(i4, valueSet, cls);
            case 9:
                Object objectValue = valueSet.objectValue(0, Object.class);
                if (objectValue instanceof EventListener) {
                    ok((EventListener) objectValue);
                    break;
                }
                break;
            case 10:
                a aVar2 = this.f36252a;
                if (aVar2 == null) {
                    return null;
                }
                return (T) aVar2.ok(valueSet.intValue(0));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ok.ok.ok.ok.a.b().f(10000, 5).a();
    }

    public void ok(a aVar) {
        this.f36252a = aVar;
    }

    private void ok(final EventListener eventListener) {
        this.bl.ok(new ok.InterfaceC0531ok() { // from class: com.bytedance.sdk.openadsdk.ok.bl.1
            @Override // com.bytedance.sdk.openadsdk.ok.ok.InterfaceC0531ok
            public void a() {
                eventListener.onEvent(1, null);
            }

            @Override // com.bytedance.sdk.openadsdk.ok.ok.InterfaceC0531ok
            public void ok() {
                eventListener.onEvent(0, null);
            }
        });
    }
}
