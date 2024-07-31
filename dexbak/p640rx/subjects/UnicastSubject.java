package p640rx.subjects;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.internal.operators.BackpressureUtils;
import p640rx.internal.operators.NotificationLite;
import p640rx.internal.util.atomic.SpscLinkedAtomicQueue;
import p640rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import p640rx.internal.util.unsafe.SpscLinkedQueue;
import p640rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import p640rx.internal.util.unsafe.UnsafeAccess;

/* renamed from: rx.subjects.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UnicastSubject<T> extends Subject<T, T> {

    /* renamed from: b */
    final C16187a<T> f47072b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnicastSubject.java */
    /* renamed from: rx.subjects.i$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16187a<T> extends AtomicLong implements Producer, Observer<T>, Observable.InterfaceC15567a<T>, Subscription {
        private static final long serialVersionUID = -9044104859202255786L;

        /* renamed from: a */
        final AtomicReference<Subscriber<? super T>> f47073a = new AtomicReference<>();

        /* renamed from: b */
        final Queue<Object> f47074b;

        /* renamed from: c */
        final boolean f47075c;

        /* renamed from: d */
        final AtomicReference<Action0> f47076d;

        /* renamed from: e */
        Throwable f47077e;

        /* renamed from: f */
        volatile boolean f47078f;

        /* renamed from: g */
        boolean f47079g;

        /* renamed from: h */
        boolean f47080h;

        /* renamed from: i */
        volatile boolean f47081i;

        public C16187a(int i, boolean z, Action0 action0) {
            Queue<Object> spscLinkedQueue;
            this.f47076d = action0 != null ? new AtomicReference<>(action0) : null;
            this.f47075c = z;
            if (i > 1) {
                spscLinkedQueue = UnsafeAccess.m759f() ? new SpscUnboundedArrayQueue<>(i) : new SpscUnboundedAtomicArrayQueue<>(i);
            } else {
                spscLinkedQueue = UnsafeAccess.m759f() ? new SpscLinkedQueue<>() : new SpscLinkedAtomicQueue<>();
            }
            this.f47074b = spscLinkedQueue;
        }

        /* renamed from: F */
        void m367F() {
            Action0 action0;
            AtomicReference<Action0> atomicReference = this.f47076d;
            if (atomicReference == null || (action0 = atomicReference.get()) == null || !atomicReference.compareAndSet(action0, null)) {
                return;
            }
            action0.call();
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
            if (r7 == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
            if (r0.isEmpty() == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
            r15.f47081i = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
            r15.f47079g = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return;
         */
        /* renamed from: G */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m366G() {
            /*
                r15 = this;
                monitor-enter(r15)
                boolean r0 = r15.f47079g     // Catch: java.lang.Throwable -> L97
                r1 = 1
                if (r0 == 0) goto La
                r15.f47080h = r1     // Catch: java.lang.Throwable -> L97
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L97
                return
            La:
                r15.f47079g = r1     // Catch: java.lang.Throwable -> L97
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L97
                java.util.Queue<java.lang.Object> r0 = r15.f47074b
                boolean r2 = r15.f47075c
            L11:
                java.util.concurrent.atomic.AtomicReference<rx.l<? super T>> r3 = r15.f47073a
                java.lang.Object r3 = r3.get()
                rx.l r3 = (p640rx.Subscriber) r3
                r4 = 0
                if (r3 == 0) goto L7b
                boolean r5 = r15.f47078f
                boolean r6 = r0.isEmpty()
                boolean r5 = r15.m365d(r5, r6, r2, r3)
                if (r5 == 0) goto L29
                return
            L29:
                long r5 = r15.get()
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 != 0) goto L38
                r7 = 1
                goto L39
            L38:
                r7 = 0
            L39:
                r8 = 0
                r10 = r8
            L3c:
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 == 0) goto L70
                boolean r12 = r15.f47078f
                java.lang.Object r13 = r0.poll()
                if (r13 != 0) goto L4a
                r14 = 1
                goto L4b
            L4a:
                r14 = 0
            L4b:
                boolean r12 = r15.m365d(r12, r14, r2, r3)
                if (r12 == 0) goto L52
                return
            L52:
                if (r14 == 0) goto L55
                goto L70
            L55:
                java.lang.Object r12 = p640rx.internal.operators.NotificationLite.m1048e(r13)
                r3.onNext(r12)     // Catch: java.lang.Throwable -> L61
                r12 = 1
                long r5 = r5 - r12
                long r10 = r10 + r12
                goto L3c
            L61:
                r1 = move-exception
                r0.clear()
                p640rx.exceptions.C15575a.m1474e(r1)
                java.lang.Throwable r0 = p640rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r12)
                r3.onError(r0)
                return
            L70:
                if (r7 != 0) goto L7c
                int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r3 == 0) goto L7c
                long r5 = -r10
                r15.addAndGet(r5)
                goto L7c
            L7b:
                r7 = 0
            L7c:
                monitor-enter(r15)
                boolean r3 = r15.f47080h     // Catch: java.lang.Throwable -> L94
                if (r3 != 0) goto L8f
                if (r7 == 0) goto L8b
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L94
                if (r0 == 0) goto L8b
                r15.f47081i = r1     // Catch: java.lang.Throwable -> L94
            L8b:
                r15.f47079g = r4     // Catch: java.lang.Throwable -> L94
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L94
                return
            L8f:
                r15.f47080h = r4     // Catch: java.lang.Throwable -> L94
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L94
                goto L11
            L94:
                r0 = move-exception
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L94
                throw r0
            L97:
                r0 = move-exception
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L97
                goto L9b
            L9a:
                throw r0
            L9b:
                goto L9a
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.subjects.UnicastSubject.C16187a.m366G():void");
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        /* renamed from: d */
        boolean m365d(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber) {
            if (subscriber.isUnsubscribed()) {
                this.f47074b.clear();
                return true;
            } else if (z) {
                Throwable th = this.f47077e;
                if (th != null && !z3) {
                    this.f47074b.clear();
                    subscriber.onError(th);
                    return true;
                } else if (z2) {
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onCompleted();
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f47078f;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f47078f) {
                return;
            }
            m367F();
            boolean z = true;
            this.f47078f = true;
            if (!this.f47081i) {
                synchronized (this) {
                    if (this.f47081i) {
                        z = false;
                    }
                }
                if (z) {
                    m366G();
                    return;
                }
            }
            this.f47073a.get().onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f47078f) {
                return;
            }
            m367F();
            this.f47077e = th;
            boolean z = true;
            this.f47078f = true;
            if (!this.f47081i) {
                synchronized (this) {
                    if (this.f47081i) {
                        z = false;
                    }
                }
                if (z) {
                    m366G();
                    return;
                }
            }
            this.f47073a.get().onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f47078f) {
                return;
            }
            if (!this.f47081i) {
                boolean z = false;
                synchronized (this) {
                    if (!this.f47081i) {
                        this.f47074b.offer(NotificationLite.m1043j(t));
                        z = true;
                    }
                }
                if (z) {
                    m366G();
                    return;
                }
            }
            Subscriber<? super T> subscriber = this.f47073a.get();
            try {
                subscriber.onNext(t);
            } catch (Throwable th) {
                C15575a.m1472g(th, subscriber, t);
            }
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j > 0) {
                BackpressureUtils.m1335b(this, j);
                m366G();
            } else if (this.f47078f) {
                m366G();
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            m367F();
            this.f47078f = true;
            synchronized (this) {
                if (this.f47079g) {
                    return;
                }
                this.f47079g = true;
                this.f47074b.clear();
            }
        }

        public void call(Subscriber<? super T> subscriber) {
            if (this.f47073a.compareAndSet(null, subscriber)) {
                subscriber.add(this);
                subscriber.setProducer(this);
                return;
            }
            subscriber.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }
    }

    private UnicastSubject(C16187a<T> c16187a) {
        super(c16187a);
        this.f47072b = c16187a;
    }

    /* renamed from: A7 */
    public static <T> UnicastSubject<T> m373A7(int i, Action0 action0, boolean z) {
        return new UnicastSubject<>(new C16187a(i, z, action0));
    }

    /* renamed from: B7 */
    public static <T> UnicastSubject<T> m372B7(boolean z) {
        return new UnicastSubject<>(new C16187a(16, z, null));
    }

    /* renamed from: x7 */
    public static <T> UnicastSubject<T> m370x7() {
        return m369y7(16);
    }

    /* renamed from: y7 */
    public static <T> UnicastSubject<T> m369y7(int i) {
        return new UnicastSubject<>(new C16187a(i, false, null));
    }

    /* renamed from: z7 */
    public static <T> UnicastSubject<T> m368z7(int i, Action0 action0) {
        return new UnicastSubject<>(new C16187a(i, false, action0));
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f47072b.onCompleted();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f47072b.onError(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f47072b.onNext(t);
    }

    @Override // p640rx.subjects.Subject
    /* renamed from: v7 */
    public boolean mo371v7() {
        return this.f47072b.f47073a.get() != null;
    }
}
