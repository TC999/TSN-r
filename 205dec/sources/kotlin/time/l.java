package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TimeSources.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0014J\u001b\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lkotlin/time/l;", "Lkotlin/time/b;", "Lkotlin/time/d;", "duration", "Lkotlin/f1;", "d", "(J)V", "", "c", "e", "J", "reading", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalTime
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l extends b {

    /* renamed from: c  reason: collision with root package name */
    private long f59007c;

    public l() {
        super(DurationUnit.NANOSECONDS);
    }

    private final void d(long j4) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f59007c + "ns is advanced by " + ((Object) d.v0(j4)) + '.');
    }

    @Override // kotlin.time.b
    protected long c() {
        return this.f59007c;
    }

    public final void e(long j4) {
        long j5;
        long s02 = d.s0(j4, b());
        if (s02 != Long.MIN_VALUE && s02 != Long.MAX_VALUE) {
            long j6 = this.f59007c;
            j5 = j6 + s02;
            if ((s02 ^ j6) >= 0 && (j6 ^ j5) < 0) {
                d(j4);
            }
        } else {
            double p02 = d.p0(j4, b());
            double d4 = this.f59007c;
            Double.isNaN(d4);
            double d5 = d4 + p02;
            if (d5 > 9.223372036854776E18d || d5 < -9.223372036854776E18d) {
                d(j4);
            }
            j5 = (long) d5;
        }
        this.f59007c = j5;
    }
}
