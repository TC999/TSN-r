package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorMerge.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l2<T> implements e.b<T, rx.e<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f62912a;

    /* renamed from: b  reason: collision with root package name */
    final int f62913b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMerge.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final l2<Object> f62914a = new l2<>(true, Integer.MAX_VALUE);

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMerge.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final l2<Object> f62915a = new l2<>(false, Integer.MAX_VALUE);

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMerge.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends rx.l<T> {

        /* renamed from: f  reason: collision with root package name */
        static final int f62916f = rx.internal.util.j.f63940d / 4;

        /* renamed from: a  reason: collision with root package name */
        final e<T> f62917a;

        /* renamed from: b  reason: collision with root package name */
        final long f62918b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f62919c;

        /* renamed from: d  reason: collision with root package name */
        volatile rx.internal.util.j f62920d;

        /* renamed from: e  reason: collision with root package name */
        int f62921e;

        public c(e<T> eVar, long j4) {
            this.f62917a = eVar;
            this.f62918b = j4;
        }

        public void g(long j4) {
            int i4 = this.f62921e - ((int) j4);
            if (i4 > f62916f) {
                this.f62921e = i4;
                return;
            }
            int i5 = rx.internal.util.j.f63940d;
            this.f62921e = i5;
            int i6 = i5 - i4;
            if (i6 > 0) {
                request(i6);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62919c = true;
            this.f62917a.x();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62919c = true;
            this.f62917a.O().offer(th);
            this.f62917a.x();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62917a.W(this, t3);
        }

        @Override // rx.l
        public void onStart() {
            int i4 = rx.internal.util.j.f63940d;
            this.f62921e = i4;
            request(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMerge.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> extends AtomicLong implements rx.g {
        private static final long serialVersionUID = -1214379189873595503L;

        /* renamed from: a  reason: collision with root package name */
        final e<T> f62922a;

        public d(e<T> eVar) {
            this.f62922a = eVar;
        }

        public long a(int i4) {
            return addAndGet(-i4);
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 <= 0) {
                if (j4 < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else if (get() == Long.MAX_VALUE) {
            } else {
                rx.internal.operators.a.b(this, j4);
                this.f62922a.x();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMerge.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e<T> extends rx.l<rx.e<? extends T>> {

        /* renamed from: r  reason: collision with root package name */
        static final c<?>[] f62923r = new c[0];

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62924a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f62925b;

        /* renamed from: c  reason: collision with root package name */
        final int f62926c;

        /* renamed from: d  reason: collision with root package name */
        d<T> f62927d;

        /* renamed from: e  reason: collision with root package name */
        volatile Queue<Object> f62928e;

        /* renamed from: f  reason: collision with root package name */
        volatile rx.subscriptions.b f62929f;

        /* renamed from: g  reason: collision with root package name */
        volatile ConcurrentLinkedQueue<Throwable> f62930g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f62931h;

        /* renamed from: i  reason: collision with root package name */
        boolean f62932i;

        /* renamed from: j  reason: collision with root package name */
        boolean f62933j;

        /* renamed from: k  reason: collision with root package name */
        final Object f62934k = new Object();

        /* renamed from: l  reason: collision with root package name */
        volatile c<?>[] f62935l = f62923r;

        /* renamed from: m  reason: collision with root package name */
        long f62936m;

        /* renamed from: n  reason: collision with root package name */
        long f62937n;

        /* renamed from: o  reason: collision with root package name */
        int f62938o;

        /* renamed from: p  reason: collision with root package name */
        final int f62939p;

        /* renamed from: q  reason: collision with root package name */
        int f62940q;

        public e(rx.l<? super T> lVar, boolean z3, int i4) {
            this.f62924a = lVar;
            this.f62925b = z3;
            this.f62926c = i4;
            if (i4 == Integer.MAX_VALUE) {
                this.f62939p = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
                return;
            }
            this.f62939p = Math.max(1, i4 >> 1);
            request(i4);
        }

        private void T() {
            ArrayList arrayList = new ArrayList(this.f62930g);
            if (arrayList.size() == 1) {
                this.f62924a.onError((Throwable) arrayList.get(0));
            } else {
                this.f62924a.onError(new CompositeException(arrayList));
            }
        }

        void I() {
            int i4 = this.f62940q + 1;
            if (i4 == this.f62939p) {
                this.f62940q = 0;
                U(i4);
                return;
            }
            this.f62940q = i4;
        }

        void J() {
            boolean z3;
            long j4;
            int i4;
            boolean z4;
            try {
                rx.l<? super T> lVar = this.f62924a;
                while (!v()) {
                    Queue<Object> queue = this.f62928e;
                    long j5 = this.f62927d.get();
                    boolean z5 = j5 == Long.MAX_VALUE;
                    if (queue != null) {
                        int i5 = 0;
                        while (true) {
                            j4 = j5;
                            int i6 = 0;
                            i4 = i5;
                            Object obj = null;
                            while (true) {
                                if (j4 <= 0) {
                                    break;
                                }
                                Object poll = queue.poll();
                                if (v()) {
                                    return;
                                }
                                if (poll == null) {
                                    obj = poll;
                                    break;
                                }
                                lVar.onNext((Object) v.e(poll));
                                i4++;
                                i6++;
                                j4--;
                                obj = poll;
                            }
                            if (i6 > 0) {
                                j4 = z5 ? Long.MAX_VALUE : this.f62927d.a(i6);
                            }
                            if (j4 == 0 || obj == null) {
                                break;
                            }
                            i5 = i4;
                            j5 = j4;
                        }
                    } else {
                        j4 = j5;
                        i4 = 0;
                    }
                    boolean z6 = this.f62931h;
                    Queue<Object> queue2 = this.f62928e;
                    c<?>[] cVarArr = this.f62935l;
                    int length = cVarArr.length;
                    if (z6 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f62930g;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            T();
                            return;
                        }
                        lVar.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        long j6 = this.f62937n;
                        int i7 = this.f62938o;
                        if (length <= i7 || cVarArr[i7].f62918b != j6) {
                            if (length <= i7) {
                                i7 = 0;
                            }
                            for (int i8 = 0; i8 < length && cVarArr[i7].f62918b != j6; i8++) {
                                i7++;
                                if (i7 == length) {
                                    i7 = 0;
                                }
                            }
                            this.f62938o = i7;
                            this.f62937n = cVarArr[i7].f62918b;
                        }
                        z4 = false;
                        for (int i9 = 0; i9 < length; i9++) {
                            if (v()) {
                                return;
                            }
                            c<?> cVar = cVarArr[i7];
                            Object obj2 = null;
                            do {
                                int i10 = 0;
                                while (j4 > 0) {
                                    if (v()) {
                                        return;
                                    }
                                    rx.internal.util.j jVar = cVar.f62920d;
                                    if (jVar == null || (obj2 = jVar.R()) == null) {
                                        break;
                                    }
                                    try {
                                        lVar.onNext((Object) v.e(obj2));
                                        j4--;
                                        i10++;
                                    }
                                }
                                if (i10 > 0) {
                                    j4 = !z5 ? this.f62927d.a(i10) : Long.MAX_VALUE;
                                    cVar.g(i10);
                                }
                                if (j4 == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z7 = cVar.f62919c;
                            rx.internal.util.j jVar2 = cVar.f62920d;
                            if (z7 && (jVar2 == null || jVar2.L())) {
                                S(cVar);
                                if (v()) {
                                    return;
                                }
                                i4++;
                                z4 = true;
                            }
                            if (j4 == 0) {
                                break;
                            }
                            i7++;
                            if (i7 == length) {
                                i7 = 0;
                            }
                        }
                        this.f62938o = i7;
                        this.f62937n = cVarArr[i7].f62918b;
                    } else {
                        z4 = false;
                    }
                    if (i4 > 0) {
                        request(i4);
                    }
                    if (!z4) {
                        synchronized (this) {
                            try {
                                if (!this.f62933j) {
                                    try {
                                        this.f62932i = false;
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        z3 = true;
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
                                this.f62933j = false;
                            } catch (Throwable th3) {
                                th = th3;
                                z3 = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            if (!z3) {
                                synchronized (this) {
                                    this.f62932i = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                z3 = false;
            }
        }

        protected void L(T t3, long j4) {
            try {
                this.f62924a.onNext(t3);
                if (j4 != Long.MAX_VALUE) {
                    this.f62927d.a(1);
                }
                int i4 = this.f62940q + 1;
                if (i4 == this.f62939p) {
                    this.f62940q = 0;
                    U(i4);
                } else {
                    this.f62940q = i4;
                }
                synchronized (this) {
                    try {
                        if (!this.f62933j) {
                            this.f62932i = false;
                            return;
                        }
                        this.f62933j = false;
                        J();
                    }
                }
            }
        }

        protected void M(c<T> cVar, T t3, long j4) {
            try {
                this.f62924a.onNext(t3);
                if (j4 != Long.MAX_VALUE) {
                    this.f62927d.a(1);
                }
                cVar.g(1L);
                synchronized (this) {
                    try {
                        if (!this.f62933j) {
                            this.f62932i = false;
                            return;
                        }
                        this.f62933j = false;
                        J();
                    }
                }
            }
        }

        rx.subscriptions.b N() {
            rx.subscriptions.b bVar;
            rx.subscriptions.b bVar2 = this.f62929f;
            if (bVar2 == null) {
                boolean z3 = false;
                synchronized (this) {
                    bVar = this.f62929f;
                    if (bVar == null) {
                        rx.subscriptions.b bVar3 = new rx.subscriptions.b();
                        this.f62929f = bVar3;
                        bVar = bVar3;
                        z3 = true;
                    }
                }
                if (z3) {
                    add(bVar);
                }
                return bVar;
            }
            return bVar2;
        }

        Queue<Throwable> O() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f62930g;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.f62930g;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.f62930g = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        /* renamed from: P */
        public void onNext(rx.e<? extends T> eVar) {
            if (eVar == null) {
                return;
            }
            if (eVar == rx.e.S1()) {
                I();
            } else if (eVar instanceof rx.internal.util.k) {
                V(((rx.internal.util.k) eVar).x7());
            } else {
                long j4 = this.f62936m;
                this.f62936m = 1 + j4;
                c cVar = new c(this, j4);
                g(cVar);
                eVar.I6(cVar);
                x();
            }
        }

        protected void Q(T t3) {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> queue = this.f62928e;
            if (queue == null) {
                int i4 = this.f62926c;
                if (i4 == Integer.MAX_VALUE) {
                    queue = new rx.internal.util.atomic.g<>(rx.internal.util.j.f63940d);
                } else {
                    if (rx.internal.util.unsafe.p.a(i4)) {
                        if (rx.internal.util.unsafe.n0.f()) {
                            spscExactAtomicArrayQueue = new rx.internal.util.unsafe.z<>(i4);
                        } else {
                            spscExactAtomicArrayQueue = new rx.internal.util.atomic.d<>(i4);
                        }
                    } else {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i4);
                    }
                    queue = spscExactAtomicArrayQueue;
                }
                this.f62928e = queue;
            }
            if (queue.offer(v.j(t3))) {
                return;
            }
            unsubscribe();
            onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t3));
        }

        protected void R(c<T> cVar, T t3) {
            rx.internal.util.j jVar = cVar.f62920d;
            if (jVar == null) {
                jVar = rx.internal.util.j.x();
                cVar.add(jVar);
                cVar.f62920d = jVar;
            }
            try {
                jVar.P(v.j(t3));
            } catch (IllegalStateException e4) {
                if (cVar.isUnsubscribed()) {
                    return;
                }
                cVar.unsubscribe();
                cVar.onError(e4);
            } catch (MissingBackpressureException e5) {
                cVar.unsubscribe();
                cVar.onError(e5);
            }
        }

        void S(c<T> cVar) {
            rx.internal.util.j jVar = cVar.f62920d;
            if (jVar != null) {
                jVar.S();
            }
            this.f62929f.g(cVar);
            synchronized (this.f62934k) {
                c<?>[] cVarArr = this.f62935l;
                int length = cVarArr.length;
                int i4 = -1;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    } else if (cVar.equals(cVarArr[i5])) {
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
                    this.f62935l = f62923r;
                    return;
                }
                c<?>[] cVarArr2 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i4);
                System.arraycopy(cVarArr, i4 + 1, cVarArr2, i4, (length - i4) - 1);
                this.f62935l = cVarArr2;
            }
        }

        public void U(long j4) {
            request(j4);
        }

        void V(T t3) {
            long j4 = this.f62927d.get();
            boolean z3 = false;
            if (j4 != 0) {
                synchronized (this) {
                    j4 = this.f62927d.get();
                    if (!this.f62932i && j4 != 0) {
                        this.f62932i = true;
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Queue<Object> queue = this.f62928e;
                if (queue != null && !queue.isEmpty()) {
                    Q(t3);
                    J();
                    return;
                }
                L(t3, j4);
                return;
            }
            Q(t3);
            x();
        }

        void W(c<T> cVar, T t3) {
            long j4 = this.f62927d.get();
            boolean z3 = false;
            if (j4 != 0) {
                synchronized (this) {
                    j4 = this.f62927d.get();
                    if (!this.f62932i && j4 != 0) {
                        this.f62932i = true;
                        z3 = true;
                    }
                }
            }
            if (z3) {
                rx.internal.util.j jVar = cVar.f62920d;
                if (jVar != null && !jVar.L()) {
                    R(cVar, t3);
                    J();
                    return;
                }
                M(cVar, t3, j4);
                return;
            }
            R(cVar, t3);
            x();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g(c<T> cVar) {
            N().a(cVar);
            synchronized (this.f62934k) {
                c<?>[] cVarArr = this.f62935l;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.f62935l = cVarArr2;
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62931h = true;
            x();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            O().offer(th);
            this.f62931h = true;
            x();
        }

        boolean v() {
            if (this.f62924a.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f62930g;
            if (this.f62925b || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                T();
                return true;
            } finally {
                unsubscribe();
            }
        }

        void x() {
            synchronized (this) {
                if (this.f62932i) {
                    this.f62933j = true;
                    return;
                }
                this.f62932i = true;
                J();
            }
        }
    }

    l2(boolean z3, int i4) {
        this.f62912a = z3;
        this.f62913b = i4;
    }

    public static <T> l2<T> a(boolean z3) {
        if (z3) {
            return (l2<T>) a.f62914a;
        }
        return (l2<T>) b.f62915a;
    }

    public static <T> l2<T> b(boolean z3, int i4) {
        if (i4 > 0) {
            if (i4 == Integer.MAX_VALUE) {
                return a(z3);
            }
            return new l2<>(z3, i4);
        }
        throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i4);
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<rx.e<? extends T>> call(rx.l<? super T> lVar) {
        e eVar = new e(lVar, this.f62912a, this.f62913b);
        d<T> dVar = new d<>(eVar);
        eVar.f62927d = dVar;
        lVar.add(eVar);
        lVar.setProducer(dVar);
        return eVar;
    }
}
