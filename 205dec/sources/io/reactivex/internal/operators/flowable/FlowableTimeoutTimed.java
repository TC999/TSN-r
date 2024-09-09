package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscribers.FullArbiterSubscriber;
import io.reactivex.internal.subscriptions.FullArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    static final Disposable NEW_TIMER = new EmptyDispose();
    final Publisher<? extends T> other;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class EmptyDispose implements Disposable {
        EmptyDispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class TimeoutTimedOtherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final Subscriber<? super T> actual;
        final FullArbiter<T> arbiter;
        volatile boolean done;
        volatile long index;
        final Publisher<? extends T> other;

        /* renamed from: s  reason: collision with root package name */
        Subscription f54977s;
        final long timeout;
        Disposable timer;
        final TimeUnit unit;
        final Scheduler.Worker worker;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class TimeoutTask implements Runnable {
            private final long idx;

            TimeoutTask(long j4) {
                this.idx = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.idx == TimeoutTimedOtherSubscriber.this.index) {
                    TimeoutTimedOtherSubscriber.this.done = true;
                    TimeoutTimedOtherSubscriber.this.f54977s.cancel();
                    TimeoutTimedOtherSubscriber.this.worker.dispose();
                    TimeoutTimedOtherSubscriber.this.subscribeNext();
                }
            }
        }

        TimeoutTimedOtherSubscriber(Subscriber<? super T> subscriber, long j4, TimeUnit timeUnit, Scheduler.Worker worker, Publisher<? extends T> publisher) {
            this.actual = subscriber;
            this.timeout = j4;
            this.unit = timeUnit;
            this.worker = worker;
            this.other = publisher;
            this.arbiter = new FullArbiter<>(subscriber, this, 8);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f54977s.cancel();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.arbiter.onComplete(this.f54977s);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.arbiter.onError(th, this.f54977s);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t3) {
            if (this.done) {
                return;
            }
            long j4 = this.index + 1;
            this.index = j4;
            if (this.arbiter.onNext(t3, this.f54977s)) {
                scheduleTimeout(j4);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f54977s, subscription)) {
                this.f54977s = subscription;
                if (this.arbiter.setSubscription(subscription)) {
                    this.actual.onSubscribe(this.arbiter);
                    scheduleTimeout(0L);
                }
            }
        }

        void scheduleTimeout(long j4) {
            Disposable disposable = this.timer;
            if (disposable != null) {
                disposable.dispose();
            }
            this.timer = this.worker.schedule(new TimeoutTask(j4), this.timeout, this.unit);
        }

        void subscribeNext() {
            this.other.subscribe(new FullArbiterSubscriber(this.arbiter));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class TimeoutTimedSubscriber<T> implements FlowableSubscriber<T>, Disposable, Subscription {
        final Subscriber<? super T> actual;
        volatile boolean done;
        volatile long index;

        /* renamed from: s  reason: collision with root package name */
        Subscription f54978s;
        final long timeout;
        Disposable timer;
        final TimeUnit unit;
        final Scheduler.Worker worker;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class TimeoutTask implements Runnable {
            private final long idx;

            TimeoutTask(long j4) {
                this.idx = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.idx == TimeoutTimedSubscriber.this.index) {
                    TimeoutTimedSubscriber.this.done = true;
                    TimeoutTimedSubscriber.this.dispose();
                    TimeoutTimedSubscriber.this.actual.onError(new TimeoutException());
                }
            }
        }

        TimeoutTimedSubscriber(Subscriber<? super T> subscriber, long j4, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.actual = subscriber;
            this.timeout = j4;
            this.unit = timeUnit;
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f54978s.cancel();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t3) {
            if (this.done) {
                return;
            }
            long j4 = this.index + 1;
            this.index = j4;
            this.actual.onNext(t3);
            scheduleTimeout(j4);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f54978s, subscription)) {
                this.f54978s = subscription;
                this.actual.onSubscribe(this);
                scheduleTimeout(0L);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j4) {
            this.f54978s.request(j4);
        }

        void scheduleTimeout(long j4) {
            Disposable disposable = this.timer;
            if (disposable != null) {
                disposable.dispose();
            }
            this.timer = this.worker.schedule(new TimeoutTask(j4), this.timeout, this.unit);
        }
    }

    public FlowableTimeoutTimed(Flowable<T> flowable, long j4, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.timeout = j4;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = publisher;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.other == null) {
            this.source.subscribe((FlowableSubscriber) new TimeoutTimedSubscriber(new SerializedSubscriber(subscriber), this.timeout, this.unit, this.scheduler.createWorker()));
        } else {
            this.source.subscribe((FlowableSubscriber) new TimeoutTimedOtherSubscriber(subscriber, this.timeout, this.unit, this.scheduler.createWorker(), this.other));
        }
    }
}
