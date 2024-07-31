package p640rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import p640rx.Subscription;
import p640rx.functions.Action0;

/* renamed from: rx.subscriptions.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BooleanSubscription implements Subscription {

    /* renamed from: b */
    static final Action0 f47082b = new C16188a();

    /* renamed from: a */
    final AtomicReference<Action0> f47083a;

    /* compiled from: BooleanSubscription.java */
    /* renamed from: rx.subscriptions.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16188a implements Action0 {
        C16188a() {
        }

        @Override // p640rx.functions.Action0
        public void call() {
        }
    }

    public BooleanSubscription() {
        this.f47083a = new AtomicReference<>();
    }

    /* renamed from: a */
    public static BooleanSubscription m364a() {
        return new BooleanSubscription();
    }

    /* renamed from: b */
    public static BooleanSubscription m363b(Action0 action0) {
        return new BooleanSubscription(action0);
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f47083a.get() == f47082b;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        Action0 andSet;
        Action0 action0 = this.f47083a.get();
        Action0 action02 = f47082b;
        if (action0 == action02 || (andSet = this.f47083a.getAndSet(action02)) == null || andSet == action02) {
            return;
        }
        andSet.call();
    }

    private BooleanSubscription(Action0 action0) {
        this.f47083a = new AtomicReference<>(action0);
    }
}
