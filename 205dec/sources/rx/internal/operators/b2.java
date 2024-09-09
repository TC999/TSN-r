package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDoOnRequest.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b2<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.b<? super Long> f62387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDoOnRequest.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62388a;

        a(b bVar) {
            this.f62388a = bVar;
        }

        @Override // rx.g
        public void request(long j4) {
            b2.this.f62387a.call(Long.valueOf(j4));
            this.f62388a.v(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDoOnRequest.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super T> f62390a;

        b(rx.l<? super T> lVar) {
            this.f62390a = lVar;
            request(0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(long j4) {
            request(j4);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62390a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62390a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62390a.onNext(t3);
        }
    }

    public b2(rx.functions.b<? super Long> bVar) {
        this.f62387a = bVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar);
        lVar.setProducer(new a(bVar));
        lVar.add(bVar);
        return bVar;
    }
}
