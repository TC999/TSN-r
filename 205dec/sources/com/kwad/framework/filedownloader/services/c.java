package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.e.b;
import com.kwad.framework.filedownloader.f.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private final b ahP;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        c.b vu();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b {
        c.InterfaceC0672c ahQ;
        Integer ahR;
        c.e ahS;
        c.b ahT;
        a ahU;
        c.a ahV;
        c.d ahW;

        public final b a(c.b bVar) {
            this.ahT = bVar;
            return this;
        }

        public final b bH(int i4) {
            this.ahR = Integer.MAX_VALUE;
            return this;
        }

        public final String toString() {
            return com.kwad.framework.filedownloader.f.f.b("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.ahQ, this.ahR, this.ahS, this.ahT, this.ahV);
        }

        public final b a(a aVar) {
            this.ahU = aVar;
            return this;
        }
    }

    public c() {
        this.ahP = null;
    }

    private static c.a wA() {
        return new com.kwad.framework.filedownloader.a.a();
    }

    private static c.d ww() {
        return new com.kwad.framework.filedownloader.services.b();
    }

    private static int wx() {
        return com.kwad.framework.filedownloader.f.e.wN().aiq;
    }

    private static c.e wy() {
        return new b.a();
    }

    private static c.b wz() {
        return new c.b();
    }

    public final int vr() {
        b bVar = this.ahP;
        if (bVar == null) {
            return wx();
        }
        Integer num = bVar.ahR;
        if (num != null) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwad.framework.filedownloader.f.e.bL(num.intValue());
        }
        return wx();
    }

    public final com.kwad.framework.filedownloader.b.a wr() {
        c.InterfaceC0672c interfaceC0672c;
        b bVar = this.ahP;
        if (bVar != null && (interfaceC0672c = bVar.ahQ) != null) {
            com.kwad.framework.filedownloader.b.a wM = interfaceC0672c.wM();
            return wM != null ? wM : new com.kwad.framework.filedownloader.b.c();
        }
        return new com.kwad.framework.filedownloader.b.c();
    }

    public final c.e ws() {
        b bVar = this.ahP;
        if (bVar == null) {
            return wy();
        }
        c.e eVar = bVar.ahS;
        if (eVar != null) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return wy();
    }

    public final c.b wt() {
        c.b vu;
        b bVar = this.ahP;
        if (bVar == null) {
            return wz();
        }
        a aVar = bVar.ahU;
        return (aVar == null || (vu = aVar.vu()) == null) ? wz() : vu;
    }

    public final c.a wu() {
        b bVar = this.ahP;
        if (bVar == null) {
            return wA();
        }
        c.a aVar = bVar.ahV;
        if (aVar != null) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return wA();
    }

    public final c.d wv() {
        b bVar = this.ahP;
        if (bVar == null) {
            return ww();
        }
        c.d dVar = bVar.ahW;
        if (dVar != null) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return ww();
    }

    public c(b bVar) {
        this.ahP = bVar;
    }
}
