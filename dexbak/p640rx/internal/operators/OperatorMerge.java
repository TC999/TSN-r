package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.CompositeException;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.exceptions.OnErrorThrowable;
import p640rx.internal.util.RxRingBuffer;
import p640rx.internal.util.ScalarSynchronousObservable;
import p640rx.internal.util.atomic.SpscAtomicArrayQueue;
import p640rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import p640rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import p640rx.internal.util.unsafe.C16092z;
import p640rx.internal.util.unsafe.Pow2;
import p640rx.internal.util.unsafe.UnsafeAccess;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.l2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorMerge<T> implements Observable.InterfaceC15568b<T, Observable<? extends T>> {

    /* renamed from: a */
    final boolean f45481a;

    /* renamed from: b */
    final int f45482b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* renamed from: rx.internal.operators.l2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15783a {

        /* renamed from: a */
        static final OperatorMerge<Object> f45483a = new OperatorMerge<>(true, Integer.MAX_VALUE);

        C15783a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* renamed from: rx.internal.operators.l2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15784b {

        /* renamed from: a */
        static final OperatorMerge<Object> f45484a = new OperatorMerge<>(false, Integer.MAX_VALUE);

        C15784b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* renamed from: rx.internal.operators.l2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15785c<T> extends Subscriber<T> {

        /* renamed from: f */
        static final int f45485f = RxRingBuffer.f46509d / 4;

        /* renamed from: a */
        final C15787e<T> f45486a;

        /* renamed from: b */
        final long f45487b;

        /* renamed from: c */
        volatile boolean f45488c;

        /* renamed from: d */
        volatile RxRingBuffer f45489d;

        /* renamed from: e */
        int f45490e;

        public C15785c(C15787e<T> c15787e, long j) {
            this.f45486a = c15787e;
            this.f45487b = j;
        }

        /* renamed from: F */
        public void m1176F(long j) {
            int i = this.f45490e - ((int) j);
            if (i > f45485f) {
                this.f45490e = i;
                return;
            }
            int i2 = RxRingBuffer.f46509d;
            this.f45490e = i2;
            int i3 = i2 - i;
            if (i3 > 0) {
                request(i3);
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45488c = true;
            this.f45486a.m1172H();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45488c = true;
            this.f45486a.m1166N().offer(th);
            this.f45486a.m1172H();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45486a.m1158V(this, t);
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            int i = RxRingBuffer.f46509d;
            this.f45490e = i;
            request(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* renamed from: rx.internal.operators.l2$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15786d<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;

        /* renamed from: a */
        final C15787e<T> f45491a;

        public C15786d(C15787e<T> c15787e) {
            this.f45491a = c15787e;
        }

        /* renamed from: a */
        public long m1175a(int i) {
            return addAndGet(-i);
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j <= 0) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else if (get() == Long.MAX_VALUE) {
            } else {
                BackpressureUtils.m1335b(this, j);
                this.f45491a.m1172H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* renamed from: rx.internal.operators.l2$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15787e<T> extends Subscriber<Observable<? extends T>> {

        /* renamed from: r */
        static final C15785c<?>[] f45492r = new C15785c[0];

        /* renamed from: a */
        final Subscriber<? super T> f45493a;

        /* renamed from: b */
        final boolean f45494b;

        /* renamed from: c */
        final int f45495c;

        /* renamed from: d */
        C15786d<T> f45496d;

        /* renamed from: e */
        volatile Queue<Object> f45497e;

        /* renamed from: f */
        volatile CompositeSubscription f45498f;

        /* renamed from: g */
        volatile ConcurrentLinkedQueue<Throwable> f45499g;

        /* renamed from: h */
        volatile boolean f45500h;

        /* renamed from: i */
        boolean f45501i;

        /* renamed from: j */
        boolean f45502j;

        /* renamed from: k */
        final Object f45503k = new Object();

        /* renamed from: l */
        volatile C15785c<?>[] f45504l = f45492r;

        /* renamed from: m */
        long f45505m;

        /* renamed from: n */
        long f45506n;

        /* renamed from: o */
        int f45507o;

        /* renamed from: p */
        final int f45508p;

        /* renamed from: q */
        int f45509q;

        public C15787e(Subscriber<? super T> subscriber, boolean z, int i) {
            this.f45493a = subscriber;
            this.f45494b = z;
            this.f45495c = i;
            if (i == Integer.MAX_VALUE) {
                this.f45508p = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
                return;
            }
            this.f45508p = Math.max(1, i >> 1);
            request(i);
        }

        /* renamed from: S */
        private void m1161S() {
            ArrayList arrayList = new ArrayList(this.f45499g);
            if (arrayList.size() == 1) {
                this.f45493a.onError((Throwable) arrayList.get(0));
            } else {
                this.f45493a.onError(new CompositeException(arrayList));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: F */
        void m1174F(C15785c<T> c15785c) {
            m1167M().m359a(c15785c);
            synchronized (this.f45503k) {
                C15785c<?>[] c15785cArr = this.f45504l;
                int length = c15785cArr.length;
                C15785c<?>[] c15785cArr2 = new C15785c[length + 1];
                System.arraycopy(c15785cArr, 0, c15785cArr2, 0, length);
                c15785cArr2[length] = c15785c;
                this.f45504l = c15785cArr2;
            }
        }

        /* renamed from: G */
        boolean m1173G() {
            if (this.f45493a.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f45499g;
            if (this.f45494b || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                m1161S();
                return true;
            } finally {
                unsubscribe();
            }
        }

        /* renamed from: H */
        void m1172H() {
            synchronized (this) {
                if (this.f45501i) {
                    this.f45502j = true;
                    return;
                }
                this.f45501i = true;
                m1170J();
            }
        }

        /* renamed from: I */
        void m1171I() {
            int i = this.f45509q + 1;
            if (i == this.f45508p) {
                this.f45509q = 0;
                m1160T(i);
                return;
            }
            this.f45509q = i;
        }

        /* renamed from: J */
        void m1170J() {
            boolean z;
            long j;
            int i;
            boolean z2;
            try {
                Subscriber<? super T> subscriber = this.f45493a;
                while (!m1173G()) {
                    Queue<Object> queue = this.f45497e;
                    long j2 = this.f45496d.get();
                    boolean z3 = j2 == Long.MAX_VALUE;
                    if (queue != null) {
                        int i2 = 0;
                        while (true) {
                            j = j2;
                            int i3 = 0;
                            i = i2;
                            Object obj = null;
                            while (true) {
                                if (j <= 0) {
                                    break;
                                }
                                Object poll = queue.poll();
                                if (m1173G()) {
                                    return;
                                }
                                if (poll == null) {
                                    obj = poll;
                                    break;
                                }
                                subscriber.onNext((Object) NotificationLite.m1048e(poll));
                                i++;
                                i3++;
                                j--;
                                obj = poll;
                            }
                            if (i3 > 0) {
                                j = z3 ? Long.MAX_VALUE : this.f45496d.m1175a(i3);
                            }
                            if (j == 0 || obj == null) {
                                break;
                            }
                            i2 = i;
                            j2 = j;
                        }
                    } else {
                        j = j2;
                        i = 0;
                    }
                    boolean z4 = this.f45500h;
                    Queue<Object> queue2 = this.f45497e;
                    C15785c<?>[] c15785cArr = this.f45504l;
                    int length = c15785cArr.length;
                    if (z4 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f45499g;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            m1161S();
                            return;
                        }
                        subscriber.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        long j3 = this.f45506n;
                        int i4 = this.f45507o;
                        if (length <= i4 || c15785cArr[i4].f45487b != j3) {
                            if (length <= i4) {
                                i4 = 0;
                            }
                            for (int i5 = 0; i5 < length && c15785cArr[i4].f45487b != j3; i5++) {
                                i4++;
                                if (i4 == length) {
                                    i4 = 0;
                                }
                            }
                            this.f45507o = i4;
                            this.f45506n = c15785cArr[i4].f45487b;
                        }
                        z2 = false;
                        for (int i6 = 0; i6 < length; i6++) {
                            if (m1173G()) {
                                return;
                            }
                            C15785c<?> c15785c = c15785cArr[i4];
                            Object obj2 = null;
                            do {
                                int i7 = 0;
                                while (j > 0) {
                                    if (m1173G()) {
                                        return;
                                    }
                                    RxRingBuffer rxRingBuffer = c15785c.f45489d;
                                    if (rxRingBuffer == null || (obj2 = rxRingBuffer.m824R()) == null) {
                                        break;
                                    }
                                    try {
                                        subscriber.onNext((Object) NotificationLite.m1048e(obj2));
                                        j--;
                                        i7++;
                                    }
                                }
                                if (i7 > 0) {
                                    j = !z3 ? this.f45496d.m1175a(i7) : Long.MAX_VALUE;
                                    c15785c.m1176F(i7);
                                }
                                if (j == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z5 = c15785c.f45488c;
                            RxRingBuffer rxRingBuffer2 = c15785c.f45489d;
                            if (z5 && (rxRingBuffer2 == null || rxRingBuffer2.m830L())) {
                                m1162R(c15785c);
                                if (m1173G()) {
                                    return;
                                }
                                i++;
                                z2 = true;
                            }
                            if (j == 0) {
                                break;
                            }
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.f45507o = i4;
                        this.f45506n = c15785cArr[i4].f45487b;
                    } else {
                        z2 = false;
                    }
                    if (i > 0) {
                        request(i);
                    }
                    if (!z2) {
                        synchronized (this) {
                            try {
                                if (!this.f45502j) {
                                    try {
                                        this.f45501i = false;
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        z = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.f45502j = false;
                            } catch (Throwable th3) {
                                th = th3;
                                z = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            if (!z) {
                                synchronized (this) {
                                    this.f45501i = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                z = false;
            }
        }

        /* renamed from: K */
        protected void m1169K(T t, long j) {
            try {
                this.f45493a.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.f45496d.m1175a(1);
                }
                int i = this.f45509q + 1;
                if (i == this.f45508p) {
                    this.f45509q = 0;
                    m1160T(i);
                } else {
                    this.f45509q = i;
                }
                synchronized (this) {
                    try {
                        if (!this.f45502j) {
                            this.f45501i = false;
                            return;
                        }
                        this.f45502j = false;
                        m1170J();
                    }
                }
            }
        }

        /* renamed from: L */
        protected void m1168L(C15785c<T> c15785c, T t, long j) {
            try {
                this.f45493a.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.f45496d.m1175a(1);
                }
                c15785c.m1176F(1L);
                synchronized (this) {
                    try {
                        if (!this.f45502j) {
                            this.f45501i = false;
                            return;
                        }
                        this.f45502j = false;
                        m1170J();
                    }
                }
            }
        }

        /* renamed from: M */
        CompositeSubscription m1167M() {
            CompositeSubscription compositeSubscription;
            CompositeSubscription compositeSubscription2 = this.f45498f;
            if (compositeSubscription2 == null) {
                boolean z = false;
                synchronized (this) {
                    compositeSubscription = this.f45498f;
                    if (compositeSubscription == null) {
                        CompositeSubscription compositeSubscription3 = new CompositeSubscription();
                        this.f45498f = compositeSubscription3;
                        compositeSubscription = compositeSubscription3;
                        z = true;
                    }
                }
                if (z) {
                    add(compositeSubscription);
                }
                return compositeSubscription;
            }
            return compositeSubscription2;
        }

        /* renamed from: N */
        Queue<Throwable> m1166N() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f45499g;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.f45499g;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.f45499g = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p640rx.Observer
        /* renamed from: O */
        public void onNext(Observable<? extends T> observable) {
            if (observable == null) {
                return;
            }
            if (observable == Observable.m1747S1()) {
                m1171I();
            } else if (observable instanceof ScalarSynchronousObservable) {
                m1159U(((ScalarSynchronousObservable) observable).m817x7());
            } else {
                long j = this.f45505m;
                this.f45505m = 1 + j;
                C15785c c15785c = new C15785c(this, j);
                m1174F(c15785c);
                observable.m1822I6(c15785c);
                m1172H();
            }
        }

        /* renamed from: P */
        protected void m1164P(T t) {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> queue = this.f45497e;
            if (queue == null) {
                int i = this.f45495c;
                if (i == Integer.MAX_VALUE) {
                    queue = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.f46509d);
                } else {
                    if (Pow2.m757a(i)) {
                        if (UnsafeAccess.m759f()) {
                            spscExactAtomicArrayQueue = new C16092z<>(i);
                        } else {
                            spscExactAtomicArrayQueue = new SpscAtomicArrayQueue<>(i);
                        }
                    } else {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i);
                    }
                    queue = spscExactAtomicArrayQueue;
                }
                this.f45497e = queue;
            }
            if (queue.offer(NotificationLite.m1043j(t))) {
                return;
            }
            unsubscribe();
            onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
        }

        /* renamed from: Q */
        protected void m1163Q(C15785c<T> c15785c, T t) {
            RxRingBuffer rxRingBuffer = c15785c.f45489d;
            if (rxRingBuffer == null) {
                rxRingBuffer = RxRingBuffer.m833I();
                c15785c.add(rxRingBuffer);
                c15785c.f45489d = rxRingBuffer;
            }
            try {
                rxRingBuffer.m826P(NotificationLite.m1043j(t));
            } catch (IllegalStateException e) {
                if (c15785c.isUnsubscribed()) {
                    return;
                }
                c15785c.unsubscribe();
                c15785c.onError(e);
            } catch (MissingBackpressureException e2) {
                c15785c.unsubscribe();
                c15785c.onError(e2);
            }
        }

        /* renamed from: R */
        void m1162R(C15785c<T> c15785c) {
            RxRingBuffer rxRingBuffer = c15785c.f45489d;
            if (rxRingBuffer != null) {
                rxRingBuffer.m823S();
            }
            this.f45498f.m361G(c15785c);
            synchronized (this.f45503k) {
                C15785c<?>[] c15785cArr = this.f45504l;
                int length = c15785cArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (c15785c.equals(c15785cArr[i2])) {
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
                    this.f45504l = f45492r;
                    return;
                }
                C15785c<?>[] c15785cArr2 = new C15785c[length - 1];
                System.arraycopy(c15785cArr, 0, c15785cArr2, 0, i);
                System.arraycopy(c15785cArr, i + 1, c15785cArr2, i, (length - i) - 1);
                this.f45504l = c15785cArr2;
            }
        }

        /* renamed from: T */
        public void m1160T(long j) {
            request(j);
        }

        /* renamed from: U */
        void m1159U(T t) {
            long j = this.f45496d.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.f45496d.get();
                    if (!this.f45501i && j != 0) {
                        this.f45501i = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue = this.f45497e;
                if (queue != null && !queue.isEmpty()) {
                    m1164P(t);
                    m1170J();
                    return;
                }
                m1169K(t, j);
                return;
            }
            m1164P(t);
            m1172H();
        }

        /* renamed from: V */
        void m1158V(C15785c<T> c15785c, T t) {
            long j = this.f45496d.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.f45496d.get();
                    if (!this.f45501i && j != 0) {
                        this.f45501i = true;
                        z = true;
                    }
                }
            }
            if (z) {
                RxRingBuffer rxRingBuffer = c15785c.f45489d;
                if (rxRingBuffer != null && !rxRingBuffer.m830L()) {
                    m1163Q(c15785c, t);
                    m1170J();
                    return;
                }
                m1168L(c15785c, t, j);
                return;
            }
            m1163Q(c15785c, t);
            m1172H();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45500h = true;
            m1172H();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            m1166N().offer(th);
            this.f45500h = true;
            m1172H();
        }
    }

    OperatorMerge(boolean z, int i) {
        this.f45481a = z;
        this.f45482b = i;
    }

    /* renamed from: a */
    public static <T> OperatorMerge<T> m1178a(boolean z) {
        if (z) {
            return (OperatorMerge<T>) C15783a.f45483a;
        }
        return (OperatorMerge<T>) C15784b.f45484a;
    }

    /* renamed from: b */
    public static <T> OperatorMerge<T> m1177b(boolean z, int i) {
        if (i > 0) {
            if (i == Integer.MAX_VALUE) {
                return m1178a(z);
            }
            return new OperatorMerge<>(z, i);
        }
        throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i);
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        C15787e c15787e = new C15787e(subscriber, this.f45481a, this.f45482b);
        C15786d<T> c15786d = new C15786d<>(c15787e);
        c15787e.f45496d = c15786d;
        subscriber.add(c15787e);
        subscriber.setProducer(c15786d);
        return c15787e;
    }
}
