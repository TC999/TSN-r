package rx.internal.operators;

import rx.exceptions.OnErrorThrowable;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleOnSubscribeMap.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u4<T, R> implements i.t<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.i<T> f63435a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends R> f63436b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleOnSubscribeMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, R> extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final rx.k<? super R> f63437b;

        /* renamed from: c  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends R> f63438c;

        /* renamed from: d  reason: collision with root package name */
        boolean f63439d;

        public a(rx.k<? super R> kVar, rx.functions.p<? super T, ? extends R> pVar) {
            this.f63437b = kVar;
            this.f63438c = pVar;
        }

        @Override // rx.k
        public void c(T t3) {
            try {
                this.f63437b.c(this.f63438c.call(t3));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t3));
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (this.f63439d) {
                rx.plugins.c.I(th);
                return;
            }
            this.f63439d = true;
            this.f63437b.onError(th);
        }
    }

    public u4(rx.i<T> iVar, rx.functions.p<? super T, ? extends R> pVar) {
        this.f63435a = iVar;
        this.f63436b = pVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super R> kVar) {
        a aVar = new a(kVar, this.f63436b);
        kVar.b(aVar);
        this.f63435a.i0(aVar);
    }
}
