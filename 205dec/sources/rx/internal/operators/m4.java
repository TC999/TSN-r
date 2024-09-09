package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleFromCallable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f62978a;

    public m4(Callable<? extends T> callable) {
        this.f62978a = callable;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        try {
            kVar.c((T) this.f62978a.call());
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            kVar.onError(th);
        }
    }
}
