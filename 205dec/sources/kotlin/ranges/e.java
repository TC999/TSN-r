package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lkotlin/ranges/e;", "Lkotlin/ranges/f;", "", "a", "b", "", "e", "value", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "F", "_start", "_endInclusive", "d", "()Ljava/lang/Float;", CampaignEx.JSON_NATIVE_VIDEO_START, "c", "endInclusive", "<init>", "(FF)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class e implements f<Float> {

    /* renamed from: a  reason: collision with root package name */
    private final float f55788a;

    /* renamed from: b  reason: collision with root package name */
    private final float f55789b;

    public e(float f4, float f5) {
        this.f55788a = f4;
        this.f55789b = f5;
    }

    @Override // kotlin.ranges.f
    public /* bridge */ /* synthetic */ boolean a(Float f4, Float f5) {
        return e(f4.floatValue(), f5.floatValue());
    }

    public boolean b(float f4) {
        return f4 >= this.f55788a && f4 <= this.f55789b;
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: c */
    public Float getEndInclusive() {
        return Float.valueOf(this.f55789b);
    }

    @Override // kotlin.ranges.f, kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: d */
    public Float getStart() {
        return Float.valueOf(this.f55788a);
    }

    public boolean e(float f4, float f5) {
        return f4 <= f5;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof e) {
            if (isEmpty() && ((e) obj).isEmpty()) {
                return true;
            }
            e eVar = (e) obj;
            if (this.f55788a == eVar.f55788a) {
                if (this.f55789b == eVar.f55789b) {
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
        return (Float.valueOf(this.f55788a).hashCode() * 31) + Float.valueOf(this.f55789b).hashCode();
    }

    @Override // kotlin.ranges.f, kotlin.ranges.g
    public boolean isEmpty() {
        return this.f55788a > this.f55789b;
    }

    @NotNull
    public String toString() {
        return this.f55788a + ".." + this.f55789b;
    }
}
