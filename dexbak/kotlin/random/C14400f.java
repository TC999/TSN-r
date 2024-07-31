package kotlin.random;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.C14413k;
import kotlin.ranges.C14418n;
import org.jetbrains.annotations.NotNull;

/* compiled from: Random.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0007\u001a\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0014H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0000¨\u0006\u0019"}, m12616d2 = {"", "seed", "Lkotlin/random/Random;", "a", "", "b", "Lkotlin/ranges/k;", "range", "h", "Lkotlin/ranges/n;", "i", DomainCampaignEx.LOOPBACK_VALUE, "g", "bitCount", "j", Constants.FROM, "until", "Lkotlin/f1;", "e", "f", "", "d", "", "", "c", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.random.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14400f {
    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: a */
    public static final Random m7652a(int i) {
        return new XorWowRandom(i, i >> 31);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: b */
    public static final Random m7651b(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    @NotNull
    /* renamed from: c */
    public static final String m7650c(@NotNull Object from, @NotNull Object until) {
        C14342f0.m8184p(from, "from");
        C14342f0.m8184p(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    /* renamed from: d */
    public static final void m7649d(double d, double d2) {
        if (!(d2 > d)) {
            throw new IllegalArgumentException(m7650c(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }

    /* renamed from: e */
    public static final void m7648e(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(m7650c(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    /* renamed from: f */
    public static final void m7647f(long j, long j2) {
        if (!(j2 > j)) {
            throw new IllegalArgumentException(m7650c(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    /* renamed from: g */
    public static final int m7646g(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: h */
    public static final int m7645h(@NotNull Random nextInt, @NotNull C14413k range) {
        C14342f0.m8184p(nextInt, "$this$nextInt");
        C14342f0.m8184p(range, "range");
        if (!range.isEmpty()) {
            return range.m7603d() < Integer.MAX_VALUE ? nextInt.nextInt(range.m7604c(), range.m7603d() + 1) : range.m7604c() > Integer.MIN_VALUE ? nextInt.nextInt(range.m7604c() - 1, range.m7603d()) + 1 : nextInt.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: i */
    public static final long m7644i(@NotNull Random nextLong, @NotNull C14418n range) {
        C14342f0.m8184p(nextLong, "$this$nextLong");
        C14342f0.m8184p(range, "range");
        if (!range.isEmpty()) {
            return range.m7592d() < Long.MAX_VALUE ? nextLong.nextLong(range.m7593c(), range.m7592d() + 1) : range.m7593c() > Long.MIN_VALUE ? nextLong.nextLong(range.m7593c() - 1, range.m7592d()) + 1 : nextLong.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    /* renamed from: j */
    public static final int m7643j(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }
}
