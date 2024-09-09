package rx.observers;

import rx.exceptions.OnErrorNotImplementedException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: Observers.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final rx.f<Object> f64164a = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Observers.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a implements rx.f<Object> {
        a() {
        }

        @Override // rx.f
        public final void onCompleted() {
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.f
        public final void onNext(Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Observers.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class b<T> implements rx.f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64165a;

        b(rx.functions.b bVar) {
            this.f64165a = bVar;
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
            this.f64165a.call(t3);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Observers.java */
    /* renamed from: rx.observers.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class C1322c<T> implements rx.f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64166a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64167b;

        C1322c(rx.functions.b bVar, rx.functions.b bVar2) {
            this.f64166a = bVar;
            this.f64167b = bVar2;
        }

        @Override // rx.f
        public final void onCompleted() {
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            this.f64166a.call(th);
        }

        @Override // rx.f
        public final void onNext(T t3) {
            this.f64167b.call(t3);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: Observers.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class d<T> implements rx.f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f64168a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64169b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64170c;

        d(rx.functions.a aVar, rx.functions.b bVar, rx.functions.b bVar2) {
            this.f64168a = aVar;
            this.f64169b = bVar;
            this.f64170c = bVar2;
        }

        @Override // rx.f
        public final void onCompleted() {
            this.f64168a.call();
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            this.f64169b.call(th);
        }

        @Override // rx.f
        public final void onNext(T t3) {
            this.f64170c.call(t3);
        }
    }

    private c() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> rx.f<T> a(rx.functions.b<? super T> bVar) {
        if (bVar != null) {
            return new b(bVar);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> rx.f<T> b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar != null) {
            if (bVar2 != null) {
                return new C1322c(bVar2, bVar);
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> rx.f<T> c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
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

    public static <T> rx.f<T> d() {
        return (rx.f<T>) f64164a;
    }
}
