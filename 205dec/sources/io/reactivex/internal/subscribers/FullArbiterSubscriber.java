package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.FullArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FullArbiterSubscriber<T> implements FlowableSubscriber<T> {
    final FullArbiter<T> arbiter;

    /* renamed from: s  reason: collision with root package name */
    Subscription f55180s;

    public FullArbiterSubscriber(FullArbiter<T> fullArbiter) {
        this.arbiter = fullArbiter;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.arbiter.onComplete(this.f55180s);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.arbiter.onError(th, this.f55180s);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t3) {
        this.arbiter.onNext(t3, this.f55180s);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f55180s, subscription)) {
            this.f55180s = subscription;
            this.arbiter.setSubscription(subscription);
        }
    }
}
