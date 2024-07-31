package p640rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.schedulers.Timestamped;

/* renamed from: rx.internal.operators.d3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorSkipLastTimed<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final long f45067a;

    /* renamed from: b */
    final Scheduler f45068b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSkipLastTimed.java */
    /* renamed from: rx.internal.operators.d3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15689a extends Subscriber<T> {

        /* renamed from: a */
        private Deque<Timestamped<T>> f45069a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f45070b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15689a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f45070b = subscriber2;
            this.f45069a = new ArrayDeque();
        }

        /* renamed from: F */
        private void m1276F(long j) {
            long j2 = j - OperatorSkipLastTimed.this.f45067a;
            while (!this.f45069a.isEmpty()) {
                Timestamped<T> first = this.f45069a.getFirst();
                if (first.m452a() >= j2) {
                    return;
                }
                this.f45069a.removeFirst();
                this.f45070b.onNext(first.m451b());
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            m1276F(OperatorSkipLastTimed.this.f45068b.mo462b());
            this.f45070b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45070b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            long mo462b = OperatorSkipLastTimed.this.f45068b.mo462b();
            m1276F(mo462b);
            this.f45069a.offerLast(new Timestamped<>(mo462b, t));
        }
    }

    public OperatorSkipLastTimed(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f45067a = timeUnit.toMillis(j);
        this.f45068b = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new C15689a(subscriber, subscriber);
    }
}
