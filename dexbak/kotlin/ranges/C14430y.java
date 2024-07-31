package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.random.Random;
import kotlin.random.URandom;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import okhttp3.internal.p629ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _URanges.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001e\u0010\f\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0087\bø\u0001\u0000\u001a\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0087\bø\u0001\u0000\u001a\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000\u001a\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000\u001a!\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a!\u0010\u0016\u001a\u00020\u0013*\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001f\u0010\u001a\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u00020\u0013*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u0013*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010 \u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001f\u0010#\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\"H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u0013*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\"H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010)\u001a\u00020(*\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u001f\u0010+\u001a\u00020(*\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010.\u001a\u00020-*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u001f\u00100\u001a\u00020(*\u00020\"2\u0006\u0010'\u001a\u00020\"H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\f\u00102\u001a\u00020(*\u00020(H\u0007\u001a\f\u00103\u001a\u00020-*\u00020-H\u0007\u001a\u0015\u00106\u001a\u00020(*\u00020(2\u0006\u00105\u001a\u000204H\u0087\u0004\u001a\u0015\u00108\u001a\u00020-*\u00020-2\u0006\u00105\u001a\u000207H\u0087\u0004\u001a\u001f\u00109\u001a\u00020\u0000*\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u001f\u0010;\u001a\u00020\u0000*\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u001f\u0010=\u001a\u00020\u0004*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u001f\u0010?\u001a\u00020\u0000*\u00020\"2\u0006\u0010'\u001a\u00020\"H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001e\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u0010A\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a\u001e\u0010D\u001a\u00020\u0005*\u00020\u00052\u0006\u0010A\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a\u001e\u0010F\u001a\u00020\u0018*\u00020\u00182\u0006\u0010A\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a\u001e\u0010H\u001a\u00020\"*\u00020\"2\u0006\u0010A\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a\u001e\u0010K\u001a\u00020\u0001*\u00020\u00012\u0006\u0010J\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010C\u001a\u001e\u0010L\u001a\u00020\u0005*\u00020\u00052\u0006\u0010J\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bL\u0010E\u001a\u001e\u0010M\u001a\u00020\u0018*\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010G\u001a\u001e\u0010N\u001a\u00020\"*\u00020\"2\u0006\u0010J\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010I\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010J\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a&\u0010Q\u001a\u00020\u0005*\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a&\u0010S\u001a\u00020\u0018*\u00020\u00182\u0006\u0010A\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a&\u0010U\u001a\u00020\"*\u00020\"2\u0006\u0010A\u001a\u00020\"2\u0006\u0010J\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a$\u0010Y\u001a\u00020\u0001*\u00020\u00012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00010WH\u0007ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a$\u0010[\u001a\u00020\u0005*\u00020\u00052\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050WH\u0007ø\u0001\u0000¢\u0006\u0004\b[\u0010\\\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006]"}, m12616d2 = {"Lkotlin/ranges/t;", "Lkotlin/r0;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlin/ranges/t;)I", "Lkotlin/ranges/w;", "Lkotlin/v0;", "C", "(Lkotlin/ranges/w;)J", "Lkotlin/random/Random;", "random", "B", "(Lkotlin/ranges/t;Lkotlin/random/Random;)I", "D", "(Lkotlin/ranges/w;Lkotlin/random/Random;)J", ExifInterface.LONGITUDE_EAST, "G", "F", "H", "element", "", UMCommonContent.f37782aL, "(Lkotlin/ranges/t;Lkotlin/r0;)Z", "p", "(Lkotlin/ranges/w;Lkotlin/v0;)Z", "Lkotlin/n0;", DomainCampaignEx.LOOPBACK_VALUE, "o", "(Lkotlin/ranges/t;B)Z", "r", "(Lkotlin/ranges/w;B)Z", CampaignEx.JSON_KEY_AD_Q, "(Lkotlin/ranges/w;I)Z", "u", "(Lkotlin/ranges/t;J)Z", "Lkotlin/b1;", "s", "(Lkotlin/ranges/t;S)Z", "v", "(Lkotlin/ranges/w;S)Z", "to", "Lkotlin/ranges/r;", "y", "(BB)Lkotlin/ranges/r;", "x", "(II)Lkotlin/ranges/r;", "Lkotlin/ranges/u;", UMCommonContent.f37777aG, "(JJ)Lkotlin/ranges/u;", IAdInterListener.AdReqParam.WIDTH, "(SS)Lkotlin/ranges/r;", "I", "J", "", "step", "K", "", "L", "O", "(BB)Lkotlin/ranges/t;", "N", "(II)Lkotlin/ranges/t;", "P", "(JJ)Lkotlin/ranges/w;", "M", "(SS)Lkotlin/ranges/t;", "minimumValue", "b", "(II)I", "d", "(JJ)J", "c", "(BB)B", "a", "(SS)S", "maximumValue", "f", "h", "g", "e", "k", "(III)I", "m", "(JJJ)J", C7304t.f25048d, "(BBB)B", "j", "(SSS)S", "Lkotlin/ranges/g;", "range", "n", "(ILkotlin/ranges/g;)I", "i", "(JLkotlin/ranges/g;)J", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/ranges/URangesKt")
/* renamed from: kotlin.ranges.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14430y {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: A */
    private static final int m7425A(C14424t c14424t) {
        return m7424B(c14424t, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: B */
    public static final int m7424B(@NotNull C14424t random, @NotNull Random random2) {
        C14342f0.m8184p(random, "$this$random");
        C14342f0.m8184p(random2, "random");
        try {
            return URandom.m7635h(random2, random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: C */
    private static final long m7423C(C14428w c14428w) {
        return m7422D(c14428w, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: D */
    public static final long m7422D(@NotNull C14428w random, @NotNull Random random2) {
        C14342f0.m8184p(random, "$this$random");
        C14342f0.m8184p(random2, "random");
        try {
            return URandom.m7631l(random2, random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, Unsigned.class})
    @InlineOnly
    /* renamed from: E */
    private static final UInt m7421E(C14424t c14424t) {
        return m7420F(c14424t, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, Unsigned.class})
    @Nullable
    /* renamed from: F */
    public static final UInt m7420F(@NotNull C14424t randomOrNull, @NotNull Random random) {
        C14342f0.m8184p(randomOrNull, "$this$randomOrNull");
        C14342f0.m8184p(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.m7690b(URandom.m7635h(random, randomOrNull));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, Unsigned.class})
    @InlineOnly
    /* renamed from: G */
    private static final ULong m7419G(C14428w c14428w) {
        return m7418H(c14428w, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, Unsigned.class})
    @Nullable
    /* renamed from: H */
    public static final ULong m7418H(@NotNull C14428w randomOrNull, @NotNull Random random) {
        C14342f0.m8184p(randomOrNull, "$this$randomOrNull");
        C14342f0.m8184p(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.m5901b(URandom.m7631l(random, randomOrNull));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: I */
    public static final UIntRange m7417I(@NotNull UIntRange reversed) {
        C14342f0.m8184p(reversed, "$this$reversed");
        return UIntRange.f41312d.m7440a(reversed.m7442d(), reversed.m7443c(), -reversed.m7441e());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: J */
    public static final ULongRange m7416J(@NotNull ULongRange reversed) {
        C14342f0.m8184p(reversed, "$this$reversed");
        return ULongRange.f41322d.m7431a(reversed.m7433d(), reversed.m7434c(), -reversed.m7432e());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: K */
    public static final UIntRange m7415K(@NotNull UIntRange step, int i) {
        C14342f0.m8184p(step, "$this$step");
        C14421p.m7572a(i > 0, Integer.valueOf(i));
        UIntRange.C14422a c14422a = UIntRange.f41312d;
        int m7443c = step.m7443c();
        int m7442d = step.m7442d();
        if (step.m7441e() <= 0) {
            i = -i;
        }
        return c14422a.m7440a(m7443c, m7442d, i);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: L */
    public static final ULongRange m7414L(@NotNull ULongRange step, long j) {
        C14342f0.m8184p(step, "$this$step");
        C14421p.m7572a(j > 0, Long.valueOf(j));
        ULongRange.C14426a c14426a = ULongRange.f41322d;
        long m7434c = step.m7434c();
        long m7433d = step.m7433d();
        if (step.m7432e() <= 0) {
            j = -j;
        }
        return c14426a.m7431a(m7434c, m7433d, j);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: M */
    public static final C14424t m7413M(short s, short s2) {
        int i = s2 & UShort.f40820c;
        return C14342f0.m8180t(i, 0) <= 0 ? C14424t.f41321f.m7435a() : new C14424t(UInt.m7678h(s & UShort.f40820c), UInt.m7678h(UInt.m7678h(i) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: N */
    public static final C14424t m7412N(int i, int i2) {
        return UnsignedUtils.m8561c(i2, 0) <= 0 ? C14424t.f41321f.m7435a() : new C14424t(i, UInt.m7678h(i2 - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: O */
    public static final C14424t m7411O(byte b, byte b2) {
        int i = b2 & UByte.f41242c;
        return C14342f0.m8180t(i, 0) <= 0 ? C14424t.f41321f.m7435a() : new C14424t(UInt.m7678h(b & UByte.f41242c), UInt.m7678h(UInt.m7678h(i) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: P */
    public static final C14428w m7410P(long j, long j2) {
        return UnsignedUtils.m8557g(j2, 0L) <= 0 ? C14428w.f41331f.m7426a() : new C14428w(j, ULong.m5889h(j2 - ULong.m5889h(1 & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: a */
    public static final short m7409a(short s, short s2) {
        return C14342f0.m8180t(s & UShort.f40820c, 65535 & s2) < 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: b */
    public static final int m7408b(int i, int i2) {
        return UnsignedUtils.m8561c(i, i2) < 0 ? i2 : i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: c */
    public static final byte m7407c(byte b, byte b2) {
        return C14342f0.m8180t(b & UByte.f41242c, b2 & UByte.f41242c) < 0 ? b2 : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: d */
    public static final long m7406d(long j, long j2) {
        return UnsignedUtils.m8557g(j, j2) < 0 ? j2 : j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: e */
    public static final short m7405e(short s, short s2) {
        return C14342f0.m8180t(s & UShort.f40820c, 65535 & s2) > 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: f */
    public static final int m7404f(int i, int i2) {
        return UnsignedUtils.m8561c(i, i2) > 0 ? i2 : i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: g */
    public static final byte m7403g(byte b, byte b2) {
        return C14342f0.m8180t(b & UByte.f41242c, b2 & UByte.f41242c) > 0 ? b2 : b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: h */
    public static final long m7402h(long j, long j2) {
        return UnsignedUtils.m8557g(j, j2) > 0 ? j2 : j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: i */
    public static final long m7401i(long j, @NotNull InterfaceC14407g<ULong> range) {
        C14342f0.m8184p(range, "range");
        if (range instanceof InterfaceC14405f) {
            return ((ULong) _Ranges.m7555G(ULong.m5901b(j), (InterfaceC14405f) range)).m5890g0();
        }
        if (!range.isEmpty()) {
            return UnsignedUtils.m8557g(j, range.getStart().m5890g0()) < 0 ? range.getStart().m5890g0() : UnsignedUtils.m8557g(j, range.getEndInclusive().m5890g0()) > 0 ? range.getEndInclusive().m5890g0() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: j */
    public static final short m7400j(short s, short s2, short s3) {
        int i = s2 & UShort.f40820c;
        int i2 = s3 & UShort.f40820c;
        if (C14342f0.m8180t(i, i2) <= 0) {
            int i3 = 65535 & s;
            return C14342f0.m8180t(i3, i) < 0 ? s2 : C14342f0.m8180t(i3, i2) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m12542Z(s3) + " is less than minimum " + UShort.m12542Z(s2) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: k */
    public static final int m7399k(int i, int i2, int i3) {
        if (UnsignedUtils.m8561c(i2, i3) <= 0) {
            return UnsignedUtils.m8561c(i, i2) < 0 ? i2 : UnsignedUtils.m8561c(i, i3) > 0 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m7689b0(i3) + " is less than minimum " + UInt.m7689b0(i2) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: l */
    public static final byte m7398l(byte b, byte b2, byte b3) {
        int i = b2 & UByte.f41242c;
        int i2 = b3 & UByte.f41242c;
        if (C14342f0.m8180t(i, i2) <= 0) {
            int i3 = b & UByte.f41242c;
            return C14342f0.m8180t(i3, i) < 0 ? b2 : C14342f0.m8180t(i3, i2) > 0 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m7790Z(b3) + " is less than minimum " + UByte.m7790Z(b2) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: m */
    public static final long m7397m(long j, long j2, long j3) {
        if (UnsignedUtils.m8557g(j2, j3) <= 0) {
            return UnsignedUtils.m8557g(j, j2) < 0 ? j2 : UnsignedUtils.m8557g(j, j3) > 0 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m5900b0(j3) + " is less than minimum " + ULong.m5900b0(j2) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: n */
    public static final int m7396n(int i, @NotNull InterfaceC14407g<UInt> range) {
        C14342f0.m8184p(range, "range");
        if (range instanceof InterfaceC14405f) {
            return ((UInt) _Ranges.m7555G(UInt.m7690b(i), (InterfaceC14405f) range)).m7679g0();
        }
        if (!range.isEmpty()) {
            return UnsignedUtils.m8561c(i, range.getStart().m7679g0()) < 0 ? range.getStart().m7679g0() : UnsignedUtils.m8561c(i, range.getEndInclusive().m7679g0()) > 0 ? range.getEndInclusive().m7679g0() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: o */
    public static final boolean m7395o(@NotNull C14424t contains, byte b) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.m7438g(UInt.m7678h(b & UByte.f41242c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: p */
    private static final boolean m7394p(C14428w contains, ULong uLong) {
        C14342f0.m8184p(contains, "$this$contains");
        return uLong != null && contains.m7429g(uLong.m5890g0());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: q */
    public static final boolean m7393q(@NotNull C14428w contains, int i) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.m7429g(ULong.m5889h(i & 4294967295L));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: r */
    public static final boolean m7392r(@NotNull C14428w contains, byte b) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.m7429g(ULong.m5889h(b & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: s */
    public static final boolean m7391s(@NotNull C14424t contains, short s) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.m7438g(UInt.m7678h(s & UShort.f40820c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @InlineOnly
    /* renamed from: t */
    private static final boolean m7390t(C14424t contains, UInt uInt) {
        C14342f0.m8184p(contains, "$this$contains");
        return uInt != null && contains.m7438g(uInt.m7679g0());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: u */
    public static final boolean m7389u(@NotNull C14424t contains, long j) {
        C14342f0.m8184p(contains, "$this$contains");
        return ULong.m5889h(j >>> 32) == 0 && contains.m7438g(UInt.m7678h((int) j));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: v */
    public static final boolean m7388v(@NotNull C14428w contains, short s) {
        C14342f0.m8184p(contains, "$this$contains");
        return contains.m7429g(ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: w */
    public static final UIntRange m7387w(short s, short s2) {
        return UIntRange.f41312d.m7440a(UInt.m7678h(s & UShort.f40820c), UInt.m7678h(s2 & UShort.f40820c), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: x */
    public static final UIntRange m7386x(int i, int i2) {
        return UIntRange.f41312d.m7440a(i, i2, -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: y */
    public static final UIntRange m7385y(byte b, byte b2) {
        return UIntRange.f41312d.m7440a(UInt.m7678h(b & UByte.f41242c), UInt.m7678h(b2 & UByte.f41242c), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @NotNull
    /* renamed from: z */
    public static final ULongRange m7384z(long j, long j2) {
        return ULongRange.f41322d.m7431a(j, j2, -1L);
    }
}
