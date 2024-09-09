package rx.observers;

import rx.exceptions.OnErrorNotImplementedException;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: Subscribers.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Subscribers.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class a<T> extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.f f64183a;

        a(rx.f fVar) {
            this.f64183a = fVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64183a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64183a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64183a.onNext(t3);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Subscribers.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class b<T> extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64184a;

        b(rx.functions.b bVar) {
            this.f64184a = bVar;
        }

        @Override // rx.f
        public final void onCompleted() {
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.f
        public final void onNext(T t3) {
            this.f64184a.call(t3);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Subscribers.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class c<T> extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64185a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64186b;

        c(rx.functions.b bVar, rx.functions.b bVar2) {
            this.f64185a = bVar;
            this.f64186b = bVar2;
        }

        @Override // rx.f
        public final void onCompleted() {
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            this.f64185a.call(th);
        }

        @Override // rx.f
        public final void onNext(T t3) {
            this.f64186b.call(t3);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Subscribers.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class d<T> extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f64187a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64188b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64189c;

        d(rx.functions.a aVar, rx.functions.b bVar, rx.functions.b bVar2) {
            this.f64187a = aVar;
            this.f64188b = bVar;
            this.f64189c = bVar2;
        }

        @Override // rx.f
        public final void onCompleted() {
            this.f64187a.call();
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            this.f64188b.call(th);
        }

        @Override // rx.f
        public final void onNext(T t3) {
            this.f64189c.call(t3);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Subscribers.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class e<T> extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f64190a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(l lVar, l lVar2) {
            super(lVar);
            this.f64190a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64190a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64190a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64190a.onNext(t3);
        }
    }

    private h() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> l<T> a(rx.functions.b<? super T> bVar) {
        if (bVar != null) {
            return new b(bVar);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> l<T> b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar != null) {
            if (bVar2 != null) {
                return new c(bVar2, bVar);
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> l<T> c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        if (bVar != null) {
            if (bVar2 != null) {
                if (aVar != null) {
                    return new d(aVar, bVar2, bVar);
                }
                throw new IllegalArgumentException("onComplete can not be null");
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> l<T> d() {
        return e(rx.observers.c.d());
    }

    public static <T> l<T> e(rx.f<? super T> fVar) {
        return new a(fVar);
    }

    public static <T> l<T> f(l<? super T> lVar) {
        return new e(lVar, lVar);
    }
}
