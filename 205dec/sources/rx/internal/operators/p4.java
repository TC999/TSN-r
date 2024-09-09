package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.e;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleFromObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final e.a<T> f63143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleFromObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: d  reason: collision with root package name */
        static final int f63144d = 0;

        /* renamed from: e  reason: collision with root package name */
        static final int f63145e = 1;

        /* renamed from: f  reason: collision with root package name */
        static final int f63146f = 2;

        /* renamed from: a  reason: collision with root package name */
        final rx.k<? super T> f63147a;

        /* renamed from: b  reason: collision with root package name */
        T f63148b;

        /* renamed from: c  reason: collision with root package name */
        int f63149c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(rx.k<? super T> kVar) {
            this.f63147a = kVar;
        }

        @Override // rx.f
        public void onCompleted() {
            int i4 = this.f63149c;
            if (i4 == 0) {
                this.f63147a.onError(new NoSuchElementException());
            } else if (i4 == 1) {
                this.f63149c = 2;
                T t3 = this.f63148b;
                this.f63148b = null;
                this.f63147a.c(t3);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63149c == 2) {
                rx.plugins.c.I(th);
                return;
            }
            this.f63148b = null;
            this.f63147a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            int i4 = this.f63149c;
            if (i4 == 0) {
                this.f63149c = 1;
                this.f63148b = t3;
            } else if (i4 == 1) {
                this.f63149c = 2;
                this.f63147a.onError(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public p4(e.a<T> aVar) {
        this.f63143a = aVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f63143a.call(aVar);
    }
}
