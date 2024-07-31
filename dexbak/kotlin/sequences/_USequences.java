package kotlin.sequences;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unsigned;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u001c\u0010\n\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m12616d2 = {"Lkotlin/sequences/m;", "Lkotlin/r0;", "b", "(Lkotlin/sequences/m;)I", "Lkotlin/v0;", "c", "(Lkotlin/sequences/m;)J", "Lkotlin/n0;", "a", "Lkotlin/b1;", "d", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/sequences/USequencesKt")
/* renamed from: kotlin.sequences.a0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class _USequences {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {Unsigned.class})
    @JvmName(name = "sumOfUByte")
    /* renamed from: a */
    public static final int m7076a(@NotNull Sequence<UByte> sum) {
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
    public static final int m7075b(@NotNull Sequence<UInt> sum) {
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
    public static final long m7074c(@NotNull Sequence<ULong> sum) {
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
    public static final int m7073d(@NotNull Sequence<UShort> sum) {
        C14342f0.m8184p(sum, "$this$sum");
        int i = 0;
        for (UShort uShort : sum) {
            i = UInt.m7678h(i + UInt.m7678h(uShort.m12532e0() & UShort.f40820c));
        }
        return i;
    }
}
