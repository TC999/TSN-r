package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.functions.Action1;
import p640rx.observables.ConnectableObservable;
import p640rx.observers.Subscribers;

/* renamed from: rx.internal.operators.OnSubscribeAutoConnect */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements Observable.InterfaceC15567a<T> {
    final Action1<? super Subscription> connection;
    final int numberOfSubscribers;
    final ConnectableObservable<? extends T> source;

    public OnSubscribeAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i, Action1<? super Subscription> action1) {
        if (i > 0) {
            this.source = connectableObservable;
            this.numberOfSubscribers = i;
            this.connection = action1;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        this.source.m1822I6(Subscribers.m631f(subscriber));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.mo692z7(this.connection);
        }
    }
}
