package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeThrow.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e1<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f62524a;

    public e1(Throwable th) {
        this.f62524a = th;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        lVar.onError(this.f62524a);
    }
}
