package com.kwad.library.solder.lib;

import com.kwad.library.solder.lib.a.a;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b<P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> implements com.kwad.library.solder.lib.ext.b<P, R> {
    com.kwad.library.solder.lib.ext.b<P, R> aiT;
    com.kwad.library.solder.lib.ext.b<P, R> aiU;

    public b(com.kwad.library.solder.lib.ext.b<P, R> bVar, com.kwad.library.solder.lib.ext.b<P, R> bVar2) {
        this.aiT = bVar;
        this.aiU = bVar2;
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void a(R r3, P p3) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aiT;
        if (bVar != null) {
            bVar.a((com.kwad.library.solder.lib.ext.b<P, R>) r3, (R) p3);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void b(R r3) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aiT;
        if (bVar != null) {
            bVar.b(r3);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void c(R r3) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aiT;
        if (bVar != null) {
            bVar.c(r3);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void d(R r3) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aiT;
        if (bVar != null) {
            bVar.d(r3);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void e(R r3) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aiT;
        if (bVar != null) {
            bVar.e(r3);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void f(R r3) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aiT;
        if (bVar != null) {
            bVar.f(r3);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public void a(R r3, PluginError pluginError) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aiT;
        if (bVar != null) {
            bVar.a((com.kwad.library.solder.lib.ext.b<P, R>) r3, pluginError);
        }
        com.kwad.library.solder.lib.ext.b<P, R> bVar2 = this.aiU;
        if (bVar2 != null) {
            bVar2.a((com.kwad.library.solder.lib.ext.b<P, R>) r3, pluginError);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void a(R r3) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aiT;
        if (bVar != null) {
            bVar.a(r3);
        }
    }
}
