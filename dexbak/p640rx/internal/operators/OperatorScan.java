package p640rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func0;
import p640rx.functions.Func2;
import p640rx.internal.util.atomic.SpscLinkedAtomicQueue;
import p640rx.internal.util.unsafe.SpscLinkedQueue;
import p640rx.internal.util.unsafe.UnsafeAccess;

/* renamed from: rx.internal.operators.x2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorScan<R, T> implements Observable.InterfaceC15568b<R, T> {

    /* renamed from: c */
    private static final Object f46144c = new Object();

    /* renamed from: a */
    private final Func0<R> f46145a;

    /* renamed from: b */
    final Func2<R, ? super T, R> f46146b;

    /* compiled from: OperatorScan.java */
    /* renamed from: rx.internal.operators.x2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15961a implements Func0<R> {

        /* renamed from: a */
        final /* synthetic */ Object f46147a;

        C15961a(Object obj) {
            this.f46147a = obj;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public R call() {
            return (R) this.f46147a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorScan.java */
    /* renamed from: rx.internal.operators.x2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15962b extends Subscriber<T> {

        /* renamed from: a */
        boolean f46148a;

        /* renamed from: b */
        R f46149b;

        /* renamed from: c */
        final /* synthetic */ Subscriber f46150c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15962b(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f46150c = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46150c.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46150c.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            R r;
            if (!this.f46148a) {
                this.f46148a = true;
                r = t;
            } else {
                try {
                    r = OperatorScan.this.f46146b.call(this.f46149b, t);
                } catch (Throwable th) {
                    C15575a.m1472g(th, this.f46150c, t);
                    return;
                }
            }
            this.f46149b = r;
            this.f46150c.onNext(r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorScan.java */
    /* renamed from: rx.internal.operators.x2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15963c extends Subscriber<T> {

        /* renamed from: a */
        private R f46152a;

        /* renamed from: b */
        final /* synthetic */ Object f46153b;

        /* renamed from: c */
        final /* synthetic */ C15964d f46154c;

        /* JADX WARN: Multi-variable type inference failed */
        C15963c(Object obj, C15964d c15964d) {
            this.f46153b = obj;
            this.f46154c = c15964d;
            this.f46152a = obj;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46154c.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46154c.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                R call = OperatorScan.this.f46146b.call(this.f46152a, t);
                this.f46152a = call;
                this.f46154c.onNext(call);
            } catch (Throwable th) {
                C15575a.m1472g(th, this, t);
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f46154c.setProducer(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorScan.java */
    /* renamed from: rx.internal.operators.x2$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15964d<R> implements Producer, Observer<R> {

        /* renamed from: a */
        final Subscriber<? super R> f46156a;

        /* renamed from: b */
        final Queue<Object> f46157b;

        /* renamed from: c */
        boolean f46158c;

        /* renamed from: d */
        boolean f46159d;

        /* renamed from: e */
        long f46160e;

        /* renamed from: f */
        final AtomicLong f46161f;

        /* renamed from: g */
        volatile Producer f46162g;

        /* renamed from: h */
        volatile boolean f46163h;

        /* renamed from: i */
        Throwable f46164i;

        public C15964d(R r, Subscriber<? super R> subscriber) {
            Queue<Object> spscLinkedAtomicQueue;
            this.f46156a = subscriber;
            if (UnsafeAccess.m759f()) {
                spscLinkedAtomicQueue = new SpscLinkedQueue<>();
            } else {
                spscLinkedAtomicQueue = new SpscLinkedAtomicQueue<>();
            }
            this.f46157b = spscLinkedAtomicQueue;
            spscLinkedAtomicQueue.offer(NotificationLite.m1043j(r));
            this.f46161f = new AtomicLong();
        }

        /* renamed from: F */
        void m1004F() {
            synchronized (this) {
                if (this.f46158c) {
                    this.f46159d = true;
                    return;
                }
                this.f46158c = true;
                m1003G();
            }
        }

        /* renamed from: G */
        void m1003G() {
            Subscriber<? super R> subscriber = this.f46156a;
            Queue<Object> queue = this.f46157b;
            AtomicLong atomicLong = this.f46161f;
            long j = atomicLong.get();
            while (!m1002d(this.f46163h, queue.isEmpty(), subscriber)) {
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.f46163h;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (m1002d(z, z2, subscriber)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    Object obj = (Object) NotificationLite.m1048e(poll);
                    try {
                        subscriber.onNext(obj);
                        j2++;
                    } catch (Throwable th) {
                        C15575a.m1472g(th, subscriber, obj);
                        return;
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    j = BackpressureUtils.m1328i(atomicLong, j2);
                }
                synchronized (this) {
                    if (!this.f46159d) {
                        this.f46158c = false;
                        return;
                    }
                    this.f46159d = false;
                }
            }
        }

        /* renamed from: d */
        boolean m1002d(boolean z, boolean z2, Subscriber<? super R> subscriber) {
            if (subscriber.isUnsubscribed()) {
                return true;
            }
            if (z) {
                Throwable th = this.f46164i;
                if (th != null) {
                    subscriber.onError(th);
                    return true;
                } else if (z2) {
                    subscriber.onCompleted();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46163h = true;
            m1004F();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46164i = th;
            this.f46163h = true;
            m1004F();
        }

        @Override // p640rx.Observer
        public void onNext(R r) {
            this.f46157b.offer(NotificationLite.m1043j(r));
            m1004F();
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            } else if (j != 0) {
                BackpressureUtils.m1335b(this.f46161f, j);
                Producer producer = this.f46162g;
                if (producer == null) {
                    synchronized (this.f46161f) {
                        producer = this.f46162g;
                        if (producer == null) {
                            this.f46160e = BackpressureUtils.m1336a(this.f46160e, j);
                        }
                    }
                }
                if (producer != null) {
                    producer.request(j);
                }
                m1004F();
            }
        }

        public void setProducer(Producer producer) {
            long j;
            producer.getClass();
            synchronized (this.f46161f) {
                if (this.f46162g == null) {
                    j = this.f46160e;
                    if (j != Long.MAX_VALUE) {
                        j--;
                    }
                    this.f46160e = 0L;
                    this.f46162g = producer;
                } else {
                    throw new IllegalStateException("Can't set more than one Producer!");
                }
            }
            if (j > 0) {
                producer.request(j);
            }
            m1004F();
        }
    }

    public OperatorScan(R r, Func2<R, ? super T, R> func2) {
        this((Func0) new C15961a(r), (Func2) func2);
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorScan(Func0<R> func0, Func2<R, ? super T, R> func2) {
        this.f46145a = func0;
        this.f46146b = func2;
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        R call = this.f46145a.call();
        if (call == f46144c) {
            return new C15962b(subscriber, subscriber);
        }
        C15964d c15964d = new C15964d(call, subscriber);
        C15963c c15963c = new C15963c(call, c15964d);
        subscriber.add(c15963c);
        subscriber.setProducer(c15964d);
        return c15963c;
    }

    public OperatorScan(Func2<R, ? super T, R> func2) {
        this(f46144c, func2);
    }
}
