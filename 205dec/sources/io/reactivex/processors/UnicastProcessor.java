package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    final AtomicReference<Subscriber<? super T>> actual;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested;
    final BasicIntQueueSubscription<T> wip;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (UnicastProcessor.this.cancelled) {
                return;
            }
            UnicastProcessor.this.cancelled = true;
            UnicastProcessor.this.doTerminate();
            UnicastProcessor unicastProcessor = UnicastProcessor.this;
            if (unicastProcessor.enableOperatorFusion || unicastProcessor.wip.getAndIncrement() != 0) {
                return;
            }
            UnicastProcessor.this.queue.clear();
            UnicastProcessor.this.actual.lazySet(null);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j4) {
            if (SubscriptionHelper.validate(j4)) {
                BackpressureHelper.add(UnicastProcessor.this.requested, j4);
                UnicastProcessor.this.drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i4) {
            if ((i4 & 2) != 0) {
                UnicastProcessor.this.enableOperatorFusion = true;
                return 2;
            }
            return 0;
        }
    }

    UnicastProcessor(int i4) {
        this(i4, null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(Flowable.bufferSize());
    }

    boolean checkTerminated(boolean z3, boolean z4, boolean z5, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.cancelled) {
            spscLinkedArrayQueue.clear();
            this.actual.lazySet(null);
            return true;
        } else if (z4) {
            if (z3 && this.error != null) {
                spscLinkedArrayQueue.clear();
                this.actual.lazySet(null);
                subscriber.onError(this.error);
                return true;
            } else if (z5) {
                Throwable th = this.error;
                this.actual.lazySet(null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void doTerminate() {
        Runnable runnable = this.onTerminate.get();
        if (runnable == null || !this.onTerminate.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        int i4 = 1;
        Subscriber<? super T> subscriber = this.actual.get();
        while (subscriber == null) {
            i4 = this.wip.addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
            subscriber = this.actual.get();
        }
        if (this.enableOperatorFusion) {
            drainFused(subscriber);
        } else {
            drainRegular(subscriber);
        }
    }

    void drainFused(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i4 = 1;
        boolean z3 = !this.delayError;
        while (!this.cancelled) {
            boolean z4 = this.done;
            if (z3 && z4 && this.error != null) {
                spscLinkedArrayQueue.clear();
                this.actual.lazySet(null);
                subscriber.onError(this.error);
                return;
            }
            subscriber.onNext(null);
            if (z4) {
                this.actual.lazySet(null);
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            i4 = this.wip.addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.actual.lazySet(null);
    }

    void drainRegular(Subscriber<? super T> subscriber) {
        long j4;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean z3 = !this.delayError;
        int i4 = 1;
        do {
            long j5 = this.requested.get();
            long j6 = 0;
            while (true) {
                if (j5 == j6) {
                    j4 = j6;
                    break;
                }
                boolean z4 = this.done;
                T poll = spscLinkedArrayQueue.poll();
                boolean z5 = poll == null;
                j4 = j6;
                if (checkTerminated(z3, z4, z5, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (z5) {
                    break;
                }
                subscriber.onNext(poll);
                j6 = 1 + j4;
            }
            if (j5 == j4 && checkTerminated(z3, this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (j4 != 0 && j5 != Long.MAX_VALUE) {
                this.requested.addAndGet(-j4);
            }
            i4 = this.wip.addAndGet(-i4);
        } while (i4 != 0);
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.actual.get() != null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done || this.cancelled) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (!this.done && !this.cancelled) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            doTerminate();
            drain();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t3) {
        if (this.done || this.cancelled) {
            return;
        }
        if (t3 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.queue.offer(t3);
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (!this.done && !this.cancelled) {
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.cancel();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            subscriber.onSubscribe(this.wip);
            this.actual.set(subscriber);
            if (this.cancelled) {
                this.actual.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
    }

    UnicastProcessor(int i4, Runnable runnable) {
        this(i4, runnable, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i4) {
        return new UnicastProcessor<>(i4);
    }

    UnicastProcessor(int i4, Runnable runnable, boolean z3) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i4, "capacityHint"));
        this.onTerminate = new AtomicReference<>(runnable);
        this.delayError = z3;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription();
        this.requested = new AtomicLong();
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastProcessor<T> create(boolean z3) {
        return new UnicastProcessor<>(Flowable.bufferSize(), null, z3);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i4, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i4, runnable);
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastProcessor<T> create(int i4, Runnable runnable, boolean z3) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i4, runnable, z3);
    }
}
