package rx.internal.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ActionSubscriber.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class c<T> extends rx.l<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.b<? super T> f63913a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.b<Throwable> f63914b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.a f63915c;

    public c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.f63913a = bVar;
        this.f63914b = bVar2;
        this.f63915c = aVar;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f63915c.call();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f63914b.call(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f63913a.call(t3);
    }
}
