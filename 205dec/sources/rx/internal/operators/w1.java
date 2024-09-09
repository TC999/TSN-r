package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDelayWithSelector.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w1<T, V> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends T> f63529a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<V>> f63530b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDelayWithSelector.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.subjects.c f63531a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.observers.g f63532b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorDelayWithSelector.java */
        /* renamed from: rx.internal.operators.w1$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class C1304a implements rx.functions.p<V, T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f63534a;

            C1304a(Object obj) {
                this.f63534a = obj;
            }

            @Override // rx.functions.p
            public T call(V v3) {
                return (T) this.f63534a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.subjects.c cVar, rx.observers.g gVar) {
            super(lVar);
            this.f63531a = cVar;
            this.f63532b = gVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63531a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63532b.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        public void onNext(T t3) {
            try {
                this.f63531a.onNext(w1.this.f63530b.call(t3).C5(1).q1(null).b3(new C1304a(t3)));
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }
    }

    public w1(rx.e<? extends T> eVar, rx.functions.p<? super T, ? extends rx.e<V>> pVar) {
        this.f63529a = eVar;
        this.f63530b = pVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        rx.subjects.c x7 = rx.subjects.c.x7();
        lVar.add(rx.e.g3(x7).I6(rx.observers.h.e(gVar)));
        return new a(lVar, x7, gVar);
    }
}
