package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableFromArray<T> extends Flowable<T> {
    final T[] array;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super T> actual;

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            for (int i4 = this.index; i4 != length; i4++) {
                if (this.cancelled) {
                    return;
                }
                T t3 = tArr[i4];
                if (t3 == null) {
                    conditionalSubscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                conditionalSubscriber.tryOnNext(t3);
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long j4) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i4 = this.index;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 == j4 || i4 == length) {
                        if (i4 == length) {
                            if (this.cancelled) {
                                return;
                            }
                            conditionalSubscriber.onComplete();
                            return;
                        }
                        j4 = get();
                        if (j5 == j4) {
                            this.index = i4;
                            j4 = addAndGet(-j5);
                        }
                    } else if (this.cancelled) {
                        return;
                    } else {
                        T t3 = tArr[i4];
                        if (t3 == null) {
                            conditionalSubscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        if (conditionalSubscriber.tryOnNext(t3)) {
                            j5++;
                        }
                        i4++;
                    }
                }
            } while (j4 != 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super T> actual;

        ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.actual;
            for (int i4 = this.index; i4 != length; i4++) {
                if (this.cancelled) {
                    return;
                }
                T t3 = tArr[i4];
                if (t3 == null) {
                    subscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                subscriber.onNext(t3);
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long j4) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i4 = this.index;
            Subscriber<? super T> subscriber = this.actual;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 == j4 || i4 == length) {
                        if (i4 == length) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        }
                        j4 = get();
                        if (j5 == j4) {
                            this.index = i4;
                            j4 = addAndGet(-j5);
                        }
                    } else if (this.cancelled) {
                        return;
                    } else {
                        T t3 = tArr[i4];
                        if (t3 == null) {
                            subscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        subscriber.onNext(t3);
                        j5++;
                        i4++;
                    }
                }
            } while (j4 != 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.array.length;
        }

        abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            int i4 = this.index;
            T[] tArr = this.array;
            if (i4 == tArr.length) {
                return null;
            }
            this.index = i4 + 1;
            return (T) ObjectHelper.requireNonNull(tArr[i4], "array element is null");
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j4) {
            if (SubscriptionHelper.validate(j4) && BackpressureHelper.add(this, j4) == 0) {
                if (j4 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j4);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i4) {
            return i4 & 1;
        }

        abstract void slowPath(long j4);
    }

    public FlowableFromArray(T[] tArr) {
        this.array = tArr;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.array));
        } else {
            subscriber.onSubscribe(new ArraySubscription(subscriber, this.array));
        }
    }
}
