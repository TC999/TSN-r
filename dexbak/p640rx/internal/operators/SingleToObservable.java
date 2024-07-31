package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Single;
import p640rx.Subscriber;
import p640rx.internal.operators.SingleLiftObservableOperator;

/* renamed from: rx.internal.operators.c5 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleToObservable<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f45047a;

    public SingleToObservable(Single.InterfaceC15633t<T> interfaceC15633t) {
        this.f45047a = interfaceC15633t;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        SingleLiftObservableOperator.C15846a c15846a = new SingleLiftObservableOperator.C15846a(subscriber);
        subscriber.add(c15846a);
        this.f45047a.call(c15846a);
    }
}
