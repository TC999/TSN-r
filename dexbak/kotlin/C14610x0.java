package kotlin;

import kotlin.internal.InlineOnly;
import p617l1.InterfaceC15280l;

/* compiled from: ULongArray.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00020\u00052\n\u0010\b\u001a\u00020\u0005\"\u00020\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m12616d2 = {"", "size", "Lkotlin/Function1;", "Lkotlin/v0;", "init", "Lkotlin/w0;", "a", "(ILl1/l;)[J", "elements", "b", "([J)[J", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.x0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14610x0 {
    @SinceKotlin(version = "1.3")
    @Unsigned
    @InlineOnly
    /* renamed from: a */
    private static final long[] m5787a(int i, InterfaceC15280l<? super Integer, ULong> interfaceC15280l) {
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = interfaceC15280l.invoke(Integer.valueOf(i2)).m5890g0();
        }
        return ULongArray.m5830e(jArr);
    }

    @SinceKotlin(version = "1.3")
    @Unsigned
    @InlineOnly
    /* renamed from: b */
    private static final long[] m5786b(long... jArr) {
        return jArr;
    }
}
