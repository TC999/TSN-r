package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.CompositeException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeCombineLatest.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y<T, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends T>[] f63611a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends rx.e<? extends T>> f63612b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.y<? extends R> f63613c;

    /* renamed from: d  reason: collision with root package name */
    final int f63614d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f63615e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCombineLatest.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final b<T, R> f63616a;

        /* renamed from: b  reason: collision with root package name */
        final int f63617b;

        /* renamed from: c  reason: collision with root package name */
        boolean f63618c;

        public a(b<T, R> bVar, int i4) {
            this.f63616a = bVar;
            this.f63617b = i4;
            request(bVar.f63623d);
        }

        public void g(long j4) {
            request(j4);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63618c) {
                return;
            }
            this.f63618c = true;
            this.f63616a.c(null, this.f63617b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63618c) {
                rx.plugins.c.I(th);
                return;
            }
            this.f63616a.g(th);
            this.f63618c = true;
            this.f63616a.c(null, this.f63617b);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63618c) {
                return;
            }
            this.f63616a.c(v.j(t3), this.f63617b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCombineLatest.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T, R> extends AtomicInteger implements rx.g, rx.m {

        /* renamed from: n  reason: collision with root package name */
        static final Object f63619n = new Object();
        private static final long serialVersionUID = 8567835998786448817L;

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f63620a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.y<? extends R> f63621b;

        /* renamed from: c  reason: collision with root package name */
        final a<T, R>[] f63622c;

        /* renamed from: d  reason: collision with root package name */
        final int f63623d;

        /* renamed from: e  reason: collision with root package name */
        final Object[] f63624e;

        /* renamed from: f  reason: collision with root package name */
        final rx.internal.util.atomic.e<Object> f63625f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f63626g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f63627h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f63628i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicLong f63629j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Throwable> f63630k;

        /* renamed from: l  reason: collision with root package name */
        int f63631l;

        /* renamed from: m  reason: collision with root package name */
        int f63632m;

        public b(rx.l<? super R> lVar, rx.functions.y<? extends R> yVar, int i4, int i5, boolean z3) {
            this.f63620a = lVar;
            this.f63621b = yVar;
            this.f63623d = i5;
            this.f63626g = z3;
            Object[] objArr = new Object[i4];
            this.f63624e = objArr;
            Arrays.fill(objArr, f63619n);
            this.f63622c = new a[i4];
            this.f63625f = new rx.internal.util.atomic.e<>(i5);
            this.f63629j = new AtomicLong();
            this.f63630k = new AtomicReference<>();
        }

        void a(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.f63622c) {
                aVar.unsubscribe();
            }
        }

        boolean b(boolean z3, boolean z4, rx.l<?> lVar, Queue<?> queue, boolean z5) {
            if (this.f63627h) {
                a(queue);
                return true;
            } else if (z3) {
                if (z5) {
                    if (z4) {
                        Throwable th = this.f63630k.get();
                        if (th != null) {
                            lVar.onError(th);
                        } else {
                            lVar.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f63630k.get();
                if (th2 != null) {
                    a(queue);
                    lVar.onError(th2);
                    return true;
                } else if (z4) {
                    lVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void c(Object obj, int i4) {
            boolean z3;
            a<T, R> aVar = this.f63622c[i4];
            synchronized (this) {
                Object[] objArr = this.f63624e;
                int length = objArr.length;
                Object obj2 = objArr[i4];
                int i5 = this.f63631l;
                Object obj3 = f63619n;
                if (obj2 == obj3) {
                    i5++;
                    this.f63631l = i5;
                }
                int i6 = this.f63632m;
                if (obj == null) {
                    i6++;
                    this.f63632m = i6;
                } else {
                    objArr[i4] = v.e(obj);
                }
                boolean z4 = false;
                z3 = i5 == length;
                if (i6 == length || (obj == null && obj2 == obj3)) {
                    z4 = true;
                }
                if (z4) {
                    this.f63628i = true;
                } else if (obj != null && z3) {
                    this.f63625f.s(aVar, this.f63624e.clone());
                } else if (obj == null && this.f63630k.get() != null && (obj2 == obj3 || !this.f63626g)) {
                    this.f63628i = true;
                }
            }
            if (!z3 && obj != null) {
                aVar.g(1L);
            } else {
                e();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
            if (r3 == 0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
            if (r13 == Long.MAX_VALUE) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
            rx.internal.operators.a.i(r10, r3);
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void e() {
            /*
                r19 = this;
                r7 = r19
                int r0 = r19.getAndIncrement()
                if (r0 == 0) goto L9
                return
            L9:
                rx.internal.util.atomic.e<java.lang.Object> r8 = r7.f63625f
                rx.l<? super R> r9 = r7.f63620a
                boolean r0 = r7.f63626g
                java.util.concurrent.atomic.AtomicLong r10 = r7.f63629j
                r11 = 1
                r12 = 1
            L13:
                boolean r2 = r7.f63628i
                boolean r3 = r8.isEmpty()
                r1 = r19
                r4 = r9
                r5 = r8
                r6 = r0
                boolean r1 = r1.b(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L25
                return
            L25:
                long r13 = r10.get()
                r5 = 0
            L2b:
                int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
                if (r1 == 0) goto L8e
                boolean r2 = r7.f63628i
                java.lang.Object r1 = r8.peek()
                r4 = r1
                rx.internal.operators.y$a r4 = (rx.internal.operators.y.a) r4
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
                boolean r1 = r1.b(r2, r3, r4, r5, r6)
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
                r7.f63627h = r11
                r7.a(r8)
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Broken queue?! Sender received but not the array."
                r0.<init>(r1)
                r9.onError(r0)
                return
            L71:
                rx.functions.y<? extends R> r2 = r7.f63621b     // Catch: java.lang.Throwable -> L84
                java.lang.Object r1 = r2.call(r1)     // Catch: java.lang.Throwable -> L84
                r9.onNext(r1)
                r1 = 1
                r15.g(r1)
                r3 = r17
                long r5 = r3 + r1
                goto L2b
            L84:
                r0 = move-exception
                r7.f63627h = r11
                r7.a(r8)
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
                rx.internal.operators.a.i(r10, r3)
            La1:
                int r1 = -r12
                int r12 = r7.addAndGet(r1)
                if (r12 != 0) goto L13
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.y.b.e():void");
        }

        void g(Throwable th) {
            Throwable th2;
            Throwable th3;
            AtomicReference<Throwable> atomicReference = this.f63630k;
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

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63627h;
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j4);
            } else if (j4 != 0) {
                rx.internal.operators.a.b(this.f63629j, j4);
                e();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f63627h) {
                return;
            }
            this.f63627h = true;
            if (getAndIncrement() == 0) {
                a(this.f63625f);
            }
        }

        public void v(rx.e<? extends T>[] eVarArr) {
            a<T, R>[] aVarArr = this.f63622c;
            int length = aVarArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                aVarArr[i4] = new a<>(this, i4);
            }
            lazySet(0);
            this.f63620a.add(this);
            this.f63620a.setProducer(this);
            for (int i5 = 0; i5 < length && !this.f63627h; i5++) {
                eVarArr[i5].q5(aVarArr[i5]);
            }
        }
    }

    public y(Iterable<? extends rx.e<? extends T>> iterable, rx.functions.y<? extends R> yVar) {
        this(null, iterable, yVar, rx.internal.util.j.f63940d, false);
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public y(rx.e<? extends T>[] eVarArr, Iterable<? extends rx.e<? extends T>> iterable, rx.functions.y<? extends R> yVar, int i4, boolean z3) {
        this.f63611a = eVarArr;
        this.f63612b = iterable;
        this.f63613c = yVar;
        this.f63614d = i4;
        this.f63615e = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call(rx.l<? super R> r9) {
        /*
            r8 = this;
            rx.e<? extends T>[] r0 = r8.f63611a
            if (r0 != 0) goto L45
            java.lang.Iterable<? extends rx.e<? extends T>> r0 = r8.f63612b
            boolean r1 = r0 instanceof java.util.List
            if (r1 == 0) goto L1a
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            rx.e[] r1 = new rx.e[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            rx.e[] r0 = (rx.e[]) r0
            int r1 = r0.length
            goto L46
        L1a:
            r1 = 8
            rx.e[] r1 = new rx.e[r1]
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
            r3 = 0
        L24:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L42
            java.lang.Object r4 = r0.next()
            rx.e r4 = (rx.e) r4
            int r5 = r1.length
            if (r3 != r5) goto L3c
            int r5 = r3 >> 2
            int r5 = r5 + r3
            rx.e[] r5 = new rx.e[r5]
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
            rx.functions.y<? extends R> r3 = r8.f63613c
            int r5 = r8.f63614d
            boolean r6 = r8.f63615e
            r1 = r7
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r7.v(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.y.call(rx.l):void");
    }
}
