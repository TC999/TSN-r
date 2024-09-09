package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleDoOnEvent.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.i<T> f62837a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.b<? super T> f62838b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.b<Throwable> f62839c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleDoOnEvent.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super T> f62840b;

        /* renamed from: c  reason: collision with root package name */
        final rx.functions.b<? super T> f62841c;

        /* renamed from: d  reason: collision with root package name */
        final rx.functions.b<Throwable> f62842d;

        a(rx.k<? super T> kVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.f62840b = kVar;
            this.f62841c = bVar;
            this.f62842d = bVar2;
        }

        @Override // rx.k
        public void c(T t3) {
            try {
                this.f62841c.call(t3);
                this.f62840b.c(t3);
            } catch (Throwable th) {
                rx.exceptions.a.i(th, this, t3);
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            try {
                this.f62842d.call(th);
                this.f62840b.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                this.f62840b.onError(new CompositeException(th, th2));
            }
        }
    }

    public j4(rx.i<T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.f62837a = iVar;
        this.f62838b = bVar;
        this.f62839c = bVar2;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar, this.f62838b, this.f62839c);
        kVar.b(aVar);
        this.f62837a.i0(aVar);
    }
}
