package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _Comparisons.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0007\u001aI\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005H\u0007\u00a2\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005H\u0007\u00a2\u0006\u0004\b\t\u0010\n\u001aM\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\"\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005H\u0007\u00a2\u0006\u0004\b\r\u0010\u000e\u001aI\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005H\u0007\u00a2\u0006\u0004\b\u000f\u0010\b\u001aA\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005H\u0007\u00a2\u0006\u0004\b\u0010\u0010\n\u001aM\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\"\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005H\u0007\u00a2\u0006\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"T", "a", "b", "c", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "p0", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "q0", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "", "other", "r0", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "s0", "t0", "u0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class d extends c {
    @SinceKotlin(version = "1.1")
    public static final <T> T p0(T t3, T t4, T t5, @NotNull Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return (T) q0(t3, q0(t4, t5, comparator), comparator);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T q0(T t3, T t4, @NotNull Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return comparator.compare(t3, t4) >= 0 ? t3 : t4;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T r0(T t3, @NotNull T[] other, @NotNull Comparator<? super T> comparator) {
        f0.p(other, "other");
        f0.p(comparator, "comparator");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            T t4 = other[i4];
            i4++;
            if (comparator.compare(t3, t4) < 0) {
                t3 = t4;
            }
        }
        return t3;
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T s0(T t3, T t4, T t5, @NotNull Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return (T) t0(t3, t0(t4, t5, comparator), comparator);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T t0(T t3, T t4, @NotNull Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return comparator.compare(t3, t4) <= 0 ? t3 : t4;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T u0(T t3, @NotNull T[] other, @NotNull Comparator<? super T> comparator) {
        f0.p(other, "other");
        f0.p(comparator, "comparator");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            T t4 = other[i4];
            i4++;
            if (comparator.compare(t3, t4) > 0) {
                t3 = t4;
            }
        }
        return t3;
    }
}
