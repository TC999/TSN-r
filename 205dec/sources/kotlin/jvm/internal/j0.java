package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lkotlin/jvm/internal/j0;", "Lkotlin/jvm/internal/m0;", "", "", "i", "", "value", "Lkotlin/f1;", "h", "j", "d", "[J", "values", "size", "<init>", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j0 extends m0<long[]> {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final long[] f55634d;

    public j0(int i4) {
        super(i4);
        this.f55634d = new long[i4];
    }

    public final void h(long j4) {
        long[] jArr = this.f55634d;
        int b4 = b();
        e(b4 + 1);
        jArr[b4] = j4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.m0
    /* renamed from: i */
    public int c(@NotNull long[] jArr) {
        f0.p(jArr, "<this>");
        return jArr.length;
    }

    @NotNull
    public final long[] j() {
        return g(this.f55634d, new long[f()]);
    }
}
