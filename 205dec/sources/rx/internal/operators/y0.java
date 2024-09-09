package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeReduceSeed.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y0<T, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f63633a;

    /* renamed from: b  reason: collision with root package name */
    final R f63634b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.q<R, ? super T, R> f63635c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeReduceSeed.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, R> extends t<T, R> {

        /* renamed from: i  reason: collision with root package name */
        final rx.functions.q<R, ? super T, R> f63636i;

        public a(rx.l<? super R> lVar, R r3, rx.functions.q<R, ? super T, R> qVar) {
            super(lVar);
            this.f63313c = r3;
            this.f63312b = true;
            this.f63636i = qVar;
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                this.f63313c = this.f63636i.call(this.f63313c, t3);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                this.f63311a.onError(th);
            }
        }
    }

    public y0(rx.e<T> eVar, R r3, rx.functions.q<R, ? super T, R> qVar) {
        this.f63633a = eVar;
        this.f63634b = r3;
        this.f63635c = qVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        new a(lVar, this.f63634b, this.f63635c).J(this.f63633a);
    }
}
