package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDoOnSubscribe.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c2<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.functions.a f62441a;

    public c2(rx.functions.a aVar) {
        this.f62441a = aVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        this.f62441a.call();
        return rx.observers.h.f(lVar);
    }
}