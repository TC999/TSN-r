package p640rx;

import p640rx.internal.util.SubscriptionList;

/* renamed from: rx.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class SingleSubscriber<T> implements Subscription {

    /* renamed from: a */
    private final SubscriptionList f46815a = new SubscriptionList();

    /* renamed from: b */
    public final void m743b(Subscription subscription) {
        this.f46815a.m808a(subscription);
    }

    /* renamed from: d */
    public abstract void mo446d(T t);

    @Override // p640rx.Subscription
    public final boolean isUnsubscribed() {
        return this.f46815a.isUnsubscribed();
    }

    public abstract void onError(Throwable th);

    @Override // p640rx.Subscription
    public final void unsubscribe() {
        this.f46815a.unsubscribe();
    }
}
