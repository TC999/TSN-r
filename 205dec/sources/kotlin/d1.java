package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UShortArray.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00020\u00052\n\u0010\b\u001a\u00020\u0005\"\u00020\u0003H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006\u000b"}, d2 = {"", "size", "Lkotlin/Function1;", "Lkotlin/b1;", "init", "Lkotlin/c1;", "a", "(ILd2/l;)[S", "elements", "b", "([S)[S", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d1 {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] a(int i4, d2.l<? super Integer, b1> init) {
        kotlin.jvm.internal.f0.p(init, "init");
        short[] sArr = new short[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            sArr[i5] = init.invoke(Integer.valueOf(i5)).j0();
        }
        return c1.k(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] b(short... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements;
    }
}
