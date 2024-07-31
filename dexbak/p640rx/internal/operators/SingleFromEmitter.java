package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Single;
import p640rx.SingleEmitter;
import p640rx.SingleSubscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action1;
import p640rx.functions.Cancellable;
import p640rx.internal.subscriptions.CancellableSubscription;
import p640rx.internal.subscriptions.SequentialSubscription;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.n4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleFromEmitter<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Action1<SingleEmitter<T>> f45586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleFromEmitter.java */
    /* renamed from: rx.internal.operators.n4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15805a<T> extends AtomicBoolean implements SingleEmitter<T>, Subscription {
        private static final long serialVersionUID = 8082834163465882809L;

        /* renamed from: a */
        final SingleSubscriber<? super T> f45587a;

        /* renamed from: b */
        final SequentialSubscription f45588b = new SequentialSubscription();

        C15805a(SingleSubscriber<? super T> singleSubscriber) {
            this.f45587a = singleSubscriber;
        }

        @Override // p640rx.SingleEmitter
        /* renamed from: a */
        public void mo745a(Subscription subscription) {
            this.f45588b.update(subscription);
        }

        @Override // p640rx.SingleEmitter
        /* renamed from: b */
        public void mo744b(Cancellable cancellable) {
            mo745a(new CancellableSubscription(cancellable));
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // p640rx.SingleEmitter
        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException();
            }
            if (compareAndSet(false, true)) {
                try {
                    this.f45587a.onError(th);
                    return;
                } finally {
                    this.f45588b.unsubscribe();
                }
            }
            RxJavaHooks.m576I(th);
        }

        @Override // p640rx.SingleEmitter
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                try {
                    this.f45587a.mo446d(t);
                } finally {
                    this.f45588b.unsubscribe();
                }
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f45588b.unsubscribe();
            }
        }
    }

    public SingleFromEmitter(Action1<SingleEmitter<T>> action1) {
        this.f45586a = action1;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15805a c15805a = new C15805a(singleSubscriber);
        singleSubscriber.m743b(c15805a);
        try {
            this.f45586a.call(c15805a);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            c15805a.onError(th);
        }
    }
}
