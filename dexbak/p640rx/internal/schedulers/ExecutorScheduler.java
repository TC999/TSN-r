package p640rx.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;
import p640rx.subscriptions.MultipleAssignmentSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.schedulers.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ExecutorScheduler extends Scheduler {

    /* renamed from: a */
    final Executor f46352a;

    /* compiled from: ExecutorScheduler.java */
    /* renamed from: rx.internal.schedulers.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class RunnableC16010a extends Scheduler.AbstractC15607a implements Runnable {

        /* renamed from: a */
        final Executor f46353a;

        /* renamed from: c */
        final ConcurrentLinkedQueue<ScheduledAction> f46355c = new ConcurrentLinkedQueue<>();

        /* renamed from: d */
        final AtomicInteger f46356d = new AtomicInteger();

        /* renamed from: b */
        final CompositeSubscription f46354b = new CompositeSubscription();

        /* renamed from: e */
        final ScheduledExecutorService f46357e = GenericScheduledExecutorService.m948a();

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: rx.internal.schedulers.c$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C16011a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ MultipleAssignmentSubscription f46358a;

            C16011a(MultipleAssignmentSubscription multipleAssignmentSubscription) {
                this.f46358a = multipleAssignmentSubscription;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                RunnableC16010a.this.f46354b.m361G(this.f46358a);
            }
        }

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: rx.internal.schedulers.c$a$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C16012b implements Action0 {

            /* renamed from: a */
            final /* synthetic */ MultipleAssignmentSubscription f46360a;

            /* renamed from: b */
            final /* synthetic */ Action0 f46361b;

            /* renamed from: c */
            final /* synthetic */ Subscription f46362c;

            C16012b(MultipleAssignmentSubscription multipleAssignmentSubscription, Action0 action0, Subscription subscription) {
                this.f46360a = multipleAssignmentSubscription;
                this.f46361b = action0;
                this.f46362c = subscription;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                if (this.f46360a.isUnsubscribed()) {
                    return;
                }
                Subscription mo456d = RunnableC16010a.this.mo456d(this.f46361b);
                this.f46360a.m355b(mo456d);
                if (mo456d.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) mo456d).add(this.f46362c);
                }
            }
        }

        public RunnableC16010a(Executor executor) {
            this.f46353a = executor;
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: F */
        public Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return mo456d(action0);
            }
            if (isUnsubscribed()) {
                return Subscriptions.m342e();
            }
            Action0 m569P = RxJavaHooks.m569P(action0);
            MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            MultipleAssignmentSubscription multipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
            multipleAssignmentSubscription2.m355b(multipleAssignmentSubscription);
            this.f46354b.m359a(multipleAssignmentSubscription2);
            Subscription m346a = Subscriptions.m346a(new C16011a(multipleAssignmentSubscription2));
            ScheduledAction scheduledAction = new ScheduledAction(new C16012b(multipleAssignmentSubscription2, m569P, m346a));
            multipleAssignmentSubscription.m355b(scheduledAction);
            try {
                scheduledAction.add(this.f46357e.schedule(scheduledAction, j, timeUnit));
                return m346a;
            } catch (RejectedExecutionException e) {
                RxJavaHooks.m576I(e);
                throw e;
            }
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: d */
        public Subscription mo456d(Action0 action0) {
            if (isUnsubscribed()) {
                return Subscriptions.m342e();
            }
            ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.m569P(action0), this.f46354b);
            this.f46354b.m359a(scheduledAction);
            this.f46355c.offer(scheduledAction);
            if (this.f46356d.getAndIncrement() == 0) {
                try {
                    this.f46353a.execute(this);
                } catch (RejectedExecutionException e) {
                    this.f46354b.m361G(scheduledAction);
                    this.f46356d.decrementAndGet();
                    RxJavaHooks.m576I(e);
                    throw e;
                }
            }
            return scheduledAction;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46354b.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f46354b.isUnsubscribed()) {
                ScheduledAction poll = this.f46355c.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (!this.f46354b.isUnsubscribed()) {
                        poll.run();
                    } else {
                        this.f46355c.clear();
                        return;
                    }
                }
                if (this.f46356d.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f46355c.clear();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f46354b.unsubscribe();
            this.f46355c.clear();
        }
    }

    public ExecutorScheduler(Executor executor) {
        this.f46352a = executor;
    }

    @Override // p640rx.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC15607a mo450a() {
        return new RunnableC16010a(this.f46352a);
    }
}
