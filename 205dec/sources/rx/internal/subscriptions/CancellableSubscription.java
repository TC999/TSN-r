package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.a;
import rx.functions.n;
import rx.m;
import rx.plugins.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class CancellableSubscription extends AtomicReference<n> implements m {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(n nVar) {
        super(nVar);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return get() == null;
    }

    @Override // rx.m
    public void unsubscribe() {
        n andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e4) {
            a.e(e4);
            c.I(e4);
        }
    }
}
