package rx.internal.operators;

import rx.e;
import rx.exceptions.OnErrorThrowable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorCast.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class s1<T, R> implements e.b<R, T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<R> f63263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorCast.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f63264a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f63265b;

        /* renamed from: c  reason: collision with root package name */
        boolean f63266c;

        public a(rx.l<? super R> lVar, Class<R> cls) {
            this.f63264a = lVar;
            this.f63265b = cls;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63266c) {
                return;
            }
            this.f63264a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63266c) {
                rx.plugins.c.I(th);
                return;
            }
            this.f63266c = true;
            this.f63264a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                this.f63264a.onNext(this.f63265b.cast(t3));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t3));
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f63264a.setProducer(gVar);
        }
    }

    public s1(Class<R> cls) {
        this.f63263a = cls;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f63263a);
        lVar.add(aVar);
        return aVar;
    }
}
