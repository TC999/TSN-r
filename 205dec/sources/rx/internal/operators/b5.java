package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.h;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleTimeout.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b5<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f62410a;

    /* renamed from: b  reason: collision with root package name */
    final long f62411b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f62412c;

    /* renamed from: d  reason: collision with root package name */
    final rx.h f62413d;

    /* renamed from: e  reason: collision with root package name */
    final i.t<? extends T> f62414e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleTimeout.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> implements rx.functions.a {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f62415b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicBoolean f62416c = new AtomicBoolean();

        /* renamed from: d  reason: collision with root package name */
        final i.t<? extends T> f62417d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: SingleTimeout.java */
        /* renamed from: rx.internal.operators.b5$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1276a<T> extends rx.k<T> {

            /* renamed from: b  reason: collision with root package name */
            final rx.k<? super T> f62418b;

            C1276a(rx.k<? super T> kVar) {
                this.f62418b = kVar;
            }

            @Override // rx.k
            public void c(T t3) {
                this.f62418b.c(t3);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f62418b.onError(th);
            }
        }

        a(rx.k<? super T> kVar, i.t<? extends T> tVar) {
            this.f62415b = kVar;
            this.f62417d = tVar;
        }

        @Override // rx.k
        public void c(T t3) {
            if (this.f62416c.compareAndSet(false, true)) {
                try {
                    this.f62415b.c(t3);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f62416c.compareAndSet(false, true)) {
                try {
                    i.t<? extends T> tVar = this.f62417d;
                    if (tVar == null) {
                        this.f62415b.onError(new TimeoutException());
                    } else {
                        C1276a c1276a = new C1276a(this.f62415b);
                        this.f62415b.b(c1276a);
                        tVar.call(c1276a);
                    }
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (this.f62416c.compareAndSet(false, true)) {
                try {
                    this.f62415b.onError(th);
                    return;
                } finally {
                    unsubscribe();
                }
            }
            rx.plugins.c.I(th);
        }
    }

    public b5(i.t<T> tVar, long j4, TimeUnit timeUnit, rx.h hVar, i.t<? extends T> tVar2) {
        this.f62410a = tVar;
        this.f62411b = j4;
        this.f62412c = timeUnit;
        this.f62413d = hVar;
        this.f62414e = tVar2;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar, this.f62414e);
        h.a a4 = this.f62413d.a();
        aVar.b(a4);
        kVar.b(aVar);
        a4.e(aVar, this.f62411b, this.f62412c);
        this.f62410a.call(aVar);
    }
}
