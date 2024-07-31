package p640rx.internal.operators;

import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;

/* renamed from: rx.internal.operators.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableFlatMapSingleToCompletable<T> implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Single<T> f45312a;

    /* renamed from: b */
    final Func1<? super T, ? extends Completable> f45313b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableFlatMapSingleToCompletable.java */
    /* renamed from: rx.internal.operators.i$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15747a<T> extends SingleSubscriber<T> implements CompletableSubscriber {

        /* renamed from: b */
        final CompletableSubscriber f45314b;

        /* renamed from: c */
        final Func1<? super T, ? extends Completable> f45315c;

        public C15747a(CompletableSubscriber completableSubscriber, Func1<? super T, ? extends Completable> func1) {
            this.f45314b = completableSubscriber;
            this.f45315c = func1;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            m743b(subscription);
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            try {
                Completable call = this.f45315c.call(t);
                if (call == null) {
                    onError(new NullPointerException("The mapper returned a null Completable"));
                } else {
                    call.m1909q0(this);
                }
            } catch (Throwable th) {
                C15575a.m1474e(th);
                onError(th);
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            this.f45314b.onCompleted();
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            this.f45314b.onError(th);
        }
    }

    public CompletableFlatMapSingleToCompletable(Single<T> single, Func1<? super T, ? extends Completable> func1) {
        this.f45312a = single;
        this.f45313b = func1;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        C15747a c15747a = new C15747a(completableSubscriber, this.f45313b);
        completableSubscriber.mo640a(c15747a);
        this.f45312a.m1372i0(c15747a);
    }
}
