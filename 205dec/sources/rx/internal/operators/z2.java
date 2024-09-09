package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSerialize.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z2<T> implements e.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSerialize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f63700a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f63700a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63700a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63700a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63700a.onNext(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSerialize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final z2<Object> f63702a = new z2<>();

        b() {
        }
    }

    z2() {
    }

    public static <T> z2<T> a() {
        return (z2<T>) b.f63702a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new rx.observers.g(new a(lVar, lVar));
    }
}
