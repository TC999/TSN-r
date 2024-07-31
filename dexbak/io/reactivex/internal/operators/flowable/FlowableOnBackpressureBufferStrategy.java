package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
    final long bufferSize;
    final Action onOverflow;
    final BackpressureOverflowStrategy strategy;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static /* synthetic */ class C140991 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureOverflowStrategy;

        static {
            int[] iArr = new int[BackpressureOverflowStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureOverflowStrategy = iArr;
            try {
                iArr[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureOverflowStrategy[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;
        final Subscriber<? super T> actual;
        final long bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final Action onOverflow;

        /* renamed from: s */
        Subscription f40461s;
        final BackpressureOverflowStrategy strategy;
        final AtomicLong requested = new AtomicLong();
        final Deque<T> deque = new ArrayDeque();

        OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
            this.actual = subscriber;
            this.onOverflow = action;
            this.strategy = backpressureOverflowStrategy;
            this.bufferSize = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.f40461s.cancel();
            if (getAndIncrement() == 0) {
                clear(this.deque);
            }
        }

        void clear(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        void drain() {
            boolean isEmpty;
            T poll;
            if (getAndIncrement() != 0) {
                return;
            }
            Deque<T> deque = this.deque;
            Subscriber<? super T> subscriber = this.actual;
            int i = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        clear(deque);
                        return;
                    }
                    boolean z = this.done;
                    synchronized (deque) {
                        poll = deque.poll();
                    }
                    boolean z2 = poll == null;
                    if (z) {
                        Throwable th = this.error;
                        if (th != null) {
                            clear(deque);
                            subscriber.onError(th);
                            return;
                        } else if (z2) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        clear(deque);
                        return;
                    }
                    boolean z3 = this.done;
                    synchronized (deque) {
                        isEmpty = deque.isEmpty();
                    }
                    if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            clear(deque);
                            subscriber.onError(th2);
                            return;
                        } else if (isEmpty) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    BackpressureHelper.produced(this.requested, j2);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
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
        public void onNext(T t) {
            boolean z;
            boolean z2;
            if (this.done) {
                return;
            }
            Deque<T> deque = this.deque;
            synchronized (deque) {
                z = false;
                z2 = true;
                if (deque.size() == this.bufferSize) {
                    int i = C140991.$SwitchMap$io$reactivex$BackpressureOverflowStrategy[this.strategy.ordinal()];
                    if (i == 1) {
                        deque.pollLast();
                        deque.offer(t);
                    } else if (i == 2) {
                        deque.poll();
                        deque.offer(t);
                    }
                    z = true;
                } else {
                    deque.offer(t);
                }
                z2 = false;
            }
            if (!z) {
                if (z2) {
                    this.f40461s.cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
                drain();
                return;
            }
            Action action = this.onOverflow;
            if (action != null) {
                try {
                    action.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f40461s.cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f40461s, subscription)) {
                this.f40461s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.bufferSize = j;
        this.onOverflow = action;
        this.strategy = backpressureOverflowStrategy;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new OnBackpressureBufferStrategySubscriber(subscriber, this.onOverflow, this.strategy, this.bufferSize));
    }
}
