package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    static final Object DISPOSED = new Object();
    static final Object DONE = new Object();
    static final int FUTURE_INDEX = 1;
    static final int PARENT_INDEX = 0;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.actual = runnable;
        lazySet(0, disposableContainer);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        while (true) {
            Object obj4 = get(1);
            if (obj4 == DONE || obj4 == (obj3 = DISPOSED)) {
                break;
            } else if (compareAndSet(1, obj4, obj3)) {
                if (obj4 != null) {
                    ((Future) obj4).cancel(get(2) != Thread.currentThread());
                }
            }
        }
        do {
            obj = get(0);
            if (obj == DONE || obj == (obj2 = DISPOSED) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((DisposableContainer) obj).delete(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Object obj = get(1);
        return obj == DISPOSED || obj == DONE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003f A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r5 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r1 = 2
            r5.lazySet(r1, r0)
            r0 = 0
            r2 = 1
            r3 = 0
            java.lang.Runnable r4 = r5.actual     // Catch: java.lang.Throwable -> L11
            r4.run()     // Catch: java.lang.Throwable -> L11
            goto L15
        L11:
            r4 = move-exception
            io.reactivex.plugins.RxJavaPlugins.onError(r4)     // Catch: java.lang.Throwable -> L40
        L15:
            r5.lazySet(r1, r0)
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r1 = io.reactivex.internal.schedulers.ScheduledRunnable.DISPOSED
            if (r0 == r1) goto L2f
            if (r0 == 0) goto L2f
            java.lang.Object r1 = io.reactivex.internal.schedulers.ScheduledRunnable.DONE
            boolean r1 = r5.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L2f
            io.reactivex.internal.disposables.DisposableContainer r0 = (io.reactivex.internal.disposables.DisposableContainer) r0
            r0.delete(r5)
        L2f:
            java.lang.Object r0 = r5.get(r2)
            java.lang.Object r1 = io.reactivex.internal.schedulers.ScheduledRunnable.DISPOSED
            if (r0 == r1) goto L3f
            java.lang.Object r1 = io.reactivex.internal.schedulers.ScheduledRunnable.DONE
            boolean r0 = r5.compareAndSet(r2, r0, r1)
            if (r0 == 0) goto L2f
        L3f:
            return
        L40:
            r4 = move-exception
            r5.lazySet(r1, r0)
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r1 = io.reactivex.internal.schedulers.ScheduledRunnable.DISPOSED
            if (r0 == r1) goto L5b
            if (r0 == 0) goto L5b
            java.lang.Object r1 = io.reactivex.internal.schedulers.ScheduledRunnable.DONE
            boolean r1 = r5.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L5b
            io.reactivex.internal.disposables.DisposableContainer r0 = (io.reactivex.internal.disposables.DisposableContainer) r0
            r0.delete(r5)
        L5b:
            java.lang.Object r0 = r5.get(r2)
            java.lang.Object r1 = io.reactivex.internal.schedulers.ScheduledRunnable.DISPOSED
            if (r0 == r1) goto L6c
            java.lang.Object r1 = io.reactivex.internal.schedulers.ScheduledRunnable.DONE
            boolean r0 = r5.compareAndSet(r2, r0, r1)
            if (r0 != 0) goto L6c
            goto L5b
        L6c:
            goto L6e
        L6d:
            throw r4
        L6e:
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ScheduledRunnable.run():void");
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == DONE) {
                return;
            }
            if (obj == DISPOSED) {
                future.cancel(get(2) != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}
