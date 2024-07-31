package p640rx;

import java.util.concurrent.TimeUnit;
import p640rx.functions.Action0;
import p640rx.functions.Func1;
import p640rx.internal.schedulers.SchedulePeriodicHelper;
import p640rx.internal.schedulers.SchedulerWhen;

/* renamed from: rx.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class Scheduler {

    /* compiled from: Scheduler.java */
    /* renamed from: rx.h$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15607a implements Subscription {
        /* renamed from: F */
        public abstract Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit);

        /* renamed from: G */
        public Subscription mo459G(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            return SchedulePeriodicHelper.m936a(this, action0, j, j2, timeUnit, null);
        }

        /* renamed from: b */
        public long mo457b() {
            return System.currentTimeMillis();
        }

        /* renamed from: d */
        public abstract Subscription mo456d(Action0 action0);
    }

    /* renamed from: a */
    public abstract AbstractC15607a mo450a();

    /* renamed from: b */
    public long mo462b() {
        return System.currentTimeMillis();
    }

    /* renamed from: d */
    public <S extends Scheduler & Subscription> S m1430d(Func1<Observable<Observable<Completable>>, Completable> func1) {
        return new SchedulerWhen(func1, this);
    }
}
