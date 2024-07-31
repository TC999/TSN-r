package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000Z\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0017\u001a/\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0019\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b\u001a\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b\u001a7\u0010\u0013\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a!\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0087\b\u001a!\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0087\b\u001a!\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\b\u001a!\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\b\u001a!\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0087\b\u001a;\u0010\u001d\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001b\"\u00028\u0000H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010 \u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u001c\u001a\u00020\u001f\"\u00020\u0006H\u0007\u001a\u001c\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\n\u0010\u001c\u001a\u00020!\"\u00020\bH\u0007\u001a\u001c\u0010#\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\n\u0010\u001c\u001a\u00020\"\"\u00020\nH\u0007\u001a\u001c\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u001c\u001a\u00020$\"\u00020\fH\u0007\u001a\u001c\u0010'\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\n\u0010\u001c\u001a\u00020&\"\u00020\u000eH\u0007\u001a\u001c\u0010)\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\n\u0010\u001c\u001a\u00020(\"\u00020\u0010H\u0007\u001a/\u0010*\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b*\u0010\u0005\u001a\u0019\u0010+\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010,\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0019\u0010-\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u0019\u0010.\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u0019\u0010/\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b\u001a\u0019\u00100\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b\u001a7\u00101\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0007¢\u0006\u0004\b1\u0010\u0014\u001a!\u00102\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0087\b\u001a!\u00103\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0087\b\u001a!\u00104\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0087\b\u001a!\u00105\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\b\u001a!\u00106\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\b\u001a!\u00107\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0087\b\u001a;\u00108\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001b\"\u00028\u0000H\u0007¢\u0006\u0004\b8\u0010\u001e\u001a\u001c\u00109\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u001c\u001a\u00020\u001f\"\u00020\u0006H\u0007\u001a\u001c\u0010:\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\n\u0010\u001c\u001a\u00020!\"\u00020\bH\u0007\u001a\u001c\u0010;\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\n\u0010\u001c\u001a\u00020\"\"\u00020\nH\u0007\u001a\u001c\u0010<\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u001c\u001a\u00020$\"\u00020\fH\u0007\u001a\u001c\u0010=\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\n\u0010\u001c\u001a\u00020&\"\u00020\u000eH\u0007\u001a\u001c\u0010>\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\n\u0010\u001c\u001a\u00020(\"\u00020\u0010H\u0007¨\u0006?"}, m12616d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "O", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", UMCommonContent.f37777aG, "", "R", "", "I", "", "L", "", "F", "", "C", "c", "P", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.LATITUDE_SOUTH, "J", "M", "G", "D", "", AdnName.OTHER, "Q", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "B", "", "", "K", "", "N", "", "H", "", ExifInterface.LONGITUDE_EAST, "j0", "U", "m0", "d0", "g0", "a0", "X", "k0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "n0", "e0", "h0", "b0", "Y", "l0", ExifInterface.LONGITUDE_WEST, "o0", "f0", "i0", "c0", "Z", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/comparisons/ComparisonsKt")
/* renamed from: kotlin.comparisons.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class _ComparisonsJvm extends Comparisons {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: A */
    private static final byte m8784A(byte b, byte b2, byte b3) {
        return (byte) Math.max((int) b, Math.max((int) b2, (int) b3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: B */
    public static final byte m8783B(byte b, @NotNull byte... other) {
        C14342f0.m8184p(other, "other");
        for (byte b2 : other) {
            b = (byte) Math.max((int) b, (int) b2);
        }
        return b;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: C */
    private static final double m8782C(double d, double d2) {
        return Math.max(d, d2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: D */
    private static final double m8781D(double d, double d2, double d3) {
        return Math.max(d, Math.max(d2, d3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: E */
    public static final double m8780E(double d, @NotNull double... other) {
        C14342f0.m8184p(other, "other");
        for (double d2 : other) {
            d = Math.max(d, d2);
        }
        return d;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: F */
    private static final float m8779F(float f, float f2) {
        return Math.max(f, f2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: G */
    private static final float m8778G(float f, float f2, float f3) {
        return Math.max(f, Math.max(f2, f3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: H */
    public static final float m8777H(float f, @NotNull float... other) {
        C14342f0.m8184p(other, "other");
        for (float f2 : other) {
            f = Math.max(f, f2);
        }
        return f;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: I */
    private static final int m8776I(int i, int i2) {
        return Math.max(i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: J */
    private static final int m8775J(int i, int i2, int i3) {
        return Math.max(i, Math.max(i2, i3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: K */
    public static final int m8774K(int i, @NotNull int... other) {
        C14342f0.m8184p(other, "other");
        for (int i2 : other) {
            i = Math.max(i, i2);
        }
        return i;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: L */
    private static final long m8773L(long j, long j2) {
        return Math.max(j, j2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: M */
    private static final long m8772M(long j, long j2, long j3) {
        return Math.max(j, Math.max(j2, j3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: N */
    public static final long m8771N(long j, @NotNull long... other) {
        C14342f0.m8184p(other, "other");
        for (long j2 : other) {
            j = Math.max(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: O */
    public static <T extends Comparable<? super T>> T m8770O(@NotNull T a, @NotNull T b) {
        C14342f0.m8184p(a, "a");
        C14342f0.m8184p(b, "b");
        return a.compareTo(b) >= 0 ? a : b;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: P */
    public static final <T extends Comparable<? super T>> T m8769P(@NotNull T a, @NotNull T b, @NotNull T c) {
        C14342f0.m8184p(a, "a");
        C14342f0.m8184p(b, "b");
        C14342f0.m8184p(c, "c");
        return (T) C14241a.m8813O(a, C14241a.m8813O(b, c));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    /* renamed from: Q */
    public static final <T extends Comparable<? super T>> T m8768Q(@NotNull T a, @NotNull T... other) {
        C14342f0.m8184p(a, "a");
        C14342f0.m8184p(other, "other");
        for (T t : other) {
            a = (T) C14241a.m8813O(a, t);
        }
        return a;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: R */
    private static final short m8767R(short s, short s2) {
        return (short) Math.max((int) s, (int) s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: S */
    private static final short m8766S(short s, short s2, short s3) {
        return (short) Math.max((int) s, Math.max((int) s2, (int) s3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: T */
    public static final short m8765T(short s, @NotNull short... other) {
        C14342f0.m8184p(other, "other");
        for (short s2 : other) {
            s = (short) Math.max((int) s, (int) s2);
        }
        return s;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: U */
    private static final byte m8764U(byte b, byte b2) {
        return (byte) Math.min((int) b, (int) b2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: V */
    private static final byte m8763V(byte b, byte b2, byte b3) {
        return (byte) Math.min((int) b, Math.min((int) b2, (int) b3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: W */
    public static final byte m8762W(byte b, @NotNull byte... other) {
        C14342f0.m8184p(other, "other");
        for (byte b2 : other) {
            b = (byte) Math.min((int) b, (int) b2);
        }
        return b;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: X */
    private static final double m8761X(double d, double d2) {
        return Math.min(d, d2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: Y */
    private static final double m8760Y(double d, double d2, double d3) {
        return Math.min(d, Math.min(d2, d3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: Z */
    public static final double m8759Z(double d, @NotNull double... other) {
        C14342f0.m8184p(other, "other");
        for (double d2 : other) {
            d = Math.min(d, d2);
        }
        return d;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: a0 */
    private static final float m8758a0(float f, float f2) {
        return Math.min(f, f2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: b0 */
    private static final float m8757b0(float f, float f2, float f3) {
        return Math.min(f, Math.min(f2, f3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: c0 */
    public static final float m8756c0(float f, @NotNull float... other) {
        C14342f0.m8184p(other, "other");
        for (float f2 : other) {
            f = Math.min(f, f2);
        }
        return f;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: d0 */
    private static final int m8755d0(int i, int i2) {
        return Math.min(i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: e0 */
    private static final int m8754e0(int i, int i2, int i3) {
        return Math.min(i, Math.min(i2, i3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: f0 */
    public static final int m8753f0(int i, @NotNull int... other) {
        C14342f0.m8184p(other, "other");
        for (int i2 : other) {
            i = Math.min(i, i2);
        }
        return i;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: g0 */
    private static final long m8752g0(long j, long j2) {
        return Math.min(j, j2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: h0 */
    private static final long m8751h0(long j, long j2, long j3) {
        return Math.min(j, Math.min(j2, j3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: i0 */
    public static final long m8750i0(long j, @NotNull long... other) {
        C14342f0.m8184p(other, "other");
        for (long j2 : other) {
            j = Math.min(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: j0 */
    public static final <T extends Comparable<? super T>> T m8749j0(@NotNull T a, @NotNull T b) {
        C14342f0.m8184p(a, "a");
        C14342f0.m8184p(b, "b");
        return a.compareTo(b) <= 0 ? a : b;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: k0 */
    public static final <T extends Comparable<? super T>> T m8748k0(@NotNull T a, @NotNull T b, @NotNull T c) {
        C14342f0.m8184p(a, "a");
        C14342f0.m8184p(b, "b");
        C14342f0.m8184p(c, "c");
        return (T) m8749j0(a, m8749j0(b, c));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    /* renamed from: l0 */
    public static final <T extends Comparable<? super T>> T m8747l0(@NotNull T a, @NotNull T... other) {
        C14342f0.m8184p(a, "a");
        C14342f0.m8184p(other, "other");
        for (T t : other) {
            a = (T) m8749j0(a, t);
        }
        return a;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: m0 */
    private static final short m8746m0(short s, short s2) {
        return (short) Math.min((int) s, (int) s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: n0 */
    private static final short m8745n0(short s, short s2, short s3) {
        return (short) Math.min((int) s, Math.min((int) s2, (int) s3));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: o0 */
    public static final short m8744o0(short s, @NotNull short... other) {
        C14342f0.m8184p(other, "other");
        for (short s2 : other) {
            s = (short) Math.min((int) s, (int) s2);
        }
        return s;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: z */
    private static final byte m8743z(byte b, byte b2) {
        return (byte) Math.max((int) b, (int) b2);
    }
}
