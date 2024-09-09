package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorEagerConcatMap.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e2<T, R> implements e.b<R, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<? extends R>> f62525a;

    /* renamed from: b  reason: collision with root package name */
    final int f62526b;

    /* renamed from: c  reason: collision with root package name */
    private final int f62527c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorEagerConcatMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final c<?, T> f62528a;

        /* renamed from: b  reason: collision with root package name */
        final Queue<Object> f62529b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f62530c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f62531d;

        public a(c<?, T> cVar, int i4) {
            Queue<Object> dVar;
            this.f62528a = cVar;
            if (rx.internal.util.unsafe.n0.f()) {
                dVar = new rx.internal.util.unsafe.z<>(i4);
            } else {
                dVar = new rx.internal.util.atomic.d<>(i4);
            }
            this.f62529b = dVar;
            request(i4);
        }

        void g(long j4) {
            request(j4);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62530c = true;
            this.f62528a.v();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62531d = th;
            this.f62530c = true;
            this.f62528a.v();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62529b.offer(v.j(t3));
            this.f62528a.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorEagerConcatMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends AtomicLong implements rx.g {
        private static final long serialVersionUID = -657299606803478389L;

        /* renamed from: a  reason: collision with root package name */
        final c<?, ?> f62532a;

        public b(c<?, ?> cVar) {
            this.f62532a = cVar;
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j4);
            } else if (j4 > 0) {
                rx.internal.operators.a.b(this, j4);
                this.f62532a.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorEagerConcatMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.e<? extends R>> f62533a;

        /* renamed from: b  reason: collision with root package name */
        final int f62534b;

        /* renamed from: c  reason: collision with root package name */
        final rx.l<? super R> f62535c;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f62537e;

        /* renamed from: f  reason: collision with root package name */
        Throwable f62538f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f62539g;

        /* renamed from: i  reason: collision with root package name */
        private b f62541i;

        /* renamed from: d  reason: collision with root package name */
        final Queue<a<R>> f62536d = new LinkedList();

        /* renamed from: h  reason: collision with root package name */
        final AtomicInteger f62540h = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorEagerConcatMap.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                c.this.f62539g = true;
                if (c.this.f62540h.getAndIncrement() == 0) {
                    c.this.g();
                }
            }
        }

        public c(rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar, int i4, int i5, rx.l<? super R> lVar) {
            this.f62533a = pVar;
            this.f62534b = i4;
            this.f62535c = lVar;
            request(i5 == Integer.MAX_VALUE ? Long.MAX_VALUE : i5);
        }

        void g() {
            ArrayList<rx.m> arrayList;
            synchronized (this.f62536d) {
                arrayList = new ArrayList(this.f62536d);
                this.f62536d.clear();
            }
            for (rx.m mVar : arrayList) {
                mVar.unsubscribe();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62537e = true;
            v();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62538f = th;
            this.f62537e = true;
            v();
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                rx.e<? extends R> call = this.f62533a.call(t3);
                if (this.f62539g) {
                    return;
                }
                a<R> aVar = new a<>(this, this.f62534b);
                synchronized (this.f62536d) {
                    if (this.f62539g) {
                        return;
                    }
                    this.f62536d.add(aVar);
                    if (this.f62539g) {
                        return;
                    }
                    call.I6(aVar);
                    v();
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this.f62535c, t3);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x0087, code lost:
            if (r12 == 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0090, code lost:
            if (r8 == Long.MAX_VALUE) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0092, code lost:
            rx.internal.operators.a.i(r0, r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
            if (r6 != false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0097, code lost:
            r7.g(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009a, code lost:
            if (r6 == false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x009c, code lost:
            r4 = r17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void v() {
            /*
                Method dump skipped, instructions count: 198
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.e2.c.v():void");
        }

        void x() {
            this.f62541i = new b(this);
            add(rx.subscriptions.f.a(new a()));
            this.f62535c.add(this);
            this.f62535c.setProducer(this.f62541i);
        }
    }

    public e2(rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar, int i4, int i5) {
        this.f62525a = pVar;
        this.f62526b = i4;
        this.f62527c = i5;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super R> lVar) {
        c cVar = new c(this.f62525a, this.f62526b, this.f62527c, lVar);
        cVar.x();
        return cVar;
    }
}
