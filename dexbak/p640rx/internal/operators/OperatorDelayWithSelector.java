package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.observers.SerializedSubscriber;
import p640rx.observers.Subscribers;
import p640rx.subjects.PublishSubject;

/* renamed from: rx.internal.operators.w1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorDelayWithSelector<T, V> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Observable<? extends T> f46098a;

    /* renamed from: b */
    final Func1<? super T, ? extends Observable<V>> f46099b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDelayWithSelector.java */
    /* renamed from: rx.internal.operators.w1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15947a extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ PublishSubject f46100a;

        /* renamed from: b */
        final /* synthetic */ SerializedSubscriber f46101b;

        /* compiled from: OperatorDelayWithSelector.java */
        /* renamed from: rx.internal.operators.w1$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15948a implements Func1<V, T> {

            /* renamed from: a */
            final /* synthetic */ Object f46103a;

            C15948a(Object obj) {
                this.f46103a = obj;
            }

            @Override // p640rx.functions.Func1
            public T call(V v) {
                return (T) this.f46103a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15947a(Subscriber subscriber, PublishSubject publishSubject, SerializedSubscriber serializedSubscriber) {
            super(subscriber);
            this.f46100a = publishSubject;
            this.f46101b = serializedSubscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46100a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46101b.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                this.f46100a.onNext(OperatorDelayWithSelector.this.f46099b.call(t).m1869C5(1).m1555q1(null).m1674b3(new C15948a(t)));
            } catch (Throwable th) {
                C15575a.m1473f(th, this);
            }
        }
    }

    public OperatorDelayWithSelector(Observable<? extends T> observable, Func1<? super T, ? extends Observable<V>> func1) {
        this.f46098a = observable;
        this.f46099b = func1;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        PublishSubject m427x7 = PublishSubject.m427x7();
        subscriber.add(Observable.m1633g3(m427x7).m1822I6(Subscribers.m632e(serializedSubscriber)));
        return new C15947a(subscriber, m427x7, serializedSubscriber);
    }
}
