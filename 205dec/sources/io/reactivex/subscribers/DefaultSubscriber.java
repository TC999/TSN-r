package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {

    /* renamed from: s  reason: collision with root package name */
    private Subscription f55203s;

    protected final void cancel() {
        Subscription subscription = this.f55203s;
        this.f55203s = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    protected void onStart() {
        request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.f55203s, subscription, getClass())) {
            this.f55203s = subscription;
            onStart();
        }
    }

    protected final void request(long j4) {
        Subscription subscription = this.f55203s;
        if (subscription != null) {
            subscription.request(j4);
        }
    }
}
