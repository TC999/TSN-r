package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum NeverObservableHolder implements e.a<Object> {
    INSTANCE;
    
    static final rx.e<Object> NEVER = rx.e.H6(INSTANCE);

    public static <T> rx.e<T> instance() {
        return (rx.e<T>) NEVER;
    }

    @Override // rx.functions.b
    public void call(rx.l<? super Object> lVar) {
    }
}
