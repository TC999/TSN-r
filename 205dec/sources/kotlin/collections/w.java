package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {}, d1 = {"kotlin/collections/x", "kotlin/collections/CollectionsKt__CollectionsKt", "kotlin/collections/y", "kotlin/collections/z", "kotlin/collections/a0", "kotlin/collections/b0", "kotlin/collections/c0", "kotlin/collections/d0", "kotlin/collections/e0", "kotlin/collections/f0"}, d2 = {}, k = 4, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w extends f0 {
    private w() {
    }

    @NotNull
    public static /* bridge */ /* synthetic */ List G5(@NotNull Iterable iterable) {
        return f0.G5(iterable);
    }

    public static /* bridge */ /* synthetic */ Appendable V2(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, d2.l lVar, int i5, Object obj) {
        Appendable U2;
        U2 = f0.U2(iterable, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i4, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : lVar);
        return U2;
    }
}
