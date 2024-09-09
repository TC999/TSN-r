package com.bytedance.sdk.component.xv.w.c.c;

import com.bytedance.sdk.component.xv.c.a;
import com.bytedance.sdk.component.xv.c.fz;
import com.bytedance.sdk.component.xv.c.s;
import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.c.c.xv;
import com.bytedance.sdk.component.xv.w.c.xv.ev;
import com.bytedance.sdk.component.xv.w.ls;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.s;
import com.bytedance.sdk.component.xv.w.u;
import com.bytedance.sdk.component.xv.w.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c implements u {

    /* renamed from: c  reason: collision with root package name */
    final f f30736c;

    public c(f fVar) {
        this.f30736c = fVar;
    }

    @Override // com.bytedance.sdk.component.xv.w.u
    public ba c(u.c cVar) throws IOException {
        f fVar = this.f30736c;
        ba c4 = fVar != null ? fVar.c(cVar.c()) : null;
        xv c5 = new xv.c(System.currentTimeMillis(), cVar.c(), c4).c();
        n nVar = c5.f30763c;
        ba baVar = c5.f30764w;
        f fVar2 = this.f30736c;
        if (fVar2 != null) {
            fVar2.c(c5);
        }
        if (c4 != null && baVar == null) {
            com.bytedance.sdk.component.xv.w.c.xv.c(c4.ev());
        }
        if (nVar == null && baVar == null) {
            return new ba.c().c(cVar.c()).c(ls.HTTP_1_1).c(504).c("Unsatisfiable Request (only-if-cached)").c(com.bytedance.sdk.component.xv.w.c.xv.xv).c(-1L).w(System.currentTimeMillis()).c();
        }
        if (nVar == null) {
            return baVar.gd().w(c(baVar)).c();
        }
        try {
            ba c6 = cVar.c(nVar);
            if (c6 == null && c4 != null) {
            }
            if (baVar != null) {
                if (c6.xv() == 304) {
                    ba c7 = baVar.gd().c(c(baVar.r(), c6.r())).c(c6.bk()).w(c6.t()).w(c(baVar)).c(c(c6)).c();
                    c6.ev().close();
                    this.f30736c.c();
                    this.f30736c.update(baVar, c7);
                    return c7;
                }
                com.bytedance.sdk.component.xv.w.c.xv.c(baVar.ev());
            }
            ba c8 = c6.gd().w(c(baVar)).c(c(c6)).c();
            if (this.f30736c != null) {
                if (com.bytedance.sdk.component.xv.w.c.xv.ux.xv(c8) && xv.c(c8, nVar)) {
                    return c(this.f30736c.c(c8), c8);
                }
                if (com.bytedance.sdk.component.xv.w.c.xv.f.c(nVar.w())) {
                    try {
                        this.f30736c.w(nVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return c8;
        } finally {
            if (c4 != null) {
                com.bytedance.sdk.component.xv.w.c.xv.c(c4.ev());
            }
        }
    }

    private static ba c(ba baVar) {
        return (baVar == null || baVar.ev() == null) ? baVar : baVar.gd().c((y) null).c();
    }

    private ba c(final w wVar, ba baVar) throws IOException {
        s c4;
        if (wVar == null || (c4 = wVar.c()) == null) {
            return baVar;
        }
        final com.bytedance.sdk.component.xv.c.ux xv = baVar.ev().xv();
        final com.bytedance.sdk.component.xv.c.sr c5 = a.c(c4);
        return baVar.gd().c(new ev(baVar.c("Content-Type"), baVar.ev().w(), a.c(new fz() { // from class: com.bytedance.sdk.component.xv.w.c.c.c.1

            /* renamed from: c  reason: collision with root package name */
            boolean f30737c;

            @Override // com.bytedance.sdk.component.xv.c.fz
            public long c(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
                try {
                    long c6 = xv.c(xvVar, j4);
                    if (c6 == -1) {
                        if (!this.f30737c) {
                            this.f30737c = true;
                            c5.close();
                        }
                        return -1L;
                    }
                    xvVar.c(c5.xv(), xvVar.w() - c6, c6);
                    c5.i();
                    return c6;
                } catch (IOException e4) {
                    if (!this.f30737c) {
                        this.f30737c = true;
                        wVar.w();
                    }
                    throw e4;
                }
            }

            @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.f30737c && !com.bytedance.sdk.component.xv.w.c.xv.c(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f30737c = true;
                    wVar.w();
                }
                xv.close();
            }

            @Override // com.bytedance.sdk.component.xv.c.fz
            public com.bytedance.sdk.component.xv.c.u c() {
                return xv.c();
            }
        }))).c();
    }

    private static com.bytedance.sdk.component.xv.w.s c(com.bytedance.sdk.component.xv.w.s sVar, com.bytedance.sdk.component.xv.w.s sVar2) {
        s.c cVar = new s.c();
        int c4 = sVar.c();
        for (int i4 = 0; i4 < c4; i4++) {
            String c5 = sVar.c(i4);
            String w3 = sVar.w(i4);
            if ((!"Warning".equalsIgnoreCase(c5) || !w3.startsWith("1")) && (!c(c5) || sVar2.c(c5) == null)) {
                com.bytedance.sdk.component.xv.w.c.c.f30735c.c(cVar, c5, w3);
            }
        }
        int c6 = sVar2.c();
        for (int i5 = 0; i5 < c6; i5++) {
            String c7 = sVar2.c(i5);
            if (!"Content-Length".equalsIgnoreCase(c7) && c(c7)) {
                com.bytedance.sdk.component.xv.w.c.c.f30735c.c(cVar, c7, sVar2.w(i5));
            }
        }
        return cVar.c();
    }

    static boolean c(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
