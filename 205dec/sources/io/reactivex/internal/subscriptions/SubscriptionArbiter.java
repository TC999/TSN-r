package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    Subscription actual;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<Subscription> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    final void drainLoop() {
        int i4 = 1;
        Subscription subscription = null;
        long j4 = 0;
        do {
            Subscription subscription2 = this.missedSubscription.get();
            if (subscription2 != null) {
                subscription2 = this.missedSubscription.getAndSet(null);
            }
            long j5 = this.missedRequested.get();
            if (j5 != 0) {
                j5 = this.missedRequested.getAndSet(0L);
            }
            long j6 = this.missedProduced.get();
            if (j6 != 0) {
                j6 = this.missedProduced.getAndSet(0L);
            }
            Subscription subscription3 = this.actual;
            if (this.cancelled) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.actual = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j7 = this.requested;
                if (j7 != Long.MAX_VALUE) {
                    j7 = BackpressureHelper.addCap(j7, j5);
                    if (j7 != Long.MAX_VALUE) {
                        j7 -= j6;
                        if (j7 < 0) {
                            SubscriptionHelper.reportMoreProduced(j7);
                            j7 = 0;
                        }
                    }
                    this.requested = j7;
                }
                if (subscription2 != null) {
                    if (subscription3 != null) {
                        subscription3.cancel();
                    }
                    this.actual = subscription2;
                    if (j7 != 0) {
                        j4 = BackpressureHelper.addCap(j4, j7);
                        subscription = subscription2;
                    }
                } else if (subscription3 != null && j5 != 0) {
                    j4 = BackpressureHelper.addCap(j4, j5);
                    subscription = subscription3;
                }
            }
            i4 = addAndGet(-i4);
        } while (i4 != 0);
        if (j4 != 0) {
            subscription.request(j4);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j4) {
        if (this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j5 = this.requested;
            if (j5 != Long.MAX_VALUE) {
                long j6 = j5 - j4;
                if (j6 < 0) {
                    SubscriptionHelper.reportMoreProduced(j6);
                    j6 = 0;
                }
                this.requested = j6;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            drainLoop();
            return;
        }
        BackpressureHelper.add(this.missedProduced, j4);
        drain();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j4) {
        if (!SubscriptionHelper.validate(j4) || this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j5 = this.requested;
            if (j5 != Long.MAX_VALUE) {
                long addCap = BackpressureHelper.addCap(j5, j4);
                this.requested = addCap;
                if (addCap == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            Subscription subscription = this.actual;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (subscription != null) {
                subscription.request(j4);
                return;
            }
            return;
        }
        BackpressureHelper.add(this.missedRequested, j4);
        drain();
    }

    public final void setSubscription(Subscription subscription) {
        if (this.cancelled) {
            subscription.cancel();
            return;
        }
        ObjectHelper.requireNonNull(subscription, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            Subscription subscription2 = this.actual;
            if (subscription2 != null) {
                subscription2.cancel();
            }
            this.actual = subscription;
            long j4 = this.requested;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (j4 != 0) {
                subscription.request(j4);
                return;
            }
            return;
        }
        Subscription andSet = this.missedSubscription.getAndSet(subscription);
        if (andSet != null) {
            andSet.cancel();
        }
        drain();
    }
}
