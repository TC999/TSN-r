package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleTakeUntilObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z4<T, U> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f63715a;

    /* renamed from: b  reason: collision with root package name */
    final rx.e<? extends U> f63716b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleTakeUntilObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, U> extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f63717b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicBoolean f63718c = new AtomicBoolean();

        /* renamed from: d  reason: collision with root package name */
        final rx.l<U> f63719d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: SingleTakeUntilObservable.java */
        /* renamed from: rx.internal.operators.z4$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class C1306a extends rx.l<U> {
            C1306a() {
            }

            @Override // rx.f
            public void onCompleted() {
                onError(new CancellationException("Single::takeUntil(Observable) - Stream was canceled before emitting a terminal event."));
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.onError(th);
            }

            @Override // rx.f
            public void onNext(U u3) {
                onCompleted();
            }
        }

        a(rx.k<? super T> kVar) {
            this.f63717b = kVar;
            C1306a c1306a = new C1306a();
            this.f63719d = c1306a;
            b(c1306a);
        }

        @Override // rx.k
        public void c(T t3) {
            if (this.f63718c.compareAndSet(false, true)) {
                unsubscribe();
                this.f63717b.c(t3);
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (this.f63718c.compareAndSet(false, true)) {
                unsubscribe();
                this.f63717b.onError(th);
                return;
            }
            rx.plugins.c.I(th);
        }
    }

    public z4(i.t<T> tVar, rx.e<? extends U> eVar) {
        this.f63715a = tVar;
        this.f63716b = eVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f63716b.q5(aVar.f63719d);
        this.f63715a.call(aVar);
    }
}
