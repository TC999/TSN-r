package rx.internal.operators;

import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleDoOnUnsubscribe.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f62945a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.a f62946b;

    public l4(i.t<T> tVar, rx.functions.a aVar) {
        this.f62945a = tVar;
        this.f62946b = aVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        kVar.b(rx.subscriptions.f.a(this.f62946b));
        this.f62945a.call(kVar);
    }
}
