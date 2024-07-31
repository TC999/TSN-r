package kotlin.math;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MathJVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0010\u0006\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\bD\u001a\u0011\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0019\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\n\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0019\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0007\u001a\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0011\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0019\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0000H\u0087\b\u001a\u0019\u0010\"\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010&\u001a\u00020\u0000*\u00020\u00002\u0006\u0010%\u001a\u00020$H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010)\u001a\u00020\u0000*\u00020\u00002\u0006\u0010(\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010*\u001a\u00020\u0000*\u00020\u00002\u0006\u0010(\u001a\u00020$H\u0087\b\u001a\r\u0010+\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010,\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0015\u0010.\u001a\u00020\u0000*\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\u0087\b\u001a\f\u0010/\u001a\u00020$*\u00020\u0000H\u0007\u001a\f\u00101\u001a\u000200*\u00020\u0000H\u0007\u001a\u0011\u00103\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010\u0001\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u00104\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u00105\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u00106\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u00107\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0019\u00108\u001a\u0002022\u0006\u0010\b\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u00109\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010:\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010;\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010%\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010<\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010=\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0019\u0010>\u001a\u0002022\u0006\u0010\u0001\u001a\u0002022\u0006\u0010\b\u001a\u000202H\u0087\b\u001a\u0011\u0010?\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010@\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010A\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0018\u0010B\u001a\u0002022\u0006\u0010\u0001\u001a\u0002022\u0006\u0010\u0013\u001a\u000202H\u0007\u001a\u0011\u0010C\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010D\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0010\u0010E\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0007\u001a\u0011\u0010F\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010G\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010H\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0010\u0010I\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0007\u001a\u0011\u0010J\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010K\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0011\u0010L\u001a\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0019\u0010M\u001a\u0002022\u0006\u0010\u001f\u001a\u0002022\u0006\u0010 \u001a\u000202H\u0087\b\u001a\u0019\u0010N\u001a\u0002022\u0006\u0010\u001f\u001a\u0002022\u0006\u0010 \u001a\u000202H\u0087\b\u001a\u0015\u0010O\u001a\u000202*\u0002022\u0006\u0010\u0001\u001a\u000202H\u0087\b\u001a\u0015\u0010P\u001a\u000202*\u0002022\u0006\u0010%\u001a\u00020$H\u0087\b\u001a\u0015\u0010 \u001a\u000202*\u0002022\u0006\u0010'\u001a\u000202H\u0087\b\u001a\u0015\u0010Q\u001a\u000202*\u0002022\u0006\u0010(\u001a\u000202H\u0087\b\u001a\u0015\u0010R\u001a\u000202*\u0002022\u0006\u0010(\u001a\u00020$H\u0087\b\u001a\r\u0010S\u001a\u000202*\u000202H\u0087\b\u001a\r\u0010T\u001a\u000202*\u000202H\u0087\b\u001a\u0015\u0010U\u001a\u000202*\u0002022\u0006\u0010-\u001a\u000202H\u0087\b\u001a\f\u0010V\u001a\u00020$*\u000202H\u0007\u001a\f\u0010W\u001a\u000200*\u000202H\u0007\u001a\u0011\u0010X\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0087\b\u001a\u0019\u0010Y\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010 \u001a\u00020$H\u0087\b\u001a\u0019\u0010Z\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010 \u001a\u00020$H\u0087\b\u001a\u0011\u0010[\u001a\u0002002\u0006\u0010%\u001a\u000200H\u0087\b\u001a\u0019\u0010\\\u001a\u0002002\u0006\u0010\u001f\u001a\u0002002\u0006\u0010 \u001a\u000200H\u0087\b\u001a\u0019\u0010]\u001a\u0002002\u0006\u0010\u001f\u001a\u0002002\u0006\u0010 \u001a\u000200H\u0087\b\"\u001f\u0010b\u001a\u00020\u0000*\u00020\u00008Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b`\u0010a\u001a\u0004\b^\u0010_\"\u001f\u0010(\u001a\u00020\u0000*\u00020\u00008Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bd\u0010a\u001a\u0004\bc\u0010_\"\u001f\u0010g\u001a\u00020\u0000*\u00020\u00008Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bf\u0010a\u001a\u0004\be\u0010_\"\u001f\u0010b\u001a\u000202*\u0002028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b`\u0010j\u001a\u0004\bh\u0010i\"\u001f\u0010(\u001a\u000202*\u0002028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bd\u0010j\u001a\u0004\bk\u0010i\"\u001f\u0010g\u001a\u000202*\u0002028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bf\u0010j\u001a\u0004\bl\u0010i\"\u001f\u0010b\u001a\u00020$*\u00020$8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b`\u0010o\u001a\u0004\bm\u0010n\"\u001e\u0010(\u001a\u00020$*\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\bd\u0010o\u001a\u0004\bp\u0010n\"\u001f\u0010b\u001a\u000200*\u0002008Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b`\u0010s\u001a\u0004\bq\u0010r\"\u001e\u0010(\u001a\u00020$*\u0002008FX\u0087\u0004¢\u0006\f\u0012\u0004\bd\u0010s\u001a\u0004\bt\u0010u¨\u0006v"}, m12616d2 = {"", "x", "M0", IAdInterListener.AdReqParam.WIDTH, "S0", "k", "g", "o", "y", CampaignEx.JSON_KEY_AD_Q, "O0", "U0", "m", "i", "s", "a0", "Q0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "C", "base", "g0", "c0", "i0", "k0", "e0", "u", ExifInterface.LONGITUDE_EAST, "W0", "E0", "c", "K0", "a", "b", "q0", "m0", "A0", "", "n", "B0", "divisor", "sign", "Y0", "Z0", "y0", "u0", "to", "w0", "G0", "", "I0", "", "N0", "T0", C7304t.f25048d, "h", "p", "r", "P0", UMCommonContent.f37777aG, "V0", "j", UMCommonContent.f37782aL, "b0", "R0", "B", "D", "h0", "d0", "j0", "l0", "f0", "v", "F", "X0", "F0", "d", "L0", "r0", "n0", "C0", "D0", "a1", "b1", "z0", "v0", "x0", "H0", "J0", "e", "s0", "o0", "f", "t0", C7202bq.f24604g, "G", "(D)D", "getAbsoluteValue$annotations", "(D)V", "absoluteValue", "O", "getSign$annotations", ExifInterface.LONGITUDE_WEST, "getUlp$annotations", "ulp", "H", "(F)F", "(F)V", "P", "X", "I", "(I)I", "(I)V", "Q", "J", "(J)J", "(J)V", "R", "(J)I", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/math/MathKt")
/* renamed from: kotlin.math.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14376d extends MathH {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: A */
    private static final double m7927A(double d) {
        return Math.exp(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: A0 */
    private static final double m7926A0(double d, double d2) {
        return Math.pow(d, d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: B */
    private static final float m7925B(float f) {
        return (float) Math.exp(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: B0 */
    private static final double m7924B0(double d, int i) {
        return Math.pow(d, i);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: C */
    private static final double m7923C(double d) {
        return Math.expm1(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: C0 */
    private static final float m7922C0(float f, float f2) {
        return (float) Math.pow(f, f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: D */
    private static final float m7921D(float f) {
        return (float) Math.expm1(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: D0 */
    private static final float m7920D0(float f, int i) {
        return (float) Math.pow(f, i);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: E */
    private static final double m7919E(double d) {
        return Math.floor(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: E0 */
    private static final double m7918E0(double d) {
        return Math.rint(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: F */
    private static final float m7917F(float f) {
        return (float) Math.floor(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: F0 */
    private static final float m7916F0(float f) {
        return (float) Math.rint(f);
    }

    /* renamed from: G */
    private static final double m7915G(double d) {
        return Math.abs(d);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: G0 */
    public static int m7914G0(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (d < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    /* renamed from: H */
    private static final float m7913H(float f) {
        return Math.abs(f);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: H0 */
    public static final int m7912H0(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }

    /* renamed from: I */
    private static final int m7911I(int i) {
        return Math.abs(i);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: I0 */
    public static long m7910I0(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }

    /* renamed from: J */
    private static final long m7909J(long j) {
        return Math.abs(j);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: J0 */
    public static final long m7908J0(float f) {
        long m7910I0;
        m7910I0 = m7910I0(f);
        return m7910I0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: K */
    public static /* synthetic */ void m7907K(double d) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: K0 */
    private static final double m7906K0(double d) {
        return Math.signum(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: L */
    public static /* synthetic */ void m7905L(float f) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: L0 */
    private static final float m7904L0(float f) {
        return Math.signum(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: M */
    public static /* synthetic */ void m7903M(int i) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: M0 */
    private static final double m7902M0(double d) {
        return Math.sin(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: N */
    public static /* synthetic */ void m7901N(long j) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: N0 */
    private static final float m7900N0(float f) {
        return (float) Math.sin(f);
    }

    /* renamed from: O */
    private static final double m7899O(double d) {
        return Math.signum(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: O0 */
    private static final double m7898O0(double d) {
        return Math.sinh(d);
    }

    /* renamed from: P */
    private static final float m7897P(float f) {
        return Math.signum(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: P0 */
    private static final float m7896P0(float f) {
        return (float) Math.sinh(f);
    }

    /* renamed from: Q */
    public static int m7895Q(int i) {
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: Q0 */
    private static final double m7894Q0(double d) {
        return Math.sqrt(d);
    }

    /* renamed from: R */
    public static int m7893R(long j) {
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: R0 */
    private static final float m7892R0(float f) {
        return (float) Math.sqrt(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: S */
    public static /* synthetic */ void m7891S(double d) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: S0 */
    private static final double m7890S0(double d) {
        return Math.tan(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: T */
    public static /* synthetic */ void m7889T(float f) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: T0 */
    private static final float m7888T0(float f) {
        return (float) Math.tan(f);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: U */
    public static /* synthetic */ void m7887U(int i) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: U0 */
    private static final double m7886U0(double d) {
        return Math.tanh(d);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: V */
    public static /* synthetic */ void m7885V(long j) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: V0 */
    private static final float m7884V0(float f) {
        return (float) Math.tanh(f);
    }

    /* renamed from: W */
    private static final double m7883W(double d) {
        return Math.ulp(d);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: W0 */
    public static final double m7882W0(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return d;
        }
        if (d > 0) {
            return Math.floor(d);
        }
        return Math.ceil(d);
    }

    /* renamed from: X */
    private static final float m7881X(float f) {
        return Math.ulp(f);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: X0 */
    public static final float m7880X0(float f) {
        double ceil;
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        if (f > 0) {
            ceil = Math.floor(f);
        } else {
            ceil = Math.ceil(f);
        }
        return (float) ceil;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: Y */
    public static /* synthetic */ void m7879Y(double d) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: Y0 */
    private static final double m7878Y0(double d, double d2) {
        return Math.copySign(d, d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: Z */
    public static /* synthetic */ void m7877Z(float f) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: Z0 */
    private static final double m7876Z0(double d, int i) {
        return Math.copySign(d, i);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: a */
    private static final double m7875a(double d, double d2) {
        return Math.IEEEremainder(d, d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: a0 */
    private static final double m7874a0(double d, double d2) {
        return Math.hypot(d, d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: a1 */
    private static final float m7873a1(float f, float f2) {
        return Math.copySign(f, f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: b */
    private static final float m7872b(float f, float f2) {
        return (float) Math.IEEEremainder(f, f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: b0 */
    private static final float m7871b0(float f, float f2) {
        return (float) Math.hypot(f, f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: b1 */
    private static final float m7870b1(float f, int i) {
        return Math.copySign(f, i);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: c */
    private static final double m7869c(double d) {
        return Math.abs(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: c0 */
    private static final double m7868c0(double d) {
        return Math.log(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: d */
    private static final float m7867d(float f) {
        return Math.abs(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: d0 */
    private static final float m7866d0(float f) {
        return (float) Math.log(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: e */
    private static final int m7865e(int i) {
        return Math.abs(i);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: e0 */
    private static final double m7864e0(double d) {
        return Math.log1p(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: f */
    private static final long m7863f(long j) {
        return Math.abs(j);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: f0 */
    private static final float m7862f0(float f) {
        return (float) Math.log1p(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: g */
    private static final double m7861g(double d) {
        return Math.acos(d);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: g0 */
    public static final double m7860g0(double d, double d2) {
        if (d2 <= Utils.DOUBLE_EPSILON || d2 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d) / Math.log(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: h */
    private static final float m7859h(float f) {
        return (float) Math.acos(f);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: h0 */
    public static final float m7858h0(float f, float f2) {
        if (f2 <= 0.0f || f2 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f) / Math.log(f2));
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: i */
    public static final double m7857i(double d) {
        double d2 = 1;
        if (d < d2) {
            return Double.NaN;
        }
        if (d > MathJVM.f41236e) {
            return Math.log(d) + MathJVM.f41232a;
        }
        Double.isNaN(d2);
        double d3 = d - d2;
        if (d3 >= MathJVM.f41235d) {
            Double.isNaN(d2);
            return Math.log(d + Math.sqrt((d * d) - d2));
        }
        double sqrt = Math.sqrt(d3);
        if (sqrt >= MathJVM.f41234c) {
            double d4 = 12;
            Double.isNaN(d4);
            sqrt -= ((sqrt * sqrt) * sqrt) / d4;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: i0 */
    private static final double m7856i0(double d) {
        return Math.log10(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: j */
    private static final float m7855j(float f) {
        return (float) m7857i(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: j0 */
    private static final float m7854j0(float f) {
        return (float) Math.log10(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: k */
    private static final double m7853k(double d) {
        return Math.asin(d);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: k0 */
    public static final double m7852k0(double d) {
        return Math.log(d) / MathJVM.f41232a;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: l */
    private static final float m7851l(float f) {
        return (float) Math.asin(f);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: l0 */
    public static final float m7850l0(float f) {
        return (float) (Math.log(f) / MathJVM.f41232a);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: m */
    public static final double m7849m(double d) {
        double d2 = MathJVM.f41235d;
        if (d < d2) {
            if (d <= (-d2)) {
                return -m7849m(-d);
            }
            if (Math.abs(d) >= MathJVM.f41234c) {
                double d3 = 6;
                Double.isNaN(d3);
                return d - (((d * d) * d) / d3);
            }
            return d;
        } else if (d > MathJVM.f41237f) {
            if (d > MathJVM.f41236e) {
                return Math.log(d) + MathJVM.f41232a;
            }
            double d4 = 2;
            Double.isNaN(d4);
            double d5 = d * d4;
            double d6 = 1;
            Double.isNaN(d6);
            return Math.log(d5 + (d6 / d5));
        } else {
            double d7 = 1;
            Double.isNaN(d7);
            return Math.log(d + Math.sqrt((d * d) + d7));
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: m0 */
    private static final double m7848m0(double d, double d2) {
        return Math.max(d, d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: n */
    private static final float m7847n(float f) {
        return (float) m7849m(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: n0 */
    private static final float m7846n0(float f, float f2) {
        return Math.max(f, f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: o */
    private static final double m7845o(double d) {
        return Math.atan(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: o0 */
    private static final int m7844o0(int i, int i2) {
        return Math.max(i, i2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: p */
    private static final float m7843p(float f) {
        return (float) Math.atan(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: p0 */
    private static final long m7842p0(long j, long j2) {
        return Math.max(j, j2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: q */
    private static final double m7841q(double d, double d2) {
        return Math.atan2(d, d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: q0 */
    private static final double m7840q0(double d, double d2) {
        return Math.min(d, d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: r */
    private static final float m7839r(float f, float f2) {
        return (float) Math.atan2(f, f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: r0 */
    private static final float m7838r0(float f, float f2) {
        return Math.min(f, f2);
    }

    @SinceKotlin(version = "1.2")
    /* renamed from: s */
    public static final double m7837s(double d) {
        if (Math.abs(d) < MathJVM.f41235d) {
            if (Math.abs(d) > MathJVM.f41234c) {
                double d2 = 3;
                Double.isNaN(d2);
                return d + (((d * d) * d) / d2);
            }
            return d;
        }
        double d3 = 1;
        Double.isNaN(d3);
        Double.isNaN(d3);
        double log = Math.log((d3 + d) / (d3 - d));
        double d4 = 2;
        Double.isNaN(d4);
        return log / d4;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: s0 */
    private static final int m7836s0(int i, int i2) {
        return Math.min(i, i2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: t */
    private static final float m7835t(float f) {
        return (float) m7837s(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: t0 */
    private static final long m7834t0(long j, long j2) {
        return Math.min(j, j2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: u */
    private static final double m7833u(double d) {
        return Math.ceil(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: u0 */
    private static final double m7832u0(double d) {
        return Math.nextAfter(d, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: v */
    private static final float m7831v(float f) {
        return (float) Math.ceil(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: v0 */
    private static final float m7830v0(float f) {
        return Math.nextAfter(f, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: w */
    private static final double m7829w(double d) {
        return Math.cos(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: w0 */
    private static final double m7828w0(double d, double d2) {
        return Math.nextAfter(d, d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: x */
    private static final float m7827x(float f) {
        return (float) Math.cos(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: x0 */
    private static final float m7826x0(float f, float f2) {
        return Math.nextAfter(f, f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: y */
    private static final double m7825y(double d) {
        return Math.cosh(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: y0 */
    private static final double m7824y0(double d) {
        return Math.nextUp(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: z */
    private static final float m7823z(float f) {
        return (float) Math.cosh(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: z0 */
    private static final float m7822z0(float f) {
        return Math.nextUp(f);
    }
}
