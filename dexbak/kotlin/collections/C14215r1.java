package kotlin.collections;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unsigned;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: _UCollections.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00050\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\t0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\r0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\t0\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013\u001a\u001c\u0010\u0017\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\r0\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m12616d2 = {"", "Lkotlin/n0;", "Lkotlin/o0;", "e", "(Ljava/util/Collection;)[B", "Lkotlin/r0;", "Lkotlin/s0;", "f", "(Ljava/util/Collection;)[I", "Lkotlin/v0;", "Lkotlin/w0;", "g", "(Ljava/util/Collection;)[J", "Lkotlin/b1;", "Lkotlin/c1;", "h", "(Ljava/util/Collection;)[S", "", "b", "(Ljava/lang/Iterable;)I", "c", "(Ljava/lang/Iterable;)J", "a", "d", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/UCollectionsKt")
/* renamed from: kotlin.collections.r1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14215r1 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @JvmName(name = "sumOfUByte")
    /* renamed from: a */
    public static final int m9809a(@NotNull Iterable<UByte> sum) {
        C14342f0.m8184p(sum, "$this$sum");
        int i = 0;
        for (UByte uByte : sum) {
            i = UInt.m7678h(i + UInt.m7678h(uByte.m7780e0() & UByte.f41242c));
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @JvmName(name = "sumOfUInt")
    /* renamed from: b */
    public static final int m9808b(@NotNull Iterable<UInt> sum) {
        C14342f0.m8184p(sum, "$this$sum");
        int i = 0;
        for (UInt uInt : sum) {
            i = UInt.m7678h(i + uInt.m7679g0());
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @JvmName(name = "sumOfULong")
    /* renamed from: c */
    public static final long m9807c(@NotNull Iterable<ULong> sum) {
        C14342f0.m8184p(sum, "$this$sum");
        long j = 0;
        for (ULong uLong : sum) {
            j = ULong.m5889h(j + uLong.m5890g0());
        }
        return j;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @JvmName(name = "sumOfUShort")
    /* renamed from: d */
    public static final int m9806d(@NotNull Iterable<UShort> sum) {
        C14342f0.m8184p(sum, "$this$sum");
        int i = 0;
        for (UShort uShort : sum) {
            i = UInt.m7678h(i + UInt.m7678h(uShort.m12532e0() & UShort.f40820c));
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: e */
    public static final byte[] m9805e(@NotNull Collection<UByte> toUByteArray) {
        C14342f0.m8184p(toUByteArray, "$this$toUByteArray");
        byte[] m7755d = UByteArray.m7755d(toUByteArray.size());
        int i = 0;
        for (UByte uByte : toUByteArray) {
            UByteArray.m7741r(m7755d, i, uByte.m7780e0());
            i++;
        }
        return m7755d;
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: f */
    public static final int[] m9804f(@NotNull Collection<UInt> toUIntArray) {
        C14342f0.m8184p(toUIntArray, "$this$toUIntArray");
        int[] m7291d = UIntArray.m7291d(toUIntArray.size());
        int i = 0;
        for (UInt uInt : toUIntArray) {
            UIntArray.m7277r(m7291d, i, uInt.m7679g0());
            i++;
        }
        return m7291d;
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: g */
    public static final long[] m9803g(@NotNull Collection<ULong> toULongArray) {
        C14342f0.m8184p(toULongArray, "$this$toULongArray");
        long[] m5831d = ULongArray.m5831d(toULongArray.size());
        int i = 0;
        for (ULong uLong : toULongArray) {
            ULongArray.m5817r(m5831d, i, uLong.m5890g0());
            i++;
        }
        return m5831d;
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @NotNull
    /* renamed from: h */
    public static final short[] m9802h(@NotNull Collection<UShort> toUShortArray) {
        C14342f0.m8184p(toUShortArray, "$this$toUShortArray");
        short[] m12499d = UShortArray.m12499d(toUShortArray.size());
        int i = 0;
        for (UShort uShort : toUShortArray) {
            UShortArray.m12485r(m12499d, i, uShort.m12532e0());
            i++;
        }
        return m12499d;
    }
}
