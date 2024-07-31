package p640rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.internal.util.RxThreadFactory;
import p640rx.internal.util.SubscriptionList;
import p640rx.subscriptions.CompositeSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.schedulers.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class EventLoopsScheduler extends Scheduler implements SchedulerLifecycle {

    /* renamed from: c */
    static final String f46335c = "rx.scheduler.max-computation-threads";

    /* renamed from: d */
    static final int f46336d;

    /* renamed from: e */
    static final C16009c f46337e;

    /* renamed from: f */
    static final C16008b f46338f;

    /* renamed from: a */
    final ThreadFactory f46339a;

    /* renamed from: b */
    final AtomicReference<C16008b> f46340b = new AtomicReference<>(f46338f);

    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: rx.internal.schedulers.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16005a extends Scheduler.AbstractC15607a {

        /* renamed from: a */
        private final SubscriptionList f46341a;

        /* renamed from: b */
        private final CompositeSubscription f46342b;

        /* renamed from: c */
        private final SubscriptionList f46343c;

        /* renamed from: d */
        private final C16009c f46344d;

        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: rx.internal.schedulers.b$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C16006a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ Action0 f46345a;

            C16006a(Action0 action0) {
                this.f46345a = action0;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                if (C16005a.this.isUnsubscribed()) {
                    return;
                }
                this.f46345a.call();
            }
        }

        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: rx.internal.schedulers.b$a$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C16007b implements Action0 {

            /* renamed from: a */
            final /* synthetic */ Action0 f46347a;

            C16007b(Action0 action0) {
                this.f46347a = action0;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                if (C16005a.this.isUnsubscribed()) {
                    return;
                }
                this.f46347a.call();
            }
        }

        C16005a(C16009c c16009c) {
            SubscriptionList subscriptionList = new SubscriptionList();
            this.f46341a = subscriptionList;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.f46342b = compositeSubscription;
            this.f46343c = new SubscriptionList(subscriptionList, compositeSubscription);
            this.f46344d = c16009c;
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: F */
        public Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return Subscriptions.m342e();
            }
            return this.f46344d.m938N(new C16007b(action0), j, timeUnit, this.f46342b);
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: d */
        public Subscription mo456d(Action0 action0) {
            if (isUnsubscribed()) {
                return Subscriptions.m342e();
            }
            return this.f46344d.m939M(new C16006a(action0), 0L, null, this.f46341a);
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46343c.isUnsubscribed();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f46343c.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: rx.internal.schedulers.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16008b {

        /* renamed from: a */
        final int f46349a;

        /* renamed from: b */
        final C16009c[] f46350b;

        /* renamed from: c */
        long f46351c;

        C16008b(ThreadFactory threadFactory, int i) {
            this.f46349a = i;
            this.f46350b = new C16009c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f46350b[i2] = new C16009c(threadFactory);
            }
        }

        /* renamed from: a */
        public C16009c m950a() {
            int i = this.f46349a;
            if (i == 0) {
                return EventLoopsScheduler.f46337e;
            }
            C16009c[] c16009cArr = this.f46350b;
            long j = this.f46351c;
            this.f46351c = 1 + j;
            return c16009cArr[(int) (j % i)];
        }

        /* renamed from: b */
        public void m949b() {
            for (C16009c c16009c : this.f46350b) {
                c16009c.unsubscribe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: rx.internal.schedulers.b$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16009c extends NewThreadWorker {
        C16009c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger(f46335c, 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f46336d = intValue;
        C16009c c16009c = new C16009c(RxThreadFactory.NONE);
        f46337e = c16009c;
        c16009c.unsubscribe();
        f46338f = new C16008b(null, 0);
    }

    public EventLoopsScheduler(ThreadFactory threadFactory) {
        this.f46339a = threadFactory;
        start();
    }

    /* renamed from: F */
    public Subscription m951F(Action0 action0) {
        return this.f46340b.get().m950a().m940L(action0, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // p640rx.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC15607a mo450a() {
        return new C16005a(this.f46340b.get().m950a());
    }

    @Override // p640rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        C16008b c16008b;
        C16008b c16008b2;
        do {
            c16008b = this.f46340b.get();
            c16008b2 = f46338f;
            if (c16008b == c16008b2) {
                return;
            }
        } while (!this.f46340b.compareAndSet(c16008b, c16008b2));
        c16008b.m949b();
    }

    @Override // p640rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        C16008b c16008b = new C16008b(this.f46339a, f46336d);
        if (this.f46340b.compareAndSet(f46338f, c16008b)) {
            return;
        }
        c16008b.m949b();
    }
}
