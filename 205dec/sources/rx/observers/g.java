package rx.observers;

import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SerializedSubscriber.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class g<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.f<T> f64182a;

    public g(l<? super T> lVar) {
        this(lVar, true);
    }

    @Override // rx.f
    public void onCompleted() {
        this.f64182a.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f64182a.onError(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f64182a.onNext(t3);
    }

    public g(l<? super T> lVar, boolean z3) {
        super(lVar, z3);
        this.f64182a = new f(lVar);
    }
}
