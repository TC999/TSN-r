package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTakeTimed.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f62941a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f62942b;

    /* renamed from: c  reason: collision with root package name */
    final rx.h f62943c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeTimed.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62944a;

        public a(rx.l<? super T> lVar) {
            super(lVar);
            this.f62944a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            onCompleted();
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62944a.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62944a.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62944a.onNext(t3);
        }
    }

    public l3(long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f62941a = j4;
        this.f62942b = timeUnit;
        this.f62943c = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        h.a a4 = this.f62943c.a();
        lVar.add(a4);
        a aVar = new a(new rx.observers.g(lVar));
        a4.e(aVar, this.f62941a, this.f62942b);
        return aVar;
    }
}
