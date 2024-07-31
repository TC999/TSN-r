package kotlin.jvm.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, m12616d2 = {"Lkotlin/jvm/internal/e0;", "Lkotlin/jvm/internal/m0;", "", "", "i", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "h", "j", "d", "[I", "values", "size", "<init>", "(I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.e0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class PrimitiveSpreadBuilders extends AbstractC14353m0<int[]> {

    /* renamed from: d */
    private final int[] f41132d;

    public PrimitiveSpreadBuilders(int i) {
        super(i);
        this.f41132d = new int[i];
    }

    /* renamed from: h */
    public final void m8221h(int i) {
        int[] iArr = this.f41132d;
        int m8136b = m8136b();
        m8134e(m8136b + 1);
        iArr[m8136b] = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.AbstractC14353m0
    /* renamed from: i */
    public int mo7965c(@NotNull int[] getSize) {
        C14342f0.m8184p(getSize, "$this$getSize");
        return getSize.length;
    }

    @NotNull
    /* renamed from: j */
    public final int[] m8219j() {
        return m8132g(this.f41132d, new int[m8133f()]);
    }
}
