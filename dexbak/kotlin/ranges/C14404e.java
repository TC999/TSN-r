package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, m12616d2 = {"Lkotlin/ranges/e;", "Lkotlin/ranges/f;", "", "a", "b", "", "e", DomainCampaignEx.LOOPBACK_VALUE, "isEmpty", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "F", "_start", "_endInclusive", "d", "()Ljava/lang/Float;", CampaignEx.JSON_NATIVE_VIDEO_START, "c", "endInclusive", "<init>", "(FF)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14404e implements InterfaceC14405f<Float> {

    /* renamed from: a */
    private final float f41288a;

    /* renamed from: b */
    private final float f41289b;

    public C14404e(float f, float f2) {
        this.f41288a = f;
        this.f41289b = f2;
    }

    @Override // kotlin.ranges.InterfaceC14405f
    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo7609a(Float f, Float f2) {
        return m7610e(f.floatValue(), f2.floatValue());
    }

    /* renamed from: b */
    public boolean m7613b(float f) {
        return f >= this.f41288a && f <= this.f41289b;
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: c */
    public Float getEndInclusive() {
        return Float.valueOf(this.f41289b);
    }

    @Override // kotlin.ranges.InterfaceC14405f, kotlin.ranges.InterfaceC14407g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return m7613b(((Number) comparable).floatValue());
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    /* renamed from: d */
    public Float getStart() {
        return Float.valueOf(this.f41288a);
    }

    /* renamed from: e */
    public boolean m7610e(float f, float f2) {
        return f <= f2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14404e) {
            if (!isEmpty() || !((C14404e) obj).isEmpty()) {
                C14404e c14404e = (C14404e) obj;
                if (this.f41288a != c14404e.f41288a || this.f41289b != c14404e.f41289b) {
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
        return (Float.valueOf(this.f41288a).hashCode() * 31) + Float.valueOf(this.f41289b).hashCode();
    }

    @Override // kotlin.ranges.InterfaceC14405f, kotlin.ranges.InterfaceC14407g
    public boolean isEmpty() {
        return this.f41288a > this.f41289b;
    }

    @NotNull
    public String toString() {
        return this.f41288a + ".." + this.f41289b;
    }
}
