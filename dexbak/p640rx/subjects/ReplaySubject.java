package p640rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.internal.operators.BackpressureUtils;
import p640rx.plugins.RxJavaHooks;
import p640rx.schedulers.Schedulers;

/* renamed from: rx.subjects.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ReplaySubject<T> extends Subject<T, T> {

    /* renamed from: c */
    private static final Object[] f47007c = new Object[0];

    /* renamed from: b */
    final C16177e<T> f47008b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* renamed from: rx.subjects.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC16171a<T> {
        /* renamed from: a */
        boolean mo400a();

        /* renamed from: b */
        void mo399b(C16172b<T> c16172b);

        void complete();

        Throwable error();

        void error(Throwable th);

        boolean isEmpty();

        T last();

        void next(T t);

        int size();

        T[] toArray(T[] tArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* renamed from: rx.subjects.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16172b<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;

        /* renamed from: a */
        final Subscriber<? super T> f47009a;

        /* renamed from: b */
        final AtomicLong f47010b = new AtomicLong();

        /* renamed from: c */
        final C16177e<T> f47011c;

        /* renamed from: d */
        int f47012d;

        /* renamed from: e */
        int f47013e;

        /* renamed from: f */
        Object f47014f;

        public C16172b(Subscriber<? super T> subscriber, C16177e<T> c16177e) {
            this.f47009a = subscriber;
            this.f47011c = c16177e;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f47009a.isUnsubscribed();
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j > 0) {
                BackpressureUtils.m1335b(this.f47010b, j);
                this.f47011c.f47034a.mo399b(this);
            } else if (j >= 0) {
            } else {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f47011c.m402G(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* renamed from: rx.subjects.d$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16177e<T> extends AtomicReference<C16172b<T>[]> implements Observable.InterfaceC15567a<T>, Observer<T> {

        /* renamed from: b */
        static final C16172b[] f47032b = new C16172b[0];

        /* renamed from: c */
        static final C16172b[] f47033c = new C16172b[0];
        private static final long serialVersionUID = 5952362471246910544L;

        /* renamed from: a */
        final InterfaceC16171a<T> f47034a;

        public C16177e(InterfaceC16171a<T> interfaceC16171a) {
            this.f47034a = interfaceC16171a;
            lazySet(f47032b);
        }

        /* renamed from: F */
        boolean m403F() {
            return get() == f47033c;
        }

        /* renamed from: G */
        void m402G(C16172b<T> c16172b) {
            C16172b<T>[] c16172bArr;
            C16172b[] c16172bArr2;
            do {
                c16172bArr = get();
                if (c16172bArr == f47033c || c16172bArr == f47032b) {
                    return;
                }
                int length = c16172bArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (c16172bArr[i2] == c16172b) {
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
                    c16172bArr2 = f47032b;
                } else {
                    C16172b[] c16172bArr3 = new C16172b[length - 1];
                    System.arraycopy(c16172bArr, 0, c16172bArr3, 0, i);
                    System.arraycopy(c16172bArr, i + 1, c16172bArr3, i, (length - i) - 1);
                    c16172bArr2 = c16172bArr3;
                }
            } while (!compareAndSet(c16172bArr, c16172bArr2));
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        /* renamed from: d */
        boolean m401d(C16172b<T> c16172b) {
            C16172b<T>[] c16172bArr;
            C16172b[] c16172bArr2;
            do {
                c16172bArr = get();
                if (c16172bArr == f47033c) {
                    return false;
                }
                int length = c16172bArr.length;
                c16172bArr2 = new C16172b[length + 1];
                System.arraycopy(c16172bArr, 0, c16172bArr2, 0, length);
                c16172bArr2[length] = c16172b;
            } while (!compareAndSet(c16172bArr, c16172bArr2));
            return true;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            InterfaceC16171a<T> interfaceC16171a = this.f47034a;
            interfaceC16171a.complete();
            for (C16172b<T> c16172b : getAndSet(f47033c)) {
                interfaceC16171a.mo399b(c16172b);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            InterfaceC16171a<T> interfaceC16171a = this.f47034a;
            interfaceC16171a.error(th);
            ArrayList arrayList = null;
            for (C16172b<T> c16172b : getAndSet(f47033c)) {
                try {
                    interfaceC16171a.mo399b(c16172b);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            C15575a.m1475d(arrayList);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            InterfaceC16171a<T> interfaceC16171a = this.f47034a;
            interfaceC16171a.next(t);
            for (C16172b<T> c16172b : get()) {
                interfaceC16171a.mo399b(c16172b);
            }
        }

        public void call(Subscriber<? super T> subscriber) {
            C16172b<T> c16172b = new C16172b<>(subscriber, this);
            subscriber.add(c16172b);
            subscriber.setProducer(c16172b);
            if (m401d(c16172b) && c16172b.isUnsubscribed()) {
                m402G(c16172b);
            } else {
                this.f47034a.mo399b(c16172b);
            }
        }
    }

    ReplaySubject(C16177e<T> c16177e) {
        super(c16177e);
        this.f47008b = c16177e;
    }

    /* renamed from: A7 */
    static <T> ReplaySubject<T> m422A7() {
        return new ReplaySubject<>(new C16177e(new C16173c(Integer.MAX_VALUE, Long.MAX_VALUE, Schedulers.m476d())));
    }

    /* renamed from: B7 */
    public static <T> ReplaySubject<T> m421B7(int i) {
        return new ReplaySubject<>(new C16177e(new C16175d(i)));
    }

    /* renamed from: C7 */
    public static <T> ReplaySubject<T> m420C7(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m419D7(j, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    /* renamed from: D7 */
    public static <T> ReplaySubject<T> m419D7(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        return new ReplaySubject<>(new C16177e(new C16173c(i, timeUnit.toMillis(j), scheduler)));
    }

    /* renamed from: x7 */
    public static <T> ReplaySubject<T> m408x7() {
        return m407y7(16);
    }

    /* renamed from: y7 */
    public static <T> ReplaySubject<T> m407y7(int i) {
        if (i > 0) {
            return new ReplaySubject<>(new C16177e(new C16178f(i)));
        }
        throw new IllegalArgumentException("capacity > 0 required but it was " + i);
    }

    /* renamed from: z7 */
    static <T> ReplaySubject<T> m406z7() {
        return new ReplaySubject<>(new C16177e(new C16175d(Integer.MAX_VALUE)));
    }

    /* renamed from: E7 */
    public Throwable m418E7() {
        if (this.f47008b.m403F()) {
            return this.f47008b.f47034a.error();
        }
        return null;
    }

    /* renamed from: F7 */
    public T m417F7() {
        return this.f47008b.f47034a.last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: G7 */
    public Object[] m416G7() {
        Object[] objArr = f47007c;
        Object[] m415H7 = m415H7(objArr);
        return m415H7 == objArr ? new Object[0] : m415H7;
    }

    /* renamed from: H7 */
    public T[] m415H7(T[] tArr) {
        return this.f47008b.f47034a.toArray(tArr);
    }

    /* renamed from: I7 */
    public boolean m414I7() {
        return !this.f47008b.f47034a.isEmpty();
    }

    /* renamed from: J7 */
    public boolean m413J7() {
        return this.f47008b.m403F() && this.f47008b.f47034a.error() == null;
    }

    /* renamed from: K7 */
    public boolean m412K7() {
        return this.f47008b.m403F() && this.f47008b.f47034a.error() != null;
    }

    /* renamed from: L7 */
    public boolean m411L7() {
        return m414I7();
    }

    /* renamed from: M7 */
    public int m410M7() {
        return this.f47008b.f47034a.size();
    }

    /* renamed from: N7 */
    int m409N7() {
        return this.f47008b.get().length;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f47008b.onCompleted();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f47008b.onError(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f47008b.onNext(t);
    }

    @Override // p640rx.subjects.Subject
    /* renamed from: v7 */
    public boolean mo371v7() {
        return this.f47008b.get().length != 0;
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: rx.subjects.d$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16175d<T> implements InterfaceC16171a<T> {

        /* renamed from: a */
        final int f47025a;

        /* renamed from: b */
        volatile C16176a<T> f47026b;

        /* renamed from: c */
        C16176a<T> f47027c;

        /* renamed from: d */
        int f47028d;

        /* renamed from: e */
        volatile boolean f47029e;

        /* renamed from: f */
        Throwable f47030f;

        /* compiled from: ReplaySubject.java */
        /* renamed from: rx.subjects.d$d$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static final class C16176a<T> extends AtomicReference<C16176a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;

            /* renamed from: a */
            final T f47031a;

            public C16176a(T t) {
                this.f47031a = t;
            }
        }

        public C16175d(int i) {
            this.f47025a = i;
            C16176a<T> c16176a = new C16176a<>(null);
            this.f47027c = c16176a;
            this.f47026b = c16176a;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        /* renamed from: a */
        public boolean mo400a() {
            return this.f47029e;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
            if (r10 != r5) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
            if (r2.isUnsubscribed() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
            r18.f47014f = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
            r14 = r17.f47029e;
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
            r18.f47014f = null;
            r1 = r17.f47030f;
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
            p640rx.internal.operators.BackpressureUtils.m1328i(r18.f47010b, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
            r18.f47014f = r7;
            r4 = r18.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
            return;
         */
        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo399b(p640rx.subjects.ReplaySubject.C16172b<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r18.getAndIncrement()
                if (r2 == 0) goto Lb
                return
            Lb:
                rx.l<? super T> r2 = r1.f47009a
                r3 = 1
                r4 = 1
            Lf:
                java.util.concurrent.atomic.AtomicLong r5 = r1.f47010b
                long r5 = r5.get()
                java.lang.Object r7 = r1.f47014f
                rx.subjects.d$d$a r7 = (p640rx.subjects.ReplaySubject.C16175d.C16176a) r7
                r8 = 0
                if (r7 != 0) goto L1f
                rx.subjects.d$d$a<T> r7 = r0.f47026b
            L1f:
                r10 = r8
            L20:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L5d
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L2f
                r1.f47014f = r13
                return
            L2f:
                boolean r14 = r0.f47029e
                java.lang.Object r15 = r7.get()
                rx.subjects.d$d$a r15 = (p640rx.subjects.ReplaySubject.C16175d.C16176a) r15
                if (r15 != 0) goto L3c
                r16 = 1
                goto L3e
            L3c:
                r16 = 0
            L3e:
                if (r14 == 0) goto L50
                if (r16 == 0) goto L50
                r1.f47014f = r13
                java.lang.Throwable r1 = r0.f47030f
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
                T r7 = r15.f47031a
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
                r1.f47014f = r13
                return
            L6a:
                boolean r14 = r0.f47029e
                java.lang.Object r15 = r7.get()
                if (r15 != 0) goto L73
                r12 = 1
            L73:
                if (r14 == 0) goto L85
                if (r12 == 0) goto L85
                r1.f47014f = r13
                java.lang.Throwable r1 = r0.f47030f
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
                java.util.concurrent.atomic.AtomicLong r5 = r1.f47010b
                p640rx.internal.operators.BackpressureUtils.m1328i(r5, r10)
            L97:
                r1.f47014f = r7
                int r4 = -r4
                int r4 = r1.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.subjects.ReplaySubject.C16175d.mo399b(rx.subjects.d$b):void");
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public void complete() {
            this.f47029e = true;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public void error(Throwable th) {
            this.f47030f = th;
            this.f47029e = true;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public boolean isEmpty() {
            return this.f47026b.get() == null;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public T last() {
            C16176a<T> c16176a = this.f47026b;
            while (true) {
                C16176a<T> c16176a2 = c16176a.get();
                if (c16176a2 == null) {
                    return c16176a.f47031a;
                }
                c16176a = c16176a2;
            }
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public void next(T t) {
            C16176a<T> c16176a = new C16176a<>(t);
            this.f47027c.set(c16176a);
            this.f47027c = c16176a;
            int i = this.f47028d;
            if (i == this.f47025a) {
                this.f47026b = this.f47026b.get();
            } else {
                this.f47028d = i + 1;
            }
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public int size() {
            C16176a<T> c16176a = this.f47026b.get();
            int i = 0;
            while (c16176a != null && i != Integer.MAX_VALUE) {
                c16176a = c16176a.get();
                i++;
            }
            return i;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (C16176a<T> c16176a = this.f47026b.get(); c16176a != null; c16176a = c16176a.get()) {
                arrayList.add(c16176a.f47031a);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public Throwable error() {
            return this.f47030f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* renamed from: rx.subjects.d$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16173c<T> implements InterfaceC16171a<T> {

        /* renamed from: a */
        final int f47015a;

        /* renamed from: b */
        final long f47016b;

        /* renamed from: c */
        final Scheduler f47017c;

        /* renamed from: d */
        volatile C16174a<T> f47018d;

        /* renamed from: e */
        C16174a<T> f47019e;

        /* renamed from: f */
        int f47020f;

        /* renamed from: g */
        volatile boolean f47021g;

        /* renamed from: h */
        Throwable f47022h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReplaySubject.java */
        /* renamed from: rx.subjects.d$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C16174a<T> extends AtomicReference<C16174a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;

            /* renamed from: a */
            final T f47023a;

            /* renamed from: b */
            final long f47024b;

            public C16174a(T t, long j) {
                this.f47023a = t;
                this.f47024b = j;
            }
        }

        public C16173c(int i, long j, Scheduler scheduler) {
            this.f47015a = i;
            C16174a<T> c16174a = new C16174a<>(null, 0L);
            this.f47019e = c16174a;
            this.f47018d = c16174a;
            this.f47016b = j;
            this.f47017c = scheduler;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        /* renamed from: a */
        public boolean mo400a() {
            return this.f47021g;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
            if (r10 != r5) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
            if (r2.isUnsubscribed() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
            r18.f47014f = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
            r14 = r17.f47021g;
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
            r18.f47014f = null;
            r1 = r17.f47022h;
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
            p640rx.internal.operators.BackpressureUtils.m1328i(r18.f47010b, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
            r18.f47014f = r7;
            r4 = r18.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
            return;
         */
        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo399b(p640rx.subjects.ReplaySubject.C16172b<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r18.getAndIncrement()
                if (r2 == 0) goto Lb
                return
            Lb:
                rx.l<? super T> r2 = r1.f47009a
                r3 = 1
                r4 = 1
            Lf:
                java.util.concurrent.atomic.AtomicLong r5 = r1.f47010b
                long r5 = r5.get()
                java.lang.Object r7 = r1.f47014f
                rx.subjects.d$c$a r7 = (p640rx.subjects.ReplaySubject.C16173c.C16174a) r7
                r8 = 0
                if (r7 != 0) goto L21
                rx.subjects.d$c$a r7 = r17.m404d()
            L21:
                r10 = r8
            L22:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L5f
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L31
                r1.f47014f = r13
                return
            L31:
                boolean r14 = r0.f47021g
                java.lang.Object r15 = r7.get()
                rx.subjects.d$c$a r15 = (p640rx.subjects.ReplaySubject.C16173c.C16174a) r15
                if (r15 != 0) goto L3e
                r16 = 1
                goto L40
            L3e:
                r16 = 0
            L40:
                if (r14 == 0) goto L52
                if (r16 == 0) goto L52
                r1.f47014f = r13
                java.lang.Throwable r1 = r0.f47022h
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
                T r7 = r15.f47023a
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
                r1.f47014f = r13
                return
            L6c:
                boolean r14 = r0.f47021g
                java.lang.Object r15 = r7.get()
                if (r15 != 0) goto L75
                r12 = 1
            L75:
                if (r14 == 0) goto L87
                if (r12 == 0) goto L87
                r1.f47014f = r13
                java.lang.Throwable r1 = r0.f47022h
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
                java.util.concurrent.atomic.AtomicLong r5 = r1.f47010b
                p640rx.internal.operators.BackpressureUtils.m1328i(r5, r10)
            L99:
                r1.f47014f = r7
                int r4 = -r4
                int r4 = r1.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.subjects.ReplaySubject.C16173c.mo399b(rx.subjects.d$b):void");
        }

        /* renamed from: c */
        void m405c() {
            long mo462b = this.f47017c.mo462b() - this.f47016b;
            C16174a<T> c16174a = this.f47018d;
            C16174a<T> c16174a2 = c16174a;
            while (true) {
                C16174a<T> c16174a3 = c16174a2.get();
                if (c16174a3 == null || c16174a3.f47024b > mo462b) {
                    break;
                }
                c16174a2 = c16174a3;
            }
            if (c16174a != c16174a2) {
                this.f47018d = c16174a2;
            }
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public void complete() {
            m405c();
            this.f47021g = true;
        }

        /* renamed from: d */
        C16174a<T> m404d() {
            long mo462b = this.f47017c.mo462b() - this.f47016b;
            C16174a<T> c16174a = this.f47018d;
            while (true) {
                C16174a<T> c16174a2 = c16174a.get();
                if (c16174a2 == null || c16174a2.f47024b > mo462b) {
                    break;
                }
                c16174a = c16174a2;
            }
            return c16174a;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public void error(Throwable th) {
            m405c();
            this.f47022h = th;
            this.f47021g = true;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public boolean isEmpty() {
            return m404d().get() == null;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public T last() {
            C16174a<T> m404d = m404d();
            while (true) {
                C16174a<T> c16174a = m404d.get();
                if (c16174a == null) {
                    return m404d.f47023a;
                }
                m404d = c16174a;
            }
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public void next(T t) {
            C16174a<T> c16174a;
            long mo462b = this.f47017c.mo462b();
            C16174a<T> c16174a2 = new C16174a<>(t, mo462b);
            this.f47019e.set(c16174a2);
            this.f47019e = c16174a2;
            long j = mo462b - this.f47016b;
            int i = this.f47020f;
            C16174a<T> c16174a3 = this.f47018d;
            if (i == this.f47015a) {
                c16174a = c16174a3.get();
            } else {
                i++;
                c16174a = c16174a3;
            }
            while (true) {
                C16174a<T> c16174a4 = c16174a.get();
                if (c16174a4 == null || c16174a4.f47024b > j) {
                    break;
                }
                i--;
                c16174a = c16174a4;
            }
            this.f47020f = i;
            if (c16174a != c16174a3) {
                this.f47018d = c16174a;
            }
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public int size() {
            C16174a<T> c16174a = m404d().get();
            int i = 0;
            while (c16174a != null && i != Integer.MAX_VALUE) {
                c16174a = c16174a.get();
                i++;
            }
            return i;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (C16174a<T> c16174a = m404d().get(); c16174a != null; c16174a = c16174a.get()) {
                arrayList.add(c16174a.f47023a);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public Throwable error() {
            return this.f47022h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* renamed from: rx.subjects.d$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16178f<T> implements InterfaceC16171a<T> {

        /* renamed from: a */
        final int f47035a;

        /* renamed from: b */
        volatile int f47036b;

        /* renamed from: c */
        final Object[] f47037c;

        /* renamed from: d */
        Object[] f47038d;

        /* renamed from: e */
        int f47039e;

        /* renamed from: f */
        volatile boolean f47040f;

        /* renamed from: g */
        Throwable f47041g;

        public C16178f(int i) {
            this.f47035a = i;
            Object[] objArr = new Object[i + 1];
            this.f47037c = objArr;
            this.f47038d = objArr;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        /* renamed from: a */
        public boolean mo400a() {
            return this.f47040f;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        /* renamed from: b */
        public void mo399b(C16172b<T> c16172b) {
            if (c16172b.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = c16172b.f47009a;
            int i = this.f47035a;
            int i2 = 1;
            do {
                long j = c16172b.f47010b.get();
                Object[] objArr = (Object[]) c16172b.f47014f;
                if (objArr == null) {
                    objArr = this.f47037c;
                }
                int i3 = c16172b.f47013e;
                int i4 = c16172b.f47012d;
                long j2 = 0;
                while (j2 != j) {
                    if (subscriber.isUnsubscribed()) {
                        c16172b.f47014f = null;
                        return;
                    }
                    boolean z = this.f47040f;
                    boolean z2 = i4 == this.f47036b;
                    if (z && z2) {
                        c16172b.f47014f = null;
                        Throwable th = this.f47041g;
                        if (th != null) {
                            subscriber.onError(th);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    } else if (z2) {
                        break;
                    } else {
                        if (i3 == i) {
                            objArr = (Object[]) objArr[i3];
                            i3 = 0;
                        }
                        subscriber.onNext(objArr[i3]);
                        j2++;
                        i3++;
                        i4++;
                    }
                }
                if (j2 == j) {
                    if (subscriber.isUnsubscribed()) {
                        c16172b.f47014f = null;
                        return;
                    }
                    boolean z3 = this.f47040f;
                    boolean z4 = i4 == this.f47036b;
                    if (z3 && z4) {
                        c16172b.f47014f = null;
                        Throwable th2 = this.f47041g;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    BackpressureUtils.m1328i(c16172b.f47010b, j2);
                }
                c16172b.f47012d = i4;
                c16172b.f47013e = i3;
                c16172b.f47014f = objArr;
                i2 = c16172b.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public void complete() {
            this.f47040f = true;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public void error(Throwable th) {
            if (this.f47040f) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f47041g = th;
            this.f47040f = true;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public boolean isEmpty() {
            return this.f47036b == 0;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public T last() {
            int i = this.f47036b;
            if (i == 0) {
                return null;
            }
            Object[] objArr = this.f47037c;
            int i2 = this.f47035a;
            while (i >= i2) {
                objArr = objArr[i2];
                i -= i2;
            }
            return (T) objArr[i - 1];
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public void next(T t) {
            if (this.f47040f) {
                return;
            }
            int i = this.f47039e;
            Object[] objArr = this.f47038d;
            if (i == objArr.length - 1) {
                Object[] objArr2 = new Object[objArr.length];
                objArr2[0] = t;
                this.f47039e = 1;
                objArr[i] = objArr2;
                this.f47038d = objArr2;
            } else {
                objArr[i] = t;
                this.f47039e = i + 1;
            }
            this.f47036b++;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public int size() {
            return this.f47036b;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public T[] toArray(T[] tArr) {
            int i = this.f47036b;
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            Object[] objArr = this.f47037c;
            int i2 = this.f47035a;
            int i3 = 0;
            while (true) {
                int i4 = i3 + i2;
                if (i4 >= i) {
                    break;
                }
                System.arraycopy(objArr, 0, tArr, i3, i2);
                objArr = objArr[i2];
                i3 = i4;
            }
            System.arraycopy(objArr, 0, tArr, i3, i - i3);
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // p640rx.subjects.ReplaySubject.InterfaceC16171a
        public Throwable error() {
            return this.f47041g;
        }
    }
}
