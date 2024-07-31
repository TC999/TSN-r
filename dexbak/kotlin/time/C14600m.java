package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;

/* compiled from: TimeSources.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0014J\u001b\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m12616d2 = {"Lkotlin/time/m;", "Lkotlin/time/b;", "Lkotlin/time/d;", "duration", "Lkotlin/f1;", "d", "(J)V", "", "c", "e", "J", "reading", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalTime
/* renamed from: kotlin.time.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14600m extends AbstractC14594b {

    /* renamed from: c */
    private long f41667c;

    public C14600m() {
        super(TimeUnit.NANOSECONDS);
    }

    /* renamed from: d */
    private final void m5986d(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f41667c + "ns is advanced by " + Duration.m6102x0(j) + '.');
    }

    @Override // kotlin.time.AbstractC14594b
    /* renamed from: c */
    protected long mo5987c() {
        return this.f41667c;
    }

    /* renamed from: e */
    public final void m5985e(long j) {
        long j2;
        long m6108u0 = Duration.m6108u0(j, m6180b());
        if (m6108u0 != Long.MIN_VALUE && m6108u0 != Long.MAX_VALUE) {
            long j3 = this.f41667c;
            j2 = j3 + m6108u0;
            if ((m6108u0 ^ j3) >= 0 && (j3 ^ j2) < 0) {
                m5986d(j);
            }
        } else {
            double m6114r0 = Duration.m6114r0(j, m6180b());
            double d = this.f41667c;
            Double.isNaN(d);
            double d2 = d + m6114r0;
            if (d2 > Long.MAX_VALUE || d2 < Long.MIN_VALUE) {
                m5986d(j);
            }
            j2 = (long) d2;
        }
        this.f41667c = j2;
    }
}
