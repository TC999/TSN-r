package p640rx.internal.operators;

import java.util.NoSuchElementException;
import p640rx.Observable;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.Subscriber;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.p4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleFromObservable<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Observable.InterfaceC15567a<T> f45712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleFromObservable.java */
    /* renamed from: rx.internal.operators.p4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15837a<T> extends Subscriber<T> {

        /* renamed from: d */
        static final int f45713d = 0;

        /* renamed from: e */
        static final int f45714e = 1;

        /* renamed from: f */
        static final int f45715f = 2;

        /* renamed from: a */
        final SingleSubscriber<? super T> f45716a;

        /* renamed from: b */
        T f45717b;

        /* renamed from: c */
        int f45718c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C15837a(SingleSubscriber<? super T> singleSubscriber) {
            this.f45716a = singleSubscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            int i = this.f45718c;
            if (i == 0) {
                this.f45716a.onError(new NoSuchElementException());
            } else if (i == 1) {
                this.f45718c = 2;
                T t = this.f45717b;
                this.f45717b = null;
                this.f45716a.mo446d(t);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45718c == 2) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45717b = null;
            this.f45716a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            int i = this.f45718c;
            if (i == 0) {
                this.f45718c = 1;
                this.f45717b = t;
            } else if (i == 1) {
                this.f45718c = 2;
                this.f45716a.onError(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public SingleFromObservable(Observable.InterfaceC15567a<T> interfaceC15567a) {
        this.f45712a = interfaceC15567a;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15837a c15837a = new C15837a(singleSubscriber);
        singleSubscriber.m743b(c15837a);
        this.f45712a.call(c15837a);
    }
}
