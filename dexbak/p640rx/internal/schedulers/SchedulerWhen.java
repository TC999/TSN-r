package p640rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.functions.Func1;
import p640rx.internal.operators.BufferUntilSubscriber;
import p640rx.observers.SerializedObserver;
import p640rx.subjects.PublishSubject;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.schedulers.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SchedulerWhen extends Scheduler implements Subscription {

    /* renamed from: d */
    static final Subscription f46398d = new C16020c();

    /* renamed from: e */
    static final Subscription f46399e = Subscriptions.m342e();

    /* renamed from: a */
    private final Scheduler f46400a;

    /* renamed from: b */
    private final Observer<Observable<Completable>> f46401b;

    /* renamed from: c */
    private final Subscription f46402c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerWhen.java */
    /* renamed from: rx.internal.schedulers.k$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16017a implements Func1<AbstractC16024g, Completable> {

        /* renamed from: a */
        final /* synthetic */ Scheduler.AbstractC15607a f46403a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SchedulerWhen.java */
        /* renamed from: rx.internal.schedulers.k$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C16018a implements Completable.InterfaceC15540j0 {

            /* renamed from: a */
            final /* synthetic */ AbstractC16024g f46405a;

            C16018a(AbstractC16024g abstractC16024g) {
                this.f46405a = abstractC16024g;
            }

            @Override // p640rx.functions.Action1
            public void call(CompletableSubscriber completableSubscriber) {
                completableSubscriber.mo640a(this.f46405a);
                this.f46405a.call(C16017a.this.f46403a, completableSubscriber);
            }
        }

        C16017a(Scheduler.AbstractC15607a abstractC15607a) {
            this.f46403a = abstractC15607a;
        }

        @Override // p640rx.functions.Func1
        public Completable call(AbstractC16024g abstractC16024g) {
            return Completable.m1912p(new C16018a(abstractC16024g));
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: rx.internal.schedulers.k$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16019b extends Scheduler.AbstractC15607a {

        /* renamed from: a */
        private final AtomicBoolean f46407a = new AtomicBoolean();

        /* renamed from: b */
        final /* synthetic */ Scheduler.AbstractC15607a f46408b;

        /* renamed from: c */
        final /* synthetic */ Observer f46409c;

        C16019b(Scheduler.AbstractC15607a abstractC15607a, Observer observer) {
            this.f46408b = abstractC15607a;
            this.f46409c = observer;
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: F */
        public Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit) {
            C16021d c16021d = new C16021d(action0, j, timeUnit);
            this.f46409c.onNext(c16021d);
            return c16021d;
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: d */
        public Subscription mo456d(Action0 action0) {
            C16022e c16022e = new C16022e(action0);
            this.f46409c.onNext(c16022e);
            return c16022e;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46407a.get();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (this.f46407a.compareAndSet(false, true)) {
                this.f46408b.unsubscribe();
                this.f46409c.onCompleted();
            }
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: rx.internal.schedulers.k$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16020c implements Subscription {
        C16020c() {
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: rx.internal.schedulers.k$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16021d extends AbstractC16024g {

        /* renamed from: a */
        private final Action0 f46411a;

        /* renamed from: b */
        private final long f46412b;

        /* renamed from: c */
        private final TimeUnit f46413c;

        public C16021d(Action0 action0, long j, TimeUnit timeUnit) {
            this.f46411a = action0;
            this.f46412b = j;
            this.f46413c = timeUnit;
        }

        @Override // p640rx.internal.schedulers.SchedulerWhen.AbstractC16024g
        /* renamed from: b */
        protected Subscription mo934b(Scheduler.AbstractC15607a abstractC15607a, CompletableSubscriber completableSubscriber) {
            return abstractC15607a.mo460F(new C16023f(this.f46411a, completableSubscriber), this.f46412b, this.f46413c);
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: rx.internal.schedulers.k$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16022e extends AbstractC16024g {

        /* renamed from: a */
        private final Action0 f46414a;

        public C16022e(Action0 action0) {
            this.f46414a = action0;
        }

        @Override // p640rx.internal.schedulers.SchedulerWhen.AbstractC16024g
        /* renamed from: b */
        protected Subscription mo934b(Scheduler.AbstractC15607a abstractC15607a, CompletableSubscriber completableSubscriber) {
            return abstractC15607a.mo456d(new C16023f(this.f46414a, completableSubscriber));
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: rx.internal.schedulers.k$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16023f implements Action0 {

        /* renamed from: a */
        private CompletableSubscriber f46415a;

        /* renamed from: b */
        private Action0 f46416b;

        public C16023f(Action0 action0, CompletableSubscriber completableSubscriber) {
            this.f46416b = action0;
            this.f46415a = completableSubscriber;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            try {
                this.f46416b.call();
            } finally {
                this.f46415a.onCompleted();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerWhen.java */
    /* renamed from: rx.internal.schedulers.k$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC16024g extends AtomicReference<Subscription> implements Subscription {
        public AbstractC16024g() {
            super(SchedulerWhen.f46398d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(Scheduler.AbstractC15607a abstractC15607a, CompletableSubscriber completableSubscriber) {
            Subscription subscription;
            Subscription subscription2 = get();
            if (subscription2 != SchedulerWhen.f46399e && subscription2 == (subscription = SchedulerWhen.f46398d)) {
                Subscription mo934b = mo934b(abstractC15607a, completableSubscriber);
                if (compareAndSet(subscription, mo934b)) {
                    return;
                }
                mo934b.unsubscribe();
            }
        }

        /* renamed from: b */
        protected abstract Subscription mo934b(Scheduler.AbstractC15607a abstractC15607a, CompletableSubscriber completableSubscriber);

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            Subscription subscription;
            Subscription subscription2 = SchedulerWhen.f46399e;
            do {
                subscription = get();
                if (subscription == SchedulerWhen.f46399e) {
                    return;
                }
            } while (!compareAndSet(subscription, subscription2));
            if (subscription != SchedulerWhen.f46398d) {
                subscription.unsubscribe();
            }
        }
    }

    public SchedulerWhen(Func1<Observable<Observable<Completable>>, Completable> func1, Scheduler scheduler) {
        this.f46400a = scheduler;
        PublishSubject m427x7 = PublishSubject.m427x7();
        this.f46401b = new SerializedObserver(m427x7);
        this.f46402c = func1.call(m427x7.m1793M3()).m1915n0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p640rx.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC15607a mo450a() {
        Scheduler.AbstractC15607a mo450a = this.f46400a.mo450a();
        BufferUntilSubscriber m1256x7 = BufferUntilSubscriber.m1256x7();
        SerializedObserver serializedObserver = new SerializedObserver(m1256x7);
        Object m1674b3 = m1256x7.m1674b3(new C16017a(mo450a));
        C16019b c16019b = new C16019b(mo450a, serializedObserver);
        this.f46401b.onNext(m1674b3);
        return c16019b;
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f46402c.isUnsubscribed();
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        this.f46402c.unsubscribe();
    }
}
