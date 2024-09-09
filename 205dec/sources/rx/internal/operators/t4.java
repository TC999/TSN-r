package rx.internal.operators;

import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleOnSubscribeDelaySubscriptionOther.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.i<? extends T> f63390a;

    /* renamed from: b  reason: collision with root package name */
    final rx.e<?> f63391b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleOnSubscribeDelaySubscriptionOther.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.k f63392b;

        a(rx.k kVar) {
            this.f63392b = kVar;
        }

        @Override // rx.k
        public void c(T t3) {
            this.f63392b.c(t3);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f63392b.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleOnSubscribeDelaySubscriptionOther.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<Object> {

        /* renamed from: a  reason: collision with root package name */
        boolean f63394a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.k f63395b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f63396c;

        b(rx.k kVar, rx.subscriptions.e eVar) {
            this.f63395b = kVar;
            this.f63396c = eVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63394a) {
                return;
            }
            this.f63394a = true;
            this.f63396c.b(this.f63395b);
            t4.this.f63390a.i0(this.f63395b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63394a) {
                rx.plugins.c.I(th);
                return;
            }
            this.f63394a = true;
            this.f63395b.onError(th);
        }

        @Override // rx.f
        public void onNext(Object obj) {
            onCompleted();
        }
    }

    public t4(rx.i<? extends T> iVar, rx.e<?> eVar) {
        this.f63390a = iVar;
        this.f63391b = eVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        kVar.b(eVar);
        b bVar = new b(aVar, eVar);
        eVar.b(bVar);
        this.f63391b.q5(bVar);
    }
}
