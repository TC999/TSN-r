package com.kwad.components.core.p330s;

import java.util.HashSet;
import java.util.Set;

/* renamed from: com.kwad.components.core.s.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8936c {

    /* renamed from: Ta */
    private Set<InterfaceC8938b> f28853Ta;

    /* renamed from: com.kwad.components.core.s.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C8937a {

        /* renamed from: Tb */
        private static C8936c f28854Tb = new C8936c((byte) 0);
    }

    /* renamed from: com.kwad.components.core.s.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8938b {
        void onPageClose();
    }

    /* synthetic */ C8936c(byte b) {
        this();
    }

    /* renamed from: qZ */
    public static C8936c m29567qZ() {
        return C8937a.f28854Tb;
    }

    /* renamed from: a */
    public final void m29569a(InterfaceC8938b interfaceC8938b) {
        this.f28853Ta.add(interfaceC8938b);
    }

    /* renamed from: b */
    public final void m29568b(InterfaceC8938b interfaceC8938b) {
        this.f28853Ta.remove(interfaceC8938b);
    }

    /* renamed from: ra */
    public final void m29566ra() {
        if (this.f28853Ta.size() == 0) {
            return;
        }
        for (InterfaceC8938b interfaceC8938b : this.f28853Ta) {
            interfaceC8938b.onPageClose();
        }
    }

    private C8936c() {
        this.f28853Ta = new HashSet();
    }
}
