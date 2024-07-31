package com.kwad.sdk.core.network;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.sdk.core.network.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10422h {
    private static volatile C10422h avN;
    private List<InterfaceC10423a> avM = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.sdk.core.network.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10423a {
        /* renamed from: a */
        void mo26108a(InterfaceC10420f interfaceC10420f, int i);
    }

    private C10422h() {
    }

    /* renamed from: DN */
    public static C10422h m26111DN() {
        if (avN == null) {
            synchronized (C10422h.class) {
                if (avN == null) {
                    avN = new C10422h();
                }
            }
        }
        return avN;
    }

    /* renamed from: a */
    public final void m26110a(InterfaceC10423a interfaceC10423a) {
        this.avM.add(interfaceC10423a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m26109b(InterfaceC10420f interfaceC10420f, int i) {
        for (InterfaceC10423a interfaceC10423a : this.avM) {
            interfaceC10423a.mo26108a(interfaceC10420f, i);
        }
    }
}
