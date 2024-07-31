package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.internal.operators.SingleFromObservable;
import p640rx.internal.producers.SingleProducer;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.q4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleLiftObservableOperator<T, R> implements Single.InterfaceC15633t<R> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f45753a;

    /* renamed from: b */
    final Observable.InterfaceC15568b<? extends R, ? super T> f45754b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleLiftObservableOperator.java */
    /* renamed from: rx.internal.operators.q4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15846a<T> extends SingleSubscriber<T> {

        /* renamed from: b */
        final Subscriber<? super T> f45755b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C15846a(Subscriber<? super T> subscriber) {
            this.f45755b = subscriber;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            this.f45755b.setProducer(new SingleProducer(this.f45755b, t));
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            this.f45755b.onError(th);
        }
    }

    public SingleLiftObservableOperator(Single.InterfaceC15633t<T> interfaceC15633t, Observable.InterfaceC15568b<? extends R, ? super T> interfaceC15568b) {
        this.f45753a = interfaceC15633t;
        this.f45754b = interfaceC15568b;
    }

    /* renamed from: a */
    public static <T> SingleSubscriber<T> m1112a(Subscriber<T> subscriber) {
        C15846a c15846a = new C15846a(subscriber);
        subscriber.add(c15846a);
        return c15846a;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super R> singleSubscriber) {
        SingleFromObservable.C15837a c15837a = new SingleFromObservable.C15837a(singleSubscriber);
        singleSubscriber.m743b(c15837a);
        try {
            Subscriber<? super T> call = RxJavaHooks.m567R(this.f45754b).call(c15837a);
            SingleSubscriber m1112a = m1112a(call);
            call.onStart();
            this.f45753a.call(m1112a);
        } catch (Throwable th) {
            C15575a.m1471h(th, singleSubscriber);
        }
    }
}
