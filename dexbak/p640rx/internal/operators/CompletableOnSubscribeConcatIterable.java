package p640rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.subscriptions.SerialSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableOnSubscribeConcatIterable implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Iterable<? extends Completable> f45516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeConcatIterable.java */
    /* renamed from: rx.internal.operators.m$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15789a extends AtomicInteger implements CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: a */
        final CompletableSubscriber f45517a;

        /* renamed from: b */
        final Iterator<? extends Completable> f45518b;

        /* renamed from: c */
        final SerialSubscription f45519c = new SerialSubscription();

        public C15789a(CompletableSubscriber completableSubscriber, Iterator<? extends Completable> it) {
            this.f45517a = completableSubscriber;
            this.f45518b = it;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f45519c.m347b(subscription);
        }

        /* renamed from: b */
        void m1157b() {
            if (!this.f45519c.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends Completable> it = this.f45518b;
                while (!this.f45519c.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.f45517a.onCompleted();
                            return;
                        }
                        try {
                            Completable next = it.next();
                            if (next == null) {
                                this.f45517a.onError(new NullPointerException("The completable returned is null"));
                                return;
                            }
                            next.m1967G0(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            this.f45517a.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        this.f45517a.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            m1157b();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f45517a.onError(th);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends Completable> iterable) {
        this.f45516a = iterable;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        try {
            Iterator<? extends Completable> it = this.f45516a.iterator();
            if (it == null) {
                completableSubscriber.mo640a(Subscriptions.m342e());
                completableSubscriber.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            C15789a c15789a = new C15789a(completableSubscriber, it);
            completableSubscriber.mo640a(c15789a.f45519c);
            c15789a.m1157b();
        } catch (Throwable th) {
            completableSubscriber.mo640a(Subscriptions.m342e());
            completableSubscriber.onError(th);
        }
    }
}
