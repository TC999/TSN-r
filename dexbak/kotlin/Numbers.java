package kotlin;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.internal.InlineOnly;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\r\u0010\f\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\r\u0010\r\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\r\u0010\u000e\u001a\u00020\n*\u00020\nH\u0087\b\u001a\r\u0010\u000f\u001a\u00020\n*\u00020\nH\u0087\b\u001a\u0014\u0010\u0010\u001a\u00020\n*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0011\u001a\u00020\n*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0001H\u0007¨\u0006\u0012"}, m12616d2 = {"", "", "V0", "T0", "X0", "d1", "f1", "bitCount", "Z0", "b1", "", "W0", "U0", "Y0", "e1", "g1", "a1", "c1", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/NumbersKt")
/* renamed from: kotlin.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class Numbers extends NumbersJVM {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: T0 */
    private static final int m5785T0(byte b) {
        return Integer.numberOfLeadingZeros(b & UByte.f41242c) - 24;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: U0 */
    private static final int m5784U0(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.f40820c) - 16;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: V0 */
    private static final int m5783V0(byte b) {
        return Integer.bitCount(b & UByte.f41242c);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: W0 */
    private static final int m5782W0(short s) {
        return Integer.bitCount(s & UShort.f40820c);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: X0 */
    private static final int m5781X0(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: Y0 */
    private static final int m5780Y0(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    /* renamed from: Z0 */
    public static final byte m5779Z0(byte b, int i) {
        int i2 = i & 7;
        return (byte) (((b & 255) >>> (8 - i2)) | (b << i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    /* renamed from: a1 */
    public static final short m5778a1(short s, int i) {
        int i2 = i & 15;
        return (short) (((s & 65535) >>> (16 - i2)) | (s << i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    /* renamed from: b1 */
    public static final byte m5777b1(byte b, int i) {
        int i2 = i & 7;
        return (byte) (((b & 255) >>> i2) | (b << (8 - i2)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    /* renamed from: c1 */
    public static final short m5776c1(short s, int i) {
        int i2 = i & 15;
        return (short) (((s & 65535) >>> i2) | (s << (16 - i2)));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: d1 */
    private static final byte m5775d1(byte b) {
        return (byte) Integer.highestOneBit(b & UByte.f41242c);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: e1 */
    private static final short m5774e1(short s) {
        return (short) Integer.highestOneBit(s & UShort.f40820c);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: f1 */
    private static final byte m5773f1(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: g1 */
    private static final short m5772g1(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
