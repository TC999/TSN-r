package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.x;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: collections.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    public static final <T> void a(@NotNull Collection<T> collection, @Nullable T t3) {
        f0.p(collection, "<this>");
        if (t3 != null) {
            collection.add(t3);
        }
    }

    private static final int b(int i4) {
        if (i4 < 3) {
            return 3;
        }
        return i4 + (i4 / 3) + 1;
    }

    @NotNull
    public static final <T> List<T> c(@NotNull ArrayList<T> arrayList) {
        List<T> F;
        Object m22;
        List<T> l4;
        f0.p(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        } else if (size != 1) {
            arrayList.trimToSize();
            return arrayList;
        } else {
            m22 = kotlin.collections.f0.m2(arrayList);
            l4 = x.l(m22);
            return l4;
        }
    }

    @NotNull
    public static final <K> Map<K, Integer> d(@NotNull Iterable<? extends K> iterable) {
        f0.p(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i4 = 0;
        for (K k4 : iterable) {
            linkedHashMap.put(k4, Integer.valueOf(i4));
            i4++;
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> HashMap<K, V> e(int i4) {
        return new HashMap<>(b(i4));
    }

    @NotNull
    public static final <E> HashSet<E> f(int i4) {
        return new HashSet<>(b(i4));
    }

    @NotNull
    public static final <E> LinkedHashSet<E> g(int i4) {
        return new LinkedHashSet<>(b(i4));
    }
}
