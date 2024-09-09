package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.internal.util.ExceptionsUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeFlatMapSingle.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j0<T, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f62799a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.i<? extends R>> f62800b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f62801c;

    /* renamed from: d  reason: collision with root package name */
    final int f62802d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeFlatMapSingle.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f62803a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.i<? extends R>> f62804b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f62805c;

        /* renamed from: d  reason: collision with root package name */
        final int f62806d;

        /* renamed from: i  reason: collision with root package name */
        final Queue<Object> f62811i;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f62813k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f62814l;

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f62807e = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<Throwable> f62810h = new AtomicReference<>();

        /* renamed from: j  reason: collision with root package name */
        final a<T, R>.b f62812j = new b();

        /* renamed from: g  reason: collision with root package name */
        final rx.subscriptions.b f62809g = new rx.subscriptions.b();

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f62808f = new AtomicInteger();

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeFlatMapSingle.java */
        /* renamed from: rx.internal.operators.j0$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class C1284a extends rx.k<R> {
            C1284a() {
            }

            @Override // rx.k
            public void c(R r3) {
                a.this.x(this, r3);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                a.this.v(this, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeFlatMapSingle.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class b extends AtomicLong implements rx.g, rx.m {
            private static final long serialVersionUID = -887187595446742742L;

            b() {
            }

            void a(long j4) {
                rx.internal.operators.a.i(this, j4);
            }

            @Override // rx.m
            public boolean isUnsubscribed() {
                return a.this.f62814l;
            }

            @Override // rx.g
            public void request(long j4) {
                if (j4 > 0) {
                    rx.internal.operators.a.b(this, j4);
                    a.this.g();
                }
            }

            @Override // rx.m
            public void unsubscribe() {
                a.this.f62814l = true;
                a.this.unsubscribe();
                if (a.this.f62807e.getAndIncrement() == 0) {
                    a.this.f62811i.clear();
                }
            }
        }

        a(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends rx.i<? extends R>> pVar, boolean z3, int i4) {
            this.f62803a = lVar;
            this.f62804b = pVar;
            this.f62805c = z3;
            this.f62806d = i4;
            if (rx.internal.util.unsafe.n0.f()) {
                this.f62811i = new rx.internal.util.unsafe.o();
            } else {
                this.f62811i = new rx.internal.util.atomic.c();
            }
            request(i4 != Integer.MAX_VALUE ? i4 : Long.MAX_VALUE);
        }

        void g() {
            if (this.f62807e.getAndIncrement() != 0) {
                return;
            }
            rx.l<? super R> lVar = this.f62803a;
            Queue<Object> queue = this.f62811i;
            boolean z3 = this.f62805c;
            AtomicInteger atomicInteger = this.f62808f;
            int i4 = 1;
            do {
                long j4 = this.f62812j.get();
                long j5 = 0;
                while (j5 != j4) {
                    if (this.f62814l) {
                        queue.clear();
                        return;
                    }
                    boolean z4 = this.f62813k;
                    if (!z3 && z4 && this.f62810h.get() != null) {
                        queue.clear();
                        lVar.onError(ExceptionsUtils.terminate(this.f62810h));
                        return;
                    }
                    Object poll = queue.poll();
                    boolean z5 = poll == null;
                    if (z4 && atomicInteger.get() == 0 && z5) {
                        if (this.f62810h.get() != null) {
                            lVar.onError(ExceptionsUtils.terminate(this.f62810h));
                            return;
                        } else {
                            lVar.onCompleted();
                            return;
                        }
                    } else if (z5) {
                        break;
                    } else {
                        lVar.onNext((Object) v.e(poll));
                        j5++;
                    }
                }
                if (j5 == j4) {
                    if (this.f62814l) {
                        queue.clear();
                        return;
                    } else if (this.f62813k) {
                        if (z3) {
                            if (atomicInteger.get() == 0 && queue.isEmpty()) {
                                if (this.f62810h.get() != null) {
                                    lVar.onError(ExceptionsUtils.terminate(this.f62810h));
                                    return;
                                } else {
                                    lVar.onCompleted();
                                    return;
                                }
                            }
                        } else if (this.f62810h.get() != null) {
                            queue.clear();
                            lVar.onError(ExceptionsUtils.terminate(this.f62810h));
                            return;
                        } else if (atomicInteger.get() == 0 && queue.isEmpty()) {
                            lVar.onCompleted();
                            return;
                        }
                    }
                }
                if (j5 != 0) {
                    this.f62812j.a(j5);
                    if (!this.f62813k && this.f62806d != Integer.MAX_VALUE) {
                        request(j5);
                    }
                }
                i4 = this.f62807e.addAndGet(-i4);
            } while (i4 != 0);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62813k = true;
            g();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62805c) {
                ExceptionsUtils.addThrowable(this.f62810h, th);
            } else {
                this.f62809g.unsubscribe();
                if (!this.f62810h.compareAndSet(null, th)) {
                    rx.plugins.c.I(th);
                    return;
                }
            }
            this.f62813k = true;
            g();
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                rx.i<? extends R> call = this.f62804b.call(t3);
                if (call != null) {
                    C1284a c1284a = new C1284a();
                    this.f62809g.a(c1284a);
                    this.f62808f.incrementAndGet();
                    call.i0(c1284a);
                    return;
                }
                throw new NullPointerException("The mapper returned a null Single");
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }

        void v(a<T, R>.C1284a c1284a, Throwable th) {
            if (this.f62805c) {
                ExceptionsUtils.addThrowable(this.f62810h, th);
                this.f62809g.g(c1284a);
                if (!this.f62813k && this.f62806d != Integer.MAX_VALUE) {
                    request(1L);
                }
            } else {
                this.f62809g.unsubscribe();
                unsubscribe();
                if (!this.f62810h.compareAndSet(null, th)) {
                    rx.plugins.c.I(th);
                    return;
                }
                this.f62813k = true;
            }
            this.f62808f.decrementAndGet();
            g();
        }

        void x(a<T, R>.C1284a c1284a, R r3) {
            this.f62811i.offer(v.j(r3));
            this.f62809g.g(c1284a);
            this.f62808f.decrementAndGet();
            g();
        }
    }

    public j0(rx.e<T> eVar, rx.functions.p<? super T, ? extends rx.i<? extends R>> pVar, boolean z3, int i4) {
        if (pVar == null) {
            throw new NullPointerException("mapper is null");
        }
        if (i4 > 0) {
            this.f62799a = eVar;
            this.f62800b = pVar;
            this.f62801c = z3;
            this.f62802d = i4;
            return;
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i4);
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f62800b, this.f62801c, this.f62802d);
        lVar.add(aVar.f62809g);
        lVar.add(aVar.f62812j);
        lVar.setProducer(aVar.f62812j);
        this.f62799a.I6(aVar);
    }
}
