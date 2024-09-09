package kotlin.math;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MathJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0010\u0006\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\bE\u001a\u0011\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0019\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\n\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0019\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0007\u001a\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0011\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0019\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0000H\u0087\b\u001a\u0019\u0010\"\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010&\u001a\u00020\u0000*\u00020\u00002\u0006\u0010%\u001a\u00020$H\u0087\b\u001a\u0015\u0010(\u001a\u00020\u0000*\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010*\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020$H\u0087\b\u001a\r\u0010,\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010-\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0015\u0010/\u001a\u00020\u0000*\u00020\u00002\u0006\u0010.\u001a\u00020\u0000H\u0087\b\u001a\f\u00100\u001a\u00020$*\u00020\u0000H\u0007\u001a\f\u00102\u001a\u000201*\u00020\u0000H\u0007\u001a\u0011\u00104\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u00105\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u00106\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010%\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u00107\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u00108\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0019\u00109\u001a\u0002032\u0006\u0010\u0003\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010:\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010;\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010<\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010=\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010>\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010?\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0019\u0010@\u001a\u0002032\u0006\u0010\u0001\u001a\u0002032\u0006\u0010\u0003\u001a\u000203H\u0087\b\u001a\u0011\u0010A\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010B\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010C\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0018\u0010D\u001a\u0002032\u0006\u0010\u0001\u001a\u0002032\u0006\u0010\u0013\u001a\u000203H\u0007\u001a\u0011\u0010E\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010F\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0010\u0010G\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0007\u001a\u0011\u0010H\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010\u0001\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010I\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0010\u0010J\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0007\u001a\u0011\u0010K\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010L\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0011\u0010M\u001a\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0019\u0010N\u001a\u0002032\u0006\u0010\u001f\u001a\u0002032\u0006\u0010 \u001a\u000203H\u0087\b\u001a\u0019\u0010O\u001a\u0002032\u0006\u0010\u001f\u001a\u0002032\u0006\u0010 \u001a\u000203H\u0087\b\u001a\u0015\u0010P\u001a\u000203*\u0002032\u0006\u0010\u0001\u001a\u000203H\u0087\b\u001a\u0015\u0010Q\u001a\u000203*\u0002032\u0006\u0010%\u001a\u00020$H\u0087\b\u001a\u0015\u0010R\u001a\u000203*\u0002032\u0006\u0010'\u001a\u000203H\u0087\b\u001a\u0015\u0010S\u001a\u000203*\u0002032\u0006\u0010)\u001a\u000203H\u0087\b\u001a\u0015\u0010T\u001a\u000203*\u0002032\u0006\u0010)\u001a\u00020$H\u0087\b\u001a\r\u0010U\u001a\u000203*\u000203H\u0087\b\u001a\r\u0010V\u001a\u000203*\u000203H\u0087\b\u001a\u0015\u0010W\u001a\u000203*\u0002032\u0006\u0010.\u001a\u000203H\u0087\b\u001a\f\u0010X\u001a\u00020$*\u000203H\u0007\u001a\f\u0010Y\u001a\u000201*\u000203H\u0007\u001a\u0011\u0010Z\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0087\b\u001a\u0019\u0010[\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010 \u001a\u00020$H\u0087\b\u001a\u0019\u0010\\\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010 \u001a\u00020$H\u0087\b\u001a\u0011\u0010]\u001a\u0002012\u0006\u0010%\u001a\u000201H\u0087\b\u001a\u0019\u0010^\u001a\u0002012\u0006\u0010\u001f\u001a\u0002012\u0006\u0010 \u001a\u000201H\u0087\b\u001a\u0019\u0010_\u001a\u0002012\u0006\u0010\u001f\u001a\u0002012\u0006\u0010 \u001a\u000201H\u0087\b\"\u001f\u0010d\u001a\u00020\u0000*\u00020\u00008\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\bb\u0010c\u001a\u0004\b`\u0010a\"\u001f\u0010)\u001a\u00020\u0000*\u00020\u00008\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\bf\u0010c\u001a\u0004\be\u0010a\"\u001f\u0010i\u001a\u00020\u0000*\u00020\u00008\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\bh\u0010c\u001a\u0004\bg\u0010a\"\u001f\u0010d\u001a\u000203*\u0002038\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\bb\u0010l\u001a\u0004\bj\u0010k\"\u001f\u0010)\u001a\u000203*\u0002038\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\bf\u0010l\u001a\u0004\bm\u0010k\"\u001f\u0010i\u001a\u000203*\u0002038\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\bh\u0010l\u001a\u0004\bn\u0010k\"\u001f\u0010d\u001a\u00020$*\u00020$8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\bb\u0010q\u001a\u0004\bo\u0010p\"\u001e\u0010)\u001a\u00020$*\u00020$8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bf\u0010q\u001a\u0004\br\u0010p\"\u001f\u0010d\u001a\u000201*\u0002018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\bb\u0010u\u001a\u0004\bs\u0010t\"\u001e\u0010)\u001a\u00020$*\u0002018FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bf\u0010u\u001a\u0004\bv\u0010w\u00a8\u0006x"}, d2 = {"", "x", "O0", "y", "U0", "m", "i", CampaignEx.JSON_KEY_AD_Q, "s", "Q0", "A", "W0", "o", "k", "u", "c0", "S0", "C", "E", "base", "i0", "e0", "k0", "m0", "g0", "w", "G", "Y0", "G0", "e", "M0", "a", "b", "s0", "o0", "C0", "", "n", "D0", "divisor", "c", "sign", "a1", "b1", "A0", "w0", "to", "y0", "I0", "", "K0", "", "P0", "z", "V0", "j", "r", "t", "R0", "B", "X0", "p", "l", "v", "d0", "T0", "D", "F", "j0", "f0", "l0", "n0", "h0", "H", "Z0", "H0", "f", "N0", "t0", "p0", "E0", "F0", "d", "c1", "d1", "B0", "x0", "z0", "J0", "L0", "g", "u0", "q0", "h", "v0", "r0", "I", "(D)D", "getAbsoluteValue$annotations", "(D)V", "absoluteValue", "Q", "getSign$annotations", "Y", "getUlp$annotations", "ulp", "J", "(F)F", "(F)V", "R", "Z", "K", "(I)I", "(I)V", "S", "L", "(J)J", "(J)V", "T", "(J)I", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/math/MathKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d extends c {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double A(double d4) {
        return Math.cosh(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double A0(double d4) {
        return Math.nextUp(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float B(float f4) {
        return (float) Math.cosh(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float B0(float f4) {
        return Math.nextUp(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double C(double d4) {
        return Math.exp(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double C0(double d4, double d5) {
        return Math.pow(d4, d5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float D(float f4) {
        return (float) Math.exp(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double D0(double d4, int i4) {
        return Math.pow(d4, i4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double E(double d4) {
        return Math.expm1(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float E0(float f4, float f5) {
        return (float) Math.pow(f4, f5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float F(float f4) {
        return (float) Math.expm1(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float F0(float f4, int i4) {
        return (float) Math.pow(f4, i4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double G(double d4) {
        return Math.floor(d4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final double G0(double d4) {
        return Math.rint(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float H(float f4) {
        return (float) Math.floor(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float H0(float f4) {
        return (float) Math.rint(f4);
    }

    private static final double I(double d4) {
        return Math.abs(d4);
    }

    @SinceKotlin(version = "1.2")
    public static int I0(double d4) {
        if (Double.isNaN(d4)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d4 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d4 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d4);
    }

    private static final float J(float f4) {
        return Math.abs(f4);
    }

    @SinceKotlin(version = "1.2")
    public static final int J0(float f4) {
        if (Float.isNaN(f4)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f4);
    }

    private static final int K(int i4) {
        return Math.abs(i4);
    }

    @SinceKotlin(version = "1.2")
    public static long K0(double d4) {
        if (Double.isNaN(d4)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d4);
    }

    private static final long L(long j4) {
        return Math.abs(j4);
    }

    @SinceKotlin(version = "1.2")
    public static final long L0(float f4) {
        long K0;
        K0 = K0(f4);
        return K0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void M(double d4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double M0(double d4) {
        return Math.signum(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void N(float f4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float N0(float f4) {
        return Math.signum(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void O(int i4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double O0(double d4) {
        return Math.sin(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void P(long j4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float P0(float f4) {
        return (float) Math.sin(f4);
    }

    private static final double Q(double d4) {
        return Math.signum(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double Q0(double d4) {
        return Math.sinh(d4);
    }

    private static final float R(float f4) {
        return Math.signum(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float R0(float f4) {
        return (float) Math.sinh(f4);
    }

    public static int S(int i4) {
        if (i4 < 0) {
            return -1;
        }
        return i4 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double S0(double d4) {
        return Math.sqrt(d4);
    }

    public static int T(long j4) {
        if (j4 < 0) {
            return -1;
        }
        return j4 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float T0(float f4) {
        return (float) Math.sqrt(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void U(double d4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double U0(double d4) {
        return Math.tan(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void V(float f4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float V0(float f4) {
        return (float) Math.tan(f4);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void W(int i4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double W0(double d4) {
        return Math.tanh(d4);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void X(long j4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float X0(float f4) {
        return (float) Math.tanh(f4);
    }

    private static final double Y(double d4) {
        return Math.ulp(d4);
    }

    @SinceKotlin(version = "1.2")
    public static final double Y0(double d4) {
        if (Double.isNaN(d4) || Double.isInfinite(d4)) {
            return d4;
        }
        if (d4 > 0.0d) {
            return Math.floor(d4);
        }
        return Math.ceil(d4);
    }

    private static final float Z(float f4) {
        return Math.ulp(f4);
    }

    @SinceKotlin(version = "1.2")
    public static final float Z0(float f4) {
        double ceil;
        if (Float.isNaN(f4) || Float.isInfinite(f4)) {
            return f4;
        }
        if (f4 > 0.0f) {
            ceil = Math.floor(f4);
        } else {
            ceil = Math.ceil(f4);
        }
        return (float) ceil;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void a0(double d4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double a1(double d4, double d5) {
        return Math.copySign(d4, d5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void b0(float f4) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double b1(double d4, int i4) {
        return Math.copySign(d4, i4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double c(double d4, double d5) {
        return Math.IEEEremainder(d4, d5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double c0(double d4, double d5) {
        return Math.hypot(d4, d5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float c1(float f4, float f5) {
        return Math.copySign(f4, f5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float d(float f4, float f5) {
        return (float) Math.IEEEremainder(f4, f5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float d0(float f4, float f5) {
        return (float) Math.hypot(f4, f5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float d1(float f4, int i4) {
        return Math.copySign(f4, i4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double e(double d4) {
        return Math.abs(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double e0(double d4) {
        return Math.log(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float f(float f4) {
        return Math.abs(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float f0(float f4) {
        return (float) Math.log(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int g(int i4) {
        return Math.abs(i4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double g0(double d4) {
        return Math.log1p(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long h(long j4) {
        return Math.abs(j4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float h0(float f4) {
        return (float) Math.log1p(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double i(double d4) {
        return Math.acos(d4);
    }

    @SinceKotlin(version = "1.2")
    public static final double i0(double d4, double d5) {
        if (d5 > 0.0d) {
            if (d5 == 1.0d) {
                return Double.NaN;
            }
            return Math.log(d4) / Math.log(d5);
        }
        return Double.NaN;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float j(float f4) {
        return (float) Math.acos(f4);
    }

    @SinceKotlin(version = "1.2")
    public static final float j0(float f4, float f5) {
        if (f5 > 0.0f) {
            if (f5 == 1.0f) {
                return Float.NaN;
            }
            return (float) (Math.log(f4) / Math.log(f5));
        }
        return Float.NaN;
    }

    @SinceKotlin(version = "1.2")
    public static final double k(double d4) {
        if (d4 < 1.0d) {
            return Double.NaN;
        }
        if (d4 > a.f55736f) {
            return Math.log(d4) + a.f55732b;
        }
        double d5 = 1;
        Double.isNaN(d5);
        double d6 = d4 - d5;
        if (d6 >= a.f55735e) {
            Double.isNaN(d5);
            return Math.log(d4 + Math.sqrt((d4 * d4) - d5));
        }
        double sqrt = Math.sqrt(d6);
        if (sqrt >= a.f55734d) {
            double d7 = 12;
            Double.isNaN(d7);
            sqrt -= ((sqrt * sqrt) * sqrt) / d7;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double k0(double d4) {
        return Math.log10(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float l(float f4) {
        return (float) k(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float l0(float f4) {
        return (float) Math.log10(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double m(double d4) {
        return Math.asin(d4);
    }

    @SinceKotlin(version = "1.2")
    public static final double m0(double d4) {
        return Math.log(d4) / a.f55732b;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float n(float f4) {
        return (float) Math.asin(f4);
    }

    @SinceKotlin(version = "1.2")
    public static final float n0(float f4) {
        return (float) (Math.log(f4) / a.f55732b);
    }

    @SinceKotlin(version = "1.2")
    public static final double o(double d4) {
        double d5 = a.f55735e;
        if (d4 < d5) {
            if (d4 <= (-d5)) {
                return -o(-d4);
            }
            if (Math.abs(d4) >= a.f55734d) {
                double d6 = 6;
                Double.isNaN(d6);
                return d4 - (((d4 * d4) * d4) / d6);
            }
            return d4;
        } else if (d4 > a.f55737g) {
            if (d4 > a.f55736f) {
                return Math.log(d4) + a.f55732b;
            }
            double d7 = 2;
            Double.isNaN(d7);
            double d8 = d4 * d7;
            double d9 = 1;
            Double.isNaN(d9);
            return Math.log(d8 + (d9 / d8));
        } else {
            double d10 = 1;
            Double.isNaN(d10);
            return Math.log(d4 + Math.sqrt((d4 * d4) + d10));
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double o0(double d4, double d5) {
        return Math.max(d4, d5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float p(float f4) {
        return (float) o(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float p0(float f4, float f5) {
        return Math.max(f4, f5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double q(double d4) {
        return Math.atan(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int q0(int i4, int i5) {
        return Math.max(i4, i5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float r(float f4) {
        return (float) Math.atan(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long r0(long j4, long j5) {
        return Math.max(j4, j5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double s(double d4, double d5) {
        return Math.atan2(d4, d5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double s0(double d4, double d5) {
        return Math.min(d4, d5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float t(float f4, float f5) {
        return (float) Math.atan2(f4, f5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float t0(float f4, float f5) {
        return Math.min(f4, f5);
    }

    @SinceKotlin(version = "1.2")
    public static final double u(double d4) {
        if (Math.abs(d4) < a.f55735e) {
            if (Math.abs(d4) > a.f55734d) {
                double d5 = 3;
                Double.isNaN(d5);
                return d4 + (((d4 * d4) * d4) / d5);
            }
            return d4;
        }
        double d6 = 1;
        Double.isNaN(d6);
        Double.isNaN(d6);
        double log = Math.log((d6 + d4) / (d6 - d4));
        double d7 = 2;
        Double.isNaN(d7);
        return log / d7;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int u0(int i4, int i5) {
        return Math.min(i4, i5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float v(float f4) {
        return (float) u(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long v0(long j4, long j5) {
        return Math.min(j4, j5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double w(double d4) {
        return Math.ceil(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double w0(double d4) {
        return Math.nextAfter(d4, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float x(float f4) {
        return (float) Math.ceil(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float x0(float f4) {
        return Math.nextAfter(f4, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double y(double d4) {
        return Math.cos(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double y0(double d4, double d5) {
        return Math.nextAfter(d4, d5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float z(float f4) {
        return (float) Math.cos(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float z0(float f4, float f5) {
        return Math.nextAfter(f4, f5);
    }
}
