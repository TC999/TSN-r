package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.functions.Action1;

/* renamed from: rx.internal.operators.b2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorDoOnRequest<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Action1<? super Long> f44956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDoOnRequest.java */
    /* renamed from: rx.internal.operators.b2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15660a implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15661b f44957a;

        C15660a(C15661b c15661b) {
            this.f44957a = c15661b;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            OperatorDoOnRequest.this.f44956a.call(Long.valueOf(j));
            this.f44957a.m1303G(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDoOnRequest.java */
    /* renamed from: rx.internal.operators.b2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15661b<T> extends Subscriber<T> {

        /* renamed from: a */
        private final Subscriber<? super T> f44959a;

        C15661b(Subscriber<? super T> subscriber) {
            this.f44959a = subscriber;
            request(0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: G */
        public void m1303G(long j) {
            request(j);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f44959a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f44959a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f44959a.onNext(t);
        }
    }

    public OperatorDoOnRequest(Action1<? super Long> action1) {
        this.f44956a = action1;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15661b c15661b = new C15661b(subscriber);
        subscriber.setProducer(new C15660a(c15661b));
        subscriber.add(c15661b);
        return c15661b;
    }
}
