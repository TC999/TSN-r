package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTimeInterval.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q3<T> implements e.b<rx.schedulers.e<T>, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.h f63180a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTimeInterval.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private long f63181a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f63182b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f63182b = lVar2;
            this.f63181a = q3.this.f63180a.b();
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63182b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63182b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            long b4 = q3.this.f63180a.b();
            this.f63182b.onNext(new rx.schedulers.e(b4 - this.f63181a, t3));
            this.f63181a = b4;
        }
    }

    public q3(rx.h hVar) {
        this.f63180a = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super rx.schedulers.e<T>> lVar) {
        return new a(lVar, lVar);
    }
}
