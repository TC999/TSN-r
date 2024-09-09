package kotlin.collections;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Collections.kt */
@Metadata(bv = {}, d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000\u00a2\u0006\u0004\b\u0010\u0010\t\u001a7\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00132\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0017\u0010\t\u001aC\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0019\u001a\u00020\u00182!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00028\u00000\u001aH\u0087\b\u00f8\u0001\u0000\u001aC\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0019\u001a\u00020\u00182!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00028\u00000\u001aH\u0087\b\u00f8\u0001\u0000\u001aF\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010!2\u001f\b\u0001\u0010$\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\"0\u001a\u00a2\u0006\u0002\b#H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aN\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010!2\u0006\u0010&\u001a\u00020\u00182\u001f\b\u0001\u0010$\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\"0\u001a\u00a2\u0006\u0002\b#H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0019\u0010)\u001a\u00020(\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b\u001a,\u0010*\u001a\u00020(\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a!\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0087\b\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0087\b\u001a=\u0010/\u001a\u00028\u0001\"\u0010\b\u0000\u0010'*\u0006\u0012\u0002\b\u00030\u0002*\u00028\u0001\"\u0004\b\u0001\u0010,*\u00028\u00002\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010-H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u00100\u001a,\u0010!\u001a\u00020(\"\t\b\u0000\u0010\u0000\u00a2\u0006\u0002\b1*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b\u001a&\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u0000022\u0006\u00104\u001a\u000203H\u0007\u001a\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000\u001aG\u00109\u001a\u00020\u0018\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u000006*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\b\u0010\u0014\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u0018\u00a2\u0006\u0004\b9\u0010:\u001aU\u0010>\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0014\u001a\u00028\u00002\u001a\u0010=\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000;j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`<2\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u0018\u00a2\u0006\u0004\b>\u0010?\u001ai\u0010B\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010**\b\u0012\u0004\u0012\u00028\u000106*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0010@\u001a\u0004\u0018\u00018\u00012\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u00182\u0016\b\u0004\u0010A\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u001aH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010C\u001a>\u0010E\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u00182\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001a\u001a'\u0010F\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u0018H\u0002\u00a2\u0006\u0004\bF\u0010G\u001a\b\u0010H\u001a\u00020\"H\u0001\u001a\b\u0010I\u001a\u00020\"H\u0001\"\u0019\u0010M\u001a\u00020J*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\bK\u0010L\"!\u0010P\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00058F\u00a2\u0006\u0006\u001a\u0004\bN\u0010O\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006Q"}, d2 = {"T", "", "", "t", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "F", "elements", "M", "([Ljava/lang/Object;)Ljava/util/List;", "L", "", "P", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "r", "Q", "s", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "", "element", "N", "(Ljava/lang/Object;)Ljava/util/List;", "O", "", "size", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "init", "p", CampaignEx.JSON_KEY_AD_Q, "E", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "D", "capacity", "C", "", "J", "K", "S", "R", "Lkotlin/Function0;", "defaultValue", "I", "(Ljava/util/Collection;Ld2/a;)Ljava/lang/Object;", "Lkotlin/internal/OnlyInputTypes;", "", "Lkotlin/random/Random;", "random", "V", "", "fromIndex", "toIndex", "v", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "w", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", DomainCampaignEx.LOOPBACK_KEY, "selector", "A", "(Ljava/util/List;Ljava/lang/Comparable;IILd2/l;)I", "comparison", "u", "U", "(III)V", "X", "W", "Lkotlin/ranges/k;", "G", "(Ljava/util/Collection;)Lkotlin/ranges/k;", "indices", "H", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class CollectionsKt__CollectionsKt extends x {
    public static final <T, K extends Comparable<? super K>> int A(@NotNull List<? extends T> list, @Nullable K k4, int i4, int i5, @NotNull d2.l<? super T, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return u(list, i4, i5, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, k4));
    }

    public static /* synthetic */ int B(List list, Comparable comparable, int i4, int i5, d2.l lVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = list.size();
        }
        return u(list, i4, i5, new CollectionsKt__CollectionsKt$binarySearchBy$1(lVar, comparable));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> List<E> C(int i4, @BuilderInference d2.l<? super List<E>, kotlin.f1> builderAction) {
        List k4;
        List<E> b4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        k4 = x.k(i4);
        builderAction.invoke(k4);
        b4 = x.b(k4);
        return b4;
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> List<E> D(@BuilderInference d2.l<? super List<E>, kotlin.f1> builderAction) {
        List j4;
        List<E> b4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        j4 = x.j();
        builderAction.invoke(j4);
        b4 = x.b(j4);
        return b4;
    }

    @InlineOnly
    private static final <T> boolean E(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        return collection.containsAll(elements);
    }

    @NotNull
    public static <T> List<T> F() {
        return EmptyList.INSTANCE;
    }

    @NotNull
    public static kotlin.ranges.k G(@NotNull Collection<?> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return new kotlin.ranges.k(0, collection.size() - 1);
    }

    public static <T> int H(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.size() - 1;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object I(Collection collection, d2.a defaultValue) {
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return collection.isEmpty() ? defaultValue.invoke() : collection;
    }

    @InlineOnly
    private static final <T> boolean J(Collection<? extends T> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return !collection.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> boolean K(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @InlineOnly
    private static final <T> List<T> L() {
        List<T> F;
        F = F();
        return F;
    }

    @NotNull
    public static <T> List<T> M(@NotNull T... elements) {
        List<T> F;
        List<T> t3;
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (elements.length > 0) {
            t3 = o.t(elements);
            return t3;
        }
        F = F();
        return F;
    }

    @NotNull
    public static <T> List<T> N(@Nullable T t3) {
        List<T> F;
        List<T> l4;
        if (t3 != null) {
            l4 = x.l(t3);
            return l4;
        }
        F = F();
        return F;
    }

    @NotNull
    public static <T> List<T> O(@NotNull T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return p.qa(elements);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> P() {
        return new ArrayList();
    }

    @NotNull
    public static <T> List<T> Q(@NotNull T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new j(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> R(@NotNull List<? extends T> list) {
        List<T> F;
        List<T> l4;
        kotlin.jvm.internal.f0.p(list, "<this>");
        int size = list.size();
        if (size == 0) {
            F = F();
            return F;
        } else if (size != 1) {
            return list;
        } else {
            l4 = x.l(list.get(0));
            return l4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Collection<T> S(Collection<? extends T> collection) {
        List F;
        if (collection == 0) {
            F = F();
            return F;
        }
        return collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> List<T> T(List<? extends T> list) {
        List<T> F;
        if (list == 0) {
            F = F();
            return F;
        }
        return list;
    }

    private static final void U(int i4, int i5, int i6) {
        if (i5 > i6) {
            throw new IllegalArgumentException("fromIndex (" + i5 + ") is greater than toIndex (" + i6 + ").");
        } else if (i5 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i5 + ") is less than zero.");
        } else if (i6 <= i4) {
        } else {
            throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is greater than size (" + i4 + ").");
        }
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> List<T> V(@NotNull Iterable<? extends T> iterable, @NotNull Random random) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        List<T> I5 = f0.I5(iterable);
        f0.P4(I5, random);
        return I5;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void W() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void X() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> p(int i4, d2.l<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.f0.p(init, "init");
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList.add(init.invoke(Integer.valueOf(i5)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> q(int i4, d2.l<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.f0.p(init, "init");
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList.add(init.invoke(Integer.valueOf(i5)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> ArrayList<T> r() {
        return new ArrayList<>();
    }

    @NotNull
    public static final <T> ArrayList<T> s(@NotNull T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new j(elements, true));
    }

    @NotNull
    public static final <T> Collection<T> t(@NotNull T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return new j(tArr, false);
    }

    public static final <T> int u(@NotNull List<? extends T> list, int i4, int i5, @NotNull d2.l<? super T, Integer> comparison) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparison, "comparison");
        U(list.size(), i4, i5);
        int i6 = i5 - 1;
        while (i4 <= i6) {
            int i7 = (i4 + i6) >>> 1;
            int intValue = comparison.invoke((T) list.get(i7)).intValue();
            if (intValue < 0) {
                i4 = i7 + 1;
            } else if (intValue <= 0) {
                return i7;
            } else {
                i6 = i7 - 1;
            }
        }
        return -(i4 + 1);
    }

    public static final <T extends Comparable<? super T>> int v(@NotNull List<? extends T> list, @Nullable T t3, int i4, int i5) {
        int g4;
        kotlin.jvm.internal.f0.p(list, "<this>");
        U(list.size(), i4, i5);
        int i6 = i5 - 1;
        while (i4 <= i6) {
            int i7 = (i4 + i6) >>> 1;
            g4 = kotlin.comparisons.b.g(list.get(i7), t3);
            if (g4 < 0) {
                i4 = i7 + 1;
            } else if (g4 <= 0) {
                return i7;
            } else {
                i6 = i7 - 1;
            }
        }
        return -(i4 + 1);
    }

    public static final <T> int w(@NotNull List<? extends T> list, T t3, @NotNull Comparator<? super T> comparator, int i4, int i5) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        U(list.size(), i4, i5);
        int i6 = i5 - 1;
        while (i4 <= i6) {
            int i7 = (i4 + i6) >>> 1;
            int compare = comparator.compare((T) list.get(i7), t3);
            if (compare < 0) {
                i4 = i7 + 1;
            } else if (compare <= 0) {
                return i7;
            } else {
                i6 = i7 - 1;
            }
        }
        return -(i4 + 1);
    }

    public static /* synthetic */ int x(List list, int i4, int i5, d2.l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = list.size();
        }
        return u(list, i4, i5, lVar);
    }

    public static /* synthetic */ int y(List list, Comparable comparable, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = list.size();
        }
        return v(list, comparable, i4, i5);
    }

    public static /* synthetic */ int z(List list, Object obj, Comparator comparator, int i4, int i5, int i6, Object obj2) {
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = list.size();
        }
        return w(list, obj, comparator, i4, i5);
    }
}
