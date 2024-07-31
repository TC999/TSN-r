package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\r\u001a/\u0010\u0005\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a.\u0010\t\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087\b\u001a.\u0010\n\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087\b\u001a*\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\f\u0010\r\u001a)\u0010\u000f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\n\u001a0\u0010\u0011\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0012\u001a)\u0010\u0014\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0087\n\u001a*\u0010\u0015\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\u0015\u0010\r\u001a)\u0010\u0016\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\n\u001a0\u0010\u0017\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0087\n¢\u0006\u0004\b\u0017\u0010\u0012\u001a)\u0010\u0018\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0087\n\u001a&\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u001a&\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u001a/\u0010\u001b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u001d\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u001a&\u0010\u001e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u001a/\u0010\u001f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u001f\u0010\u001c\u001a&\u0010 \u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u001a/\u0010!\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0004\b!\u0010\u001c\u001a&\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u001a\u0017\u0010#\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b#\u0010$\u001a*\u0010(\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&\u001a*\u0010)\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&\u001a;\u0010+\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010,\u001a(\u00100\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010/\u001a\u00020.H\u0087\b¢\u0006\u0004\b0\u00101\u001a\u001f\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-H\u0007¢\u0006\u0004\b2\u00103\u001a!\u00104\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-H\u0007¢\u0006\u0004\b4\u00103\u001a\u001f\u00105\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-H\u0007¢\u0006\u0004\b5\u00103\u001a!\u00106\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-H\u0007¢\u0006\u0004\b6\u00103\u001a*\u00107\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&\u001a*\u00108\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&\u001a;\u00109\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000-2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b9\u0010:¨\u0006;"}, m12616d2 = {"Lkotlin/internal/OnlyInputTypes;", ExifInterface.GPS_DIRECTION_TRUE, "", "element", "", "E0", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "", "elements", "H0", "R0", "Lkotlin/f1;", "A0", "(Ljava/util/Collection;Ljava/lang/Object;)V", "", "z0", "", "C0", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "Lkotlin/sequences/m;", "B0", "w0", "v0", "y0", "x0", "q0", "r0", "s0", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "G0", "I0", "J0", "Q0", "T0", "S0", "V0", "(Ljava/util/Collection;)Z", "", "Lkotlin/Function1;", "predicate", "F0", "P0", "predicateResultToRemove", "t0", "(Ljava/lang/Iterable;Ll1/l;Z)Z", "", "", "index", "D0", "(Ljava/util/List;I)Ljava/lang/Object;", "L0", "(Ljava/util/List;)Ljava/lang/Object;", "M0", "N0", "O0", "K0", "U0", "u0", "(Ljava/util/List;Ll1/l;Z)Z", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.b0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MutableCollections extends MutableCollectionsJVM {
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: A0 */
    private static final <T> void m12438A0(Collection<? super T> plusAssign, T t) {
        C14342f0.m8184p(plusAssign, "$this$plusAssign");
        plusAssign.add(t);
    }

    @InlineOnly
    /* renamed from: B0 */
    private static final <T> void m12437B0(Collection<? super T> plusAssign, Sequence<? extends T> sequence) {
        C14342f0.m8184p(plusAssign, "$this$plusAssign");
        m12415r0(plusAssign, sequence);
    }

    @InlineOnly
    /* renamed from: C0 */
    private static final <T> void m12436C0(Collection<? super T> plusAssign, T[] tArr) {
        C14342f0.m8184p(plusAssign, "$this$plusAssign");
        m12414s0(plusAssign, tArr);
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    @InlineOnly
    /* renamed from: D0 */
    private static final <T> T m12435D0(List<T> list, int i) {
        return list.remove(i);
    }

    @InlineOnly
    /* renamed from: E0 */
    private static final <T> boolean m12434E0(Collection<? extends T> collection, T t) {
        if (collection != null) {
            return TypeIntrinsics.m8026a(collection).remove(t);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    /* renamed from: F0 */
    public static final <T> boolean m12433F0(@NotNull Iterable<? extends T> removeAll, @NotNull InterfaceC15280l<? super T, Boolean> predicate) {
        C14342f0.m8184p(removeAll, "$this$removeAll");
        C14342f0.m8184p(predicate, "predicate");
        return m12413t0(removeAll, predicate, true);
    }

    /* renamed from: G0 */
    public static final <T> boolean m12432G0(@NotNull Collection<? super T> removeAll, @NotNull Iterable<? extends T> elements) {
        C14342f0.m8184p(removeAll, "$this$removeAll");
        C14342f0.m8184p(elements, "elements");
        return TypeIntrinsics.m8026a(removeAll).removeAll(C14236x.m8954b0(elements, removeAll));
    }

    @InlineOnly
    /* renamed from: H0 */
    private static final <T> boolean m12431H0(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return TypeIntrinsics.m8026a(collection).removeAll(collection2);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    /* renamed from: I0 */
    public static final <T> boolean m12430I0(@NotNull Collection<? super T> removeAll, @NotNull Sequence<? extends T> elements) {
        HashSet m7193U2;
        C14342f0.m8184p(removeAll, "$this$removeAll");
        C14342f0.m8184p(elements, "elements");
        m7193U2 = _Sequences.m7193U2(elements);
        return (m7193U2.isEmpty() ^ true) && removeAll.removeAll(m7193U2);
    }

    /* renamed from: J0 */
    public static final <T> boolean m12429J0(@NotNull Collection<? super T> removeAll, @NotNull T[] elements) {
        HashSet m10799Ux;
        C14342f0.m8184p(removeAll, "$this$removeAll");
        C14342f0.m8184p(elements, "elements");
        if (!(elements.length == 0)) {
            m10799Ux = _Arrays.m10799Ux(elements);
            return removeAll.removeAll(m10799Ux);
        }
        return false;
    }

    /* renamed from: K0 */
    public static final <T> boolean m12428K0(@NotNull List<T> removeAll, @NotNull InterfaceC15280l<? super T, Boolean> predicate) {
        C14342f0.m8184p(removeAll, "$this$removeAll");
        C14342f0.m8184p(predicate, "predicate");
        return m12412u0(removeAll, predicate, true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: L0 */
    public static final <T> T m12427L0(@NotNull List<T> removeFirst) {
        C14342f0.m8184p(removeFirst, "$this$removeFirst");
        if (removeFirst.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return removeFirst.remove(0);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    /* renamed from: M0 */
    public static final <T> T m12426M0(@NotNull List<T> removeFirstOrNull) {
        C14342f0.m8184p(removeFirstOrNull, "$this$removeFirstOrNull");
        if (removeFirstOrNull.isEmpty()) {
            return null;
        }
        return removeFirstOrNull.remove(0);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: N0 */
    public static <T> T m12425N0(@NotNull List<T> removeLast) {
        int m12476G;
        C14342f0.m8184p(removeLast, "$this$removeLast");
        if (removeLast.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        m12476G = CollectionsKt__CollectionsKt.m12476G(removeLast);
        return removeLast.remove(m12476G);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    /* renamed from: O0 */
    public static final <T> T m12424O0(@NotNull List<T> removeLastOrNull) {
        int m12476G;
        C14342f0.m8184p(removeLastOrNull, "$this$removeLastOrNull");
        if (removeLastOrNull.isEmpty()) {
            return null;
        }
        m12476G = CollectionsKt__CollectionsKt.m12476G(removeLastOrNull);
        return removeLastOrNull.remove(m12476G);
    }

    /* renamed from: P0 */
    public static <T> boolean m12423P0(@NotNull Iterable<? extends T> retainAll, @NotNull InterfaceC15280l<? super T, Boolean> predicate) {
        C14342f0.m8184p(retainAll, "$this$retainAll");
        C14342f0.m8184p(predicate, "predicate");
        return m12413t0(retainAll, predicate, false);
    }

    /* renamed from: Q0 */
    public static final <T> boolean m12422Q0(@NotNull Collection<? super T> retainAll, @NotNull Iterable<? extends T> elements) {
        C14342f0.m8184p(retainAll, "$this$retainAll");
        C14342f0.m8184p(elements, "elements");
        return TypeIntrinsics.m8026a(retainAll).retainAll(C14236x.m8954b0(elements, retainAll));
    }

    @InlineOnly
    /* renamed from: R0 */
    private static final <T> boolean m12421R0(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return TypeIntrinsics.m8026a(collection).retainAll(collection2);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    /* renamed from: S0 */
    public static final <T> boolean m12420S0(@NotNull Collection<? super T> retainAll, @NotNull Sequence<? extends T> elements) {
        HashSet m7193U2;
        C14342f0.m8184p(retainAll, "$this$retainAll");
        C14342f0.m8184p(elements, "elements");
        m7193U2 = _Sequences.m7193U2(elements);
        if (!m7193U2.isEmpty()) {
            return retainAll.retainAll(m7193U2);
        }
        return m12417V0(retainAll);
    }

    /* renamed from: T0 */
    public static final <T> boolean m12419T0(@NotNull Collection<? super T> retainAll, @NotNull T[] elements) {
        HashSet m10799Ux;
        C14342f0.m8184p(retainAll, "$this$retainAll");
        C14342f0.m8184p(elements, "elements");
        if (!(elements.length == 0)) {
            m10799Ux = _Arrays.m10799Ux(elements);
            return retainAll.retainAll(m10799Ux);
        }
        return m12417V0(retainAll);
    }

    /* renamed from: U0 */
    public static final <T> boolean m12418U0(@NotNull List<T> retainAll, @NotNull InterfaceC15280l<? super T, Boolean> predicate) {
        C14342f0.m8184p(retainAll, "$this$retainAll");
        C14342f0.m8184p(predicate, "predicate");
        return m12412u0(retainAll, predicate, false);
    }

    /* renamed from: V0 */
    private static final boolean m12417V0(Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    /* renamed from: q0 */
    public static <T> boolean m12416q0(@NotNull Collection<? super T> addAll, @NotNull Iterable<? extends T> elements) {
        C14342f0.m8184p(addAll, "$this$addAll");
        C14342f0.m8184p(elements, "elements");
        if (elements instanceof Collection) {
            return addAll.addAll((Collection) elements);
        }
        boolean z = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (addAll.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: r0 */
    public static <T> boolean m12415r0(@NotNull Collection<? super T> addAll, @NotNull Sequence<? extends T> elements) {
        C14342f0.m8184p(addAll, "$this$addAll");
        C14342f0.m8184p(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (addAll.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: s0 */
    public static <T> boolean m12414s0(@NotNull Collection<? super T> addAll, @NotNull T[] elements) {
        List m11537t;
        C14342f0.m8184p(addAll, "$this$addAll");
        C14342f0.m8184p(elements, "elements");
        m11537t = _ArraysJvm.m11537t(elements);
        return addAll.addAll(m11537t);
    }

    /* renamed from: t0 */
    private static final <T> boolean m12413t0(Iterable<? extends T> iterable, InterfaceC15280l<? super T, Boolean> interfaceC15280l, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (interfaceC15280l.invoke((T) it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    /* renamed from: u0 */
    private static final <T> boolean m12412u0(List<T> list, InterfaceC15280l<? super T, Boolean> interfaceC15280l, boolean z) {
        int m12476G;
        int i;
        int m12476G2;
        if (!(list instanceof RandomAccess)) {
            if (list != null) {
                return m12413t0(TypeIntrinsics.m8024c(list), interfaceC15280l, z);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        }
        m12476G = CollectionsKt__CollectionsKt.m12476G(list);
        if (m12476G >= 0) {
            int i2 = 0;
            i = 0;
            while (true) {
                T t = list.get(i2);
                if (interfaceC15280l.invoke(t).booleanValue() != z) {
                    if (i != i2) {
                        list.set(i, t);
                    }
                    i++;
                }
                if (i2 == m12476G) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        m12476G2 = CollectionsKt__CollectionsKt.m12476G(list);
        if (m12476G2 < i) {
            return true;
        }
        while (true) {
            list.remove(m12476G2);
            if (m12476G2 == i) {
                return true;
            }
            m12476G2--;
        }
    }

    @InlineOnly
    /* renamed from: v0 */
    private static final <T> void m12411v0(Collection<? super T> minusAssign, Iterable<? extends T> iterable) {
        C14342f0.m8184p(minusAssign, "$this$minusAssign");
        m12432G0(minusAssign, iterable);
    }

    @InlineOnly
    /* renamed from: w0 */
    private static final <T> void m12410w0(Collection<? super T> minusAssign, T t) {
        C14342f0.m8184p(minusAssign, "$this$minusAssign");
        minusAssign.remove(t);
    }

    @InlineOnly
    /* renamed from: x0 */
    private static final <T> void m12409x0(Collection<? super T> minusAssign, Sequence<? extends T> sequence) {
        C14342f0.m8184p(minusAssign, "$this$minusAssign");
        m12430I0(minusAssign, sequence);
    }

    @InlineOnly
    /* renamed from: y0 */
    private static final <T> void m12408y0(Collection<? super T> minusAssign, T[] tArr) {
        C14342f0.m8184p(minusAssign, "$this$minusAssign");
        m12429J0(minusAssign, tArr);
    }

    @InlineOnly
    /* renamed from: z0 */
    private static final <T> void m12407z0(Collection<? super T> plusAssign, Iterable<? extends T> iterable) {
        C14342f0.m8184p(plusAssign, "$this$plusAssign");
        m12416q0(plusAssign, iterable);
    }
}
