package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.d1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeTakeLastOne<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Observable<T> f45064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeTakeLastOne.java */
    /* renamed from: rx.internal.operators.d1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15688a<T> extends DeferredScalarSubscriber<T, T> {

        /* renamed from: i */
        static final Object f45065i = new Object();

        /* JADX WARN: Type inference failed for: r1v1, types: [R, java.lang.Object] */
        public C15688a(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.f45882c = f45065i;
        }

        @Override // p640rx.internal.operators.DeferredScalarSubscriber, p640rx.Observer
        public void onCompleted() {
            Object obj = this.f45882c;
            if (obj == f45065i) {
                m1092F();
            } else {
                m1091G(obj);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45882c = t;
        }
    }

    public OnSubscribeTakeLastOne(Observable<T> observable) {
        this.f45064a = observable;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        new C15688a(subscriber).m1088J(this.f45064a);
    }
}
