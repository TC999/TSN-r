package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.i3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTake<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final int f45353a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTake.java */
    /* renamed from: rx.internal.operators.i3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15754a extends Subscriber<T> {

        /* renamed from: a */
        int f45354a;

        /* renamed from: b */
        boolean f45355b;

        /* renamed from: c */
        final /* synthetic */ Subscriber f45356c;

        /* compiled from: OperatorTake.java */
        /* renamed from: rx.internal.operators.i3$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15755a implements Producer {

            /* renamed from: a */
            final AtomicLong f45358a = new AtomicLong(0);

            /* renamed from: b */
            final /* synthetic */ Producer f45359b;

            C15755a(Producer producer) {
                this.f45359b = producer;
            }

            @Override // p640rx.Producer
            public void request(long j) {
                long j2;
                long min;
                if (j <= 0 || C15754a.this.f45355b) {
                    return;
                }
                do {
                    j2 = this.f45358a.get();
                    min = Math.min(j, OperatorTake.this.f45353a - j2);
                    if (min == 0) {
                        return;
                    }
                } while (!this.f45358a.compareAndSet(j2, j2 + min));
                this.f45359b.request(min);
            }
        }

        C15754a(Subscriber subscriber) {
            this.f45356c = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45355b) {
                return;
            }
            this.f45355b = true;
            this.f45356c.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45355b) {
                return;
            }
            this.f45355b = true;
            try {
                this.f45356c.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (isUnsubscribed()) {
                return;
            }
            int i = this.f45354a;
            int i2 = i + 1;
            this.f45354a = i2;
            int i3 = OperatorTake.this.f45353a;
            if (i < i3) {
                boolean z = i2 == i3;
                this.f45356c.onNext(t);
                if (!z || this.f45355b) {
                    return;
                }
                this.f45355b = true;
                try {
                    this.f45356c.onCompleted();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45356c.setProducer(new C15755a(producer));
        }
    }

    public OperatorTake(int i) {
        if (i >= 0) {
            this.f45353a = i;
            return;
        }
        throw new IllegalArgumentException("limit >= 0 required but it was " + i);
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15754a c15754a = new C15754a(subscriber);
        if (this.f45353a == 0) {
            subscriber.onCompleted();
            c15754a.unsubscribe();
        }
        subscriber.add(c15754a);
        return c15754a;
    }
}
