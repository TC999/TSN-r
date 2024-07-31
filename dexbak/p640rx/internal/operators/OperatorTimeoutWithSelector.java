package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.internal.operators.OperatorTimeoutBase;
import p640rx.schedulers.Schedulers;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.t3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorTimeoutWithSelector<T, U, V> extends OperatorTimeoutBase<T> {

    /* compiled from: OperatorTimeoutWithSelector.java */
    /* renamed from: rx.internal.operators.t3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15902a implements OperatorTimeoutBase.InterfaceC15875a<T> {

        /* renamed from: a */
        final /* synthetic */ Func0 f45951a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorTimeoutWithSelector.java */
        /* renamed from: rx.internal.operators.t3$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15903a extends Subscriber<U> {

            /* renamed from: a */
            final /* synthetic */ OperatorTimeoutBase.C15877c f45952a;

            /* renamed from: b */
            final /* synthetic */ Long f45953b;

            C15903a(OperatorTimeoutBase.C15877c c15877c, Long l) {
                this.f45952a = c15877c;
                this.f45953b = l;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                this.f45952a.m1093F(this.f45953b.longValue());
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                this.f45952a.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(U u) {
                this.f45952a.m1093F(this.f45953b.longValue());
            }
        }

        C15902a(Func0 func0) {
            this.f45951a = func0;
        }

        @Override // p640rx.functions.Func3
        public /* bridge */ /* synthetic */ Subscription call(Object obj, Long l, Scheduler.AbstractC15607a abstractC15607a) {
            return call((OperatorTimeoutBase.C15877c) ((OperatorTimeoutBase.C15877c) obj), l, abstractC15607a);
        }

        public Subscription call(OperatorTimeoutBase.C15877c<T> c15877c, Long l, Scheduler.AbstractC15607a abstractC15607a) {
            Func0 func0 = this.f45951a;
            if (func0 != null) {
                try {
                    return ((Observable) func0.call()).m1822I6(new C15903a(c15877c, l));
                } catch (Throwable th) {
                    C15575a.m1473f(th, c15877c);
                    return Subscriptions.m342e();
                }
            }
            return Subscriptions.m342e();
        }
    }

    /* compiled from: OperatorTimeoutWithSelector.java */
    /* renamed from: rx.internal.operators.t3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15904b implements OperatorTimeoutBase.InterfaceC15876b<T> {

        /* renamed from: a */
        final /* synthetic */ Func1 f45955a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorTimeoutWithSelector.java */
        /* renamed from: rx.internal.operators.t3$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15905a extends Subscriber<V> {

            /* renamed from: a */
            final /* synthetic */ OperatorTimeoutBase.C15877c f45956a;

            /* renamed from: b */
            final /* synthetic */ Long f45957b;

            C15905a(OperatorTimeoutBase.C15877c c15877c, Long l) {
                this.f45956a = c15877c;
                this.f45957b = l;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                this.f45956a.m1093F(this.f45957b.longValue());
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                this.f45956a.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(V v) {
                this.f45956a.m1093F(this.f45957b.longValue());
            }
        }

        C15904b(Func1 func1) {
            this.f45955a = func1;
        }

        @Override // p640rx.functions.Func4
        public /* bridge */ /* synthetic */ Subscription call(Object obj, Long l, Object obj2, Scheduler.AbstractC15607a abstractC15607a) {
            return call((OperatorTimeoutBase.C15877c<Long>) obj, l, (Long) obj2, abstractC15607a);
        }

        public Subscription call(OperatorTimeoutBase.C15877c<T> c15877c, Long l, T t, Scheduler.AbstractC15607a abstractC15607a) {
            try {
                return ((Observable) this.f45955a.call(t)).m1822I6(new C15905a(c15877c, l));
            } catch (Throwable th) {
                C15575a.m1473f(th, c15877c);
                return Subscriptions.m342e();
            }
        }
    }

    public OperatorTimeoutWithSelector(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable) {
        super(new C15902a(func0), new C15904b(func1), observable, Schedulers.m476d());
    }

    @Override // p640rx.internal.operators.OperatorTimeoutBase
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber subscriber) {
        return super.call(subscriber);
    }
}
