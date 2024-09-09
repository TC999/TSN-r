package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: MultipleAssignmentSubscription.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class c implements m {

    /* renamed from: a  reason: collision with root package name */
    final SequentialSubscription f64355a = new SequentialSubscription();

    public m a() {
        return this.f64355a.current();
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.f64355a.replace(mVar);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f64355a.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f64355a.unsubscribe();
    }
}
