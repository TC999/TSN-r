package rx.internal.operators;

import rx.e;
import rx.exceptions.OnErrorThrowable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeMap.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r0<T, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f63193a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends R> f63194b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f63195a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends R> f63196b;

        /* renamed from: c  reason: collision with root package name */
        boolean f63197c;

        public a(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends R> pVar) {
            this.f63195a = lVar;
            this.f63196b = pVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63197c) {
                return;
            }
            this.f63195a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63197c) {
                rx.plugins.c.I(th);
                return;
            }
            this.f63197c = true;
            this.f63195a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                this.f63195a.onNext(this.f63196b.call(t3));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t3));
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f63195a.setProducer(gVar);
        }
    }

    public r0(rx.e<T> eVar, rx.functions.p<? super T, ? extends R> pVar) {
        this.f63193a = eVar;
        this.f63194b = pVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f63194b);
        lVar.add(aVar);
        this.f63193a.I6(aVar);
    }
}
