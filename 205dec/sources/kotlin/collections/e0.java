package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: _CollectionsJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000N\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001aC\u0010\t\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u00a2\u0006\u0004\b\t\u0010\n\u001a\u0016\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f\u001a&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u000f*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a8\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0014\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0012j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0013\u001a7\u0010\u0019\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a7\u0010\u001c\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001e"}, d2 = {"R", "", "Ljava/lang/Class;", "klass", "", "a1", "", "C", "destination", "b1", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "T", "", "Lkotlin/f1;", "c1", "", "Ljava/util/SortedSet;", "f1", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "g1", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "d1", "(Ljava/lang/Iterable;Ld2/l;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "e1", "(Ljava/lang/Iterable;Ld2/l;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e0 extends d0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a<T> implements kotlin.sequences.m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f55310a;

        public a(Iterable iterable) {
            this.f55310a = iterable;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<T> iterator() {
            return this.f55310a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: _Collections.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "", "it", "a", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class b<T> extends Lambda implements l1.l<Integer, T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f55311a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i4) {
            super(1);
            this.f55311a = i4;
        }

        public final T a(int i4) {
            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f55311a + '.');
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    /* compiled from: _Collections.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"kotlin/collections/e0$c", "Lkotlin/collections/j0;", "", "b", "element", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c<K, T> implements j0<T, K> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f55312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.l f55313b;

        public c(Iterable<? extends T> iterable, l1.l lVar) {
            this.f55312a = iterable;
            this.f55313b = lVar;
        }

        public K a(T t3) {
            return (K) this.f55313b.invoke(t3);
        }

        @NotNull
        public Iterator<T> b() {
            return this.f55312a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: _Collections.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class d<T> extends Lambda implements l1.a<Iterator<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f55314a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Iterable iterable) {
            super(0);
            this.f55314a = iterable;
        }

        @NotNull
        /* renamed from: a */
        public final Iterator<T> invoke() {
            return this.f55314a.iterator();
        }
    }

    @NotNull
    public static <R> List<R> a1(@NotNull Iterable<?> iterable, @NotNull Class<R> klass) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(klass, "klass");
        return (List) b1(iterable, new ArrayList(), klass);
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C b1(@NotNull Iterable<?> iterable, @NotNull C destination, @NotNull Class<R> klass) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static <T> void c1(@NotNull List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        Collections.reverse(list);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal d1(Iterable<? extends T> iterable, d2.l<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(valueOf, "valueOf(this.toLong())");
        for (Object obj : iterable) {
            valueOf = valueOf.add(selector.invoke(obj));
            kotlin.jvm.internal.f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigInteger e1(Iterable<? extends T> iterable, d2.l<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(valueOf, "valueOf(this.toLong())");
        for (Object obj : iterable) {
            valueOf = valueOf.add(selector.invoke(obj));
            kotlin.jvm.internal.f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> f1(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return (SortedSet) f0.B5(iterable, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> g1(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return (SortedSet) f0.B5(iterable, new TreeSet(comparator));
    }
}
