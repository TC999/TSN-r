package rx.internal.operators;

import rx.e;
import rx.internal.operators.u1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDebounceWithSelector.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t1<T, U> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<U>> f63321a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDebounceWithSelector.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final u1.b<T> f63322a;

        /* renamed from: b  reason: collision with root package name */
        final rx.l<?> f63323b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.observers.g f63324c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f63325d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorDebounceWithSelector.java */
        /* renamed from: rx.internal.operators.t1$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class C1297a extends rx.l<U> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f63327a;

            C1297a(int i4) {
                this.f63327a = i4;
            }

            @Override // rx.f
            public void onCompleted() {
                a aVar = a.this;
                aVar.f63322a.b(this.f63327a, aVar.f63324c, aVar.f63323b);
                unsubscribe();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.f63323b.onError(th);
            }

            @Override // rx.f
            public void onNext(U u3) {
                onCompleted();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.observers.g gVar, rx.subscriptions.e eVar) {
            super(lVar);
            this.f63324c = gVar;
            this.f63325d = eVar;
            this.f63322a = new u1.b<>();
            this.f63323b = this;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63322a.c(this.f63324c, this);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63324c.onError(th);
            unsubscribe();
            this.f63322a.a();
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                rx.e<U> call = t1.this.f63321a.call(t3);
                C1297a c1297a = new C1297a(this.f63322a.d(t3));
                this.f63325d.b(c1297a);
                call.I6(c1297a);
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public t1(rx.functions.p<? super T, ? extends rx.e<U>> pVar) {
        this.f63321a = pVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        lVar.add(eVar);
        return new a(lVar, gVar, eVar);
    }
}
