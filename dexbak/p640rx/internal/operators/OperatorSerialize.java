package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.observers.SerializedSubscriber;

/* renamed from: rx.internal.operators.z2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSerialize<T> implements Observable.InterfaceC15568b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSerialize.java */
    /* renamed from: rx.internal.operators.z2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15988a extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f46269a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15988a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f46269a = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46269a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46269a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46269a.onNext(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSerialize.java */
    /* renamed from: rx.internal.operators.z2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15989b {

        /* renamed from: a */
        static final OperatorSerialize<Object> f46271a = new OperatorSerialize<>();

        C15989b() {
        }
    }

    OperatorSerialize() {
    }

    /* renamed from: a */
    public static <T> OperatorSerialize<T> m970a() {
        return (OperatorSerialize<T>) C15989b.f46271a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new SerializedSubscriber(new C15988a(subscriber, subscriber));
    }
}
