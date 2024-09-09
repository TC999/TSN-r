package rx;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleSubscriber.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class k<T> implements m {

    /* renamed from: a  reason: collision with root package name */
    private final rx.internal.util.m f64084a = new rx.internal.util.m();

    public final void b(m mVar) {
        this.f64084a.a(mVar);
    }

    public abstract void c(T t3);

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.f64084a.isUnsubscribed();
    }

    public abstract void onError(Throwable th);

    @Override // rx.m
    public final void unsubscribe() {
        this.f64084a.unsubscribe();
    }
}
