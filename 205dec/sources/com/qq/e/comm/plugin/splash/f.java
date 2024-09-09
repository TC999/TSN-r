package com.qq.e.comm.plugin.splash;

import android.view.View;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f implements Object<h> {

    /* renamed from: c  reason: collision with root package name */
    private h f46077c;

    public void a(h hVar, com.qq.e.comm.plugin.splash.r.c cVar) {
        this.f46077c = hVar;
    }

    public void b() {
        View view;
        if (c() || (view = this.f46077c.f46112x) == null) {
            return;
        }
        view.post(this);
    }

    public boolean c() {
        return this.f46077c == null;
    }

    public void run() {
        View view;
        h hVar = this.f46077c;
        if (c() || (view = this.f46077c.f46112x) == null) {
            return;
        }
        GDTLogger.d("\u5f00\u5c4f\u5f00\u59cb\u66dd\u5149");
        c0 b4 = hVar.b();
        com.qq.e.comm.plugin.e.a a4 = com.qq.e.comm.plugin.e.a.a();
        com.qq.e.comm.plugin.e.i.a d4 = a4.d(view);
        if (d4 != null) {
            d4.e(41);
            d4.a(b4.e1());
        }
        com.qq.e.comm.plugin.l0.c.a(a4.c(view), b4, null, this.f46077c.f46103o, null);
        if (b4.e1()) {
            n.c(hVar.c());
        }
        l1.a(view, b4);
    }

    public void a() {
        this.f46077c = null;
    }
}
