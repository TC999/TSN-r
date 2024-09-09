package kotlin.sequences;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SequencesJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b\u00a8\u0006\u0004"}, d2 = {"T", "Ljava/util/Enumeration;", "Lkotlin/sequences/m;", "f", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class r extends q {
    @InlineOnly
    private static final <T> m<T> f(Enumeration<T> enumeration) {
        Iterator d02;
        m<T> h4;
        f0.p(enumeration, "<this>");
        d02 = kotlin.collections.z.d0(enumeration);
        h4 = s.h(d02);
        return h4;
    }
}
