package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableRange extends Flowable<Integer> {
    final int end;
    final int start;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        BaseRangeSubscription(int i4, int i5) {
            this.index = i4;
            this.end = i5;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.end;
        }

        abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.end;
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

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final Integer poll() {
            int i4 = this.index;
            if (i4 == this.end) {
                return null;
            }
            this.index = i4 + 1;
            return Integer.valueOf(i4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Integer> actual;

        RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i4, int i5) {
            super(i4, i5);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void fastPath() {
            int i4 = this.end;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
            for (int i5 = this.index; i5 != i4; i5++) {
                if (this.cancelled) {
                    return;
                }
                conditionalSubscriber.tryOnNext(Integer.valueOf(i5));
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void slowPath(long j4) {
            int i4 = this.end;
            int i5 = this.index;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 == j4 || i5 == i4) {
                        if (i5 == i4) {
                            if (this.cancelled) {
                                return;
                            }
                            conditionalSubscriber.onComplete();
                            return;
                        }
                        j4 = get();
                        if (j5 == j4) {
                            this.index = i5;
                            j4 = addAndGet(-j5);
                        }
                    } else if (this.cancelled) {
                        return;
                    } else {
                        if (conditionalSubscriber.tryOnNext(Integer.valueOf(i5))) {
                            j5++;
                        }
                        i5++;
                    }
                }
            } while (j4 != 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Integer> actual;

        RangeSubscription(Subscriber<? super Integer> subscriber, int i4, int i5) {
            super(i4, i5);
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void fastPath() {
            int i4 = this.end;
            Subscriber<? super Integer> subscriber = this.actual;
            for (int i5 = this.index; i5 != i4; i5++) {
                if (this.cancelled) {
                    return;
                }
                subscriber.onNext(Integer.valueOf(i5));
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void slowPath(long j4) {
            int i4 = this.end;
            int i5 = this.index;
            Subscriber<? super Integer> subscriber = this.actual;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 == j4 || i5 == i4) {
                        if (i5 == i4) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        }
                        j4 = get();
                        if (j5 == j4) {
                            this.index = i5;
                            j4 = addAndGet(-j5);
                        }
                    } else if (this.cancelled) {
                        return;
                    } else {
                        subscriber.onNext(Integer.valueOf(i5));
                        j5++;
                        i5++;
                    }
                }
            } while (j4 != 0);
        }
    }

    public FlowableRange(int i4, int i5) {
        this.start = i4;
        this.end = i4 + i5;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.start, this.end));
        } else {
            subscriber.onSubscribe(new RangeSubscription(subscriber, this.start, this.end));
        }
    }
}
