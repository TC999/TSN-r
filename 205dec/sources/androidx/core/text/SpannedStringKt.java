package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SpannedString.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\u001a:\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086\b\u00a2\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0004*\u00020\nH\u0086\b\u00a8\u0006\u000b"}, d2 = {"getSpans", "", "T", "", "Landroid/text/Spanned;", CampaignEx.JSON_NATIVE_VIDEO_START, "", "end", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "toSpanned", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class SpannedStringKt {
    @NotNull
    public static final /* synthetic */ <T> T[] getSpans(@NotNull Spanned getSpans, int i4, int i5) {
        f0.q(getSpans, "$this$getSpans");
        f0.y(4, "T");
        T[] tArr = (T[]) getSpans.getSpans(i4, i5, Object.class);
        f0.h(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned getSpans, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = getSpans.length();
        }
        f0.q(getSpans, "$this$getSpans");
        f0.y(4, "T");
        Object[] spans = getSpans.getSpans(i4, i5, Object.class);
        f0.h(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    @NotNull
    public static final Spanned toSpanned(@NotNull CharSequence toSpanned) {
        f0.q(toSpanned, "$this$toSpanned");
        SpannedString valueOf = SpannedString.valueOf(toSpanned);
        f0.h(valueOf, "SpannedString.valueOf(this)");
        return valueOf;
    }
}
