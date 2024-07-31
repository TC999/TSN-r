package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.p3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorThrottleFirst<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final long f45707a;

    /* renamed from: b */
    final Scheduler f45708b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorThrottleFirst.java */
    /* renamed from: rx.internal.operators.p3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15836a extends Subscriber<T> {

        /* renamed from: a */
        private long f45709a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f45710b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15836a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f45710b = subscriber2;
            this.f45709a = -1L;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45710b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45710b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            long mo462b = OperatorThrottleFirst.this.f45708b.mo462b();
            long j = this.f45709a;
            if (j == -1 || mo462b < j || mo462b - j >= OperatorThrottleFirst.this.f45707a) {
                this.f45709a = mo462b;
                this.f45710b.onNext(t);
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorThrottleFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f45707a = timeUnit.toMillis(j);
        this.f45708b = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new C15836a(subscriber, subscriber);
    }
}
