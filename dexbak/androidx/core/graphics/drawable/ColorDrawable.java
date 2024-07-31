package androidx.core.graphics.drawable;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0086\b¨\u0006\u0004"}, m12616d2 = {"toDrawable", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/Color;", "", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.drawable.ColorDrawableKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ColorDrawable {
    @NotNull
    public static final android.graphics.drawable.ColorDrawable toDrawable(@ColorInt int i) {
        return new android.graphics.drawable.ColorDrawable(i);
    }

    @RequiresApi(26)
    @NotNull
    public static final android.graphics.drawable.ColorDrawable toDrawable(@NotNull Color toDrawable) {
        C14342f0.m8183q(toDrawable, "$this$toDrawable");
        return new android.graphics.drawable.ColorDrawable(toDrawable.toArgb());
    }
}
