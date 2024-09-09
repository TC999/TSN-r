package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lkotlin/jvm/internal/e0;", "Lkotlin/jvm/internal/m0;", "", "", "i", "value", "Lkotlin/f1;", "h", "j", "d", "[I", "values", "size", "<init>", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e0 extends m0<int[]> {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final int[] f55622d;

    public e0(int i4) {
        super(i4);
        this.f55622d = new int[i4];
    }

    public final void h(int i4) {
        int[] iArr = this.f55622d;
        int b4 = b();
        e(b4 + 1);
        iArr[b4] = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.m0
    /* renamed from: i */
    public int c(@NotNull int[] iArr) {
        f0.p(iArr, "<this>");
        return iArr.length;
    }

    @NotNull
    public final int[] j() {
        return g(this.f55622d, new int[f()]);
    }
}
