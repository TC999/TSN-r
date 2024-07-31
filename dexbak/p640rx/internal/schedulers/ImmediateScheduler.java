package p640rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.subscriptions.BooleanSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.schedulers.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ImmediateScheduler extends Scheduler {

    /* renamed from: a */
    public static final ImmediateScheduler f46372a = new ImmediateScheduler();

    /* compiled from: ImmediateScheduler.java */
    /* renamed from: rx.internal.schedulers.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    final class C16013a extends Scheduler.AbstractC15607a implements Subscription {

        /* renamed from: a */
        final BooleanSubscription f46373a = new BooleanSubscription();

        C16013a() {
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: F */
        public Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit) {
            return mo456d(new SleepingAction(action0, this, ImmediateScheduler.this.mo462b() + timeUnit.toMillis(j)));
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: d */
        public Subscription mo456d(Action0 action0) {
            action0.call();
            return Subscriptions.m342e();
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46373a.isUnsubscribed();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f46373a.unsubscribe();
        }
    }

    private ImmediateScheduler() {
    }

    @Override // p640rx.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC15607a mo450a() {
        return new C16013a();
    }
}
