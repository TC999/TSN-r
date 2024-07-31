package p640rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.subscriptions.BooleanSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.schedulers.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class TrampolineScheduler extends Scheduler {

    /* renamed from: a */
    public static final TrampolineScheduler f46420a = new TrampolineScheduler();

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: rx.internal.schedulers.m$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16025a extends Scheduler.AbstractC15607a implements Subscription {

        /* renamed from: a */
        final AtomicInteger f46421a = new AtomicInteger();

        /* renamed from: b */
        final PriorityBlockingQueue<C16027b> f46422b = new PriorityBlockingQueue<>();

        /* renamed from: c */
        private final BooleanSubscription f46423c = new BooleanSubscription();

        /* renamed from: d */
        private final AtomicInteger f46424d = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* renamed from: rx.internal.schedulers.m$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C16026a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ C16027b f46425a;

            C16026a(C16027b c16027b) {
                this.f46425a = c16027b;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C16025a.this.f46422b.remove(this.f46425a);
            }
        }

        C16025a() {
        }

        /* renamed from: H */
        private Subscription m932H(Action0 action0, long j) {
            if (this.f46423c.isUnsubscribed()) {
                return Subscriptions.m342e();
            }
            C16027b c16027b = new C16027b(action0, Long.valueOf(j), this.f46421a.incrementAndGet());
            this.f46422b.add(c16027b);
            if (this.f46424d.getAndIncrement() == 0) {
                do {
                    C16027b poll = this.f46422b.poll();
                    if (poll != null) {
                        poll.f46427a.call();
                    }
                } while (this.f46424d.decrementAndGet() > 0);
                return Subscriptions.m342e();
            }
            return Subscriptions.m346a(new C16026a(c16027b));
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: F */
        public Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit) {
            long mo457b = mo457b() + timeUnit.toMillis(j);
            return m932H(new SleepingAction(action0, this, mo457b), mo457b);
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: d */
        public Subscription mo456d(Action0 action0) {
            return m932H(action0, mo457b());
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46423c.isUnsubscribed();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f46423c.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* renamed from: rx.internal.schedulers.m$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16027b implements Comparable<C16027b> {

        /* renamed from: a */
        final Action0 f46427a;

        /* renamed from: b */
        final Long f46428b;

        /* renamed from: c */
        final int f46429c;

        C16027b(Action0 action0, Long l, int i) {
            this.f46427a = action0;
            this.f46428b = l;
            this.f46429c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C16027b c16027b) {
            int compareTo = this.f46428b.compareTo(c16027b.f46428b);
            return compareTo == 0 ? TrampolineScheduler.m933F(this.f46429c, c16027b.f46429c) : compareTo;
        }
    }

    private TrampolineScheduler() {
    }

    /* renamed from: F */
    static int m933F(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    @Override // p640rx.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC15607a mo450a() {
        return new C16025a();
    }
}
