package kotlin.sequences;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.b1;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.n0;
import kotlin.r0;
import kotlin.v0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _USequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0003\u001a\u001c\u0010\n\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lkotlin/sequences/m;", "Lkotlin/r0;", "b", "(Lkotlin/sequences/m;)I", "Lkotlin/v0;", "c", "(Lkotlin/sequences/m;)J", "Lkotlin/n0;", "a", "Lkotlin/b1;", "d", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/sequences/USequencesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class a0 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int a(@NotNull m<n0> mVar) {
        f0.p(mVar, "<this>");
        int i4 = 0;
        for (n0 n0Var : mVar) {
            i4 = r0.i(i4 + r0.i(n0Var.j0() & 255));
        }
        return i4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int b(@NotNull m<r0> mVar) {
        f0.p(mVar, "<this>");
        int i4 = 0;
        for (r0 r0Var : mVar) {
            i4 = r0.i(i4 + r0Var.l0());
        }
        return i4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long c(@NotNull m<v0> mVar) {
        f0.p(mVar, "<this>");
        long j4 = 0;
        for (v0 v0Var : mVar) {
            j4 = v0.i(j4 + v0Var.l0());
        }
        return j4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int d(@NotNull m<b1> mVar) {
        f0.p(mVar, "<this>");
        int i4 = 0;
        for (b1 b1Var : mVar) {
            i4 = r0.i(i4 + r0.i(b1Var.j0() & 65535));
        }
        return i4;
    }
}
