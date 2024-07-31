package p640rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Observable;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.Subscriber;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.z4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleTakeUntilObservable<T, U> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f46284a;

    /* renamed from: b */
    final Observable<? extends U> f46285b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleTakeUntilObservable.java */
    /* renamed from: rx.internal.operators.z4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15992a<T, U> extends SingleSubscriber<T> {

        /* renamed from: b */
        final SingleSubscriber<? super T> f46286b;

        /* renamed from: c */
        final AtomicBoolean f46287c = new AtomicBoolean();

        /* renamed from: d */
        final Subscriber<U> f46288d;

        /* compiled from: SingleTakeUntilObservable.java */
        /* renamed from: rx.internal.operators.z4$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        final class C15993a extends Subscriber<U> {
            C15993a() {
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                onError(new CancellationException("Single::takeUntil(Observable) - Stream was canceled before emitting a terminal event."));
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15992a.this.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(U u) {
                onCompleted();
            }
        }

        C15992a(SingleSubscriber<? super T> singleSubscriber) {
            this.f46286b = singleSubscriber;
            C15993a c15993a = new C15993a();
            this.f46288d = c15993a;
            m743b(c15993a);
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            if (this.f46287c.compareAndSet(false, true)) {
                unsubscribe();
                this.f46286b.mo446d(t);
            }
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            if (this.f46287c.compareAndSet(false, true)) {
                unsubscribe();
                this.f46286b.onError(th);
                return;
            }
            RxJavaHooks.m576I(th);
        }
    }

    public SingleTakeUntilObservable(Single.InterfaceC15633t<T> interfaceC15633t, Observable<? extends U> observable) {
        this.f46284a = interfaceC15633t;
        this.f46285b = observable;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15992a c15992a = new C15992a(singleSubscriber);
        singleSubscriber.m743b(c15992a);
        this.f46285b.m1551q5(c15992a.f46288d);
        this.f46284a.call(c15992a);
    }
}
