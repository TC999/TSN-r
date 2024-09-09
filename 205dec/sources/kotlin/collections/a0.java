package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Iterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\n\u001a\"\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a0\u0010\b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\t"}, d2 = {"T", "", "f0", "Lkotlin/collections/o0;", "g0", "Lkotlin/Function1;", "Lkotlin/f1;", "operation", "e0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a0 extends z {
    public static final <T> void e0(@NotNull Iterator<? extends T> it, @NotNull d2.l<? super T, kotlin.f1> operation) {
        kotlin.jvm.internal.f0.p(it, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        while (it.hasNext()) {
            operation.invoke((T) it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Iterator<T> f0(Iterator<? extends T> it) {
        kotlin.jvm.internal.f0.p(it, "<this>");
        return it;
    }

    @NotNull
    public static final <T> Iterator<o0<T>> g0(@NotNull Iterator<? extends T> it) {
        kotlin.jvm.internal.f0.p(it, "<this>");
        return new q0(it);
    }
}
