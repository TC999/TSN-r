package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSampleWithTime.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w2<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f63536a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f63537b;

    /* renamed from: c  reason: collision with root package name */
    final rx.h f63538c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSampleWithTime.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: c  reason: collision with root package name */
        private static final Object f63539c = new Object();

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super T> f63540a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<Object> f63541b = new AtomicReference<>(f63539c);

        public a(rx.l<? super T> lVar) {
            this.f63540a = lVar;
        }

        private void g() {
            AtomicReference<Object> atomicReference = this.f63541b;
            Object obj = f63539c;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                try {
                    this.f63540a.onNext(andSet);
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        @Override // rx.functions.a
        public void call() {
            g();
        }

        @Override // rx.f
        public void onCompleted() {
            g();
            this.f63540a.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63540a.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63541b.set(t3);
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public w2(long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f63536a = j4;
        this.f63537b = timeUnit;
        this.f63538c = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        h.a a4 = this.f63538c.a();
        lVar.add(a4);
        a aVar = new a(gVar);
        lVar.add(aVar);
        long j4 = this.f63536a;
        a4.g(aVar, j4, j4, this.f63537b);
        return aVar;
    }
}
