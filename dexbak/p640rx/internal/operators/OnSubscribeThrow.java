package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.e1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeThrow<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    private final Throwable f45093a;

    public OnSubscribeThrow(Throwable th) {
        this.f45093a = th;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        subscriber.onError(this.f45093a);
    }
}
