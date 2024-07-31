package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.x3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorUnsubscribeOn<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Scheduler f46165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorUnsubscribeOn.java */
    /* renamed from: rx.internal.operators.x3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15965a extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f46166a;

        C15965a(Subscriber subscriber) {
            this.f46166a = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46166a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46166a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46166a.onNext(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorUnsubscribeOn.java */
    /* renamed from: rx.internal.operators.x3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15966b implements Action0 {

        /* renamed from: a */
        final /* synthetic */ Subscriber f46168a;

        /* compiled from: OperatorUnsubscribeOn.java */
        /* renamed from: rx.internal.operators.x3$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15967a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ Scheduler.AbstractC15607a f46170a;

            C15967a(Scheduler.AbstractC15607a abstractC15607a) {
                this.f46170a = abstractC15607a;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15966b.this.f46168a.unsubscribe();
                this.f46170a.unsubscribe();
            }
        }

        C15966b(Subscriber subscriber) {
            this.f46168a = subscriber;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            Scheduler.AbstractC15607a mo450a = OperatorUnsubscribeOn.this.f46165a.mo450a();
            mo450a.mo456d(new C15967a(mo450a));
        }
    }

    public OperatorUnsubscribeOn(Scheduler scheduler) {
        this.f46165a = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15965a c15965a = new C15965a(subscriber);
        subscriber.add(Subscriptions.m346a(new C15966b(c15965a)));
        return c15965a;
    }
}
