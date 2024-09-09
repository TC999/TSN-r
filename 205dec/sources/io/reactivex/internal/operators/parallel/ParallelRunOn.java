package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ParallelRunOn<T> extends ParallelFlowable<T> {
    final int prefetch;
    final Scheduler scheduler;
    final ParallelFlowable<? extends T> source;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SpscArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s  reason: collision with root package name */
        Subscription f55151s;
        final Scheduler.Worker worker;

        BaseRunOnSubscriber(int i4, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            this.prefetch = i4;
            this.queue = spscArrayQueue;
            this.limit = i4 - (i4 >> 2);
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f55151s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t3) {
            if (this.done) {
                return;
            }
            if (!this.queue.offer(t3)) {
                this.f55151s.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
                return;
            }
            schedule();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j4) {
            if (SubscriptionHelper.validate(j4)) {
                BackpressureHelper.add(this.requested, j4);
                schedule();
            }
        }

        final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final ConditionalSubscriber<? super T> actual;

        RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i4, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i4, spscArrayQueue, worker);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f55151s, subscription)) {
                this.f55151s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            Throwable th;
            int i5 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            int i6 = this.limit;
            int i7 = 1;
            while (true) {
                long j4 = this.requested.get();
                long j5 = 0;
                while (j5 != j4) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    if (z3 && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z4 = poll == null;
                    if (z3 && z4) {
                        conditionalSubscriber.onComplete();
                        this.worker.dispose();
                        return;
                    } else if (z4) {
                        break;
                    } else {
                        if (conditionalSubscriber.tryOnNext(poll)) {
                            j5++;
                        }
                        i5++;
                        if (i5 == i6) {
                            i4 = i7;
                            this.f55151s.request(i5);
                            i5 = 0;
                        } else {
                            i4 = i7;
                        }
                        i7 = i4;
                    }
                }
                int i8 = i7;
                if (j5 == j4) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j5 != 0 && j4 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j5);
                }
                int i9 = get();
                if (i9 == i8) {
                    this.consumed = i5;
                    i9 = addAndGet(-i8);
                    if (i9 == 0) {
                        return;
                    }
                }
                i7 = i9;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final Subscriber<? super T> actual;

        RunOnSubscriber(Subscriber<? super T> subscriber, int i4, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i4, spscArrayQueue, worker);
            this.actual = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f55151s, subscription)) {
                this.f55151s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            Throwable th;
            int i5 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            Subscriber<? super T> subscriber = this.actual;
            int i6 = this.limit;
            int i7 = 1;
            while (true) {
                long j4 = this.requested.get();
                long j5 = 0;
                while (j5 != j4) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    if (z3 && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z4 = poll == null;
                    if (z3 && z4) {
                        subscriber.onComplete();
                        this.worker.dispose();
                        return;
                    } else if (z4) {
                        break;
                    } else {
                        subscriber.onNext(poll);
                        j5++;
                        i5++;
                        if (i5 == i6) {
                            i4 = i7;
                            this.f55151s.request(i5);
                            i5 = 0;
                        } else {
                            i4 = i7;
                        }
                        i7 = i4;
                    }
                }
                int i8 = i7;
                if (j5 == j4) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j5 != 0 && j4 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j5);
                }
                int i9 = get();
                if (i9 == i8) {
                    this.consumed = i5;
                    i9 = addAndGet(-i8);
                    if (i9 == 0) {
                        return;
                    }
                }
                i7 = i9;
            }
        }
    }

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int i4) {
        this.source = parallelFlowable;
        this.scheduler = scheduler;
        this.prefetch = i4;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super Object>[] subscriberArr2 = new Subscriber[length];
            int i4 = this.prefetch;
            for (int i5 = 0; i5 < length; i5++) {
                Subscriber<? super T> subscriber = subscriberArr[i5];
                Scheduler.Worker createWorker = this.scheduler.createWorker();
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i4);
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i5] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriber, i4, spscArrayQueue, createWorker);
                } else {
                    subscriberArr2[i5] = new RunOnSubscriber(subscriber, i4, spscArrayQueue, createWorker);
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
