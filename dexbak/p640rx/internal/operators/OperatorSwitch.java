package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.CompositeException;
import p640rx.functions.Action0;
import p640rx.internal.util.RxRingBuffer;
import p640rx.internal.util.atomic.SpscLinkedArrayQueue;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.SerialSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.h3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSwitch<T> implements Observable.InterfaceC15568b<T, Observable<? extends T>> {

    /* renamed from: a */
    final boolean f45282a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSwitch.java */
    /* renamed from: rx.internal.operators.h3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15740a {

        /* renamed from: a */
        static final OperatorSwitch<Object> f45283a = new OperatorSwitch<>(false);

        C15740a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSwitch.java */
    /* renamed from: rx.internal.operators.h3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15741b {

        /* renamed from: a */
        static final OperatorSwitch<Object> f45284a = new OperatorSwitch<>(true);

        C15741b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSwitch.java */
    /* renamed from: rx.internal.operators.h3$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15742c<T> extends Subscriber<T> {

        /* renamed from: a */
        private final long f45285a;

        /* renamed from: b */
        private final C15743d<T> f45286b;

        C15742c(long j, C15743d<T> c15743d) {
            this.f45285a = j;
            this.f45286b = c15743d;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45286b.m1223I(this.f45285a);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45286b.m1220L(th, this.f45285a);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45286b.m1221K(t, this);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45286b.m1218N(producer, this.f45285a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSwitch.java */
    /* renamed from: rx.internal.operators.h3$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15743d<T> extends Subscriber<Observable<? extends T>> {

        /* renamed from: m */
        static final Throwable f45287m = new Throwable("Terminal error");

        /* renamed from: a */
        final Subscriber<? super T> f45288a;

        /* renamed from: c */
        final boolean f45290c;

        /* renamed from: f */
        boolean f45293f;

        /* renamed from: g */
        boolean f45294g;

        /* renamed from: h */
        long f45295h;

        /* renamed from: i */
        Producer f45296i;

        /* renamed from: j */
        volatile boolean f45297j;

        /* renamed from: k */
        Throwable f45298k;

        /* renamed from: l */
        boolean f45299l;

        /* renamed from: b */
        final SerialSubscription f45289b = new SerialSubscription();

        /* renamed from: d */
        final AtomicLong f45291d = new AtomicLong();

        /* renamed from: e */
        final SpscLinkedArrayQueue<Object> f45292e = new SpscLinkedArrayQueue<>(RxRingBuffer.f46509d);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorSwitch.java */
        /* renamed from: rx.internal.operators.h3$d$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15744a implements Action0 {
            C15744a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15743d.this.m1224H();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorSwitch.java */
        /* renamed from: rx.internal.operators.h3$d$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15745b implements Producer {
            C15745b() {
            }

            @Override // p640rx.Producer
            public void request(long j) {
                if (j > 0) {
                    C15743d.this.m1225G(j);
                } else if (j >= 0) {
                } else {
                    throw new IllegalArgumentException("n >= 0 expected but it was " + j);
                }
            }
        }

        C15743d(Subscriber<? super T> subscriber, boolean z) {
            this.f45288a = subscriber;
            this.f45290c = z;
        }

        /* renamed from: F */
        protected boolean m1226F(boolean z, boolean z2, Throwable th, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z3) {
            if (this.f45290c) {
                if (z && !z2 && z3) {
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onCompleted();
                    }
                    return true;
                }
                return false;
            } else if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            } else if (z && !z2 && z3) {
                subscriber.onCompleted();
                return true;
            } else {
                return false;
            }
        }

        /* renamed from: G */
        void m1225G(long j) {
            Producer producer;
            synchronized (this) {
                producer = this.f45296i;
                this.f45295h = BackpressureUtils.m1336a(this.f45295h, j);
            }
            if (producer != null) {
                producer.request(j);
            }
            m1222J();
        }

        /* renamed from: H */
        void m1224H() {
            synchronized (this) {
                this.f45296i = null;
            }
        }

        /* renamed from: I */
        void m1223I(long j) {
            synchronized (this) {
                if (this.f45291d.get() != j) {
                    return;
                }
                this.f45299l = false;
                this.f45296i = null;
                m1222J();
            }
        }

        /* renamed from: J */
        void m1222J() {
            Throwable th;
            Throwable th2;
            synchronized (this) {
                if (this.f45293f) {
                    this.f45294g = true;
                    return;
                }
                this.f45293f = true;
                boolean z = this.f45299l;
                long j = this.f45295h;
                Throwable th3 = this.f45298k;
                if (th3 != null && th3 != (th2 = f45287m) && !this.f45290c) {
                    this.f45298k = th2;
                }
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f45292e;
                AtomicLong atomicLong = this.f45291d;
                Subscriber<? super T> subscriber = this.f45288a;
                long j2 = j;
                Throwable th4 = th3;
                boolean z2 = this.f45297j;
                while (true) {
                    long j3 = 0;
                    while (j3 != j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (m1226F(z2, z, th4, spscLinkedArrayQueue, subscriber, isEmpty)) {
                            return;
                        }
                        if (isEmpty) {
                            break;
                        }
                        Object obj = (Object) NotificationLite.m1048e(spscLinkedArrayQueue.poll());
                        if (atomicLong.get() == ((C15742c) spscLinkedArrayQueue.poll()).f45285a) {
                            subscriber.onNext(obj);
                            j3++;
                        }
                    }
                    if (j3 == j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (m1226F(this.f45297j, z, th4, spscLinkedArrayQueue, subscriber, spscLinkedArrayQueue.isEmpty())) {
                            return;
                        }
                    }
                    synchronized (this) {
                        long j4 = this.f45295h;
                        if (j4 != Long.MAX_VALUE) {
                            j4 -= j3;
                            this.f45295h = j4;
                        }
                        j2 = j4;
                        if (!this.f45294g) {
                            this.f45293f = false;
                            return;
                        }
                        this.f45294g = false;
                        z2 = this.f45297j;
                        z = this.f45299l;
                        th4 = this.f45298k;
                        if (th4 != null && th4 != (th = f45287m) && !this.f45290c) {
                            this.f45298k = th;
                        }
                    }
                }
            }
        }

        /* renamed from: K */
        void m1221K(T t, C15742c<T> c15742c) {
            synchronized (this) {
                if (this.f45291d.get() != ((C15742c) c15742c).f45285a) {
                    return;
                }
                this.f45292e.m896l(c15742c, NotificationLite.m1043j(t));
                m1222J();
            }
        }

        /* renamed from: L */
        void m1220L(Throwable th, long j) {
            boolean z;
            synchronized (this) {
                if (this.f45291d.get() == j) {
                    z = m1215Q(th);
                    this.f45299l = false;
                    this.f45296i = null;
                } else {
                    z = true;
                }
            }
            if (z) {
                m1222J();
            } else {
                m1216P(th);
            }
        }

        /* renamed from: M */
        void m1219M() {
            this.f45288a.add(this.f45289b);
            this.f45288a.add(Subscriptions.m346a(new C15744a()));
            this.f45288a.setProducer(new C15745b());
        }

        /* renamed from: N */
        void m1218N(Producer producer, long j) {
            synchronized (this) {
                if (this.f45291d.get() != j) {
                    return;
                }
                long j2 = this.f45295h;
                this.f45296i = producer;
                producer.request(j2);
            }
        }

        @Override // p640rx.Observer
        /* renamed from: O */
        public void onNext(Observable<? extends T> observable) {
            C15742c c15742c;
            long incrementAndGet = this.f45291d.incrementAndGet();
            Subscription m348a = this.f45289b.m348a();
            if (m348a != null) {
                m348a.unsubscribe();
            }
            synchronized (this) {
                c15742c = new C15742c(incrementAndGet, this);
                this.f45299l = true;
                this.f45296i = null;
            }
            this.f45289b.m347b(c15742c);
            observable.m1822I6(c15742c);
        }

        /* renamed from: P */
        void m1216P(Throwable th) {
            RxJavaHooks.m576I(th);
        }

        /* renamed from: Q */
        boolean m1215Q(Throwable th) {
            Throwable th2 = this.f45298k;
            if (th2 == f45287m) {
                return false;
            }
            if (th2 == null) {
                this.f45298k = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                this.f45298k = new CompositeException(arrayList);
            } else {
                this.f45298k = new CompositeException(th2, th);
            }
            return true;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45297j = true;
            m1222J();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            boolean m1215Q;
            synchronized (this) {
                m1215Q = m1215Q(th);
            }
            if (m1215Q) {
                this.f45297j = true;
                m1222J();
                return;
            }
            m1216P(th);
        }
    }

    OperatorSwitch(boolean z) {
        this.f45282a = z;
    }

    /* renamed from: a */
    public static <T> OperatorSwitch<T> m1228a(boolean z) {
        if (z) {
            return (OperatorSwitch<T>) C15741b.f45284a;
        }
        return (OperatorSwitch<T>) C15740a.f45283a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        C15743d c15743d = new C15743d(subscriber, this.f45282a);
        subscriber.add(c15743d);
        c15743d.m1219M();
        return c15743d;
    }
}
