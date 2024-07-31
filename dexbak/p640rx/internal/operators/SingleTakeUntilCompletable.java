package p640rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.Subscription;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.y4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleTakeUntilCompletable<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f46222a;

    /* renamed from: b */
    final Completable f46223b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleTakeUntilCompletable.java */
    /* renamed from: rx.internal.operators.y4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15978a<T> extends SingleSubscriber<T> implements CompletableSubscriber {

        /* renamed from: b */
        final SingleSubscriber<? super T> f46224b;

        /* renamed from: c */
        final AtomicBoolean f46225c = new AtomicBoolean();

        C15978a(SingleSubscriber<? super T> singleSubscriber) {
            this.f46224b = singleSubscriber;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            m743b(subscription);
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            if (this.f46225c.compareAndSet(false, true)) {
                unsubscribe();
                this.f46224b.mo446d(t);
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            onError(new CancellationException("Single::takeUntil(Completable) - Stream was canceled before emitting a terminal event."));
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            if (this.f46225c.compareAndSet(false, true)) {
                unsubscribe();
                this.f46224b.onError(th);
                return;
            }
            RxJavaHooks.m576I(th);
        }
    }

    public SingleTakeUntilCompletable(Single.InterfaceC15633t<T> interfaceC15633t, Completable completable) {
        this.f46222a = interfaceC15633t;
        this.f46223b = completable;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15978a c15978a = new C15978a(singleSubscriber);
        singleSubscriber.m743b(c15978a);
        this.f46223b.m1909q0(c15978a);
        this.f46222a.call(c15978a);
    }
}
