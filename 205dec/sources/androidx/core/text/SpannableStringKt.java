package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.ranges.k;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SpannableString.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0001H\u0087\b\u001a%\u0010\n\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\n\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0086\n\u00a8\u0006\r"}, d2 = {"", "Landroid/text/Spannable;", "toSpannable", "Lkotlin/f1;", "clearSpans", "", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "", "span", f3.f5659h, "Lkotlin/ranges/k;", "range", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@NotNull Spannable clearSpans) {
        f0.q(clearSpans, "$this$clearSpans");
        Object[] spans = clearSpans.getSpans(0, clearSpans.length(), Object.class);
        f0.h(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            clearSpans.removeSpan(obj);
        }
    }

    public static final void set(@NotNull Spannable set, int i4, int i5, @NotNull Object span) {
        f0.q(set, "$this$set");
        f0.q(span, "span");
        set.setSpan(span, i4, i5, 17);
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence toSpannable) {
        f0.q(toSpannable, "$this$toSpannable");
        SpannableString valueOf = SpannableString.valueOf(toSpannable);
        f0.h(valueOf, "SpannableString.valueOf(this)");
        return valueOf;
    }

    public static final void set(@NotNull Spannable set, @NotNull k range, @NotNull Object span) {
        f0.q(set, "$this$set");
        f0.q(range, "range");
        f0.q(span, "span");
        set.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }
}
