package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.f;
import rx.g;
import rx.internal.util.unsafe.g0;
import rx.internal.util.unsafe.n0;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class QueuedProducer<T> extends AtomicLong implements g, f<T> {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final l<? super T> child;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedProducer(l<? super T> lVar) {
        this(lVar, n0.f() ? new g0() : new rx.internal.util.atomic.f());
    }

    private boolean checkTerminated(boolean z3, boolean z4) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (z3) {
            Throwable th = this.error;
            if (th != null) {
                this.queue.clear();
                this.child.onError(th);
                return true;
            } else if (z4) {
                this.child.onCompleted();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void drain() {
        if (this.wip.getAndIncrement() == 0) {
            l<? super T> lVar = this.child;
            Queue<Object> queue = this.queue;
            while (!checkTerminated(this.done, queue.isEmpty())) {
                this.wip.lazySet(1);
                long j4 = get();
                long j5 = 0;
                while (j4 != 0) {
                    boolean z3 = this.done;
                    Object poll = queue.poll();
                    if (checkTerminated(z3, poll == null)) {
                        return;
                    }
                    if (poll == null) {
                        break;
                    }
                    try {
                        if (poll == NULL_SENTINEL) {
                            lVar.onNext(null);
                        } else {
                            lVar.onNext(poll);
                        }
                        j4--;
                        j5++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        rx.exceptions.a.g(th, lVar, poll);
                        return;
                    }
                }
                if (j5 != 0 && get() != Long.MAX_VALUE) {
                    addAndGet(-j5);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public boolean offer(T t3) {
        if (t3 == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t3)) {
            return false;
        }
        drain();
        return true;
    }

    @Override // rx.f
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.f
    public void onNext(T t3) {
        if (offer(t3)) {
            return;
        }
        onError(new MissingBackpressureException());
    }

    @Override // rx.g
    public void request(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j4 > 0) {
            rx.internal.operators.a.b(this, j4);
            drain();
        }
    }

    public QueuedProducer(l<? super T> lVar, Queue<Object> queue) {
        this.child = lVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
