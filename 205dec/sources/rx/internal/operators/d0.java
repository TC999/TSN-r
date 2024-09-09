package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeDelaySubscriptionOther.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d0<T, U> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends T> f62489a;

    /* renamed from: b  reason: collision with root package name */
    final rx.e<U> f62490b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeDelaySubscriptionOther.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<U> {

        /* renamed from: a  reason: collision with root package name */
        boolean f62491a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f62492b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f62493c;

        a(rx.l lVar, rx.subscriptions.e eVar) {
            this.f62492b = lVar;
            this.f62493c = eVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62491a) {
                return;
            }
            this.f62491a = true;
            this.f62493c.b(rx.subscriptions.f.e());
            d0.this.f62489a.I6(this.f62492b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62491a) {
                rx.plugins.c.I(th);
                return;
            }
            this.f62491a = true;
            this.f62492b.onError(th);
        }

        @Override // rx.f
        public void onNext(U u3) {
            onCompleted();
        }
    }

    public d0(rx.e<? extends T> eVar, rx.e<U> eVar2) {
        this.f62489a = eVar;
        this.f62490b = eVar2;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        lVar.add(eVar);
        a aVar = new a(rx.observers.h.f(lVar), eVar);
        eVar.b(aVar);
        this.f62490b.I6(aVar);
    }
}
