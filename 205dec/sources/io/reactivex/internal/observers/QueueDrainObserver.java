package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    protected final Observer<? super V> actual;
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected Throwable error;
    protected final SimplePlainQueue<U> queue;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.actual = observer;
        this.queue = simplePlainQueue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void accept(Observer<? super V> observer, U u3) {
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean enter() {
        return this.wip.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        return this.wip.get() == 0 && this.wip.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void fastPathEmit(U u3, boolean z3, Disposable disposable) {
        Observer<? super V> observer = this.actual;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            accept(observer, u3);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u3);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z3, disposable, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void fastPathOrderedEmit(U u3, boolean z3, Disposable disposable) {
        Observer<? super V> observer = this.actual;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            if (simplePlainQueue.isEmpty()) {
                accept(observer, u3);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u3);
            }
        } else {
            simplePlainQueue.offer(u3);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z3, disposable, this);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final int leave(int i4) {
        return this.wip.addAndGet(i4);
    }
}
