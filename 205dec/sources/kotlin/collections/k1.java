package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _Sets.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002\u00a2\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\u0002\u001a-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086\u0002\u001a.\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\b\u00a2\u0006\u0004\b\r\u0010\u0004\u001a.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0004\u001a6\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002\u00a2\u0006\u0004\b\u000f\u0010\b\u001a-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\u0002\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086\u0002\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\b\u00a2\u0006\u0004\b\u0012\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"T", "", "element", "y", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "", "elements", "A", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "x", "Lkotlin/sequences/m;", "z", "B", "D", "F", "C", "E", "G", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/SetsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class k1 extends j1 {
    @NotNull
    public static final <T> Set<T> A(@NotNull Set<? extends T> set, @NotNull T[] elements) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        c0.H0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @InlineOnly
    private static final <T> Set<T> B(Set<? extends T> set, T t3) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        return y(set, t3);
    }

    @NotNull
    public static <T> Set<T> C(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> elements) {
        int j4;
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        Integer a02 = y.a0(elements);
        j4 = y0.j(a02 == null ? set.size() * 2 : a02.intValue() + set.size());
        LinkedHashSet linkedHashSet = new LinkedHashSet(j4);
        linkedHashSet.addAll(set);
        c0.o0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @NotNull
    public static <T> Set<T> D(@NotNull Set<? extends T> set, T t3) {
        int j4;
        kotlin.jvm.internal.f0.p(set, "<this>");
        j4 = y0.j(set.size() + 1);
        LinkedHashSet linkedHashSet = new LinkedHashSet(j4);
        linkedHashSet.addAll(set);
        linkedHashSet.add(t3);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> E(@NotNull Set<? extends T> set, @NotNull kotlin.sequences.m<? extends T> elements) {
        int j4;
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        j4 = y0.j(set.size() * 2);
        LinkedHashSet linkedHashSet = new LinkedHashSet(j4);
        linkedHashSet.addAll(set);
        c0.p0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> F(@NotNull Set<? extends T> set, @NotNull T[] elements) {
        int j4;
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        j4 = y0.j(set.size() + elements.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(j4);
        linkedHashSet.addAll(set);
        c0.q0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @InlineOnly
    private static final <T> Set<T> G(Set<? extends T> set, T t3) {
        Set<T> D;
        kotlin.jvm.internal.f0.p(set, "<this>");
        D = D(set, t3);
        return D;
    }

    @NotNull
    public static <T> Set<T> x(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> elements) {
        Set<T> L5;
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        Collection<?> d4 = s.d(elements, set);
        if (d4.isEmpty()) {
            L5 = f0.L5(set);
            return L5;
        } else if (d4 instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t3 : set) {
                if (!d4.contains(t3)) {
                    linkedHashSet.add(t3);
                }
            }
            return linkedHashSet;
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
            linkedHashSet2.removeAll(d4);
            return linkedHashSet2;
        }
    }

    @NotNull
    public static final <T> Set<T> y(@NotNull Set<? extends T> set, T t3) {
        int j4;
        kotlin.jvm.internal.f0.p(set, "<this>");
        j4 = y0.j(set.size());
        LinkedHashSet linkedHashSet = new LinkedHashSet(j4);
        boolean z3 = false;
        for (T t4 : set) {
            boolean z4 = true;
            if (!z3 && kotlin.jvm.internal.f0.g(t4, t3)) {
                z3 = true;
                z4 = false;
            }
            if (z4) {
                linkedHashSet.add(t4);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> z(@NotNull Set<? extends T> set, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        c0.G0(linkedHashSet, elements);
        return linkedHashSet;
    }
}
