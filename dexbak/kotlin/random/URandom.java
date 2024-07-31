package kotlin.random;

import com.kuaishou.weapon.p205p0.C7304t;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.WasExperimental;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.C14424t;
import kotlin.ranges.C14428w;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a&\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0016\u0010\u000f\u001a\u00020\u000e*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a&\u0010\u0013\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0016\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u001a\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u001e\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a2\u0010\"\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\"\u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\"\u0010'\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, m12616d2 = {"Lkotlin/random/Random;", "Lkotlin/r0;", "g", "(Lkotlin/random/Random;)I", "until", "j", "(Lkotlin/random/Random;I)I", Constants.FROM, "i", "(Lkotlin/random/Random;II)I", "Lkotlin/ranges/t;", "range", "h", "(Lkotlin/random/Random;Lkotlin/ranges/t;)I", "Lkotlin/v0;", "k", "(Lkotlin/random/Random;)J", "m", "(Lkotlin/random/Random;J)J", "n", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/w;", C7304t.f25048d, "(Lkotlin/random/Random;Lkotlin/ranges/w;)J", "Lkotlin/o0;", "array", "d", "(Lkotlin/random/Random;[B)[B", "", "size", "c", "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "e", "(Lkotlin/random/Random;[BII)[B", "Lkotlin/f1;", "a", "(II)V", "b", "(JJ)V", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.random.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class URandom {
    /* renamed from: a */
    public static final void m7642a(int i, int i2) {
        if (!(UnsignedUtils.m8561c(i2, i) > 0)) {
            throw new IllegalArgumentException(C14400f.m7650c(UInt.m7690b(i), UInt.m7690b(i2)).toString());
        }
    }

    /* renamed from: b */
    public static final void m7641b(long j, long j2) {
        if (!(UnsignedUtils.m8557g(j2, j) > 0)) {
            throw new IllegalArgumentException(C14400f.m7650c(ULong.m5901b(j), ULong.m5901b(j2)).toString());
        }
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: c */
    public static final byte[] m7640c(@NotNull Random nextUBytes, int i) {
        C14342f0.m8184p(nextUBytes, "$this$nextUBytes");
        return UByteArray.m7754e(nextUBytes.nextBytes(i));
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: d */
    public static final byte[] m7639d(@NotNull Random nextUBytes, @NotNull byte[] array) {
        C14342f0.m8184p(nextUBytes, "$this$nextUBytes");
        C14342f0.m8184p(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: e */
    public static final byte[] m7638e(@NotNull Random nextUBytes, @NotNull byte[] array, int i, int i2) {
        C14342f0.m8184p(nextUBytes, "$this$nextUBytes");
        C14342f0.m8184p(array, "array");
        nextUBytes.nextBytes(array, i, i2);
        return array;
    }

    /* renamed from: f */
    public static /* synthetic */ byte[] m7637f(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m7746m(bArr);
        }
        return m7638e(random, bArr, i, i2);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: g */
    public static final int m7636g(@NotNull Random nextUInt) {
        C14342f0.m8184p(nextUInt, "$this$nextUInt");
        return UInt.m7678h(nextUInt.nextInt());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: h */
    public static final int m7635h(@NotNull Random nextUInt, @NotNull C14424t range) {
        C14342f0.m8184p(nextUInt, "$this$nextUInt");
        C14342f0.m8184p(range, "range");
        if (!range.isEmpty()) {
            return UnsignedUtils.m8561c(range.m7442d(), -1) < 0 ? m7634i(nextUInt, range.m7443c(), UInt.m7678h(range.m7442d() + 1)) : UnsignedUtils.m8561c(range.m7443c(), 0) > 0 ? UInt.m7678h(m7634i(nextUInt, UInt.m7678h(range.m7443c() - 1), range.m7442d()) + 1) : m7636g(nextUInt);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: i */
    public static final int m7634i(@NotNull Random nextUInt, int i, int i2) {
        C14342f0.m8184p(nextUInt, "$this$nextUInt");
        m7642a(i, i2);
        return UInt.m7678h(nextUInt.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: j */
    public static final int m7633j(@NotNull Random nextUInt, int i) {
        C14342f0.m8184p(nextUInt, "$this$nextUInt");
        return m7634i(nextUInt, 0, i);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: k */
    public static final long m7632k(@NotNull Random nextULong) {
        C14342f0.m8184p(nextULong, "$this$nextULong");
        return ULong.m5889h(nextULong.nextLong());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: l */
    public static final long m7631l(@NotNull Random nextULong, @NotNull C14428w range) {
        C14342f0.m8184p(nextULong, "$this$nextULong");
        C14342f0.m8184p(range, "range");
        if (!range.isEmpty()) {
            if (UnsignedUtils.m8557g(range.m7433d(), -1L) < 0) {
                return m7629n(nextULong, range.m7434c(), ULong.m5889h(range.m7433d() + ULong.m5889h(4294967295L & 1)));
            }
            if (UnsignedUtils.m8557g(range.m7434c(), 0L) > 0) {
                long j = 4294967295L & 1;
                return ULong.m5889h(m7629n(nextULong, ULong.m5889h(range.m7434c() - ULong.m5889h(j)), range.m7433d()) + ULong.m5889h(j));
            }
            return m7632k(nextULong);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: m */
    public static final long m7630m(@NotNull Random nextULong, long j) {
        C14342f0.m8184p(nextULong, "$this$nextULong");
        return m7629n(nextULong, 0L, j);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    /* renamed from: n */
    public static final long m7629n(@NotNull Random nextULong, long j, long j2) {
        C14342f0.m8184p(nextULong, "$this$nextULong");
        m7641b(j, j2);
        return ULong.m5889h(nextULong.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }
}
