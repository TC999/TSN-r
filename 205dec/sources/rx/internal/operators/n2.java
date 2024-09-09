package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorObserveOn.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n2<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.h f62996a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f62997b;

    /* renamed from: c  reason: collision with root package name */
    private final int f62998c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorObserveOn.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements e.b<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f62999a;

        a(int i4) {
            this.f62999a = i4;
        }

        @Override // rx.functions.p
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((rx.l) ((rx.l) obj));
        }

        public rx.l<? super T> call(rx.l<? super T> lVar) {
            b bVar = new b(rx.schedulers.c.d(), lVar, false, this.f62999a);
            bVar.v();
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorObserveOn.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f63000a;

        /* renamed from: b  reason: collision with root package name */
        final h.a f63001b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f63002c;

        /* renamed from: d  reason: collision with root package name */
        final Queue<Object> f63003d;

        /* renamed from: e  reason: collision with root package name */
        final int f63004e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f63005f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicLong f63006g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        final AtomicLong f63007h = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        Throwable f63008i;

        /* renamed from: j  reason: collision with root package name */
        long f63009j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorObserveOn.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.g {
            a() {
            }

            @Override // rx.g
            public void request(long j4) {
                if (j4 > 0) {
                    rx.internal.operators.a.b(b.this.f63006g, j4);
                    b.this.x();
                }
            }
        }

        public b(rx.h hVar, rx.l<? super T> lVar, boolean z3, int i4) {
            this.f63000a = lVar;
            this.f63001b = hVar.a();
            this.f63002c = z3;
            i4 = i4 <= 0 ? rx.internal.util.j.f63940d : i4;
            this.f63004e = i4 - (i4 >> 2);
            if (rx.internal.util.unsafe.n0.f()) {
                this.f63003d = new rx.internal.util.unsafe.z(i4);
            } else {
                this.f63003d = new rx.internal.util.atomic.d(i4);
            }
            request(i4);
        }

        @Override // rx.functions.a
        public void call() {
            long j4 = this.f63009j;
            Queue<Object> queue = this.f63003d;
            rx.l<? super T> lVar = this.f63000a;
            long j5 = 1;
            do {
                long j6 = this.f63006g.get();
                while (j6 != j4) {
                    boolean z3 = this.f63005f;
                    Object poll = queue.poll();
                    boolean z4 = poll == null;
                    if (g(z3, z4, lVar, queue)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    lVar.onNext((Object) v.e(poll));
                    j4++;
                    if (j4 == this.f63004e) {
                        j6 = rx.internal.operators.a.i(this.f63006g, j4);
                        request(j4);
                        j4 = 0;
                    }
                }
                if (j6 == j4 && g(this.f63005f, queue.isEmpty(), lVar, queue)) {
                    return;
                }
                this.f63009j = j4;
                j5 = this.f63007h.addAndGet(-j5);
            } while (j5 != 0);
        }

        boolean g(boolean z3, boolean z4, rx.l<? super T> lVar, Queue<Object> queue) {
            if (lVar.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (z3) {
                if (this.f63002c) {
                    if (z4) {
                        Throwable th = this.f63008i;
                        try {
                            if (th != null) {
                                lVar.onError(th);
                            } else {
                                lVar.onCompleted();
                            }
                            return false;
                        } finally {
                        }
                    }
                    return false;
                }
                Throwable th2 = this.f63008i;
                if (th2 != null) {
                    queue.clear();
                    try {
                        lVar.onError(th2);
                        return true;
                    } finally {
                    }
                } else if (z4) {
                    try {
                        lVar.onCompleted();
                        return true;
                    } finally {
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (isUnsubscribed() || this.f63005f) {
                return;
            }
            this.f63005f = true;
            x();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!isUnsubscribed() && !this.f63005f) {
                this.f63008i = th;
                this.f63005f = true;
                x();
                return;
            }
            rx.plugins.c.I(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (isUnsubscribed() || this.f63005f) {
                return;
            }
            if (!this.f63003d.offer(v.j(t3))) {
                onError(new MissingBackpressureException());
            } else {
                x();
            }
        }

        void v() {
            rx.l<? super T> lVar = this.f63000a;
            lVar.setProducer(new a());
            lVar.add(this.f63001b);
            lVar.add(this);
        }

        protected void x() {
            if (this.f63007h.getAndIncrement() == 0) {
                this.f63001b.c(this);
            }
        }
    }

    public n2(rx.h hVar, boolean z3) {
        this(hVar, z3, rx.internal.util.j.f63940d);
    }

    public static <T> e.b<T, T> a(int i4) {
        return new a(i4);
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public n2(rx.h hVar, boolean z3, int i4) {
        this.f62996a = hVar;
        this.f62997b = z3;
        this.f62998c = i4 <= 0 ? rx.internal.util.j.f63940d : i4;
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.h hVar = this.f62996a;
        if ((hVar instanceof rx.internal.schedulers.f) || (hVar instanceof rx.internal.schedulers.m)) {
            return lVar;
        }
        b bVar = new b(hVar, lVar, this.f62997b, this.f62998c);
        bVar.v();
        return bVar;
    }
}
