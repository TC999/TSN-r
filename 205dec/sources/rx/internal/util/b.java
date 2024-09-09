package rx.internal.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ActionObserver.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class b<T> implements rx.f<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.b<? super T> f63910a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.b<? super Throwable> f63911b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.a f63912c;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.f63910a = bVar;
        this.f63911b = bVar2;
        this.f63912c = aVar;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f63912c.call();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f63911b.call(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f63910a.call(t3);
    }
}
