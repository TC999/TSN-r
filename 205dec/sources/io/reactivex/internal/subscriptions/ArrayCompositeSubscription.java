package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i4) {
        super(i4);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Subscription andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i4 = 0; i4 < length; i4++) {
                Subscription subscription = get(i4);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper && (andSet = getAndSet(i4, subscriptionHelper)) != subscriptionHelper && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public Subscription replaceResource(int i4, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get(i4);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return null;
                }
                return null;
            }
        } while (!compareAndSet(i4, subscription2, subscription));
        return subscription2;
    }

    public boolean setResource(int i4, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get(i4);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(i4, subscription2, subscription));
        if (subscription2 != null) {
            subscription2.cancel();
            return true;
        }
        return true;
    }
}
