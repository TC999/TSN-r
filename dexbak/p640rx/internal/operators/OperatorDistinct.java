package p640rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.functions.Func1;
import p640rx.internal.util.UtilityFunctions;

/* renamed from: rx.internal.operators.y1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorDistinct<T, U> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Func1<? super T, ? extends U> f46206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDistinct.java */
    /* renamed from: rx.internal.operators.y1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15973a extends Subscriber<T> {

        /* renamed from: a */
        Set<U> f46207a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f46208b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15973a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f46208b = subscriber2;
            this.f46207a = new HashSet();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46207a = null;
            this.f46208b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46207a = null;
            this.f46208b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f46207a.add(OperatorDistinct.this.f46206a.call(t))) {
                this.f46208b.onNext(t);
            } else {
                request(1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDistinct.java */
    /* renamed from: rx.internal.operators.y1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15974b {

        /* renamed from: a */
        static final OperatorDistinct<?, ?> f46210a = new OperatorDistinct<>(UtilityFunctions.m803c());

        C15974b() {
        }
    }

    public OperatorDistinct(Func1<? super T, ? extends U> func1) {
        this.f46206a = func1;
    }

    /* renamed from: a */
    public static <T> OperatorDistinct<T, T> m993a() {
        return (OperatorDistinct<T, T>) C15974b.f46210a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new C15973a(subscriber, subscriber);
    }
}
