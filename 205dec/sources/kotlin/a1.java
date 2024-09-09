package kotlin;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UNumbers.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0003\u001a\u0017\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\u0003\u001a\u001f\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\n\u001a\u0017\u0010\r\u001a\u00020\u0001*\u00020\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u0001*\u00020\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u000e\u001a\u0017\u0010\u0010\u001a\u00020\u0001*\u00020\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000e\u001a\u0017\u0010\u0011\u001a\u00020\f*\u00020\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\f*\u00020\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00020\f*\u00020\f2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\f*\u00020\f2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0015\u001a\u0017\u0010\u0018\u001a\u00020\u0001*\u00020\u0017H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u0001*\u00020\u0017H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\u0001*\u00020\u0017H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0019\u001a\u0017\u0010\u001c\u001a\u00020\u0017*\u00020\u0017H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010\u001e\u001a\u00020\u0017*\u00020\u0017H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001d\u001a\u001f\u0010\u001f\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 \u001a\u001f\u0010!\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010 \u001a\u0017\u0010#\u001a\u00020\u0001*\u00020\"H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\u0017\u0010%\u001a\u00020\u0001*\u00020\"H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010$\u001a\u0017\u0010&\u001a\u00020\u0001*\u00020\"H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010$\u001a\u0017\u0010'\u001a\u00020\"*\u00020\"H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(\u001a\u0017\u0010)\u001a\u00020\"*\u00020\"H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010(\u001a\u001f\u0010*\u001a\u00020\"*\u00020\"2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+\u001a\u001f\u0010,\u001a\u00020\"*\u00020\"2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010+\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lkotlin/r0;", "", "g", "(I)I", "c", "k", "w", "A", "bitCount", "o", "(II)I", "s", "Lkotlin/v0;", "f", "(J)I", "b", "j", "v", "(J)J", "z", "m", "(JI)J", CampaignEx.JSON_KEY_AD_Q, "Lkotlin/n0;", "e", "(B)I", "a", "i", "u", "(B)B", "y", "n", "(BI)B", "r", "Lkotlin/b1;", "h", "(S)I", "d", "l", "x", "(S)S", "B", "p", "(SI)S", "t", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "UNumbersKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a1 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int A(int i4) {
        return r0.i(Integer.lowestOneBit(i4));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final short B(short s3) {
        return b1.i((short) Integer.lowestOneBit(s3 & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int a(byte b4) {
        return Integer.numberOfLeadingZeros(b4 & 255) - 24;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int b(long j4) {
        return Long.numberOfLeadingZeros(j4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int c(int i4) {
        return Integer.numberOfLeadingZeros(i4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int d(short s3) {
        return Integer.numberOfLeadingZeros(s3 & 65535) - 16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int e(byte b4) {
        return Integer.bitCount(r0.i(b4 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int f(long j4) {
        return Long.bitCount(j4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int g(int i4) {
        return Integer.bitCount(i4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int h(short s3) {
        return Integer.bitCount(r0.i(s3 & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int i(byte b4) {
        return Integer.numberOfTrailingZeros(b4 | 256);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int j(long j4) {
        return Long.numberOfTrailingZeros(j4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int k(int i4) {
        return Integer.numberOfTrailingZeros(i4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int l(short s3) {
        return Integer.numberOfTrailingZeros(s3 | 65536);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long m(long j4, int i4) {
        return v0.i(Long.rotateLeft(j4, i4));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte n(byte b4, int i4) {
        return n0.i(y.Z0(b4, i4));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int o(int i4, int i5) {
        return r0.i(Integer.rotateLeft(i4, i5));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short p(short s3, int i4) {
        return b1.i(y.a1(s3, i4));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long q(long j4, int i4) {
        return v0.i(Long.rotateRight(j4, i4));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte r(byte b4, int i4) {
        return n0.i(y.b1(b4, i4));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int s(int i4, int i5) {
        return r0.i(Integer.rotateRight(i4, i5));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short t(short s3, int i4) {
        return b1.i(y.c1(s3, i4));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final byte u(byte b4) {
        return n0.i((byte) Integer.highestOneBit(b4 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long v(long j4) {
        return v0.i(Long.highestOneBit(j4));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int w(int i4) {
        return r0.i(Integer.highestOneBit(i4));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final short x(short s3) {
        return b1.i((short) Integer.highestOneBit(s3 & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final byte y(byte b4) {
        return n0.i((byte) Integer.lowestOneBit(b4 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long z(long j4) {
        return v0.i(Long.lowestOneBit(j4));
    }
}
