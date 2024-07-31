package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;

/* renamed from: rx.internal.operators.f1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeTimerOnce implements Observable.InterfaceC15567a<Long> {

    /* renamed from: a */
    final long f45142a;

    /* renamed from: b */
    final TimeUnit f45143b;

    /* renamed from: c */
    final Scheduler f45144c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeTimerOnce.java */
    /* renamed from: rx.internal.operators.f1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15707a implements Action0 {

        /* renamed from: a */
        final /* synthetic */ Subscriber f45145a;

        C15707a(Subscriber subscriber) {
            this.f45145a = subscriber;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            try {
                this.f45145a.onNext(0L);
                this.f45145a.onCompleted();
            } catch (Throwable th) {
                C15575a.m1473f(th, this.f45145a);
            }
        }
    }

    public OnSubscribeTimerOnce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f45142a = j;
        this.f45143b = timeUnit;
        this.f45144c = scheduler;
    }

    @Override // p640rx.functions.Action1
    public void call(Subscriber<? super Long> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45144c.mo450a();
        subscriber.add(mo450a);
        mo450a.mo460F(new C15707a(subscriber), this.f45142a, this.f45143b);
    }
}
