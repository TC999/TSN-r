package p640rx.observables;

import p640rx.Observable;
import p640rx.Subscription;
import p640rx.functions.Action1;
import p640rx.functions.Actions;
import p640rx.internal.operators.OnSubscribeAutoConnect;
import p640rx.internal.operators.OnSubscribeRefCount;

/* renamed from: rx.observables.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ConnectableObservable<T> extends Observable<T> {

    /* compiled from: ConnectableObservable.java */
    /* renamed from: rx.observables.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16115a implements Action1<Subscription> {

        /* renamed from: a */
        final /* synthetic */ Subscription[] f46876a;

        C16115a(Subscription[] subscriptionArr) {
            this.f46876a = subscriptionArr;
        }

        @Override // p640rx.functions.Action1
        public void call(Subscription subscription) {
            this.f46876a[0] = subscription;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ConnectableObservable(Observable.InterfaceC15567a<T> interfaceC15567a) {
        super(interfaceC15567a);
    }

    /* renamed from: A7 */
    public Observable<T> m697A7() {
        return Observable.m1830H6(new OnSubscribeRefCount(this));
    }

    /* renamed from: v7 */
    public Observable<T> m696v7() {
        return m695w7(1);
    }

    /* renamed from: w7 */
    public Observable<T> m695w7(int i) {
        return m694x7(i, Actions.m1455a());
    }

    /* renamed from: x7 */
    public Observable<T> m694x7(int i, Action1<? super Subscription> action1) {
        if (i <= 0) {
            mo692z7(action1);
            return this;
        }
        return Observable.m1830H6(new OnSubscribeAutoConnect(this, i, action1));
    }

    /* renamed from: y7 */
    public final Subscription m693y7() {
        Subscription[] subscriptionArr = new Subscription[1];
        mo692z7(new C16115a(subscriptionArr));
        return subscriptionArr[0];
    }

    /* renamed from: z7 */
    public abstract void mo692z7(Action1<? super Subscription> action1);
}
