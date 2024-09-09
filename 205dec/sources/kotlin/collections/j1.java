package kotlin.collections;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sets.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0012\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\u0006\u001a\u001f\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a7\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0010j\b\u0012\u0004\u0012\u00028\u0000`\u0011\"\u0004\b\u0000\u0010\u0000H\u0087\b\u001a7\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0010j\b\u0012\u0004\u0012\u00028\u0000`\u0011\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00152\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0003\"\u0004\u0018\u00018\u0000H\u0007\u00a2\u0006\u0004\b\u0019\u0010\u0006\u001aF\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u001a2\u001f\b\u0001\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\u001c0\u001b\u00a2\u0006\u0002\b\u001dH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aN\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u001a2\u0006\u0010!\u001a\u00020 2\u001f\b\u0001\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\u001c0\u001b\u00a2\u0006\u0002\b\u001dH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a!\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006%"}, d2 = {"T", "", "k", "", "elements", "u", "([Ljava/lang/Object;)Ljava/util/Set;", "t", "", "p", CampaignEx.JSON_KEY_AD_Q, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "l", "m", "([Ljava/lang/Object;)Ljava/util/HashSet;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "n", "o", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "", "element", "v", "(Ljava/lang/Object;)Ljava/util/Set;", "w", "E", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "j", "", "capacity", "i", "s", "r", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/SetsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class j1 extends i1 {
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> Set<E> i(int i4, @BuilderInference d2.l<? super Set<E>, kotlin.f1> builderAction) {
        Set e4;
        Set<E> a4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        e4 = i1.e(i4);
        builderAction.invoke(e4);
        a4 = i1.a(e4);
        return a4;
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> Set<E> j(@BuilderInference d2.l<? super Set<E>, kotlin.f1> builderAction) {
        Set<E> a4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Set d4 = i1.d();
        builderAction.invoke(d4);
        a4 = i1.a(d4);
        return a4;
    }

    @NotNull
    public static <T> Set<T> k() {
        return EmptySet.INSTANCE;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> HashSet<T> l() {
        return new HashSet<>();
    }

    @NotNull
    public static final <T> HashSet<T> m(@NotNull T... elements) {
        int j4;
        kotlin.jvm.internal.f0.p(elements, "elements");
        j4 = y0.j(elements.length);
        return (HashSet) p.Jx(elements, new HashSet(j4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> LinkedHashSet<T> n() {
        return new LinkedHashSet<>();
    }

    @NotNull
    public static <T> LinkedHashSet<T> o(@NotNull T... elements) {
        int j4;
        kotlin.jvm.internal.f0.p(elements, "elements");
        j4 = y0.j(elements.length);
        return (LinkedHashSet) p.Jx(elements, new LinkedHashSet(j4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> Set<T> p() {
        return new LinkedHashSet();
    }

    @NotNull
    public static <T> Set<T> q(@NotNull T... elements) {
        int j4;
        kotlin.jvm.internal.f0.p(elements, "elements");
        j4 = y0.j(elements.length);
        return (Set) p.Jx(elements, new LinkedHashSet(j4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> Set<T> r(@NotNull Set<? extends T> set) {
        Set<T> k4;
        Set<T> f4;
        kotlin.jvm.internal.f0.p(set, "<this>");
        int size = set.size();
        if (size == 0) {
            k4 = k();
            return k4;
        } else if (size != 1) {
            return set;
        } else {
            f4 = i1.f(set.iterator().next());
            return f4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Set<T> s(Set<? extends T> set) {
        Set<T> k4;
        if (set == 0) {
            k4 = k();
            return k4;
        }
        return set;
    }

    @InlineOnly
    private static final <T> Set<T> t() {
        Set<T> k4;
        k4 = k();
        return k4;
    }

    @NotNull
    public static <T> Set<T> u(@NotNull T... elements) {
        Set<T> k4;
        Set<T> Gy;
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (elements.length > 0) {
            Gy = p.Gy(elements);
            return Gy;
        }
        k4 = k();
        return k4;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> v(@Nullable T t3) {
        Set<T> k4;
        Set<T> f4;
        if (t3 != null) {
            f4 = i1.f(t3);
            return f4;
        }
        k4 = k();
        return k4;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> w(@NotNull T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return (Set) p.ra(elements, new LinkedHashSet());
    }
}
