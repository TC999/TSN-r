package p640rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.internal.schedulers.SchedulePeriodicHelper;
import p640rx.subscriptions.BooleanSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.schedulers.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class TestScheduler extends Scheduler {

    /* renamed from: c */
    static long f46972c;

    /* renamed from: a */
    final Queue<C16164c> f46973a = new PriorityQueue(11, new C16160a());

    /* renamed from: b */
    long f46974b;

    /* compiled from: TestScheduler.java */
    /* renamed from: rx.schedulers.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16160a implements Comparator<C16164c> {
        C16160a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C16164c c16164c, C16164c c16164c2) {
            long j = c16164c.f46981a;
            long j2 = c16164c2.f46981a;
            if (j == j2) {
                if (c16164c.f46984d < c16164c2.f46984d) {
                    return -1;
                }
                return c16164c.f46984d > c16164c2.f46984d ? 1 : 0;
            } else if (j < j2) {
                return -1;
            } else {
                return j > j2 ? 1 : 0;
            }
        }
    }

    /* compiled from: TestScheduler.java */
    /* renamed from: rx.schedulers.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    final class C16161b extends Scheduler.AbstractC15607a implements SchedulePeriodicHelper.InterfaceC16016b {

        /* renamed from: a */
        private final BooleanSubscription f46975a = new BooleanSubscription();

        /* compiled from: TestScheduler.java */
        /* renamed from: rx.schedulers.d$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C16162a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ C16164c f46977a;

            C16162a(C16164c c16164c) {
                this.f46977a = c16164c;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                TestScheduler.this.f46973a.remove(this.f46977a);
            }
        }

        /* compiled from: TestScheduler.java */
        /* renamed from: rx.schedulers.d$b$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C16163b implements Action0 {

            /* renamed from: a */
            final /* synthetic */ C16164c f46979a;

            C16163b(C16164c c16164c) {
                this.f46979a = c16164c;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                TestScheduler.this.f46973a.remove(this.f46979a);
            }
        }

        C16161b() {
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: F */
        public Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit) {
            C16164c c16164c = new C16164c(this, TestScheduler.this.f46974b + timeUnit.toNanos(j), action0);
            TestScheduler.this.f46973a.add(c16164c);
            return Subscriptions.m346a(new C16162a(c16164c));
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: G */
        public Subscription mo459G(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            return SchedulePeriodicHelper.m936a(this, action0, j, j2, timeUnit, this);
        }

        @Override // p640rx.internal.schedulers.SchedulePeriodicHelper.InterfaceC16016b
        /* renamed from: a */
        public long mo458a() {
            return TestScheduler.this.f46974b;
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: b */
        public long mo457b() {
            return TestScheduler.this.mo462b();
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: d */
        public Subscription mo456d(Action0 action0) {
            C16164c c16164c = new C16164c(this, 0L, action0);
            TestScheduler.this.f46973a.add(c16164c);
            return Subscriptions.m346a(new C16163b(c16164c));
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46975a.isUnsubscribed();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f46975a.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TestScheduler.java */
    /* renamed from: rx.schedulers.d$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16164c {

        /* renamed from: a */
        final long f46981a;

        /* renamed from: b */
        final Action0 f46982b;

        /* renamed from: c */
        final Scheduler.AbstractC15607a f46983c;

        /* renamed from: d */
        private final long f46984d;

        C16164c(Scheduler.AbstractC15607a abstractC15607a, long j, Action0 action0) {
            long j2 = TestScheduler.f46972c;
            TestScheduler.f46972c = 1 + j2;
            this.f46984d = j2;
            this.f46981a = j;
            this.f46982b = action0;
            this.f46983c = abstractC15607a;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f46981a), this.f46982b.toString());
        }
    }

    /* renamed from: I */
    private void m463I(long j) {
        while (!this.f46973a.isEmpty()) {
            C16164c peek = this.f46973a.peek();
            long j2 = peek.f46981a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.f46974b;
            }
            this.f46974b = j2;
            this.f46973a.remove();
            if (!peek.f46983c.isUnsubscribed()) {
                peek.f46982b.call();
            }
        }
        this.f46974b = j;
    }

    /* renamed from: F */
    public void m466F(long j, TimeUnit timeUnit) {
        m465G(this.f46974b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    /* renamed from: G */
    public void m465G(long j, TimeUnit timeUnit) {
        m463I(timeUnit.toNanos(j));
    }

    /* renamed from: H */
    public void m464H() {
        m463I(this.f46974b);
    }

    @Override // p640rx.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC15607a mo450a() {
        return new C16161b();
    }

    @Override // p640rx.Scheduler
    /* renamed from: b */
    public long mo462b() {
        return TimeUnit.NANOSECONDS.toMillis(this.f46974b);
    }
}
