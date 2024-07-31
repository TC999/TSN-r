package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.OnErrorThrowable;
import p640rx.functions.Func1;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.h0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeFilter<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Observable<T> f45268a;

    /* renamed from: b */
    final Func1<? super T, Boolean> f45269b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFilter.java */
    /* renamed from: rx.internal.operators.h0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15736a<T> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super T> f45270a;

        /* renamed from: b */
        final Func1<? super T, Boolean> f45271b;

        /* renamed from: c */
        boolean f45272c;

        public C15736a(Subscriber<? super T> subscriber, Func1<? super T, Boolean> func1) {
            this.f45270a = subscriber;
            this.f45271b = func1;
            request(0L);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45272c) {
                return;
            }
            this.f45270a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45272c) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45272c = true;
            this.f45270a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                if (this.f45271b.call(t).booleanValue()) {
                    this.f45270a.onNext(t);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.f45270a.setProducer(producer);
        }
    }

    public OnSubscribeFilter(Observable<T> observable, Func1<? super T, Boolean> func1) {
        this.f45268a = observable;
        this.f45269b = func1;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        C15736a c15736a = new C15736a(subscriber, this.f45269b);
        subscriber.add(c15736a);
        this.f45268a.m1822I6(c15736a);
    }
}
