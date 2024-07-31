package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.schedulers.Timestamped;

/* renamed from: rx.internal.operators.u3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTimestamp<T> implements Observable.InterfaceC15568b<Timestamped<T>, T> {

    /* renamed from: a */
    final Scheduler f46001a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTimestamp.java */
    /* renamed from: rx.internal.operators.u3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15915a extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f46002a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15915a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f46002a = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46002a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46002a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46002a.onNext(new Timestamped(OperatorTimestamp.this.f46001a.mo462b(), t));
        }
    }

    public OperatorTimestamp(Scheduler scheduler) {
        this.f46001a = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super Timestamped<T>> subscriber) {
        return new C15915a(subscriber, subscriber);
    }
}
