package rx.internal.operators;

import rx.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableFlatMapSingleToCompletable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i<T> implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final rx.i<T> f62743a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.b> f62744b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableFlatMapSingleToCompletable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> implements rx.d {

        /* renamed from: b  reason: collision with root package name */
        final rx.d f62745b;

        /* renamed from: c  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.b> f62746c;

        public a(rx.d dVar, rx.functions.p<? super T, ? extends rx.b> pVar) {
            this.f62745b = dVar;
            this.f62746c = pVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            b(mVar);
        }

        @Override // rx.k
        public void c(T t3) {
            try {
                rx.b call = this.f62746c.call(t3);
                if (call == null) {
                    onError(new NullPointerException("The mapper returned a null Completable"));
                } else {
                    call.q0(this);
                }
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                onError(th);
            }
        }

        @Override // rx.d
        public void onCompleted() {
            this.f62745b.onCompleted();
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f62745b.onError(th);
        }
    }

    public i(rx.i<T> iVar, rx.functions.p<? super T, ? extends rx.b> pVar) {
        this.f62743a = iVar;
        this.f62744b = pVar;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar, this.f62744b);
        dVar.a(aVar);
        this.f62743a.i0(aVar);
    }
}
