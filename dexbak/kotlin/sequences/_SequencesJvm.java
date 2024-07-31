package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001aC\u0010\b\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\b\u0010\t\u001a&\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\n*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a8\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u000f\u001a7\u0010\u0014\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00120\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0017\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, m12616d2 = {"R", "Lkotlin/sequences/m;", "Ljava/lang/Class;", "klass", "x", "", "C", RtspHeaders.Values.DESTINATION, "y", "(Lkotlin/sequences/m;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/SortedSet;", "B", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", UMCommonContent.f37777aG, "(Lkotlin/sequences/m;Ll1/l;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlin/sequences/m;Ll1/l;)Ljava/math/BigInteger;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/sequences/SequencesKt")
/* renamed from: kotlin.sequences.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class _SequencesJvm extends C14520s {

    /* compiled from: _SequencesJvm.kt */
    @Metadata(m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, m12616d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.t$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14531a extends Lambda implements InterfaceC15280l<Object, Boolean> {

        /* renamed from: a */
        final /* synthetic */ Class f41502a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14531a(Class cls) {
            super(1);
            this.f41502a = cls;
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2(@Nullable Object obj) {
            return this.f41502a.isInstance(obj);
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: A */
    private static final <T> BigInteger m6972A(Sequence<? extends T> sequence, InterfaceC15280l<? super T, ? extends BigInteger> interfaceC15280l) {
        BigInteger valueOf = BigInteger.valueOf(0);
        C14342f0.m8185o(valueOf, "BigInteger.valueOf(this.toLong())");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(interfaceC15280l.invoke((T) it.next()));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    /* renamed from: B */
    public static final <T extends Comparable<? super T>> SortedSet<T> m6971B(@NotNull Sequence<? extends T> toSortedSet) {
        C14342f0.m8184p(toSortedSet, "$this$toSortedSet");
        return (SortedSet) _Sequences.m7197T2(toSortedSet, new TreeSet());
    }

    @NotNull
    /* renamed from: C */
    public static final <T> SortedSet<T> m6970C(@NotNull Sequence<? extends T> toSortedSet, @NotNull Comparator<? super T> comparator) {
        C14342f0.m8184p(toSortedSet, "$this$toSortedSet");
        C14342f0.m8184p(comparator, "comparator");
        return (SortedSet) _Sequences.m7197T2(toSortedSet, new TreeSet(comparator));
    }

    @NotNull
    /* renamed from: x */
    public static final <R> Sequence<R> m6969x(@NotNull Sequence<?> filterIsInstance, @NotNull Class<R> klass) {
        Sequence<R> m7140i0;
        C14342f0.m8184p(filterIsInstance, "$this$filterIsInstance");
        C14342f0.m8184p(klass, "klass");
        m7140i0 = _Sequences.m7140i0(filterIsInstance, new C14531a(klass));
        if (m7140i0 != null) {
            return m7140i0;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    @NotNull
    /* renamed from: y */
    public static final <C extends Collection<? super R>, R> C m6968y(@NotNull Sequence<?> filterIsInstanceTo, @NotNull C destination, @NotNull Class<R> klass) {
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

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: z */
    private static final <T> BigDecimal m6967z(Sequence<? extends T> sequence, InterfaceC15280l<? super T, ? extends BigDecimal> interfaceC15280l) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        C14342f0.m8185o(valueOf, "BigDecimal.valueOf(this.toLong())");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(interfaceC15280l.invoke((T) it.next()));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }
}
