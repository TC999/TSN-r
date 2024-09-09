package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CachedObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h<T> extends rx.e<T> {

    /* renamed from: b  reason: collision with root package name */
    private final a<T> f62683b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CachedObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.internal.util.f implements rx.f<T> {

        /* renamed from: k  reason: collision with root package name */
        static final c<?>[] f62684k = new c[0];

        /* renamed from: f  reason: collision with root package name */
        final rx.e<? extends T> f62685f;

        /* renamed from: g  reason: collision with root package name */
        final rx.subscriptions.e f62686g;

        /* renamed from: h  reason: collision with root package name */
        volatile c<?>[] f62687h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f62688i;

        /* renamed from: j  reason: collision with root package name */
        boolean f62689j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CachedObservable.java */
        /* renamed from: rx.internal.operators.h$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1281a extends rx.l<T> {
            C1281a() {
            }

            @Override // rx.f
            public void onCompleted() {
                a.this.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.onError(th);
            }

            @Override // rx.f
            public void onNext(T t3) {
                a.this.onNext(t3);
            }
        }

        public a(rx.e<? extends T> eVar, int i4) {
            super(i4);
            this.f62685f = eVar;
            this.f62687h = f62684k;
            this.f62686g = new rx.subscriptions.e();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void L(c<T> cVar) {
            synchronized (this.f62686g) {
                c<?>[] cVarArr = this.f62687h;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.f62687h = cVarArr2;
            }
        }

        public void M() {
            C1281a c1281a = new C1281a();
            this.f62686g.b(c1281a);
            this.f62685f.I6(c1281a);
            this.f62688i = true;
        }

        void N() {
            for (c<?> cVar : this.f62687h) {
                cVar.b();
            }
        }

        public void O(c<T> cVar) {
            synchronized (this.f62686g) {
                c<?>[] cVarArr = this.f62687h;
                int length = cVarArr.length;
                int i4 = -1;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    } else if (cVarArr[i5].equals(cVar)) {
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
                    this.f62687h = f62684k;
                    return;
                }
                c<?>[] cVarArr2 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i4);
                System.arraycopy(cVarArr, i4 + 1, cVarArr2, i4, (length - i4) - 1);
                this.f62687h = cVarArr2;
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62689j) {
                return;
            }
            this.f62689j = true;
            c(v.b());
            this.f62686g.unsubscribe();
            N();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62689j) {
                return;
            }
            this.f62689j = true;
            c(v.c(th));
            this.f62686g.unsubscribe();
            N();
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62689j) {
                return;
            }
            c(v.j(t3));
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CachedObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends AtomicBoolean implements e.a<T> {
        private static final long serialVersionUID = -2817751667698696782L;

        /* renamed from: a  reason: collision with root package name */
        final a<T> f62691a;

        public b(a<T> aVar) {
            this.f62691a = aVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            c<T> cVar = new c<>(lVar, this.f62691a);
            this.f62691a.L(cVar);
            lVar.add(cVar);
            lVar.setProducer(cVar);
            if (get() || !compareAndSet(false, true)) {
                return;
            }
            this.f62691a.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CachedObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends AtomicLong implements rx.g, rx.m {
        private static final long serialVersionUID = -2557562030197141021L;

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62692a;

        /* renamed from: b  reason: collision with root package name */
        final a<T> f62693b;

        /* renamed from: c  reason: collision with root package name */
        Object[] f62694c;

        /* renamed from: d  reason: collision with root package name */
        int f62695d;

        /* renamed from: e  reason: collision with root package name */
        int f62696e;

        /* renamed from: f  reason: collision with root package name */
        boolean f62697f;

        /* renamed from: g  reason: collision with root package name */
        boolean f62698g;

        public c(rx.l<? super T> lVar, a<T> aVar) {
            this.f62692a = lVar;
            this.f62693b = aVar;
        }

        public long a(long j4) {
            return addAndGet(-j4);
        }

        /* JADX WARN: Removed duplicated region for block: B:88:0x00df  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b() {
            /*
                Method dump skipped, instructions count: 237
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.h.c.b():void");
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // rx.g
        public void request(long j4) {
            long j5;
            long j6;
            do {
                j5 = get();
                if (j5 < 0) {
                    return;
                }
                j6 = j5 + j4;
                if (j6 < 0) {
                    j6 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j5, j6));
            b();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (get() < 0 || getAndSet(-1L) < 0) {
                return;
            }
            this.f62693b.O(this);
        }
    }

    private h(e.a<T> aVar, a<T> aVar2) {
        super(aVar);
        this.f62683b = aVar2;
    }

    public static <T> h<T> v7(rx.e<? extends T> eVar) {
        return w7(eVar, 16);
    }

    public static <T> h<T> w7(rx.e<? extends T> eVar, int i4) {
        if (i4 >= 1) {
            a aVar = new a(eVar, i4);
            return new h<>(new b(aVar), aVar);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }

    boolean x7() {
        return this.f62683b.f62687h.length != 0;
    }

    boolean y7() {
        return this.f62683b.f62688i;
    }
}
