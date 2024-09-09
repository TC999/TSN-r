package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTimestamp.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u3<T> implements e.b<rx.schedulers.f<T>, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.h f63432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTimestamp.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f63433a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f63433a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63433a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63433a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63433a.onNext(new rx.schedulers.f(u3.this.f63432a.b(), t3));
        }
    }

    public u3(rx.h hVar) {
        this.f63432a = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super rx.schedulers.f<T>> lVar) {
        return new a(lVar, lVar);
    }
}
