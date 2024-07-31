package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.n1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorAsObservable<T> implements Observable.InterfaceC15568b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorAsObservable.java */
    /* renamed from: rx.internal.operators.n1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15799a {

        /* renamed from: a */
        static final OperatorAsObservable<Object> f45564a = new OperatorAsObservable<>();

        C15799a() {
        }
    }

    OperatorAsObservable() {
    }

    /* renamed from: a */
    public static <T> OperatorAsObservable<T> m1148a() {
        return (OperatorAsObservable<T>) C15799a.f45564a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return subscriber;
    }
}
