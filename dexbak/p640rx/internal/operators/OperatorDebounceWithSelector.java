package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.internal.operators.OperatorDebounceWithTime;
import p640rx.observers.SerializedSubscriber;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.t1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorDebounceWithSelector<T, U> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Func1<? super T, ? extends Observable<U>> f45890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDebounceWithSelector.java */
    /* renamed from: rx.internal.operators.t1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15882a extends Subscriber<T> {

        /* renamed from: a */
        final OperatorDebounceWithTime.C15911b<T> f45891a;

        /* renamed from: b */
        final Subscriber<?> f45892b;

        /* renamed from: c */
        final /* synthetic */ SerializedSubscriber f45893c;

        /* renamed from: d */
        final /* synthetic */ SerialSubscription f45894d;

        /* compiled from: OperatorDebounceWithSelector.java */
        /* renamed from: rx.internal.operators.t1$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15883a extends Subscriber<U> {

            /* renamed from: a */
            final /* synthetic */ int f45896a;

            C15883a(int i) {
                this.f45896a = i;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                C15882a c15882a = C15882a.this;
                c15882a.f45891a.m1056b(this.f45896a, c15882a.f45893c, c15882a.f45892b);
                unsubscribe();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15882a.this.f45892b.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(U u) {
                onCompleted();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15882a(Subscriber subscriber, SerializedSubscriber serializedSubscriber, SerialSubscription serialSubscription) {
            super(subscriber);
            this.f45893c = serializedSubscriber;
            this.f45894d = serialSubscription;
            this.f45891a = new OperatorDebounceWithTime.C15911b<>();
            this.f45892b = this;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45891a.m1055c(this.f45893c, this);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45893c.onError(th);
            unsubscribe();
            this.f45891a.m1057a();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                Observable<U> call = OperatorDebounceWithSelector.this.f45890a.call(t);
                C15883a c15883a = new C15883a(this.f45891a.m1054d(t));
                this.f45894d.m347b(c15883a);
                call.m1822I6(c15883a);
            } catch (Throwable th) {
                C15575a.m1473f(th, this);
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorDebounceWithSelector(Func1<? super T, ? extends Observable<U>> func1) {
        this.f45890a = func1;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        return new C15882a(subscriber, serializedSubscriber, serialSubscription);
    }
}
