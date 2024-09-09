package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.functions.m;
import rx.internal.operators.v;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SubjectSubscriptionManager.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
final class g<T> extends AtomicReference<b<T>> implements e.a<T> {
    private static final long serialVersionUID = 6035251036011671568L;

    /* renamed from: a  reason: collision with root package name */
    volatile Object f64314a;

    /* renamed from: b  reason: collision with root package name */
    boolean f64315b;

    /* renamed from: c  reason: collision with root package name */
    rx.functions.b<c<T>> f64316c;

    /* renamed from: d  reason: collision with root package name */
    rx.functions.b<c<T>> f64317d;

    /* renamed from: e  reason: collision with root package name */
    rx.functions.b<c<T>> f64318e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SubjectSubscriptionManager.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class a implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64319a;

        a(c cVar) {
            this.f64319a = cVar;
        }

        @Override // rx.functions.a
        public void call() {
            g.this.f(this.f64319a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SubjectSubscriptionManager.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b<T> {

        /* renamed from: c  reason: collision with root package name */
        static final c[] f64321c;

        /* renamed from: d  reason: collision with root package name */
        static final b f64322d;

        /* renamed from: e  reason: collision with root package name */
        static final b f64323e;

        /* renamed from: a  reason: collision with root package name */
        final boolean f64324a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f64325b;

        static {
            c[] cVarArr = new c[0];
            f64321c = cVarArr;
            f64322d = new b(true, cVarArr);
            f64323e = new b(false, cVarArr);
        }

        public b(boolean z3, c[] cVarArr) {
            this.f64324a = z3;
            this.f64325b = cVarArr;
        }

        public b a(c cVar) {
            c[] cVarArr = this.f64325b;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.f64324a, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.f64325b;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return f64323e;
            }
            if (length == 0) {
                return this;
            }
            int i4 = length - 1;
            c[] cVarArr2 = new c[i4];
            int i5 = 0;
            for (c cVar2 : cVarArr) {
                if (cVar2 != cVar) {
                    if (i5 == i4) {
                        return this;
                    }
                    cVarArr2[i5] = cVar2;
                    i5++;
                }
            }
            if (i5 == 0) {
                return f64323e;
            }
            if (i5 < i4) {
                c[] cVarArr3 = new c[i5];
                System.arraycopy(cVarArr2, 0, cVarArr3, 0, i5);
                cVarArr2 = cVarArr3;
            }
            return new b(this.f64324a, cVarArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SubjectSubscriptionManager.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c<T> implements rx.f<T> {

        /* renamed from: a  reason: collision with root package name */
        final l<? super T> f64326a;

        /* renamed from: b  reason: collision with root package name */
        boolean f64327b = true;

        /* renamed from: c  reason: collision with root package name */
        boolean f64328c;

        /* renamed from: d  reason: collision with root package name */
        List<Object> f64329d;

        /* renamed from: e  reason: collision with root package name */
        boolean f64330e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f64331f;

        /* renamed from: g  reason: collision with root package name */
        private volatile Object f64332g;

        public c(l<? super T> lVar) {
            this.f64326a = lVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void F(Object obj) {
            synchronized (this) {
                if (this.f64327b && !this.f64328c) {
                    this.f64327b = false;
                    this.f64328c = obj != null;
                    if (obj != null) {
                        G(null, obj);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void G(java.util.List<java.lang.Object> r5, java.lang.Object r6) {
            /*
                r4 = this;
                r0 = 1
                r1 = 1
            L2:
                r2 = 0
                if (r5 == 0) goto L1a
                java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L17
            L9:
                boolean r3 = r5.hasNext()     // Catch: java.lang.Throwable -> L17
                if (r3 == 0) goto L1a
                java.lang.Object r3 = r5.next()     // Catch: java.lang.Throwable -> L17
                r4.d(r3)     // Catch: java.lang.Throwable -> L17
                goto L9
            L17:
                r5 = move-exception
                r0 = 0
                goto L36
            L1a:
                if (r1 == 0) goto L20
                r4.d(r6)     // Catch: java.lang.Throwable -> L17
                r1 = 0
            L20:
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L17
                java.util.List<java.lang.Object> r5 = r4.f64329d     // Catch: java.lang.Throwable -> L2e
                r3 = 0
                r4.f64329d = r3     // Catch: java.lang.Throwable -> L2e
                if (r5 != 0) goto L2c
                r4.f64328c = r2     // Catch: java.lang.Throwable -> L2e
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L34
                return
            L2c:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L2e
                goto L2
            L2e:
                r5 = move-exception
                r0 = 0
            L30:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L34
                throw r5     // Catch: java.lang.Throwable -> L32
            L32:
                r5 = move-exception
                goto L36
            L34:
                r5 = move-exception
                goto L30
            L36:
                if (r0 != 0) goto L40
                monitor-enter(r4)
                r4.f64328c = r2     // Catch: java.lang.Throwable -> L3d
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                goto L40
            L3d:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                throw r5
            L40:
                goto L42
            L41:
                throw r5
            L42:
                goto L41
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.g.c.G(java.util.List, java.lang.Object):void");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void H(Object obj) {
            if (!this.f64330e) {
                synchronized (this) {
                    this.f64327b = false;
                    if (this.f64328c) {
                        if (this.f64329d == null) {
                            this.f64329d = new ArrayList();
                        }
                        this.f64329d.add(obj);
                        return;
                    }
                    this.f64330e = true;
                }
            }
            v.a(this.f64326a, obj);
        }

        rx.f<? super T> I() {
            return this.f64326a;
        }

        public <I> I J() {
            return (I) this.f64332g;
        }

        public void K(Object obj) {
            this.f64332g = obj;
        }

        void d(Object obj) {
            if (obj != null) {
                v.a(this.f64326a, obj);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64326a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64326a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64326a.onNext(t3);
        }
    }

    public g() {
        super(b.f64323e);
        this.f64315b = true;
        this.f64316c = m.a();
        this.f64317d = m.a();
        this.f64318e = m.a();
    }

    boolean a(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = get();
            if (bVar.f64324a) {
                this.f64318e.call(cVar);
                return false;
            }
        } while (!compareAndSet(bVar, bVar.a(cVar)));
        this.f64317d.call(cVar);
        return true;
    }

    void b(l<? super T> lVar, c<T> cVar) {
        lVar.add(rx.subscriptions.f.a(new a(cVar)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object c() {
        return this.f64314a;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<T>[] d(Object obj) {
        g(obj);
        return get().f64325b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<T>[] e() {
        return get().f64325b;
    }

    void f(c<T> cVar) {
        b<T> bVar;
        b<T> b4;
        do {
            bVar = get();
            if (bVar.f64324a || (b4 = bVar.b(cVar)) == bVar) {
                return;
            }
        } while (!compareAndSet(bVar, b4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Object obj) {
        this.f64314a = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<T>[] h(Object obj) {
        g(obj);
        this.f64315b = false;
        if (get().f64324a) {
            return b.f64321c;
        }
        return getAndSet(b.f64322d).f64325b;
    }

    public void call(l<? super T> lVar) {
        c<T> cVar = new c<>(lVar);
        b(lVar, cVar);
        this.f64316c.call(cVar);
        if (!lVar.isUnsubscribed() && a(cVar) && lVar.isUnsubscribed()) {
            f(cVar);
        }
    }
}
