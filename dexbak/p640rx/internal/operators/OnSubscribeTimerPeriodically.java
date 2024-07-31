package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;

/* renamed from: rx.internal.operators.g1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeTimerPeriodically implements Observable.InterfaceC15567a<Long> {

    /* renamed from: a */
    final long f45189a;

    /* renamed from: b */
    final long f45190b;

    /* renamed from: c */
    final TimeUnit f45191c;

    /* renamed from: d */
    final Scheduler f45192d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeTimerPeriodically.java */
    /* renamed from: rx.internal.operators.g1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15721a implements Action0 {

        /* renamed from: a */
        long f45193a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f45194b;

        /* renamed from: c */
        final /* synthetic */ Scheduler.AbstractC15607a f45195c;

        C15721a(Subscriber subscriber, Scheduler.AbstractC15607a abstractC15607a) {
            this.f45194b = subscriber;
            this.f45195c = abstractC15607a;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            try {
                Subscriber subscriber = this.f45194b;
                long j = this.f45193a;
                this.f45193a = 1 + j;
                subscriber.onNext(Long.valueOf(j));
            } catch (Throwable th) {
                try {
                    this.f45195c.unsubscribe();
                } finally {
                    C15575a.m1473f(th, this.f45194b);
                }
            }
        }
    }

    public OnSubscribeTimerPeriodically(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.f45189a = j;
        this.f45190b = j2;
        this.f45191c = timeUnit;
        this.f45192d = scheduler;
    }

    @Override // p640rx.functions.Action1
    public void call(Subscriber<? super Long> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45192d.mo450a();
        subscriber.add(mo450a);
        mo450a.mo459G(new C15721a(subscriber, mo450a), this.f45189a, this.f45190b, this.f45191c);
    }
}
