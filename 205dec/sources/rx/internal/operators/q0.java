package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeLift.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q0<T, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final e.a<T> f63156a;

    /* renamed from: b  reason: collision with root package name */
    final e.b<? extends R, ? super T> f63157b;

    public q0(e.a<T> aVar, e.b<? extends R, ? super T> bVar) {
        this.f63156a = aVar;
        this.f63157b = bVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        try {
            rx.l<? super T> call = rx.plugins.c.M(this.f63157b).call(lVar);
            call.onStart();
            this.f63156a.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            lVar.onError(th);
        }
    }
}
