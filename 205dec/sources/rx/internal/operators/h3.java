package rx.internal.operators;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.CompositeException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSwitch.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h3<T> implements e.b<T, rx.e<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f62713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSwitch.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final h3<Object> f62714a = new h3<>(false);

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSwitch.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final h3<Object> f62715a = new h3<>(true);

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSwitch.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final long f62716a;

        /* renamed from: b  reason: collision with root package name */
        private final d<T> f62717b;

        c(long j4, d<T> dVar) {
            this.f62716a = j4;
            this.f62717b = dVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62717b.I(this.f62716a);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62717b.M(th, this.f62716a);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62717b.L(t3, this);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62717b.O(gVar, this.f62716a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSwitch.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> extends rx.l<rx.e<? extends T>> {

        /* renamed from: m  reason: collision with root package name */
        static final Throwable f62718m = new Throwable("Terminal error");

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62719a;

        /* renamed from: c  reason: collision with root package name */
        final boolean f62721c;

        /* renamed from: f  reason: collision with root package name */
        boolean f62724f;

        /* renamed from: g  reason: collision with root package name */
        boolean f62725g;

        /* renamed from: h  reason: collision with root package name */
        long f62726h;

        /* renamed from: i  reason: collision with root package name */
        rx.g f62727i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f62728j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f62729k;

        /* renamed from: l  reason: collision with root package name */
        boolean f62730l;

        /* renamed from: b  reason: collision with root package name */
        final rx.subscriptions.e f62720b = new rx.subscriptions.e();

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f62722d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        final rx.internal.util.atomic.e<Object> f62723e = new rx.internal.util.atomic.e<>(rx.internal.util.j.f63940d);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorSwitch.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                d.this.x();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorSwitch.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class b implements rx.g {
            b() {
            }

            @Override // rx.g
            public void request(long j4) {
                if (j4 > 0) {
                    d.this.v(j4);
                } else if (j4 >= 0) {
                } else {
                    throw new IllegalArgumentException("n >= 0 expected but it was " + j4);
                }
            }
        }

        d(rx.l<? super T> lVar, boolean z3) {
            this.f62719a = lVar;
            this.f62721c = z3;
        }

        void I(long j4) {
            synchronized (this) {
                if (this.f62722d.get() != j4) {
                    return;
                }
                this.f62730l = false;
                this.f62727i = null;
                J();
            }
        }

        void J() {
            Throwable th;
            Throwable th2;
            synchronized (this) {
                if (this.f62724f) {
                    this.f62725g = true;
                    return;
                }
                this.f62724f = true;
                boolean z3 = this.f62730l;
                long j4 = this.f62726h;
                Throwable th3 = this.f62729k;
                if (th3 != null && th3 != (th2 = f62718m) && !this.f62721c) {
                    this.f62729k = th2;
                }
                rx.internal.util.atomic.e<Object> eVar = this.f62723e;
                AtomicLong atomicLong = this.f62722d;
                rx.l<? super T> lVar = this.f62719a;
                long j5 = j4;
                Throwable th4 = th3;
                boolean z4 = this.f62728j;
                while (true) {
                    long j6 = 0;
                    while (j6 != j5) {
                        if (lVar.isUnsubscribed()) {
                            return;
                        }
                        boolean isEmpty = eVar.isEmpty();
                        if (g(z4, z3, th4, eVar, lVar, isEmpty)) {
                            return;
                        }
                        if (isEmpty) {
                            break;
                        }
                        Object obj = (Object) v.e(eVar.poll());
                        if (atomicLong.get() == ((c) eVar.poll()).f62716a) {
                            lVar.onNext(obj);
                            j6++;
                        }
                    }
                    if (j6 == j5) {
                        if (lVar.isUnsubscribed()) {
                            return;
                        }
                        if (g(this.f62728j, z3, th4, eVar, lVar, eVar.isEmpty())) {
                            return;
                        }
                    }
                    synchronized (this) {
                        long j7 = this.f62726h;
                        if (j7 != Long.MAX_VALUE) {
                            j7 -= j6;
                            this.f62726h = j7;
                        }
                        j5 = j7;
                        if (!this.f62725g) {
                            this.f62724f = false;
                            return;
                        }
                        this.f62725g = false;
                        z4 = this.f62728j;
                        z3 = this.f62730l;
                        th4 = this.f62729k;
                        if (th4 != null && th4 != (th = f62718m) && !this.f62721c) {
                            this.f62729k = th;
                        }
                    }
                }
            }
        }

        void L(T t3, c<T> cVar) {
            synchronized (this) {
                if (this.f62722d.get() != ((c) cVar).f62716a) {
                    return;
                }
                this.f62723e.s(cVar, v.j(t3));
                J();
            }
        }

        void M(Throwable th, long j4) {
            boolean z3;
            synchronized (this) {
                if (this.f62722d.get() == j4) {
                    z3 = R(th);
                    this.f62730l = false;
                    this.f62727i = null;
                } else {
                    z3 = true;
                }
            }
            if (z3) {
                J();
            } else {
                Q(th);
            }
        }

        void N() {
            this.f62719a.add(this.f62720b);
            this.f62719a.add(rx.subscriptions.f.a(new a()));
            this.f62719a.setProducer(new b());
        }

        void O(rx.g gVar, long j4) {
            synchronized (this) {
                if (this.f62722d.get() != j4) {
                    return;
                }
                long j5 = this.f62726h;
                this.f62727i = gVar;
                gVar.request(j5);
            }
        }

        @Override // rx.f
        /* renamed from: P */
        public void onNext(rx.e<? extends T> eVar) {
            c cVar;
            long incrementAndGet = this.f62722d.incrementAndGet();
            rx.m a4 = this.f62720b.a();
            if (a4 != null) {
                a4.unsubscribe();
            }
            synchronized (this) {
                cVar = new c(incrementAndGet, this);
                this.f62730l = true;
                this.f62727i = null;
            }
            this.f62720b.b(cVar);
            eVar.I6(cVar);
        }

        void Q(Throwable th) {
            rx.plugins.c.I(th);
        }

        boolean R(Throwable th) {
            Throwable th2 = this.f62729k;
            if (th2 == f62718m) {
                return false;
            }
            if (th2 == null) {
                this.f62729k = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                this.f62729k = new CompositeException(arrayList);
            } else {
                this.f62729k = new CompositeException(th2, th);
            }
            return true;
        }

        protected boolean g(boolean z3, boolean z4, Throwable th, rx.internal.util.atomic.e<Object> eVar, rx.l<? super T> lVar, boolean z5) {
            if (this.f62721c) {
                if (z3 && !z4 && z5) {
                    if (th != null) {
                        lVar.onError(th);
                    } else {
                        lVar.onCompleted();
                    }
                    return true;
                }
                return false;
            } else if (th != null) {
                eVar.clear();
                lVar.onError(th);
                return true;
            } else if (z3 && !z4 && z5) {
                lVar.onCompleted();
                return true;
            } else {
                return false;
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62728j = true;
            J();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            boolean R;
            synchronized (this) {
                R = R(th);
            }
            if (R) {
                this.f62728j = true;
                J();
                return;
            }
            Q(th);
        }

        void v(long j4) {
            rx.g gVar;
            synchronized (this) {
                gVar = this.f62727i;
                this.f62726h = rx.internal.operators.a.a(this.f62726h, j4);
            }
            if (gVar != null) {
                gVar.request(j4);
            }
            J();
        }

        void x() {
            synchronized (this) {
                this.f62727i = null;
            }
        }
    }

    h3(boolean z3) {
        this.f62713a = z3;
    }

    public static <T> h3<T> a(boolean z3) {
        if (z3) {
            return (h3<T>) b.f62715a;
        }
        return (h3<T>) a.f62714a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super rx.e<? extends T>> call(rx.l<? super T> lVar) {
        d dVar = new d(lVar, this.f62713a);
        lVar.add(dVar);
        dVar.N();
        return dVar;
    }
}
