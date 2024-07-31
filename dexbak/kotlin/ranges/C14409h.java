package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.InterfaceC14407g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0010\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, m12616d2 = {"Lkotlin/ranges/h;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ranges/g;", "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "a", "Ljava/lang/Comparable;", "getStart", "()Ljava/lang/Comparable;", CampaignEx.JSON_NATIVE_VIDEO_START, "b", "getEndInclusive", "endInclusive", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14409h<T extends Comparable<? super T>> implements InterfaceC14407g<T> {
    @NotNull

    /* renamed from: a */
    private final T f41290a;
    @NotNull

    /* renamed from: b */
    private final T f41291b;

    public C14409h(@NotNull T start, @NotNull T endInclusive) {
        C14342f0.m8184p(start, "start");
        C14342f0.m8184p(endInclusive, "endInclusive");
        this.f41290a = start;
        this.f41291b = endInclusive;
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public boolean contains(@NotNull T value) {
        C14342f0.m8184p(value, "value");
        return InterfaceC14407g.C14408a.m7606a(this, value);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14409h) {
            if (!isEmpty() || !((C14409h) obj).isEmpty()) {
                C14409h c14409h = (C14409h) obj;
                if (!C14342f0.m8193g(getStart(), c14409h.getStart()) || !C14342f0.m8193g(getEndInclusive(), c14409h.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    public T getEndInclusive() {
        return this.f41291b;
    }

    @Override // kotlin.ranges.InterfaceC14407g
    @NotNull
    public T getStart() {
        return this.f41290a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // kotlin.ranges.InterfaceC14407g
    public boolean isEmpty() {
        return InterfaceC14407g.C14408a.m7605b(this);
    }

    @NotNull
    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
