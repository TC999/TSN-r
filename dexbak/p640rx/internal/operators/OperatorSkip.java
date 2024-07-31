package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.b3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSkip<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final int f44960a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSkip.java */
    /* renamed from: rx.internal.operators.b3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15662a extends Subscriber<T> {

        /* renamed from: a */
        int f44961a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f44962b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15662a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f44962b = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f44962b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f44962b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            int i = this.f44961a;
            if (i >= OperatorSkip.this.f44960a) {
                this.f44962b.onNext(t);
            } else {
                this.f44961a = i + 1;
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f44962b.setProducer(producer);
            producer.request(OperatorSkip.this.f44960a);
        }
    }

    public OperatorSkip(int i) {
        if (i >= 0) {
            this.f44960a = i;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + i);
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new C15662a(subscriber, subscriber);
    }
}
