package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSkip.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final int f62391a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSkip.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        int f62392a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f62393b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f62393b = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62393b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62393b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            int i4 = this.f62392a;
            if (i4 >= b3.this.f62391a) {
                this.f62393b.onNext(t3);
            } else {
                this.f62392a = i4 + 1;
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62393b.setProducer(gVar);
            gVar.request(b3.this.f62391a);
        }
    }

    public b3(int i4) {
        if (i4 >= 0) {
            this.f62391a = i4;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + i4);
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
