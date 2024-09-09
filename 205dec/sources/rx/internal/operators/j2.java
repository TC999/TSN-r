package rx.internal.operators;

import rx.e;
import rx.exceptions.OnErrorThrowable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorMapPair.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j2<T, U, R> implements e.b<rx.e<? extends R>, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<? extends U>> f62821a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.q<? super T, ? super U, ? extends R> f62822b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMapPair.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements rx.functions.p<T, rx.e<U>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f62823a;

        a(rx.functions.p pVar) {
            this.f62823a = pVar;
        }

        @Override // rx.functions.p
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((a) obj);
        }

        @Override // rx.functions.p
        public rx.e<U> call(T t3) {
            return rx.e.u2((Iterable) this.f62823a.call(t3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMapPair.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T, U, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.e<? extends R>> f62824a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.e<? extends U>> f62825b;

        /* renamed from: c  reason: collision with root package name */
        final rx.functions.q<? super T, ? super U, ? extends R> f62826c;

        /* renamed from: d  reason: collision with root package name */
        boolean f62827d;

        public b(rx.l<? super rx.e<? extends R>> lVar, rx.functions.p<? super T, ? extends rx.e<? extends U>> pVar, rx.functions.q<? super T, ? super U, ? extends R> qVar) {
            this.f62824a = lVar;
            this.f62825b = pVar;
            this.f62826c = qVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62827d) {
                return;
            }
            this.f62824a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62827d) {
                rx.plugins.c.I(th);
                return;
            }
            this.f62827d = true;
            this.f62824a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                this.f62824a.onNext(this.f62825b.call(t3).b3(new c(t3, this.f62826c)));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t3));
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62824a.setProducer(gVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMapPair.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c<T, U, R> implements rx.functions.p<U, R> {

        /* renamed from: a  reason: collision with root package name */
        final T f62828a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.q<? super T, ? super U, ? extends R> f62829b;

        public c(T t3, rx.functions.q<? super T, ? super U, ? extends R> qVar) {
            this.f62828a = t3;
            this.f62829b = qVar;
        }

        @Override // rx.functions.p
        public R call(U u3) {
            return this.f62829b.call((T) this.f62828a, u3);
        }
    }

    public j2(rx.functions.p<? super T, ? extends rx.e<? extends U>> pVar, rx.functions.q<? super T, ? super U, ? extends R> qVar) {
        this.f62821a = pVar;
        this.f62822b = qVar;
    }

    public static <T, U> rx.functions.p<T, rx.e<U>> a(rx.functions.p<? super T, ? extends Iterable<? extends U>> pVar) {
        return new a(pVar);
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super rx.e<? extends R>> lVar) {
        b bVar = new b(lVar, this.f62821a, this.f62822b);
        lVar.add(bVar);
        return bVar;
    }
}
