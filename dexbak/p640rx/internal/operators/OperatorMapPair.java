package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.OnErrorThrowable;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.j2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorMapPair<T, U, R> implements Observable.InterfaceC15568b<Observable<? extends R>, T> {

    /* renamed from: a */
    final Func1<? super T, ? extends Observable<? extends U>> f45390a;

    /* renamed from: b */
    final Func2<? super T, ? super U, ? extends R> f45391b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMapPair.java */
    /* renamed from: rx.internal.operators.j2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15763a implements Func1<T, Observable<U>> {

        /* renamed from: a */
        final /* synthetic */ Func1 f45392a;

        C15763a(Func1 func1) {
            this.f45392a = func1;
        }

        @Override // p640rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((C15763a) obj);
        }

        @Override // p640rx.functions.Func1
        public Observable<U> call(T t) {
            return Observable.m1522u2((Iterable) this.f45392a.call(t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMapPair.java */
    /* renamed from: rx.internal.operators.j2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15764b<T, U, R> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super Observable<? extends R>> f45393a;

        /* renamed from: b */
        final Func1<? super T, ? extends Observable<? extends U>> f45394b;

        /* renamed from: c */
        final Func2<? super T, ? super U, ? extends R> f45395c;

        /* renamed from: d */
        boolean f45396d;

        public C15764b(Subscriber<? super Observable<? extends R>> subscriber, Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
            this.f45393a = subscriber;
            this.f45394b = func1;
            this.f45395c = func2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45396d) {
                return;
            }
            this.f45393a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45396d) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45396d = true;
            this.f45393a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                this.f45393a.onNext(this.f45394b.call(t).m1674b3(new C15765c(t, this.f45395c)));
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45393a.setProducer(producer);
        }
    }

    /* compiled from: OperatorMapPair.java */
    /* renamed from: rx.internal.operators.j2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15765c<T, U, R> implements Func1<U, R> {

        /* renamed from: a */
        final T f45397a;

        /* renamed from: b */
        final Func2<? super T, ? super U, ? extends R> f45398b;

        public C15765c(T t, Func2<? super T, ? super U, ? extends R> func2) {
            this.f45397a = t;
            this.f45398b = func2;
        }

        @Override // p640rx.functions.Func1
        public R call(U u) {
            return this.f45398b.call((T) this.f45397a, u);
        }
    }

    public OperatorMapPair(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        this.f45390a = func1;
        this.f45391b = func2;
    }

    /* renamed from: a */
    public static <T, U> Func1<T, Observable<U>> m1198a(Func1<? super T, ? extends Iterable<? extends U>> func1) {
        return new C15763a(func1);
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<? extends R>> subscriber) {
        C15764b c15764b = new C15764b(subscriber, this.f45390a, this.f45391b);
        subscriber.add(c15764b);
        return c15764b;
    }
}
