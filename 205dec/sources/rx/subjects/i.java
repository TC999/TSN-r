package rx.subjects;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.internal.operators.v;
import rx.internal.util.unsafe.g0;
import rx.internal.util.unsafe.h0;
import rx.internal.util.unsafe.n0;
import rx.l;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: UnicastSubject.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class i<T> extends f<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final a<T> f64341b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: UnicastSubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a<T> extends AtomicLong implements rx.g, rx.f<T>, e.a<T>, m {
        private static final long serialVersionUID = -9044104859202255786L;

        /* renamed from: a  reason: collision with root package name */
        final AtomicReference<l<? super T>> f64342a = new AtomicReference<>();

        /* renamed from: b  reason: collision with root package name */
        final Queue<Object> f64343b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f64344c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<rx.functions.a> f64345d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f64346e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f64347f;

        /* renamed from: g  reason: collision with root package name */
        boolean f64348g;

        /* renamed from: h  reason: collision with root package name */
        boolean f64349h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f64350i;

        public a(int i4, boolean z3, rx.functions.a aVar) {
            Queue<Object> g0Var;
            this.f64345d = aVar != null ? new AtomicReference<>(aVar) : null;
            this.f64344c = z3;
            if (i4 > 1) {
                g0Var = n0.f() ? new h0<>(i4) : new rx.internal.util.atomic.g<>(i4);
            } else {
                g0Var = n0.f() ? new g0<>() : new rx.internal.util.atomic.f<>();
            }
            this.f64343b = g0Var;
        }

        void F() {
            rx.functions.a aVar;
            AtomicReference<rx.functions.a> atomicReference = this.f64345d;
            if (atomicReference == null || (aVar = atomicReference.get()) == null || !atomicReference.compareAndSet(aVar, null)) {
                return;
            }
            aVar.call();
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
            if (r7 == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
            if (r0.isEmpty() == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
            r15.f64350i = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
            r15.f64348g = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void G() {
            /*
                r15 = this;
                monitor-enter(r15)
                boolean r0 = r15.f64348g     // Catch: java.lang.Throwable -> L97
                r1 = 1
                if (r0 == 0) goto La
                r15.f64349h = r1     // Catch: java.lang.Throwable -> L97
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L97
                return
            La:
                r15.f64348g = r1     // Catch: java.lang.Throwable -> L97
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L97
                java.util.Queue<java.lang.Object> r0 = r15.f64343b
                boolean r2 = r15.f64344c
            L11:
                java.util.concurrent.atomic.AtomicReference<rx.l<? super T>> r3 = r15.f64342a
                java.lang.Object r3 = r3.get()
                rx.l r3 = (rx.l) r3
                r4 = 0
                if (r3 == 0) goto L7b
                boolean r5 = r15.f64347f
                boolean r6 = r0.isEmpty()
                boolean r5 = r15.d(r5, r6, r2, r3)
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
                boolean r12 = r15.f64347f
                java.lang.Object r13 = r0.poll()
                if (r13 != 0) goto L4a
                r14 = 1
                goto L4b
            L4a:
                r14 = 0
            L4b:
                boolean r12 = r15.d(r12, r14, r2, r3)
                if (r12 == 0) goto L52
                return
            L52:
                if (r14 == 0) goto L55
                goto L70
            L55:
                java.lang.Object r12 = rx.internal.operators.v.e(r13)
                r3.onNext(r12)     // Catch: java.lang.Throwable -> L61
                r12 = 1
                long r5 = r5 - r12
                long r10 = r10 + r12
                goto L3c
            L61:
                r1 = move-exception
                r0.clear()
                rx.exceptions.a.e(r1)
                java.lang.Throwable r0 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r12)
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
                boolean r3 = r15.f64349h     // Catch: java.lang.Throwable -> L94
                if (r3 != 0) goto L8f
                if (r7 == 0) goto L8b
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L94
                if (r0 == 0) goto L8b
                r15.f64350i = r1     // Catch: java.lang.Throwable -> L94
            L8b:
                r15.f64348g = r4     // Catch: java.lang.Throwable -> L94
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L94
                return
            L8f:
                r15.f64349h = r4     // Catch: java.lang.Throwable -> L94
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
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.i.a.G():void");
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l) ((l) obj));
        }

        boolean d(boolean z3, boolean z4, boolean z5, l<? super T> lVar) {
            if (lVar.isUnsubscribed()) {
                this.f64343b.clear();
                return true;
            } else if (z3) {
                Throwable th = this.f64346e;
                if (th != null && !z5) {
                    this.f64343b.clear();
                    lVar.onError(th);
                    return true;
                } else if (z4) {
                    if (th != null) {
                        lVar.onError(th);
                    } else {
                        lVar.onCompleted();
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f64347f;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f64347f) {
                return;
            }
            F();
            boolean z3 = true;
            this.f64347f = true;
            if (!this.f64350i) {
                synchronized (this) {
                    if (this.f64350i) {
                        z3 = false;
                    }
                }
                if (z3) {
                    G();
                    return;
                }
            }
            this.f64342a.get().onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f64347f) {
                return;
            }
            F();
            this.f64346e = th;
            boolean z3 = true;
            this.f64347f = true;
            if (!this.f64350i) {
                synchronized (this) {
                    if (this.f64350i) {
                        z3 = false;
                    }
                }
                if (z3) {
                    G();
                    return;
                }
            }
            this.f64342a.get().onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f64347f) {
                return;
            }
            if (!this.f64350i) {
                boolean z3 = false;
                synchronized (this) {
                    if (!this.f64350i) {
                        this.f64343b.offer(v.j(t3));
                        z3 = true;
                    }
                }
                if (z3) {
                    G();
                    return;
                }
            }
            l<? super T> lVar = this.f64342a.get();
            try {
                lVar.onNext(t3);
            } catch (Throwable th) {
                rx.exceptions.a.g(th, lVar, t3);
            }
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j4 > 0) {
                rx.internal.operators.a.b(this, j4);
                G();
            } else if (this.f64347f) {
                G();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            F();
            this.f64347f = true;
            synchronized (this) {
                if (this.f64348g) {
                    return;
                }
                this.f64348g = true;
                this.f64343b.clear();
            }
        }

        public void call(l<? super T> lVar) {
            if (this.f64342a.compareAndSet(null, lVar)) {
                lVar.add(this);
                lVar.setProducer(this);
                return;
            }
            lVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }
    }

    private i(a<T> aVar) {
        super(aVar);
        this.f64341b = aVar;
    }

    public static <T> i<T> A7(int i4, rx.functions.a aVar, boolean z3) {
        return new i<>(new a(i4, z3, aVar));
    }

    public static <T> i<T> B7(boolean z3) {
        return new i<>(new a(16, z3, null));
    }

    public static <T> i<T> x7() {
        return y7(16);
    }

    public static <T> i<T> y7(int i4) {
        return new i<>(new a(i4, false, null));
    }

    public static <T> i<T> z7(int i4, rx.functions.a aVar) {
        return new i<>(new a(i4, false, aVar));
    }

    @Override // rx.f
    public void onCompleted() {
        this.f64341b.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f64341b.onError(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f64341b.onNext(t3);
    }

    @Override // rx.subjects.f
    public boolean v7() {
        return this.f64341b.f64342a.get() != null;
    }
}
