package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Numbers.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\r\u0010\f\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\r\u0010\r\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\r\u0010\u000e\u001a\u00020\n*\u00020\nH\u0087\b\u001a\r\u0010\u000f\u001a\u00020\n*\u00020\nH\u0087\b\u001a\u0014\u0010\u0010\u001a\u00020\n*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0011\u001a\u00020\n*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u00a8\u0006\u0012"}, d2 = {"", "", "V0", "T0", "X0", "d1", "f1", "bitCount", "Z0", "b1", "", "W0", "U0", "Y0", "e1", "g1", "a1", "c1", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/NumbersKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class y extends x {
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int T0(byte b4) {
        return Integer.numberOfLeadingZeros(b4 & 255) - 24;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int U0(short s3) {
        return Integer.numberOfLeadingZeros(s3 & 65535) - 16;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int V0(byte b4) {
        return Integer.bitCount(b4 & 255);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int W0(short s3) {
        return Integer.bitCount(s3 & 65535);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int X0(byte b4) {
        return Integer.numberOfTrailingZeros(b4 | 256);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int Y0(short s3) {
        return Integer.numberOfTrailingZeros(s3 | 65536);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte Z0(byte b4, int i4) {
        int i5 = i4 & 7;
        return (byte) (((b4 & 255) >>> (8 - i5)) | (b4 << i5));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final short a1(short s3, int i4) {
        int i5 = i4 & 15;
        return (short) (((s3 & 65535) >>> (16 - i5)) | (s3 << i5));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte b1(byte b4, int i4) {
        int i5 = i4 & 7;
        return (byte) (((b4 & 255) >>> i5) | (b4 << (8 - i5)));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final short c1(short s3, int i4) {
        int i5 = i4 & 15;
        return (short) (((s3 & 65535) >>> i5) | (s3 << (16 - i5)));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final byte d1(byte b4) {
        return (byte) Integer.highestOneBit(b4 & 255);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final short e1(short s3) {
        return (short) Integer.highestOneBit(s3 & 65535);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final byte f1(byte b4) {
        return (byte) Integer.lowestOneBit(b4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final short g1(short s3) {
        return (short) Integer.lowestOneBit(s3);
    }
}
