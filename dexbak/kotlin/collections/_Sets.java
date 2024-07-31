package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\u0002\u001a-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086\u0002\u001a.\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\r\u0010\u0004\u001a.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u0004\u001a6\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\b\u001a-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\u0002\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086\u0002\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0004¨\u0006\u0013"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "element", "y", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "", "elements", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "x", "Lkotlin/sequences/m;", UMCommonContent.f37777aG, "B", "D", "F", "C", ExifInterface.LONGITUDE_EAST, "G", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/SetsKt")
/* renamed from: kotlin.collections.j1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class _Sets extends C14164i1 {
    @NotNull
    /* renamed from: A */
    public static final <T> Set<T> m11968A(@NotNull Set<? extends T> minus, @NotNull T[] elements) {
        C14342f0.m8184p(minus, "$this$minus");
        C14342f0.m8184p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(minus);
        MutableCollections.m12429J0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @InlineOnly
    /* renamed from: B */
    private static final <T> Set<T> m11967B(Set<? extends T> set, T t) {
        return m11960y(set, t);
    }

    @NotNull
    /* renamed from: C */
    public static final <T> Set<T> m11966C(@NotNull Set<? extends T> plus, @NotNull Iterable<? extends T> elements) {
        int size;
        int m8944j;
        C14342f0.m8184p(plus, "$this$plus");
        C14342f0.m8184p(elements, "elements");
        Integer m8956Z = C14236x.m8956Z(elements);
        if (m8956Z != null) {
            size = plus.size() + m8956Z.intValue();
        } else {
            size = plus.size() * 2;
        }
        m8944j = MapsJVM.m8944j(size);
        LinkedHashSet linkedHashSet = new LinkedHashSet(m8944j);
        linkedHashSet.addAll(plus);
        MutableCollections.m12416q0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @NotNull
    /* renamed from: D */
    public static final <T> Set<T> m11965D(@NotNull Set<? extends T> plus, T t) {
        int m8944j;
        C14342f0.m8184p(plus, "$this$plus");
        m8944j = MapsJVM.m8944j(plus.size() + 1);
        LinkedHashSet linkedHashSet = new LinkedHashSet(m8944j);
        linkedHashSet.addAll(plus);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @NotNull
    /* renamed from: E */
    public static final <T> Set<T> m11964E(@NotNull Set<? extends T> plus, @NotNull Sequence<? extends T> elements) {
        int m8944j;
        C14342f0.m8184p(plus, "$this$plus");
        C14342f0.m8184p(elements, "elements");
        m8944j = MapsJVM.m8944j(plus.size() * 2);
        LinkedHashSet linkedHashSet = new LinkedHashSet(m8944j);
        linkedHashSet.addAll(plus);
        MutableCollections.m12415r0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @NotNull
    /* renamed from: F */
    public static final <T> Set<T> m11963F(@NotNull Set<? extends T> plus, @NotNull T[] elements) {
        int m8944j;
        C14342f0.m8184p(plus, "$this$plus");
        C14342f0.m8184p(elements, "elements");
        m8944j = MapsJVM.m8944j(plus.size() + elements.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(m8944j);
        linkedHashSet.addAll(plus);
        MutableCollections.m12414s0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @InlineOnly
    /* renamed from: G */
    private static final <T> Set<T> m11962G(Set<? extends T> set, T t) {
        return m11965D(set, t);
    }

    @NotNull
    /* renamed from: x */
    public static final <T> Set<T> m11961x(@NotNull Set<? extends T> minus, @NotNull Iterable<? extends T> elements) {
        Set<T> m12208N5;
        C14342f0.m8184p(minus, "$this$minus");
        C14342f0.m8184p(elements, "elements");
        Collection<?> m8954b0 = C14236x.m8954b0(elements, minus);
        if (m8954b0.isEmpty()) {
            m12208N5 = _Collections.m12208N5(minus);
            return m12208N5;
        } else if (m8954b0 instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : minus) {
                if (!m8954b0.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(minus);
            linkedHashSet2.removeAll(m8954b0);
            return linkedHashSet2;
        }
    }

    @NotNull
    /* renamed from: y */
    public static final <T> Set<T> m11960y(@NotNull Set<? extends T> minus, T t) {
        int m8944j;
        C14342f0.m8184p(minus, "$this$minus");
        m8944j = MapsJVM.m8944j(minus.size());
        LinkedHashSet linkedHashSet = new LinkedHashSet(m8944j);
        boolean z = false;
        for (T t2 : minus) {
            boolean z2 = true;
            if (!z && C14342f0.m8193g(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    /* renamed from: z */
    public static final <T> Set<T> m11959z(@NotNull Set<? extends T> minus, @NotNull Sequence<? extends T> elements) {
        C14342f0.m8184p(minus, "$this$minus");
        C14342f0.m8184p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(minus);
        MutableCollections.m12430I0(linkedHashSet, elements);
        return linkedHashSet;
    }
}
