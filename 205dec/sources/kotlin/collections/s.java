package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BrittleContainsOptimization.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0002\u001a,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000\u001a\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\bH\u0000\u001a%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\nH\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"T", "", "", "e", "", "source", "d", "a", "Lkotlin/sequences/m;", "b", "", "c", "([Ljava/lang/Object;)Ljava/util/Collection;", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s {
    @NotNull
    public static final <T> Collection<T> a(@NotNull Iterable<? extends T> iterable) {
        List G5;
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (iterable instanceof Collection) {
            Collection<T> collection = (Collection) iterable;
            return e(collection) ? f0.E5(iterable) : collection;
        } else if (v.f55459b) {
            return f0.E5(iterable);
        } else {
            G5 = f0.G5(iterable);
            return G5;
        }
    }

    @NotNull
    public static final <T> Collection<T> b(@NotNull kotlin.sequences.m<? extends T> mVar) {
        List V2;
        HashSet U2;
        kotlin.jvm.internal.f0.p(mVar, "<this>");
        if (v.f55459b) {
            U2 = SequencesKt___SequencesKt.U2(mVar);
            return U2;
        }
        V2 = SequencesKt___SequencesKt.V2(mVar);
        return V2;
    }

    @NotNull
    public static final <T> Collection<T> c(@NotNull T[] tArr) {
        List t3;
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (v.f55459b) {
            return p.Ux(tArr);
        }
        t3 = o.t(tArr);
        return t3;
    }

    @NotNull
    public static final <T> Collection<T> d(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> source) {
        List G5;
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(source, "source");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (iterable instanceof Collection) {
            if (!(source instanceof Collection) || ((Collection) source).size() >= 2) {
                Collection<T> collection = (Collection) iterable;
                return e(collection) ? f0.E5(iterable) : collection;
            }
            return (Collection) iterable;
        } else if (v.f55459b) {
            return f0.E5(iterable);
        } else {
            G5 = f0.G5(iterable);
            return G5;
        }
    }

    private static final <T> boolean e(Collection<? extends T> collection) {
        return v.f55459b && collection.size() > 2 && (collection instanceof ArrayList);
    }
}
