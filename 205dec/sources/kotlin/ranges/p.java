package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u0002\u001a\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\u0002\u001aB\u0010\u0010\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u000b\"\u0018\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\f*\b\u0012\u0004\u0012\u00028\u00000\u0003*\u00028\u00012\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0087\n\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\u00a8\u0006\u0017"}, d2 = {"", "T", "that", "Lkotlin/ranges/g;", "e", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/g;", "", "Lkotlin/ranges/f;", "c", "", "d", "", "", "R", "element", "", "b", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "isPositive", "", "step", "Lkotlin/f1;", "a", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/ranges/RangesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class p {
    public static final void a(boolean z3, @NotNull Number step) {
        f0.p(step, "step");
        if (z3) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ljava/lang/Iterable<+TT;>;:Lkotlin/ranges/g<TT;>;>(TR;TT;)Z */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean b(Iterable iterable, Object obj) {
        f0.p(iterable, "<this>");
        return obj != null && ((g) iterable).contains((Comparable) obj);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final f<Double> c(double d4, double d5) {
        return new d(d4, d5);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final f<Float> d(float f4, float f5) {
        return new e(f4, f5);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> g<T> e(@NotNull T t3, @NotNull T that) {
        f0.p(t3, "<this>");
        f0.p(that, "that");
        return new h(t3, that);
    }
}
