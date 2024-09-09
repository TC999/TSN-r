package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        final long delay;
        final boolean delayError;

        /* renamed from: s  reason: collision with root package name */
        Disposable f55054s;
        final TimeUnit unit;

        /* renamed from: w  reason: collision with root package name */
        final Scheduler.Worker f55055w;

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
                    DelayObserver.this.actual.onComplete();
                } finally {
                    DelayObserver.this.f55055w.dispose();
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class OnError implements Runnable {
            private final Throwable throwable;

            OnError(Throwable th) {
                this.throwable = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.actual.onError(this.throwable);
                } finally {
                    DelayObserver.this.f55055w.dispose();
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class OnNext implements Runnable {

            /* renamed from: t  reason: collision with root package name */
            private final T f55056t;

            OnNext(T t3) {
                this.f55056t = t3;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelayObserver.this.actual.onNext((T) this.f55056t);
            }
        }

        DelayObserver(Observer<? super T> observer, long j4, TimeUnit timeUnit, Scheduler.Worker worker, boolean z3) {
            this.actual = observer;
            this.delay = j4;
            this.unit = timeUnit;
            this.f55055w = worker;
            this.delayError = z3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f55054s.dispose();
            this.f55055w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f55055w.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f55055w.schedule(new OnComplete(), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f55055w.schedule(new OnError(th), this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            this.f55055w.schedule(new OnNext(t3), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f55054s, disposable)) {
                this.f55054s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j4, TimeUnit timeUnit, Scheduler scheduler, boolean z3) {
        super(observableSource);
        this.delay = j4;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DelayObserver(this.delayError ? observer : new SerializedObserver(observer), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
