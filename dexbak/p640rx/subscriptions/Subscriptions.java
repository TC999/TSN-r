package p640rx.subscriptions;

import java.util.concurrent.Future;
import p640rx.Subscription;
import p640rx.functions.Action0;

/* renamed from: rx.subscriptions.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Subscriptions {

    /* renamed from: a */
    private static final C16192b f47094a = new C16192b();

    /* compiled from: Subscriptions.java */
    /* renamed from: rx.subscriptions.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16191a implements Subscription {

        /* renamed from: a */
        final Future<?> f47095a;

        public C16191a(Future<?> future) {
            this.f47095a = future;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f47095a.isCancelled();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f47095a.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Subscriptions.java */
    /* renamed from: rx.subscriptions.f$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16192b implements Subscription {
        C16192b() {
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
        }
    }

    private Subscriptions() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static Subscription m346a(Action0 action0) {
        return BooleanSubscription.m363b(action0);
    }

    /* renamed from: b */
    public static Subscription m345b() {
        return BooleanSubscription.m364a();
    }

    /* renamed from: c */
    public static Subscription m344c(Future<?> future) {
        return new C16191a(future);
    }

    /* renamed from: d */
    public static CompositeSubscription m343d(Subscription... subscriptionArr) {
        return new CompositeSubscription(subscriptionArr);
    }

    /* renamed from: e */
    public static Subscription m342e() {
        return f47094a;
    }
}
