package p640rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.internal.subscriptions.SequentialSubscription;

/* renamed from: rx.internal.schedulers.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SchedulePeriodicHelper {

    /* renamed from: a */
    public static final long f46387a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulePeriodicHelper.java */
    /* renamed from: rx.internal.schedulers.i$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16015a implements Action0 {

        /* renamed from: a */
        long f46388a;

        /* renamed from: b */
        long f46389b;

        /* renamed from: c */
        long f46390c;

        /* renamed from: d */
        final /* synthetic */ long f46391d;

        /* renamed from: e */
        final /* synthetic */ long f46392e;

        /* renamed from: f */
        final /* synthetic */ Action0 f46393f;

        /* renamed from: g */
        final /* synthetic */ SequentialSubscription f46394g;

        /* renamed from: h */
        final /* synthetic */ InterfaceC16016b f46395h;

        /* renamed from: i */
        final /* synthetic */ Scheduler.AbstractC15607a f46396i;

        /* renamed from: j */
        final /* synthetic */ long f46397j;

        C16015a(long j, long j2, Action0 action0, SequentialSubscription sequentialSubscription, InterfaceC16016b interfaceC16016b, Scheduler.AbstractC15607a abstractC15607a, long j3) {
            this.f46391d = j;
            this.f46392e = j2;
            this.f46393f = action0;
            this.f46394g = sequentialSubscription;
            this.f46395h = interfaceC16016b;
            this.f46396i = abstractC15607a;
            this.f46397j = j3;
            this.f46389b = j;
            this.f46390c = j2;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            long j;
            this.f46393f.call();
            if (this.f46394g.isUnsubscribed()) {
                return;
            }
            InterfaceC16016b interfaceC16016b = this.f46395h;
            long mo458a = interfaceC16016b != null ? interfaceC16016b.mo458a() : TimeUnit.MILLISECONDS.toNanos(this.f46396i.mo457b());
            long j2 = SchedulePeriodicHelper.f46387a;
            long j3 = this.f46389b;
            if (mo458a + j2 >= j3) {
                long j4 = this.f46397j;
                if (mo458a < j3 + j4 + j2) {
                    long j5 = this.f46390c;
                    long j6 = this.f46388a + 1;
                    this.f46388a = j6;
                    j = j5 + (j6 * j4);
                    this.f46389b = mo458a;
                    this.f46394g.replace(this.f46396i.mo460F(this, j - mo458a, TimeUnit.NANOSECONDS));
                }
            }
            long j7 = this.f46397j;
            long j8 = mo458a + j7;
            long j9 = this.f46388a + 1;
            this.f46388a = j9;
            this.f46390c = j8 - (j7 * j9);
            j = j8;
            this.f46389b = mo458a;
            this.f46394g.replace(this.f46396i.mo460F(this, j - mo458a, TimeUnit.NANOSECONDS));
        }
    }

    /* compiled from: SchedulePeriodicHelper.java */
    /* renamed from: rx.internal.schedulers.i$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC16016b {
        /* renamed from: a */
        long mo458a();
    }

    private SchedulePeriodicHelper() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static Subscription m936a(Scheduler.AbstractC15607a abstractC15607a, Action0 action0, long j, long j2, TimeUnit timeUnit, InterfaceC16016b interfaceC16016b) {
        long nanos = timeUnit.toNanos(j2);
        long mo458a = interfaceC16016b != null ? interfaceC16016b.mo458a() : TimeUnit.MILLISECONDS.toNanos(abstractC15607a.mo457b());
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        sequentialSubscription.replace(abstractC15607a.mo460F(new C16015a(mo458a, timeUnit.toNanos(j) + mo458a, action0, sequentialSubscription2, interfaceC16016b, abstractC15607a, nanos), j, timeUnit));
        return sequentialSubscription2;
    }
}
