package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.g1;
import kotlin.jvm.internal.f0;
import kotlin.o0;
import kotlin.r0;
import kotlin.ranges.t;
import kotlin.ranges.w;
import kotlin.v0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: URandom.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a&\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\u0016\u0010\u000f\u001a\u00020\u000e*\u00020\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000eH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a&\u0010\u0013\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0016\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u001a\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u001e\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a2\u0010\"\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001cH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#\u001a\"\u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u001a\"\u0010'\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lkotlin/random/Random;", "Lkotlin/r0;", "g", "(Lkotlin/random/Random;)I", "until", "j", "(Lkotlin/random/Random;I)I", "from", "i", "(Lkotlin/random/Random;II)I", "Lkotlin/ranges/t;", "range", "h", "(Lkotlin/random/Random;Lkotlin/ranges/t;)I", "Lkotlin/v0;", "k", "(Lkotlin/random/Random;)J", "m", "(Lkotlin/random/Random;J)J", "n", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/w;", "l", "(Lkotlin/random/Random;Lkotlin/ranges/w;)J", "Lkotlin/o0;", "array", "d", "(Lkotlin/random/Random;[B)[B", "", "size", "c", "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "e", "(Lkotlin/random/Random;[BII)[B", "Lkotlin/f1;", "a", "(II)V", "b", "(JJ)V", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    public static final void a(int i4, int i5) {
        if (!(g1.c(i5, i4) > 0)) {
            throw new IllegalArgumentException(f.c(r0.b(i4), r0.b(i5)).toString());
        }
    }

    public static final void b(long j4, long j5) {
        if (!(g1.g(j5, j4) > 0)) {
            throw new IllegalArgumentException(f.c(v0.b(j4), v0.b(j5)).toString());
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] c(@NotNull Random random, int i4) {
        f0.p(random, "<this>");
        return o0.k(random.nextBytes(i4));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] d(@NotNull Random nextUBytes, @NotNull byte[] array) {
        f0.p(nextUBytes, "$this$nextUBytes");
        f0.p(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] e(@NotNull Random nextUBytes, @NotNull byte[] array, int i4, int i5) {
        f0.p(nextUBytes, "$this$nextUBytes");
        f0.p(array, "array");
        nextUBytes.nextBytes(array, i4, i5);
        return array;
    }

    public static /* synthetic */ byte[] f(Random random, byte[] bArr, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = o0.s(bArr);
        }
        return e(random, bArr, i4, i5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int g(@NotNull Random random) {
        f0.p(random, "<this>");
        return r0.i(random.nextInt());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int h(@NotNull Random random, @NotNull t range) {
        f0.p(random, "<this>");
        f0.p(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException(f0.C("Cannot get random in empty range: ", range));
        }
        return g1.c(range.g(), -1) < 0 ? i(random, range.c(), r0.i(range.g() + 1)) : g1.c(range.c(), 0) > 0 ? r0.i(i(random, r0.i(range.c() - 1), range.g()) + 1) : g(random);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int i(@NotNull Random nextUInt, int i4, int i5) {
        f0.p(nextUInt, "$this$nextUInt");
        a(i4, i5);
        return r0.i(nextUInt.nextInt(i4 ^ Integer.MIN_VALUE, i5 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int j(@NotNull Random nextUInt, int i4) {
        f0.p(nextUInt, "$this$nextUInt");
        return i(nextUInt, 0, i4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long k(@NotNull Random random) {
        f0.p(random, "<this>");
        return v0.i(random.nextLong());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long l(@NotNull Random random, @NotNull w range) {
        f0.p(random, "<this>");
        f0.p(range, "range");
        if (!range.isEmpty()) {
            if (g1.g(range.g(), -1L) < 0) {
                return n(random, range.c(), v0.i(range.g() + v0.i(4294967295L & 1)));
            }
            if (g1.g(range.c(), 0L) > 0) {
                long j4 = 4294967295L & 1;
                return v0.i(n(random, v0.i(range.c() - v0.i(j4)), range.g()) + v0.i(j4));
            }
            return k(random);
        }
        throw new IllegalArgumentException(f0.C("Cannot get random in empty range: ", range));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long m(@NotNull Random nextULong, long j4) {
        f0.p(nextULong, "$this$nextULong");
        return n(nextULong, 0L, j4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long n(@NotNull Random nextULong, long j4, long j5) {
        f0.p(nextULong, "$this$nextULong");
        b(j4, j5);
        return v0.i(nextULong.nextLong(j4 ^ Long.MIN_VALUE, j5 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }
}
