package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.plugin.util.q0;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private final g f44840c;

    /* renamed from: d  reason: collision with root package name */
    private final f f44841d;

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.plugin.i.d0.b f44842e;

    /* renamed from: f  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f44843f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f44844g;

    public e(f fVar, g gVar, Context context, com.qq.e.comm.plugin.n0.c cVar) {
        this(fVar, gVar, context, cVar, false);
    }

    private void d() {
        if (this.f44841d.W > 0) {
            n.b(this.f44843f, System.currentTimeMillis() - this.f44841d.W);
        }
    }

    public void a(String str) {
        com.qq.e.comm.plugin.e.a.a().a(this.f44841d.f44855f, this.f44840c, str);
        a(false, this.f44841d.f44855f, 2, 0);
        n.c(this.f44843f);
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a(this.f44844g, this.f44841d.f44855f, -999, 2);
        n.e(this.f44843f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        a(false, this.f44841d.f44855f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d1.a("report click event", new Object[0]);
        f fVar = this.f44841d;
        if (!fVar.a(fVar.f44855f, view)) {
            GDTLogger.e("\u70b9\u51fb\u5931\u8d25\uff0c\u70b9\u51fb\u7684view\u4e0d\u5728NativeAdContainer\u4e2d");
            return;
        }
        d();
        if (this.f44841d.A()) {
            f fVar2 = this.f44841d;
            if (fVar2.f44890z) {
                if (view != fVar2.f44861i && view != fVar2.M) {
                    a(this.f44844g, view);
                    return;
                }
                f fVar3 = this.f44841d;
                if (fVar3.f44888x) {
                    fVar3.w();
                    return;
                } else {
                    a(view);
                    return;
                }
            }
        }
        a(this.f44844g, view);
    }

    public e(f fVar, g gVar, Context context, com.qq.e.comm.plugin.n0.c cVar, boolean z3) {
        this.f44841d = fVar;
        this.f44840c = gVar;
        com.qq.e.comm.plugin.i.d0.d dVar = new com.qq.e.comm.plugin.i.d0.d(context, fVar);
        dVar.a(gVar);
        this.f44842e = dVar;
        this.f44843f = cVar;
        this.f44844g = z3;
    }

    public void a(com.qq.e.comm.plugin.i.f fVar) {
        f fVar2 = this.f44841d;
        if (fVar2.f44888x && fVar.f44109f == 3) {
            fVar2.w();
            return;
        }
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f44841d.f44855f);
        if (d4 != null) {
            int i4 = fVar.f44110g;
            if (2 == i4) {
                d4.a(fVar.f44111h);
            } else if (5 == i4) {
                d4.a(fVar.f44112i, fVar.f44113j);
            }
            d4.b(fVar.f44106c);
            d4.a(fVar.b());
            d4.a(fVar.f44117n);
            d4.a(fVar.f44118o);
            d4.b(fVar.f44119p);
        }
        a(false, this.f44841d.f44855f, fVar.f44109f, fVar.f44110g, fVar.f44106c, fVar.f44116m);
        n.a(this.f44843f, fVar.f44106c);
    }

    public void a() {
        this.f44841d.F();
    }

    void a(boolean z3, View view, int i4, int i5) {
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f44841d.f44855f);
        if (d4 != null) {
            d4.b(-999);
        }
        a(z3, view, i4, i5, 0, false);
    }

    private void a(boolean z3, View view, int i4, int i5, int i6, boolean z4) {
        boolean z5;
        boolean z6;
        boolean z7;
        if (z3 && this.f44840c.X0()) {
            int b4 = com.qq.e.comm.plugin.apkmanager.k.e().b(this.f44840c.v1());
            if (com.qq.e.comm.plugin.d0.a.d().f().a("nuaico", this.f44840c.q0(), 0) == 1 && com.qq.e.comm.plugin.i.i.c(this.f44840c, b4)) {
                z7 = false;
                z6 = true;
            } else {
                z7 = true;
                z6 = false;
            }
            z5 = z7 && !((this.f44840c.i1() && com.qq.e.comm.plugin.apkmanager.w.d.f(b4)) || (this.f44840c.j1() && q0.a(this.f44840c.E0())));
        } else {
            z5 = false;
            z6 = false;
        }
        String a4 = this.f44841d.a(i4, i5);
        h.b b5 = new h.b(this.f44840c).a(!z5).c(i6).f(z6).a(a4).e(z4).b(i5);
        if (i4 != -999) {
            b5.a(i4);
        }
        com.qq.e.comm.plugin.i.g.a(b5.a(), this.f44842e);
        l1.a(this.f44841d.f44855f, this.f44840c, a4, view);
        this.f44841d.b(105, view);
        if (this.f44841d.A()) {
            this.f44841d.f(true);
        }
    }

    private void a(boolean z3, View view) {
        a(z3, view, -999, 0);
        n.b(this.f44843f);
    }

    void a(View view) {
        a(false, view, 3, 0);
        n.f(this.f44843f);
    }
}
