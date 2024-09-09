package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.e;
import rx.internal.producers.SingleProducer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeToObservableFuture.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeToObservableFuture.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a<T> implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final Future<? extends T> f62817a;

        /* renamed from: b  reason: collision with root package name */
        private final long f62818b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f62819c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeToObservableFuture.java */
        /* renamed from: rx.internal.operators.j1$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1285a implements rx.functions.a {
            C1285a() {
            }

            @Override // rx.functions.a
            public void call() {
                a.this.f62817a.cancel(true);
            }
        }

        public a(Future<? extends T> future) {
            this.f62817a = future;
            this.f62818b = 0L;
            this.f62819c = null;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            lVar.add(rx.subscriptions.f.a(new C1285a()));
            try {
                if (lVar.isUnsubscribed()) {
                    return;
                }
                TimeUnit timeUnit = this.f62819c;
                lVar.setProducer(new SingleProducer(lVar, timeUnit == null ? this.f62817a.get() : this.f62817a.get(this.f62818b, timeUnit)));
            } catch (Throwable th) {
                if (lVar.isUnsubscribed()) {
                    return;
                }
                rx.exceptions.a.f(th, lVar);
            }
        }

        public a(Future<? extends T> future, long j4, TimeUnit timeUnit) {
            this.f62817a = future;
            this.f62818b = j4;
            this.f62819c = timeUnit;
        }
    }

    private j1() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> e.a<T> a(Future<? extends T> future) {
        return new a(future);
    }

    public static <T> e.a<T> b(Future<? extends T> future, long j4, TimeUnit timeUnit) {
        return new a(future, j4, timeUnit);
    }
}
