package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.NeverObservableHolder */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public enum NeverObservableHolder implements Observable.InterfaceC15567a<Object> {
    INSTANCE;
    
    static final Observable<Object> NEVER = Observable.m1830H6(INSTANCE);

    public static <T> Observable<T> instance() {
        return (Observable<T>) NEVER;
    }

    @Override // p640rx.functions.Action1
    public void call(Subscriber<? super Object> subscriber) {
    }
}
