package kotlin.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterator.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "array", "", "a", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14344h {
    @NotNull
    /* renamed from: a */
    public static final <T> Iterator<T> m8171a(@NotNull T[] array) {
        C14342f0.m8184p(array, "array");
        return new ArrayIterator(array);
    }
}
