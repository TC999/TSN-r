package com.kwad.components.p208ad.p236h;

import com.kwad.components.p208ad.p210b.p211a.InterfaceC7342b;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.components.ad.h.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7678e {

    /* renamed from: od */
    private final AtomicBoolean f26009od;

    /* renamed from: oe */
    private final List<InterfaceC7342b> f26010oe;

    /* renamed from: com.kwad.components.ad.h.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C7679a {

        /* renamed from: of */
        private static final C7678e f26011of = new C7678e((byte) 0);
    }

    /* synthetic */ C7678e(byte b) {
        this();
    }

    /* renamed from: eV */
    public static C7678e m32662eV() {
        return C7679a.f26011of;
    }

    /* renamed from: S */
    public final boolean m32667S() {
        return this.f26009od.get();
    }

    /* renamed from: a */
    public final void m32666a(InterfaceC7342b interfaceC7342b) {
        if (interfaceC7342b != null) {
            this.f26010oe.add(interfaceC7342b);
        }
    }

    /* renamed from: b */
    public final void m32665b(InterfaceC7342b interfaceC7342b) {
        if (interfaceC7342b != null) {
            this.f26010oe.remove(interfaceC7342b);
        }
    }

    /* renamed from: eR */
    public final void m32664eR() {
        this.f26009od.set(true);
        for (InterfaceC7342b interfaceC7342b : this.f26010oe) {
            interfaceC7342b.mo32675T();
        }
    }

    /* renamed from: eT */
    public final void m32663eT() {
        this.f26009od.set(false);
        for (InterfaceC7342b interfaceC7342b : this.f26010oe) {
            interfaceC7342b.mo30303U();
        }
    }

    private C7678e() {
        this.f26009od = new AtomicBoolean();
        this.f26010oe = new CopyOnWriteArrayList();
    }
}
