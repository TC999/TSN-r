package p640rx.subscriptions;

import p640rx.Subscription;
import p640rx.internal.subscriptions.SequentialSubscription;

/* renamed from: rx.subscriptions.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class MultipleAssignmentSubscription implements Subscription {

    /* renamed from: a */
    final SequentialSubscription f47086a = new SequentialSubscription();

    /* renamed from: a */
    public Subscription m356a() {
        return this.f47086a.current();
    }

    /* renamed from: b */
    public void m355b(Subscription subscription) {
        if (subscription != null) {
            this.f47086a.replace(subscription);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f47086a.isUnsubscribed();
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        this.f47086a.unsubscribe();
    }
}
