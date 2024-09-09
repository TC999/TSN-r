package com.qq.e.comm.plugin.splash;

import com.qq.e.comm.plugin.util.c2;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class m {

    /* renamed from: a  reason: collision with root package name */
    private h f46142a;

    /* renamed from: b  reason: collision with root package name */
    private b f46143b;

    /* renamed from: c  reason: collision with root package name */
    private a f46144c;

    /* renamed from: d  reason: collision with root package name */
    private a f46145d;

    /* renamed from: e  reason: collision with root package name */
    private Future f46146e;

    /* renamed from: f  reason: collision with root package name */
    private Future f46147f;

    /* renamed from: g  reason: collision with root package name */
    private c2.c f46148g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final boolean f46149c;

        /* renamed from: d  reason: collision with root package name */
        b f46150d;

        a(b bVar, boolean z3) {
            this.f46150d = bVar;
            this.f46149c = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f46149c) {
                b bVar = this.f46150d;
                if (bVar != null) {
                    bVar.i();
                    return;
                }
                return;
            }
            b bVar2 = this.f46150d;
            if (bVar2 != null) {
                bVar2.l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b extends c2.b {
        void i();

        void l();
    }

    private void a(h hVar) {
        if (hVar == null) {
            return;
        }
        int i4 = hVar.f46108t;
        if (i4 == 0) {
            n.b(hVar.c());
        }
        long j4 = i4;
        com.qq.e.comm.plugin.j0.b.a().a(j4);
        d1.a("\u5f00\u5c4f\u9884\u52a0\u8f7d\u4f7f\u7528\u7684\u8d85\u65f6\u65f6\u95f4: %s", Integer.valueOf(i4));
        if (i4 < 0 || i4 >= hVar.f46104p) {
            return;
        }
        a aVar = new a(this.f46143b, false);
        this.f46144c = aVar;
        this.f46146e = d0.f46410f.schedule(aVar, j4, TimeUnit.MILLISECONDS);
    }

    private void b(h hVar) {
        if (hVar == null) {
            return;
        }
        a aVar = new a(this.f46143b, true);
        this.f46145d = aVar;
        this.f46147f = d0.f46410f.schedule(aVar, hVar.f46104p, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        c2.c cVar = this.f46148g;
        if (cVar != null) {
            cVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        c2.c cVar = this.f46148g;
        if (cVar != null) {
            cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        h hVar = this.f46142a;
        if (b()) {
            return;
        }
        c2.c cVar = new c2.c(hVar.d(), 500L);
        this.f46148g = cVar;
        hVar.B = cVar;
        cVar.a(this.f46143b);
        this.f46148g.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (b()) {
            return;
        }
        b(this.f46142a);
        a(this.f46142a);
    }

    public boolean b() {
        return this.f46142a == null || this.f46143b == null;
    }

    public void a(h hVar, b bVar) {
        a();
        this.f46142a = hVar;
        this.f46143b = bVar;
    }

    public void a() {
        Future future = this.f46146e;
        if (future != null) {
            future.cancel(false);
            this.f46146e = null;
        }
        Future future2 = this.f46147f;
        if (future2 != null) {
            future2.cancel(false);
            this.f46147f = null;
        }
        a aVar = this.f46144c;
        if (aVar != null) {
            aVar.f46150d = null;
            this.f46144c = null;
        }
        a aVar2 = this.f46145d;
        if (aVar2 != null) {
            aVar2.f46150d = null;
            this.f46145d = null;
        }
        c2.c cVar = this.f46148g;
        if (cVar != null) {
            cVar.a((c2.b) null);
            this.f46148g.h();
            this.f46148g = null;
        }
        this.f46143b = null;
        this.f46142a = null;
    }
}
