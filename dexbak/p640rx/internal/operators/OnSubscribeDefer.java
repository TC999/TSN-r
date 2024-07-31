package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func0;
import p640rx.observers.Subscribers;

/* renamed from: rx.internal.operators.b0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeDefer<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Func0<? extends Observable<? extends T>> f44949a;

    public OnSubscribeDefer(Func0<? extends Observable<? extends T>> func0) {
        this.f44949a = func0;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        try {
            this.f44949a.call().m1822I6(Subscribers.m631f(subscriber));
        } catch (Throwable th) {
            C15575a.m1473f(th, subscriber);
        }
    }
}
