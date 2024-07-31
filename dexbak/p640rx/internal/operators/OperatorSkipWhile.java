package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.functions.Func2;

/* renamed from: rx.internal.operators.f3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSkipWhile<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Func2<? super T, Integer, Boolean> f45154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSkipWhile.java */
    /* renamed from: rx.internal.operators.f3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15710a extends Subscriber<T> {

        /* renamed from: a */
        boolean f45155a;

        /* renamed from: b */
        int f45156b;

        /* renamed from: c */
        final /* synthetic */ Subscriber f45157c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15710a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f45157c = subscriber2;
            this.f45155a = true;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45157c.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45157c.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (!this.f45155a) {
                this.f45157c.onNext(t);
                return;
            }
            try {
                Func2<? super T, Integer, Boolean> func2 = OperatorSkipWhile.this.f45154a;
                int i = this.f45156b;
                this.f45156b = i + 1;
                if (!func2.call(t, Integer.valueOf(i)).booleanValue()) {
                    this.f45155a = false;
                    this.f45157c.onNext(t);
                    return;
                }
                request(1L);
            } catch (Throwable th) {
                C15575a.m1472g(th, this.f45157c, t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSkipWhile.java */
    /* renamed from: rx.internal.operators.f3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15711b implements Func2<T, Integer, Boolean> {

        /* renamed from: a */
        final /* synthetic */ Func1 f45159a;

        C15711b(Func1 func1) {
            this.f45159a = func1;
        }

        @Override // p640rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((C15711b) obj, num);
        }

        /* renamed from: call  reason: avoid collision after fix types in other method */
        public Boolean call2(T t, Integer num) {
            return (Boolean) this.f45159a.call(t);
        }
    }

    public OperatorSkipWhile(Func2<? super T, Integer, Boolean> func2) {
        this.f45154a = func2;
    }

    /* renamed from: a */
    public static <T> Func2<T, Integer, Boolean> m1261a(Func1<? super T, Boolean> func1) {
        return new C15711b(func1);
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new C15710a(subscriber, subscriber);
    }
}
