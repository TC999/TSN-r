package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleTakeUntilCompletable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f63653a;

    /* renamed from: b  reason: collision with root package name */
    final rx.b f63654b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleTakeUntilCompletable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> implements rx.d {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f63655b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicBoolean f63656c = new AtomicBoolean();

        a(rx.k<? super T> kVar) {
            this.f63655b = kVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            b(mVar);
        }

        @Override // rx.k
        public void c(T t3) {
            if (this.f63656c.compareAndSet(false, true)) {
                unsubscribe();
                this.f63655b.c(t3);
            }
        }

        @Override // rx.d
        public void onCompleted() {
            onError(new CancellationException("Single::takeUntil(Completable) - Stream was canceled before emitting a terminal event."));
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (this.f63656c.compareAndSet(false, true)) {
                unsubscribe();
                this.f63655b.onError(th);
                return;
            }
            rx.plugins.c.I(th);
        }
    }

    public y4(i.t<T> tVar, rx.b bVar) {
        this.f63653a = tVar;
        this.f63654b = bVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f63654b.q0(aVar);
        this.f63653a.call(aVar);
    }
}
