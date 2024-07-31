package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.OnErrorThrowable;
import p640rx.functions.Func1;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.r0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeMap<T, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable<T> f45762a;

    /* renamed from: b */
    final Func1<? super T, ? extends R> f45763b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeMap.java */
    /* renamed from: rx.internal.operators.r0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15848a<T, R> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super R> f45764a;

        /* renamed from: b */
        final Func1<? super T, ? extends R> f45765b;

        /* renamed from: c */
        boolean f45766c;

        public C15848a(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
            this.f45764a = subscriber;
            this.f45765b = func1;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45766c) {
                return;
            }
            this.f45764a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45766c) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45766c = true;
            this.f45764a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                this.f45764a.onNext(this.f45765b.call(t));
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45764a.setProducer(producer);
        }
    }

    public OnSubscribeMap(Observable<T> observable, Func1<? super T, ? extends R> func1) {
        this.f45762a = observable;
        this.f45763b = func1;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        C15848a c15848a = new C15848a(subscriber, this.f45763b);
        subscriber.add(c15848a);
        this.f45762a.m1822I6(c15848a);
    }
}
