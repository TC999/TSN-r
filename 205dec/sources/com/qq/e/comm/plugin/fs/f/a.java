package com.qq.e.comm.plugin.fs.f;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.c.b;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.n0.c;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.h.f;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private b f43287c;

    public a(Context context, e eVar, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        super(context);
        a(eVar, aVar);
    }

    private void a(e eVar, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        removeAllViews();
        if (eVar.i0() != null && eVar.i0().y()) {
            this.f43287c = new com.qq.e.comm.plugin.fs.f.b.b(getContext(), eVar, aVar);
        } else if (eVar.l1()) {
            this.f43287c = new com.qq.e.comm.plugin.fs.f.c.b(getContext(), eVar, aVar);
        } else {
            this.f43287c = new com.qq.e.comm.plugin.fs.f.b.a(getContext(), eVar, aVar);
        }
        View a4 = this.f43287c.a();
        if (a4 != null) {
            addView(a4);
        } else {
            v.a(9411102, c.a(eVar), 3);
        }
    }

    public com.qq.e.comm.plugin.c.c b() {
        b bVar = this.f43287c;
        if (bVar instanceof com.qq.e.comm.plugin.c.c) {
            return (com.qq.e.comm.plugin.c.c) bVar;
        }
        return null;
    }

    public f c() {
        b bVar = this.f43287c;
        if (bVar instanceof com.qq.e.comm.plugin.c.c) {
            return ((com.qq.e.comm.plugin.c.c) bVar).b();
        }
        return null;
    }

    public s a() {
        b bVar = this.f43287c;
        if (bVar instanceof com.qq.e.comm.plugin.fs.f.c.b) {
            return ((com.qq.e.comm.plugin.fs.f.c.b) bVar).k();
        }
        if (bVar instanceof com.qq.e.comm.plugin.fs.f.b.a) {
            return ((com.qq.e.comm.plugin.fs.f.b.a) bVar).i();
        }
        return null;
    }

    public void a(com.qq.e.comm.plugin.fs.f.d.c cVar) {
        b bVar = this.f43287c;
        if (bVar instanceof com.qq.e.comm.plugin.c.c) {
            ((com.qq.e.comm.plugin.c.c) bVar).a(cVar);
        }
    }
}
