package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeDefer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.o<? extends rx.e<? extends T>> f62380a;

    public b0(rx.functions.o<? extends rx.e<? extends T>> oVar) {
        this.f62380a = oVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        try {
            this.f62380a.call().I6(rx.observers.h.f(lVar));
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }
}
