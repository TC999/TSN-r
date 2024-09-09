package rx.internal.operators;

import rx.e;
import rx.i;
import rx.internal.operators.p4;
import rx.internal.producers.SingleProducer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleLiftObservableOperator.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q4<T, R> implements i.t<R> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f63184a;

    /* renamed from: b  reason: collision with root package name */
    final e.b<? extends R, ? super T> f63185b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleLiftObservableOperator.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final rx.l<? super T> f63186b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(rx.l<? super T> lVar) {
            this.f63186b = lVar;
        }

        @Override // rx.k
        public void c(T t3) {
            this.f63186b.setProducer(new SingleProducer(this.f63186b, t3));
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f63186b.onError(th);
        }
    }

    public q4(i.t<T> tVar, e.b<? extends R, ? super T> bVar) {
        this.f63184a = tVar;
        this.f63185b = bVar;
    }

    public static <T> rx.k<T> a(rx.l<T> lVar) {
        a aVar = new a(lVar);
        lVar.add(aVar);
        return aVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super R> kVar) {
        p4.a aVar = new p4.a(kVar);
        kVar.b(aVar);
        try {
            rx.l<? super T> call = rx.plugins.c.R(this.f63185b).call(aVar);
            rx.k a4 = a(call);
            call.onStart();
            this.f63184a.call(a4);
        } catch (Throwable th) {
            rx.exceptions.a.h(th, kVar);
        }
    }
}
