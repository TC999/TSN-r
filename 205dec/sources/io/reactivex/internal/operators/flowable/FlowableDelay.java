package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        final long delay;
        final boolean delayError;

        /* renamed from: s  reason: collision with root package name */
        Subscription f54906s;
        final TimeUnit unit;

        /* renamed from: w  reason: collision with root package name */
        final Scheduler.Worker f54907w;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.actual.onComplete();
                } finally {
                    DelaySubscriber.this.f54907w.dispose();
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class OnError implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final Throwable f54908t;

            OnError(Throwable th) {
                this.f54908t = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.actual.onError(this.f54908t);
                } finally {
                    DelaySubscriber.this.f54907w.dispose();
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class OnNext implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final T f54909t;

            OnNext(T t3) {
                this.f54909t = t3;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelaySubscriber.this.actual.onNext((T) this.f54909t);
            }
        }

        DelaySubscriber(Subscriber<? super T> subscriber, long j4, TimeUnit timeUnit, Scheduler.Worker worker, boolean z3) {
            this.actual = subscriber;
            this.delay = j4;
            this.unit = timeUnit;
            this.f54907w = worker;
            this.delayError = z3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f54906s.cancel();
            this.f54907w.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f54907w.schedule(new OnComplete(), this.delay, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f54907w.schedule(new OnError(th), this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t3) {
            this.f54907w.schedule(new OnNext(t3), this.delay, this.unit);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f54906s, subscription)) {
                this.f54906s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j4) {
            this.f54906s.request(j4);
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j4, TimeUnit timeUnit, Scheduler scheduler, boolean z3) {
        super(flowable);
        this.delay = j4;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new DelaySubscriber(this.delayError ? subscriber : new SerializedSubscriber(subscriber), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
