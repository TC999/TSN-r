package p640rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.internal.util.atomic.SpscAtomicArrayQueue;
import p640rx.internal.util.unsafe.C16092z;
import p640rx.internal.util.unsafe.UnsafeAccess;

/* renamed from: rx.internal.operators.OnSubscribePublishMulticast */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.InterfaceC15567a<T>, Observer<T>, Subscription {
    static final C15636b<?>[] EMPTY = new C15636b[0];
    static final C15636b<?>[] TERMINATED = new C15636b[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final C15635a<T> parent;
    final int prefetch;
    volatile Producer producer;
    final Queue<T> queue;
    volatile C15636b<T>[] subscribers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.OnSubscribePublishMulticast$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15635a<T> extends Subscriber<T> {

        /* renamed from: a */
        final OnSubscribePublishMulticast<T> f44870a;

        public C15635a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f44870a = onSubscribePublishMulticast;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f44870a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f44870a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f44870a.onNext(t);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f44870a.setProducer(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.OnSubscribePublishMulticast$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15636b<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;

        /* renamed from: a */
        final Subscriber<? super T> f44871a;

        /* renamed from: b */
        final OnSubscribePublishMulticast<T> f44872b;

        /* renamed from: c */
        final AtomicBoolean f44873c = new AtomicBoolean();

        public C15636b(Subscriber<? super T> subscriber, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f44871a = subscriber;
            this.f44872b = onSubscribePublishMulticast;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f44873c.get();
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (j != 0) {
                BackpressureUtils.m1335b(this, j);
                this.f44872b.drain();
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (this.f44873c.compareAndSet(false, true)) {
                this.f44872b.remove(this);
            }
        }
    }

    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i > 0) {
            this.prefetch = i;
            this.delayError = z;
            if (UnsafeAccess.m759f()) {
                this.queue = new C16092z(i);
            } else {
                this.queue = new SpscAtomicArrayQueue(i);
            }
            this.subscribers = (C15636b<T>[]) EMPTY;
            this.parent = new C15635a<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i);
    }

    boolean add(C15636b<T> c15636b) {
        C15636b<T>[] c15636bArr = this.subscribers;
        C15636b<?>[] c15636bArr2 = TERMINATED;
        if (c15636bArr == c15636bArr2) {
            return false;
        }
        synchronized (this) {
            C15636b<T>[] c15636bArr3 = this.subscribers;
            if (c15636bArr3 == c15636bArr2) {
                return false;
            }
            int length = c15636bArr3.length;
            C15636b<T>[] c15636bArr4 = new C15636b[length + 1];
            System.arraycopy(c15636bArr3, 0, c15636bArr4, 0, length);
            c15636bArr4[length] = c15636b;
            this.subscribers = c15636bArr4;
            return true;
        }
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    boolean checkTerminated(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    C15636b<T>[] terminate = terminate();
                    int length = terminate.length;
                    while (i < length) {
                        terminate[i].f44871a.onError(th);
                        i++;
                    }
                    return true;
                } else if (z2) {
                    C15636b<T>[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i < length2) {
                        terminate2[i].f44871a.onCompleted();
                        i++;
                    }
                    return true;
                }
            } else if (z2) {
                C15636b<T>[] terminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = terminate3.length;
                    while (i < length3) {
                        terminate3[i].f44871a.onError(th2);
                        i++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i < length4) {
                        terminate3[i].f44871a.onCompleted();
                        i++;
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
        int i = 0;
        do {
            long j = Long.MAX_VALUE;
            C15636b<T>[] c15636bArr = this.subscribers;
            int length = c15636bArr.length;
            for (C15636b<T> c15636b : c15636bArr) {
                j = Math.min(j, c15636b.get());
            }
            if (length != 0) {
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    T poll = queue.poll();
                    boolean z2 = poll == null;
                    if (checkTerminated(z, z2)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    for (C15636b<T> c15636b2 : c15636bArr) {
                        c15636b2.f44871a.onNext(poll);
                    }
                    j2++;
                }
                if (j2 == j && checkTerminated(this.done, queue.isEmpty())) {
                    return;
                }
                if (j2 != 0) {
                    Producer producer = this.producer;
                    if (producer != null) {
                        producer.request(j2);
                    }
                    for (C15636b<T> c15636b3 : c15636bArr) {
                        BackpressureUtils.m1328i(c15636b3, j2);
                    }
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    void remove(C15636b<T> c15636b) {
        C15636b<?>[] c15636bArr;
        C15636b[] c15636bArr2;
        C15636b<T>[] c15636bArr3 = this.subscribers;
        C15636b<?>[] c15636bArr4 = TERMINATED;
        if (c15636bArr3 == c15636bArr4 || c15636bArr3 == (c15636bArr = EMPTY)) {
            return;
        }
        synchronized (this) {
            C15636b<T>[] c15636bArr5 = this.subscribers;
            if (c15636bArr5 != c15636bArr4 && c15636bArr5 != c15636bArr) {
                int i = -1;
                int length = c15636bArr5.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (c15636bArr5[i2] == c15636b) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    c15636bArr2 = EMPTY;
                } else {
                    C15636b[] c15636bArr6 = new C15636b[length - 1];
                    System.arraycopy(c15636bArr5, 0, c15636bArr6, 0, i);
                    System.arraycopy(c15636bArr5, i + 1, c15636bArr6, i, (length - i) - 1);
                    c15636bArr2 = c15636bArr6;
                }
                this.subscribers = c15636bArr2;
            }
        }
    }

    void setProducer(Producer producer) {
        this.producer = producer;
        producer.request(this.prefetch);
    }

    public Subscriber<T> subscriber() {
        return this.parent;
    }

    C15636b<T>[] terminate() {
        C15636b<T>[] c15636bArr = this.subscribers;
        C15636b<T>[] c15636bArr2 = (C15636b<T>[]) TERMINATED;
        if (c15636bArr != c15636bArr2) {
            synchronized (this) {
                c15636bArr = this.subscribers;
                if (c15636bArr != c15636bArr2) {
                    this.subscribers = c15636bArr2;
                }
            }
        }
        return c15636bArr;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    public void call(Subscriber<? super T> subscriber) {
        C15636b<T> c15636b = new C15636b<>(subscriber, this);
        subscriber.add(c15636b);
        subscriber.setProducer(c15636b);
        if (add(c15636b)) {
            if (c15636b.isUnsubscribed()) {
                remove(c15636b);
                return;
            } else {
                drain();
                return;
            }
        }
        Throwable th = this.error;
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onCompleted();
        }
    }
}
