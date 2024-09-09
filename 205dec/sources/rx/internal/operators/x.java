package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeCollect.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x<T, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f63557a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.o<R> f63558b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.c<R, ? super T> f63559c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCollect.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, R> extends u<T, R> {

        /* renamed from: j  reason: collision with root package name */
        final rx.functions.c<R, ? super T> f63560j;

        public a(rx.l<? super R> lVar, R r3, rx.functions.c<R, ? super T> cVar) {
            super(lVar);
            this.f63313c = r3;
            this.f63312b = true;
            this.f63560j = cVar;
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63398i) {
                return;
            }
            try {
                this.f63560j.call(this.f63313c, t3);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public x(rx.e<T> eVar, rx.functions.o<R> oVar, rx.functions.c<R, ? super T> cVar) {
        this.f63557a = eVar;
        this.f63558b = oVar;
        this.f63559c = cVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        try {
            new a(lVar, this.f63558b.call(), this.f63559c).J(this.f63557a);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            lVar.onError(th);
        }
    }
}
