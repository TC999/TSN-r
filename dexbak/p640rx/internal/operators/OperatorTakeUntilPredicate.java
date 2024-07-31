package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;

/* renamed from: rx.internal.operators.n3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTakeUntilPredicate<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Func1<? super T, Boolean> f45580a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeUntilPredicate.java */
    /* renamed from: rx.internal.operators.n3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15803a implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15804b f45581a;

        C15803a(C15804b c15804b) {
            this.f45581a = c15804b;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f45581a.m1143F(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeUntilPredicate.java */
    /* renamed from: rx.internal.operators.n3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15804b extends Subscriber<T> {

        /* renamed from: a */
        private final Subscriber<? super T> f45583a;

        /* renamed from: b */
        private boolean f45584b;

        C15804b(Subscriber<? super T> subscriber) {
            this.f45583a = subscriber;
        }

        /* renamed from: F */
        void m1143F(long j) {
            request(j);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45584b) {
                return;
            }
            this.f45583a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45584b) {
                return;
            }
            this.f45583a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45583a.onNext(t);
            try {
                if (OperatorTakeUntilPredicate.this.f45580a.call(t).booleanValue()) {
                    this.f45584b = true;
                    this.f45583a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f45584b = true;
                C15575a.m1472g(th, this.f45583a, t);
                unsubscribe();
            }
        }
    }

    public OperatorTakeUntilPredicate(Func1<? super T, Boolean> func1) {
        this.f45580a = func1;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15804b c15804b = new C15804b(subscriber);
        subscriber.add(c15804b);
        subscriber.setProducer(new C15803a(c15804b));
        return c15804b;
    }
}
