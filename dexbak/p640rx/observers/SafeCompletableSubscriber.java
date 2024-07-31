package p640rx.observers;

import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.CompositeException;
import p640rx.exceptions.OnCompletedFailedException;
import p640rx.exceptions.OnErrorFailedException;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.observers.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SafeCompletableSubscriber implements CompletableSubscriber, Subscription {

    /* renamed from: a */
    final CompletableSubscriber f46902a;

    /* renamed from: b */
    Subscription f46903b;

    /* renamed from: c */
    boolean f46904c;

    public SafeCompletableSubscriber(CompletableSubscriber completableSubscriber) {
        this.f46902a = completableSubscriber;
    }

    @Override // p640rx.CompletableSubscriber
    /* renamed from: a */
    public void mo640a(Subscription subscription) {
        this.f46903b = subscription;
        try {
            this.f46902a.mo640a(this);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            subscription.unsubscribe();
            onError(th);
        }
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f46904c || this.f46903b.isUnsubscribed();
    }

    @Override // p640rx.CompletableSubscriber
    public void onCompleted() {
        if (this.f46904c) {
            return;
        }
        this.f46904c = true;
        try {
            this.f46902a.onCompleted();
        } catch (Throwable th) {
            C15575a.m1474e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // p640rx.CompletableSubscriber
    public void onError(Throwable th) {
        RxJavaHooks.m576I(th);
        if (this.f46904c) {
            return;
        }
        this.f46904c = true;
        try {
            this.f46902a.onError(th);
        } catch (Throwable th2) {
            C15575a.m1474e(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        this.f46903b.unsubscribe();
    }
}
