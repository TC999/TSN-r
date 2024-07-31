package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func2;

/* renamed from: rx.internal.operators.y0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeReduceSeed<T, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable<T> f46202a;

    /* renamed from: b */
    final R f46203b;

    /* renamed from: c */
    final Func2<R, ? super T, R> f46204c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeReduceSeed.java */
    /* renamed from: rx.internal.operators.y0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15972a<T, R> extends DeferredScalarSubscriber<T, R> {

        /* renamed from: i */
        final Func2<R, ? super T, R> f46205i;

        public C15972a(Subscriber<? super R> subscriber, R r, Func2<R, ? super T, R> func2) {
            super(subscriber);
            this.f45882c = r;
            this.f45881b = true;
            this.f46205i = func2;
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                this.f45882c = this.f46205i.call(this.f45882c, t);
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                this.f45880a.onError(th);
            }
        }
    }

    public OnSubscribeReduceSeed(Observable<T> observable, R r, Func2<R, ? super T, R> func2) {
        this.f46202a = observable;
        this.f46203b = r;
        this.f46204c = func2;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        new C15972a(subscriber, this.f46203b, this.f46204c).m1088J(this.f46202a);
    }
}
