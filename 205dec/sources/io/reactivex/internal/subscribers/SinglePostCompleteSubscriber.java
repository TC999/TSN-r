package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final Subscriber<? super R> actual;
    protected long produced;

    /* renamed from: s  reason: collision with root package name */
    protected Subscription f55186s;
    protected R value;

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.actual = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f55186s.cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void complete(R r3) {
        long j4 = this.produced;
        if (j4 != 0) {
            BackpressureHelper.produced(this, j4);
        }
        while (true) {
            long j5 = get();
            if ((j5 & Long.MIN_VALUE) != 0) {
                onDrop(r3);
                return;
            } else if ((j5 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.actual.onNext(r3);
                this.actual.onComplete();
                return;
            } else {
                this.value = r3;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                }
                this.value = null;
            }
        }
    }

    protected void onDrop(R r3) {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f55186s, subscription)) {
            this.f55186s = subscription;
            this.actual.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j4) {
        long j5;
        if (SubscriptionHelper.validate(j4)) {
            do {
                j5 = get();
                if ((j5 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.actual.onNext((R) this.value);
                        this.actual.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j5, BackpressureHelper.addCap(j5, j4)));
            this.f55186s.request(j4);
        }
    }
}
