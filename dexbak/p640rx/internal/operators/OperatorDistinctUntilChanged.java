package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.internal.util.UtilityFunctions;

/* renamed from: rx.internal.operators.z1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorDistinctUntilChanged<T, U> implements Observable.InterfaceC15568b<T, T>, Func2<U, U, Boolean> {

    /* renamed from: a */
    final Func1<? super T, ? extends U> f46262a;

    /* renamed from: b */
    final Func2<? super U, ? super U, Boolean> f46263b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDistinctUntilChanged.java */
    /* renamed from: rx.internal.operators.z1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15986a extends Subscriber<T> {

        /* renamed from: a */
        U f46264a;

        /* renamed from: b */
        boolean f46265b;

        /* renamed from: c */
        final /* synthetic */ Subscriber f46266c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15986a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f46266c = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46266c.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46266c.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            Object obj;
            try {
                U call = OperatorDistinctUntilChanged.this.f46262a.call(t);
                U u = this.f46264a;
                this.f46264a = call;
                if (this.f46265b) {
                    try {
                        if (!OperatorDistinctUntilChanged.this.f46263b.call(u, call).booleanValue()) {
                            this.f46266c.onNext(t);
                            return;
                        } else {
                            request(1L);
                            return;
                        }
                    } catch (Throwable th) {
                        C15575a.m1472g(th, this.f46266c, obj);
                        return;
                    }
                }
                this.f46265b = true;
                this.f46266c.onNext(t);
            } catch (Throwable th2) {
                C15575a.m1472g(th2, this.f46266c, t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDistinctUntilChanged.java */
    /* renamed from: rx.internal.operators.z1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15987b {

        /* renamed from: a */
        static final OperatorDistinctUntilChanged<?, ?> f46268a = new OperatorDistinctUntilChanged<>(UtilityFunctions.m803c());

        C15987b() {
        }
    }

    public OperatorDistinctUntilChanged(Func1<? super T, ? extends U> func1) {
        this.f46262a = func1;
        this.f46263b = this;
    }

    /* renamed from: a */
    public static <T> OperatorDistinctUntilChanged<T, T> m971a() {
        return (OperatorDistinctUntilChanged<T, T>) C15987b.f46268a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p640rx.functions.Func2
    public Boolean call(U u, U u2) {
        return Boolean.valueOf(u == u2 || (u != null && u.equals(u2)));
    }

    public OperatorDistinctUntilChanged(Func2<? super U, ? super U, Boolean> func2) {
        this.f46262a = UtilityFunctions.m803c();
        this.f46263b = func2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new C15986a(subscriber, subscriber);
    }
}
