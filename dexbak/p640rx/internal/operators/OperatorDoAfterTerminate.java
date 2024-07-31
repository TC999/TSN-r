package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.a2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorDoAfterTerminate<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Action0 f44896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDoAfterTerminate.java */
    /* renamed from: rx.internal.operators.a2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15646a extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f44897a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15646a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f44897a = subscriber2;
        }

        /* renamed from: F */
        void m1318F() {
            try {
                OperatorDoAfterTerminate.this.f44896a.call();
            } catch (Throwable th) {
                C15575a.m1474e(th);
                RxJavaHooks.m576I(th);
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            try {
                this.f44897a.onCompleted();
            } finally {
                m1318F();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            try {
                this.f44897a.onError(th);
            } finally {
                m1318F();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f44897a.onNext(t);
        }
    }

    public OperatorDoAfterTerminate(Action0 action0) {
        if (action0 != null) {
            this.f44896a = action0;
            return;
        }
        throw new NullPointerException("Action can not be null");
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new C15646a(subscriber, subscriber);
    }
}
