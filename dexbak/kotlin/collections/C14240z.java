package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterators.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\n\u001a\"\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a0\u0010\b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "h0", "Lkotlin/collections/n0;", "i0", "Lkotlin/Function1;", "Lkotlin/f1;", "operation", "g0", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.z */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14240z extends IteratorsJVM {
    /* renamed from: g0 */
    public static final <T> void m8863g0(@NotNull Iterator<? extends T> forEach, @NotNull InterfaceC15280l<? super T, Unit> operation) {
        C14342f0.m8184p(forEach, "$this$forEach");
        C14342f0.m8184p(operation, "operation");
        while (forEach.hasNext()) {
            operation.invoke((T) forEach.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: h0 */
    private static final <T> Iterator<T> m8862h0(Iterator<? extends T> iterator) {
        C14342f0.m8184p(iterator, "$this$iterator");
        return iterator;
    }

    @NotNull
    /* renamed from: i0 */
    public static final <T> Iterator<IndexedValue<T>> m8861i0(@NotNull Iterator<? extends T> withIndex) {
        C14342f0.m8184p(withIndex, "$this$withIndex");
        return new C14184p0(withIndex);
    }
}
