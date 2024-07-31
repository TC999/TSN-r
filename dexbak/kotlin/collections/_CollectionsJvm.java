package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import io.netty.handler.codec.rtsp.RtspHeaders;
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
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000N\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001aC\u0010\t\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0016\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f\u001a&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u000f*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a8\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0014\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0012j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0013\u001a7\u0010\u0019\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a7\u0010\u001c\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, m12616d2 = {"R", "", "Ljava/lang/Class;", "klass", "", "c1", "", "C", RtspHeaders.Values.DESTINATION, "d1", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/f1;", "e1", "", "Ljava/util/SortedSet;", "h1", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "i1", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "f1", "(Ljava/lang/Iterable;Ll1/l;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "g1", "(Ljava/lang/Iterable;Ll1/l;)Ljava/math/BigInteger;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.d0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class _CollectionsJvm extends ReversedViews {
    @NotNull
    /* renamed from: c1 */
    public static final <R> List<R> m12297c1(@NotNull Iterable<?> filterIsInstance, @NotNull Class<R> klass) {
        C14342f0.m8184p(filterIsInstance, "$this$filterIsInstance");
        C14342f0.m8184p(klass, "klass");
        return (List) m12296d1(filterIsInstance, new ArrayList(), klass);
    }

    @NotNull
    /* renamed from: d1 */
    public static final <C extends Collection<? super R>, R> C m12296d1(@NotNull Iterable<?> filterIsInstanceTo, @NotNull C destination, @NotNull Class<R> klass) {
        C14342f0.m8184p(filterIsInstanceTo, "$this$filterIsInstanceTo");
        C14342f0.m8184p(destination, "destination");
        C14342f0.m8184p(klass, "klass");
        for (Object obj : filterIsInstanceTo) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* renamed from: e1 */
    public static <T> void m12295e1(@NotNull List<T> reverse) {
        C14342f0.m8184p(reverse, "$this$reverse");
        Collections.reverse(reverse);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: f1 */
    private static final <T> BigDecimal m12294f1(Iterable<? extends T> iterable, InterfaceC15280l<? super T, ? extends BigDecimal> interfaceC15280l) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        C14342f0.m8185o(valueOf, "BigDecimal.valueOf(this.toLong())");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(interfaceC15280l.invoke((T) it.next()));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: g1 */
    private static final <T> BigInteger m12293g1(Iterable<? extends T> iterable, InterfaceC15280l<? super T, ? extends BigInteger> interfaceC15280l) {
        BigInteger valueOf = BigInteger.valueOf(0);
        C14342f0.m8185o(valueOf, "BigInteger.valueOf(this.toLong())");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(interfaceC15280l.invoke((T) it.next()));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    /* renamed from: h1 */
    public static final <T extends Comparable<? super T>> SortedSet<T> m12292h1(@NotNull Iterable<? extends T> toSortedSet) {
        C14342f0.m8184p(toSortedSet, "$this$toSortedSet");
        return (SortedSet) _Collections.m12258D5(toSortedSet, new TreeSet());
    }

    @NotNull
    /* renamed from: i1 */
    public static final <T> SortedSet<T> m12291i1(@NotNull Iterable<? extends T> toSortedSet, @NotNull Comparator<? super T> comparator) {
        C14342f0.m8184p(toSortedSet, "$this$toSortedSet");
        C14342f0.m8184p(comparator, "comparator");
        return (SortedSet) _Collections.m12258D5(toSortedSet, new TreeSet(comparator));
    }
}
