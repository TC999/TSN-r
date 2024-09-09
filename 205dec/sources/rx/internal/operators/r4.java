package rx.internal.operators;

import rx.h;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleObserveOn.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f63238a;

    /* renamed from: b  reason: collision with root package name */
    final rx.h f63239b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleObserveOn.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> implements rx.functions.a {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f63240b;

        /* renamed from: c  reason: collision with root package name */
        final h.a f63241c;

        /* renamed from: d  reason: collision with root package name */
        T f63242d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f63243e;

        public a(rx.k<? super T> kVar, h.a aVar) {
            this.f63240b = kVar;
            this.f63241c = aVar;
        }

        @Override // rx.k
        public void c(T t3) {
            this.f63242d = t3;
            this.f63241c.c(this);
        }

        @Override // rx.functions.a
        public void call() {
            try {
                Throwable th = this.f63243e;
                if (th != null) {
                    this.f63243e = null;
                    this.f63240b.onError(th);
                } else {
                    T t3 = this.f63242d;
                    this.f63242d = null;
                    this.f63240b.c(t3);
                }
            } finally {
                this.f63241c.unsubscribe();
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f63243e = th;
            this.f63241c.c(this);
        }
    }

    public r4(i.t<T> tVar, rx.h hVar) {
        this.f63238a = tVar;
        this.f63239b = hVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        h.a a4 = this.f63239b.a();
        a aVar = new a(kVar, a4);
        kVar.b(a4);
        kVar.b(aVar);
        this.f63238a.call(aVar);
    }
}
