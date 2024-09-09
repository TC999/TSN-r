package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;
    final Subscriber<? super T> actual;
    volatile boolean done;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicLong requested = new AtomicLong();

    /* renamed from: s  reason: collision with root package name */
    final AtomicReference<Subscription> f55187s = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.actual = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.done) {
            return;
        }
        SubscriptionHelper.cancel(this.f55187s);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        HalfSerializer.onComplete(this.actual, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.done = true;
        HalfSerializer.onError(this.actual, th, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t3) {
        HalfSerializer.onNext(this.actual, t3, this, this.error);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.once.compareAndSet(false, true)) {
            this.actual.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.f55187s, this.requested, subscription);
            return;
        }
        subscription.cancel();
        cancel();
        onError(new IllegalStateException("\u00a72.12 violated: onSubscribe must be called at most once"));
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j4) {
        if (j4 <= 0) {
            cancel();
            onError(new IllegalArgumentException("\u00a73.9 violated: positive request amount required but it was " + j4));
            return;
        }
        SubscriptionHelper.deferredRequest(this.f55187s, this.requested, j4);
    }
}
