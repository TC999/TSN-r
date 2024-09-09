package rx.internal.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ObserverSubscriber.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class g<T> extends rx.l<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.f<? super T> f63930a;

    public g(rx.f<? super T> fVar) {
        this.f63930a = fVar;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f63930a.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f63930a.onError(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f63930a.onNext(t3);
    }
}
