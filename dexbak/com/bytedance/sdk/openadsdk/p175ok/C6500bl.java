package com.bytedance.sdk.openadsdk.p175ok;

import android.app.Application;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.EventListener;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.p175ok.C6502ok;
import com.clj.fastble.BleManager;

/* renamed from: com.bytedance.sdk.openadsdk.ok.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6500bl implements Bridge {

    /* renamed from: ok */
    private static volatile C6500bl f22872ok;

    /* renamed from: a */
    private InterfaceC6499a f22873a;

    /* renamed from: bl */
    private C6502ok f22874bl = new C6502ok();

    private C6500bl() {
    }

    /* renamed from: ok */
    public static C6500bl m36198ok() {
        if (f22872ok == null) {
            synchronized (C6500bl.class) {
                if (f22872ok == null) {
                    f22872ok = new C6500bl();
                }
            }
        }
        return f22872ok;
    }

    /* renamed from: a */
    public Application.ActivityLifecycleCallbacks m36199a() {
        return this.f22874bl;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Bridge mo36200ok;
        switch (i) {
            case 2:
                return (T) this.f22874bl.m36195ok();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                InterfaceC6499a interfaceC6499a = this.f22873a;
                if (interfaceC6499a == null || (mo36200ok = interfaceC6499a.mo36200ok(4)) == null) {
                    return null;
                }
                return (T) mo36200ok.call(i, valueSet, cls);
            case 9:
                Object objectValue = valueSet.objectValue(0, Object.class);
                if (objectValue instanceof EventListener) {
                    m36197ok((EventListener) objectValue);
                    break;
                }
                break;
            case 10:
                InterfaceC6499a interfaceC6499a2 = this.f22873a;
                if (interfaceC6499a2 == null) {
                    return null;
                }
                return (T) interfaceC6499a2.mo36200ok(valueSet.intValue(0));
        }
        return null;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.m37925b().m37921f(BleManager.f22896l, 5).m37926a();
    }

    /* renamed from: ok */
    public void m36196ok(InterfaceC6499a interfaceC6499a) {
        this.f22873a = interfaceC6499a;
    }

    /* renamed from: ok */
    private void m36197ok(final EventListener eventListener) {
        this.f22874bl.m36194ok(new C6502ok.InterfaceC6503ok() { // from class: com.bytedance.sdk.openadsdk.ok.bl.1
            @Override // com.bytedance.sdk.openadsdk.p175ok.C6502ok.InterfaceC6503ok
            /* renamed from: a */
            public void mo36193a() {
                eventListener.onEvent(1, null);
            }

            @Override // com.bytedance.sdk.openadsdk.p175ok.C6502ok.InterfaceC6503ok
            /* renamed from: ok */
            public void mo36192ok() {
                eventListener.onEvent(0, null);
            }
        });
    }
}
