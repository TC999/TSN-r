package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lkotlin/jvm/internal/q0;", "Lkotlin/jvm/internal/m0;", "", "", "i", "", "value", "Lkotlin/f1;", "h", "j", "d", "[S", "values", "size", "<init>", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q0 extends m0<short[]> {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final short[] f55671d;

    public q0(int i4) {
        super(i4);
        this.f55671d = new short[i4];
    }

    public final void h(short s3) {
        short[] sArr = this.f55671d;
        int b4 = b();
        e(b4 + 1);
        sArr[b4] = s3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.m0
    /* renamed from: i */
    public int c(@NotNull short[] sArr) {
        f0.p(sArr, "<this>");
        return sArr.length;
    }

    @NotNull
    public final short[] j() {
        return g(this.f55671d, new short[f()]);
    }
}
