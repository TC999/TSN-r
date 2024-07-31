package p640rx.internal.operators;

import java.util.Arrays;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.CompositeException;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.g0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OnSubscribeDoOnEach<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    private final Observer<? super T> f45184a;

    /* renamed from: b */
    private final Observable<T> f45185b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OnSubscribeDoOnEach.java */
    /* renamed from: rx.internal.operators.g0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15720a<T> extends Subscriber<T> {

        /* renamed from: a */
        private final Subscriber<? super T> f45186a;

        /* renamed from: b */
        private final Observer<? super T> f45187b;

        /* renamed from: c */
        private boolean f45188c;

        C15720a(Subscriber<? super T> subscriber, Observer<? super T> observer) {
            super(subscriber);
            this.f45186a = subscriber;
            this.f45187b = observer;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45188c) {
                return;
            }
            try {
                this.f45187b.onCompleted();
                this.f45188c = true;
                this.f45186a.onCompleted();
            } catch (Throwable th) {
                C15575a.m1473f(th, this);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45188c) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45188c = true;
            try {
                this.f45187b.onError(th);
                this.f45186a.onError(th);
            } catch (Throwable th2) {
                C15575a.m1474e(th2);
                this.f45186a.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45188c) {
                return;
            }
            try {
                this.f45187b.onNext(t);
                this.f45186a.onNext(t);
            } catch (Throwable th) {
                C15575a.m1472g(th, this, t);
            }
        }
    }

    public OnSubscribeDoOnEach(Observable<T> observable, Observer<? super T> observer) {
        this.f45185b = observable;
        this.f45184a = observer;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        this.f45185b.m1822I6(new C15720a(subscriber, this.f45184a));
    }
}
