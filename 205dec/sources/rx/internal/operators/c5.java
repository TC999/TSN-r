package rx.internal.operators;

import rx.e;
import rx.i;
import rx.internal.operators.q4;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleToObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c5<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f62478a;

    public c5(i.t<T> tVar) {
        this.f62478a = tVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        q4.a aVar = new q4.a(lVar);
        lVar.add(aVar);
        this.f62478a.call(aVar);
    }
}
