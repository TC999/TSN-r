package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Action0;

/* renamed from: rx.internal.operators.b1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeSkipTimed<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final long f44950a;

    /* renamed from: b */
    final TimeUnit f44951b;

    /* renamed from: c */
    final Scheduler f44952c;

    /* renamed from: d */
    final Observable<T> f44953d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeSkipTimed.java */
    /* renamed from: rx.internal.operators.b1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15659a<T> extends Subscriber<T> implements Action0 {

        /* renamed from: a */
        final Subscriber<? super T> f44954a;

        /* renamed from: b */
        volatile boolean f44955b;

        C15659a(Subscriber<? super T> subscriber) {
            this.f44954a = subscriber;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            this.f44955b = true;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            try {
                this.f44954a.onCompleted();
            } finally {
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            try {
                this.f44954a.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f44955b) {
                this.f44954a.onNext(t);
            }
        }
    }

    public OnSubscribeSkipTimed(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f44953d = observable;
        this.f44950a = j;
        this.f44951b = timeUnit;
        this.f44952c = scheduler;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f44952c.mo450a();
        C15659a c15659a = new C15659a(subscriber);
        c15659a.add(mo450a);
        subscriber.add(c15659a);
        mo450a.mo460F(c15659a, this.f44950a, this.f44951b);
        this.f44953d.m1822I6(c15659a);
    }
}
