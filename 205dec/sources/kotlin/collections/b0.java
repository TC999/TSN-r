package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MutableCollectionsJVM.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0002j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0003H\u0087\b\u001a6\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H\u0087\b\u00f8\u0001\u0000\u001a \u0010\f\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a2\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0002j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0003\u001a(\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\u0087\b\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b\u001a!\u0010\u0014\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0015"}, d2 = {"T", "", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "Lkotlin/f1;", "m0", "Lkotlin/Function2;", "", "comparison", "l0", "", "k0", "n0", "value", "h0", "(Ljava/util/List;Ljava/lang/Object;)V", "i0", "Ljava/util/Random;", "random", "j0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b0 extends a0 {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void h0(List<T> list, T t3) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        Collections.fill(list, t3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void i0(List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        Collections.shuffle(list);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void j0(List<T> list, Random random) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        Collections.shuffle(list, random);
    }

    public static <T extends Comparable<? super T>> void k0(@NotNull List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    @InlineOnly
    private static final <T> void l0(List<T> list, d2.p<? super T, ? super T, Integer> comparison) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparison, "comparison");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", imports = {}))
    @InlineOnly
    private static final <T> void m0(List<T> list, Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        throw new NotImplementedError(null, 1, null);
    }

    public static <T> void n0(@NotNull List<T> list, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
