package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.SetBuilder;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SetsJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0081\b\u00f8\u0001\u0000\u001a?\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\f2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0081\b\u00f8\u0001\u0000\u001a\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0005H\u0001\u001a\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\fH\u0001\u001a\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0001\u001a-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001aI\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u001a\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0018j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u00192\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001d"}, d2 = {"T", "element", "", "f", "(Ljava/lang/Object;)Ljava/util/Set;", "E", "Lkotlin/Function1;", "", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "c", "", "capacity", "b", "d", "e", "builder", "a", "", "elements", "Ljava/util/TreeSet;", "h", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "g", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/SetsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i1 {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> Set<E> a(@NotNull Set<E> builder) {
        kotlin.jvm.internal.f0.p(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> b(int i4, d2.l<? super Set<E>, kotlin.f1> builderAction) {
        Set e4;
        Set<E> a4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        e4 = e(i4);
        builderAction.invoke(e4);
        a4 = a(e4);
        return a4;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> c(d2.l<? super Set<E>, kotlin.f1> builderAction) {
        Set<E> a4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Set d4 = d();
        builderAction.invoke(d4);
        a4 = a(d4);
        return a4;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final <E> Set<E> d() {
        return new SetBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> Set<E> e(int i4) {
        return new SetBuilder(i4);
    }

    @NotNull
    public static <T> Set<T> f(T t3) {
        Set<T> singleton = Collections.singleton(t3);
        kotlin.jvm.internal.f0.o(singleton, "singleton(element)");
        return singleton;
    }

    @NotNull
    public static final <T> TreeSet<T> g(@NotNull Comparator<? super T> comparator, @NotNull T... elements) {
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(elements, "elements");
        return (TreeSet) p.Jx(elements, new TreeSet(comparator));
    }

    @NotNull
    public static final <T> TreeSet<T> h(@NotNull T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return (TreeSet) p.Jx(elements, new TreeSet());
    }
}
