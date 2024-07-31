package p640rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.a5 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleTakeUntilSingle<T, U> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f44939a;

    /* renamed from: b */
    final Single<? extends U> f44940b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleTakeUntilSingle.java */
    /* renamed from: rx.internal.operators.a5$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15655a<T, U> extends SingleSubscriber<T> {

        /* renamed from: b */
        final SingleSubscriber<? super T> f44941b;

        /* renamed from: c */
        final AtomicBoolean f44942c = new AtomicBoolean();

        /* renamed from: d */
        final SingleSubscriber<U> f44943d;

        /* compiled from: SingleTakeUntilSingle.java */
        /* renamed from: rx.internal.operators.a5$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        final class C15656a extends SingleSubscriber<U> {
            C15656a() {
            }

            @Override // p640rx.SingleSubscriber
            /* renamed from: d */
            public void mo446d(U u) {
                onError(new CancellationException("Single::takeUntil(Single) - Stream was canceled before emitting a terminal event."));
            }

            @Override // p640rx.SingleSubscriber
            public void onError(Throwable th) {
                C15655a.this.onError(th);
            }
        }

        C15655a(SingleSubscriber<? super T> singleSubscriber) {
            this.f44941b = singleSubscriber;
            C15656a c15656a = new C15656a();
            this.f44943d = c15656a;
            m743b(c15656a);
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            if (this.f44942c.compareAndSet(false, true)) {
                unsubscribe();
                this.f44941b.mo446d(t);
            }
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            if (this.f44942c.compareAndSet(false, true)) {
                unsubscribe();
                this.f44941b.onError(th);
                return;
            }
            RxJavaHooks.m576I(th);
        }
    }

    public SingleTakeUntilSingle(Single.InterfaceC15633t<T> interfaceC15633t, Single<? extends U> single) {
        this.f44939a = interfaceC15633t;
        this.f44940b = single;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15655a c15655a = new C15655a(singleSubscriber);
        singleSubscriber.m743b(c15655a);
        this.f44940b.m1372i0(c15655a.f44943d);
        this.f44939a.call(c15655a);
    }
}
