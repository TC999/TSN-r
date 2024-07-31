package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action2;
import p640rx.functions.Func0;

/* renamed from: rx.internal.operators.x */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeCollect<T, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable<T> f46126a;

    /* renamed from: b */
    final Func0<R> f46127b;

    /* renamed from: c */
    final Action2<R, ? super T> f46128c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCollect.java */
    /* renamed from: rx.internal.operators.x$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15955a<T, R> extends DeferredScalarSubscriberSafe<T, R> {

        /* renamed from: j */
        final Action2<R, ? super T> f46129j;

        public C15955a(Subscriber<? super R> subscriber, R r, Action2<R, ? super T> action2) {
            super(subscriber);
            this.f45882c = r;
            this.f45881b = true;
            this.f46129j = action2;
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45967i) {
                return;
            }
            try {
                this.f46129j.call(this.f45882c, t);
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public OnSubscribeCollect(Observable<T> observable, Func0<R> func0, Action2<R, ? super T> action2) {
        this.f46126a = observable;
        this.f46127b = func0;
        this.f46128c = action2;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        try {
            new C15955a(subscriber, this.f46127b.call(), this.f46128c).m1088J(this.f46126a);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            subscriber.onError(th);
        }
    }
}
