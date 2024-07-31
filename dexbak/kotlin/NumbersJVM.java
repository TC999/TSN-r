package kotlin;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14363v;
import kotlin.jvm.internal.C14369y;

@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0010\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\n\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u000e\u001a\u00020\u0000*\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0003H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00122\u0006\u0010\r\u001a\u00020\u000fH\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\u0015\u0010\u001a\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010\u001b\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0087\b\u001a\r\u0010\u001c\u001a\u00020\u000f*\u00020\tH\u0087\b\u001a\r\u0010\u001d\u001a\u00020\u000f*\u00020\tH\u0087\b\u001a\r\u0010\u001e\u001a\u00020\u000f*\u00020\tH\u0087\b\u001a\r\u0010\u001f\u001a\u00020\t*\u00020\tH\u0087\b\u001a\r\u0010 \u001a\u00020\t*\u00020\tH\u0087\b\u001a\u0015\u0010!\u001a\u00020\t*\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010\"\u001a\u00020\t*\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000fH\u0087\b¨\u0006#"}, m12616d2 = {"", "", "F0", "", "G0", "D0", "E0", "B0", "C0", "", "Q0", "S0", "Lkotlin/Double$Companion;", "bits", "z0", "", "P0", "R0", "Lkotlin/Float$Companion;", "A0", "v0", "t0", "x0", "L0", "N0", "bitCount", "H0", "J0", "w0", "u0", "y0", "M0", "O0", "I0", "K0", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/NumbersKt")
/* renamed from: kotlin.x */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class NumbersJVM extends FloorDivMod {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: A0 */
    private static final float m5813A0(C14369y c14369y, int i) {
        return Float.intBitsToFloat(i);
    }

    @InlineOnly
    /* renamed from: B0 */
    private static final boolean m5812B0(double d) {
        return (Double.isInfinite(d) || Double.isNaN(d)) ? false : true;
    }

    @InlineOnly
    /* renamed from: C0 */
    private static final boolean m5811C0(float f) {
        return (Float.isInfinite(f) || Float.isNaN(f)) ? false : true;
    }

    @InlineOnly
    /* renamed from: D0 */
    private static final boolean m5810D0(double d) {
        return Double.isInfinite(d);
    }

    @InlineOnly
    /* renamed from: E0 */
    private static final boolean m5809E0(float f) {
        return Float.isInfinite(f);
    }

    @InlineOnly
    /* renamed from: F0 */
    private static final boolean m5808F0(double d) {
        return Double.isNaN(d);
    }

    @InlineOnly
    /* renamed from: G0 */
    private static final boolean m5807G0(float f) {
        return Float.isNaN(f);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: H0 */
    private static final int m5806H0(int i, int i2) {
        return Integer.rotateLeft(i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: I0 */
    private static final long m5805I0(long j, int i) {
        return Long.rotateLeft(j, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: J0 */
    private static final int m5804J0(int i, int i2) {
        return Integer.rotateRight(i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: K0 */
    private static final long m5803K0(long j, int i) {
        return Long.rotateRight(j, i);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: L0 */
    private static final int m5802L0(int i) {
        return Integer.highestOneBit(i);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: M0 */
    private static final long m5801M0(long j) {
        return Long.highestOneBit(j);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: N0 */
    private static final int m5800N0(int i) {
        return Integer.lowestOneBit(i);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: O0 */
    private static final long m5799O0(long j) {
        return Long.lowestOneBit(j);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: P0 */
    private static final int m5798P0(float f) {
        return Float.floatToIntBits(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: Q0 */
    private static final long m5797Q0(double d) {
        return Double.doubleToLongBits(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: R0 */
    private static final int m5796R0(float f) {
        return Float.floatToRawIntBits(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: S0 */
    private static final long m5795S0(double d) {
        return Double.doubleToRawLongBits(d);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: t0 */
    private static final int m5794t0(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: u0 */
    private static final int m5793u0(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: v0 */
    private static final int m5792v0(int i) {
        return Integer.bitCount(i);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: w0 */
    private static final int m5791w0(long j) {
        return Long.bitCount(j);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: x0 */
    private static final int m5790x0(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: y0 */
    private static final int m5789y0(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: z0 */
    private static final double m5788z0(C14363v c14363v, long j) {
        return Double.longBitsToDouble(j);
    }
}
