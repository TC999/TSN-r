package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements e.a<T>, rx.f<T>, rx.m {
    static final b<?>[] EMPTY = new b[0];
    static final b<?>[] TERMINATED = new b[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final a<T> parent;
    final int prefetch;
    volatile rx.g producer;
    final Queue<T> queue;
    volatile b<T>[] subscribers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final OnSubscribePublishMulticast<T> f62301a;

        public a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f62301a = onSubscribePublishMulticast;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62301a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62301a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62301a.onNext(t3);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62301a.setProducer(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends AtomicLong implements rx.g, rx.m {
        private static final long serialVersionUID = 960704844171597367L;

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62302a;

        /* renamed from: b  reason: collision with root package name */
        final OnSubscribePublishMulticast<T> f62303b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicBoolean f62304c = new AtomicBoolean();

        public b(rx.l<? super T> lVar, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f62302a = lVar;
            this.f62303b = onSubscribePublishMulticast;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f62304c.get();
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j4);
            } else if (j4 != 0) {
                rx.internal.operators.a.b(this, j4);
                this.f62303b.drain();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f62304c.compareAndSet(false, true)) {
                this.f62303b.remove(this);
            }
        }
    }

    public OnSubscribePublishMulticast(int i4, boolean z3) {
        if (i4 > 0) {
            this.prefetch = i4;
            this.delayError = z3;
            if (rx.internal.util.unsafe.n0.f()) {
                this.queue = new rx.internal.util.unsafe.z(i4);
            } else {
                this.queue = new rx.internal.util.atomic.d(i4);
            }
            this.subscribers = (b<T>[]) EMPTY;
            this.parent = new a<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i4);
    }

    boolean add(b<T> bVar) {
        b<T>[] bVarArr = this.subscribers;
        b<?>[] bVarArr2 = TERMINATED;
        if (bVarArr == bVarArr2) {
            return false;
        }
        synchronized (this) {
            b<T>[] bVarArr3 = this.subscribers;
            if (bVarArr3 == bVarArr2) {
                return false;
            }
            int length = bVarArr3.length;
            b<T>[] bVarArr4 = new b[length + 1];
            System.arraycopy(bVarArr3, 0, bVarArr4, 0, length);
            bVarArr4[length] = bVar;
            this.subscribers = bVarArr4;
            return true;
        }
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    boolean checkTerminated(boolean z3, boolean z4) {
        int i4 = 0;
        if (z3) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    b<T>[] terminate = terminate();
                    int length = terminate.length;
                    while (i4 < length) {
                        terminate[i4].f62302a.onError(th);
                        i4++;
                    }
                    return true;
                } else if (z4) {
                    b<T>[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i4 < length2) {
                        terminate2[i4].f62302a.onCompleted();
                        i4++;
                    }
                    return true;
                }
            } else if (z4) {
                b<T>[] terminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = terminate3.length;
                    while (i4 < length3) {
                        terminate3[i4].f62302a.onError(th2);
                        i4++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i4 < length4) {
                        terminate3[i4].f62302a.onCompleted();
                        i4++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        Queue<T> queue = this.queue;
        int i4 = 0;
        do {
            long j4 = Long.MAX_VALUE;
            b<T>[] bVarArr = this.subscribers;
            int length = bVarArr.length;
            for (b<T> bVar : bVarArr) {
                j4 = Math.min(j4, bVar.get());
            }
            if (length != 0) {
                long j5 = 0;
                while (j5 != j4) {
                    boolean z3 = this.done;
                    T poll = queue.poll();
                    boolean z4 = poll == null;
                    if (checkTerminated(z3, z4)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    for (b<T> bVar2 : bVarArr) {
                        bVar2.f62302a.onNext(poll);
                    }
                    j5++;
                }
                if (j5 == j4 && checkTerminated(this.done, queue.isEmpty())) {
                    return;
                }
                if (j5 != 0) {
                    rx.g gVar = this.producer;
                    if (gVar != null) {
                        gVar.request(j5);
                    }
                    for (b<T> bVar3 : bVarArr) {
                        rx.internal.operators.a.i(bVar3, j5);
                    }
                }
            }
            i4 = addAndGet(-i4);
        } while (i4 != 0);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
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
        if (!this.queue.offer(t3)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    void remove(b<T> bVar) {
        b<?>[] bVarArr;
        b[] bVarArr2;
        b<T>[] bVarArr3 = this.subscribers;
        b<?>[] bVarArr4 = TERMINATED;
        if (bVarArr3 == bVarArr4 || bVarArr3 == (bVarArr = EMPTY)) {
            return;
        }
        synchronized (this) {
            b<T>[] bVarArr5 = this.subscribers;
            if (bVarArr5 != bVarArr4 && bVarArr5 != bVarArr) {
                int i4 = -1;
                int length = bVarArr5.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    } else if (bVarArr5[i5] == bVar) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i4 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = EMPTY;
                } else {
                    b[] bVarArr6 = new b[length - 1];
                    System.arraycopy(bVarArr5, 0, bVarArr6, 0, i4);
                    System.arraycopy(bVarArr5, i4 + 1, bVarArr6, i4, (length - i4) - 1);
                    bVarArr2 = bVarArr6;
                }
                this.subscribers = bVarArr2;
            }
        }
    }

    void setProducer(rx.g gVar) {
        this.producer = gVar;
        gVar.request(this.prefetch);
    }

    public rx.l<T> subscriber() {
        return this.parent;
    }

    b<T>[] terminate() {
        b<T>[] bVarArr = this.subscribers;
        b<T>[] bVarArr2 = (b<T>[]) TERMINATED;
        if (bVarArr != bVarArr2) {
            synchronized (this) {
                bVarArr = this.subscribers;
                if (bVarArr != bVarArr2) {
                    this.subscribers = bVarArr2;
                }
            }
        }
        return bVarArr;
    }

    @Override // rx.m
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    public void call(rx.l<? super T> lVar) {
        b<T> bVar = new b<>(lVar, this);
        lVar.add(bVar);
        lVar.setProducer(bVar);
        if (add(bVar)) {
            if (bVar.isUnsubscribed()) {
                remove(bVar);
                return;
            } else {
                drain();
                return;
            }
        }
        Throwable th = this.error;
        if (th != null) {
            lVar.onError(th);
        } else {
            lVar.onCompleted();
        }
    }
}
