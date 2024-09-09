package rx.internal.operators;

import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleDoAfterTerminate.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.i<T> f62792a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.a f62793b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleDoAfterTerminate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f62794b;

        /* renamed from: c  reason: collision with root package name */
        final rx.functions.a f62795c;

        public a(rx.k<? super T> kVar, rx.functions.a aVar) {
            this.f62794b = kVar;
            this.f62795c = aVar;
        }

        @Override // rx.k
        public void c(T t3) {
            try {
                this.f62794b.c(t3);
            } finally {
                e();
            }
        }

        void e() {
            try {
                this.f62795c.call();
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            try {
                this.f62794b.onError(th);
            } finally {
                e();
            }
        }
    }

    public i4(rx.i<T> iVar, rx.functions.a aVar) {
        this.f62792a = iVar;
        this.f62793b = aVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar, this.f62793b);
        kVar.b(aVar);
        this.f62792a.i0(aVar);
    }
}
