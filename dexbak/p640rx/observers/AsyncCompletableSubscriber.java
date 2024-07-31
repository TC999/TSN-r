package p640rx.observers;

import java.util.concurrent.atomic.AtomicReference;
import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.observers.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AsyncCompletableSubscriber implements CompletableSubscriber, Subscription {

    /* renamed from: b */
    static final C16124a f46893b = new C16124a();

    /* renamed from: a */
    private final AtomicReference<Subscription> f46894a = new AtomicReference<>();

    /* compiled from: AsyncCompletableSubscriber.java */
    /* renamed from: rx.observers.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16124a implements Subscription {
        C16124a() {
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
        }
    }

    @Override // p640rx.CompletableSubscriber
    /* renamed from: a */
    public final void mo640a(Subscription subscription) {
        if (!this.f46894a.compareAndSet(null, subscription)) {
            subscription.unsubscribe();
            if (this.f46894a.get() != f46893b) {
                RxJavaHooks.m576I(new IllegalStateException("Subscription already set!"));
                return;
            }
            return;
        }
        onStart();
    }

    /* renamed from: b */
    protected final void m645b() {
        this.f46894a.set(f46893b);
    }

    @Override // p640rx.Subscription
    public final boolean isUnsubscribed() {
        return this.f46894a.get() == f46893b;
    }

    protected void onStart() {
    }

    @Override // p640rx.Subscription
    public final void unsubscribe() {
        Subscription andSet;
        Subscription subscription = this.f46894a.get();
        C16124a c16124a = f46893b;
        if (subscription == c16124a || (andSet = this.f46894a.getAndSet(c16124a)) == null || andSet == c16124a) {
            return;
        }
        andSet.unsubscribe();
    }
}
