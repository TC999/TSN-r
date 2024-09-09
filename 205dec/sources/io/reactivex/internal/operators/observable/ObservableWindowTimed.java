package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final int bufferSize;
        long count;
        final long maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;

        /* renamed from: s  reason: collision with root package name */
        Disposable f55130s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        UnicastSubject<T> window;
        final Scheduler.Worker worker;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowExactBoundedObserver<?> parent;

            ConsumerIndexHolder(long j4, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.index = j4;
                this.parent = windowExactBoundedObserver;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedObserver<?> windowExactBoundedObserver = this.parent;
                if (!((QueueDrainObserver) windowExactBoundedObserver).cancelled) {
                    ((QueueDrainObserver) windowExactBoundedObserver).queue.offer(this);
                } else {
                    windowExactBoundedObserver.terminated = true;
                    windowExactBoundedObserver.disposeTimer();
                }
                if (windowExactBoundedObserver.enter()) {
                    windowExactBoundedObserver.drainLoop();
                }
            }
        }

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j4, TimeUnit timeUnit, Scheduler scheduler, int i4, long j5, boolean z3) {
            super(observer, new MpscLinkedQueue());
            this.timer = new AtomicReference<>();
            this.timespan = j4;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i4;
            this.maxSize = j5;
            this.restartTimerOnMaxSize = z3;
            if (z3) {
                this.worker = scheduler.createWorker();
            } else {
                this.worker = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        void disposeTimer() {
            DisposableHelper.dispose(this.timer);
            Scheduler.Worker worker = this.worker;
            if (worker != null) {
                worker.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.actual;
            UnicastSubject<T> unicastSubject = this.window;
            int i4 = 1;
            while (!this.terminated) {
                boolean z3 = this.done;
                Object poll = mpscLinkedQueue.poll();
                boolean z4 = poll == null;
                boolean z5 = poll instanceof ConsumerIndexHolder;
                if (z3 && (z4 || z5)) {
                    this.window = null;
                    mpscLinkedQueue.clear();
                    disposeTimer();
                    Throwable th = this.error;
                    if (th != null) {
                        unicastSubject.onError(th);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                } else if (z4) {
                    i4 = leave(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else if (z5) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                    if (this.restartTimerOnMaxSize || this.producerIndex == consumerIndexHolder.index) {
                        unicastSubject.onComplete();
                        this.count = 0L;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
                        this.window = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                    long j4 = this.count + 1;
                    if (j4 >= this.maxSize) {
                        this.producerIndex++;
                        this.count = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
                        this.window = unicastSubject;
                        this.actual.onNext(unicastSubject);
                        if (this.restartTimerOnMaxSize) {
                            Disposable disposable = this.timer.get();
                            disposable.dispose();
                            Scheduler.Worker worker = this.worker;
                            ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.producerIndex, this);
                            long j5 = this.timespan;
                            Disposable schedulePeriodically = worker.schedulePeriodically(consumerIndexHolder2, j5, j5, this.unit);
                            if (!this.timer.compareAndSet(disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.count = j4;
                    }
                }
            }
            this.f55130s.dispose();
            mpscLinkedQueue.clear();
            disposeTimer();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            disposeTimer();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            disposeTimer();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            if (this.terminated) {
                return;
            }
            if (fastEnter()) {
                UnicastSubject<T> unicastSubject = this.window;
                unicastSubject.onNext(t3);
                long j4 = this.count + 1;
                if (j4 >= this.maxSize) {
                    this.producerIndex++;
                    this.count = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                    this.window = create;
                    this.actual.onNext(create);
                    if (this.restartTimerOnMaxSize) {
                        this.timer.get().dispose();
                        Scheduler.Worker worker = this.worker;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                        long j5 = this.timespan;
                        DisposableHelper.replace(this.timer, worker.schedulePeriodically(consumerIndexHolder, j5, j5, this.unit));
                    }
                } else {
                    this.count = j4;
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t3));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Disposable schedulePeriodicallyDirect;
            if (DisposableHelper.validate(this.f55130s, disposable)) {
                this.f55130s = disposable;
                Observer<? super V> observer = this.actual;
                observer.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                this.window = create;
                observer.onNext(create);
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                if (this.restartTimerOnMaxSize) {
                    Scheduler.Worker worker = this.worker;
                    long j4 = this.timespan;
                    schedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j4, j4, this.unit);
                } else {
                    Scheduler scheduler = this.scheduler;
                    long j5 = this.timespan;
                    schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j5, j5, this.unit);
                }
                DisposableHelper.replace(this.timer, schedulePeriodicallyDirect);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        static final Object NEXT = new Object();
        final int bufferSize;

        /* renamed from: s  reason: collision with root package name */
        Disposable f55131s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        UnicastSubject<T> window;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j4, TimeUnit timeUnit, Scheduler scheduler, int i4) {
            super(observer, new MpscLinkedQueue());
            this.timer = new AtomicReference<>();
            this.timespan = j4;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i4;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        void disposeTimer() {
            DisposableHelper.dispose(this.timer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
            r7.window = null;
            r0.clear();
            disposeTimer();
            r0 = r7.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (r0 == null) goto L13;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                r7 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r7.queue
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                io.reactivex.Observer<? super V> r1 = r7.actual
                io.reactivex.subjects.UnicastSubject<T> r2 = r7.window
                r3 = 1
            L9:
                boolean r4 = r7.terminated
                boolean r5 = r7.done
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L19
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.NEXT
                if (r6 != r5) goto L2e
            L19:
                r1 = 0
                r7.window = r1
                r0.clear()
                r7.disposeTimer()
                java.lang.Throwable r0 = r7.error
                if (r0 == 0) goto L2a
                r2.onError(r0)
                goto L2d
            L2a:
                r2.onComplete()
            L2d:
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r7.leave(r3)
                if (r3 != 0) goto L9
                return
            L38:
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.NEXT
                if (r6 != r5) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r7.bufferSize
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.create(r2)
                r7.window = r2
                r1.onNext(r2)
                goto L9
            L4d:
                io.reactivex.disposables.Disposable r4 = r7.f55131s
                r4.dispose()
                goto L9
            L53:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.drainLoop():void");
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            if (this.terminated) {
                return;
            }
            if (fastEnter()) {
                this.window.onNext(t3);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t3));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f55131s, disposable)) {
                this.f55131s = disposable;
                this.window = UnicastSubject.create(this.bufferSize);
                Observer<? super V> observer = this.actual;
                observer.onSubscribe(this);
                observer.onNext(this.window);
                if (this.cancelled) {
                    return;
                }
                Scheduler scheduler = this.scheduler;
                long j4 = this.timespan;
                DisposableHelper.replace(this.timer, scheduler.schedulePeriodicallyDirect(this, j4, j4, this.unit));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.terminated = true;
                disposeTimer();
            }
            this.queue.offer(NEXT);
            if (enter()) {
                drainLoop();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        final int bufferSize;

        /* renamed from: s  reason: collision with root package name */
        Disposable f55132s;
        volatile boolean terminated;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        final List<UnicastSubject<T>> windows;
        final Scheduler.Worker worker;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class CompletionTask implements Runnable {

            /* renamed from: w  reason: collision with root package name */
            private final UnicastSubject<T> f55133w;

            CompletionTask(UnicastSubject<T> unicastSubject) {
                this.f55133w = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowSkipObserver.this.complete(this.f55133w);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class SubjectWork<T> {
            final boolean open;

            /* renamed from: w  reason: collision with root package name */
            final UnicastSubject<T> f55134w;

            SubjectWork(UnicastSubject<T> unicastSubject, boolean z3) {
                this.f55134w = unicastSubject;
                this.open = z3;
            }
        }

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j4, long j5, TimeUnit timeUnit, Scheduler.Worker worker, int i4) {
            super(observer, new MpscLinkedQueue());
            this.timespan = j4;
            this.timeskip = j5;
            this.unit = timeUnit;
            this.worker = worker;
            this.bufferSize = i4;
            this.windows = new LinkedList();
        }

        void complete(UnicastSubject<T> unicastSubject) {
            this.queue.offer(new SubjectWork(unicastSubject, false));
            if (enter()) {
                drainLoop();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        void disposeWorker() {
            this.worker.dispose();
        }

        void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.actual;
            List<UnicastSubject<T>> list = this.windows;
            int i4 = 1;
            while (!this.terminated) {
                boolean z3 = this.done;
                T t3 = (T) mpscLinkedQueue.poll();
                boolean z4 = t3 == null;
                boolean z5 = t3 instanceof SubjectWork;
                if (z3 && (z4 || z5)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastSubject<T> unicastSubject : list) {
                            unicastSubject.onError(th);
                        }
                    } else {
                        for (UnicastSubject<T> unicastSubject2 : list) {
                            unicastSubject2.onComplete();
                        }
                    }
                    disposeWorker();
                    list.clear();
                    return;
                } else if (z4) {
                    i4 = leave(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else if (z5) {
                    SubjectWork subjectWork = (SubjectWork) t3;
                    if (subjectWork.open) {
                        if (!this.cancelled) {
                            UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                            list.add(create);
                            observer.onNext(create);
                            this.worker.schedule(new CompletionTask(create), this.timespan, this.unit);
                        }
                    } else {
                        list.remove(subjectWork.f55134w);
                        subjectWork.f55134w.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.terminated = true;
                        }
                    }
                } else {
                    for (UnicastSubject<T> unicastSubject3 : list) {
                        unicastSubject3.onNext(t3);
                    }
                }
            }
            this.f55132s.dispose();
            disposeWorker();
            mpscLinkedQueue.clear();
            list.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            disposeWorker();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            disposeWorker();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            if (fastEnter()) {
                for (UnicastSubject<T> unicastSubject : this.windows) {
                    unicastSubject.onNext(t3);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t3);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f55132s, disposable)) {
                this.f55132s = disposable;
                this.actual.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                this.windows.add(create);
                this.actual.onNext(create);
                this.worker.schedule(new CompletionTask(create), this.timespan, this.unit);
                Scheduler.Worker worker = this.worker;
                long j4 = this.timeskip;
                worker.schedulePeriodically(this, j4, j4, this.unit);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.create(this.bufferSize), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                drainLoop();
            }
        }
    }

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j4, long j5, TimeUnit timeUnit, Scheduler scheduler, long j6, int i4, boolean z3) {
        super(observableSource);
        this.timespan = j4;
        this.timeskip = j5;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.maxSize = j6;
        this.bufferSize = i4;
        this.restartTimerOnMaxSize = z3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        long j4 = this.timespan;
        long j5 = this.timeskip;
        if (j4 == j5) {
            long j6 = this.maxSize;
            if (j6 == Long.MAX_VALUE) {
                this.source.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.timespan, this.unit, this.scheduler, this.bufferSize));
                return;
            } else {
                this.source.subscribe(new WindowExactBoundedObserver(serializedObserver, j4, this.unit, this.scheduler, this.bufferSize, j6, this.restartTimerOnMaxSize));
                return;
            }
        }
        this.source.subscribe(new WindowSkipObserver(serializedObserver, j4, j5, this.unit, this.scheduler.createWorker(), this.bufferSize));
    }
}
