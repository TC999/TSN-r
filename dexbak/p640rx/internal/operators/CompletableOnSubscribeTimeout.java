package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableOnSubscribeTimeout implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Completable f45813a;

    /* renamed from: b */
    final long f45814b;

    /* renamed from: c */
    final TimeUnit f45815c;

    /* renamed from: d */
    final Scheduler f45816d;

    /* renamed from: e */
    final Completable f45817e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeTimeout.java */
    /* renamed from: rx.internal.operators.s$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15864a implements Action0 {

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f45818a;

        /* renamed from: b */
        final /* synthetic */ CompositeSubscription f45819b;

        /* renamed from: c */
        final /* synthetic */ CompletableSubscriber f45820c;

        /* compiled from: CompletableOnSubscribeTimeout.java */
        /* renamed from: rx.internal.operators.s$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15865a implements CompletableSubscriber {
            C15865a() {
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                C15864a.this.f45819b.m359a(subscription);
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                C15864a.this.f45819b.unsubscribe();
                C15864a.this.f45820c.onCompleted();
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                C15864a.this.f45819b.unsubscribe();
                C15864a.this.f45820c.onError(th);
            }
        }

        C15864a(AtomicBoolean atomicBoolean, CompositeSubscription compositeSubscription, CompletableSubscriber completableSubscriber) {
            this.f45818a = atomicBoolean;
            this.f45819b = compositeSubscription;
            this.f45820c = completableSubscriber;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            if (this.f45818a.compareAndSet(false, true)) {
                this.f45819b.m357d();
                Completable completable = CompletableOnSubscribeTimeout.this.f45817e;
                if (completable == null) {
                    this.f45820c.onError(new TimeoutException());
                } else {
                    completable.m1967G0(new C15865a());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeTimeout.java */
    /* renamed from: rx.internal.operators.s$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15866b implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ CompositeSubscription f45823a;

        /* renamed from: b */
        final /* synthetic */ AtomicBoolean f45824b;

        /* renamed from: c */
        final /* synthetic */ CompletableSubscriber f45825c;

        C15866b(CompositeSubscription compositeSubscription, AtomicBoolean atomicBoolean, CompletableSubscriber completableSubscriber) {
            this.f45823a = compositeSubscription;
            this.f45824b = atomicBoolean;
            this.f45825c = completableSubscriber;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f45823a.m359a(subscription);
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            if (this.f45824b.compareAndSet(false, true)) {
                this.f45823a.unsubscribe();
                this.f45825c.onCompleted();
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            if (this.f45824b.compareAndSet(false, true)) {
                this.f45823a.unsubscribe();
                this.f45825c.onError(th);
                return;
            }
            RxJavaHooks.m576I(th);
        }
    }

    public CompletableOnSubscribeTimeout(Completable completable, long j, TimeUnit timeUnit, Scheduler scheduler, Completable completable2) {
        this.f45813a = completable;
        this.f45814b = j;
        this.f45815c = timeUnit;
        this.f45816d = scheduler;
        this.f45817e = completable2;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.mo640a(compositeSubscription);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        Scheduler.AbstractC15607a mo450a = this.f45816d.mo450a();
        compositeSubscription.m359a(mo450a);
        mo450a.mo460F(new C15864a(atomicBoolean, compositeSubscription, completableSubscriber), this.f45814b, this.f45815c);
        this.f45813a.m1967G0(new C15866b(compositeSubscription, atomicBoolean, completableSubscriber));
    }
}
