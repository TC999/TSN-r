package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorScan.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x2<R, T> implements e.b<R, T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f63575c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final rx.functions.o<R> f63576a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.q<R, ? super T, R> f63577b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorScan.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements rx.functions.o<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f63578a;

        a(Object obj) {
            this.f63578a = obj;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public R call() {
            return (R) this.f63578a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorScan.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f63579a;

        /* renamed from: b  reason: collision with root package name */
        R f63580b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.l f63581c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f63581c = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63581c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63581c.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            R r3;
            if (!this.f63579a) {
                this.f63579a = true;
                r3 = t3;
            } else {
                try {
                    r3 = x2.this.f63577b.call(this.f63580b, t3);
                } catch (Throwable th) {
                    rx.exceptions.a.g(th, this.f63581c, t3);
                    return;
                }
            }
            this.f63580b = r3;
            this.f63581c.onNext(r3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorScan.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class c extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private R f63583a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f63584b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f63585c;

        /* JADX WARN: Multi-variable type inference failed */
        c(Object obj, d dVar) {
            this.f63584b = obj;
            this.f63585c = dVar;
            this.f63583a = obj;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63585c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63585c.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                R call = x2.this.f63577b.call(this.f63583a, t3);
                this.f63583a = call;
                this.f63585c.onNext(call);
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this, t3);
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f63585c.setProducer(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorScan.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<R> implements rx.g, rx.f<R> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f63587a;

        /* renamed from: b  reason: collision with root package name */
        final Queue<Object> f63588b;

        /* renamed from: c  reason: collision with root package name */
        boolean f63589c;

        /* renamed from: d  reason: collision with root package name */
        boolean f63590d;

        /* renamed from: e  reason: collision with root package name */
        long f63591e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f63592f;

        /* renamed from: g  reason: collision with root package name */
        volatile rx.g f63593g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f63594h;

        /* renamed from: i  reason: collision with root package name */
        Throwable f63595i;

        public d(R r3, rx.l<? super R> lVar) {
            Queue<Object> fVar;
            this.f63587a = lVar;
            if (rx.internal.util.unsafe.n0.f()) {
                fVar = new rx.internal.util.unsafe.g0<>();
            } else {
                fVar = new rx.internal.util.atomic.f<>();
            }
            this.f63588b = fVar;
            fVar.offer(v.j(r3));
            this.f63592f = new AtomicLong();
        }

        boolean c(boolean z3, boolean z4, rx.l<? super R> lVar) {
            if (lVar.isUnsubscribed()) {
                return true;
            }
            if (z3) {
                Throwable th = this.f63595i;
                if (th != null) {
                    lVar.onError(th);
                    return true;
                } else if (z4) {
                    lVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        void e() {
            synchronized (this) {
                if (this.f63589c) {
                    this.f63590d = true;
                    return;
                }
                this.f63589c = true;
                g();
            }
        }

        void g() {
            rx.l<? super R> lVar = this.f63587a;
            Queue<Object> queue = this.f63588b;
            AtomicLong atomicLong = this.f63592f;
            long j4 = atomicLong.get();
            while (!c(this.f63594h, queue.isEmpty(), lVar)) {
                long j5 = 0;
                while (j5 != j4) {
                    boolean z3 = this.f63594h;
                    Object poll = queue.poll();
                    boolean z4 = poll == null;
                    if (c(z3, z4, lVar)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    Object obj = (Object) v.e(poll);
                    try {
                        lVar.onNext(obj);
                        j5++;
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, lVar, obj);
                        return;
                    }
                }
                if (j5 != 0 && j4 != Long.MAX_VALUE) {
                    j4 = rx.internal.operators.a.i(atomicLong, j5);
                }
                synchronized (this) {
                    if (!this.f63590d) {
                        this.f63589c = false;
                        return;
                    }
                    this.f63590d = false;
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63594h = true;
            e();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63595i = th;
            this.f63594h = true;
            e();
        }

        @Override // rx.f
        public void onNext(R r3) {
            this.f63588b.offer(v.j(r3));
            e();
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j4);
            } else if (j4 != 0) {
                rx.internal.operators.a.b(this.f63592f, j4);
                rx.g gVar = this.f63593g;
                if (gVar == null) {
                    synchronized (this.f63592f) {
                        gVar = this.f63593g;
                        if (gVar == null) {
                            this.f63591e = rx.internal.operators.a.a(this.f63591e, j4);
                        }
                    }
                }
                if (gVar != null) {
                    gVar.request(j4);
                }
                e();
            }
        }

        public void setProducer(rx.g gVar) {
            long j4;
            gVar.getClass();
            synchronized (this.f63592f) {
                if (this.f63593g == null) {
                    j4 = this.f63591e;
                    if (j4 != Long.MAX_VALUE) {
                        j4--;
                    }
                    this.f63591e = 0L;
                    this.f63593g = gVar;
                } else {
                    throw new IllegalStateException("Can't set more than one Producer!");
                }
            }
            if (j4 > 0) {
                gVar.request(j4);
            }
            e();
        }
    }

    public x2(R r3, rx.functions.q<R, ? super T, R> qVar) {
        this((rx.functions.o) new a(r3), (rx.functions.q) qVar);
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public x2(rx.functions.o<R> oVar, rx.functions.q<R, ? super T, R> qVar) {
        this.f63576a = oVar;
        this.f63577b = qVar;
    }

    public rx.l<? super T> call(rx.l<? super R> lVar) {
        R call = this.f63576a.call();
        if (call == f63575c) {
            return new b(lVar, lVar);
        }
        d dVar = new d(call, lVar);
        c cVar = new c(call, dVar);
        lVar.add(cVar);
        lVar.setProducer(dVar);
        return cVar;
    }

    public x2(rx.functions.q<R, ? super T, R> qVar) {
        this(f63575c, qVar);
    }
}
