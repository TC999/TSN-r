package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> accumulator;
    final Callable<R> seedSupplier;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;
        final BiFunction<R, ? super T, R> accumulator;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SimplePlainQueue<R> queue;
        final AtomicLong requested;

        /* renamed from: s  reason: collision with root package name */
        Subscription f54949s;
        R value;

        ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r3, int i4) {
            this.actual = subscriber;
            this.accumulator = biFunction;
            this.value = r3;
            this.prefetch = i4;
            this.limit = i4 - (i4 >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i4);
            this.queue = spscArrayQueue;
            spscArrayQueue.offer(r3);
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.f54949s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.actual;
            SimplePlainQueue<R> simplePlainQueue = this.queue;
            int i4 = this.limit;
            int i5 = this.consumed;
            int i6 = 1;
            do {
                long j4 = this.requested.get();
                long j5 = 0;
                while (j5 != j4) {
                    if (this.cancelled) {
                        simplePlainQueue.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    if (z3 && (th = this.error) != null) {
                        simplePlainQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    Object obj = (R) simplePlainQueue.poll();
                    boolean z4 = obj == null;
                    if (z3 && z4) {
                        subscriber.onComplete();
                        return;
                    } else if (z4) {
                        break;
                    } else {
                        subscriber.onNext(obj);
                        j5++;
                        i5++;
                        if (i5 == i4) {
                            this.f54949s.request(i4);
                            i5 = 0;
                        }
                    }
                }
                if (j5 == j4 && this.done) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        simplePlainQueue.clear();
                        subscriber.onError(th2);
                        return;
                    } else if (simplePlainQueue.isEmpty()) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j5 != 0) {
                    BackpressureHelper.produced(this.requested, j5);
                }
                this.consumed = i5;
                i6 = addAndGet(-i6);
            } while (i6 != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t3) {
            if (this.done) {
                return;
            }
            try {
                R r3 = (R) ObjectHelper.requireNonNull(this.accumulator.apply(this.value, t3), "The accumulator returned a null value");
                this.value = r3;
                this.queue.offer(r3);
                drain();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f54949s.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f54949s, subscription)) {
                this.f54949s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch - 1);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j4) {
            if (SubscriptionHelper.validate(j4)) {
                BackpressureHelper.add(this.requested, j4);
                drain();
            }
        }
    }

    public FlowableScanSeed(Flowable<T> flowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.accumulator = biFunction;
        this.seedSupplier = callable;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            this.source.subscribe((FlowableSubscriber) new ScanSeedSubscriber(subscriber, this.accumulator, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seed supplied is null"), Flowable.bufferSize()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
