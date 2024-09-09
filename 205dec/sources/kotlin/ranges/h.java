package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.ranges.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0010\u001a\u00028\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00028\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lkotlin/ranges/h;", "", "T", "Lkotlin/ranges/g;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/Comparable;", "getStart", "()Ljava/lang/Comparable;", CampaignEx.JSON_NATIVE_VIDEO_START, "b", "getEndInclusive", "endInclusive", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class h<T extends Comparable<? super T>> implements g<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final T f55790a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final T f55791b;

    public h(@NotNull T start, @NotNull T endInclusive) {
        f0.p(start, "start");
        f0.p(endInclusive, "endInclusive");
        this.f55790a = start;
        this.f55791b = endInclusive;
    }

    @Override // kotlin.ranges.g
    public boolean contains(@NotNull T t3) {
        return g.a.a(this, t3);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof h) {
            if (!isEmpty() || !((h) obj).isEmpty()) {
                h hVar = (h) obj;
                if (!f0.g(getStart(), hVar.getStart()) || !f0.g(getEndInclusive(), hVar.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.g
    @NotNull
    public T getEndInclusive() {
        return this.f55791b;
    }

    @Override // kotlin.ranges.g
    @NotNull
    public T getStart() {
        return this.f55790a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // kotlin.ranges.g
    public boolean isEmpty() {
        return g.a.b(this);
    }

    @NotNull
    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
