package p640rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Cancellable;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.subscriptions.CancellableSubscription */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CancellableSubscription extends AtomicReference<Cancellable> implements Subscription {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(Cancellable cancellable) {
        super(cancellable);
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return get() == null;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        Cancellable andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e) {
            C15575a.m1474e(e);
            RxJavaHooks.m576I(e);
        }
    }
}
