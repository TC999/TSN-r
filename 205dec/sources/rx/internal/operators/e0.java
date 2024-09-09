package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeDelaySubscriptionWithSelector.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e0<T, U> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends T> f62520a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.o<? extends rx.e<U>> f62521b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeDelaySubscriptionWithSelector.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<U> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f62522a;

        a(rx.l lVar) {
            this.f62522a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            e0.this.f62520a.I6(rx.observers.h.f(this.f62522a));
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62522a.onError(th);
        }

        @Override // rx.f
        public void onNext(U u3) {
        }
    }

    public e0(rx.e<? extends T> eVar, rx.functions.o<? extends rx.e<U>> oVar) {
        this.f62520a = eVar;
        this.f62521b = oVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        try {
            this.f62521b.call().C5(1).I6(new a(lVar));
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }
}
