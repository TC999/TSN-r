package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.1")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0002\b\u0005\bg\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&J\u0017\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m12616d2 = {"Lkotlin/collections/j0;", ExifInterface.GPS_DIRECTION_TRUE, "K", "", "", "b", "element", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.j0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Grouping<T, K> {
    /* renamed from: a */
    K mo6189a(T t);

    @NotNull
    /* renamed from: b */
    Iterator<T> mo6188b();
}
