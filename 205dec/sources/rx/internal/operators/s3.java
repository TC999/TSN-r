package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTimeoutBase.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class s3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final a<T> f63290a;

    /* renamed from: b  reason: collision with root package name */
    final b<T> f63291b;

    /* renamed from: c  reason: collision with root package name */
    final rx.e<? extends T> f63292c;

    /* renamed from: d  reason: collision with root package name */
    final rx.h f63293d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTimeoutBase.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a<T> extends rx.functions.r<c<T>, Long, h.a, rx.m> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTimeoutBase.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface b<T> extends rx.functions.s<c<T>, Long, T, h.a, rx.m> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTimeoutBase.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.subscriptions.e f63294a;

        /* renamed from: b  reason: collision with root package name */
        final rx.observers.g<T> f63295b;

        /* renamed from: c  reason: collision with root package name */
        final b<T> f63296c;

        /* renamed from: d  reason: collision with root package name */
        final rx.e<? extends T> f63297d;

        /* renamed from: e  reason: collision with root package name */
        final h.a f63298e;

        /* renamed from: f  reason: collision with root package name */
        final rx.internal.producers.a f63299f = new rx.internal.producers.a();

        /* renamed from: g  reason: collision with root package name */
        boolean f63300g;

        /* renamed from: h  reason: collision with root package name */
        long f63301h;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorTimeoutBase.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class a extends rx.l<T> {
            a() {
            }

            @Override // rx.f
            public void onCompleted() {
                c.this.f63295b.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                c.this.f63295b.onError(th);
            }

            @Override // rx.f
            public void onNext(T t3) {
                c.this.f63295b.onNext(t3);
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                c.this.f63299f.c(gVar);
            }
        }

        c(rx.observers.g<T> gVar, b<T> bVar, rx.subscriptions.e eVar, rx.e<? extends T> eVar2, h.a aVar) {
            this.f63295b = gVar;
            this.f63296c = bVar;
            this.f63294a = eVar;
            this.f63297d = eVar2;
            this.f63298e = aVar;
        }

        public void g(long j4) {
            boolean z3;
            synchronized (this) {
                z3 = true;
                if (j4 != this.f63301h || this.f63300g) {
                    z3 = false;
                } else {
                    this.f63300g = true;
                }
            }
            if (z3) {
                if (this.f63297d == null) {
                    this.f63295b.onError(new TimeoutException());
                    return;
                }
                a aVar = new a();
                this.f63297d.I6(aVar);
                this.f63294a.b(aVar);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            boolean z3;
            synchronized (this) {
                z3 = true;
                if (this.f63300g) {
                    z3 = false;
                } else {
                    this.f63300g = true;
                }
            }
            if (z3) {
                this.f63294a.unsubscribe();
                this.f63295b.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            boolean z3;
            synchronized (this) {
                z3 = true;
                if (this.f63300g) {
                    z3 = false;
                } else {
                    this.f63300g = true;
                }
            }
            if (z3) {
                this.f63294a.unsubscribe();
                this.f63295b.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            long j4;
            boolean z3;
            synchronized (this) {
                if (!this.f63300g) {
                    j4 = this.f63301h + 1;
                    this.f63301h = j4;
                    z3 = true;
                } else {
                    j4 = this.f63301h;
                    z3 = false;
                }
            }
            if (z3) {
                this.f63295b.onNext(t3);
                this.f63294a.b(this.f63296c.call(this, Long.valueOf(j4), t3, this.f63298e));
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f63299f.c(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3(a<T> aVar, b<T> bVar, rx.e<? extends T> eVar, rx.h hVar) {
        this.f63290a = aVar;
        this.f63291b = bVar;
        this.f63292c = eVar;
        this.f63293d = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        h.a a4 = this.f63293d.a();
        lVar.add(a4);
        rx.observers.g gVar = new rx.observers.g(lVar);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        gVar.add(eVar);
        c cVar = new c(gVar, this.f63291b, eVar, this.f63292c, a4);
        gVar.add(cVar);
        gVar.setProducer(cVar.f63299f);
        eVar.b(this.f63290a.call(cVar, 0L, a4));
        return cVar;
    }
}
