package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.internal.producers.ProducerArbiter;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.r2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorOnErrorResumeNextViaFunction<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Func1<? super Throwable, ? extends Observable<? extends T>> f45786a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* renamed from: rx.internal.operators.r2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15854a implements Func1<Throwable, Observable<? extends T>> {

        /* renamed from: a */
        final /* synthetic */ Func1 f45787a;

        C15854a(Func1 func1) {
            this.f45787a = func1;
        }

        @Override // p640rx.functions.Func1
        public Observable<? extends T> call(Throwable th) {
            return Observable.m1802L2(this.f45787a.call(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* renamed from: rx.internal.operators.r2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15855b implements Func1<Throwable, Observable<? extends T>> {

        /* renamed from: a */
        final /* synthetic */ Observable f45788a;

        C15855b(Observable observable) {
            this.f45788a = observable;
        }

        @Override // p640rx.functions.Func1
        public Observable<? extends T> call(Throwable th) {
            return this.f45788a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* renamed from: rx.internal.operators.r2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15856c implements Func1<Throwable, Observable<? extends T>> {

        /* renamed from: a */
        final /* synthetic */ Observable f45789a;

        C15856c(Observable observable) {
            this.f45789a = observable;
        }

        @Override // p640rx.functions.Func1
        public Observable<? extends T> call(Throwable th) {
            if (th instanceof Exception) {
                return this.f45789a;
            }
            return Observable.m1739T1(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* renamed from: rx.internal.operators.r2$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15857d extends Subscriber<T> {

        /* renamed from: a */
        private boolean f45790a;

        /* renamed from: b */
        long f45791b;

        /* renamed from: c */
        final /* synthetic */ Subscriber f45792c;

        /* renamed from: d */
        final /* synthetic */ ProducerArbiter f45793d;

        /* renamed from: e */
        final /* synthetic */ SerialSubscription f45794e;

        /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
        /* renamed from: rx.internal.operators.r2$d$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15858a extends Subscriber<T> {
            C15858a() {
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                C15857d.this.f45792c.onCompleted();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15857d.this.f45792c.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(T t) {
                C15857d.this.f45792c.onNext(t);
            }

            @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                C15857d.this.f45793d.m960c(producer);
            }
        }

        C15857d(Subscriber subscriber, ProducerArbiter producerArbiter, SerialSubscription serialSubscription) {
            this.f45792c = subscriber;
            this.f45793d = producerArbiter;
            this.f45794e = serialSubscription;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45790a) {
                return;
            }
            this.f45790a = true;
            this.f45792c.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45790a) {
                C15575a.m1474e(th);
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45790a = true;
            try {
                unsubscribe();
                C15858a c15858a = new C15858a();
                this.f45794e.m347b(c15858a);
                long j = this.f45791b;
                if (j != 0) {
                    this.f45793d.m961b(j);
                }
                OperatorOnErrorResumeNextViaFunction.this.f45786a.call(th).m1822I6(c15858a);
            } catch (Throwable th2) {
                C15575a.m1473f(th2, this.f45792c);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45790a) {
                return;
            }
            this.f45791b++;
            this.f45792c.onNext(t);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45793d.m960c(producer);
        }
    }

    public OperatorOnErrorResumeNextViaFunction(Func1<? super Throwable, ? extends Observable<? extends T>> func1) {
        this.f45786a = func1;
    }

    /* renamed from: a */
    public static <T> OperatorOnErrorResumeNextViaFunction<T> m1106a(Observable<? extends T> observable) {
        return new OperatorOnErrorResumeNextViaFunction<>(new C15856c(observable));
    }

    /* renamed from: b */
    public static <T> OperatorOnErrorResumeNextViaFunction<T> m1105b(Observable<? extends T> observable) {
        return new OperatorOnErrorResumeNextViaFunction<>(new C15855b(observable));
    }

    /* renamed from: c */
    public static <T> OperatorOnErrorResumeNextViaFunction<T> m1104c(Func1<? super Throwable, ? extends T> func1) {
        return new OperatorOnErrorResumeNextViaFunction<>(new C15854a(func1));
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        ProducerArbiter producerArbiter = new ProducerArbiter();
        SerialSubscription serialSubscription = new SerialSubscription();
        C15857d c15857d = new C15857d(subscriber, producerArbiter, serialSubscription);
        serialSubscription.m347b(c15857d);
        subscriber.add(serialSubscription);
        subscriber.setProducer(producerArbiter);
        return c15857d;
    }
}
