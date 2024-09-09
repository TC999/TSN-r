package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorAsObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n1<T> implements e.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorAsObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final n1<Object> f62995a = new n1<>();

        a() {
        }
    }

    n1() {
    }

    public static <T> n1<T> a() {
        return (n1<T>) a.f62995a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return lVar;
    }
}
