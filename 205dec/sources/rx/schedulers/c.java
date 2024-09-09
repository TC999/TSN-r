package rx.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;
import rx.internal.schedulers.j;
import rx.internal.schedulers.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: Schedulers.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference<c> f64237d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    private final h f64238a;

    /* renamed from: b  reason: collision with root package name */
    private final h f64239b;

    /* renamed from: c  reason: collision with root package name */
    private final h f64240c;

    private c() {
        rx.plugins.g f4 = rx.plugins.f.c().f();
        h g4 = f4.g();
        if (g4 != null) {
            this.f64238a = g4;
        } else {
            this.f64238a = rx.plugins.g.a();
        }
        h i4 = f4.i();
        if (i4 != null) {
            this.f64239b = i4;
        } else {
            this.f64239b = rx.plugins.g.c();
        }
        h j4 = f4.j();
        if (j4 != null) {
            this.f64240c = j4;
        } else {
            this.f64240c = rx.plugins.g.e();
        }
    }

    public static h a() {
        return rx.plugins.c.E(c().f64238a);
    }

    public static h b(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    private static c c() {
        while (true) {
            AtomicReference<c> atomicReference = f64237d;
            c cVar = atomicReference.get();
            if (cVar != null) {
                return cVar;
            }
            c cVar2 = new c();
            if (atomicReference.compareAndSet(null, cVar2)) {
                return cVar2;
            }
            cVar2.i();
        }
    }

    public static h d() {
        return rx.internal.schedulers.f.f63803a;
    }

    public static h e() {
        return rx.plugins.c.J(c().f64239b);
    }

    public static h f() {
        return rx.plugins.c.K(c().f64240c);
    }

    public static void g() {
        c andSet = f64237d.getAndSet(null);
        if (andSet != null) {
            andSet.i();
        }
    }

    public static void h() {
        c c4 = c();
        c4.i();
        synchronized (c4) {
            rx.internal.schedulers.d.f63797d.shutdown();
        }
    }

    public static void j() {
        c c4 = c();
        c4.k();
        synchronized (c4) {
            rx.internal.schedulers.d.f63797d.start();
        }
    }

    public static d l() {
        return new d();
    }

    public static h m() {
        return m.f63851a;
    }

    synchronized void i() {
        h hVar = this.f64238a;
        if (hVar instanceof j) {
            ((j) hVar).shutdown();
        }
        h hVar2 = this.f64239b;
        if (hVar2 instanceof j) {
            ((j) hVar2).shutdown();
        }
        h hVar3 = this.f64240c;
        if (hVar3 instanceof j) {
            ((j) hVar3).shutdown();
        }
    }

    synchronized void k() {
        h hVar = this.f64238a;
        if (hVar instanceof j) {
            ((j) hVar).start();
        }
        h hVar2 = this.f64239b;
        if (hVar2 instanceof j) {
            ((j) hVar2).start();
        }
        h hVar3 = this.f64240c;
        if (hVar3 instanceof j) {
            ((j) hVar3).start();
        }
    }
}
