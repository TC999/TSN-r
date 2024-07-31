package kotlin.jvm.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m12616d2 = {"Lkotlin/jvm/internal/m;", "Lkotlin/jvm/internal/m0;", "", "", "i", "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "h", "j", "d", "[Z", "values", "size", "<init>", "(I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14352m extends AbstractC14353m0<boolean[]> {

    /* renamed from: d */
    private final boolean[] f41150d;

    public C14352m(int i) {
        super(i);
        this.f41150d = new boolean[i];
    }

    /* renamed from: h */
    public final void m8140h(boolean z) {
        boolean[] zArr = this.f41150d;
        int m8136b = m8136b();
        m8134e(m8136b + 1);
        zArr[m8136b] = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.AbstractC14353m0
    /* renamed from: i */
    public int mo7965c(@NotNull boolean[] getSize) {
        C14342f0.m8184p(getSize, "$this$getSize");
        return getSize.length;
    }

    @NotNull
    /* renamed from: j */
    public final boolean[] m8138j() {
        return m8132g(this.f41150d, new boolean[m8133f()]);
    }
}