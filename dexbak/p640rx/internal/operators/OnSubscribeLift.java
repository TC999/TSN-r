package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.q0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeLift<T, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable.InterfaceC15567a<T> f45725a;

    /* renamed from: b */
    final Observable.InterfaceC15568b<? extends R, ? super T> f45726b;

    public OnSubscribeLift(Observable.InterfaceC15567a<T> interfaceC15567a, Observable.InterfaceC15568b<? extends R, ? super T> interfaceC15568b) {
        this.f45725a = interfaceC15567a;
        this.f45726b = interfaceC15568b;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super T> call = RxJavaHooks.m572M(this.f45726b).call(subscriber);
            call.onStart();
            this.f45725a.call(call);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            subscriber.onError(th);
        }
    }
}
