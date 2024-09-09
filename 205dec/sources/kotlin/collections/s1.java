package kotlin.collections;

import java.util.Collection;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: _UCollections.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00050\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\t0\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\r0\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\t0\u0011H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0013\u001a\u001c\u0010\u0017\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\r0\u0011H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"", "Lkotlin/n0;", "Lkotlin/o0;", "e", "(Ljava/util/Collection;)[B", "Lkotlin/r0;", "Lkotlin/s0;", "f", "(Ljava/util/Collection;)[I", "Lkotlin/v0;", "Lkotlin/w0;", "g", "(Ljava/util/Collection;)[J", "Lkotlin/b1;", "Lkotlin/c1;", "h", "(Ljava/util/Collection;)[S", "", "b", "(Ljava/lang/Iterable;)I", "c", "(Ljava/lang/Iterable;)J", "a", "d", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class s1 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int a(@NotNull Iterable<kotlin.n0> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        int i4 = 0;
        for (kotlin.n0 n0Var : iterable) {
            i4 = kotlin.r0.i(i4 + kotlin.r0.i(n0Var.j0() & 255));
        }
        return i4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int b(@NotNull Iterable<kotlin.r0> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        int i4 = 0;
        for (kotlin.r0 r0Var : iterable) {
            i4 = kotlin.r0.i(i4 + r0Var.l0());
        }
        return i4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long c(@NotNull Iterable<kotlin.v0> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        long j4 = 0;
        for (kotlin.v0 v0Var : iterable) {
            j4 = kotlin.v0.i(j4 + v0Var.l0());
        }
        return j4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int d(@NotNull Iterable<kotlin.b1> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        int i4 = 0;
        for (kotlin.b1 b1Var : iterable) {
            i4 = kotlin.r0.i(i4 + kotlin.r0.i(b1Var.j0() & 65535));
        }
        return i4;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] e(@NotNull Collection<kotlin.n0> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        byte[] g4 = kotlin.o0.g(collection.size());
        int i4 = 0;
        for (kotlin.n0 n0Var : collection) {
            kotlin.o0.y(g4, i4, n0Var.j0());
            i4++;
        }
        return g4;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] f(@NotNull Collection<kotlin.r0> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        int[] g4 = kotlin.s0.g(collection.size());
        int i4 = 0;
        for (kotlin.r0 r0Var : collection) {
            kotlin.s0.y(g4, i4, r0Var.l0());
            i4++;
        }
        return g4;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] g(@NotNull Collection<kotlin.v0> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        long[] g4 = kotlin.w0.g(collection.size());
        int i4 = 0;
        for (kotlin.v0 v0Var : collection) {
            kotlin.w0.y(g4, i4, v0Var.l0());
            i4++;
        }
        return g4;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] h(@NotNull Collection<kotlin.b1> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        short[] g4 = kotlin.c1.g(collection.size());
        int i4 = 0;
        for (kotlin.b1 b1Var : collection) {
            kotlin.c1.y(g4, i4, b1Var.j0());
            i4++;
        }
        return g4;
    }
}
