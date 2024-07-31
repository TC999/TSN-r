package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.FullArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FullArbiterSubscriber<T> implements FlowableSubscriber<T> {
    final FullArbiter<T> arbiter;

    /* renamed from: s */
    Subscription f40731s;

    public FullArbiterSubscriber(FullArbiter<T> fullArbiter) {
        this.arbiter = fullArbiter;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.arbiter.onComplete(this.f40731s);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.arbiter.onError(th, this.f40731s);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.arbiter.onNext(t, this.f40731s);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f40731s, subscription)) {
            this.f40731s = subscription;
            this.arbiter.setSubscription(subscription);
        }
    }
}
