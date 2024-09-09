package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.g;
import rx.internal.util.atomic.f;
import rx.internal.util.unsafe.g0;
import rx.internal.util.unsafe.n0;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements g {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final l<? super T> child;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedValueProducer(l<? super T> lVar) {
        this(lVar, n0.f() ? new g0() : new f());
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            l<? super T> lVar = this.child;
            Queue<Object> queue = this.queue;
            while (!lVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j4 = get();
                long j5 = 0;
                while (j4 != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            lVar.onNext(null);
                        } else {
                            lVar.onNext(poll);
                        }
                        if (lVar.isUnsubscribed()) {
                            return;
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

    public QueuedValueProducer(l<? super T> lVar, Queue<Object> queue) {
        this.child = lVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
