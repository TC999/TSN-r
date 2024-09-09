package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ArraysJVM.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0086\b\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a(\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\b\u00a2\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0001\u001a#\u0010\u0014\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"T", "", "d", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "Ljava/nio/charset/Charset;", "charset", "", "e", "", "f", "(Ljava/util/Collection;)[Ljava/lang/Object;", "reference", "", "size", "a", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "toIndex", "Lkotlin/f1;", "c", "b", "([Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/ArraysKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class m {
    @NotNull
    public static final <T> T[] a(@NotNull T[] reference, int i4) {
        kotlin.jvm.internal.f0.p(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i4);
        if (newInstance != null) {
            return (T[]) ((Object[]) newInstance);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepHashCode")
    public static final <T> int b(@Nullable T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    @SinceKotlin(version = "1.3")
    public static final void c(int i4, int i5) {
        if (i4 <= i5) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i5 + ").");
    }

    public static final /* synthetic */ <T> T[] d(T[] tArr) {
        if (tArr == null) {
            kotlin.jvm.internal.f0.y(0, "T?");
            return (T[]) new Object[0];
        }
        return tArr;
    }

    @InlineOnly
    private static final String e(byte[] bArr, Charset charset) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(charset, "charset");
        return new String(bArr, charset);
    }

    public static final /* synthetic */ <T> T[] f(Collection<? extends T> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.y(0, "T?");
        T[] tArr = (T[]) collection.toArray(new Object[0]);
        if (tArr != null) {
            return tArr;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
