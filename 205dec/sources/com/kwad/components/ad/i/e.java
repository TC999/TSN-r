package com.kwad.components.ad.i;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class e {
    private final AtomicBoolean oe;
    private final List<com.kwad.components.ad.b.a.b> of;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static class a {
        private static final e og = new e((byte) 0);
    }

    /* synthetic */ e(byte b4) {
        this();
    }

    public static e eW() {
        return a.og;
    }

    public final boolean S() {
        return this.oe.get();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.of.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.of.remove(bVar);
        }
    }

    public final void eS() {
        this.oe.set(true);
        for (com.kwad.components.ad.b.a.b bVar : this.of) {
            bVar.T();
        }
    }

    public final void eU() {
        this.oe.set(false);
        for (com.kwad.components.ad.b.a.b bVar : this.of) {
            bVar.U();
        }
    }

    private e() {
        this.oe = new AtomicBoolean();
        this.of = new CopyOnWriteArrayList();
    }
}
