package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.EmptyObservableHolder */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public enum EmptyObservableHolder implements Observable.InterfaceC15567a<Object> {
    INSTANCE;
    
    static final Observable<Object> EMPTY = Observable.m1830H6(INSTANCE);

    public static <T> Observable<T> instance() {
        return (Observable<T>) EMPTY;
    }

    @Override // p640rx.functions.Action1
    public void call(Subscriber<? super Object> subscriber) {
        subscriber.onCompleted();
    }
}
