package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.schedulers.TimeInterval;

/* renamed from: rx.internal.operators.q3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTimeInterval<T> implements Observable.InterfaceC15568b<TimeInterval<T>, T> {

    /* renamed from: a */
    final Scheduler f45749a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTimeInterval.java */
    /* renamed from: rx.internal.operators.q3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15845a extends Subscriber<T> {

        /* renamed from: a */
        private long f45750a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f45751b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15845a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f45751b = subscriber2;
            this.f45750a = OperatorTimeInterval.this.f45749a.mo462b();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45751b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45751b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            long mo462b = OperatorTimeInterval.this.f45749a.mo462b();
            this.f45751b.onNext(new TimeInterval(mo462b - this.f45750a, t));
            this.f45750a = mo462b;
        }
    }

    public OperatorTimeInterval(Scheduler scheduler) {
        this.f45749a = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super TimeInterval<T>> subscriber) {
        return new C15845a(subscriber, subscriber);
    }
}
