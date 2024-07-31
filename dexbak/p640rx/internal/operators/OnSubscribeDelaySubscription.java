package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.observers.Subscribers;

/* renamed from: rx.internal.operators.c0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeDelaySubscription<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Observable<? extends T> f44993a;

    /* renamed from: b */
    final long f44994b;

    /* renamed from: c */
    final TimeUnit f44995c;

    /* renamed from: d */
    final Scheduler f44996d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeDelaySubscription.java */
    /* renamed from: rx.internal.operators.c0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15672a implements Action0 {

        /* renamed from: a */
        final /* synthetic */ Subscriber f44997a;

        C15672a(Subscriber subscriber) {
            this.f44997a = subscriber;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            if (this.f44997a.isUnsubscribed()) {
                return;
            }
            OnSubscribeDelaySubscription.this.f44993a.m1822I6(Subscribers.m631f(this.f44997a));
        }
    }

    public OnSubscribeDelaySubscription(Observable<? extends T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f44993a = observable;
        this.f44994b = j;
        this.f44995c = timeUnit;
        this.f44996d = scheduler;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f44996d.mo450a();
        subscriber.add(mo450a);
        mo450a.mo460F(new C15672a(subscriber), this.f44994b, this.f44995c);
    }
}
