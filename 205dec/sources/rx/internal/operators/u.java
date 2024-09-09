package rx.internal.operators;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DeferredScalarSubscriberSafe.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class u<T, R> extends t<T, R> {

    /* renamed from: i  reason: collision with root package name */
    protected boolean f63398i;

    public u(rx.l<? super R> lVar) {
        super(lVar);
    }

    @Override // rx.internal.operators.t, rx.f
    public void onCompleted() {
        if (this.f63398i) {
            return;
        }
        this.f63398i = true;
        super.onCompleted();
    }

    @Override // rx.internal.operators.t, rx.f
    public void onError(Throwable th) {
        if (!this.f63398i) {
            this.f63398i = true;
            super.onError(th);
            return;
        }
        rx.plugins.c.I(th);
    }
}
