package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.C14307b;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.CollectionToArray;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000V\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0081\bø\u0001\u0000\u001a?\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\f2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0081\bø\u0001\u0000\u001a\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0005H\u0001\u001a\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\fH\u0001\u001a\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0001\u001a\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0087\b\u001a\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0007\u001a&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0007\u001a$\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0081\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a6\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\u0004\b\u0000\u0010\u00002\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0081\b¢\u0006\u0004\b!\u0010\"\u001a3\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001d0\u001c\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001c2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&\u001a\u0011\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0081\b\u001a\u0011\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0081\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "element", "", "k", "(Ljava/lang/Object;)Ljava/util/List;", ExifInterface.LONGITUDE_EAST, "Lkotlin/Function1;", "", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "c", "", "capacity", "b", "i", "j", "builder", "a", "Ljava/util/Enumeration;", "n", "", C7304t.f25048d, "Ljava/util/Random;", "random", "m", "", "collection", "", "", "f", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "g", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "isVarargs", "h", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "index", "e", "count", "d", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.w */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class CollectionsJVM {
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    /* renamed from: a */
    public static <E> List<E> m8975a(@NotNull List<E> builder) {
        C14342f0.m8184p(builder, "builder");
        return ((ListBuilder) builder).m12397l();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @PublishedApi
    /* renamed from: b */
    private static final <E> List<E> m8974b(int i, InterfaceC15280l<? super List<E>, Unit> interfaceC15280l) {
        List m8966j;
        List<E> m8975a;
        m8966j = m8966j(i);
        interfaceC15280l.invoke(m8966j);
        m8975a = m8975a(m8966j);
        return m8975a;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @PublishedApi
    /* renamed from: c */
    private static final <E> List<E> m8973c(InterfaceC15280l<? super List<E>, Unit> interfaceC15280l) {
        List<E> m8975a;
        List m8967i = m8967i();
        interfaceC15280l.invoke(m8967i);
        m8975a = m8975a(m8967i);
        return m8975a;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    /* renamed from: d */
    private static final int m8972d(int i) {
        if (i < 0) {
            if (C14307b.m8534a(1, 3, 0)) {
                CollectionsKt__CollectionsKt.m12461V();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    /* renamed from: e */
    private static final int m8971e(int i) {
        if (i < 0) {
            if (C14307b.m8534a(1, 3, 0)) {
                CollectionsKt__CollectionsKt.m12460W();
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        return i;
    }

    @InlineOnly
    /* renamed from: f */
    private static final Object[] m8970f(Collection<?> collection) {
        return CollectionToArray.m8043a(collection);
    }

    @InlineOnly
    /* renamed from: g */
    private static final <T> T[] m8969g(Collection<?> collection, T[] tArr) {
        if (tArr != null) {
            T[] tArr2 = (T[]) CollectionToArray.m8042b(collection, tArr);
            if (tArr2 != null) {
                return tArr2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @NotNull
    /* renamed from: h */
    public static final <T> Object[] m8968h(@NotNull T[] copyToArrayOfAny, boolean z) {
        C14342f0.m8184p(copyToArrayOfAny, "$this$copyToArrayOfAny");
        if (z && C14342f0.m8193g(copyToArrayOfAny.getClass(), Object[].class)) {
            return copyToArrayOfAny;
        }
        Object[] copyOf = Arrays.copyOf(copyToArrayOfAny, copyToArrayOfAny.length, Object[].class);
        C14342f0.m8185o(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    /* renamed from: i */
    public static final <E> List<E> m8967i() {
        return new ListBuilder();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    /* renamed from: j */
    public static <E> List<E> m8966j(int i) {
        return new ListBuilder(i);
    }

    @NotNull
    /* renamed from: k */
    public static <T> List<T> m8965k(T t) {
        List<T> singletonList = Collections.singletonList(t);
        C14342f0.m8185o(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: l */
    public static final <T> List<T> m8964l(@NotNull Iterable<? extends T> shuffled) {
        C14342f0.m8184p(shuffled, "$this$shuffled");
        List<T> m12223K5 = _Collections.m12223K5(shuffled);
        Collections.shuffle(m12223K5);
        return m12223K5;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    /* renamed from: m */
    public static final <T> List<T> m8963m(@NotNull Iterable<? extends T> shuffled, @NotNull Random random) {
        C14342f0.m8184p(shuffled, "$this$shuffled");
        C14342f0.m8184p(random, "random");
        List<T> m12223K5 = _Collections.m12223K5(shuffled);
        Collections.shuffle(m12223K5, random);
        return m12223K5;
    }

    @InlineOnly
    /* renamed from: n */
    private static final <T> List<T> m8962n(Enumeration<T> enumeration) {
        ArrayList list = Collections.list(enumeration);
        C14342f0.m8185o(list, "java.util.Collections.list(this)");
        return list;
    }
}
