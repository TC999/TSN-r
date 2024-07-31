package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.observers.SerializedSubscriber;

/* renamed from: rx.internal.operators.m3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTakeUntil<T, E> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    private final Observable<? extends E> f45542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeUntil.java */
    /* renamed from: rx.internal.operators.m3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15794a extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f45543a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15794a(Subscriber subscriber, boolean z, Subscriber subscriber2) {
            super(subscriber, z);
            this.f45543a = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            try {
                this.f45543a.onCompleted();
            } finally {
                this.f45543a.unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            try {
                this.f45543a.onError(th);
            } finally {
                this.f45543a.unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45543a.onNext(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeUntil.java */
    /* renamed from: rx.internal.operators.m3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15795b extends Subscriber<E> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f45545a;

        C15795b(Subscriber subscriber) {
            this.f45545a = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45545a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45545a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(E e) {
            onCompleted();
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorTakeUntil(Observable<? extends E> observable) {
        this.f45542a = observable;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        C15794a c15794a = new C15794a(serializedSubscriber, false, serializedSubscriber);
        C15795b c15795b = new C15795b(c15794a);
        serializedSubscriber.add(c15794a);
        serializedSubscriber.add(c15795b);
        subscriber.add(serializedSubscriber);
        this.f45542a.m1822I6(c15795b);
        return c15794a;
    }
}
