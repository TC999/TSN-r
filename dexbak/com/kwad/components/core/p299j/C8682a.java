package com.kwad.components.core.p299j;

import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.j.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8682a {

    /* renamed from: Mk */
    private CopyOnWriteArrayList<C8684b> f28350Mk = new CopyOnWriteArrayList<>();

    /* renamed from: Ml */
    private volatile boolean f28351Ml;

    /* renamed from: com.kwad.components.core.j.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C8683a {

        /* renamed from: Mm */
        private static final C8682a f28352Mm = new C8682a();
    }

    /* renamed from: com.kwad.components.core.j.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8684b {

        /* renamed from: Mn */
        private final InterfaceC8685c f28353Mn;

        /* renamed from: Mo */
        public boolean f28354Mo;

        public C8684b(InterfaceC8685c interfaceC8685c) {
            this.f28353Mn = interfaceC8685c;
        }
    }

    /* renamed from: com.kwad.components.core.j.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8685c {
        /* renamed from: bk */
        void mo30017bk();
    }

    /* renamed from: b */
    public static boolean m30022b(C8684b c8684b) {
        if (c8684b == null) {
            return true;
        }
        return c8684b.f28354Mo;
    }

    /* renamed from: oG */
    public static C8682a m30020oG() {
        return C8683a.f28352Mm;
    }

    /* renamed from: a */
    public final void m30023a(C8684b c8684b) {
        if (this.f28350Mk.contains(c8684b)) {
            return;
        }
        if (!this.f28351Ml) {
            this.f28351Ml = true;
            c8684b.f28354Mo = true;
        }
        this.f28350Mk.add(c8684b);
    }

    /* renamed from: c */
    public final void m30021c(C8684b c8684b) {
        if (c8684b == null) {
            return;
        }
        if (c8684b.f28354Mo) {
            c8684b.f28354Mo = false;
            this.f28351Ml = false;
        }
        this.f28350Mk.remove(c8684b);
        if (this.f28350Mk.size() == 0 || this.f28351Ml) {
            return;
        }
        this.f28350Mk.get(0).f28354Mo = true;
        this.f28351Ml = true;
        this.f28350Mk.get(0).f28353Mn.mo30017bk();
    }
}
