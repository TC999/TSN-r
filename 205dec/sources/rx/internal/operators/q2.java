package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorOnBackpressureLatest.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q2<T> implements e.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnBackpressureLatest.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final q2<Object> f63169a = new q2<>();

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnBackpressureLatest.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends AtomicLong implements rx.g, rx.m, rx.f<T> {

        /* renamed from: h  reason: collision with root package name */
        static final Object f63170h = new Object();

        /* renamed from: i  reason: collision with root package name */
        static final long f63171i = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f63172a;

        /* renamed from: b  reason: collision with root package name */
        c<? super T> f63173b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Object> f63174c = new AtomicReference<>(f63170h);

        /* renamed from: d  reason: collision with root package name */
        Throwable f63175d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f63176e;

        /* renamed from: f  reason: collision with root package name */
        boolean f63177f;

        /* renamed from: g  reason: collision with root package name */
        boolean f63178g;

        public b(rx.l<? super T> lVar) {
            this.f63172a = lVar;
            lazySet(-4611686018427387904L);
        }

        void c() {
            boolean z3;
            Object obj;
            synchronized (this) {
                boolean z4 = true;
                if (this.f63177f) {
                    this.f63178g = true;
                    return;
                }
                this.f63177f = true;
                this.f63178g = false;
                while (true) {
                    try {
                        long j4 = get();
                        if (j4 == Long.MIN_VALUE) {
                            return;
                        }
                        Object obj2 = this.f63174c.get();
                        if (j4 > 0 && obj2 != (obj = f63170h)) {
                            this.f63172a.onNext(obj2);
                            this.f63174c.compareAndSet(obj2, obj);
                            e(1L);
                            obj2 = obj;
                        }
                        if (obj2 == f63170h && this.f63176e) {
                            Throwable th = this.f63175d;
                            if (th != null) {
                                this.f63172a.onError(th);
                            } else {
                                this.f63172a.onCompleted();
                            }
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (!this.f63178g) {
                                        this.f63177f = false;
                                        return;
                                    }
                                    this.f63178g = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z4 = false;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            z3 = z4;
                            th = th4;
                            if (!z3) {
                                synchronized (this) {
                                    this.f63177f = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z3 = false;
                    }
                }
            }
        }

        long e(long j4) {
            long j5;
            long j6;
            do {
                j5 = get();
                if (j5 < 0) {
                    return j5;
                }
                j6 = j5 - j4;
            } while (!compareAndSet(j5, j6));
            return j6;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63176e = true;
            c();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63175d = th;
            this.f63176e = true;
            c();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63174c.lazySet(t3);
            c();
        }

        @Override // rx.g
        public void request(long j4) {
            long j5;
            long j6;
            if (j4 >= 0) {
                do {
                    j5 = get();
                    if (j5 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j5 == -4611686018427387904L) {
                        j6 = j4;
                    } else {
                        j6 = j5 + j4;
                        if (j6 < 0) {
                            j6 = Long.MAX_VALUE;
                        }
                    }
                } while (!compareAndSet(j5, j6));
                if (j5 == -4611686018427387904L) {
                    this.f63173b.g(Long.MAX_VALUE);
                }
                c();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnBackpressureLatest.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final b<T> f63179a;

        c(b<T> bVar) {
            this.f63179a = bVar;
        }

        void g(long j4) {
            request(j4);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63179a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63179a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63179a.onNext(t3);
        }

        @Override // rx.l
        public void onStart() {
            request(0L);
        }
    }

    public static <T> q2<T> a() {
        return (q2<T>) a.f63169a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar);
        c<? super T> cVar = new c<>(bVar);
        bVar.f63173b = cVar;
        lVar.add(cVar);
        lVar.add(bVar);
        lVar.setProducer(bVar);
        return cVar;
    }
}
