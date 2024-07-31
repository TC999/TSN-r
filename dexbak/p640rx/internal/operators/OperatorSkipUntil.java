package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.observers.SerializedSubscriber;

/* renamed from: rx.internal.operators.e3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSkipUntil<T, U> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Observable<U> f45112a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSkipUntil.java */
    /* renamed from: rx.internal.operators.e3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15699a extends Subscriber<U> {

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f45113a;

        /* renamed from: b */
        final /* synthetic */ SerializedSubscriber f45114b;

        C15699a(AtomicBoolean atomicBoolean, SerializedSubscriber serializedSubscriber) {
            this.f45113a = atomicBoolean;
            this.f45114b = serializedSubscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            unsubscribe();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45114b.onError(th);
            this.f45114b.unsubscribe();
        }

        @Override // p640rx.Observer
        public void onNext(U u) {
            this.f45113a.set(true);
            unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSkipUntil.java */
    /* renamed from: rx.internal.operators.e3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15700b extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f45116a;

        /* renamed from: b */
        final /* synthetic */ SerializedSubscriber f45117b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15700b(Subscriber subscriber, AtomicBoolean atomicBoolean, SerializedSubscriber serializedSubscriber) {
            super(subscriber);
            this.f45116a = atomicBoolean;
            this.f45117b = serializedSubscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45117b.onCompleted();
            unsubscribe();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45117b.onError(th);
            unsubscribe();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45116a.get()) {
                this.f45117b.onNext(t);
            } else {
                request(1L);
            }
        }
    }

    public OperatorSkipUntil(Observable<U> observable) {
        this.f45112a = observable;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        C15699a c15699a = new C15699a(atomicBoolean, serializedSubscriber);
        subscriber.add(c15699a);
        this.f45112a.m1822I6(c15699a);
        return new C15700b(subscriber, atomicBoolean, serializedSubscriber);
    }
}
