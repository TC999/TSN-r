package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, m12616d2 = {"Lkotlin/ranges/d;", "Lkotlin/ranges/f;", "", "a", "b", "", "e", DomainCampaignEx.LOOPBACK_VALUE, "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "D", "_start", "_endInclusive", "d", "()Ljava/lang/Double;", CampaignEx.JSON_NATIVE_VIDEO_START, "c", "endInclusive", "<init>", "(DD)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14403d implements InterfaceC14405f<Double> {

    /* renamed from: a */
    private final double f41286a;

    /* renamed from: b */
    private final double f41287b;

    public C14403d(double d, double d2) {
        this.f41286a = d;
        this.f41287b = d2;
    }

    @Override // kotlin.ranges.InterfaceC14405f
    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo7609a(Double d, Double d2) {
        return m7614e(d.doubleValue(), d2.doubleValue());
    }

    /* renamed from: b */
    public boolean m7617b(double d) {
        return d >= this.f41286a && d <= this.f41287b;
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: c */
    public Double getEndInclusive() {
        return Double.valueOf(this.f41287b);
    }

    @Override // kotlin.ranges.InterfaceC14405f, kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return m7617b(((Number) comparable).doubleValue());
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: d */
    public Double getStart() {
        return Double.valueOf(this.f41286a);
    }

    /* renamed from: e */
    public boolean m7614e(double d, double d2) {
        return d <= d2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14403d) {
            if (!isEmpty() || !((C14403d) obj).isEmpty()) {
                C14403d c14403d = (C14403d) obj;
                if (this.f41286a != c14403d.f41286a || this.f41287b != c14403d.f41287b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.f41286a).hashCode() * 31) + Double.valueOf(this.f41287b).hashCode();
    }

    @Override // kotlin.ranges.InterfaceC14405f, kotlin.ranges.InterfaceC14407g
    public boolean isEmpty() {
        return this.f41286a > this.f41287b;
    }

    @NotNull
    public String toString() {
        return this.f41286a + ".." + this.f41287b;
    }
}
