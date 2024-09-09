package rx.observables;

import rx.e;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: GroupedObservable.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class d<K, T> extends rx.e<T> {

    /* renamed from: b  reason: collision with root package name */
    private final K f64147b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: GroupedObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f64148a;

        a(rx.e eVar) {
            this.f64148a = eVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l) ((l) obj));
        }

        public void call(l<? super T> lVar) {
            this.f64148a.I6(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(K k4, e.a<T> aVar) {
        super(aVar);
        this.f64147b = k4;
    }

    public static <K, T> d<K, T> v7(K k4, e.a<T> aVar) {
        return new d<>(k4, aVar);
    }

    public static <K, T> d<K, T> w7(K k4, rx.e<T> eVar) {
        return new d<>(k4, new a(eVar));
    }

    public K x7() {
        return this.f64147b;
    }
}
