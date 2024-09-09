package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean delayError;
    final int prefetch;
    final Scheduler scheduler;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s  reason: collision with root package name */
        Subscription f54934s;
        int sourceMode;
        final Scheduler.Worker worker;

        BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z3, int i4) {
            this.worker = worker;
            this.delayError = z3;
            this.prefetch = i4;
            this.limit = i4 - (i4 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f54934s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        final boolean checkTerminated(boolean z3, boolean z4, Subscriber<?> subscriber) {
            if (this.cancelled) {
                clear();
                return true;
            } else if (z3) {
                if (this.delayError) {
                    if (z4) {
                        Throwable th = this.error;
                        if (th != null) {
                            subscriber.onError(th);
                        } else {
                            subscriber.onComplete();
                        }
                        this.worker.dispose();
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    clear();
                    subscriber.onError(th2);
                    this.worker.dispose();
                    return true;
                } else if (z4) {
                    subscriber.onComplete();
                    this.worker.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t3) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                trySchedule();
                return;
            }
            if (!this.queue.offer(t3)) {
                this.f54934s.cancel();
                this.error = new MissingBackpressureException("Queue is full?!");
                this.done = true;
            }
            trySchedule();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j4) {
            if (SubscriptionHelper.validate(j4)) {
                BackpressureHelper.add(this.requested, j4);
                trySchedule();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i4) {
            if ((i4 & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        abstract void runAsync();

        abstract void runBackfused();

        abstract void runSync();

        final void trySchedule() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.worker.schedule(this);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        final ConditionalSubscriber<? super T> actual;
        long consumed;

        ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z3, int i4) {
            super(worker, z3, i4);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f54934s, subscription)) {
                this.f54934s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j4 = this.consumed + 1;
                if (j4 == this.limit) {
                    this.consumed = 0L;
                    this.f54934s.request(j4);
                } else {
                    this.consumed = j4;
                }
            }
            return poll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            long j4 = this.produced;
            long j5 = this.consumed;
            int i4 = 1;
            while (true) {
                long j6 = this.requested.get();
                while (j4 != j6) {
                    boolean z3 = this.done;
                    try {
                        Object obj = (T) simpleQueue.poll();
                        boolean z4 = obj == null;
                        if (checkTerminated(z3, z4, conditionalSubscriber)) {
                            return;
                        }
                        if (z4) {
                            break;
                        }
                        if (conditionalSubscriber.tryOnNext(obj)) {
                            j4++;
                        }
                        j5++;
                        if (j5 == this.limit) {
                            this.f54934s.request(j5);
                            j5 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f54934s.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j4 == j6 && checkTerminated(this.done, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    return;
                }
                int i5 = get();
                if (i4 == i5) {
                    this.produced = j4;
                    this.consumed = j5;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int i4 = 1;
            while (!this.cancelled) {
                boolean z3 = this.done;
                this.actual.onNext(null);
                if (z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            long j4 = this.produced;
            int i4 = 1;
            while (true) {
                long j5 = this.requested.get();
                while (j4 != j5) {
                    try {
                        Object obj = (T) simpleQueue.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (obj == null) {
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (conditionalSubscriber.tryOnNext(obj)) {
                            j4++;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f54934s.cancel();
                        conditionalSubscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (simpleQueue.isEmpty()) {
                    conditionalSubscriber.onComplete();
                    this.worker.dispose();
                    return;
                }
                int i5 = get();
                if (i4 == i5) {
                    this.produced = j4;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final Subscriber<? super T> actual;

        ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z3, int i4) {
            super(worker, z3, i4);
            this.actual = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f54934s, subscription)) {
                this.f54934s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j4 = this.produced + 1;
                if (j4 == this.limit) {
                    this.produced = 0L;
                    this.f54934s.request(j4);
                } else {
                    this.produced = j4;
                }
            }
            return poll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            Subscriber<? super T> subscriber = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            long j4 = this.produced;
            int i4 = 1;
            while (true) {
                long j5 = this.requested.get();
                while (j4 != j5) {
                    boolean z3 = this.done;
                    try {
                        Object obj = (T) simpleQueue.poll();
                        boolean z4 = obj == null;
                        if (checkTerminated(z3, z4, subscriber)) {
                            return;
                        }
                        if (z4) {
                            break;
                        }
                        subscriber.onNext(obj);
                        j4++;
                        if (j4 == this.limit) {
                            if (j5 != Long.MAX_VALUE) {
                                j5 = this.requested.addAndGet(-j4);
                            }
                            this.f54934s.request(j4);
                            j4 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f54934s.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j4 == j5 && checkTerminated(this.done, simpleQueue.isEmpty(), subscriber)) {
                    return;
                }
                int i5 = get();
                if (i4 == i5) {
                    this.produced = j4;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int i4 = 1;
            while (!this.cancelled) {
                boolean z3 = this.done;
                this.actual.onNext(null);
                if (z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            Subscriber<? super T> subscriber = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            long j4 = this.produced;
            int i4 = 1;
            while (true) {
                long j5 = this.requested.get();
                while (j4 != j5) {
                    try {
                        Object obj = (T) simpleQueue.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (obj == null) {
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        subscriber.onNext(obj);
                        j4++;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f54934s.cancel();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (simpleQueue.isEmpty()) {
                    subscriber.onComplete();
                    this.worker.dispose();
                    return;
                }
                int i5 = get();
                if (i4 == i5) {
                    this.produced = j4;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z3, int i4) {
        super(flowable);
        this.scheduler = scheduler;
        this.delayError = z3;
        this.prefetch = i4;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber) new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, createWorker, this.delayError, this.prefetch));
        } else {
            this.source.subscribe((FlowableSubscriber) new ObserveOnSubscriber(subscriber, createWorker, this.delayError, this.prefetch));
        }
    }
}
