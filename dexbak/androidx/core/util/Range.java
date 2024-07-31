package androidx.core.util;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.InterfaceC14407g;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\f¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\n\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\f\u001a(\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0007¨\u0006\u000e"}, m12616d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "that", "Landroid/util/Range;", "rangeTo", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", DomainCampaignEx.LOOPBACK_VALUE, "plus", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", AdnName.OTHER, "and", "Lkotlin/ranges/g;", "toClosedRange", "toRange", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.util.RangeKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Range {
    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> android.util.Range<T> and(@NotNull android.util.Range<T> and, @NotNull android.util.Range<T> other) {
        C14342f0.m8183q(and, "$this$and");
        C14342f0.m8183q(other, "other");
        android.util.Range<T> intersect = and.intersect(other);
        C14342f0.m8192h(intersect, "intersect(other)");
        return intersect;
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> android.util.Range<T> plus(@NotNull android.util.Range<T> plus, @NotNull T value) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(value, "value");
        android.util.Range<T> extend = plus.extend((android.util.Range<T>) value);
        C14342f0.m8192h(extend, "extend(value)");
        return extend;
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> android.util.Range<T> rangeTo(@NotNull T rangeTo, @NotNull T that) {
        C14342f0.m8183q(rangeTo, "$this$rangeTo");
        C14342f0.m8183q(that, "that");
        return new android.util.Range<>(rangeTo, that);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> InterfaceC14407g<T> toClosedRange(@NotNull final android.util.Range<T> toClosedRange) {
        C14342f0.m8183q(toClosedRange, "$this$toClosedRange");
        return (InterfaceC14407g<T>) new InterfaceC14407g<T>() { // from class: androidx.core.util.RangeKt$toClosedRange$1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // kotlin.ranges.InterfaceC14407g
            public boolean contains(@NotNull Comparable value) {
                C14342f0.m8183q(value, "value");
                return InterfaceC14407g.C14408a.m7606a(this, value);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.ranges.InterfaceC14407g
            public Comparable getEndInclusive() {
                return toClosedRange.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.ranges.InterfaceC14407g
            public Comparable getStart() {
                return toClosedRange.getLower();
            }

            @Override // kotlin.ranges.InterfaceC14407g
            public boolean isEmpty() {
                return InterfaceC14407g.C14408a.m7605b(this);
            }
        };
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> android.util.Range<T> toRange(@NotNull InterfaceC14407g<T> toRange) {
        C14342f0.m8183q(toRange, "$this$toRange");
        return new android.util.Range<>(toRange.getStart(), toRange.getEndInclusive());
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> android.util.Range<T> plus(@NotNull android.util.Range<T> plus, @NotNull android.util.Range<T> other) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(other, "other");
        android.util.Range<T> extend = plus.extend(other);
        C14342f0.m8192h(extend, "extend(other)");
        return extend;
    }
}
