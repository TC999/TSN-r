package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.h2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorIgnoreElements<T> implements Observable.InterfaceC15568b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorIgnoreElements.java */
    /* renamed from: rx.internal.operators.h2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15738a extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f45279a;

        C15738a(Subscriber subscriber) {
            this.f45279a = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45279a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45279a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorIgnoreElements.java */
    /* renamed from: rx.internal.operators.h2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15739b {

        /* renamed from: a */
        static final OperatorIgnoreElements<?> f45281a = new OperatorIgnoreElements<>();

        C15739b() {
        }
    }

    OperatorIgnoreElements() {
    }

    /* renamed from: a */
    public static <T> OperatorIgnoreElements<T> m1229a() {
        return (OperatorIgnoreElements<T>) C15739b.f45281a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15738a c15738a = new C15738a(subscriber);
        subscriber.add(c15738a);
        return c15738a;
    }
}
