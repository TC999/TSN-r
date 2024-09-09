package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorIgnoreElements.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class h2<T> implements e.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorIgnoreElements.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f62710a;

        a(rx.l lVar) {
            this.f62710a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62710a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62710a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorIgnoreElements.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final h2<?> f62712a = new h2<>();

        b() {
        }
    }

    h2() {
    }

    public static <T> h2<T> a() {
        return (h2<T>) b.f62712a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar);
        lVar.add(aVar);
        return aVar;
    }
}
