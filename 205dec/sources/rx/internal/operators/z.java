package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.ExceptionsUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeConcatMap.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z<T, R> implements e.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public static final int f63657e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f63658f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f63659g = 2;

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends T> f63660a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<? extends R>> f63661b;

    /* renamed from: c  reason: collision with root package name */
    final int f63662c;

    /* renamed from: d  reason: collision with root package name */
    final int f63663d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63664a;

        a(d dVar) {
            this.f63664a = dVar;
        }

        @Override // rx.g
        public void request(long j4) {
            this.f63664a.M(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T, R> implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final R f63666a;

        /* renamed from: b  reason: collision with root package name */
        final d<T, R> f63667b;

        /* renamed from: c  reason: collision with root package name */
        boolean f63668c;

        public b(R r3, d<T, R> dVar) {
            this.f63666a = r3;
            this.f63667b = dVar;
        }

        @Override // rx.g
        public void request(long j4) {
            if (this.f63668c || j4 <= 0) {
                return;
            }
            this.f63668c = true;
            d<T, R> dVar = this.f63667b;
            dVar.J(this.f63666a);
            dVar.x(1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T, R> extends rx.l<R> {

        /* renamed from: a  reason: collision with root package name */
        final d<T, R> f63669a;

        /* renamed from: b  reason: collision with root package name */
        long f63670b;

        public c(d<T, R> dVar) {
            this.f63669a = dVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63669a.x(this.f63670b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63669a.I(th, this.f63670b);
        }

        @Override // rx.f
        public void onNext(R r3) {
            this.f63670b++;
            this.f63669a.J(r3);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f63669a.f63674d.c(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f63671a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.e<? extends R>> f63672b;

        /* renamed from: c  reason: collision with root package name */
        final int f63673c;

        /* renamed from: e  reason: collision with root package name */
        final Queue<Object> f63675e;

        /* renamed from: h  reason: collision with root package name */
        final rx.subscriptions.e f63678h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f63679i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f63680j;

        /* renamed from: d  reason: collision with root package name */
        final rx.internal.producers.a f63674d = new rx.internal.producers.a();

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f63676f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Throwable> f63677g = new AtomicReference<>();

        public d(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar, int i4, int i5) {
            Queue<Object> dVar;
            this.f63671a = lVar;
            this.f63672b = pVar;
            this.f63673c = i5;
            if (rx.internal.util.unsafe.n0.f()) {
                dVar = new rx.internal.util.unsafe.z<>(i4);
            } else {
                dVar = new rx.internal.util.atomic.d<>(i4);
            }
            this.f63675e = dVar;
            this.f63678h = new rx.subscriptions.e();
            request(i4);
        }

        void I(Throwable th, long j4) {
            if (!ExceptionsUtils.addThrowable(this.f63677g, th)) {
                L(th);
            } else if (this.f63673c == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.f63677g);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.f63671a.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j4 != 0) {
                    this.f63674d.b(j4);
                }
                this.f63680j = false;
                g();
            }
        }

        void J(R r3) {
            this.f63671a.onNext(r3);
        }

        void L(Throwable th) {
            rx.plugins.c.I(th);
        }

        void M(long j4) {
            if (j4 > 0) {
                this.f63674d.request(j4);
            } else if (j4 >= 0) {
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j4);
            }
        }

        void g() {
            if (this.f63676f.getAndIncrement() != 0) {
                return;
            }
            int i4 = this.f63673c;
            while (!this.f63671a.isUnsubscribed()) {
                if (!this.f63680j) {
                    if (i4 == 1 && this.f63677g.get() != null) {
                        Throwable terminate = ExceptionsUtils.terminate(this.f63677g);
                        if (ExceptionsUtils.isTerminated(terminate)) {
                            return;
                        }
                        this.f63671a.onError(terminate);
                        return;
                    }
                    boolean z3 = this.f63679i;
                    Object poll = this.f63675e.poll();
                    boolean z4 = poll == null;
                    if (z3 && z4) {
                        Throwable terminate2 = ExceptionsUtils.terminate(this.f63677g);
                        if (terminate2 == null) {
                            this.f63671a.onCompleted();
                            return;
                        } else if (ExceptionsUtils.isTerminated(terminate2)) {
                            return;
                        } else {
                            this.f63671a.onError(terminate2);
                            return;
                        }
                    } else if (!z4) {
                        try {
                            rx.e<? extends R> call = this.f63672b.call((Object) v.e(poll));
                            if (call == null) {
                                v(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            } else if (call != rx.e.S1()) {
                                if (call instanceof rx.internal.util.k) {
                                    this.f63680j = true;
                                    this.f63674d.c(new b(((rx.internal.util.k) call).x7(), this));
                                } else {
                                    c cVar = new c(this);
                                    this.f63678h.b(cVar);
                                    if (cVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.f63680j = true;
                                    call.I6(cVar);
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.e(th);
                            v(th);
                            return;
                        }
                    }
                }
                if (this.f63676f.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63679i = true;
            g();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.f63677g, th)) {
                this.f63679i = true;
                if (this.f63673c == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.f63677g);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.f63671a.onError(terminate);
                    }
                    this.f63678h.unsubscribe();
                    return;
                }
                g();
                return;
            }
            L(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (!this.f63675e.offer(v.j(t3))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            g();
        }

        void v(Throwable th) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.f63677g, th)) {
                Throwable terminate = ExceptionsUtils.terminate(this.f63677g);
                if (ExceptionsUtils.isTerminated(terminate)) {
                    return;
                }
                this.f63671a.onError(terminate);
                return;
            }
            L(th);
        }

        void x(long j4) {
            if (j4 != 0) {
                this.f63674d.b(j4);
            }
            this.f63680j = false;
            g();
        }
    }

    public z(rx.e<? extends T> eVar, rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar, int i4, int i5) {
        this.f63660a = eVar;
        this.f63661b = pVar;
        this.f63662c = i4;
        this.f63663d = i5;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        d dVar = new d(this.f63663d == 0 ? new rx.observers.g<>(lVar) : lVar, this.f63661b, this.f63662c, this.f63663d);
        lVar.add(dVar);
        lVar.add(dVar.f63678h);
        lVar.setProducer(new a(dVar));
        if (lVar.isUnsubscribed()) {
            return;
        }
        this.f63660a.I6(dVar);
    }
}
