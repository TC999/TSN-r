package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final InnerQueuedSubscriberSupport<T> parent;
    final int prefetch;
    long produced;
    volatile SimpleQueue<T> queue;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i4) {
        this.parent = innerQueuedSubscriberSupport;
        this.prefetch = i4;
        this.limit = i4 - (i4 >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t3) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t3);
        } else {
            this.parent.drain();
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    QueueDrainHelper.request(subscription, this.prefetch);
                    return;
                }
            }
            this.queue = QueueDrainHelper.createQueue(this.prefetch);
            QueueDrainHelper.request(subscription, this.prefetch);
        }
    }

    public SimpleQueue<T> queue() {
        return this.queue;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j4) {
        if (this.fusionMode != 1) {
            long j5 = this.produced + j4;
            if (j5 >= this.limit) {
                this.produced = 0L;
                get().request(j5);
                return;
            }
            this.produced = j5;
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j4 = this.produced + 1;
            if (j4 == this.limit) {
                this.produced = 0L;
                get().request(j4);
                return;
            }
            this.produced = j4;
        }
    }

    public void setDone() {
        this.done = true;
    }
}
