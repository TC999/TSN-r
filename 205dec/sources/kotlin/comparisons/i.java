package kotlin.comparisons;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.b1;
import kotlin.c1;
import kotlin.g1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import kotlin.n0;
import kotlin.o0;
import kotlin.r0;
import kotlin.s0;
import kotlin.v0;
import kotlin.w0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _UComparisons.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\"\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\"\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0001\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a&\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0015\u001a\u00020\u0014\"\u00020\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\n\u0010\u0015\u001a\u00020\u0018\"\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a&\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\n\u0010\u0015\u001a\u00020\u001b\"\u00020\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a&\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\n\u0010\u0015\u001a\u00020\u001e\"\u00020\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 \u001a\"\u0010!\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\u0003\u001a\"\u0010\"\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010\u0006\u001a\"\u0010#\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\t\u001a\"\u0010$\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u000b\u001a+\u0010%\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\r\u001a+\u0010&\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u000f\u001a+\u0010'\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0011\u001a+\u0010(\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0013\u001a&\u0010)\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0015\u001a\u00020\u0014\"\u00020\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u0017\u001a&\u0010*\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\n\u0010\u0015\u001a\u00020\u0018\"\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u001a\u001a&\u0010+\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\n\u0010\u0015\u001a\u00020\u001b\"\u00020\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010\u001d\u001a&\u0010,\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\n\u0010\u0015\u001a\u00020\u001e\"\u00020\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lkotlin/r0;", "a", "b", "(II)I", "Lkotlin/v0;", "j", "(JJ)J", "Lkotlin/n0;", "c", "(BB)B", "Lkotlin/b1;", "(SS)S", "g", "(III)I", "k", "(JJJ)J", "i", "(BBB)B", "f", "(SSS)S", "Lkotlin/s0;", "other", "d", "(I[I)I", "Lkotlin/w0;", "e", "(J[J)J", "Lkotlin/o0;", "h", "(B[B)B", "Lkotlin/c1;", "l", "(S[S)S", "n", "v", "o", "m", "s", "w", "u", "r", "p", CampaignEx.JSON_KEY_AD_Q, "t", "x", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short a(short s3, short s4) {
        return f0.t(s3 & 65535, 65535 & s4) >= 0 ? s3 : s4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static int b(int i4, int i5) {
        return g1.c(i4, i5) >= 0 ? i4 : i5;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte c(byte b4, byte b5) {
        return f0.t(b4 & 255, b5 & 255) >= 0 ? b4 : b5;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    public static final int d(int i4, @NotNull int... other) {
        f0.p(other, "other");
        Iterator<r0> x3 = s0.x(other);
        while (x3.hasNext()) {
            i4 = b(i4, x3.next().l0());
        }
        return i4;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    public static final long e(long j4, @NotNull long... other) {
        f0.p(other, "other");
        Iterator<v0> x3 = w0.x(other);
        while (x3.hasNext()) {
            j4 = j(j4, x3.next().l0());
        }
        return j4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short f(short s3, short s4, short s5) {
        return a(s3, a(s4, s5));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int g(int i4, int i5, int i6) {
        int b4;
        int b5;
        b4 = b(i5, i6);
        b5 = b(i4, b4);
        return b5;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    public static final byte h(byte b4, @NotNull byte... other) {
        f0.p(other, "other");
        Iterator<n0> x3 = o0.x(other);
        while (x3.hasNext()) {
            b4 = c(b4, x3.next().j0());
        }
        return b4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte i(byte b4, byte b5, byte b6) {
        return c(b4, c(b5, b6));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static long j(long j4, long j5) {
        return g1.g(j4, j5) >= 0 ? j4 : j5;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long k(long j4, long j5, long j6) {
        long j7;
        long j8;
        j7 = j(j5, j6);
        j8 = j(j4, j7);
        return j8;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    public static final short l(short s3, @NotNull short... other) {
        f0.p(other, "other");
        Iterator<b1> x3 = c1.x(other);
        while (x3.hasNext()) {
            s3 = a(s3, x3.next().j0());
        }
        return s3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short m(short s3, short s4) {
        return f0.t(s3 & 65535, 65535 & s4) <= 0 ? s3 : s4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static int n(int i4, int i5) {
        return g1.c(i4, i5) <= 0 ? i4 : i5;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte o(byte b4, byte b5) {
        return f0.t(b4 & 255, b5 & 255) <= 0 ? b4 : b5;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    public static final int p(int i4, @NotNull int... other) {
        f0.p(other, "other");
        Iterator<r0> x3 = s0.x(other);
        while (x3.hasNext()) {
            i4 = n(i4, x3.next().l0());
        }
        return i4;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    public static final long q(long j4, @NotNull long... other) {
        f0.p(other, "other");
        Iterator<v0> x3 = w0.x(other);
        while (x3.hasNext()) {
            j4 = v(j4, x3.next().l0());
        }
        return j4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short r(short s3, short s4, short s5) {
        return m(s3, m(s4, s5));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int s(int i4, int i5, int i6) {
        int n4;
        int n5;
        n4 = n(i5, i6);
        n5 = n(i4, n4);
        return n5;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    public static final byte t(byte b4, @NotNull byte... other) {
        f0.p(other, "other");
        Iterator<n0> x3 = o0.x(other);
        while (x3.hasNext()) {
            b4 = o(b4, x3.next().j0());
        }
        return b4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte u(byte b4, byte b5, byte b6) {
        return o(b4, o(b5, b6));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static long v(long j4, long j5) {
        return g1.g(j4, j5) <= 0 ? j4 : j5;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long w(long j4, long j5, long j6) {
        long v3;
        long v4;
        v3 = v(j5, j6);
        v4 = v(j4, v3);
        return v4;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    public static final short x(short s3, @NotNull short... other) {
        f0.p(other, "other");
        Iterator<b1> x3 = c1.x(other);
        while (x3.hasNext()) {
            s3 = m(s3, x3.next().j0());
        }
        return s3;
    }
}
