package rx.internal.operators;

import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleDoOnSubscribe.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f62896a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.a f62897b;

    public k4(i.t<T> tVar, rx.functions.a aVar) {
        this.f62896a = tVar;
        this.f62897b = aVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        try {
            this.f62897b.call();
            this.f62896a.call(kVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            kVar.onError(th);
        }
    }
}
