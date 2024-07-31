package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.CompositeException;
import p640rx.functions.FuncN;
import p640rx.internal.util.RxRingBuffer;
import p640rx.internal.util.atomic.SpscLinkedArrayQueue;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeCombineLatest<T, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable<? extends T>[] f46180a;

    /* renamed from: b */
    final Iterable<? extends Observable<? extends T>> f46181b;

    /* renamed from: c */
    final FuncN<? extends R> f46182c;

    /* renamed from: d */
    final int f46183d;

    /* renamed from: e */
    final boolean f46184e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCombineLatest.java */
    /* renamed from: rx.internal.operators.y$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15970a<T, R> extends Subscriber<T> {

        /* renamed from: a */
        final C15971b<T, R> f46185a;

        /* renamed from: b */
        final int f46186b;

        /* renamed from: c */
        boolean f46187c;

        public C15970a(C15971b<T, R> c15971b, int i) {
            this.f46185a = c15971b;
            this.f46186b = i;
            request(c15971b.f46192d);
        }

        /* renamed from: F */
        public void m1000F(long j) {
            request(j);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f46187c) {
                return;
            }
            this.f46187c = true;
            this.f46185a.m994d(null, this.f46186b);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f46187c) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f46185a.m998G(th);
            this.f46187c = true;
            this.f46185a.m994d(null, this.f46186b);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f46187c) {
                return;
            }
            this.f46185a.m994d(NotificationLite.m1043j(t), this.f46186b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCombineLatest.java */
    /* renamed from: rx.internal.operators.y$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15971b<T, R> extends AtomicInteger implements Producer, Subscription {

        /* renamed from: n */
        static final Object f46188n = new Object();
        private static final long serialVersionUID = 8567835998786448817L;

        /* renamed from: a */
        final Subscriber<? super R> f46189a;

        /* renamed from: b */
        final FuncN<? extends R> f46190b;

        /* renamed from: c */
        final C15970a<T, R>[] f46191c;

        /* renamed from: d */
        final int f46192d;

        /* renamed from: e */
        final Object[] f46193e;

        /* renamed from: f */
        final SpscLinkedArrayQueue<Object> f46194f;

        /* renamed from: g */
        final boolean f46195g;

        /* renamed from: h */
        volatile boolean f46196h;

        /* renamed from: i */
        volatile boolean f46197i;

        /* renamed from: j */
        final AtomicLong f46198j;

        /* renamed from: k */
        final AtomicReference<Throwable> f46199k;

        /* renamed from: l */
        int f46200l;

        /* renamed from: m */
        int f46201m;

        public C15971b(Subscriber<? super R> subscriber, FuncN<? extends R> funcN, int i, int i2, boolean z) {
            this.f46189a = subscriber;
            this.f46190b = funcN;
            this.f46192d = i2;
            this.f46195g = z;
            Object[] objArr = new Object[i];
            this.f46193e = objArr;
            Arrays.fill(objArr, f46188n);
            this.f46191c = new C15970a[i];
            this.f46194f = new SpscLinkedArrayQueue<>(i2);
            this.f46198j = new AtomicLong();
            this.f46199k = new AtomicReference<>();
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
            if (r3 == 0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
            if (r13 == Long.MAX_VALUE) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
            p640rx.internal.operators.BackpressureUtils.m1328i(r10, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
            r12 = addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
            if (r12 != 0) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
            return;
         */
        /* renamed from: F */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m999F() {
            /*
                r19 = this;
                r7 = r19
                int r0 = r19.getAndIncrement()
                if (r0 == 0) goto L9
                return
            L9:
                rx.internal.util.atomic.e<java.lang.Object> r8 = r7.f46194f
                rx.l<? super R> r9 = r7.f46189a
                boolean r0 = r7.f46195g
                java.util.concurrent.atomic.AtomicLong r10 = r7.f46198j
                r11 = 1
                r12 = 1
            L13:
                boolean r2 = r7.f46197i
                boolean r3 = r8.isEmpty()
                r1 = r19
                r4 = r9
                r5 = r8
                r6 = r0
                boolean r1 = r1.m995b(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L25
                return
            L25:
                long r13 = r10.get()
                r5 = 0
            L2b:
                int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
                if (r1 == 0) goto L8e
                boolean r2 = r7.f46197i
                java.lang.Object r1 = r8.peek()
                r4 = r1
                rx.internal.operators.y$a r4 = (p640rx.internal.operators.OnSubscribeCombineLatest.C15970a) r4
                if (r4 != 0) goto L3d
                r16 = 1
                goto L40
            L3d:
                r1 = 0
                r16 = 0
            L40:
                r1 = r19
                r3 = r16
                r15 = r4
                r4 = r9
                r17 = r5
                r5 = r8
                r6 = r0
                boolean r1 = r1.m995b(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L51
                return
            L51:
                if (r16 == 0) goto L56
                r3 = r17
                goto L8f
            L56:
                r8.poll()
                java.lang.Object r1 = r8.poll()
                java.lang.Object[] r1 = (java.lang.Object[]) r1
                if (r1 != 0) goto L71
                r7.f46196h = r11
                r7.m996a(r8)
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Broken queue?! Sender received but not the array."
                r0.<init>(r1)
                r9.onError(r0)
                return
            L71:
                rx.functions.y<? extends R> r2 = r7.f46190b     // Catch: java.lang.Throwable -> L84
                java.lang.Object r1 = r2.call(r1)     // Catch: java.lang.Throwable -> L84
                r9.onNext(r1)
                r1 = 1
                r15.m1000F(r1)
                r3 = r17
                long r5 = r3 + r1
                goto L2b
            L84:
                r0 = move-exception
                r7.f46196h = r11
                r7.m996a(r8)
                r9.onError(r0)
                return
            L8e:
                r3 = r5
            L8f:
                r1 = 0
                int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r5 == 0) goto La1
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
                if (r5 == 0) goto La1
                p640rx.internal.operators.BackpressureUtils.m1328i(r10, r3)
            La1:
                int r1 = -r12
                int r12 = r7.addAndGet(r1)
                if (r12 != 0) goto L13
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.operators.OnSubscribeCombineLatest.C15971b.m999F():void");
        }

        /* renamed from: G */
        void m998G(Throwable th) {
            Throwable th2;
            Throwable th3;
            AtomicReference<Throwable> atomicReference = this.f46199k;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    th3 = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                    arrayList.add(th);
                    th3 = new CompositeException(arrayList);
                } else {
                    th3 = new CompositeException(Arrays.asList(th2, th));
                }
            } while (!atomicReference.compareAndSet(th2, th3));
        }

        /* renamed from: H */
        public void m997H(Observable<? extends T>[] observableArr) {
            C15970a<T, R>[] c15970aArr = this.f46191c;
            int length = c15970aArr.length;
            for (int i = 0; i < length; i++) {
                c15970aArr[i] = new C15970a<>(this, i);
            }
            lazySet(0);
            this.f46189a.add(this);
            this.f46189a.setProducer(this);
            for (int i2 = 0; i2 < length && !this.f46196h; i2++) {
                observableArr[i2].m1551q5(c15970aArr[i2]);
            }
        }

        /* renamed from: a */
        void m996a(Queue<?> queue) {
            queue.clear();
            for (C15970a<T, R> c15970a : this.f46191c) {
                c15970a.unsubscribe();
            }
        }

        /* renamed from: b */
        boolean m995b(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue, boolean z3) {
            if (this.f46196h) {
                m996a(queue);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.f46199k.get();
                        if (th != null) {
                            subscriber.onError(th);
                        } else {
                            subscriber.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f46199k.get();
                if (th2 != null) {
                    m996a(queue);
                    subscriber.onError(th2);
                    return true;
                } else if (z2) {
                    subscriber.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        /* renamed from: d */
        void m994d(Object obj, int i) {
            boolean z;
            C15970a<T, R> c15970a = this.f46191c[i];
            synchronized (this) {
                Object[] objArr = this.f46193e;
                int length = objArr.length;
                Object obj2 = objArr[i];
                int i2 = this.f46200l;
                Object obj3 = f46188n;
                if (obj2 == obj3) {
                    i2++;
                    this.f46200l = i2;
                }
                int i3 = this.f46201m;
                if (obj == null) {
                    i3++;
                    this.f46201m = i3;
                } else {
                    objArr[i] = NotificationLite.m1048e(obj);
                }
                boolean z2 = false;
                z = i2 == length;
                if (i3 == length || (obj == null && obj2 == obj3)) {
                    z2 = true;
                }
                if (z2) {
                    this.f46197i = true;
                } else if (obj != null && z) {
                    this.f46194f.m896l(c15970a, this.f46193e.clone());
                } else if (obj == null && this.f46199k.get() != null && (obj2 == obj3 || !this.f46195g)) {
                    this.f46197i = true;
                }
            }
            if (!z && obj != null) {
                c15970a.m1000F(1L);
            } else {
                m999F();
            }
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46196h;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            } else if (j != 0) {
                BackpressureUtils.m1335b(this.f46198j, j);
                m999F();
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (this.f46196h) {
                return;
            }
            this.f46196h = true;
            if (getAndIncrement() == 0) {
                m996a(this.f46194f);
            }
        }
    }

    public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        this(null, iterable, funcN, RxRingBuffer.f46509d, false);
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeCombineLatest(Observable<? extends T>[] observableArr, Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN, int i, boolean z) {
        this.f46180a = observableArr;
        this.f46181b = iterable;
        this.f46182c = funcN;
        this.f46183d = i;
        this.f46184e = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call(p640rx.Subscriber<? super R> r9) {
        /*
            r8 = this;
            rx.e<? extends T>[] r0 = r8.f46180a
            if (r0 != 0) goto L45
            java.lang.Iterable<? extends rx.e<? extends T>> r0 = r8.f46181b
            boolean r1 = r0 instanceof java.util.List
            if (r1 == 0) goto L1a
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            rx.e[] r1 = new p640rx.Observable[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            rx.e[] r0 = (p640rx.Observable[]) r0
            int r1 = r0.length
            goto L46
        L1a:
            r1 = 8
            rx.e[] r1 = new p640rx.Observable[r1]
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
            r3 = 0
        L24:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L42
            java.lang.Object r4 = r0.next()
            rx.e r4 = (p640rx.Observable) r4
            int r5 = r1.length
            if (r3 != r5) goto L3c
            int r5 = r3 >> 2
            int r5 = r5 + r3
            rx.e[] r5 = new p640rx.Observable[r5]
            java.lang.System.arraycopy(r1, r2, r5, r2, r3)
            r1 = r5
        L3c:
            int r5 = r3 + 1
            r1[r3] = r4
            r3 = r5
            goto L24
        L42:
            r0 = r1
            r4 = r3
            goto L47
        L45:
            int r1 = r0.length
        L46:
            r4 = r1
        L47:
            if (r4 != 0) goto L4d
            r9.onCompleted()
            return
        L4d:
            rx.internal.operators.y$b r7 = new rx.internal.operators.y$b
            rx.functions.y<? extends R> r3 = r8.f46182c
            int r5 = r8.f46183d
            boolean r6 = r8.f46184e
            r1 = r7
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r7.m997H(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.operators.OnSubscribeCombineLatest.call(rx.l):void");
    }
}
