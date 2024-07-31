package p640rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Subscription;
import p640rx.exceptions.OnErrorNotImplementedException;
import p640rx.functions.Action0;
import p640rx.internal.util.SubscriptionList;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.schedulers.ScheduledAction */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    private static final long serialVersionUID = -3962399486978279857L;
    final Action0 action;
    final SubscriptionList cancel;

    /* renamed from: rx.internal.schedulers.ScheduledAction$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    final class C15996a implements Subscription {

        /* renamed from: a */
        private final Future<?> f46307a;

        C15996a(Future<?> future) {
            this.f46307a = future;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46307a.isCancelled();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f46307a.cancel(true);
            } else {
                this.f46307a.cancel(false);
            }
        }
    }

    /* renamed from: rx.internal.schedulers.ScheduledAction$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15997b extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a */
        final ScheduledAction f46309a;

        /* renamed from: b */
        final SubscriptionList f46310b;

        public C15997b(ScheduledAction scheduledAction, SubscriptionList subscriptionList) {
            this.f46309a = scheduledAction;
            this.f46310b = subscriptionList;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46309a.isUnsubscribed();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f46310b.m810F(this.f46309a);
            }
        }
    }

    /* renamed from: rx.internal.schedulers.ScheduledAction$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15998c extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a */
        final ScheduledAction f46311a;

        /* renamed from: b */
        final CompositeSubscription f46312b;

        public C15998c(ScheduledAction scheduledAction, CompositeSubscription compositeSubscription) {
            this.f46311a = scheduledAction;
            this.f46312b = compositeSubscription;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46311a.isUnsubscribed();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f46312b.m361G(this.f46311a);
            }
        }
    }

    public ScheduledAction(Action0 action0) {
        this.action = action0;
        this.cancel = new SubscriptionList();
    }

    public void add(Subscription subscription) {
        this.cancel.m808a(subscription);
    }

    public void addParent(CompositeSubscription compositeSubscription) {
        this.cancel.m808a(new C15998c(this, compositeSubscription));
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } catch (OnErrorNotImplementedException e) {
                signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
            } catch (Throwable th) {
                signalError(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
            }
        } finally {
            unsubscribe();
        }
    }

    void signalError(Throwable th) {
        RxJavaHooks.m576I(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        if (this.cancel.isUnsubscribed()) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public void add(Future<?> future) {
        this.cancel.m808a(new C15996a(future));
    }

    public void addParent(SubscriptionList subscriptionList) {
        this.cancel.m808a(new C15997b(this, subscriptionList));
    }

    public ScheduledAction(Action0 action0, CompositeSubscription compositeSubscription) {
        this.action = action0;
        this.cancel = new SubscriptionList(new C15998c(this, compositeSubscription));
    }

    public ScheduledAction(Action0 action0, SubscriptionList subscriptionList) {
        this.action = action0;
        this.cancel = new SubscriptionList(new C15997b(this, subscriptionList));
    }
}
