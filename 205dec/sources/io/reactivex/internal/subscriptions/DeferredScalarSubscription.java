package io.reactivex.internal.subscriptions;

import io.reactivex.annotations.Nullable;
import org.reactivestreams.Subscriber;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final Subscriber<? super T> actual;
    protected T value;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.actual = subscriber;
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t3) {
        int i4 = get();
        while (i4 != 8) {
            if ((i4 & (-3)) != 0) {
                return;
            }
            if (i4 == 2) {
                lazySet(3);
                Subscriber<? super T> subscriber = this.actual;
                subscriber.onNext(t3);
                if (get() != 4) {
                    subscriber.onComplete();
                    return;
                }
                return;
            }
            this.value = t3;
            if (compareAndSet(0, 1)) {
                return;
            }
            i4 = get();
            if (i4 == 4) {
                this.value = null;
                return;
            }
        }
        this.value = t3;
        lazySet(16);
        Subscriber<? super T> subscriber2 = this.actual;
        subscriber2.onNext(t3);
        if (get() != 4) {
            subscriber2.onComplete();
        }
    }

    public final boolean isCancelled() {
        return get() == 4;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public final T poll() {
        if (get() == 16) {
            lazySet(32);
            T t3 = this.value;
            this.value = null;
            return t3;
        }
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j4) {
        T t3;
        if (SubscriptionHelper.validate(j4)) {
            do {
                int i4 = get();
                if ((i4 & (-2)) != 0) {
                    return;
                }
                if (i4 == 1) {
                    if (!compareAndSet(1, 3) || (t3 = this.value) == null) {
                        return;
                    }
                    this.value = null;
                    Subscriber<? super T> subscriber = this.actual;
                    subscriber.onNext(t3);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int i4) {
        if ((i4 & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final boolean tryCancel() {
        return getAndSet(4) != 4;
    }
}
