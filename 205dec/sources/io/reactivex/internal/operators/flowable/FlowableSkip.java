package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: n  reason: collision with root package name */
    final long f54957n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        long remaining;

        /* renamed from: s  reason: collision with root package name */
        Subscription f54958s;

        SkipSubscriber(Subscriber<? super T> subscriber, long j4) {
            this.actual = subscriber;
            this.remaining = j4;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f54958s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t3) {
            long j4 = this.remaining;
            if (j4 != 0) {
                this.remaining = j4 - 1;
            } else {
                this.actual.onNext(t3);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f54958s, subscription)) {
                long j4 = this.remaining;
                this.f54958s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(j4);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j4) {
            this.f54958s.request(j4);
        }
    }

    public FlowableSkip(Flowable<T> flowable, long j4) {
        super(flowable);
        this.f54957n = j4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new SkipSubscriber(subscriber, this.f54957n));
    }
}
