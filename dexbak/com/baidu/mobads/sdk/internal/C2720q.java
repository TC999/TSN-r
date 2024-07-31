package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.C2580aa;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.baidu.mobads.sdk.internal.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2720q {

    /* renamed from: a */
    private static volatile C2720q f9119a;

    /* renamed from: b */
    private List<C2580aa.InterfaceC2581a> f9120b = new CopyOnWriteArrayList();

    private C2720q() {
    }

    /* renamed from: a */
    public static C2720q m50350a() {
        if (f9119a == null) {
            synchronized (C2720q.class) {
                if (f9119a == null) {
                    f9119a = new C2720q();
                }
            }
        }
        return f9119a;
    }

    /* renamed from: b */
    private void m50347b(C2580aa.InterfaceC2581a interfaceC2581a) {
        if (this.f9120b.contains(interfaceC2581a)) {
            this.f9120b.remove(interfaceC2581a);
        }
    }

    /* renamed from: a */
    public void m50348a(C2580aa.InterfaceC2581a interfaceC2581a) {
        if (interfaceC2581a == null || this.f9120b.contains(interfaceC2581a)) {
            return;
        }
        this.f9120b.add(interfaceC2581a);
    }

    /* renamed from: a */
    public void m50349a(int i) {
        for (C2580aa.InterfaceC2581a interfaceC2581a : this.f9120b) {
            if (i == 1) {
                interfaceC2581a.onSuccess();
            } else if (i == 2) {
                interfaceC2581a.onFailure();
            }
            m50347b(interfaceC2581a);
        }
    }
}
