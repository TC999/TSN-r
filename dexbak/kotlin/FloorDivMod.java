package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kwad.sdk.api.model.AdnName;
import kotlin.internal.InlineOnly;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\r\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u000e\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0012\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0013\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\u0014\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0016\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0018\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u001b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\u001c\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\u001d\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u001e\u001a\u00020\u0000*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010 \u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010!\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\"\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010#\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010$\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010&\u001a\u00020%*\u00020%2\u0006\u0010\u0001\u001a\u00020%H\u0087\b\u001a\u0015\u0010(\u001a\u00020'*\u00020%2\u0006\u0010\u0001\u001a\u00020'H\u0087\b\u001a\u0015\u0010)\u001a\u00020'*\u00020'2\u0006\u0010\u0001\u001a\u00020%H\u0087\b\u001a\u0015\u0010*\u001a\u00020'*\u00020'2\u0006\u0010\u0001\u001a\u00020'H\u0087\b¨\u0006+"}, m12616d2 = {"", AdnName.OTHER, "", "J", "Z", "", "L", C7202bq.f24604g, "K", "h0", "", ExifInterface.LATITUDE_SOUTH, "l0", "P", "c0", "R", "s0", "Q", "k0", "Y", "o0", "M", "a0", "O", "q0", "N", "i0", ExifInterface.GPS_DIRECTION_TRUE, "m0", "U", "b0", "X", "r0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "j0", ExifInterface.LONGITUDE_WEST, "n0", "", "g0", "", "f0", "e0", "d0", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/NumbersKt")
/* renamed from: kotlin.w */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class FloorDivMod extends BigIntegers {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: J */
    private static final int m5869J(byte b, byte b2) {
        int i = b / b2;
        return ((b ^ b2) >= 0 || b2 * i == b) ? i : i - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: K */
    private static final int m5868K(byte b, int i) {
        int i2 = b / i;
        return ((b ^ i) >= 0 || i * i2 == b) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: L */
    private static final int m5867L(byte b, short s) {
        int i = b / s;
        return ((b ^ s) >= 0 || s * i == b) ? i : i - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: M */
    private static final int m5866M(int i, byte b) {
        int i2 = i / b;
        return ((i ^ b) >= 0 || b * i2 == i) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: N */
    private static final int m5865N(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: O */
    private static final int m5864O(int i, short s) {
        int i2 = i / s;
        return ((i ^ s) >= 0 || s * i2 == i) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: P */
    private static final int m5863P(short s, byte b) {
        int i = s / b;
        return ((s ^ b) >= 0 || b * i == s) ? i : i - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: Q */
    private static final int m5862Q(short s, int i) {
        int i2 = s / i;
        return ((s ^ i) >= 0 || i * i2 == s) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: R */
    private static final int m5861R(short s, short s2) {
        int i = s / s2;
        return ((s ^ s2) >= 0 || s2 * i == s) ? i : i - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: S */
    private static final long m5860S(byte b, long j) {
        long j2 = b;
        long j3 = j2 / j;
        return ((j2 ^ j) >= 0 || j * j3 == j2) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: T */
    private static final long m5859T(int i, long j) {
        long j2 = i;
        long j3 = j2 / j;
        return ((j2 ^ j) >= 0 || j * j3 == j2) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: U */
    private static final long m5858U(long j, byte b) {
        long j2 = b;
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: V */
    private static final long m5857V(long j, int i) {
        long j2 = i;
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: W */
    private static final long m5856W(long j, long j2) {
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: X */
    private static final long m5855X(long j, short s) {
        long j2 = s;
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: Y */
    private static final long m5854Y(short s, long j) {
        long j2 = s;
        long j3 = j2 / j;
        return ((j2 ^ j) >= 0 || j * j3 == j2) ? j3 : j3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: Z */
    private static final byte m5853Z(byte b, byte b2) {
        int i = b % b2;
        return (byte) (i + (b2 & (((i ^ b2) & ((-i) | i)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: a0 */
    private static final byte m5852a0(int i, byte b) {
        int i2 = i % b;
        return (byte) (i2 + (b & (((i2 ^ b) & ((-i2) | i2)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: b0 */
    private static final byte m5851b0(long j, byte b) {
        long j2;
        long j3 = j % b;
        return (byte) (j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: c0 */
    private static final byte m5850c0(short s, byte b) {
        int i = s % b;
        return (byte) (i + (b & (((i ^ b) & ((-i) | i)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: d0 */
    private static final double m5849d0(double d, double d2) {
        double d3 = d % d2;
        return (d3 == Utils.DOUBLE_EPSILON || Math.signum(d3) == Math.signum(d2)) ? d3 : d3 + d2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: e0 */
    private static final double m5848e0(double d, float f) {
        double d2 = f;
        Double.isNaN(d2);
        double d3 = d % d2;
        if (d3 == Utils.DOUBLE_EPSILON || Math.signum(d3) == Math.signum(d2)) {
            return d3;
        }
        Double.isNaN(d2);
        return d3 + d2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: f0 */
    private static final double m5847f0(float f, double d) {
        double d2 = f;
        Double.isNaN(d2);
        double d3 = d2 % d;
        return (d3 == Utils.DOUBLE_EPSILON || Math.signum(d3) == Math.signum(d)) ? d3 : d3 + d;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: g0 */
    private static final float m5846g0(float f, float f2) {
        float f3 = f % f2;
        return (f3 == ((float) Utils.DOUBLE_EPSILON) || Math.signum(f3) == Math.signum(f2)) ? f3 : f3 + f2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: h0 */
    private static final int m5845h0(byte b, int i) {
        int i2 = b % i;
        return i2 + (i & (((i2 ^ i) & ((-i2) | i2)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: i0 */
    private static final int m5844i0(int i, int i2) {
        int i3 = i % i2;
        return i3 + (i2 & (((i3 ^ i2) & ((-i3) | i3)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: j0 */
    private static final int m5843j0(long j, int i) {
        long j2 = i;
        long j3 = j % j2;
        return (int) (j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: k0 */
    private static final int m5842k0(short s, int i) {
        int i2 = s % i;
        return i2 + (i & (((i2 ^ i) & ((-i2) | i2)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: l0 */
    private static final long m5841l0(byte b, long j) {
        long j2 = b % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: m0 */
    private static final long m5840m0(int i, long j) {
        long j2 = i % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: n0 */
    private static final long m5839n0(long j, long j2) {
        long j3 = j % j2;
        return j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: o0 */
    private static final long m5838o0(short s, long j) {
        long j2 = s % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: p0 */
    private static final short m5837p0(byte b, short s) {
        int i = b % s;
        return (short) (i + (s & (((i ^ s) & ((-i) | i)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: q0 */
    private static final short m5836q0(int i, short s) {
        int i2 = i % s;
        return (short) (i2 + (s & (((i2 ^ s) & ((-i2) | i2)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: r0 */
    private static final short m5835r0(long j, short s) {
        long j2;
        long j3 = j % s;
        return (short) (j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    /* renamed from: s0 */
    private static final short m5834s0(short s, short s2) {
        int i = s % s2;
        return (short) (i + (s2 & (((i ^ s2) & ((-i) | i)) >> 31)));
    }
}
