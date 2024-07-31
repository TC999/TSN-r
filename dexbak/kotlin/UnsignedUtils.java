package kotlin;

import com.kuaishou.weapon.p205p0.C7304t;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.CharJVM;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001\u001a\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0001\u001a\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u001a\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\f\u001a\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000H\u0001\u001a\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0001\u001a\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0000H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m12616d2 = {"", "v1", "v2", "c", "", "g", "Lkotlin/r0;", "d", "(II)I", "e", "Lkotlin/v0;", "h", "(JJ)J", "i", "", "v", "a", "(D)I", "b", "(D)J", "f", "j", "", "k", "base", C7304t.f25048d, "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "UnsignedKt")
/* renamed from: kotlin.g1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UnsignedUtils {
    @PublishedApi
    /* renamed from: a */
    public static final int m8563a(double d) {
        if (!Double.isNaN(d) && d > m8558f(0)) {
            if (d >= m8558f(-1)) {
                return -1;
            }
            double d2 = Integer.MAX_VALUE;
            if (d <= d2) {
                return UInt.m7678h((int) d);
            }
            Double.isNaN(d2);
            return UInt.m7678h(UInt.m7678h((int) (d - d2)) + UInt.m7678h(Integer.MAX_VALUE));
        }
        return 0;
    }

    @PublishedApi
    /* renamed from: b */
    public static final long m8562b(double d) {
        if (!Double.isNaN(d) && d > m8554j(0L)) {
            if (d >= m8554j(-1L)) {
                return -1L;
            }
            if (d < Long.MAX_VALUE) {
                return ULong.m5889h((long) d);
            }
            return ULong.m5889h(ULong.m5889h((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
        }
        return 0L;
    }

    @PublishedApi
    /* renamed from: c */
    public static final int m8561c(int i, int i2) {
        return C14342f0.m8180t(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: d */
    public static final int m8560d(int i, int i2) {
        return UInt.m7678h((int) ((i & 4294967295L) / (i2 & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: e */
    public static final int m8559e(int i, int i2) {
        return UInt.m7678h((int) ((i & 4294967295L) % (i2 & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: f */
    public static final double m8558f(int i) {
        double d = Integer.MAX_VALUE & i;
        double d2 = (i >>> 31) << 30;
        double d3 = 2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d);
        return d + (d2 * d3);
    }

    @PublishedApi
    /* renamed from: g */
    public static final int m8557g(long j, long j2) {
        return ((j ^ Long.MIN_VALUE) > (j2 ^ Long.MIN_VALUE) ? 1 : ((j ^ Long.MIN_VALUE) == (j2 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    @PublishedApi
    /* renamed from: h */
    public static final long m8556h(long j, long j2) {
        if (j2 < 0) {
            return m8557g(j, j2) < 0 ? ULong.m5889h(0L) : ULong.m5889h(1L);
        } else if (j >= 0) {
            return ULong.m5889h(j / j2);
        } else {
            long j3 = ((j >>> 1) / j2) << 1;
            return ULong.m5889h(j3 + (m8557g(ULong.m5889h(j - (j3 * j2)), ULong.m5889h(j2)) < 0 ? 0 : 1));
        }
    }

    @PublishedApi
    /* renamed from: i */
    public static final long m8555i(long j, long j2) {
        if (j2 < 0) {
            return m8557g(j, j2) < 0 ? j : ULong.m5889h(j - j2);
        } else if (j >= 0) {
            return ULong.m5889h(j % j2);
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (m8557g(ULong.m5889h(j3), ULong.m5889h(j2)) < 0) {
                j2 = 0;
            }
            return ULong.m5889h(j3 - j2);
        }
    }

    @PublishedApi
    /* renamed from: j */
    public static final double m8554j(long j) {
        double d = j >>> 11;
        double d2 = 2048;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = j & 2047;
        Double.isNaN(d3);
        return (d * d2) + d3;
    }

    @NotNull
    /* renamed from: k */
    public static final String m8553k(long j) {
        return m8552l(j, 10);
    }

    @NotNull
    /* renamed from: l */
    public static final String m8552l(long j, int i) {
        int m6893a;
        int m6893a2;
        int m6893a3;
        if (j >= 0) {
            m6893a3 = CharJVM.m6893a(i);
            String l = Long.toString(j, m6893a3);
            C14342f0.m8185o(l, "java.lang.Long.toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        m6893a = CharJVM.m6893a(i);
        String l2 = Long.toString(j3, m6893a);
        C14342f0.m8185o(l2, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l2);
        m6893a2 = CharJVM.m6893a(i);
        String l3 = Long.toString(j4, m6893a2);
        C14342f0.m8185o(l3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }
}
