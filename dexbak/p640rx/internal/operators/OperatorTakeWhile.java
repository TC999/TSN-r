package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.functions.Func2;

/* renamed from: rx.internal.operators.o3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTakeWhile<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Func2<? super T, ? super Integer, Boolean> f45643a;

    /* compiled from: OperatorTakeWhile.java */
    /* renamed from: rx.internal.operators.o3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15819a implements Func2<T, Integer, Boolean> {

        /* renamed from: a */
        final /* synthetic */ Func1 f45644a;

        C15819a(Func1 func1) {
            this.f45644a = func1;
        }

        @Override // p640rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((C15819a) obj, num);
        }

        /* renamed from: call  reason: avoid collision after fix types in other method */
        public Boolean call2(T t, Integer num) {
            return (Boolean) this.f45644a.call(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeWhile.java */
    /* renamed from: rx.internal.operators.o3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15820b extends Subscriber<T> {

        /* renamed from: a */
        private int f45645a;

        /* renamed from: b */
        private boolean f45646b;

        /* renamed from: c */
        final /* synthetic */ Subscriber f45647c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15820b(Subscriber subscriber, boolean z, Subscriber subscriber2) {
            super(subscriber, z);
            this.f45647c = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45646b) {
                return;
            }
            this.f45647c.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45646b) {
                return;
            }
            this.f45647c.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                Func2<? super T, ? super Integer, Boolean> func2 = OperatorTakeWhile.this.f45643a;
                int i = this.f45645a;
                this.f45645a = i + 1;
                if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                    this.f45647c.onNext(t);
                    return;
                }
                this.f45646b = true;
                this.f45647c.onCompleted();
                unsubscribe();
            } catch (Throwable th) {
                this.f45646b = true;
                C15575a.m1472g(th, this.f45647c, t);
                unsubscribe();
            }
        }
    }

    public OperatorTakeWhile(Func1<? super T, Boolean> func1) {
        this(new C15819a(func1));
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorTakeWhile(Func2<? super T, ? super Integer, Boolean> func2) {
        this.f45643a = func2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15820b c15820b = new C15820b(subscriber, false, subscriber);
        subscriber.add(c15820b);
        return c15820b;
    }
}
