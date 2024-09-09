package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import kotlin.ranges.k;
import kotlin.ranges.n;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Random.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0007\u001a\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0014H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0000\u00a8\u0006\u0019"}, d2 = {"", "seed", "Lkotlin/random/Random;", "a", "", "b", "Lkotlin/ranges/k;", "range", "h", "Lkotlin/ranges/n;", "i", "value", "g", "bitCount", "j", "from", "until", "Lkotlin/f1;", "e", "f", "", "d", "", "", "c", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random a(int i4) {
        return new XorWowRandom(i4, i4 >> 31);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random b(long j4) {
        return new XorWowRandom((int) j4, (int) (j4 >> 32));
    }

    @NotNull
    public static final String c(@NotNull Object from, @NotNull Object until) {
        f0.p(from, "from");
        f0.p(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void d(double d4, double d5) {
        if (!(d5 > d4)) {
            throw new IllegalArgumentException(c(Double.valueOf(d4), Double.valueOf(d5)).toString());
        }
    }

    public static final void e(int i4, int i5) {
        if (!(i5 > i4)) {
            throw new IllegalArgumentException(c(Integer.valueOf(i4), Integer.valueOf(i5)).toString());
        }
    }

    public static final void f(long j4, long j5) {
        if (!(j5 > j4)) {
            throw new IllegalArgumentException(c(Long.valueOf(j4), Long.valueOf(j5)).toString());
        }
    }

    public static final int g(int i4) {
        return 31 - Integer.numberOfLeadingZeros(i4);
    }

    @SinceKotlin(version = "1.3")
    public static final int h(@NotNull Random random, @NotNull k range) {
        f0.p(random, "<this>");
        f0.p(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException(f0.C("Cannot get random in empty range: ", range));
        }
        return range.g() < Integer.MAX_VALUE ? random.nextInt(range.c(), range.g() + 1) : range.c() > Integer.MIN_VALUE ? random.nextInt(range.c() - 1, range.g()) + 1 : random.nextInt();
    }

    @SinceKotlin(version = "1.3")
    public static final long i(@NotNull Random random, @NotNull n range) {
        f0.p(random, "<this>");
        f0.p(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException(f0.C("Cannot get random in empty range: ", range));
        }
        return range.g() < Long.MAX_VALUE ? random.nextLong(range.c(), range.g() + 1) : range.c() > Long.MIN_VALUE ? random.nextLong(range.c() - 1, range.g()) + 1 : random.nextLong();
    }

    public static final int j(int i4, int i5) {
        return (i4 >>> (32 - i5)) & ((-i5) >> 31);
    }
}
