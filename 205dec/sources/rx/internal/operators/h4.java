package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.h;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleDelay.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f62733a;

    /* renamed from: b  reason: collision with root package name */
    final long f62734b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f62735c;

    /* renamed from: d  reason: collision with root package name */
    final rx.h f62736d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleDelay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> implements rx.functions.a {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f62737b;

        /* renamed from: c  reason: collision with root package name */
        final h.a f62738c;

        /* renamed from: d  reason: collision with root package name */
        final long f62739d;

        /* renamed from: e  reason: collision with root package name */
        final TimeUnit f62740e;

        /* renamed from: f  reason: collision with root package name */
        T f62741f;

        /* renamed from: g  reason: collision with root package name */
        Throwable f62742g;

        public a(rx.k<? super T> kVar, h.a aVar, long j4, TimeUnit timeUnit) {
            this.f62737b = kVar;
            this.f62738c = aVar;
            this.f62739d = j4;
            this.f62740e = timeUnit;
        }

        @Override // rx.k
        public void c(T t3) {
            this.f62741f = t3;
            this.f62738c.e(this, this.f62739d, this.f62740e);
        }

        @Override // rx.functions.a
        public void call() {
            try {
                Throwable th = this.f62742g;
                if (th != null) {
                    this.f62742g = null;
                    this.f62737b.onError(th);
                } else {
                    T t3 = this.f62741f;
                    this.f62741f = null;
                    this.f62737b.c(t3);
                }
            } finally {
                this.f62738c.unsubscribe();
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f62742g = th;
            this.f62738c.e(this, this.f62739d, this.f62740e);
        }
    }

    public h4(i.t<T> tVar, long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f62733a = tVar;
        this.f62736d = hVar;
        this.f62734b = j4;
        this.f62735c = timeUnit;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        h.a a4 = this.f62736d.a();
        a aVar = new a(kVar, a4, this.f62734b, this.f62735c);
        kVar.b(a4);
        kVar.b(aVar);
        this.f62733a.call(aVar);
    }
}
