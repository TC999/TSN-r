package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Html.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0086\b\u00a8\u0006\u000b"}, d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", "flags", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class HtmlKt {
    @NotNull
    public static final Spanned parseAsHtml(@NotNull String parseAsHtml, int i4, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        f0.q(parseAsHtml, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(parseAsHtml, i4, imageGetter, tagHandler);
        f0.h(fromHtml, "HtmlCompat.fromHtml(this\u2026 imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String parseAsHtml, int i4, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        if ((i5 & 2) != 0) {
            imageGetter = null;
        }
        if ((i5 & 4) != 0) {
            tagHandler = null;
        }
        f0.q(parseAsHtml, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(parseAsHtml, i4, imageGetter, tagHandler);
        f0.h(fromHtml, "HtmlCompat.fromHtml(this\u2026 imageGetter, tagHandler)");
        return fromHtml;
    }

    @NotNull
    public static final String toHtml(@NotNull Spanned toHtml, int i4) {
        f0.q(toHtml, "$this$toHtml");
        String html = HtmlCompat.toHtml(toHtml, i4);
        f0.h(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned toHtml, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        f0.q(toHtml, "$this$toHtml");
        String html = HtmlCompat.toHtml(toHtml, i4);
        f0.h(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}
