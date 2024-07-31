package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0017\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u001f\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\n\u001a\u0017\u0010\r\u001a\u00020\u0001*\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u0001*\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0017\u0010\u0010\u001a\u00020\u0001*\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0017\u0010\u0011\u001a\u00020\f*\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\f*\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00020\f*\u00020\f2\u0006\u0010\b\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\f*\u00020\f2\u0006\u0010\b\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0015\u001a\u0017\u0010\u0018\u001a\u00020\u0001*\u00020\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u0001*\u00020\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\u0001*\u00020\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019\u001a\u0017\u0010\u001c\u001a\u00020\u0017*\u00020\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010\u001e\u001a\u00020\u0017*\u00020\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001d\u001a\u001f\u0010\u001f\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\b\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001f\u0010!\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\b\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b!\u0010 \u001a\u0017\u0010#\u001a\u00020\u0001*\u00020\"H\u0087\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0017\u0010%\u001a\u00020\u0001*\u00020\"H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010$\u001a\u0017\u0010&\u001a\u00020\u0001*\u00020\"H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010$\u001a\u0017\u0010'\u001a\u00020\"*\u00020\"H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u0017\u0010)\u001a\u00020\"*\u00020\"H\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010(\u001a\u001f\u0010*\u001a\u00020\"*\u00020\"2\u0006\u0010\b\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u001f\u0010,\u001a\u00020\"*\u00020\"2\u0006\u0010\b\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, m12616d2 = {"Lkotlin/r0;", "", "g", "(I)I", "c", "k", IAdInterListener.AdReqParam.WIDTH, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "bitCount", "o", "(II)I", "s", "Lkotlin/v0;", "f", "(J)I", "b", "j", "v", "(J)J", UMCommonContent.f37777aG, "m", "(JI)J", CampaignEx.JSON_KEY_AD_Q, "Lkotlin/n0;", "e", "(B)I", "a", "i", "u", "(B)B", "y", "n", "(BI)B", "r", "Lkotlin/b1;", "h", "(S)I", "d", C7304t.f25048d, "x", "(S)S", "B", "p", "(SI)S", UMCommonContent.f37782aL, "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "UNumbersKt")
/* renamed from: kotlin.a1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UNumbers {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: A */
    private static final int m12605A(int i) {
        return UInt.m7678h(Integer.lowestOneBit(i));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: B */
    private static final short m12604B(short s) {
        return UShort.m12528h((short) Integer.lowestOneBit(s & UShort.f40820c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: a */
    private static final int m12603a(byte b) {
        return Integer.numberOfLeadingZeros(b & UByte.f41242c) - 24;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: b */
    private static final int m12602b(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: c */
    private static final int m12601c(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: d */
    private static final int m12600d(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.f40820c) - 16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: e */
    private static final int m12599e(byte b) {
        return Integer.bitCount(UInt.m7678h(b & UByte.f41242c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: f */
    private static final int m12598f(long j) {
        return Long.bitCount(j);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: g */
    private static final int m12597g(int i) {
        return Integer.bitCount(i);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: h */
    private static final int m12596h(short s) {
        return Integer.bitCount(UInt.m7678h(s & UShort.f40820c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: i */
    private static final int m12595i(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: j */
    private static final int m12594j(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: k */
    private static final int m12593k(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: l */
    private static final int m12592l(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: m */
    private static final long m12591m(long j, int i) {
        return ULong.m5889h(Long.rotateLeft(j, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: n */
    private static final byte m12590n(byte b, int i) {
        return UByte.m7776h(Numbers.m5779Z0(b, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: o */
    private static final int m12589o(int i, int i2) {
        return UInt.m7678h(Integer.rotateLeft(i, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: p */
    private static final short m12588p(short s, int i) {
        return UShort.m12528h(Numbers.m5778a1(s, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: q */
    private static final long m12587q(long j, int i) {
        return ULong.m5889h(Long.rotateRight(j, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: r */
    private static final byte m12586r(byte b, int i) {
        return UByte.m7776h(Numbers.m5777b1(b, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: s */
    private static final int m12585s(int i, int i2) {
        return UInt.m7678h(Integer.rotateRight(i, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: t */
    private static final short m12584t(short s, int i) {
        return UShort.m12528h(Numbers.m5776c1(s, i));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: u */
    private static final byte m12583u(byte b) {
        return UByte.m7776h((byte) Integer.highestOneBit(b & UByte.f41242c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: v */
    private static final long m12582v(long j) {
        return ULong.m5889h(Long.highestOneBit(j));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: w */
    private static final int m12581w(int i) {
        return UInt.m7678h(Integer.highestOneBit(i));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: x */
    private static final short m12580x(short s) {
        return UShort.m12528h((short) Integer.highestOneBit(s & UShort.f40820c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: y */
    private static final byte m12579y(byte b) {
        return UByte.m7776h((byte) Integer.lowestOneBit(b & UByte.f41242c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: z */
    private static final long m12578z(long j) {
        return ULong.m5889h(Long.lowestOneBit(j));
    }
}
