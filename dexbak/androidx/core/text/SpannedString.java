package androidx.core.text;

import android.text.Spanned;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\u001a:\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0004*\u00020\nH\u0086\b¨\u0006\u000b"}, m12616d2 = {"getSpans", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/text/Spanned;", CampaignEx.JSON_NATIVE_VIDEO_START, "", "end", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "toSpanned", "", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.text.SpannedStringKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SpannedString {
    @NotNull
    public static final /* synthetic */ <T> T[] getSpans(@NotNull Spanned getSpans, int i, int i2) {
        C14342f0.m8183q(getSpans, "$this$getSpans");
        C14342f0.m8175y(4, ExifInterface.GPS_DIRECTION_TRUE);
        T[] tArr = (T[]) getSpans.getSpans(i, i2, Object.class);
        C14342f0.m8192h(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned getSpans, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = getSpans.length();
        }
        C14342f0.m8183q(getSpans, "$this$getSpans");
        C14342f0.m8175y(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] spans = getSpans.getSpans(i, i2, Object.class);
        C14342f0.m8192h(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    @NotNull
    public static final Spanned toSpanned(@NotNull CharSequence toSpanned) {
        C14342f0.m8183q(toSpanned, "$this$toSpanned");
        android.text.SpannedString valueOf = android.text.SpannedString.valueOf(toSpanned);
        C14342f0.m8192h(valueOf, "SpannedString.valueOf(this)");
        return valueOf;
    }
}
