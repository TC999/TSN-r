package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ObserverFullArbiter;
import io.reactivex.internal.observers.FullArbiterObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {
    static final Disposable NEW_TIMER = new EmptyDisposable();
    final ObservableSource<? extends T> other;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class EmptyDisposable implements Disposable {
        EmptyDisposable() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return true;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class TimeoutTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8387234228317808253L;
        final Observer<? super T> actual;
        volatile boolean done;
        volatile long index;

        /* renamed from: s */
        Disposable f40660s;
        final long timeout;
        final TimeUnit unit;
        final Scheduler.Worker worker;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class TimeoutTask implements Runnable {
            private final long idx;

            TimeoutTask(long j) {
                this.idx = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.idx == TimeoutTimedObserver.this.index) {
                    TimeoutTimedObserver.this.done = true;
                    TimeoutTimedObserver.this.f40660s.dispose();
                    DisposableHelper.dispose(TimeoutTimedObserver.this);
                    TimeoutTimedObserver.this.actual.onError(new TimeoutException());
                    TimeoutTimedObserver.this.worker.dispose();
                }
            }
        }

        TimeoutTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.actual = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f40660s.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            this.actual.onNext(t);
            scheduleTimeout(j);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f40660s, disposable)) {
                this.f40660s = disposable;
                this.actual.onSubscribe(this);
                scheduleTimeout(0L);
            }
        }

        void scheduleTimeout(long j) {
            Disposable disposable = get();
            if (disposable != null) {
                disposable.dispose();
            }
            if (compareAndSet(disposable, ObservableTimeoutTimed.NEW_TIMER)) {
                DisposableHelper.replace(this, this.worker.schedule(new TimeoutTask(j), this.timeout, this.unit));
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class TimeoutTimedOtherObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4619702551964128179L;
        final Observer<? super T> actual;
        final ObserverFullArbiter<T> arbiter;
        volatile boolean done;
        volatile long index;
        final ObservableSource<? extends T> other;

        /* renamed from: s */
        Disposable f40661s;
        final long timeout;
        final TimeUnit unit;
        final Scheduler.Worker worker;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class SubscribeNext implements Runnable {
            private final long idx;

            SubscribeNext(long j) {
                this.idx = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.idx == TimeoutTimedOtherObserver.this.index) {
                    TimeoutTimedOtherObserver.this.done = true;
                    TimeoutTimedOtherObserver.this.f40661s.dispose();
                    DisposableHelper.dispose(TimeoutTimedOtherObserver.this);
                    TimeoutTimedOtherObserver.this.subscribeNext();
                    TimeoutTimedOtherObserver.this.worker.dispose();
                }
            }
        }

        TimeoutTimedOtherObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            this.actual = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker;
            this.other = observableSource;
            this.arbiter = new ObserverFullArbiter<>(observer, this, 8);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f40661s.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.arbiter.onComplete(this.f40661s);
            this.worker.dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.arbiter.onError(th, this.f40661s);
            this.worker.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            if (this.arbiter.onNext(t, this.f40661s)) {
                scheduleTimeout(j);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f40661s, disposable)) {
                this.f40661s = disposable;
                if (this.arbiter.setDisposable(disposable)) {
                    this.actual.onSubscribe(this.arbiter);
                    scheduleTimeout(0L);
                }
            }
        }

        void scheduleTimeout(long j) {
            Disposable disposable = get();
            if (disposable != null) {
                disposable.dispose();
            }
            if (compareAndSet(disposable, ObservableTimeoutTimed.NEW_TIMER)) {
                DisposableHelper.replace(this, this.worker.schedule(new SubscribeNext(j), this.timeout, this.unit));
            }
        }

        void subscribeNext() {
            this.other.subscribe(new FullArbiterObserver(this.arbiter));
        }
    }

    public ObservableTimeoutTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        if (this.other == null) {
            this.source.subscribe(new TimeoutTimedObserver(new SerializedObserver(observer), this.timeout, this.unit, this.scheduler.createWorker()));
        } else {
            this.source.subscribe(new TimeoutTimedOtherObserver(observer, this.timeout, this.unit, this.scheduler.createWorker(), this.other));
        }
    }
}
