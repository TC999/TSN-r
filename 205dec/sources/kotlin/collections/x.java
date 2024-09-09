package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CollectionsJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0081\b\u00f8\u0001\u0000\u001a?\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\f2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0081\b\u00f8\u0001\u0000\u001a\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0005H\u0001\u001a\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\fH\u0001\u001a\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0001\u001a\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0087\b\u001a\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0007\u001a&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0007\u001a$\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0081\b\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a6\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\u0004\b\u0000\u0010\u00002\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0081\b\u00a2\u0006\u0004\b!\u0010\"\u001a3\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001d0\u001c\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001c2\u0006\u0010$\u001a\u00020#H\u0000\u00a2\u0006\u0004\b%\u0010&\u001a\u0011\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0081\b\u001a\u0011\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0081\b\u001a\t\u0010+\u001a\u00020#H\u0080\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006,"}, d2 = {"T", "element", "", "l", "(Ljava/lang/Object;)Ljava/util/List;", "E", "Lkotlin/Function1;", "", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "d", "", "capacity", "c", "j", "k", "builder", "b", "Ljava/util/Enumeration;", "o", "", "m", "Ljava/util/Random;", "random", "n", "", "collection", "", "", "g", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "h", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "isVarargs", "i", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "index", "f", "count", "e", "a", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class x {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004"}, d2 = {"kotlin/collections/x$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a<T> implements Iterable<T>, m1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l1.a f55462a;

        public a(l1.a aVar) {
            this.f55462a = aVar;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return (Iterator) this.f55462a.invoke();
        }
    }

    public static final boolean a() {
        return v.f55459b;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> b(@NotNull List<E> builder) {
        kotlin.jvm.internal.f0.p(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> c(int i4, d2.l<? super List<E>, kotlin.f1> builderAction) {
        List k4;
        List<E> b4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        k4 = k(i4);
        builderAction.invoke(k4);
        b4 = b(k4);
        return b4;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> d(d2.l<? super List<E>, kotlin.f1> builderAction) {
        List j4;
        List<E> b4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        j4 = j();
        builderAction.invoke(j4);
        b4 = b(j4);
        return b4;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int e(int i4) {
        if (i4 < 0) {
            if (kotlin.internal.b.a(1, 3, 0)) {
                CollectionsKt__CollectionsKt.W();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i4;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int f(int i4) {
        if (i4 < 0) {
            if (kotlin.internal.b.a(1, 3, 0)) {
                CollectionsKt__CollectionsKt.X();
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        return i4;
    }

    @InlineOnly
    private static final Object[] g(Collection<?> collection) {
        kotlin.jvm.internal.f0.p(collection, "collection");
        return kotlin.jvm.internal.t.a(collection);
    }

    @InlineOnly
    private static final <T> T[] h(Collection<?> collection, T[] array) {
        kotlin.jvm.internal.f0.p(collection, "collection");
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) kotlin.jvm.internal.t.b(collection, array);
    }

    @NotNull
    public static final <T> Object[] i(@NotNull T[] tArr, boolean z3) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (z3 && kotlin.jvm.internal.f0.g(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.f0.o(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> j() {
        return new ListBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> k(int i4) {
        return new ListBuilder(i4);
    }

    @NotNull
    public static <T> List<T> l(T t3) {
        List<T> singletonList = Collections.singletonList(t3);
        kotlin.jvm.internal.f0.o(singletonList, "singletonList(element)");
        return singletonList;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> m(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        List<T> I5 = f0.I5(iterable);
        Collections.shuffle(I5);
        return I5;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> n(@NotNull Iterable<? extends T> iterable, @NotNull Random random) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        List<T> I5 = f0.I5(iterable);
        Collections.shuffle(I5, random);
        return I5;
    }

    @InlineOnly
    private static final <T> List<T> o(Enumeration<T> enumeration) {
        kotlin.jvm.internal.f0.p(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        kotlin.jvm.internal.f0.o(list, "list(this)");
        return list;
    }
}
