package rx.internal.operators;

import rx.e;
import rx.exceptions.OnErrorThrowable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeFilter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f62699a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, Boolean> f62700b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeFilter.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62701a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, Boolean> f62702b;

        /* renamed from: c  reason: collision with root package name */
        boolean f62703c;

        public a(rx.l<? super T> lVar, rx.functions.p<? super T, Boolean> pVar) {
            this.f62701a = lVar;
            this.f62702b = pVar;
            request(0L);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62703c) {
                return;
            }
            this.f62701a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62703c) {
                rx.plugins.c.I(th);
                return;
            }
            this.f62703c = true;
            this.f62701a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                if (this.f62702b.call(t3).booleanValue()) {
                    this.f62701a.onNext(t3);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t3));
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            super.setProducer(gVar);
            this.f62701a.setProducer(gVar);
        }
    }

    public h0(rx.e<T> eVar, rx.functions.p<? super T, Boolean> pVar) {
        this.f62699a = eVar;
        this.f62700b = pVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        a aVar = new a(lVar, this.f62700b);
        lVar.add(aVar);
        this.f62699a.I6(aVar);
    }
}
