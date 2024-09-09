package kotlin;

import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UnsignedUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001\u001a\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0001\u001a\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\b\u001a\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\f\u001a\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000H\u0001\u001a\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0001\u001a\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0000H\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"", EventMonitor.V1_STAGING_ADLOG, "v2", "c", "", "g", "Lkotlin/r0;", "d", "(II)I", "e", "Lkotlin/v0;", "h", "(JJ)J", "i", "", "v", "a", "(D)I", "b", "(D)J", "f", "j", "", "k", "base", "l", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "UnsignedKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g1 {
    @PublishedApi
    public static final int a(double d4) {
        if (!Double.isNaN(d4) && d4 > f(0)) {
            if (d4 >= f(-1)) {
                return -1;
            }
            if (d4 <= 2.147483647E9d) {
                return r0.i((int) d4);
            }
            double d5 = Integer.MAX_VALUE;
            Double.isNaN(d5);
            return r0.i(r0.i((int) (d4 - d5)) + r0.i(Integer.MAX_VALUE));
        }
        return 0;
    }

    @PublishedApi
    public static final long b(double d4) {
        if (!Double.isNaN(d4) && d4 > j(0L)) {
            if (d4 >= j(-1L)) {
                return -1L;
            }
            if (d4 < 9.223372036854776E18d) {
                return v0.i((long) d4);
            }
            return v0.i(v0.i((long) (d4 - 9.223372036854776E18d)) - Long.MIN_VALUE);
        }
        return 0L;
    }

    @PublishedApi
    public static final int c(int i4, int i5) {
        return kotlin.jvm.internal.f0.t(i4 ^ Integer.MIN_VALUE, i5 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    public static final int d(int i4, int i5) {
        return r0.i((int) ((i4 & 4294967295L) / (i5 & 4294967295L)));
    }

    @PublishedApi
    public static final int e(int i4, int i5) {
        return r0.i((int) ((i4 & 4294967295L) % (i5 & 4294967295L)));
    }

    @PublishedApi
    public static final double f(int i4) {
        double d4 = Integer.MAX_VALUE & i4;
        double d5 = (i4 >>> 31) << 30;
        double d6 = 2;
        Double.isNaN(d5);
        Double.isNaN(d6);
        Double.isNaN(d4);
        return d4 + (d5 * d6);
    }

    @PublishedApi
    public static final int g(long j4, long j5) {
        return kotlin.jvm.internal.f0.u(j4 ^ Long.MIN_VALUE, j5 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    public static final long h(long j4, long j5) {
        if (j5 < 0) {
            return g(j4, j5) < 0 ? v0.i(0L) : v0.i(1L);
        } else if (j4 >= 0) {
            return v0.i(j4 / j5);
        } else {
            long j6 = ((j4 >>> 1) / j5) << 1;
            return v0.i(j6 + (g(v0.i(j4 - (j6 * j5)), v0.i(j5)) < 0 ? 0 : 1));
        }
    }

    @PublishedApi
    public static final long i(long j4, long j5) {
        if (j5 < 0) {
            return g(j4, j5) < 0 ? j4 : v0.i(j4 - j5);
        } else if (j4 >= 0) {
            return v0.i(j4 % j5);
        } else {
            long j6 = j4 - ((((j4 >>> 1) / j5) << 1) * j5);
            if (g(v0.i(j6), v0.i(j5)) < 0) {
                j5 = 0;
            }
            return v0.i(j6 - j5);
        }
    }

    @PublishedApi
    public static final double j(long j4) {
        double d4 = j4 >>> 11;
        double d5 = 2048;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = j4 & 2047;
        Double.isNaN(d6);
        return (d4 * d5) + d6;
    }

    @NotNull
    public static final String k(long j4) {
        return l(j4, 10);
    }

    @NotNull
    public static final String l(long j4, int i4) {
        int a4;
        int a5;
        int a6;
        if (j4 >= 0) {
            a6 = kotlin.text.b.a(i4);
            String l4 = Long.toString(j4, a6);
            kotlin.jvm.internal.f0.o(l4, "toString(this, checkRadix(radix))");
            return l4;
        }
        long j5 = i4;
        long j6 = ((j4 >>> 1) / j5) << 1;
        long j7 = j4 - (j6 * j5);
        if (j7 >= j5) {
            j7 -= j5;
            j6++;
        }
        a4 = kotlin.text.b.a(i4);
        String l5 = Long.toString(j6, a4);
        kotlin.jvm.internal.f0.o(l5, "toString(this, checkRadix(radix))");
        a5 = kotlin.text.b.a(i4);
        String l6 = Long.toString(j7, a5);
        kotlin.jvm.internal.f0.o(l6, "toString(this, checkRadix(radix))");
        return kotlin.jvm.internal.f0.C(l5, l6);
    }
}
