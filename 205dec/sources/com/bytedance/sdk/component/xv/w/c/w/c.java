package com.bytedance.sdk.component.xv.w.c.w;

import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.j;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.u;
import com.bytedance.sdk.component.xv.w.z;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c implements u {

    /* renamed from: c  reason: collision with root package name */
    public final j f30911c;

    public c(j jVar) {
        this.f30911c = jVar;
    }

    @Override // com.bytedance.sdk.component.xv.w.u
    public ba c(u.c cVar) throws IOException {
        z zVar;
        com.bytedance.sdk.component.xv.w.c.xv.r rVar = (com.bytedance.sdk.component.xv.w.c.xv.r) cVar;
        n c4 = rVar.c();
        if (c4 != null && (zVar = c4.f31068f) != null) {
            zVar.w();
        }
        r f4 = rVar.f();
        com.bytedance.sdk.component.xv.w.c.xv.xv c5 = f4.c(this.f30911c, cVar, !c4.w().equals("GET"));
        xv w3 = f4.w();
        z zVar2 = c4.f31068f;
        if (zVar2 != null) {
            zVar2.xv();
        }
        return rVar.c(c4, f4, c5, w3);
    }
}
