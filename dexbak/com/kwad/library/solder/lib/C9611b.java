package com.kwad.library.solder.lib;

import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p360a.AbstractC9608e;

/* renamed from: com.kwad.library.solder.lib.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9611b<P extends AbstractC9604a, R extends AbstractC9608e<P>> implements InterfaceC9629b<P, R> {
    InterfaceC9629b<P, R> aiT;
    InterfaceC9629b<P, R> aiU;

    public C9611b(InterfaceC9629b<P, R> interfaceC9629b, InterfaceC9629b<P, R> interfaceC9629b2) {
        this.aiT = interfaceC9629b;
        this.aiU = interfaceC9629b2;
    }

    @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b
    /* renamed from: a */
    public final void mo24651a(R r, P p) {
        InterfaceC9629b<P, R> interfaceC9629b = this.aiT;
        if (interfaceC9629b != null) {
            interfaceC9629b.mo24651a((InterfaceC9629b<P, R>) r, (R) p);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b
    /* renamed from: b */
    public final void mo28159b(R r) {
        InterfaceC9629b<P, R> interfaceC9629b = this.aiT;
        if (interfaceC9629b != null) {
            interfaceC9629b.mo28159b(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b
    /* renamed from: c */
    public final void mo28158c(R r) {
        InterfaceC9629b<P, R> interfaceC9629b = this.aiT;
        if (interfaceC9629b != null) {
            interfaceC9629b.mo28158c(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b
    /* renamed from: d */
    public final void mo25119d(R r) {
        InterfaceC9629b<P, R> interfaceC9629b = this.aiT;
        if (interfaceC9629b != null) {
            interfaceC9629b.mo25119d(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b
    /* renamed from: e */
    public final void mo28157e(R r) {
        InterfaceC9629b<P, R> interfaceC9629b = this.aiT;
        if (interfaceC9629b != null) {
            interfaceC9629b.mo28157e(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b
    /* renamed from: f */
    public final void mo25118f(R r) {
        InterfaceC9629b<P, R> interfaceC9629b = this.aiT;
        if (interfaceC9629b != null) {
            interfaceC9629b.mo25118f(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b
    /* renamed from: a */
    public void mo24650a(R r, PluginError pluginError) {
        InterfaceC9629b<P, R> interfaceC9629b = this.aiT;
        if (interfaceC9629b != null) {
            interfaceC9629b.mo24650a((InterfaceC9629b<P, R>) r, pluginError);
        }
        InterfaceC9629b<P, R> interfaceC9629b2 = this.aiU;
        if (interfaceC9629b2 != null) {
            interfaceC9629b2.mo24650a((InterfaceC9629b<P, R>) r, pluginError);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b
    /* renamed from: a */
    public final void mo28160a(R r) {
        InterfaceC9629b<P, R> interfaceC9629b = this.aiT;
        if (interfaceC9629b != null) {
            interfaceC9629b.mo28160a(r);
        }
    }
}
