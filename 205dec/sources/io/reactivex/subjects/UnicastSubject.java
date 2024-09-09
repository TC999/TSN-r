package io.reactivex.subjects;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class UnicastSubject<T> extends Subject<T> {
    final AtomicReference<Observer<? super T>> actual;
    final boolean delayError;
    volatile boolean disposed;
    volatile boolean done;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final BasicIntQueueDisposable<T> wip;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastSubject.this.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (UnicastSubject.this.disposed) {
                return;
            }
            UnicastSubject.this.disposed = true;
            UnicastSubject.this.doTerminate();
            UnicastSubject.this.actual.lazySet(null);
            if (UnicastSubject.this.wip.getAndIncrement() == 0) {
                UnicastSubject.this.actual.lazySet(null);
                UnicastSubject.this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return UnicastSubject.this.disposed;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastSubject.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            return UnicastSubject.this.queue.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i4) {
            if ((i4 & 2) != 0) {
                UnicastSubject.this.enableOperatorFusion = true;
                return 2;
            }
            return 0;
        }
    }

    UnicastSubject(int i4, boolean z3) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i4, "capacityHint"));
        this.onTerminate = new AtomicReference<>();
        this.delayError = z3;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable();
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(Observable.bufferSize(), true);
    }

    void doTerminate() {
        Runnable runnable = this.onTerminate.get();
        if (runnable == null || !this.onTerminate.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.actual.get();
        int i4 = 1;
        while (observer == null) {
            i4 = this.wip.addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
            observer = this.actual.get();
        }
        if (this.enableOperatorFusion) {
            drainFused(observer);
        } else {
            drainNormal(observer);
        }
    }

    void drainFused(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i4 = 1;
        boolean z3 = !this.delayError;
        while (!this.disposed) {
            boolean z4 = this.done;
            if (z3 && z4 && failedFast(spscLinkedArrayQueue, observer)) {
                return;
            }
            observer.onNext(null);
            if (z4) {
                errorOrComplete(observer);
                return;
            }
            i4 = this.wip.addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
        }
        this.actual.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    void drainNormal(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean z3 = !this.delayError;
        boolean z4 = true;
        int i4 = 1;
        while (!this.disposed) {
            boolean z5 = this.done;
            Object obj = (T) this.queue.poll();
            boolean z6 = obj == null;
            if (z5) {
                if (z3 && z4) {
                    if (failedFast(spscLinkedArrayQueue, observer)) {
                        return;
                    }
                    z4 = false;
                }
                if (z6) {
                    errorOrComplete(observer);
                    return;
                }
            }
            if (z6) {
                i4 = this.wip.addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
            } else {
                observer.onNext(obj);
            }
        }
        this.actual.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    void errorOrComplete(Observer<? super T> observer) {
        this.actual.lazySet(null);
        Throwable th = this.error;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    boolean failedFast(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.error;
        if (th != null) {
            this.actual.lazySet(null);
            simpleQueue.clear();
            observer.onError(th);
            return true;
        }
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.actual.get() != null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done || this.disposed) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (!this.done && !this.disposed) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            doTerminate();
            drain();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t3) {
        if (this.done || this.disposed) {
            return;
        }
        if (t3 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.queue.offer(t3);
        drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.done || this.disposed) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            observer.onSubscribe(this.wip);
            this.actual.lazySet(observer);
            if (this.disposed) {
                this.actual.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i4) {
        return new UnicastSubject<>(i4, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i4, Runnable runnable) {
        return new UnicastSubject<>(i4, runnable, true);
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastSubject<T> create(int i4, Runnable runnable, boolean z3) {
        return new UnicastSubject<>(i4, runnable, z3);
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastSubject<T> create(boolean z3) {
        return new UnicastSubject<>(Observable.bufferSize(), z3);
    }

    UnicastSubject(int i4, Runnable runnable) {
        this(i4, runnable, true);
    }

    UnicastSubject(int i4, Runnable runnable, boolean z3) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i4, "capacityHint"));
        this.onTerminate = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.delayError = z3;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable();
    }
}
