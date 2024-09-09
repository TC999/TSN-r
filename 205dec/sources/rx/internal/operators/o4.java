package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleFromFuture.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final Future<? extends T> f63080a;

    /* renamed from: b  reason: collision with root package name */
    final long f63081b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f63082c;

    public o4(Future<? extends T> future, long j4, TimeUnit timeUnit) {
        this.f63080a = future;
        this.f63081b = j4;
        this.f63082c = timeUnit;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        Object obj;
        Future<? extends T> future = this.f63080a;
        kVar.b(rx.subscriptions.f.c(future));
        try {
            long j4 = this.f63081b;
            if (j4 == 0) {
                obj = (T) future.get();
            } else {
                obj = (T) future.get(j4, this.f63082c);
            }
            kVar.c(obj);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            kVar.onError(th);
        }
    }
}
