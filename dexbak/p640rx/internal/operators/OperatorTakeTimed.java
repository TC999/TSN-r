package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.observers.SerializedSubscriber;

/* renamed from: rx.internal.operators.l3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTakeTimed<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final long f45510a;

    /* renamed from: b */
    final TimeUnit f45511b;

    /* renamed from: c */
    final Scheduler f45512c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeTimed.java */
    /* renamed from: rx.internal.operators.l3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15788a<T> extends Subscriber<T> implements Action0 {

        /* renamed from: a */
        final Subscriber<? super T> f45513a;

        public C15788a(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.f45513a = subscriber;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            onCompleted();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45513a.onCompleted();
            unsubscribe();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45513a.onError(th);
            unsubscribe();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45513a.onNext(t);
        }
    }

    public OperatorTakeTimed(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f45510a = j;
        this.f45511b = timeUnit;
        this.f45512c = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45512c.mo450a();
        subscriber.add(mo450a);
        C15788a c15788a = new C15788a(new SerializedSubscriber(subscriber));
        mo450a.mo460F(c15788a, this.f45510a, this.f45511b);
        return c15788a;
    }
}
