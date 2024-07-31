package kotlin.comparisons;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _UComparisons.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\"\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\"\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a&\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0015\u001a\u00020\u0014\"\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\n\u0010\u0015\u001a\u00020\u0018\"\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a&\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\n\u0010\u0015\u001a\u00020\u001b\"\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a&\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\n\u0010\u0015\u001a\u00020\u001e\"\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\"\u0010!\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0003\u001a\"\u0010\"\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0006\u001a\"\u0010#\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010\t\u001a\"\u0010$\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010\u000b\u001a+\u0010%\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\r\u001a+\u0010&\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000f\u001a+\u0010'\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0011\u001a+\u0010(\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0013\u001a&\u0010)\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0015\u001a\u00020\u0014\"\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u0017\u001a&\u0010*\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\n\u0010\u0015\u001a\u00020\u0018\"\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010\u001a\u001a&\u0010+\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\n\u0010\u0015\u001a\u00020\u001b\"\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001d\u001a&\u0010,\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\n\u0010\u0015\u001a\u00020\u001e\"\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, m12616d2 = {"Lkotlin/r0;", "a", "b", "(II)I", "Lkotlin/v0;", "j", "(JJ)J", "Lkotlin/n0;", "c", "(BB)B", "Lkotlin/b1;", "(SS)S", "g", "(III)I", "k", "(JJJ)J", "i", "(BBB)B", "f", "(SSS)S", "Lkotlin/s0;", AdnName.OTHER, "d", "(I[I)I", "Lkotlin/w0;", "e", "(J[J)J", "Lkotlin/o0;", "h", "(B[B)B", "Lkotlin/c1;", C7304t.f25048d, "(S[S)S", "n", "v", "o", "m", "s", IAdInterListener.AdReqParam.WIDTH, "u", "r", "p", CampaignEx.JSON_KEY_AD_Q, UMCommonContent.f37782aL, "x", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/comparisons/UComparisonsKt")
/* renamed from: kotlin.comparisons.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14259i {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: a */
    public static final short m8729a(short s, short s2) {
        return C14342f0.m8180t(s & UShort.f40820c, 65535 & s2) >= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: b */
    public static int m8728b(int i, int i2) {
        return UnsignedUtils.m8561c(i, i2) >= 0 ? i : i2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: c */
    public static final byte m8727c(byte b, byte b2) {
        return C14342f0.m8180t(b & UByte.f41242c, b2 & UByte.f41242c) >= 0 ? b : b2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    /* renamed from: d */
    public static final int m8726d(int i, @NotNull int... other) {
        C14342f0.m8184p(other, "other");
        for (int i2 : other) {
            i = m8728b(i, i2);
        }
        return i;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    /* renamed from: e */
    public static final long m8725e(long j, @NotNull long... other) {
        C14342f0.m8184p(other, "other");
        for (long j2 : other) {
            j = m8720j(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: f */
    private static final short m8724f(short s, short s2, short s3) {
        return m8729a(s, m8729a(s2, s3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: g */
    private static final int m8723g(int i, int i2, int i3) {
        int m8728b;
        int m8728b2;
        m8728b = m8728b(i2, i3);
        m8728b2 = m8728b(i, m8728b);
        return m8728b2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    /* renamed from: h */
    public static final byte m8722h(byte b, @NotNull byte... other) {
        C14342f0.m8184p(other, "other");
        for (byte b2 : other) {
            b = m8727c(b, b2);
        }
        return b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: i */
    private static final byte m8721i(byte b, byte b2, byte b3) {
        return m8727c(b, m8727c(b2, b3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: j */
    public static long m8720j(long j, long j2) {
        return UnsignedUtils.m8557g(j, j2) >= 0 ? j : j2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: k */
    private static final long m8719k(long j, long j2, long j3) {
        long m8720j;
        long m8720j2;
        m8720j = m8720j(j2, j3);
        m8720j2 = m8720j(j, m8720j);
        return m8720j2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    /* renamed from: l */
    public static final short m8718l(short s, @NotNull short... other) {
        C14342f0.m8184p(other, "other");
        for (short s2 : other) {
            s = m8729a(s, s2);
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: m */
    public static final short m8717m(short s, short s2) {
        return C14342f0.m8180t(s & UShort.f40820c, 65535 & s2) <= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: n */
    public static int m8716n(int i, int i2) {
        return UnsignedUtils.m8561c(i, i2) <= 0 ? i : i2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: o */
    public static final byte m8715o(byte b, byte b2) {
        return C14342f0.m8180t(b & UByte.f41242c, b2 & UByte.f41242c) <= 0 ? b : b2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    /* renamed from: p */
    public static final int m8714p(int i, @NotNull int... other) {
        C14342f0.m8184p(other, "other");
        for (int i2 : other) {
            i = m8716n(i, i2);
        }
        return i;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    /* renamed from: q */
    public static final long m8713q(long j, @NotNull long... other) {
        C14342f0.m8184p(other, "other");
        for (long j2 : other) {
            j = m8708v(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: r */
    private static final short m8712r(short s, short s2, short s3) {
        return m8717m(s, m8717m(s2, s3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: s */
    private static final int m8711s(int i, int i2, int i3) {
        int m8716n;
        int m8716n2;
        m8716n = m8716n(i2, i3);
        m8716n2 = m8716n(i, m8716n);
        return m8716n2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    /* renamed from: t */
    public static final byte m8710t(byte b, @NotNull byte... other) {
        C14342f0.m8184p(other, "other");
        for (byte b2 : other) {
            b = m8715o(b, b2);
        }
        return b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: u */
    private static final byte m8709u(byte b, byte b2, byte b3) {
        return m8715o(b, m8715o(b2, b3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: v */
    public static long m8708v(long j, long j2) {
        return UnsignedUtils.m8557g(j, j2) <= 0 ? j : j2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: w */
    private static final long m8707w(long j, long j2, long j3) {
        long m8708v;
        long m8708v2;
        m8708v = m8708v(j2, j3);
        m8708v2 = m8708v(j, m8708v);
        return m8708v2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Unsigned
    /* renamed from: x */
    public static final short m8706x(short s, @NotNull short... other) {
        C14342f0.m8184p(other, "other");
        for (short s2 : other) {
            s = m8717m(s, s2);
        }
        return s;
    }
}
