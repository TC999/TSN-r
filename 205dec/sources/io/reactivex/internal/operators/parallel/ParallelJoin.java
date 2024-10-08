package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i4) {
            this.parent = joinSubscriptionBase;
            this.prefetch = i4;
            this.limit = i4 - (i4 >> 2);
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue == null) {
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
                this.queue = spscArrayQueue;
                return spscArrayQueue;
            }
            return simplePlainQueue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t3) {
            this.parent.onNext(this, t3);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request(this.prefetch);
            }
        }

        public void request(long j4) {
            long j5 = this.produced + j4;
            if (j5 >= this.limit) {
                this.produced = 0L;
                get().request(j5);
                return;
            }
            this.produced = j5;
        }

        public void requestOne() {
            long j4 = this.produced + 1;
            if (j4 == this.limit) {
                this.produced = 0L;
                get().request(j4);
                return;
            }
            this.produced = j4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> subscriber, int i4, int i5) {
            super(subscriber, i4, i5);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
            if (r13 == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
            if (r15 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
            if (r15 == false) goto L3;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 208
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscription.drainLoop():void");
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t3) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t3);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1L);
                } else if (!joinInnerSubscriber.getQueue().offer(t3)) {
                    cancelAll();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.actual.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.getQueue().offer(t3)) {
                cancelAll();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final JoinInnerSubscriber<T>[] subscribers;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger done = new AtomicInteger();

        JoinSubscriptionBase(Subscriber<? super T> subscriber, int i4, int i5) {
            this.actual = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                joinInnerSubscriberArr[i6] = new JoinInnerSubscriber<>(this, i5);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i4);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }

        void cancelAll() {
            int i4 = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
                if (i4 >= joinInnerSubscriberArr.length) {
                    return;
                }
                joinInnerSubscriberArr[i4].cancel();
                i4++;
            }
        }

        void cleanup() {
            int i4 = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
                if (i4 >= joinInnerSubscriberArr.length) {
                    return;
                }
                joinInnerSubscriberArr[i4].queue = null;
                i4++;
            }
        }

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable th);

        abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t3);

        @Override // org.reactivestreams.Subscription
        public void request(long j4) {
            if (SubscriptionHelper.validate(j4)) {
                BackpressureHelper.add(this.requested, j4);
                drain();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i4, int i5) {
            super(subscriber, i4, i5);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
            if (r13 == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
            if (r15 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
            if (r18.errors.get() == null) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
            r3.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
            if (r15 == false) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 213
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.drainLoop():void");
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t3) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t3);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1L);
                } else if (!joinInnerSubscriber.getQueue().offer(t3)) {
                    joinInnerSubscriber.cancel();
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!joinInnerSubscriber.getQueue().offer(t3) && joinInnerSubscriber.cancel()) {
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i4, boolean z3) {
        this.source = parallelFlowable;
        this.prefetch = i4;
        this.delayErrors = z3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscription;
        if (this.delayErrors) {
            joinSubscription = new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch);
        } else {
            joinSubscription = new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
        }
        subscriber.onSubscribe(joinSubscription);
        this.source.subscribe(joinSubscription.subscribers);
    }
}
