package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FullArbiter<T> extends FullArbiterPad2 implements Subscription {
    static final Subscription INITIAL = new InitialSubscription();
    static final Object REQUEST = new Object();
    final Subscriber<? super T> actual;
    volatile boolean cancelled;
    final SpscLinkedArrayQueue<Object> queue;
    long requested;
    Disposable resource;

    /* renamed from: s  reason: collision with root package name */
    volatile Subscription f55188s = INITIAL;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class InitialSubscription implements Subscription {
        InitialSubscription() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j4) {
        }
    }

    public FullArbiter(Subscriber<? super T> subscriber, Disposable disposable, int i4) {
        this.actual = subscriber;
        this.resource = disposable;
        this.queue = new SpscLinkedArrayQueue<>(i4);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        dispose();
    }

    void dispose() {
        Disposable disposable = this.resource;
        this.resource = null;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        Subscriber<? super T> subscriber = this.actual;
        int i4 = 1;
        while (true) {
            Object poll = spscLinkedArrayQueue.poll();
            if (poll == null) {
                i4 = this.wip.addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
            } else {
                Object poll2 = spscLinkedArrayQueue.poll();
                if (poll == REQUEST) {
                    long andSet = this.missedRequested.getAndSet(0L);
                    if (andSet != 0) {
                        this.requested = BackpressureHelper.addCap(this.requested, andSet);
                        this.f55188s.request(andSet);
                    }
                } else if (poll == this.f55188s) {
                    if (NotificationLite.isSubscription(poll2)) {
                        Subscription subscription = NotificationLite.getSubscription(poll2);
                        if (!this.cancelled) {
                            this.f55188s = subscription;
                            long j4 = this.requested;
                            if (j4 != 0) {
                                subscription.request(j4);
                            }
                        } else {
                            subscription.cancel();
                        }
                    } else if (NotificationLite.isError(poll2)) {
                        spscLinkedArrayQueue.clear();
                        dispose();
                        Throwable error = NotificationLite.getError(poll2);
                        if (!this.cancelled) {
                            this.cancelled = true;
                            subscriber.onError(error);
                        } else {
                            RxJavaPlugins.onError(error);
                        }
                    } else if (NotificationLite.isComplete(poll2)) {
                        spscLinkedArrayQueue.clear();
                        dispose();
                        if (!this.cancelled) {
                            this.cancelled = true;
                            subscriber.onComplete();
                        }
                    } else {
                        long j5 = this.requested;
                        if (j5 != 0) {
                            subscriber.onNext((Object) NotificationLite.getValue(poll2));
                            this.requested = j5 - 1;
                        }
                    }
                }
            }
        }
    }

    public void onComplete(Subscription subscription) {
        this.queue.offer(subscription, NotificationLite.complete());
        drain();
    }

    public void onError(Throwable th, Subscription subscription) {
        if (this.cancelled) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.queue.offer(subscription, NotificationLite.error(th));
        drain();
    }

    public boolean onNext(T t3, Subscription subscription) {
        if (this.cancelled) {
            return false;
        }
        this.queue.offer(subscription, NotificationLite.next(t3));
        drain();
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j4) {
        if (SubscriptionHelper.validate(j4)) {
            BackpressureHelper.add(this.missedRequested, j4);
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Object obj = REQUEST;
            spscLinkedArrayQueue.offer(obj, obj);
            drain();
        }
    }

    public boolean setSubscription(Subscription subscription) {
        if (this.cancelled) {
            if (subscription != null) {
                subscription.cancel();
                return false;
            }
            return false;
        }
        ObjectHelper.requireNonNull(subscription, "s is null");
        this.queue.offer(this.f55188s, NotificationLite.subscription(subscription));
        drain();
        return true;
    }
}
