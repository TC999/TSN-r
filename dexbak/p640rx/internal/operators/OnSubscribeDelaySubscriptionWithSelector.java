package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func0;
import p640rx.observers.Subscribers;

/* renamed from: rx.internal.operators.e0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeDelaySubscriptionWithSelector<T, U> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Observable<? extends T> f45089a;

    /* renamed from: b */
    final Func0<? extends Observable<U>> f45090b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeDelaySubscriptionWithSelector.java */
    /* renamed from: rx.internal.operators.e0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15694a extends Subscriber<U> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f45091a;

        C15694a(Subscriber subscriber) {
            this.f45091a = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            OnSubscribeDelaySubscriptionWithSelector.this.f45089a.m1822I6(Subscribers.m631f(this.f45091a));
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45091a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(U u) {
        }
    }

    public OnSubscribeDelaySubscriptionWithSelector(Observable<? extends T> observable, Func0<? extends Observable<U>> func0) {
        this.f45089a = observable;
        this.f45090b = func0;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        try {
            this.f45090b.call().m1869C5(1).m1822I6(new C15694a(subscriber));
        } catch (Throwable th) {
            C15575a.m1473f(th, subscriber);
        }
    }
}
