package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDoAfterTerminate.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a2<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.a f62327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDoAfterTerminate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f62328a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f62328a = lVar2;
        }

        void g() {
            try {
                a2.this.f62327a.call();
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f62328a.onCompleted();
            } finally {
                g();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f62328a.onError(th);
            } finally {
                g();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62328a.onNext(t3);
        }
    }

    public a2(rx.functions.a aVar) {
        if (aVar != null) {
            this.f62327a = aVar;
            return;
        }
        throw new NullPointerException("Action can not be null");
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
