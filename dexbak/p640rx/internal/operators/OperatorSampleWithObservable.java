package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.observers.SerializedSubscriber;

/* renamed from: rx.internal.operators.v2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSampleWithObservable<T, U> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: b */
    static final Object f46029b = new Object();

    /* renamed from: a */
    final Observable<U> f46030a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSampleWithObservable.java */
    /* renamed from: rx.internal.operators.v2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15925a extends Subscriber<U> {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f46031a;

        /* renamed from: b */
        final /* synthetic */ SerializedSubscriber f46032b;

        /* renamed from: c */
        final /* synthetic */ AtomicReference f46033c;

        C15925a(AtomicReference atomicReference, SerializedSubscriber serializedSubscriber, AtomicReference atomicReference2) {
            this.f46031a = atomicReference;
            this.f46032b = serializedSubscriber;
            this.f46033c = atomicReference2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            onNext(null);
            this.f46032b.onCompleted();
            ((Subscription) this.f46033c.get()).unsubscribe();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46032b.onError(th);
            ((Subscription) this.f46033c.get()).unsubscribe();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p640rx.Observer
        public void onNext(U u) {
            AtomicReference atomicReference = this.f46031a;
            Object obj = OperatorSampleWithObservable.f46029b;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                this.f46032b.onNext(andSet);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSampleWithObservable.java */
    /* renamed from: rx.internal.operators.v2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15926b extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f46035a;

        /* renamed from: b */
        final /* synthetic */ SerializedSubscriber f46036b;

        /* renamed from: c */
        final /* synthetic */ Subscriber f46037c;

        C15926b(AtomicReference atomicReference, SerializedSubscriber serializedSubscriber, Subscriber subscriber) {
            this.f46035a = atomicReference;
            this.f46036b = serializedSubscriber;
            this.f46037c = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46037c.onNext(null);
            this.f46036b.onCompleted();
            this.f46037c.unsubscribe();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46036b.onError(th);
            this.f46037c.unsubscribe();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46035a.set(t);
        }
    }

    public OperatorSampleWithObservable(Observable<U> observable) {
        this.f46030a = observable;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        AtomicReference atomicReference = new AtomicReference(f46029b);
        AtomicReference atomicReference2 = new AtomicReference();
        C15925a c15925a = new C15925a(atomicReference, serializedSubscriber, atomicReference2);
        C15926b c15926b = new C15926b(atomicReference, serializedSubscriber, c15925a);
        atomicReference2.lazySet(c15926b);
        subscriber.add(c15926b);
        subscriber.add(c15925a);
        this.f46030a.m1822I6(c15925a);
        return c15926b;
    }
}
