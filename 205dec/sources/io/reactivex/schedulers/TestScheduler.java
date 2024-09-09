package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class TestScheduler extends Scheduler {
    long counter;
    final Queue<TimedRunnable> queue = new PriorityBlockingQueue(11);
    volatile long time;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        final long count;
        final Runnable run;
        final TestWorker scheduler;
        final long time;

        TimedRunnable(TestWorker testWorker, long j4, Runnable runnable, long j5) {
            this.time = j4;
            this.run = runnable;
            this.scheduler = testWorker;
            this.count = j5;
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.time), this.run.toString());
        }

        @Override // java.lang.Comparable
        public int compareTo(TimedRunnable timedRunnable) {
            long j4 = this.time;
            long j5 = timedRunnable.time;
            if (j4 == j5) {
                return ObjectHelper.compare(this.count, timedRunnable.count);
            }
            return ObjectHelper.compare(j4, j5);
        }
    }

    public void advanceTimeBy(long j4, TimeUnit timeUnit) {
        advanceTimeTo(this.time + timeUnit.toNanos(j4), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j4, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j4));
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    @Override // io.reactivex.Scheduler
    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long j4) {
        while (!this.queue.isEmpty()) {
            TimedRunnable peek = this.queue.peek();
            long j5 = peek.time;
            if (j5 > j4) {
                break;
            }
            if (j5 == 0) {
                j5 = this.time;
            }
            this.time = j5;
            this.queue.remove();
            if (!peek.scheduler.disposed) {
                peek.run.run();
            }
        }
        this.time = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class TestWorker extends Scheduler.Worker {
        volatile boolean disposed;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class QueueRemove implements Runnable {
            final TimedRunnable timedAction;

            QueueRemove(TimedRunnable timedRunnable) {
                this.timedAction = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                TestScheduler.this.queue.remove(this.timedAction);
            }
        }

        TestWorker() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public long now(@NonNull TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j4, @NonNull TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.time + timeUnit.toNanos(j4);
            TestScheduler testScheduler = TestScheduler.this;
            long j5 = testScheduler.counter;
            testScheduler.counter = 1 + j5;
            TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j5);
            TestScheduler.this.queue.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j4 = testScheduler.counter;
            testScheduler.counter = 1 + j4;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0L, runnable, j4);
            TestScheduler.this.queue.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }
    }
}
