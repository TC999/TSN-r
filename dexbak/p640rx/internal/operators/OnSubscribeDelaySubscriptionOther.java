package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.observers.Subscribers;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.SerialSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.d0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeDelaySubscriptionOther<T, U> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Observable<? extends T> f45058a;

    /* renamed from: b */
    final Observable<U> f45059b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeDelaySubscriptionOther.java */
    /* renamed from: rx.internal.operators.d0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15687a extends Subscriber<U> {

        /* renamed from: a */
        boolean f45060a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f45061b;

        /* renamed from: c */
        final /* synthetic */ SerialSubscription f45062c;

        C15687a(Subscriber subscriber, SerialSubscription serialSubscription) {
            this.f45061b = subscriber;
            this.f45062c = serialSubscription;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45060a) {
                return;
            }
            this.f45060a = true;
            this.f45062c.m347b(Subscriptions.m342e());
            OnSubscribeDelaySubscriptionOther.this.f45058a.m1822I6(this.f45061b);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45060a) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45060a = true;
            this.f45061b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(U u) {
            onCompleted();
        }
    }

    public OnSubscribeDelaySubscriptionOther(Observable<? extends T> observable, Observable<U> observable2) {
        this.f45058a = observable;
        this.f45059b = observable2;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        C15687a c15687a = new C15687a(Subscribers.m631f(subscriber), serialSubscription);
        serialSubscription.m347b(c15687a);
        this.f45059b.m1822I6(c15687a);
    }
}
