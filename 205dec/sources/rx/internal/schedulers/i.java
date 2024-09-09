package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.h;
import rx.internal.subscriptions.SequentialSubscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SchedulePeriodicHelper.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final long f63818a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SchedulePeriodicHelper.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class a implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        long f63819a;

        /* renamed from: b  reason: collision with root package name */
        long f63820b;

        /* renamed from: c  reason: collision with root package name */
        long f63821c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f63822d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f63823e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f63824f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ SequentialSubscription f63825g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ b f63826h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ h.a f63827i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ long f63828j;

        a(long j4, long j5, rx.functions.a aVar, SequentialSubscription sequentialSubscription, b bVar, h.a aVar2, long j6) {
            this.f63822d = j4;
            this.f63823e = j5;
            this.f63824f = aVar;
            this.f63825g = sequentialSubscription;
            this.f63826h = bVar;
            this.f63827i = aVar2;
            this.f63828j = j6;
            this.f63820b = j4;
            this.f63821c = j5;
        }

        @Override // rx.functions.a
        public void call() {
            long j4;
            this.f63824f.call();
            if (this.f63825g.isUnsubscribed()) {
                return;
            }
            b bVar = this.f63826h;
            long a4 = bVar != null ? bVar.a() : TimeUnit.MILLISECONDS.toNanos(this.f63827i.b());
            long j5 = i.f63818a;
            long j6 = this.f63820b;
            if (a4 + j5 >= j6) {
                long j7 = this.f63828j;
                if (a4 < j6 + j7 + j5) {
                    long j8 = this.f63821c;
                    long j9 = this.f63819a + 1;
                    this.f63819a = j9;
                    j4 = j8 + (j9 * j7);
                    this.f63820b = a4;
                    this.f63825g.replace(this.f63827i.F(this, j4 - a4, TimeUnit.NANOSECONDS));
                }
            }
            long j10 = this.f63828j;
            long j11 = a4 + j10;
            long j12 = this.f63819a + 1;
            this.f63819a = j12;
            this.f63821c = j11 - (j10 * j12);
            j4 = j11;
            this.f63820b = a4;
            this.f63825g.replace(this.f63827i.F(this, j4 - a4, TimeUnit.NANOSECONDS));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SchedulePeriodicHelper.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public interface b {
        long a();
    }

    private i() {
        throw new IllegalStateException("No instances!");
    }

    public static rx.m a(h.a aVar, rx.functions.a aVar2, long j4, long j5, TimeUnit timeUnit, b bVar) {
        long nanos = timeUnit.toNanos(j5);
        long a4 = bVar != null ? bVar.a() : TimeUnit.MILLISECONDS.toNanos(aVar.b());
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        sequentialSubscription.replace(aVar.F(new a(a4, timeUnit.toNanos(j4) + a4, aVar2, sequentialSubscription2, bVar, aVar, nanos), j4, timeUnit));
        return sequentialSubscription2;
    }
}
