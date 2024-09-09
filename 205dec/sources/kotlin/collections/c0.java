package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MutableCollections.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\r\u001a/\u0010\u0005\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001\u00a2\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\b\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a.\u0010\t\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001\u00a2\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087\b\u001a.\u0010\n\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001\u00a2\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087\b\u001a*\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\n\u00a2\u0006\u0004\b\f\u0010\r\u001a)\u0010\u000f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\n\u001a0\u0010\u0011\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0087\n\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a)\u0010\u0014\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0087\n\u001a*\u0010\u0015\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\n\u00a2\u0006\u0004\b\u0015\u0010\r\u001a)\u0010\u0016\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\n\u001a0\u0010\u0017\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0087\n\u00a2\u0006\u0004\b\u0017\u0010\u0012\u001a)\u0010\u0018\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0087\n\u001a&\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u001a&\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u001a/\u0010\u001b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u001d\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u001a&\u0010\u001e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u001a/\u0010\u001f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010\u00a2\u0006\u0004\b\u001f\u0010\u001c\u001a&\u0010 \u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u001a/\u0010!\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010\u00a2\u0006\u0004\b!\u0010\u001c\u001a&\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u001a\u0017\u0010#\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0002H\u0002\u00a2\u0006\u0004\b#\u0010$\u001a*\u0010(\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&\u001a*\u0010)\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&\u001a;\u0010+\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010*\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b+\u0010,\u001a(\u00100\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010/\u001a\u00020.H\u0087\b\u00a2\u0006\u0004\b0\u00101\u001a\u001f\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-H\u0007\u00a2\u0006\u0004\b2\u00103\u001a!\u00104\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-H\u0007\u00a2\u0006\u0004\b4\u00103\u001a\u001f\u00105\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-H\u0007\u00a2\u0006\u0004\b5\u00103\u001a!\u00106\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-H\u0007\u00a2\u0006\u0004\b6\u00103\u001a*\u00107\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&\u001a*\u00108\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&\u001a;\u00109\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010*\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b9\u0010:\u00a8\u0006;"}, d2 = {"Lkotlin/internal/OnlyInputTypes;", "T", "", "element", "", "C0", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "", "elements", "F0", "P0", "Lkotlin/f1;", "y0", "(Ljava/util/Collection;Ljava/lang/Object;)V", "", "x0", "", "A0", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "Lkotlin/sequences/m;", "z0", "u0", "t0", "w0", "v0", "o0", "p0", "q0", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "E0", "G0", "H0", "O0", "R0", "Q0", "T0", "(Ljava/util/Collection;)Z", "", "Lkotlin/Function1;", "predicate", "D0", "N0", "predicateResultToRemove", "r0", "(Ljava/lang/Iterable;Ld2/l;Z)Z", "", "", "index", "B0", "(Ljava/util/List;I)Ljava/lang/Object;", "J0", "(Ljava/util/List;)Ljava/lang/Object;", "K0", "L0", "M0", "I0", "S0", "s0", "(Ljava/util/List;Ld2/l;Z)Z", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c0 extends b0 {
    @InlineOnly
    private static final <T> void A0(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        q0(collection, elements);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    @InlineOnly
    private static final <T> T B0(List<T> list, int i4) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.remove(i4);
    }

    @InlineOnly
    private static final <T> boolean C0(Collection<? extends T> collection, T t3) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return collection.remove(t3);
    }

    public static final <T> boolean D0(@NotNull Iterable<? extends T> iterable, @NotNull d2.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        return r0(iterable, predicate, true);
    }

    public static final <T> boolean E0(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        return collection.removeAll(s.d(elements, collection));
    }

    @InlineOnly
    private static final <T> boolean F0(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        return collection.removeAll(elements);
    }

    public static final <T> boolean G0(@NotNull Collection<? super T> collection, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        Collection<?> b4 = s.b(elements);
        return (b4.isEmpty() ^ true) && collection.removeAll(b4);
    }

    public static final <T> boolean H0(@NotNull Collection<? super T> collection, @NotNull T[] elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        return ((elements.length == 0) ^ true) && collection.removeAll(s.c(elements));
    }

    public static final <T> boolean I0(@NotNull List<T> list, @NotNull d2.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        return s0(list, predicate, true);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T J0(@NotNull List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final <T> T K0(@NotNull List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static <T> T L0(@NotNull List<T> list) {
        int H;
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        H = CollectionsKt__CollectionsKt.H(list);
        return list.remove(H);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final <T> T M0(@NotNull List<T> list) {
        int H;
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        H = CollectionsKt__CollectionsKt.H(list);
        return list.remove(H);
    }

    public static <T> boolean N0(@NotNull Iterable<? extends T> iterable, @NotNull d2.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        return r0(iterable, predicate, false);
    }

    public static final <T> boolean O0(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        return collection.retainAll(s.d(elements, collection));
    }

    @InlineOnly
    private static final <T> boolean P0(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        return collection.retainAll(elements);
    }

    public static final <T> boolean Q0(@NotNull Collection<? super T> collection, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        Collection<?> b4 = s.b(elements);
        if (!b4.isEmpty()) {
            return collection.retainAll(b4);
        }
        return T0(collection);
    }

    public static final <T> boolean R0(@NotNull Collection<? super T> collection, @NotNull T[] elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (!(elements.length == 0)) {
            return collection.retainAll(s.c(elements));
        }
        return T0(collection);
    }

    public static final <T> boolean S0(@NotNull List<T> list, @NotNull d2.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        return s0(list, predicate, false);
    }

    private static final boolean T0(Collection<?> collection) {
        boolean z3 = !collection.isEmpty();
        collection.clear();
        return z3;
    }

    public static <T> boolean o0(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        boolean z3 = false;
        for (Object obj : elements) {
            if (collection.add(obj)) {
                z3 = true;
            }
        }
        return z3;
    }

    public static <T> boolean p0(@NotNull Collection<? super T> collection, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        boolean z3 = false;
        for (Object obj : elements) {
            if (collection.add(obj)) {
                z3 = true;
            }
        }
        return z3;
    }

    public static <T> boolean q0(@NotNull Collection<? super T> collection, @NotNull T[] elements) {
        List t3;
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        t3 = o.t(elements);
        return collection.addAll(t3);
    }

    private static final <T> boolean r0(Iterable<? extends T> iterable, d2.l<? super T, Boolean> lVar, boolean z3) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            if (lVar.invoke((T) it.next()).booleanValue() == z3) {
                it.remove();
                z4 = true;
            }
        }
        return z4;
    }

    private static final <T> boolean s0(List<T> list, d2.l<? super T, Boolean> lVar, boolean z3) {
        int H;
        int i4;
        int H2;
        if (!(list instanceof RandomAccess)) {
            return r0(list, lVar, z3);
        }
        H = CollectionsKt__CollectionsKt.H(list);
        if (H >= 0) {
            int i5 = 0;
            i4 = 0;
            while (true) {
                int i6 = i5 + 1;
                T t3 = list.get(i5);
                if (lVar.invoke(t3).booleanValue() != z3) {
                    if (i4 != i5) {
                        list.set(i4, t3);
                    }
                    i4++;
                }
                if (i5 == H) {
                    break;
                }
                i5 = i6;
            }
        } else {
            i4 = 0;
        }
        if (i4 >= list.size()) {
            return false;
        }
        H2 = CollectionsKt__CollectionsKt.H(list);
        if (i4 > H2) {
            return true;
        }
        while (true) {
            int i7 = H2 - 1;
            list.remove(H2);
            if (H2 == i4) {
                return true;
            }
            H2 = i7;
        }
    }

    @InlineOnly
    private static final <T> void t0(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        E0(collection, elements);
    }

    @InlineOnly
    private static final <T> void u0(Collection<? super T> collection, T t3) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        collection.remove(t3);
    }

    @InlineOnly
    private static final <T> void v0(Collection<? super T> collection, kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        G0(collection, elements);
    }

    @InlineOnly
    private static final <T> void w0(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        H0(collection, elements);
    }

    @InlineOnly
    private static final <T> void x0(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        o0(collection, elements);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> void y0(Collection<? super T> collection, T t3) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        collection.add(t3);
    }

    @InlineOnly
    private static final <T> void z0(Collection<? super T> collection, kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        p0(collection, elements);
    }
}
