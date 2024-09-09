package com.bytedance.sdk.component.w.c.c.c;

import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.gd;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.component.xv.w.u;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements gd.c {

    /* renamed from: c  reason: collision with root package name */
    u.c f30387c;

    public w(u.c cVar) {
        this.f30387c = cVar;
    }

    @Override // com.bytedance.sdk.component.w.c.gd.c
    public t c() {
        return new ux(this.f30387c.c());
    }

    @Override // com.bytedance.sdk.component.w.c.gd.c
    public fp c(t tVar) throws IOException {
        return new f(this.f30387c.c(this.f30387c.c().f().c(tVar.w().c()).c()));
    }
}
