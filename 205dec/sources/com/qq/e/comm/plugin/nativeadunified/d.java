package com.qq.e.comm.plugin.nativeadunified;

import android.view.View;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private f f44838c;

    /* renamed from: d  reason: collision with root package name */
    private g f44839d;

    public d(f fVar, g gVar) {
        this.f44839d = gVar;
        this.f44838c = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d1.a("report click event", new Object[0]);
        f fVar = this.f44838c;
        if (!fVar.a(fVar.f44855f, view)) {
            GDTLogger.e("\u70b9\u51fb\u5931\u8d25\uff0c\u70b9\u51fb\u7684view\u4e0d\u5728NativeAdContainer\u4e2d");
            return;
        }
        String G = this.f44838c.G();
        com.qq.e.comm.plugin.i.h a4 = new h.b(this.f44839d).a(G).a();
        com.qq.e.comm.plugin.i.d0.d dVar = new com.qq.e.comm.plugin.i.d0.d(view.getContext());
        dVar.a(this.f44839d);
        com.qq.e.comm.plugin.i.g.b(a4, dVar);
        l1.a(this.f44838c.f44855f, this.f44839d, G, view);
        this.f44838c.a(105, new Object[0]);
        n.a(com.qq.e.comm.plugin.n0.c.a(this.f44839d));
    }
}
