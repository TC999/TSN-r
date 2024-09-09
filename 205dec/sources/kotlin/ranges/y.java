package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.b1;
import kotlin.g1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import kotlin.n0;
import kotlin.r0;
import kotlin.random.Random;
import kotlin.ranges.r;
import kotlin.ranges.u;
import kotlin.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _URanges.kt */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u001e\u0010\f\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u001a\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0087\b\u00f8\u0001\u0000\u001a\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u001a!\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a!\u0010\u0016\u001a\u00020\u0013*\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u001f\u0010\u001a\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u00020\u0013*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u0013*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010 \u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001a\u001f\u0010#\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\"H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u0013*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\"H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u001a\u001f\u0010)\u001a\u00020(*\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*\u001a\u001f\u0010+\u001a\u00020(*\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,\u001a\u001f\u0010.\u001a\u00020-*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/\u001a\u001f\u00100\u001a\u00020(*\u00020\"2\u0006\u0010'\u001a\u00020\"H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u00101\u001a\f\u00102\u001a\u00020(*\u00020(H\u0007\u001a\f\u00103\u001a\u00020-*\u00020-H\u0007\u001a\u0015\u00106\u001a\u00020(*\u00020(2\u0006\u00105\u001a\u000204H\u0087\u0004\u001a\u0015\u00108\u001a\u00020-*\u00020-2\u0006\u00105\u001a\u000207H\u0087\u0004\u001a\u001f\u00109\u001a\u00020\u0000*\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010:\u001a\u001f\u0010;\u001a\u00020\u0000*\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010<\u001a\u001f\u0010=\u001a\u00020\u0004*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010>\u001a\u001f\u0010?\u001a\u00020\u0000*\u00020\"2\u0006\u0010'\u001a\u00020\"H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010@\u001a\u001e\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u0010A\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010C\u001a\u001e\u0010D\u001a\u00020\u0005*\u00020\u00052\u0006\u0010A\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bD\u0010E\u001a\u001e\u0010F\u001a\u00020\u0018*\u00020\u00182\u0006\u0010A\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010G\u001a\u001e\u0010H\u001a\u00020\"*\u00020\"2\u0006\u0010A\u001a\u00020\"H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010I\u001a\u001e\u0010K\u001a\u00020\u0001*\u00020\u00012\u0006\u0010J\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010C\u001a\u001e\u0010L\u001a\u00020\u0005*\u00020\u00052\u0006\u0010J\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010E\u001a\u001e\u0010M\u001a\u00020\u0018*\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010G\u001a\u001e\u0010N\u001a\u00020\"*\u00020\"2\u0006\u0010J\u001a\u00020\"H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010I\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010J\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010P\u001a&\u0010Q\u001a\u00020\u0005*\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010R\u001a&\u0010S\u001a\u00020\u0018*\u00020\u00182\u0006\u0010A\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010T\u001a&\u0010U\u001a\u00020\"*\u00020\"2\u0006\u0010A\u001a\u00020\"2\u0006\u0010J\u001a\u00020\"H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bU\u0010V\u001a$\u0010Y\u001a\u00020\u0001*\u00020\u00012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00010WH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bY\u0010Z\u001a$\u0010[\u001a\u00020\u0005*\u00020\u00052\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050WH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b[\u0010\\\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006]"}, d2 = {"Lkotlin/ranges/t;", "Lkotlin/r0;", "A", "(Lkotlin/ranges/t;)I", "Lkotlin/ranges/w;", "Lkotlin/v0;", "C", "(Lkotlin/ranges/w;)J", "Lkotlin/random/Random;", "random", "B", "(Lkotlin/ranges/t;Lkotlin/random/Random;)I", "D", "(Lkotlin/ranges/w;Lkotlin/random/Random;)J", "E", "G", "F", "H", "element", "", "t", "(Lkotlin/ranges/t;Lkotlin/r0;)Z", "p", "(Lkotlin/ranges/w;Lkotlin/v0;)Z", "Lkotlin/n0;", "value", "o", "(Lkotlin/ranges/t;B)Z", "r", "(Lkotlin/ranges/w;B)Z", CampaignEx.JSON_KEY_AD_Q, "(Lkotlin/ranges/w;I)Z", "u", "(Lkotlin/ranges/t;J)Z", "Lkotlin/b1;", "s", "(Lkotlin/ranges/t;S)Z", "v", "(Lkotlin/ranges/w;S)Z", "to", "Lkotlin/ranges/r;", "y", "(BB)Lkotlin/ranges/r;", "x", "(II)Lkotlin/ranges/r;", "Lkotlin/ranges/u;", "z", "(JJ)Lkotlin/ranges/u;", "w", "(SS)Lkotlin/ranges/r;", "I", "J", "", "step", "K", "", "L", "O", "(BB)Lkotlin/ranges/t;", "N", "(II)Lkotlin/ranges/t;", "P", "(JJ)Lkotlin/ranges/w;", "M", "(SS)Lkotlin/ranges/t;", "minimumValue", "b", "(II)I", "d", "(JJ)J", "c", "(BB)B", "a", "(SS)S", "maximumValue", "f", "h", "g", "e", "k", "(III)I", "m", "(JJJ)J", "l", "(BBB)B", "j", "(SSS)S", "Lkotlin/ranges/g;", "range", "n", "(ILkotlin/ranges/g;)I", "i", "(JLkotlin/ranges/g;)J", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/ranges/URangesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class y {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int A(t tVar) {
        f0.p(tVar, "<this>");
        return B(tVar, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int B(@NotNull t tVar, @NotNull Random random) {
        f0.p(tVar, "<this>");
        f0.p(random, "random");
        try {
            return kotlin.random.g.h(random, tVar);
        } catch (IllegalArgumentException e4) {
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long C(w wVar) {
        f0.p(wVar, "<this>");
        return D(wVar, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long D(@NotNull w wVar, @NotNull Random random) {
        f0.p(wVar, "<this>");
        f0.p(random, "random");
        try {
            return kotlin.random.g.l(random, wVar);
        } catch (IllegalArgumentException e4) {
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final r0 E(t tVar) {
        f0.p(tVar, "<this>");
        return F(tVar, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @Nullable
    public static final r0 F(@NotNull t tVar, @NotNull Random random) {
        f0.p(tVar, "<this>");
        f0.p(random, "random");
        if (tVar.isEmpty()) {
            return null;
        }
        return r0.b(kotlin.random.g.h(random, tVar));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final v0 G(w wVar) {
        f0.p(wVar, "<this>");
        return H(wVar, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @Nullable
    public static final v0 H(@NotNull w wVar, @NotNull Random random) {
        f0.p(wVar, "<this>");
        f0.p(random, "random");
        if (wVar.isEmpty()) {
            return null;
        }
        return v0.b(kotlin.random.g.l(random, wVar));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final r I(@NotNull r rVar) {
        f0.p(rVar, "<this>");
        return r.f55812d.a(rVar.g(), rVar.c(), -rVar.k());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final u J(@NotNull u uVar) {
        f0.p(uVar, "<this>");
        return u.f55822d.a(uVar.g(), uVar.c(), -uVar.k());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final r K(@NotNull r rVar, int i4) {
        f0.p(rVar, "<this>");
        p.a(i4 > 0, Integer.valueOf(i4));
        r.a aVar = r.f55812d;
        int c4 = rVar.c();
        int g4 = rVar.g();
        if (rVar.k() <= 0) {
            i4 = -i4;
        }
        return aVar.a(c4, g4, i4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final u L(@NotNull u uVar, long j4) {
        f0.p(uVar, "<this>");
        p.a(j4 > 0, Long.valueOf(j4));
        u.a aVar = u.f55822d;
        long c4 = uVar.c();
        long g4 = uVar.g();
        if (uVar.k() <= 0) {
            j4 = -j4;
        }
        return aVar.a(c4, g4, j4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final t M(short s3, short s4) {
        int i4 = s4 & 65535;
        return f0.t(i4, 0) <= 0 ? t.f55820e.a() : new t(r0.i(s3 & 65535), r0.i(r0.i(i4) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final t N(int i4, int i5) {
        return g1.c(i5, 0) <= 0 ? t.f55820e.a() : new t(i4, r0.i(i5 - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final t O(byte b4, byte b5) {
        int i4 = b5 & 255;
        return f0.t(i4, 0) <= 0 ? t.f55820e.a() : new t(r0.i(b4 & 255), r0.i(r0.i(i4) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final w P(long j4, long j5) {
        return g1.g(j5, 0L) <= 0 ? w.f55830e.a() : new w(j4, v0.i(j5 - v0.i(1 & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short a(short s3, short s4) {
        return f0.t(s3 & 65535, 65535 & s4) < 0 ? s4 : s3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int b(int i4, int i5) {
        return g1.c(i4, i5) < 0 ? i5 : i4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte c(byte b4, byte b5) {
        return f0.t(b4 & 255, b5 & 255) < 0 ? b5 : b4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long d(long j4, long j5) {
        return g1.g(j4, j5) < 0 ? j5 : j4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short e(short s3, short s4) {
        return f0.t(s3 & 65535, 65535 & s4) > 0 ? s4 : s3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int f(int i4, int i5) {
        return g1.c(i4, i5) > 0 ? i5 : i4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte g(byte b4, byte b5) {
        return f0.t(b4 & 255, b5 & 255) > 0 ? b5 : b4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long h(long j4, long j5) {
        return g1.g(j4, j5) > 0 ? j5 : j4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long i(long j4, @NotNull g<v0> range) {
        f0.p(range, "range");
        if (range instanceof f) {
            return ((v0) q.G(v0.b(j4), (f) range)).l0();
        }
        if (!range.isEmpty()) {
            return g1.g(j4, range.getStart().l0()) < 0 ? range.getStart().l0() : g1.g(j4, range.getEndInclusive().l0()) > 0 ? range.getEndInclusive().l0() : j4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short j(short s3, short s4, short s5) {
        int i4 = s4 & 65535;
        int i5 = s5 & 65535;
        if (f0.t(i4, i5) <= 0) {
            int i6 = 65535 & s3;
            return f0.t(i6, i4) < 0 ? s4 : f0.t(i6, i5) > 0 ? s5 : s3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) b1.e0(s5)) + " is less than minimum " + ((Object) b1.e0(s4)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int k(int i4, int i5, int i6) {
        if (g1.c(i5, i6) <= 0) {
            return g1.c(i4, i5) < 0 ? i5 : g1.c(i4, i6) > 0 ? i6 : i4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) r0.g0(i6)) + " is less than minimum " + ((Object) r0.g0(i5)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte l(byte b4, byte b5, byte b6) {
        int i4 = b5 & 255;
        int i5 = b6 & 255;
        if (f0.t(i4, i5) <= 0) {
            int i6 = b4 & 255;
            return f0.t(i6, i4) < 0 ? b5 : f0.t(i6, i5) > 0 ? b6 : b4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) n0.e0(b6)) + " is less than minimum " + ((Object) n0.e0(b5)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long m(long j4, long j5, long j6) {
        if (g1.g(j5, j6) <= 0) {
            return g1.g(j4, j5) < 0 ? j5 : g1.g(j4, j6) > 0 ? j6 : j4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) v0.g0(j6)) + " is less than minimum " + ((Object) v0.g0(j5)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int n(int i4, @NotNull g<r0> range) {
        f0.p(range, "range");
        if (range instanceof f) {
            return ((r0) q.G(r0.b(i4), (f) range)).l0();
        }
        if (!range.isEmpty()) {
            return g1.c(i4, range.getStart().l0()) < 0 ? range.getStart().l0() : g1.c(i4, range.getEndInclusive().l0()) > 0 ? range.getEndInclusive().l0() : i4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean o(@NotNull t contains, byte b4) {
        f0.p(contains, "$this$contains");
        return contains.m(r0.i(b4 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final boolean p(w contains, v0 v0Var) {
        f0.p(contains, "$this$contains");
        return v0Var != null && contains.m(v0Var.l0());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean q(@NotNull w contains, int i4) {
        f0.p(contains, "$this$contains");
        return contains.m(v0.i(i4 & 4294967295L));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean r(@NotNull w contains, byte b4) {
        f0.p(contains, "$this$contains");
        return contains.m(v0.i(b4 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean s(@NotNull t contains, short s3) {
        f0.p(contains, "$this$contains");
        return contains.m(r0.i(s3 & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final boolean t(t contains, r0 r0Var) {
        f0.p(contains, "$this$contains");
        return r0Var != null && contains.m(r0Var.l0());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean u(@NotNull t contains, long j4) {
        f0.p(contains, "$this$contains");
        return v0.i(j4 >>> 32) == 0 && contains.m(r0.i((int) j4));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean v(@NotNull w contains, short s3) {
        f0.p(contains, "$this$contains");
        return contains.m(v0.i(s3 & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final r w(short s3, short s4) {
        return r.f55812d.a(r0.i(s3 & 65535), r0.i(s4 & 65535), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final r x(int i4, int i5) {
        return r.f55812d.a(i4, i5, -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final r y(byte b4, byte b5) {
        return r.f55812d.a(r0.i(b4 & 255), r0.i(b5 & 255), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final u z(long j4, long j5) {
        return u.f55822d.a(j4, j5, -1L);
    }
}
