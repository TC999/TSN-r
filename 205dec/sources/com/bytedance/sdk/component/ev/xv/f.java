package com.bytedance.sdk.component.ev.xv;

import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.gd;
import com.bytedance.sdk.component.w.c.t;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements gd {

    /* renamed from: c  reason: collision with root package name */
    private int f29763c;

    public void c(int i4) {
        this.f29763c = i4;
    }

    @Override // com.bytedance.sdk.component.w.c.gd
    public fp c(gd.c cVar) throws IOException {
        IOException iOException;
        t c4 = cVar.c();
        if (r.c().c(this.f29763c).w() != null) {
            r.c().c(this.f29763c).w().ux();
        }
        String rVar = c4.w().toString();
        String c5 = r.c().c(this.f29763c).c(rVar);
        if (!rVar.equals(c5)) {
            c4 = c4.r().c(c5).w();
        }
        fp fpVar = null;
        try {
            iOException = null;
            fpVar = cVar.c(c4);
        } catch (Exception e4) {
            iOException = new IOException(e4.getMessage());
            r.c().c(this.f29763c).c(c4, e4);
        }
        r.c().c(this.f29763c).c(c4, fpVar);
        if (iOException == null) {
            return fpVar == null ? cVar.c(c4) : fpVar;
        }
        throw iOException;
    }
}
