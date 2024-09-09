package com.bytedance.sdk.component.xv.w.c.xv;

import com.bytedance.sdk.component.xv.c.s;
import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.u;
import com.bytedance.sdk.component.xv.w.z;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class w implements u {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f30967c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static final class c extends com.bytedance.sdk.component.xv.c.r {

        /* renamed from: c  reason: collision with root package name */
        long f30968c;

        c(s sVar) {
            super(sVar);
        }

        @Override // com.bytedance.sdk.component.xv.c.r, com.bytedance.sdk.component.xv.c.s
        public void a_(com.bytedance.sdk.component.xv.c.xv xvVar, long j4) throws IOException {
            super.a_(xvVar, j4);
            this.f30968c += j4;
        }
    }

    public w(boolean z3) {
        this.f30967c = z3;
    }

    @Override // com.bytedance.sdk.component.xv.w.u
    public ba c(u.c cVar) throws IOException {
        ba c4;
        z zVar;
        r rVar = (r) cVar;
        xv r3 = rVar.r();
        com.bytedance.sdk.component.xv.w.c.w.r f4 = rVar.f();
        com.bytedance.sdk.component.xv.w.c.w.xv xvVar = (com.bytedance.sdk.component.xv.w.c.w.xv) rVar.ux();
        n c5 = rVar.c();
        long currentTimeMillis = System.currentTimeMillis();
        if (c5 != null && (zVar = c5.f31068f) != null) {
            zVar.c(currentTimeMillis);
        }
        rVar.ev().xv(rVar.call());
        r3.c(c5);
        rVar.ev().c(rVar.call(), c5);
        ba.c cVar2 = null;
        if (f.xv(c5.w()) && c5.sr() != null) {
            if ("100-continue".equalsIgnoreCase(c5.c("Expect"))) {
                r3.c();
                rVar.ev().ux(rVar.call());
                cVar2 = r3.c(true);
            }
            if (cVar2 == null) {
                rVar.ev().sr(rVar.call());
                c cVar3 = new c(r3.c(c5, c5.sr().w()));
                com.bytedance.sdk.component.xv.c.sr c6 = com.bytedance.sdk.component.xv.c.a.c(cVar3);
                c5.sr().c(c6);
                c6.close();
                rVar.ev().c(rVar.call(), cVar3.f30968c);
            } else if (!xvVar.ux()) {
                f4.sr();
            }
        }
        r3.w();
        if (cVar2 == null) {
            rVar.ev().ux(rVar.call());
            cVar2 = r3.c(false);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        z zVar2 = c5.f31068f;
        if (zVar2 != null) {
            zVar2.w(currentTimeMillis2);
        }
        ba c7 = cVar2.c(c5).c(f4.w().sr()).c(currentTimeMillis).w(currentTimeMillis2).c();
        rVar.ev().c(rVar.call(), c7);
        int xv = c7.xv();
        if (this.f30967c && xv == 101) {
            c4 = c7.gd().c(com.bytedance.sdk.component.xv.w.c.xv.xv).c();
        } else {
            c4 = c7.gd().c(r3.c(c7)).c();
        }
        if ("close".equalsIgnoreCase(c4.c().c("Connection")) || "close".equalsIgnoreCase(c4.c("Connection"))) {
            f4.sr();
        }
        if ((xv == 204 || xv == 205) && c4.ev().w() > 0) {
            throw new ProtocolException("HTTP " + xv + " had non-zero Content-Length: " + c4.ev().w());
        }
        return c4;
    }
}
