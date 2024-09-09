package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {
    final AtomicBoolean once;
    final CacheState<T> state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class CacheState<T> extends LinkedArrayList implements FlowableSubscriber<T> {
        static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
        static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];
        final AtomicReference<Subscription> connection;
        volatile boolean isConnected;
        final Flowable<T> source;
        boolean sourceDone;
        final AtomicReference<ReplaySubscription<T>[]> subscribers;

        CacheState(Flowable<T> flowable, int i4) {
            super(i4);
            this.connection = new AtomicReference<>();
            this.source = flowable;
            this.subscribers = new AtomicReference<>(EMPTY);
        }

        public void addChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                if (replaySubscriptionArr == TERMINATED) {
                    return;
                }
                int length = replaySubscriptionArr.length;
                replaySubscriptionArr2 = new ReplaySubscription[length + 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
                replaySubscriptionArr2[length] = replaySubscription;
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        }

        public void connect() {
            this.source.subscribe((FlowableSubscriber) this);
            this.isConnected = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.sourceDone) {
                return;
            }
            this.sourceDone = true;
            add(NotificationLite.complete());
            SubscriptionHelper.cancel(this.connection);
            for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                replaySubscription.replay();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th));
                SubscriptionHelper.cancel(this.connection);
                for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                    replaySubscription.replay();
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t3) {
            if (this.sourceDone) {
                return;
            }
            add(NotificationLite.next(t3));
            for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                replaySubscription.replay();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.connection, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void removeChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                int length = replaySubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i4 = -1;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    } else if (replaySubscriptionArr[i5].equals(replaySubscription)) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i4 < 0) {
                    return;
                }
                if (length == 1) {
                    replaySubscriptionArr2 = EMPTY;
                } else {
                    ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                    System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i4);
                    System.arraycopy(replaySubscriptionArr, i4 + 1, replaySubscriptionArr3, i4, (length - i4) - 1);
                    replaySubscriptionArr2 = replaySubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long CANCELLED = -1;
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final AtomicLong requested = new AtomicLong();
        final CacheState<T> state;

        ReplaySubscription(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.requested.getAndSet(-1L) != -1) {
                this.state.removeChild(this);
            }
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.child;
            AtomicLong atomicLong = this.requested;
            int i4 = 1;
            int i5 = 1;
            while (true) {
                long j4 = atomicLong.get();
                if (j4 < 0) {
                    return;
                }
                int size = this.state.size();
                if (size != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.head();
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - i4;
                    int i6 = this.index;
                    int i7 = this.currentIndexInBuffer;
                    int i8 = 0;
                    while (i6 < size && j4 > 0) {
                        if (atomicLong.get() == -1) {
                            return;
                        }
                        if (i7 == length) {
                            objArr = (Object[]) objArr[length];
                            i7 = 0;
                        }
                        if (NotificationLite.accept(objArr[i7], subscriber)) {
                            return;
                        }
                        i7++;
                        i6++;
                        j4--;
                        i8++;
                    }
                    if (atomicLong.get() == -1) {
                        return;
                    }
                    if (j4 == 0) {
                        Object obj = objArr[i7];
                        if (NotificationLite.isComplete(obj)) {
                            subscriber.onComplete();
                            return;
                        } else if (NotificationLite.isError(obj)) {
                            subscriber.onError(NotificationLite.getError(obj));
                            return;
                        }
                    }
                    if (i8 != 0) {
                        BackpressureHelper.producedCancel(atomicLong, i8);
                    }
                    this.index = i6;
                    this.currentIndexInBuffer = i7;
                    this.currentBuffer = objArr;
                }
                i5 = addAndGet(-i5);
                if (i5 == 0) {
                    return;
                }
                i4 = 1;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j4) {
            long j5;
            if (SubscriptionHelper.validate(j4)) {
                do {
                    j5 = this.requested.get();
                    if (j5 == -1) {
                        return;
                    }
                } while (!this.requested.compareAndSet(j5, BackpressureHelper.addCap(j5, j4)));
                replay();
            }
        }
    }

    public FlowableCache(Flowable<T> flowable, int i4) {
        super(flowable);
        this.state = new CacheState<>(flowable, i4);
        this.once = new AtomicBoolean();
    }

    int cachedEventCount() {
        return this.state.size();
    }

    boolean hasSubscribers() {
        return this.state.subscribers.get().length != 0;
    }

    boolean isConnected() {
        return this.state.isConnected;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this.state);
        this.state.addChild(replaySubscription);
        subscriber.onSubscribe(replaySubscription);
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            return;
        }
        this.state.connect();
    }
}
