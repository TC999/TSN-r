package rx.internal.operators;

import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleOnErrorReturn.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final i.t<T> f63303a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<Throwable, ? extends T> f63304b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleOnErrorReturn.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f63305b;

        /* renamed from: c  reason: collision with root package name */
        final rx.functions.p<Throwable, ? extends T> f63306c;

        public a(rx.k<? super T> kVar, rx.functions.p<Throwable, ? extends T> pVar) {
            this.f63305b = kVar;
            this.f63306c = pVar;
        }

        @Override // rx.k
        public void c(T t3) {
            this.f63305b.c(t3);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            try {
                this.f63305b.c(this.f63306c.call(th));
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                this.f63305b.onError(th2);
            }
        }
    }

    public s4(i.t<T> tVar, rx.functions.p<Throwable, ? extends T> pVar) {
        this.f63303a = tVar;
        this.f63304b = pVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar, this.f63304b);
        kVar.b(aVar);
        this.f63303a.call(aVar);
    }
}
