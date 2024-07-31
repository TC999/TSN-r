package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Completable;
import p640rx.CompletableEmitter;
import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action1;
import p640rx.functions.Cancellable;
import p640rx.internal.subscriptions.CancellableSubscription;
import p640rx.internal.subscriptions.SequentialSubscription;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableFromEmitter implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Action1<CompletableEmitter> f45365a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableFromEmitter.java */
    /* renamed from: rx.internal.operators.j$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15757a extends AtomicBoolean implements CompletableEmitter, Subscription {
        private static final long serialVersionUID = 5539301318568668881L;

        /* renamed from: a */
        final CompletableSubscriber f45366a;

        /* renamed from: b */
        final SequentialSubscription f45367b = new SequentialSubscription();

        public C15757a(CompletableSubscriber completableSubscriber) {
            this.f45366a = completableSubscriber;
        }

        @Override // p640rx.CompletableEmitter
        /* renamed from: a */
        public void mo1206a(Subscription subscription) {
            this.f45367b.update(subscription);
        }

        @Override // p640rx.CompletableEmitter
        /* renamed from: b */
        public void mo1205b(Cancellable cancellable) {
            mo1206a(new CancellableSubscription(cancellable));
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // p640rx.CompletableEmitter
        public void onCompleted() {
            if (compareAndSet(false, true)) {
                try {
                    this.f45366a.onCompleted();
                } finally {
                    this.f45367b.unsubscribe();
                }
            }
        }

        @Override // p640rx.CompletableEmitter
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                try {
                    this.f45366a.onError(th);
                    return;
                } finally {
                    this.f45367b.unsubscribe();
                }
            }
            RxJavaHooks.m576I(th);
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f45367b.unsubscribe();
            }
        }
    }

    public CompletableFromEmitter(Action1<CompletableEmitter> action1) {
        this.f45365a = action1;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        C15757a c15757a = new C15757a(completableSubscriber);
        completableSubscriber.mo640a(c15757a);
        try {
            this.f45365a.call(c15757a);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            c15757a.onError(th);
        }
    }
}
