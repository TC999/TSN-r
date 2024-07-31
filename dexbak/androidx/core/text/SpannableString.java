package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.C14413k;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0001H\u0087\b\u001a%\u0010\n\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\n\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0086\n¨\u0006\r"}, m12616d2 = {"", "Landroid/text/Spannable;", "toSpannable", "Lkotlin/f1;", "clearSpans", "", CampaignEx.JSON_NATIVE_VIDEO_START, "end", "", "span", "set", "Lkotlin/ranges/k;", "range", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.text.SpannableStringKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SpannableString {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@NotNull Spannable clearSpans) {
        C14342f0.m8183q(clearSpans, "$this$clearSpans");
        Object[] spans = clearSpans.getSpans(0, clearSpans.length(), Object.class);
        C14342f0.m8192h(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            clearSpans.removeSpan(obj);
        }
    }

    public static final void set(@NotNull Spannable set, int i, int i2, @NotNull Object span) {
        C14342f0.m8183q(set, "$this$set");
        C14342f0.m8183q(span, "span");
        set.setSpan(span, i, i2, 17);
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence toSpannable) {
        C14342f0.m8183q(toSpannable, "$this$toSpannable");
        android.text.SpannableString valueOf = android.text.SpannableString.valueOf(toSpannable);
        C14342f0.m8192h(valueOf, "SpannableString.valueOf(this)");
        return valueOf;
    }

    public static final void set(@NotNull Spannable set, @NotNull C14413k range, @NotNull Object span) {
        C14342f0.m8183q(set, "$this$set");
        C14342f0.m8183q(range, "range");
        C14342f0.m8183q(span, "span");
        set.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }
}
