package kotlin.sequences;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _SequencesJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001aC\u0010\b\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\t\u001a&\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\n*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a8\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u000f\u001a7\u0010\u0014\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00120\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0017\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0019"}, d2 = {"R", "Lkotlin/sequences/m;", "Ljava/lang/Class;", "klass", "x", "", "C", "destination", "y", "(Lkotlin/sequences/m;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "", "T", "Ljava/util/SortedSet;", "B", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "z", "(Lkotlin/sequences/m;Ld2/l;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "A", "(Lkotlin/sequences/m;Ld2/l;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class t extends s {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: _SequencesJvm.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class<R> f58853a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class<R> cls) {
            super(1);
            this.f58853a = cls;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d2.l
        @NotNull
        public final Boolean invoke(@Nullable Object obj) {
            return Boolean.valueOf(this.f58853a.isInstance(obj));
        }
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigInteger A(m<? extends T> mVar, d2.l<? super T, ? extends BigInteger> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        for (Object obj : mVar) {
            valueOf = valueOf.add(selector.invoke(obj));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> B(@NotNull m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return (SortedSet) SequencesKt___SequencesKt.T2(mVar, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> C(@NotNull m<? extends T> mVar, @NotNull Comparator<? super T> comparator) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        return (SortedSet) SequencesKt___SequencesKt.T2(mVar, new TreeSet(comparator));
    }

    @NotNull
    public static final <R> m<R> x(@NotNull m<?> mVar, @NotNull Class<R> klass) {
        m<R> i02;
        f0.p(mVar, "<this>");
        f0.p(klass, "klass");
        i02 = SequencesKt___SequencesKt.i0(mVar, new a(klass));
        return i02;
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C y(@NotNull m<?> mVar, @NotNull C destination, @NotNull Class<R> klass) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(klass, "klass");
        for (Object obj : mVar) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal z(m<? extends T> mVar, d2.l<? super T, ? extends BigDecimal> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        for (Object obj : mVar) {
            valueOf = valueOf.add(selector.invoke(obj));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }
}
