package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    final int parallelism;
    final int prefetch;
    final Publisher<? extends T> source;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        SimpleQueue<T> queue;
        final AtomicLongArray requests;

        /* renamed from: s  reason: collision with root package name */
        Subscription f55143s;
        int sourceMode;
        final AtomicInteger subscriberCount = new AtomicInteger();
        final Subscriber<? super T>[] subscribers;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class RailSubscription implements Subscription {

            /* renamed from: j  reason: collision with root package name */
            final int f55144j;

            /* renamed from: m  reason: collision with root package name */
            final int f55145m;

            RailSubscription(int i4, int i5) {
                this.f55144j = i4;
                this.f55145m = i5;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                if (ParallelDispatcher.this.requests.compareAndSet(this.f55144j + this.f55145m, 0L, 1L)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i4 = this.f55145m;
                    parallelDispatcher.cancel(i4 + i4);
                }
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j4) {
                long j5;
                if (SubscriptionHelper.validate(j4)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.requests;
                    do {
                        j5 = atomicLongArray.get(this.f55144j);
                        if (j5 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f55144j, j5, BackpressureHelper.addCap(j5, j4)));
                    if (ParallelDispatcher.this.subscriberCount.get() == this.f55145m) {
                        ParallelDispatcher.this.drain();
                    }
                }
            }
        }

        ParallelDispatcher(Subscriber<? super T>[] subscriberArr, int i4) {
            this.subscribers = subscriberArr;
            this.prefetch = i4;
            this.limit = i4 - (i4 >> 2);
            int length = subscriberArr.length;
            int i5 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i5 + 1);
            this.requests = atomicLongArray;
            atomicLongArray.lazySet(i5, length);
            this.emissions = new long[length];
        }

        void cancel(int i4) {
            if (this.requests.decrementAndGet(i4) == 0) {
                this.cancelled = true;
                this.f55143s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.sourceMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }

        void drainAsync() {
            Throwable th;
            SimpleQueue<T> simpleQueue = this.queue;
            Subscriber<? super T>[] subscriberArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i4 = this.index;
            int i5 = this.produced;
            int i6 = 1;
            while (true) {
                int i7 = 0;
                int i8 = 0;
                while (!this.cancelled) {
                    boolean z3 = this.done;
                    if (z3 && (th = this.error) != null) {
                        simpleQueue.clear();
                        int length2 = subscriberArr.length;
                        while (i7 < length2) {
                            subscriberArr[i7].onError(th);
                            i7++;
                        }
                        return;
                    }
                    boolean isEmpty = simpleQueue.isEmpty();
                    if (z3 && isEmpty) {
                        int length3 = subscriberArr.length;
                        while (i7 < length3) {
                            subscriberArr[i7].onComplete();
                            i7++;
                        }
                        return;
                    }
                    if (!isEmpty) {
                        long j4 = atomicLongArray.get(i4);
                        long j5 = jArr[i4];
                        if (j4 == j5 || atomicLongArray.get(length + i4) != 0) {
                            i8++;
                        } else {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll != null) {
                                    subscriberArr[i4].onNext(poll);
                                    jArr[i4] = j5 + 1;
                                    i5++;
                                    if (i5 == this.limit) {
                                        this.f55143s.request(i5);
                                        i5 = 0;
                                    }
                                    i8 = 0;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f55143s.cancel();
                                int length4 = subscriberArr.length;
                                while (i7 < length4) {
                                    subscriberArr[i7].onError(th2);
                                    i7++;
                                }
                                return;
                            }
                        }
                        i4++;
                        if (i4 == length) {
                            i4 = 0;
                            continue;
                        }
                        if (i8 == length) {
                        }
                    }
                    int i9 = get();
                    if (i9 == i6) {
                        this.index = i4;
                        this.produced = i5;
                        i6 = addAndGet(-i6);
                        if (i6 == 0) {
                            return;
                        }
                    } else {
                        i6 = i9;
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        void drainSync() {
            SimpleQueue<T> simpleQueue = this.queue;
            Subscriber<? super T>[] subscriberArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i4 = this.index;
            int i5 = 1;
            while (true) {
                int i6 = 0;
                int i7 = 0;
                while (!this.cancelled) {
                    if (simpleQueue.isEmpty()) {
                        int length2 = subscriberArr.length;
                        while (i6 < length2) {
                            subscriberArr[i6].onComplete();
                            i6++;
                        }
                        return;
                    }
                    long j4 = atomicLongArray.get(i4);
                    long j5 = jArr[i4];
                    if (j4 == j5 || atomicLongArray.get(length + i4) != 0) {
                        i7++;
                    } else {
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                int length3 = subscriberArr.length;
                                while (i6 < length3) {
                                    subscriberArr[i6].onComplete();
                                    i6++;
                                }
                                return;
                            }
                            subscriberArr[i4].onNext(poll);
                            jArr[i4] = j5 + 1;
                            i7 = 0;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.f55143s.cancel();
                            int length4 = subscriberArr.length;
                            while (i6 < length4) {
                                subscriberArr[i6].onError(th);
                                i6++;
                            }
                            return;
                        }
                    }
                    i4++;
                    if (i4 == length) {
                        i4 = 0;
                        continue;
                    }
                    if (i7 == length) {
                        int i8 = get();
                        if (i8 == i5) {
                            this.index = i4;
                            i5 = addAndGet(-i5);
                            if (i5 == 0) {
                                return;
                            }
                        } else {
                            i5 = i8;
                        }
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t3) {
            if (this.sourceMode == 0 && !this.queue.offer(t3)) {
                this.f55143s.cancel();
                onError(new MissingBackpressureException("Queue is full?"));
                return;
            }
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f55143s, subscription)) {
                this.f55143s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        setupSubscribers();
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                setupSubscribers();
                subscription.request(this.prefetch);
            }
        }

        void setupSubscribers() {
            Subscriber<? super T>[] subscriberArr = this.subscribers;
            int length = subscriberArr.length;
            int i4 = 0;
            while (i4 < length && !this.cancelled) {
                int i5 = i4 + 1;
                this.subscriberCount.lazySet(i5);
                subscriberArr[i4].onSubscribe(new RailSubscription(i4, length));
                i4 = i5;
            }
        }
    }

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i4, int i5) {
        this.source = publisher;
        this.parallelism = i4;
        this.prefetch = i5;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.parallelism;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            this.source.subscribe(new ParallelDispatcher(subscriberArr, this.prefetch));
        }
    }
}
