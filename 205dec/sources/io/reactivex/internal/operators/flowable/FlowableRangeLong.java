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
public final class FlowableRangeLong extends Flowable<Long> {
    final long end;
    final long start;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        BaseRangeSubscription(long j4, long j5) {
            this.index = j4;
            this.end = j5;
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
        public final Long poll() {
            long j4 = this.index;
            if (j4 == this.end) {
                return null;
            }
            this.index = 1 + j4;
            return Long.valueOf(j4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Long> actual;

        RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j4, long j5) {
            super(j4, j5);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long j4 = this.end;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.actual;
            for (long j5 = this.index; j5 != j4; j5++) {
                if (this.cancelled) {
                    return;
                }
                conditionalSubscriber.tryOnNext(Long.valueOf(j5));
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long j4) {
            long j5 = this.end;
            long j6 = this.index;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.actual;
            do {
                long j7 = 0;
                while (true) {
                    if (j7 == j4 || j6 == j5) {
                        if (j6 == j5) {
                            if (this.cancelled) {
                                return;
                            }
                            conditionalSubscriber.onComplete();
                            return;
                        }
                        j4 = get();
                        if (j7 == j4) {
                            this.index = j6;
                            j4 = addAndGet(-j7);
                        }
                    } else if (this.cancelled) {
                        return;
                    } else {
                        if (conditionalSubscriber.tryOnNext(Long.valueOf(j6))) {
                            j7++;
                        }
                        j6++;
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
        final Subscriber<? super Long> actual;

        RangeSubscription(Subscriber<? super Long> subscriber, long j4, long j5) {
            super(j4, j5);
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void fastPath() {
            long j4 = this.end;
            Subscriber<? super Long> subscriber = this.actual;
            for (long j5 = this.index; j5 != j4; j5++) {
                if (this.cancelled) {
                    return;
                }
                subscriber.onNext(Long.valueOf(j5));
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void slowPath(long j4) {
            long j5 = this.end;
            long j6 = this.index;
            Subscriber<? super Long> subscriber = this.actual;
            do {
                long j7 = 0;
                while (true) {
                    if (j7 == j4 || j6 == j5) {
                        if (j6 == j5) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        }
                        j4 = get();
                        if (j7 == j4) {
                            this.index = j6;
                            j4 = addAndGet(-j7);
                        }
                    } else if (this.cancelled) {
                        return;
                    } else {
                        subscriber.onNext(Long.valueOf(j6));
                        j7++;
                        j6++;
                    }
                }
            } while (j4 != 0);
        }
    }

    public FlowableRangeLong(long j4, long j5) {
        this.start = j4;
        this.end = j4 + j5;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.start, this.end));
        } else {
            subscriber.onSubscribe(new RangeSubscription(subscriber, this.start, this.end));
        }
    }
}
