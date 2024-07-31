package kotlin.text;

import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001e\u0010\n\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001e\u0010\r\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0016\u0010\u000f\u001a\u00020\u0000*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0006*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u00020\t*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0016\u0010\u001b\u001a\u00020\f*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001e\u0010\u001d\u001a\u00020\f*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0000*\u00020\u0003H\u0007ø\u0001\u0000\u001a\u0019\u0010 \u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0011\u0010!\u001a\u0004\u0018\u00010\u0006*\u00020\u0003H\u0007ø\u0001\u0000\u001a\u0019\u0010\"\u001a\u0004\u0018\u00010\u0006*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0011\u0010#\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007ø\u0001\u0000\u001a\u0019\u0010$\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0011\u0010%\u001a\u0004\u0018\u00010\f*\u00020\u0003H\u0007ø\u0001\u0000\u001a\u0019\u0010&\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, m12616d2 = {"Lkotlin/n0;", "", "radix", "", "b", "(BI)Ljava/lang/String;", "Lkotlin/b1;", "d", "(SI)Ljava/lang/String;", "Lkotlin/r0;", "c", "(II)Ljava/lang/String;", "Lkotlin/v0;", "a", "(JI)Ljava/lang/String;", "e", "(Ljava/lang/String;)B", "f", "(Ljava/lang/String;I)B", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/String;)S", "r", "(Ljava/lang/String;I)S", "i", "(Ljava/lang/String;)I", "j", "(Ljava/lang/String;I)I", "m", "(Ljava/lang/String;)J", "n", "(Ljava/lang/String;I)J", "g", "h", "s", UMCommonContent.f37782aL, "k", C7304t.f25048d, "o", "p", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "UStringsKt")
/* renamed from: kotlin.text.d0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UStrings {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: a */
    public static final String m6850a(long j, int i) {
        int m6893a;
        m6893a = CharJVM.m6893a(i);
        return UnsignedUtils.m8552l(j, m6893a);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: b */
    public static final String m6849b(byte b, int i) {
        int m6893a;
        int i2 = b & UByte.f41242c;
        m6893a = CharJVM.m6893a(i);
        String num = Integer.toString(i2, m6893a);
        C14342f0.m8185o(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: c */
    public static final String m6848c(int i, int i2) {
        int m6893a;
        m6893a = CharJVM.m6893a(i2);
        String l = Long.toString(i & 4294967295L, m6893a);
        C14342f0.m8185o(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: d */
    public static final String m6847d(short s, int i) {
        int m6893a;
        int i2 = s & UShort.f40820c;
        m6893a = CharJVM.m6893a(i);
        String num = Integer.toString(i2, m6893a);
        C14342f0.m8185o(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: e */
    public static final byte m6846e(@NotNull String toUByte) {
        C14342f0.m8184p(toUByte, "$this$toUByte");
        UByte m6844g = m6844g(toUByte);
        if (m6844g != null) {
            return m6844g.m7780e0();
        }
        StringNumberConversions.m6633U0(toUByte);
        throw new ExceptionsH();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: f */
    public static final byte m6845f(@NotNull String toUByte, int i) {
        C14342f0.m8184p(toUByte, "$this$toUByte");
        UByte m6843h = m6843h(toUByte, i);
        if (m6843h != null) {
            return m6843h.m7780e0();
        }
        StringNumberConversions.m6633U0(toUByte);
        throw new ExceptionsH();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @Nullable
    /* renamed from: g */
    public static final UByte m6844g(@NotNull String toUByteOrNull) {
        C14342f0.m8184p(toUByteOrNull, "$this$toUByteOrNull");
        return m6843h(toUByteOrNull, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @Nullable
    /* renamed from: h */
    public static final UByte m6843h(@NotNull String toUByteOrNull, int i) {
        C14342f0.m8184p(toUByteOrNull, "$this$toUByteOrNull");
        UInt m6839l = m6839l(toUByteOrNull, i);
        if (m6839l != null) {
            int m7679g0 = m6839l.m7679g0();
            if (UnsignedUtils.m8561c(m7679g0, UInt.m7678h(255)) > 0) {
                return null;
            }
            return UByte.m7787b(UByte.m7776h((byte) m7679g0));
        }
        return null;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: i */
    public static final int m6842i(@NotNull String toUInt) {
        C14342f0.m8184p(toUInt, "$this$toUInt");
        UInt m6840k = m6840k(toUInt);
        if (m6840k != null) {
            return m6840k.m7679g0();
        }
        StringNumberConversions.m6633U0(toUInt);
        throw new ExceptionsH();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: j */
    public static final int m6841j(@NotNull String toUInt, int i) {
        C14342f0.m8184p(toUInt, "$this$toUInt");
        UInt m6839l = m6839l(toUInt, i);
        if (m6839l != null) {
            return m6839l.m7679g0();
        }
        StringNumberConversions.m6633U0(toUInt);
        throw new ExceptionsH();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @Nullable
    /* renamed from: k */
    public static final UInt m6840k(@NotNull String toUIntOrNull) {
        C14342f0.m8184p(toUIntOrNull, "$this$toUIntOrNull");
        return m6839l(toUIntOrNull, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @Nullable
    /* renamed from: l */
    public static final UInt m6839l(@NotNull String toUIntOrNull, int i) {
        C14342f0.m8184p(toUIntOrNull, "$this$toUIntOrNull");
        CharJVM.m6893a(i);
        int length = toUIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = toUIntOrNull.charAt(0);
        int i3 = 1;
        if (C14342f0.m8180t(charAt, 48) >= 0) {
            i3 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int m7678h = UInt.m7678h(i);
        int i4 = 119304647;
        while (i3 < length) {
            int m6892b = CharJVM.m6892b(toUIntOrNull.charAt(i3), i);
            if (m6892b < 0) {
                return null;
            }
            if (UnsignedUtils.m8561c(i2, i4) > 0) {
                if (i4 == 119304647) {
                    i4 = UnsignedUtils.m8560d(-1, m7678h);
                    if (UnsignedUtils.m8561c(i2, i4) > 0) {
                    }
                }
                return null;
            }
            int m7678h2 = UInt.m7678h(i2 * m7678h);
            int m7678h3 = UInt.m7678h(UInt.m7678h(m6892b) + m7678h2);
            if (UnsignedUtils.m8561c(m7678h3, m7678h2) < 0) {
                return null;
            }
            i3++;
            i2 = m7678h3;
        }
        return UInt.m7690b(i2);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: m */
    public static final long m6838m(@NotNull String toULong) {
        C14342f0.m8184p(toULong, "$this$toULong");
        ULong m6836o = m6836o(toULong);
        if (m6836o != null) {
            return m6836o.m5890g0();
        }
        StringNumberConversions.m6633U0(toULong);
        throw new ExceptionsH();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: n */
    public static final long m6837n(@NotNull String toULong, int i) {
        C14342f0.m8184p(toULong, "$this$toULong");
        ULong m6835p = m6835p(toULong, i);
        if (m6835p != null) {
            return m6835p.m5890g0();
        }
        StringNumberConversions.m6633U0(toULong);
        throw new ExceptionsH();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @Nullable
    /* renamed from: o */
    public static final ULong m6836o(@NotNull String toULongOrNull) {
        C14342f0.m8184p(toULongOrNull, "$this$toULongOrNull");
        return m6835p(toULongOrNull, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @Nullable
    /* renamed from: p */
    public static final ULong m6835p(@NotNull String toULongOrNull, int i) {
        int m6892b;
        C14342f0.m8184p(toULongOrNull, "$this$toULongOrNull");
        CharJVM.m6893a(i);
        int length = toULongOrNull.length();
        if (length == 0) {
            return null;
        }
        long j = -1;
        int i2 = 0;
        char charAt = toULongOrNull.charAt(0);
        if (C14342f0.m8180t(charAt, 48) < 0) {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i2 = 1;
        }
        long m5889h = ULong.m5889h(i);
        long j2 = 0;
        long j3 = 512409557603043100L;
        while (i2 < length) {
            if (CharJVM.m6892b(toULongOrNull.charAt(i2), i) < 0) {
                return null;
            }
            if (UnsignedUtils.m8557g(j2, j3) > 0) {
                if (j3 == 512409557603043100L) {
                    j3 = UnsignedUtils.m8556h(j, m5889h);
                    if (UnsignedUtils.m8557g(j2, j3) > 0) {
                    }
                }
                return null;
            }
            long m5889h2 = ULong.m5889h(j2 * m5889h);
            long m5889h3 = ULong.m5889h(ULong.m5889h(UInt.m7678h(m6892b) & 4294967295L) + m5889h2);
            if (UnsignedUtils.m8557g(m5889h3, m5889h2) < 0) {
                return null;
            }
            i2++;
            j2 = m5889h3;
            j = -1;
        }
        return ULong.m5901b(j2);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: q */
    public static final short m6834q(@NotNull String toUShort) {
        C14342f0.m8184p(toUShort, "$this$toUShort");
        UShort m6832s = m6832s(toUShort);
        if (m6832s != null) {
            return m6832s.m12532e0();
        }
        StringNumberConversions.m6633U0(toUShort);
        throw new ExceptionsH();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: r */
    public static final short m6833r(@NotNull String toUShort, int i) {
        C14342f0.m8184p(toUShort, "$this$toUShort");
        UShort m6831t = m6831t(toUShort, i);
        if (m6831t != null) {
            return m6831t.m12532e0();
        }
        StringNumberConversions.m6633U0(toUShort);
        throw new ExceptionsH();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @Nullable
    /* renamed from: s */
    public static final UShort m6832s(@NotNull String toUShortOrNull) {
        C14342f0.m8184p(toUShortOrNull, "$this$toUShortOrNull");
        return m6831t(toUShortOrNull, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @Nullable
    /* renamed from: t */
    public static final UShort m6831t(@NotNull String toUShortOrNull, int i) {
        C14342f0.m8184p(toUShortOrNull, "$this$toUShortOrNull");
        UInt m6839l = m6839l(toUShortOrNull, i);
        if (m6839l != null) {
            int m7679g0 = m6839l.m7679g0();
            if (UnsignedUtils.m8561c(m7679g0, UInt.m7678h(65535)) > 0) {
                return null;
            }
            return UShort.m12539b(UShort.m12528h((short) m7679g0));
        }
        return null;
    }
}
