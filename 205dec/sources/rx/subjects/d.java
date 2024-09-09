package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.l;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ReplaySubject.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class d<T> extends rx.subjects.f<T, T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object[] f64276c = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    final e<T> f64277b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ReplaySubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public interface a<T> {
        boolean a();

        void b(b<T> bVar);

        void complete();

        Throwable error();

        void error(Throwable th);

        boolean isEmpty();

        T last();

        void next(T t3);

        int size();

        T[] toArray(T[] tArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ReplaySubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b<T> extends AtomicInteger implements rx.g, m {
        private static final long serialVersionUID = -5006209596735204567L;

        /* renamed from: a  reason: collision with root package name */
        final l<? super T> f64278a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicLong f64279b = new AtomicLong();

        /* renamed from: c  reason: collision with root package name */
        final e<T> f64280c;

        /* renamed from: d  reason: collision with root package name */
        int f64281d;

        /* renamed from: e  reason: collision with root package name */
        int f64282e;

        /* renamed from: f  reason: collision with root package name */
        Object f64283f;

        public b(l<? super T> lVar, e<T> eVar) {
            this.f64278a = lVar;
            this.f64280c = eVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f64278a.isUnsubscribed();
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 > 0) {
                rx.internal.operators.a.b(this.f64279b, j4);
                this.f64280c.f64303a.b(this);
            } else if (j4 >= 0) {
            } else {
                throw new IllegalArgumentException("n >= required but it was " + j4);
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f64280c.G(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ReplaySubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class e<T> extends AtomicReference<b<T>[]> implements e.a<T>, rx.f<T> {

        /* renamed from: b  reason: collision with root package name */
        static final b[] f64301b = new b[0];

        /* renamed from: c  reason: collision with root package name */
        static final b[] f64302c = new b[0];
        private static final long serialVersionUID = 5952362471246910544L;

        /* renamed from: a  reason: collision with root package name */
        final a<T> f64303a;

        public e(a<T> aVar) {
            this.f64303a = aVar;
            lazySet(f64301b);
        }

        boolean F() {
            return get() == f64302c;
        }

        void G(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = get();
                if (bVarArr == f64302c || bVarArr == f64301b) {
                    return;
                }
                int length = bVarArr.length;
                int i4 = -1;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    } else if (bVarArr[i5] == bVar) {
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
                    bVarArr2 = f64301b;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i4);
                    System.arraycopy(bVarArr, i4 + 1, bVarArr3, i4, (length - i4) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!compareAndSet(bVarArr, bVarArr2));
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l) ((l) obj));
        }

        boolean d(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = get();
                if (bVarArr == f64302c) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        @Override // rx.f
        public void onCompleted() {
            a<T> aVar = this.f64303a;
            aVar.complete();
            for (b<T> bVar : getAndSet(f64302c)) {
                aVar.b(bVar);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            a<T> aVar = this.f64303a;
            aVar.error(th);
            ArrayList arrayList = null;
            for (b<T> bVar : getAndSet(f64302c)) {
                try {
                    aVar.b(bVar);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }

        @Override // rx.f
        public void onNext(T t3) {
            a<T> aVar = this.f64303a;
            aVar.next(t3);
            for (b<T> bVar : get()) {
                aVar.b(bVar);
            }
        }

        public void call(l<? super T> lVar) {
            b<T> bVar = new b<>(lVar, this);
            lVar.add(bVar);
            lVar.setProducer(bVar);
            if (d(bVar) && bVar.isUnsubscribed()) {
                G(bVar);
            } else {
                this.f64303a.b(bVar);
            }
        }
    }

    d(e<T> eVar) {
        super(eVar);
        this.f64277b = eVar;
    }

    static <T> d<T> A7() {
        return new d<>(new e(new c(Integer.MAX_VALUE, Long.MAX_VALUE, rx.schedulers.c.d())));
    }

    public static <T> d<T> B7(int i4) {
        return new d<>(new e(new C1327d(i4)));
    }

    public static <T> d<T> C7(long j4, TimeUnit timeUnit, rx.h hVar) {
        return D7(j4, timeUnit, Integer.MAX_VALUE, hVar);
    }

    public static <T> d<T> D7(long j4, TimeUnit timeUnit, int i4, rx.h hVar) {
        return new d<>(new e(new c(i4, timeUnit.toMillis(j4), hVar)));
    }

    public static <T> d<T> x7() {
        return y7(16);
    }

    public static <T> d<T> y7(int i4) {
        if (i4 > 0) {
            return new d<>(new e(new f(i4)));
        }
        throw new IllegalArgumentException("capacity > 0 required but it was " + i4);
    }

    static <T> d<T> z7() {
        return new d<>(new e(new C1327d(Integer.MAX_VALUE)));
    }

    public Throwable E7() {
        if (this.f64277b.F()) {
            return this.f64277b.f64303a.error();
        }
        return null;
    }

    public T F7() {
        return this.f64277b.f64303a.last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] G7() {
        Object[] objArr = f64276c;
        Object[] H7 = H7(objArr);
        return H7 == objArr ? new Object[0] : H7;
    }

    public T[] H7(T[] tArr) {
        return this.f64277b.f64303a.toArray(tArr);
    }

    public boolean I7() {
        return !this.f64277b.f64303a.isEmpty();
    }

    public boolean J7() {
        return this.f64277b.F() && this.f64277b.f64303a.error() == null;
    }

    public boolean K7() {
        return this.f64277b.F() && this.f64277b.f64303a.error() != null;
    }

    public boolean L7() {
        return I7();
    }

    public int M7() {
        return this.f64277b.f64303a.size();
    }

    int N7() {
        return this.f64277b.get().length;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f64277b.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f64277b.onError(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f64277b.onNext(t3);
    }

    @Override // rx.subjects.f
    public boolean v7() {
        return this.f64277b.get().length != 0;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ReplaySubject.java */
    /* renamed from: rx.subjects.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class C1327d<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f64294a;

        /* renamed from: b  reason: collision with root package name */
        volatile a<T> f64295b;

        /* renamed from: c  reason: collision with root package name */
        a<T> f64296c;

        /* renamed from: d  reason: collision with root package name */
        int f64297d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f64298e;

        /* renamed from: f  reason: collision with root package name */
        Throwable f64299f;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: ReplaySubject.java */
        /* renamed from: rx.subjects.d$d$a */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        static final class a<T> extends AtomicReference<a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;

            /* renamed from: a  reason: collision with root package name */
            final T f64300a;

            public a(T t3) {
                this.f64300a = t3;
            }
        }

        public C1327d(int i4) {
            this.f64294a = i4;
            a<T> aVar = new a<>(null);
            this.f64296c = aVar;
            this.f64295b = aVar;
        }

        @Override // rx.subjects.d.a
        public boolean a() {
            return this.f64298e;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
            if (r10 != r5) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
            if (r2.isUnsubscribed() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
            r18.f64283f = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
            r14 = r17.f64298e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0070, code lost:
            if (r7.get() != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0072, code lost:
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
            if (r14 == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
            if (r12 == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
            r18.f64283f = null;
            r1 = r17.f64299f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
            if (r1 == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0087, code lost:
            if (r10 == 0) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0090, code lost:
            if (r5 == Long.MAX_VALUE) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0092, code lost:
            rx.internal.operators.a.i(r18.f64279b, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
            r18.f64283f = r7;
            r4 = r18.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
            return;
         */
        @Override // rx.subjects.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b(rx.subjects.d.b<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r18.getAndIncrement()
                if (r2 == 0) goto Lb
                return
            Lb:
                rx.l<? super T> r2 = r1.f64278a
                r3 = 1
                r4 = 1
            Lf:
                java.util.concurrent.atomic.AtomicLong r5 = r1.f64279b
                long r5 = r5.get()
                java.lang.Object r7 = r1.f64283f
                rx.subjects.d$d$a r7 = (rx.subjects.d.C1327d.a) r7
                r8 = 0
                if (r7 != 0) goto L1f
                rx.subjects.d$d$a<T> r7 = r0.f64295b
            L1f:
                r10 = r8
            L20:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L5d
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L2f
                r1.f64283f = r13
                return
            L2f:
                boolean r14 = r0.f64298e
                java.lang.Object r15 = r7.get()
                rx.subjects.d$d$a r15 = (rx.subjects.d.C1327d.a) r15
                if (r15 != 0) goto L3c
                r16 = 1
                goto L3e
            L3c:
                r16 = 0
            L3e:
                if (r14 == 0) goto L50
                if (r16 == 0) goto L50
                r1.f64283f = r13
                java.lang.Throwable r1 = r0.f64299f
                if (r1 == 0) goto L4c
                r2.onError(r1)
                goto L4f
            L4c:
                r2.onCompleted()
            L4f:
                return
            L50:
                if (r16 == 0) goto L53
                goto L5d
            L53:
                T r7 = r15.f64300a
                r2.onNext(r7)
                r12 = 1
                long r10 = r10 + r12
                r7 = r15
                goto L20
            L5d:
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 != 0) goto L85
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L6a
                r1.f64283f = r13
                return
            L6a:
                boolean r14 = r0.f64298e
                java.lang.Object r15 = r7.get()
                if (r15 != 0) goto L73
                r12 = 1
            L73:
                if (r14 == 0) goto L85
                if (r12 == 0) goto L85
                r1.f64283f = r13
                java.lang.Throwable r1 = r0.f64299f
                if (r1 == 0) goto L81
                r2.onError(r1)
                goto L84
            L81:
                r2.onCompleted()
            L84:
                return
            L85:
                int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r12 == 0) goto L97
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 == 0) goto L97
                java.util.concurrent.atomic.AtomicLong r5 = r1.f64279b
                rx.internal.operators.a.i(r5, r10)
            L97:
                r1.f64283f = r7
                int r4 = -r4
                int r4 = r1.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.d.C1327d.b(rx.subjects.d$b):void");
        }

        @Override // rx.subjects.d.a
        public void complete() {
            this.f64298e = true;
        }

        @Override // rx.subjects.d.a
        public void error(Throwable th) {
            this.f64299f = th;
            this.f64298e = true;
        }

        @Override // rx.subjects.d.a
        public boolean isEmpty() {
            return this.f64295b.get() == null;
        }

        @Override // rx.subjects.d.a
        public T last() {
            a<T> aVar = this.f64295b;
            while (true) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null) {
                    return aVar.f64300a;
                }
                aVar = aVar2;
            }
        }

        @Override // rx.subjects.d.a
        public void next(T t3) {
            a<T> aVar = new a<>(t3);
            this.f64296c.set(aVar);
            this.f64296c = aVar;
            int i4 = this.f64297d;
            if (i4 == this.f64294a) {
                this.f64295b = this.f64295b.get();
            } else {
                this.f64297d = i4 + 1;
            }
        }

        @Override // rx.subjects.d.a
        public int size() {
            a<T> aVar = this.f64295b.get();
            int i4 = 0;
            while (aVar != null && i4 != Integer.MAX_VALUE) {
                aVar = aVar.get();
                i4++;
            }
            return i4;
        }

        @Override // rx.subjects.d.a
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (a<T> aVar = this.f64295b.get(); aVar != null; aVar = aVar.get()) {
                arrayList.add(aVar.f64300a);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        @Override // rx.subjects.d.a
        public Throwable error() {
            return this.f64299f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ReplaySubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f64284a;

        /* renamed from: b  reason: collision with root package name */
        final long f64285b;

        /* renamed from: c  reason: collision with root package name */
        final rx.h f64286c;

        /* renamed from: d  reason: collision with root package name */
        volatile a<T> f64287d;

        /* renamed from: e  reason: collision with root package name */
        a<T> f64288e;

        /* renamed from: f  reason: collision with root package name */
        int f64289f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f64290g;

        /* renamed from: h  reason: collision with root package name */
        Throwable f64291h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: ReplaySubject.java */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public static final class a<T> extends AtomicReference<a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;

            /* renamed from: a  reason: collision with root package name */
            final T f64292a;

            /* renamed from: b  reason: collision with root package name */
            final long f64293b;

            public a(T t3, long j4) {
                this.f64292a = t3;
                this.f64293b = j4;
            }
        }

        public c(int i4, long j4, rx.h hVar) {
            this.f64284a = i4;
            a<T> aVar = new a<>(null, 0L);
            this.f64288e = aVar;
            this.f64287d = aVar;
            this.f64285b = j4;
            this.f64286c = hVar;
        }

        @Override // rx.subjects.d.a
        public boolean a() {
            return this.f64290g;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
            if (r10 != r5) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
            if (r2.isUnsubscribed() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
            r18.f64283f = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
            r14 = r17.f64290g;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
            if (r7.get() != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
            if (r14 == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
            if (r12 == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
            r18.f64283f = null;
            r1 = r17.f64291h;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
            if (r1 == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0086, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0089, code lost:
            if (r10 == 0) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:
            if (r5 == Long.MAX_VALUE) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0094, code lost:
            rx.internal.operators.a.i(r18.f64279b, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
            r18.f64283f = r7;
            r4 = r18.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
            return;
         */
        @Override // rx.subjects.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b(rx.subjects.d.b<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r18.getAndIncrement()
                if (r2 == 0) goto Lb
                return
            Lb:
                rx.l<? super T> r2 = r1.f64278a
                r3 = 1
                r4 = 1
            Lf:
                java.util.concurrent.atomic.AtomicLong r5 = r1.f64279b
                long r5 = r5.get()
                java.lang.Object r7 = r1.f64283f
                rx.subjects.d$c$a r7 = (rx.subjects.d.c.a) r7
                r8 = 0
                if (r7 != 0) goto L21
                rx.subjects.d$c$a r7 = r17.d()
            L21:
                r10 = r8
            L22:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L5f
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L31
                r1.f64283f = r13
                return
            L31:
                boolean r14 = r0.f64290g
                java.lang.Object r15 = r7.get()
                rx.subjects.d$c$a r15 = (rx.subjects.d.c.a) r15
                if (r15 != 0) goto L3e
                r16 = 1
                goto L40
            L3e:
                r16 = 0
            L40:
                if (r14 == 0) goto L52
                if (r16 == 0) goto L52
                r1.f64283f = r13
                java.lang.Throwable r1 = r0.f64291h
                if (r1 == 0) goto L4e
                r2.onError(r1)
                goto L51
            L4e:
                r2.onCompleted()
            L51:
                return
            L52:
                if (r16 == 0) goto L55
                goto L5f
            L55:
                T r7 = r15.f64292a
                r2.onNext(r7)
                r12 = 1
                long r10 = r10 + r12
                r7 = r15
                goto L22
            L5f:
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 != 0) goto L87
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L6c
                r1.f64283f = r13
                return
            L6c:
                boolean r14 = r0.f64290g
                java.lang.Object r15 = r7.get()
                if (r15 != 0) goto L75
                r12 = 1
            L75:
                if (r14 == 0) goto L87
                if (r12 == 0) goto L87
                r1.f64283f = r13
                java.lang.Throwable r1 = r0.f64291h
                if (r1 == 0) goto L83
                r2.onError(r1)
                goto L86
            L83:
                r2.onCompleted()
            L86:
                return
            L87:
                int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r12 == 0) goto L99
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 == 0) goto L99
                java.util.concurrent.atomic.AtomicLong r5 = r1.f64279b
                rx.internal.operators.a.i(r5, r10)
            L99:
                r1.f64283f = r7
                int r4 = -r4
                int r4 = r1.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.d.c.b(rx.subjects.d$b):void");
        }

        void c() {
            long b4 = this.f64286c.b() - this.f64285b;
            a<T> aVar = this.f64287d;
            a<T> aVar2 = aVar;
            while (true) {
                a<T> aVar3 = aVar2.get();
                if (aVar3 == null || aVar3.f64293b > b4) {
                    break;
                }
                aVar2 = aVar3;
            }
            if (aVar != aVar2) {
                this.f64287d = aVar2;
            }
        }

        @Override // rx.subjects.d.a
        public void complete() {
            c();
            this.f64290g = true;
        }

        a<T> d() {
            long b4 = this.f64286c.b() - this.f64285b;
            a<T> aVar = this.f64287d;
            while (true) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null || aVar2.f64293b > b4) {
                    break;
                }
                aVar = aVar2;
            }
            return aVar;
        }

        @Override // rx.subjects.d.a
        public void error(Throwable th) {
            c();
            this.f64291h = th;
            this.f64290g = true;
        }

        @Override // rx.subjects.d.a
        public boolean isEmpty() {
            return d().get() == null;
        }

        @Override // rx.subjects.d.a
        public T last() {
            a<T> d4 = d();
            while (true) {
                a<T> aVar = d4.get();
                if (aVar == null) {
                    return d4.f64292a;
                }
                d4 = aVar;
            }
        }

        @Override // rx.subjects.d.a
        public void next(T t3) {
            a<T> aVar;
            long b4 = this.f64286c.b();
            a<T> aVar2 = new a<>(t3, b4);
            this.f64288e.set(aVar2);
            this.f64288e = aVar2;
            long j4 = b4 - this.f64285b;
            int i4 = this.f64289f;
            a<T> aVar3 = this.f64287d;
            if (i4 == this.f64284a) {
                aVar = aVar3.get();
            } else {
                i4++;
                aVar = aVar3;
            }
            while (true) {
                a<T> aVar4 = aVar.get();
                if (aVar4 == null || aVar4.f64293b > j4) {
                    break;
                }
                i4--;
                aVar = aVar4;
            }
            this.f64289f = i4;
            if (aVar != aVar3) {
                this.f64287d = aVar;
            }
        }

        @Override // rx.subjects.d.a
        public int size() {
            a<T> aVar = d().get();
            int i4 = 0;
            while (aVar != null && i4 != Integer.MAX_VALUE) {
                aVar = aVar.get();
                i4++;
            }
            return i4;
        }

        @Override // rx.subjects.d.a
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (a<T> aVar = d().get(); aVar != null; aVar = aVar.get()) {
                arrayList.add(aVar.f64292a);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        @Override // rx.subjects.d.a
        public Throwable error() {
            return this.f64291h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ReplaySubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class f<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f64304a;

        /* renamed from: b  reason: collision with root package name */
        volatile int f64305b;

        /* renamed from: c  reason: collision with root package name */
        final Object[] f64306c;

        /* renamed from: d  reason: collision with root package name */
        Object[] f64307d;

        /* renamed from: e  reason: collision with root package name */
        int f64308e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f64309f;

        /* renamed from: g  reason: collision with root package name */
        Throwable f64310g;

        public f(int i4) {
            this.f64304a = i4;
            Object[] objArr = new Object[i4 + 1];
            this.f64306c = objArr;
            this.f64307d = objArr;
        }

        @Override // rx.subjects.d.a
        public boolean a() {
            return this.f64309f;
        }

        @Override // rx.subjects.d.a
        public void b(b<T> bVar) {
            if (bVar.getAndIncrement() != 0) {
                return;
            }
            l<? super T> lVar = bVar.f64278a;
            int i4 = this.f64304a;
            int i5 = 1;
            do {
                long j4 = bVar.f64279b.get();
                Object[] objArr = (Object[]) bVar.f64283f;
                if (objArr == null) {
                    objArr = this.f64306c;
                }
                int i6 = bVar.f64282e;
                int i7 = bVar.f64281d;
                long j5 = 0;
                while (j5 != j4) {
                    if (lVar.isUnsubscribed()) {
                        bVar.f64283f = null;
                        return;
                    }
                    boolean z3 = this.f64309f;
                    boolean z4 = i7 == this.f64305b;
                    if (z3 && z4) {
                        bVar.f64283f = null;
                        Throwable th = this.f64310g;
                        if (th != null) {
                            lVar.onError(th);
                            return;
                        } else {
                            lVar.onCompleted();
                            return;
                        }
                    } else if (z4) {
                        break;
                    } else {
                        if (i6 == i4) {
                            objArr = (Object[]) objArr[i6];
                            i6 = 0;
                        }
                        lVar.onNext(objArr[i6]);
                        j5++;
                        i6++;
                        i7++;
                    }
                }
                if (j5 == j4) {
                    if (lVar.isUnsubscribed()) {
                        bVar.f64283f = null;
                        return;
                    }
                    boolean z5 = this.f64309f;
                    boolean z6 = i7 == this.f64305b;
                    if (z5 && z6) {
                        bVar.f64283f = null;
                        Throwable th2 = this.f64310g;
                        if (th2 != null) {
                            lVar.onError(th2);
                            return;
                        } else {
                            lVar.onCompleted();
                            return;
                        }
                    }
                }
                if (j5 != 0 && j4 != Long.MAX_VALUE) {
                    rx.internal.operators.a.i(bVar.f64279b, j5);
                }
                bVar.f64281d = i7;
                bVar.f64282e = i6;
                bVar.f64283f = objArr;
                i5 = bVar.addAndGet(-i5);
            } while (i5 != 0);
        }

        @Override // rx.subjects.d.a
        public void complete() {
            this.f64309f = true;
        }

        @Override // rx.subjects.d.a
        public void error(Throwable th) {
            if (this.f64309f) {
                rx.plugins.c.I(th);
                return;
            }
            this.f64310g = th;
            this.f64309f = true;
        }

        @Override // rx.subjects.d.a
        public boolean isEmpty() {
            return this.f64305b == 0;
        }

        @Override // rx.subjects.d.a
        public T last() {
            int i4 = this.f64305b;
            if (i4 == 0) {
                return null;
            }
            Object[] objArr = this.f64306c;
            int i5 = this.f64304a;
            while (i4 >= i5) {
                objArr = objArr[i5];
                i4 -= i5;
            }
            return (T) objArr[i4 - 1];
        }

        @Override // rx.subjects.d.a
        public void next(T t3) {
            if (this.f64309f) {
                return;
            }
            int i4 = this.f64308e;
            Object[] objArr = this.f64307d;
            if (i4 == objArr.length - 1) {
                Object[] objArr2 = new Object[objArr.length];
                objArr2[0] = t3;
                this.f64308e = 1;
                objArr[i4] = objArr2;
                this.f64307d = objArr2;
            } else {
                objArr[i4] = t3;
                this.f64308e = i4 + 1;
            }
            this.f64305b++;
        }

        @Override // rx.subjects.d.a
        public int size() {
            return this.f64305b;
        }

        @Override // rx.subjects.d.a
        public T[] toArray(T[] tArr) {
            int i4 = this.f64305b;
            if (tArr.length < i4) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i4));
            }
            Object[] objArr = this.f64306c;
            int i5 = this.f64304a;
            int i6 = 0;
            while (true) {
                int i7 = i6 + i5;
                if (i7 >= i4) {
                    break;
                }
                System.arraycopy(objArr, 0, tArr, i6, i5);
                objArr = objArr[i5];
                i6 = i7;
            }
            System.arraycopy(objArr, 0, tArr, i6, i4 - i6);
            if (tArr.length > i4) {
                tArr[i4] = null;
            }
            return tArr;
        }

        @Override // rx.subjects.d.a
        public Throwable error() {
            return this.f64310g;
        }
    }
}
