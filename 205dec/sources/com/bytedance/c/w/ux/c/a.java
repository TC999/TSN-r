package com.bytedance.c.w.ux.c;

import android.content.Context;
import com.bytedance.c.w.b;
import com.bytedance.c.w.xv;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, f fVar, d dVar) {
        super(xv.ANR, context, fVar, dVar);
    }

    @Override // com.bytedance.c.w.ux.c.g
    public com.bytedance.c.w.xv.a a(com.bytedance.c.w.xv.a aVar) {
        com.bytedance.c.w.xv.a a4 = super.a(aVar);
        com.bytedance.c.w.xv.b a5 = com.bytedance.c.w.xv.b.a(this.f26606b);
        a5.d(com.bytedance.c.w.d.a().a());
        a5.c(com.bytedance.c.w.d.l().a());
        a5.k(this.f26607c.xv());
        a4.e(a5);
        a4.k("process_name", b.e.i(this.f26606b));
        b.j.b(a4, a5, this.f26605a);
        return a4;
    }
}
