package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.builders.SetBuilder;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0081\bø\u0001\u0000\u001a?\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\f2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0081\bø\u0001\u0000\u001a\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0005H\u0001\u001a\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\fH\u0001\u001a\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0001\u001a-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aI\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u001a\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0018j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u00192\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "element", "", "f", "(Ljava/lang/Object;)Ljava/util/Set;", ExifInterface.LONGITUDE_EAST, "Lkotlin/Function1;", "", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "c", "", "capacity", "b", "d", "e", "builder", "a", "", "elements", "Ljava/util/TreeSet;", "h", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "g", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/SetsKt")
/* renamed from: kotlin.collections.h1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SetsJVM {
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    /* renamed from: a */
    public static final <E> Set<E> m11994a(@NotNull Set<E> builder) {
        C14342f0.m8184p(builder, "builder");
        return ((SetBuilder) builder).m12319c();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @PublishedApi
    /* renamed from: b */
    private static final <E> Set<E> m11993b(int i, InterfaceC15280l<? super Set<E>, Unit> interfaceC15280l) {
        Set m11990e = m11990e(i);
        interfaceC15280l.invoke(m11990e);
        return m11994a(m11990e);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @PublishedApi
    /* renamed from: c */
    private static final <E> Set<E> m11992c(InterfaceC15280l<? super Set<E>, Unit> interfaceC15280l) {
        Set m11991d = m11991d();
        interfaceC15280l.invoke(m11991d);
        return m11994a(m11991d);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    /* renamed from: d */
    public static final <E> Set<E> m11991d() {
        return new SetBuilder();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    /* renamed from: e */
    public static final <E> Set<E> m11990e(int i) {
        return new SetBuilder(i);
    }

    @NotNull
    /* renamed from: f */
    public static <T> Set<T> m11989f(T t) {
        Set<T> singleton = Collections.singleton(t);
        C14342f0.m8185o(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }

    @NotNull
    /* renamed from: g */
    public static final <T> TreeSet<T> m11988g(@NotNull Comparator<? super T> comparator, @NotNull T... elements) {
        C14342f0.m8184p(comparator, "comparator");
        C14342f0.m8184p(elements, "elements");
        return (TreeSet) _Arrays.m11151Jx(elements, new TreeSet(comparator));
    }

    @NotNull
    /* renamed from: h */
    public static final <T> TreeSet<T> m11987h(@NotNull T... elements) {
        C14342f0.m8184p(elements, "elements");
        return (TreeSet) _Arrays.m11151Jx(elements, new TreeSet());
    }
}
