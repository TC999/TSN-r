package com.qq.e.comm.plugin.z;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.plugin.dl.i;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.g0.q;
import com.qq.e.comm.plugin.u.f;
import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.comm.plugin.u.k.c {

    /* renamed from: l  reason: collision with root package name */
    private boolean f46795l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f46796m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.super.d();
        }
    }

    public b(Context context, q qVar, VideoOption videoOption, f.a aVar, com.qq.e.comm.plugin.n0.c cVar) {
        super(context, qVar, videoOption, aVar, cVar);
    }

    private void a(String str) {
    }

    private void c(boolean z3) {
        s a4 = i.a().a(this.f46310b, this.f46311c, z3);
        if (a4 == null) {
            c();
            this.f46313e.d(this.f46311c.G0());
            return;
        }
        a(a4, this.f46796m);
    }

    private boolean k() {
        return com.qq.e.comm.plugin.d0.a.d().c().x();
    }

    private boolean m() {
        boolean l4 = l();
        if (l4 != this.f46795l) {
            c(false);
            a("\u6e32\u67d3\u65b9\u5411\u6539\u53d8\uff0c\u4f7f\u7528\u515c\u5e95\u6e32\u67d3");
            return true;
        } else if (this.f46311c.i0() == null) {
            c(true);
            a("Native DSL\u65e0\u6548\uff0c\u4f7f\u7528\u515c\u5e95\u6e32\u67d3");
            return true;
        } else if (this.f46311c.i0().m() != 0) {
            boolean z3 = l4 != this.f46311c.i0().v();
            if (z3) {
                c(false);
                a("\u6e32\u67d3\u65b9\u5411\u4e0e\u6a21\u677f\u65b9\u5411\u4e0d\u4e00\u81f4\uff0c\u4f7f\u7528\u515c\u5e95\u6e32\u67d3");
            }
            return z3;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.u.k.c
    public void d() {
        p0.a(new a(), 100L);
    }

    protected boolean l() {
        return this.f46311c.q1() > this.f46311c.o1();
    }

    @Override // com.qq.e.comm.plugin.u.k.c, com.qq.e.comm.plugin.u.f
    public void a(boolean z3) {
        d();
        this.f46795l = k();
        this.f46796m = z3;
    }

    @Override // com.qq.e.comm.plugin.u.k.c, com.qq.e.comm.plugin.u.f
    public void a(Activity activity) {
        super.a(activity);
        if (m()) {
            return;
        }
        b(this.f46796m);
    }
}
