package com.kwad.components.ad.h;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private final AtomicBoolean od;
    private final List<com.kwad.components.ad.b.a.b> oe;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final e of = new e((byte) 0);
    }

    /* synthetic */ e(byte b4) {
        this();
    }

    public static e eV() {
        return a.of;
    }

    public final boolean S() {
        return this.od.get();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.oe.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.oe.remove(bVar);
        }
    }

    public final void eR() {
        this.od.set(true);
        for (com.kwad.components.ad.b.a.b bVar : this.oe) {
            bVar.T();
        }
    }

    public final void eT() {
        this.od.set(false);
        for (com.kwad.components.ad.b.a.b bVar : this.oe) {
            bVar.U();
        }
    }

    private e() {
        this.od = new AtomicBoolean();
        this.oe = new CopyOnWriteArrayList();
    }
}
