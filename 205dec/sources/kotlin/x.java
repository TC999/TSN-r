package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: NumbersJVM.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0010\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\n\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u000e\u001a\u00020\u0000*\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0003H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00122\u0006\u0010\r\u001a\u00020\u000fH\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u000fH\u0087\b\u001a\u0015\u0010\u001a\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010\u001b\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0087\b\u001a\r\u0010\u001c\u001a\u00020\u000f*\u00020\tH\u0087\b\u001a\r\u0010\u001d\u001a\u00020\u000f*\u00020\tH\u0087\b\u001a\r\u0010\u001e\u001a\u00020\u000f*\u00020\tH\u0087\b\u001a\r\u0010\u001f\u001a\u00020\t*\u00020\tH\u0087\b\u001a\r\u0010 \u001a\u00020\t*\u00020\tH\u0087\b\u001a\u0015\u0010!\u001a\u00020\t*\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010\"\u001a\u00020\t*\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000fH\u0087\b\u00a8\u0006#"}, d2 = {"", "", "F0", "", "G0", "D0", "E0", "B0", "C0", "", "Q0", "S0", "Lkotlin/Double$Companion;", "bits", "z0", "", "P0", "R0", "Lkotlin/Float$Companion;", "A0", "v0", "t0", "x0", "L0", "N0", "bitCount", "H0", "J0", "w0", "u0", "y0", "M0", "O0", "I0", "K0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/NumbersKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class x extends w {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float A0(kotlin.jvm.internal.y yVar, int i4) {
        kotlin.jvm.internal.f0.p(yVar, "<this>");
        return Float.intBitsToFloat(i4);
    }

    @InlineOnly
    private static final boolean B0(double d4) {
        return (Double.isInfinite(d4) || Double.isNaN(d4)) ? false : true;
    }

    @InlineOnly
    private static final boolean C0(float f4) {
        return (Float.isInfinite(f4) || Float.isNaN(f4)) ? false : true;
    }

    @InlineOnly
    private static final boolean D0(double d4) {
        return Double.isInfinite(d4);
    }

    @InlineOnly
    private static final boolean E0(float f4) {
        return Float.isInfinite(f4);
    }

    @InlineOnly
    private static final boolean F0(double d4) {
        return Double.isNaN(d4);
    }

    @InlineOnly
    private static final boolean G0(float f4) {
        return Float.isNaN(f4);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int H0(int i4, int i5) {
        return Integer.rotateLeft(i4, i5);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long I0(long j4, int i4) {
        return Long.rotateLeft(j4, i4);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int J0(int i4, int i5) {
        return Integer.rotateRight(i4, i5);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long K0(long j4, int i4) {
        return Long.rotateRight(j4, i4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int L0(int i4) {
        return Integer.highestOneBit(i4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long M0(long j4) {
        return Long.highestOneBit(j4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int N0(int i4) {
        return Integer.lowestOneBit(i4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long O0(long j4) {
        return Long.lowestOneBit(j4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int P0(float f4) {
        return Float.floatToIntBits(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long Q0(double d4) {
        return Double.doubleToLongBits(d4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int R0(float f4) {
        return Float.floatToRawIntBits(f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long S0(double d4) {
        return Double.doubleToRawLongBits(d4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int t0(int i4) {
        return Integer.numberOfLeadingZeros(i4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int u0(long j4) {
        return Long.numberOfLeadingZeros(j4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int v0(int i4) {
        return Integer.bitCount(i4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int w0(long j4) {
        return Long.bitCount(j4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int x0(int i4) {
        return Integer.numberOfTrailingZeros(i4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int y0(long j4) {
        return Long.numberOfTrailingZeros(j4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double z0(kotlin.jvm.internal.v vVar, long j4) {
        kotlin.jvm.internal.f0.p(vVar, "<this>");
        return Double.longBitsToDouble(j4);
    }
}
