package kotlin.jvm.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m12616d2 = {"Lkotlin/jvm/internal/q0;", "Lkotlin/jvm/internal/m0;", "", "", "i", "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "h", "j", "d", "[S", "values", "size", "<init>", "(I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.q0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14359q0 extends AbstractC14353m0<short[]> {

    /* renamed from: d */
    private final short[] f41181d;

    public C14359q0(int i) {
        super(i);
        this.f41181d = new short[i];
    }

    /* renamed from: h */
    public final void m8071h(short s) {
        short[] sArr = this.f41181d;
        int m8136b = m8136b();
        m8134e(m8136b + 1);
        sArr[m8136b] = s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.AbstractC14353m0
    /* renamed from: i */
    public int mo7965c(@NotNull short[] getSize) {
        C14342f0.m8184p(getSize, "$this$getSize");
        return getSize.length;
    }

    @NotNull
    /* renamed from: j */
    public final short[] m8069j() {
        return m8132g(this.f41181d, new short[m8133f()]);
    }
}
