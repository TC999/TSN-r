package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lkotlin/ranges/d;", "Lkotlin/ranges/f;", "", "a", "b", "", "e", "value", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "D", "_start", "_endInclusive", "d", "()Ljava/lang/Double;", CampaignEx.JSON_NATIVE_VIDEO_START, "c", "endInclusive", "<init>", "(DD)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class d implements f<Double> {

    /* renamed from: a  reason: collision with root package name */
    private final double f55786a;

    /* renamed from: b  reason: collision with root package name */
    private final double f55787b;

    public d(double d4, double d5) {
        this.f55786a = d4;
        this.f55787b = d5;
    }

    @Override // kotlin.ranges.f
    public /* bridge */ /* synthetic */ boolean a(Double d4, Double d5) {
        return e(d4.doubleValue(), d5.doubleValue());
    }

    public boolean b(double d4) {
        return d4 >= this.f55786a && d4 <= this.f55787b;
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: c */
    public Double getEndInclusive() {
        return Double.valueOf(this.f55787b);
    }

    @Override // kotlin.ranges.f, kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).doubleValue());
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: d */
    public Double getStart() {
        return Double.valueOf(this.f55786a);
    }

    public boolean e(double d4, double d5) {
        return d4 <= d5;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof d) {
            if (isEmpty() && ((d) obj).isEmpty()) {
                return true;
            }
            d dVar = (d) obj;
            if (this.f55786a == dVar.f55786a) {
                if (this.f55787b == dVar.f55787b) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.f55786a).hashCode() * 31) + Double.valueOf(this.f55787b).hashCode();
    }

    @Override // kotlin.ranges.f, kotlin.ranges.g
    public boolean isEmpty() {
        return this.f55786a > this.f55787b;
    }

    @NotNull
    public String toString() {
        return this.f55786a + ".." + this.f55787b;
    }
}
