package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: compareTo.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\f\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"T", "", "other", "", "a", "(Ljava/lang/Comparable;Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.6")
    @InlineOnly
    private static final <T> int a(Comparable<? super T> comparable, T t3) {
        kotlin.jvm.internal.f0.p(comparable, "<this>");
        return comparable.compareTo(t3);
    }
}
