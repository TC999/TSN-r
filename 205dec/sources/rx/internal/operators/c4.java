package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorWindowWithTime.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c4<T> implements e.b<rx.e<T>, T> {

    /* renamed from: f  reason: collision with root package name */
    static final Object f62446f = new Object();

    /* renamed from: a  reason: collision with root package name */
    final long f62447a;

    /* renamed from: b  reason: collision with root package name */
    final long f62448b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f62449c;

    /* renamed from: d  reason: collision with root package name */
    final rx.h f62450d;

    /* renamed from: e  reason: collision with root package name */
    final int f62451e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithTime.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.f<T> f62452a;

        /* renamed from: b  reason: collision with root package name */
        final rx.e<T> f62453b;

        /* renamed from: c  reason: collision with root package name */
        int f62454c;

        public a(rx.f<T> fVar, rx.e<T> eVar) {
            this.f62452a = new rx.observers.f(fVar);
            this.f62453b = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithTime.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.e<T>> f62455a;

        /* renamed from: b  reason: collision with root package name */
        final h.a f62456b;

        /* renamed from: d  reason: collision with root package name */
        List<Object> f62458d;

        /* renamed from: e  reason: collision with root package name */
        boolean f62459e;

        /* renamed from: c  reason: collision with root package name */
        final Object f62457c = new Object();

        /* renamed from: f  reason: collision with root package name */
        volatile d<T> f62460f = d.c();

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorWindowWithTime.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c4 f62462a;

            a(c4 c4Var) {
                this.f62462a = c4Var;
            }

            @Override // rx.functions.a
            public void call() {
                if (b.this.f62460f.f62475a == null) {
                    b.this.unsubscribe();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorWindowWithTime.java */
        /* renamed from: rx.internal.operators.c4$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1277b implements rx.functions.a {
            C1277b() {
            }

            @Override // rx.functions.a
            public void call() {
                b.this.J();
            }
        }

        public b(rx.l<? super rx.e<T>> lVar, h.a aVar) {
            this.f62455a = new rx.observers.g(lVar);
            this.f62456b = aVar;
            lVar.add(rx.subscriptions.f.a(new a(c4.this)));
        }

        void I(Throwable th) {
            rx.f<T> fVar = this.f62460f.f62475a;
            this.f62460f = this.f62460f.a();
            if (fVar != null) {
                fVar.onError(th);
            }
            this.f62455a.onError(th);
            unsubscribe();
        }

        void J() {
            boolean z3;
            List<Object> list;
            synchronized (this.f62457c) {
                if (this.f62459e) {
                    if (this.f62458d == null) {
                        this.f62458d = new ArrayList();
                    }
                    this.f62458d.add(c4.f62446f);
                    return;
                }
                boolean z4 = true;
                this.f62459e = true;
                try {
                    if (!L()) {
                        synchronized (this.f62457c) {
                            this.f62459e = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.f62457c) {
                                try {
                                    list = this.f62458d;
                                    if (list == null) {
                                        this.f62459e = false;
                                        return;
                                    }
                                    this.f62458d = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z4 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        z3 = z4;
                                        th = th2;
                                        if (!z3) {
                                            synchronized (this.f62457c) {
                                                this.f62459e = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } while (v(list));
                    synchronized (this.f62457c) {
                        this.f62459e = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z3 = false;
                }
            }
        }

        boolean L() {
            rx.f<T> fVar = this.f62460f.f62475a;
            if (fVar != null) {
                fVar.onCompleted();
            }
            if (this.f62455a.isUnsubscribed()) {
                this.f62460f = this.f62460f.a();
                unsubscribe();
                return false;
            }
            rx.subjects.i x7 = rx.subjects.i.x7();
            this.f62460f = this.f62460f.b(x7, x7);
            this.f62455a.onNext(x7);
            return true;
        }

        void M() {
            h.a aVar = this.f62456b;
            C1277b c1277b = new C1277b();
            c4 c4Var = c4.this;
            aVar.g(c1277b, 0L, c4Var.f62447a, c4Var.f62449c);
        }

        void g() {
            rx.f<T> fVar = this.f62460f.f62475a;
            this.f62460f = this.f62460f.a();
            if (fVar != null) {
                fVar.onCompleted();
            }
            this.f62455a.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onCompleted() {
            synchronized (this.f62457c) {
                if (this.f62459e) {
                    if (this.f62458d == null) {
                        this.f62458d = new ArrayList();
                    }
                    this.f62458d.add(v.b());
                    return;
                }
                List<Object> list = this.f62458d;
                this.f62458d = null;
                this.f62459e = true;
                try {
                    v(list);
                    g();
                } catch (Throwable th) {
                    I(th);
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this.f62457c) {
                if (this.f62459e) {
                    this.f62458d = Collections.singletonList(v.c(th));
                    return;
                }
                this.f62458d = null;
                this.f62459e = true;
                I(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            List<Object> list;
            synchronized (this.f62457c) {
                if (this.f62459e) {
                    if (this.f62458d == null) {
                        this.f62458d = new ArrayList();
                    }
                    this.f62458d.add(t3);
                    return;
                }
                boolean z3 = true;
                this.f62459e = true;
                try {
                    if (!x(t3)) {
                        synchronized (this.f62457c) {
                            this.f62459e = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.f62457c) {
                                try {
                                    list = this.f62458d;
                                    if (list == null) {
                                        this.f62459e = false;
                                        return;
                                    }
                                    this.f62458d = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z3 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z3) {
                                            synchronized (this.f62457c) {
                                                this.f62459e = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } while (v(list));
                    synchronized (this.f62457c) {
                        this.f62459e = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z3 = false;
                }
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
            return true;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean v(java.util.List<java.lang.Object> r5) {
            /*
                r4 = this;
                r0 = 1
                if (r5 != 0) goto L4
                return r0
            L4:
                java.util.Iterator r5 = r5.iterator()
            L8:
                boolean r1 = r5.hasNext()
                if (r1 == 0) goto L3d
                java.lang.Object r1 = r5.next()
                java.lang.Object r2 = rx.internal.operators.c4.f62446f
                r3 = 0
                if (r1 != r2) goto L1e
                boolean r1 = r4.L()
                if (r1 != 0) goto L8
                return r3
            L1e:
                boolean r2 = rx.internal.operators.v.g(r1)
                if (r2 == 0) goto L2c
                java.lang.Throwable r5 = rx.internal.operators.v.d(r1)
                r4.I(r5)
                goto L3d
            L2c:
                boolean r2 = rx.internal.operators.v.f(r1)
                if (r2 == 0) goto L36
                r4.g()
                goto L3d
            L36:
                boolean r1 = r4.x(r1)
                if (r1 != 0) goto L8
                return r3
            L3d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.c4.b.v(java.util.List):boolean");
        }

        boolean x(T t3) {
            d<T> d4;
            d<T> dVar = this.f62460f;
            if (dVar.f62475a == null) {
                if (!L()) {
                    return false;
                }
                dVar = this.f62460f;
            }
            dVar.f62475a.onNext(t3);
            if (dVar.f62477c == c4.this.f62451e - 1) {
                dVar.f62475a.onCompleted();
                d4 = dVar.a();
            } else {
                d4 = dVar.d();
            }
            this.f62460f = d4;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithTime.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class c extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.e<T>> f62465a;

        /* renamed from: b  reason: collision with root package name */
        final h.a f62466b;

        /* renamed from: c  reason: collision with root package name */
        final Object f62467c;

        /* renamed from: d  reason: collision with root package name */
        final List<a<T>> f62468d;

        /* renamed from: e  reason: collision with root package name */
        boolean f62469e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorWindowWithTime.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                c.this.x();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorWindowWithTime.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class b implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f62472a;

            b(a aVar) {
                this.f62472a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                c.this.I(this.f62472a);
            }
        }

        public c(rx.l<? super rx.e<T>> lVar, h.a aVar) {
            super(lVar);
            this.f62465a = lVar;
            this.f62466b = aVar;
            this.f62467c = new Object();
            this.f62468d = new LinkedList();
        }

        void I(a<T> aVar) {
            boolean z3;
            synchronized (this.f62467c) {
                if (this.f62469e) {
                    return;
                }
                Iterator<a<T>> it = this.f62468d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    } else if (it.next() == aVar) {
                        z3 = true;
                        it.remove();
                        break;
                    }
                }
                if (z3) {
                    aVar.f62452a.onCompleted();
                }
            }
        }

        a<T> g() {
            rx.subjects.i x7 = rx.subjects.i.x7();
            return new a<>(x7, x7);
        }

        @Override // rx.f
        public void onCompleted() {
            synchronized (this.f62467c) {
                if (this.f62469e) {
                    return;
                }
                this.f62469e = true;
                ArrayList<a> arrayList = new ArrayList(this.f62468d);
                this.f62468d.clear();
                for (a aVar : arrayList) {
                    aVar.f62452a.onCompleted();
                }
                this.f62465a.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this.f62467c) {
                if (this.f62469e) {
                    return;
                }
                this.f62469e = true;
                ArrayList<a> arrayList = new ArrayList(this.f62468d);
                this.f62468d.clear();
                for (a aVar : arrayList) {
                    aVar.f62452a.onError(th);
                }
                this.f62465a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            synchronized (this.f62467c) {
                if (this.f62469e) {
                    return;
                }
                ArrayList<a> arrayList = new ArrayList(this.f62468d);
                Iterator<a<T>> it = this.f62468d.iterator();
                while (it.hasNext()) {
                    a<T> next = it.next();
                    int i4 = next.f62454c + 1;
                    next.f62454c = i4;
                    if (i4 == c4.this.f62451e) {
                        it.remove();
                    }
                }
                for (a aVar : arrayList) {
                    aVar.f62452a.onNext(t3);
                    if (aVar.f62454c == c4.this.f62451e) {
                        aVar.f62452a.onCompleted();
                    }
                }
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        void v() {
            h.a aVar = this.f62466b;
            a aVar2 = new a();
            c4 c4Var = c4.this;
            long j4 = c4Var.f62448b;
            aVar.g(aVar2, j4, j4, c4Var.f62449c);
        }

        void x() {
            a<T> g4 = g();
            synchronized (this.f62467c) {
                if (this.f62469e) {
                    return;
                }
                this.f62468d.add(g4);
                try {
                    this.f62465a.onNext(g4.f62453b);
                    h.a aVar = this.f62466b;
                    b bVar = new b(g4);
                    c4 c4Var = c4.this;
                    aVar.e(bVar, c4Var.f62447a, c4Var.f62449c);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithTime.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> {

        /* renamed from: d  reason: collision with root package name */
        static final d<Object> f62474d = new d<>(null, null, 0);

        /* renamed from: a  reason: collision with root package name */
        final rx.f<T> f62475a;

        /* renamed from: b  reason: collision with root package name */
        final rx.e<T> f62476b;

        /* renamed from: c  reason: collision with root package name */
        final int f62477c;

        public d(rx.f<T> fVar, rx.e<T> eVar, int i4) {
            this.f62475a = fVar;
            this.f62476b = eVar;
            this.f62477c = i4;
        }

        public static <T> d<T> c() {
            return (d<T>) f62474d;
        }

        public d<T> a() {
            return c();
        }

        public d<T> b(rx.f<T> fVar, rx.e<T> eVar) {
            return new d<>(fVar, eVar, 0);
        }

        public d<T> d() {
            return new d<>(this.f62475a, this.f62476b, this.f62477c + 1);
        }
    }

    public c4(long j4, long j5, TimeUnit timeUnit, int i4, rx.h hVar) {
        this.f62447a = j4;
        this.f62448b = j5;
        this.f62449c = timeUnit;
        this.f62451e = i4;
        this.f62450d = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        h.a a4 = this.f62450d.a();
        if (this.f62447a == this.f62448b) {
            b bVar = new b(lVar, a4);
            bVar.add(a4);
            bVar.M();
            return bVar;
        }
        c cVar = new c(lVar, a4);
        cVar.add(a4);
        cVar.x();
        cVar.v();
        return cVar;
    }
}
