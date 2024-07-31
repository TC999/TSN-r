package p640rx.internal.operators;

import java.util.concurrent.Callable;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.internal.producers.SingleDelayedProducer;

/* renamed from: rx.internal.operators.m0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeFromCallable<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    private final Callable<? extends T> f45520a;

    public OnSubscribeFromCallable(Callable<? extends T> callable) {
        this.f45520a = callable;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        subscriber.setProducer(singleDelayedProducer);
        try {
            singleDelayedProducer.setValue(this.f45520a.call());
        } catch (Throwable th) {
            C15575a.m1473f(th, subscriber);
        }
    }
}
