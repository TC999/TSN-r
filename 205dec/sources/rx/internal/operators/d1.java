package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeTakeLastOne.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d1<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f62495a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeTakeLastOne.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends t<T, T> {

        /* renamed from: i  reason: collision with root package name */
        static final Object f62496i = new Object();

        /* JADX WARN: Type inference failed for: r1v1, types: [R, java.lang.Object] */
        public a(rx.l<? super T> lVar) {
            super(lVar);
            this.f63313c = f62496i;
        }

        @Override // rx.internal.operators.t, rx.f
        public void onCompleted() {
            Object obj = this.f63313c;
            if (obj == f62496i) {
                g();
            } else {
                v(obj);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        public void onNext(T t3) {
            this.f63313c = t3;
        }
    }

    public d1(rx.e<T> eVar) {
        this.f62495a = eVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        new a(lVar).J(this.f62495a);
    }
}
