package com.bytedance.sdk.component.xv.w.c.ux;

import com.bytedance.sdk.component.xv.c.fz;
import com.bytedance.sdk.component.xv.c.s;
import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.j;
import com.bytedance.sdk.component.xv.w.ls;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.s;
import com.bytedance.sdk.component.xv.w.u;
import com.bytedance.sdk.component.xv.w.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class f implements com.bytedance.sdk.component.xv.w.c.xv.xv {
    private static final com.bytedance.sdk.component.xv.c.f ev;

    /* renamed from: f  reason: collision with root package name */
    private static final com.bytedance.sdk.component.xv.c.f f30824f;
    private static final com.bytedance.sdk.component.xv.c.f gd;

    /* renamed from: k  reason: collision with root package name */
    private static final List<com.bytedance.sdk.component.xv.c.f> f30825k;

    /* renamed from: p  reason: collision with root package name */
    private static final List<com.bytedance.sdk.component.xv.c.f> f30826p;

    /* renamed from: r  reason: collision with root package name */
    private static final com.bytedance.sdk.component.xv.c.f f30827r;
    private static final com.bytedance.sdk.component.xv.c.f sr;
    private static final com.bytedance.sdk.component.xv.c.f ux;

    /* renamed from: w  reason: collision with root package name */
    private static final com.bytedance.sdk.component.xv.c.f f30828w;
    private static final com.bytedance.sdk.component.xv.c.f xv;

    /* renamed from: a  reason: collision with root package name */
    private final j f30829a;
    private final u.c bk;

    /* renamed from: c  reason: collision with root package name */
    final com.bytedance.sdk.component.xv.w.c.w.r f30830c;

    /* renamed from: t  reason: collision with root package name */
    private final r f30831t;
    private gd ys;

    static {
        com.bytedance.sdk.component.xv.c.f c4 = com.bytedance.sdk.component.xv.c.f.c("connection");
        f30828w = c4;
        com.bytedance.sdk.component.xv.c.f c5 = com.bytedance.sdk.component.xv.c.f.c("host");
        xv = c5;
        com.bytedance.sdk.component.xv.c.f c6 = com.bytedance.sdk.component.xv.c.f.c("keep-alive");
        sr = c6;
        com.bytedance.sdk.component.xv.c.f c7 = com.bytedance.sdk.component.xv.c.f.c("proxy-connection");
        ux = c7;
        com.bytedance.sdk.component.xv.c.f c8 = com.bytedance.sdk.component.xv.c.f.c("transfer-encoding");
        f30824f = c8;
        com.bytedance.sdk.component.xv.c.f c9 = com.bytedance.sdk.component.xv.c.f.c("te");
        f30827r = c9;
        com.bytedance.sdk.component.xv.c.f c10 = com.bytedance.sdk.component.xv.c.f.c("encoding");
        ev = c10;
        com.bytedance.sdk.component.xv.c.f c11 = com.bytedance.sdk.component.xv.c.f.c("upgrade");
        gd = c11;
        f30826p = com.bytedance.sdk.component.xv.w.c.xv.c(c4, c5, c6, c7, c9, c8, c10, c11, xv.xv, xv.sr, xv.ux, xv.f30906f);
        f30825k = com.bytedance.sdk.component.xv.w.c.xv.c(c4, c5, c6, c7, c9, c8, c10, c11);
    }

    public f(j jVar, u.c cVar, com.bytedance.sdk.component.xv.w.c.w.r rVar, r rVar2) {
        this.f30829a = jVar;
        this.bk = cVar;
        this.f30830c = rVar;
        this.f30831t = rVar2;
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public s c(n nVar, long j4) {
        return this.ys.ev();
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public void w() throws IOException {
        this.ys.ev().close();
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public void xv() {
        gd gdVar = this.ys;
        if (gdVar != null) {
            gdVar.w(w.CANCEL);
        }
    }

    public static List<xv> w(n nVar) {
        com.bytedance.sdk.component.xv.w.s xv2 = nVar.xv();
        ArrayList arrayList = new ArrayList(xv2.c() + 4);
        arrayList.add(new xv(xv.xv, nVar.w()));
        arrayList.add(new xv(xv.sr, com.bytedance.sdk.component.xv.w.c.xv.gd.c(nVar.c())));
        String c4 = nVar.c("Host");
        if (c4 != null) {
            arrayList.add(new xv(xv.f30906f, c4));
        }
        arrayList.add(new xv(xv.ux, nVar.c().xv()));
        int c5 = xv2.c();
        for (int i4 = 0; i4 < c5; i4++) {
            com.bytedance.sdk.component.xv.c.f c6 = com.bytedance.sdk.component.xv.c.f.c(xv2.c(i4).toLowerCase(Locale.US));
            if (!f30826p.contains(c6)) {
                arrayList.add(new xv(c6, xv2.w(i4)));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public void c(n nVar) throws IOException {
        if (this.ys != null) {
            return;
        }
        gd c4 = this.f30831t.c(w(nVar), nVar.sr() != null);
        this.ys = c4;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c4.ux().c(this.bk.xv(), timeUnit);
        this.ys.f().c(this.bk.sr(), timeUnit);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class c extends com.bytedance.sdk.component.xv.c.ev {

        /* renamed from: c  reason: collision with root package name */
        boolean f30832c;

        /* renamed from: w  reason: collision with root package name */
        long f30833w;

        c(fz fzVar) {
            super(fzVar);
            this.f30832c = false;
            this.f30833w = 0L;
        }

        @Override // com.bytedance.sdk.component.xv.c.ev, com.bytedance.sdk.component.xv.c.fz
        public long c(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            try {
                long c4 = w().c(xvVar, j4);
                if (c4 > 0) {
                    this.f30833w += c4;
                }
                return c4;
            } catch (IOException e4) {
                c(e4);
                throw e4;
            }
        }

        @Override // com.bytedance.sdk.component.xv.c.ev, com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            c(null);
        }

        private void c(IOException iOException) {
            if (this.f30832c) {
                return;
            }
            this.f30832c = true;
            f fVar = f.this;
            fVar.f30830c.c(false, (com.bytedance.sdk.component.xv.w.c.xv.xv) fVar, this.f30833w, iOException);
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public void c() throws IOException {
        this.f30831t.w();
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public ba.c c(boolean z3) throws IOException {
        ba.c c4 = c(this.ys.sr());
        if (z3 && com.bytedance.sdk.component.xv.w.c.c.f30735c.c(c4) == 100) {
            return null;
        }
        return c4;
    }

    public static ba.c c(List<xv> list) throws IOException {
        s.c cVar = new s.c();
        int size = list.size();
        com.bytedance.sdk.component.xv.w.c.xv.k kVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            xv xvVar = list.get(i4);
            if (xvVar == null) {
                if (kVar != null && kVar.f30954w == 100) {
                    cVar = new s.c();
                    kVar = null;
                }
            } else {
                com.bytedance.sdk.component.xv.c.f fVar = xvVar.f30908r;
                String c4 = xvVar.ev.c();
                if (fVar.equals(xv.f30907w)) {
                    kVar = com.bytedance.sdk.component.xv.w.c.xv.k.c("HTTP/1.1 " + c4);
                } else if (!f30825k.contains(fVar)) {
                    com.bytedance.sdk.component.xv.w.c.c.f30735c.c(cVar, fVar.c(), c4);
                }
            }
        }
        if (kVar != null) {
            return new ba.c().c(ls.HTTP_2).c(kVar.f30954w).c(kVar.xv).c(cVar.c());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.bytedance.sdk.component.xv.w.c.xv.xv
    public y c(ba baVar) throws IOException {
        com.bytedance.sdk.component.xv.w.c.w.r rVar = this.f30830c;
        rVar.xv.f(rVar.f30925w);
        return new com.bytedance.sdk.component.xv.w.c.xv.ev(baVar.c("Content-Type"), com.bytedance.sdk.component.xv.w.c.xv.ux.c(baVar), com.bytedance.sdk.component.xv.c.a.c(new c(this.ys.r())));
    }
}
