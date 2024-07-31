package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.observers.SerializedSubscriber;

/* renamed from: rx.internal.operators.w2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSampleWithTime<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final long f46105a;

    /* renamed from: b */
    final TimeUnit f46106b;

    /* renamed from: c */
    final Scheduler f46107c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSampleWithTime.java */
    /* renamed from: rx.internal.operators.w2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15949a<T> extends Subscriber<T> implements Action0 {

        /* renamed from: c */
        private static final Object f46108c = new Object();

        /* renamed from: a */
        private final Subscriber<? super T> f46109a;

        /* renamed from: b */
        final AtomicReference<Object> f46110b = new AtomicReference<>(f46108c);

        public C15949a(Subscriber<? super T> subscriber) {
            this.f46109a = subscriber;
        }

        /* renamed from: F */
        private void m1010F() {
            AtomicReference<Object> atomicReference = this.f46110b;
            Object obj = f46108c;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                try {
                    this.f46109a.onNext(andSet);
                } catch (Throwable th) {
                    C15575a.m1473f(th, this);
                }
            }
        }

        @Override // p640rx.functions.Action0
        public void call() {
            m1010F();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            m1010F();
            this.f46109a.onCompleted();
            unsubscribe();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46109a.onError(th);
            unsubscribe();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46110b.set(t);
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorSampleWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f46105a = j;
        this.f46106b = timeUnit;
        this.f46107c = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Scheduler.AbstractC15607a mo450a = this.f46107c.mo450a();
        subscriber.add(mo450a);
        C15949a c15949a = new C15949a(serializedSubscriber);
        subscriber.add(c15949a);
        long j = this.f46105a;
        mo450a.mo459G(c15949a, j, j, this.f46106b);
        return c15949a;
    }
}
