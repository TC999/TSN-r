package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.observers.Subscribers;

/* renamed from: rx.internal.operators.c2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorDoOnSubscribe<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    private final Action0 f45010a;

    public OperatorDoOnSubscribe(Action0 action0) {
        this.f45010a = action0;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        this.f45010a.call();
        return Subscribers.m631f(subscriber);
    }
}
