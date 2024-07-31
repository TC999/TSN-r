package p640rx.internal.subscriptions;

import p640rx.Subscription;

/* renamed from: rx.internal.subscriptions.Unsubscribed */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public enum Unsubscribed implements Subscription {
    INSTANCE;

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
    }
}
