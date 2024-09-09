package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorMapNotification.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i2<T, R> implements e.b<R, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends R> f62768a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super Throwable, ? extends R> f62769b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.o<? extends R> f62770c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMapNotification.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62771a;

        a(b bVar) {
            this.f62771a = bVar;
        }

        @Override // rx.g
        public void request(long j4) {
            this.f62771a.v(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMapNotification.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T, R> extends rx.l<T> {

        /* renamed from: j  reason: collision with root package name */
        static final long f62773j = Long.MIN_VALUE;

        /* renamed from: k  reason: collision with root package name */
        static final long f62774k = Long.MAX_VALUE;

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f62775a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends R> f62776b;

        /* renamed from: c  reason: collision with root package name */
        final rx.functions.p<? super Throwable, ? extends R> f62777c;

        /* renamed from: d  reason: collision with root package name */
        final rx.functions.o<? extends R> f62778d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f62779e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f62780f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<rx.g> f62781g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        long f62782h;

        /* renamed from: i  reason: collision with root package name */
        R f62783i;

        public b(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends R> pVar, rx.functions.p<? super Throwable, ? extends R> pVar2, rx.functions.o<? extends R> oVar) {
            this.f62775a = lVar;
            this.f62776b = pVar;
            this.f62777c = pVar2;
            this.f62778d = oVar;
        }

        void g() {
            long j4 = this.f62782h;
            if (j4 == 0 || this.f62781g.get() == null) {
                return;
            }
            rx.internal.operators.a.i(this.f62779e, j4);
        }

        @Override // rx.f
        public void onCompleted() {
            g();
            try {
                this.f62783i = this.f62778d.call();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this.f62775a);
            }
            x();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            g();
            try {
                this.f62783i = this.f62777c.call(th);
            } catch (Throwable th2) {
                rx.exceptions.a.g(th2, this.f62775a, th);
            }
            x();
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                this.f62782h++;
                this.f62775a.onNext((R) this.f62776b.call(t3));
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this.f62775a, t3);
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            if (this.f62781g.compareAndSet(null, gVar)) {
                long andSet = this.f62780f.getAndSet(0L);
                if (andSet != 0) {
                    gVar.request(andSet);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Producer already set!");
        }

        void v(long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j4);
            } else if (j4 == 0) {
            } else {
                while (true) {
                    long j5 = this.f62779e.get();
                    if ((j5 & Long.MIN_VALUE) != 0) {
                        long j6 = Long.MAX_VALUE & j5;
                        if (this.f62779e.compareAndSet(j5, Long.MIN_VALUE | rx.internal.operators.a.a(j6, j4))) {
                            if (j6 == 0) {
                                if (!this.f62775a.isUnsubscribed()) {
                                    this.f62775a.onNext((R) this.f62783i);
                                }
                                if (this.f62775a.isUnsubscribed()) {
                                    return;
                                }
                                this.f62775a.onCompleted();
                                return;
                            }
                            return;
                        }
                    } else {
                        if (this.f62779e.compareAndSet(j5, rx.internal.operators.a.a(j5, j4))) {
                            AtomicReference<rx.g> atomicReference = this.f62781g;
                            rx.g gVar = atomicReference.get();
                            if (gVar != null) {
                                gVar.request(j4);
                                return;
                            }
                            rx.internal.operators.a.b(this.f62780f, j4);
                            rx.g gVar2 = atomicReference.get();
                            if (gVar2 != null) {
                                long andSet = this.f62780f.getAndSet(0L);
                                if (andSet != 0) {
                                    gVar2.request(andSet);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }

        void x() {
            long j4;
            do {
                j4 = this.f62779e.get();
                if ((j4 & Long.MIN_VALUE) != 0) {
                    return;
                }
            } while (!this.f62779e.compareAndSet(j4, Long.MIN_VALUE | j4));
            if (j4 != 0 || this.f62781g.get() == null) {
                if (!this.f62775a.isUnsubscribed()) {
                    this.f62775a.onNext((R) this.f62783i);
                }
                if (this.f62775a.isUnsubscribed()) {
                    return;
                }
                this.f62775a.onCompleted();
            }
        }
    }

    public i2(rx.functions.p<? super T, ? extends R> pVar, rx.functions.p<? super Throwable, ? extends R> pVar2, rx.functions.o<? extends R> oVar) {
        this.f62768a = pVar;
        this.f62769b = pVar2;
        this.f62770c = oVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super R> lVar) {
        b bVar = new b(lVar, this.f62768a, this.f62769b, this.f62770c);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        return bVar;
    }
}
