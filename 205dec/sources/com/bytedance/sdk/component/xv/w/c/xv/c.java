package com.bytedance.sdk.component.xv.w.c.xv;

import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.bk;
import com.bytedance.sdk.component.xv.w.ck;
import com.bytedance.sdk.component.xv.w.i;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.u;
import java.io.IOException;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c implements u {

    /* renamed from: c  reason: collision with root package name */
    private final bk f30950c;

    public c(bk bkVar) {
        this.f30950c = bkVar;
    }

    @Override // com.bytedance.sdk.component.xv.w.u
    public ba c(u.c cVar) throws IOException {
        n c4 = cVar.c();
        n.c f4 = c4.f();
        ck sr = c4.sr();
        if (sr != null) {
            i c5 = sr.c();
            if (c5 != null) {
                f4.c("Content-Type", c5.toString());
            }
            long w3 = sr.w();
            if (w3 != -1) {
                f4.c("Content-Length", Long.toString(w3));
                f4.w("Transfer-Encoding");
            } else {
                f4.c("Transfer-Encoding", "chunked");
                f4.w("Content-Length");
            }
        }
        boolean z3 = false;
        if (c4.c("Host") == null) {
            f4.c("Host", com.bytedance.sdk.component.xv.w.c.xv.c(c4.c(), false));
        }
        if (c4.c("Connection") == null) {
            f4.c("Connection", "Keep-Alive");
        }
        if (c4.c("Accept-Encoding") == null && c4.c("Range") == null) {
            z3 = true;
            f4.c("Accept-Encoding", "gzip");
        }
        List<com.bytedance.sdk.component.xv.w.a> c6 = this.f30950c.c(c4.c());
        if (!c6.isEmpty()) {
            f4.c("Cookie", c(c6));
        }
        if (c4.c("User-Agent") == null) {
            f4.c("User-Agent", com.bytedance.sdk.component.xv.w.c.sr.c());
        }
        ba c7 = cVar.c(f4.c());
        ux.c(this.f30950c, c4.c(), c7.r());
        ba.c c8 = c7.gd().c(c4);
        if (z3 && "gzip".equalsIgnoreCase(c7.c("Content-Encoding")) && ux.xv(c7)) {
            com.bytedance.sdk.component.xv.c.p pVar = new com.bytedance.sdk.component.xv.c.p(c7.ev().xv());
            c8.c(c7.r().w().w("Content-Encoding").w("Content-Length").c());
            c8.c(new ev(c7.c("Content-Type"), -1L, com.bytedance.sdk.component.xv.c.a.c(pVar)));
        }
        return c8.c();
    }

    private String c(List<com.bytedance.sdk.component.xv.w.a> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 > 0) {
                sb.append("; ");
            }
            com.bytedance.sdk.component.xv.w.a aVar = list.get(i4);
            sb.append(aVar.c());
            sb.append('=');
            sb.append(aVar.w());
        }
        return sb.toString();
    }
}
