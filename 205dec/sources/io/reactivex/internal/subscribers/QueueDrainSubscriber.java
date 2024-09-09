package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    protected final Subscriber<? super V> actual;
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected Throwable error;
    protected final SimplePlainQueue<U> queue;

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.actual = subscriber;
        this.queue = simplePlainQueue;
    }

    public boolean accept(Subscriber<? super V> subscriber, U u3) {
        return false;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean enter() {
        return this.wip.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        return this.wip.get() == 0 && this.wip.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void fastPathEmitMax(U u3, boolean z3, Disposable disposable) {
        Subscriber<? super V> subscriber = this.actual;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            long j4 = this.requested.get();
            if (j4 != 0) {
                if (accept(subscriber, u3) && j4 != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(u3);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z3, disposable, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void fastPathOrderedEmitMax(U u3, boolean z3, Disposable disposable) {
        Subscriber<? super V> subscriber = this.actual;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            long j4 = this.requested.get();
            if (j4 != 0) {
                if (simplePlainQueue.isEmpty()) {
                    if (accept(subscriber, u3) && j4 != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    simplePlainQueue.offer(u3);
                }
            } else {
                this.cancelled = true;
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(u3);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z3, disposable, this);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final int leave(int i4) {
        return this.wip.addAndGet(i4);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long produced(long j4) {
        return this.requested.addAndGet(-j4);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long requested() {
        return this.requested.get();
    }

    public final void requested(long j4) {
        if (SubscriptionHelper.validate(j4)) {
            BackpressureHelper.add(this.requested, j4);
        }
    }
}
