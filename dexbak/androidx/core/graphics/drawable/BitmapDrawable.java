package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, m12616d2 = {"toDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Bitmap;", "resources", "Landroid/content/res/Resources;", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.drawable.BitmapDrawableKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class BitmapDrawable {
    @NotNull
    public static final android.graphics.drawable.BitmapDrawable toDrawable(@NotNull Bitmap toDrawable, @NotNull Resources resources) {
        C14342f0.m8183q(toDrawable, "$this$toDrawable");
        C14342f0.m8183q(resources, "resources");
        return new android.graphics.drawable.BitmapDrawable(resources, toDrawable);
    }
}
