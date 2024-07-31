package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.internal.api.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8679c {
    @NonNull

    /* renamed from: Mh */
    private List<InterfaceC8678b> f28347Mh = new CopyOnWriteArrayList();

    /* renamed from: Mi */
    private boolean f28348Mi = false;

    /* renamed from: Mj */
    private boolean f28349Mj = false;

    /* renamed from: a */
    public final void m30029a(InterfaceC8678b interfaceC8678b) {
        if (interfaceC8678b == null) {
            return;
        }
        this.f28347Mh.add(interfaceC8678b);
    }

    /* renamed from: b */
    public final void m30028b(InterfaceC8678b interfaceC8678b) {
        if (interfaceC8678b == null) {
            return;
        }
        this.f28347Mh.remove(interfaceC8678b);
    }

    /* renamed from: h */
    public final void m30027h(InterfaceC8677a interfaceC8677a) {
        C10331c.m26254d("KsAdListenerHolder", "notifyAdEnter: " + interfaceC8677a + ", hadNotifiedEnter: " + this.f28349Mj);
        if (this.f28349Mj) {
            return;
        }
        for (InterfaceC8678b interfaceC8678b : this.f28347Mh) {
            interfaceC8678b.mo30031c(interfaceC8677a);
        }
        this.f28349Mj = true;
    }

    /* renamed from: i */
    public final void m30026i(InterfaceC8677a interfaceC8677a) {
        C10331c.m26254d("KsAdListenerHolder", "notifyAdExit: " + interfaceC8677a + ", hadNotifiedExit: " + this.f28348Mi);
        if (this.f28348Mi) {
            return;
        }
        for (InterfaceC8678b interfaceC8678b : this.f28347Mh) {
            interfaceC8678b.mo30030d(interfaceC8677a);
        }
        this.f28348Mi = true;
    }
}
