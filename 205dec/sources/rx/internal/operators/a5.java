package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleTakeUntilSingle.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a5<T, U> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f62370a;

    /* renamed from: b  reason: collision with root package name */
    final rx.i<? extends U> f62371b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleTakeUntilSingle.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, U> extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f62372b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicBoolean f62373c = new AtomicBoolean();

        /* renamed from: d  reason: collision with root package name */
        final rx.k<U> f62374d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: SingleTakeUntilSingle.java */
        /* renamed from: rx.internal.operators.a5$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class C1274a extends rx.k<U> {
            C1274a() {
            }

            @Override // rx.k
            public void c(U u3) {
                onError(new CancellationException("Single::takeUntil(Single) - Stream was canceled before emitting a terminal event."));
            }

            @Override // rx.k
            public void onError(Throwable th) {
                a.this.onError(th);
            }
        }

        a(rx.k<? super T> kVar) {
            this.f62372b = kVar;
            C1274a c1274a = new C1274a();
            this.f62374d = c1274a;
            b(c1274a);
        }

        @Override // rx.k
        public void c(T t3) {
            if (this.f62373c.compareAndSet(false, true)) {
                unsubscribe();
                this.f62372b.c(t3);
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (this.f62373c.compareAndSet(false, true)) {
                unsubscribe();
                this.f62372b.onError(th);
                return;
            }
            rx.plugins.c.I(th);
        }
    }

    public a5(i.t<T> tVar, rx.i<? extends U> iVar) {
        this.f62370a = tVar;
        this.f62371b = iVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f62371b.i0(aVar.f62374d);
        this.f62370a.call(aVar);
    }
}
