package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorZip.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f4<R> implements e.b<R, rx.e<?>[]> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.y<? extends R> f62591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorZip.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<R> extends AtomicLong {

        /* renamed from: g  reason: collision with root package name */
        static final int f62592g;
        private static final long serialVersionUID = 5995274816189928317L;

        /* renamed from: a  reason: collision with root package name */
        final rx.f<? super R> f62593a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.functions.y<? extends R> f62594b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.subscriptions.b f62595c;

        /* renamed from: d  reason: collision with root package name */
        int f62596d;

        /* renamed from: e  reason: collision with root package name */
        private volatile Object[] f62597e;

        /* renamed from: f  reason: collision with root package name */
        private AtomicLong f62598f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorZip.java */
        /* renamed from: rx.internal.operators.f4$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class C1278a extends rx.l {

            /* renamed from: a  reason: collision with root package name */
            final rx.internal.util.j f62599a = rx.internal.util.j.v();

            C1278a() {
            }

            public void g(long j4) {
                request(j4);
            }

            @Override // rx.f
            public void onCompleted() {
                this.f62599a.N();
                a.this.b();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.f62593a.onError(th);
            }

            @Override // rx.f
            public void onNext(Object obj) {
                try {
                    this.f62599a.P(obj);
                } catch (MissingBackpressureException e4) {
                    onError(e4);
                }
                a.this.b();
            }

            @Override // rx.l
            public void onStart() {
                request(rx.internal.util.j.f63940d);
            }
        }

        static {
            double d4 = rx.internal.util.j.f63940d;
            Double.isNaN(d4);
            f62592g = (int) (d4 * 0.7d);
        }

        public a(rx.l<? super R> lVar, rx.functions.y<? extends R> yVar) {
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            this.f62595c = bVar;
            this.f62593a = lVar;
            this.f62594b = yVar;
            lVar.add(bVar);
        }

        public void a(rx.e[] eVarArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[eVarArr.length];
            for (int i4 = 0; i4 < eVarArr.length; i4++) {
                C1278a c1278a = new C1278a();
                objArr[i4] = c1278a;
                this.f62595c.a(c1278a);
            }
            this.f62598f = atomicLong;
            this.f62597e = objArr;
            for (int i5 = 0; i5 < eVarArr.length; i5++) {
                eVarArr[i5].I6((C1278a) objArr[i5]);
            }
        }

        void b() {
            Object[] objArr = this.f62597e;
            if (objArr == null || getAndIncrement() != 0) {
                return;
            }
            int length = objArr.length;
            rx.f<? super R> fVar = this.f62593a;
            AtomicLong atomicLong = this.f62598f;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z3 = true;
                for (int i4 = 0; i4 < length; i4++) {
                    rx.internal.util.j jVar = ((C1278a) objArr[i4]).f62599a;
                    Object Q = jVar.Q();
                    if (Q == null) {
                        z3 = false;
                    } else if (jVar.J(Q)) {
                        fVar.onCompleted();
                        this.f62595c.unsubscribe();
                        return;
                    } else {
                        objArr2[i4] = jVar.I(Q);
                    }
                }
                if (z3 && atomicLong.get() > 0) {
                    try {
                        fVar.onNext((R) this.f62594b.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.f62596d++;
                        for (Object obj : objArr) {
                            rx.internal.util.j jVar2 = ((C1278a) obj).f62599a;
                            jVar2.R();
                            if (jVar2.J(jVar2.Q())) {
                                fVar.onCompleted();
                                this.f62595c.unsubscribe();
                                return;
                            }
                        }
                        if (this.f62596d > f62592g) {
                            for (Object obj2 : objArr) {
                                ((C1278a) obj2).g(this.f62596d);
                            }
                            this.f62596d = 0;
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, fVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorZip.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<R> extends AtomicLong implements rx.g {
        private static final long serialVersionUID = -1216676403723546796L;

        /* renamed from: a  reason: collision with root package name */
        final a<R> f62601a;

        public b(a<R> aVar) {
            this.f62601a = aVar;
        }

        @Override // rx.g
        public void request(long j4) {
            rx.internal.operators.a.b(this, j4);
            this.f62601a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorZip.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class c extends rx.l<rx.e[]> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f62602a;

        /* renamed from: b  reason: collision with root package name */
        final a<R> f62603b;

        /* renamed from: c  reason: collision with root package name */
        final b<R> f62604c;

        /* renamed from: d  reason: collision with root package name */
        boolean f62605d;

        public c(rx.l<? super R> lVar, a<R> aVar, b<R> bVar) {
            this.f62602a = lVar;
            this.f62603b = aVar;
            this.f62604c = bVar;
        }

        @Override // rx.f
        /* renamed from: g */
        public void onNext(rx.e[] eVarArr) {
            if (eVarArr != null && eVarArr.length != 0) {
                this.f62605d = true;
                this.f62603b.a(eVarArr, this.f62604c);
                return;
            }
            this.f62602a.onCompleted();
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62605d) {
                return;
            }
            this.f62602a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62602a.onError(th);
        }
    }

    public f4(rx.functions.y<? extends R> yVar) {
        this.f62591a = yVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super rx.e[]> call(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f62591a);
        b bVar = new b(aVar);
        c cVar = new c(lVar, aVar, bVar);
        lVar.add(cVar);
        lVar.setProducer(bVar);
        return cVar;
    }

    public f4(rx.functions.q qVar) {
        this.f62591a = rx.functions.a0.g(qVar);
    }

    public f4(rx.functions.r rVar) {
        this.f62591a = rx.functions.a0.h(rVar);
    }

    public f4(rx.functions.s sVar) {
        this.f62591a = rx.functions.a0.i(sVar);
    }

    public f4(rx.functions.t tVar) {
        this.f62591a = rx.functions.a0.j(tVar);
    }

    public f4(rx.functions.u uVar) {
        this.f62591a = rx.functions.a0.k(uVar);
    }

    public f4(rx.functions.v vVar) {
        this.f62591a = rx.functions.a0.l(vVar);
    }

    public f4(rx.functions.w wVar) {
        this.f62591a = rx.functions.a0.m(wVar);
    }

    public f4(rx.functions.x xVar) {
        this.f62591a = rx.functions.a0.n(xVar);
    }
}
