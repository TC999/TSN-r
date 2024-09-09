package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ReversedViews.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0000\u001a%\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\bH\u0007\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"", "", "index", "Y0", "(Ljava/util/List;I)I", "Z0", "T", "W0", "", "X0", "(Ljava/util/List;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d0 extends c0 {
    @NotNull
    public static final <T> List<T> W0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return new f1(list);
    }

    @JvmName(name = "asReversedMutable")
    @NotNull
    public static <T> List<T> X0(@NotNull List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return new e1(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int Y0(java.util.List<?> r4, int r5) {
        /*
            r0 = 0
            if (r5 < 0) goto Lb
            int r1 = kotlin.collections.w.H(r4)
            if (r5 > r1) goto Lb
            r1 = 1
            goto Lc
        Lb:
            r1 = 0
        Lc:
            if (r1 == 0) goto L14
            int r4 = kotlin.collections.w.H(r4)
            int r4 = r4 - r5
            return r4
        L14:
            java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Element index "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = " must be in range ["
            r2.append(r5)
            kotlin.ranges.k r5 = new kotlin.ranges.k
            int r4 = kotlin.collections.w.H(r4)
            r5.<init>(r0, r4)
            r2.append(r5)
            java.lang.String r4 = "]."
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r1.<init>(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.d0.Y0(java.util.List, int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Z0(List<?> list, int i4) {
        if (i4 >= 0 && i4 <= list.size()) {
            return list.size() - i4;
        }
        throw new IndexOutOfBoundsException("Position index " + i4 + " must be in range [" + new kotlin.ranges.k(0, list.size()) + "].");
    }
}
