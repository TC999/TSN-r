package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, m12616d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.drawable.IconKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Icon {
    @RequiresApi(26)
    @NotNull
    public static final android.graphics.drawable.Icon toAdaptiveIcon(@NotNull Bitmap toAdaptiveIcon) {
        C14342f0.m8183q(toAdaptiveIcon, "$this$toAdaptiveIcon");
        android.graphics.drawable.Icon createWithAdaptiveBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap(toAdaptiveIcon);
        C14342f0.m8192h(createWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.drawable.Icon toIcon(@NotNull Bitmap toIcon) {
        C14342f0.m8183q(toIcon, "$this$toIcon");
        android.graphics.drawable.Icon createWithBitmap = android.graphics.drawable.Icon.createWithBitmap(toIcon);
        C14342f0.m8192h(createWithBitmap, "Icon.createWithBitmap(this)");
        return createWithBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.drawable.Icon toIcon(@NotNull Uri toIcon) {
        C14342f0.m8183q(toIcon, "$this$toIcon");
        android.graphics.drawable.Icon createWithContentUri = android.graphics.drawable.Icon.createWithContentUri(toIcon);
        C14342f0.m8192h(createWithContentUri, "Icon.createWithContentUri(this)");
        return createWithContentUri;
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.drawable.Icon toIcon(@NotNull byte[] toIcon) {
        C14342f0.m8183q(toIcon, "$this$toIcon");
        android.graphics.drawable.Icon createWithData = android.graphics.drawable.Icon.createWithData(toIcon, 0, toIcon.length);
        C14342f0.m8192h(createWithData, "Icon.createWithData(this, 0, size)");
        return createWithData;
    }
}
