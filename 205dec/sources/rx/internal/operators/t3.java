package rx.internal.operators;

import rx.h;
import rx.internal.operators.s3;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTimeoutWithSelector.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class t3<T, U, V> extends s3<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTimeoutWithSelector.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements s3.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.o f63382a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorTimeoutWithSelector.java */
        /* renamed from: rx.internal.operators.t3$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1298a extends rx.l<U> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ s3.c f63383a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Long f63384b;

            C1298a(s3.c cVar, Long l4) {
                this.f63383a = cVar;
                this.f63384b = l4;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f63383a.g(this.f63384b.longValue());
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f63383a.onError(th);
            }

            @Override // rx.f
            public void onNext(U u3) {
                this.f63383a.g(this.f63384b.longValue());
            }
        }

        a(rx.functions.o oVar) {
            this.f63382a = oVar;
        }

        @Override // rx.functions.r
        public /* bridge */ /* synthetic */ rx.m call(Object obj, Long l4, h.a aVar) {
            return call((s3.c) ((s3.c) obj), l4, aVar);
        }

        public rx.m call(s3.c<T> cVar, Long l4, h.a aVar) {
            rx.functions.o oVar = this.f63382a;
            if (oVar != null) {
                try {
                    return ((rx.e) oVar.call()).I6(new C1298a(cVar, l4));
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, cVar);
                    return rx.subscriptions.f.e();
                }
            }
            return rx.subscriptions.f.e();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTimeoutWithSelector.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class b implements s3.b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f63386a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorTimeoutWithSelector.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends rx.l<V> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ s3.c f63387a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Long f63388b;

            a(s3.c cVar, Long l4) {
                this.f63387a = cVar;
                this.f63388b = l4;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f63387a.g(this.f63388b.longValue());
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f63387a.onError(th);
            }

            @Override // rx.f
            public void onNext(V v3) {
                this.f63387a.g(this.f63388b.longValue());
            }
        }

        b(rx.functions.p pVar) {
            this.f63386a = pVar;
        }

        @Override // rx.functions.s
        public /* bridge */ /* synthetic */ rx.m call(Object obj, Long l4, Object obj2, h.a aVar) {
            return call((s3.c<Long>) obj, l4, (Long) obj2, aVar);
        }

        public rx.m call(s3.c<T> cVar, Long l4, T t3, h.a aVar) {
            try {
                return ((rx.e) this.f63386a.call(t3)).I6(new a(cVar, l4));
            } catch (Throwable th) {
                rx.exceptions.a.f(th, cVar);
                return rx.subscriptions.f.e();
            }
        }
    }

    public t3(rx.functions.o<? extends rx.e<U>> oVar, rx.functions.p<? super T, ? extends rx.e<V>> pVar, rx.e<? extends T> eVar) {
        super(new a(oVar), new b(pVar), eVar, rx.schedulers.c.d());
    }

    @Override // rx.internal.operators.s3
    public /* bridge */ /* synthetic */ rx.l call(rx.l lVar) {
        return super.call(lVar);
    }
}
