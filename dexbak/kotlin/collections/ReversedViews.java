package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.C14413k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0000\u001a%\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m12616d2 = {"", "", "index", "a1", "(Ljava/util/List;I)I", "b1", ExifInterface.GPS_DIRECTION_TRUE, "Y0", "", "Z0", "(Ljava/util/List;)Ljava/util/List;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.c0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ReversedViews extends MutableCollections {
    @NotNull
    /* renamed from: Y0 */
    public static final <T> List<T> m12313Y0(@NotNull List<? extends T> asReversed) {
        C14342f0.m8184p(asReversed, "$this$asReversed");
        return new C14158e1(asReversed);
    }

    @JvmName(name = "asReversedMutable")
    @NotNull
    /* renamed from: Z0 */
    public static final <T> List<T> m12312Z0(@NotNull List<T> asReversed) {
        C14342f0.m8184p(asReversed, "$this$asReversed");
        return new C14147d1(asReversed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public static final int m12311a1(List<?> list, int i) {
        int m12476G;
        int m12476G2;
        int m12476G3;
        m12476G = CollectionsKt__CollectionsKt.m12476G(list);
        if (i >= 0 && m12476G >= i) {
            m12476G3 = CollectionsKt__CollectionsKt.m12476G(list);
            return m12476G3 - i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Element index ");
        sb.append(i);
        sb.append(" must be in range [");
        m12476G2 = CollectionsKt__CollectionsKt.m12476G(list);
        sb.append(new C14413k(0, m12476G2));
        sb.append("].");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b1 */
    public static final int m12310b1(List<?> list, int i) {
        int size = list.size();
        if (i < 0 || size < i) {
            throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new C14413k(0, list.size()) + "].");
        }
        return list.size() - i;
    }
}
