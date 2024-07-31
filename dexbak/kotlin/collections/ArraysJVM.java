package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a(\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\b¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0001\u001a#\u0010\u0014\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "d", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "Ljava/nio/charset/Charset;", "charset", "", "e", "", "f", "(Ljava/util/Collection;)[Ljava/lang/Object;", "reference", "", "size", "a", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "toIndex", "Lkotlin/f1;", "c", "b", "([Ljava/lang/Object;)I", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/ArraysKt")
/* renamed from: kotlin.collections.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class ArraysJVM {
    @NotNull
    /* renamed from: a */
    public static final <T> T[] m11803a(@NotNull T[] reference, int i) {
        C14342f0.m8184p(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i);
        if (newInstance != null) {
            return (T[]) ((Object[]) newInstance);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepHashCode")
    /* renamed from: b */
    public static final <T> int m11802b(@Nullable T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: c */
    public static final void m11801c(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }

    /* renamed from: d */
    public static final /* synthetic */ <T> T[] m11800d(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        C14342f0.m8175y(0, "T?");
        return (T[]) new Object[0];
    }

    @InlineOnly
    /* renamed from: e */
    private static final String m11799e(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    /* renamed from: f */
    public static final /* synthetic */ <T> T[] m11798f(Collection<? extends T> toTypedArray) {
        C14342f0.m8184p(toTypedArray, "$this$toTypedArray");
        C14342f0.m8175y(0, "T?");
        T[] tArr = (T[]) toTypedArray.toArray(new Object[0]);
        if (tArr != null) {
            return tArr;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
