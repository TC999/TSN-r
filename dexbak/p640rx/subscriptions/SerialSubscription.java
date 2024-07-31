package p640rx.subscriptions;

import p640rx.Subscription;
import p640rx.internal.subscriptions.SequentialSubscription;

/* renamed from: rx.subscriptions.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SerialSubscription implements Subscription {

    /* renamed from: a */
    final SequentialSubscription f47093a = new SequentialSubscription();

    /* renamed from: a */
    public Subscription m348a() {
        return this.f47093a.current();
    }

    /* renamed from: b */
    public void m347b(Subscription subscription) {
        if (subscription != null) {
            this.f47093a.update(subscription);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f47093a.isUnsubscribed();
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        this.f47093a.unsubscribe();
    }
}
