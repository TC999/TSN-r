package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Drawable.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a2\u0010\r\u001a\u00020\f*\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00012\b\b\u0003\u0010\t\u001a\u00020\u00012\b\b\u0003\u0010\n\u001a\u00020\u00012\b\b\u0003\u0010\u000b\u001a\u00020\u0001\u00a8\u0006\u000e"}, d2 = {"Landroid/graphics/drawable/Drawable;", "", "width", "height", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "toBitmap", "left", "top", "right", "bottom", "Lkotlin/f1;", "updateBounds", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class DrawableKt {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0.getConfig() == r9) goto L6;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Bitmap toBitmap(@org.jetbrains.annotations.NotNull android.graphics.drawable.Drawable r6, @androidx.annotation.Px int r7, @androidx.annotation.Px int r8, @org.jetbrains.annotations.Nullable android.graphics.Bitmap.Config r9) {
        /*
            java.lang.String r0 = "$this$toBitmap"
            kotlin.jvm.internal.f0.q(r6, r0)
            boolean r0 = r6 instanceof android.graphics.drawable.BitmapDrawable
            java.lang.String r1 = "bitmap"
            if (r0 == 0) goto L42
            if (r9 == 0) goto L1d
            r0 = r6
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            kotlin.jvm.internal.f0.h(r0, r1)
            android.graphics.Bitmap$Config r0 = r0.getConfig()
            if (r0 != r9) goto L42
        L1d:
            android.graphics.drawable.BitmapDrawable r6 = (android.graphics.drawable.BitmapDrawable) r6
            int r9 = r6.getIntrinsicWidth()
            if (r7 != r9) goto L33
            int r9 = r6.getIntrinsicHeight()
            if (r8 != r9) goto L33
            android.graphics.Bitmap r6 = r6.getBitmap()
            kotlin.jvm.internal.f0.h(r6, r1)
            return r6
        L33:
            android.graphics.Bitmap r6 = r6.getBitmap()
            r9 = 1
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r6, r7, r8, r9)
            java.lang.String r7 = "Bitmap.createScaledBitma\u2026map, width, height, true)"
            kotlin.jvm.internal.f0.h(r6, r7)
            return r6
        L42:
            android.graphics.Rect r0 = r6.getBounds()
            int r2 = r0.left
            int r3 = r0.top
            int r4 = r0.right
            int r0 = r0.bottom
            if (r9 == 0) goto L51
            goto L53
        L51:
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
        L53:
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r7, r8, r9)
            r5 = 0
            r6.setBounds(r5, r5, r7, r8)
            android.graphics.Canvas r7 = new android.graphics.Canvas
            r7.<init>(r9)
            r6.draw(r7)
            r6.setBounds(r2, r3, r4, r0)
            kotlin.jvm.internal.f0.h(r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.DrawableKt.toBitmap(android.graphics.drawable.Drawable, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i4, int i5, Bitmap.Config config, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = drawable.getIntrinsicWidth();
        }
        if ((i6 & 2) != 0) {
            i5 = drawable.getIntrinsicHeight();
        }
        if ((i6 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i4, i5, config);
    }

    public static final void updateBounds(@NotNull Drawable updateBounds, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        f0.q(updateBounds, "$this$updateBounds");
        updateBounds.setBounds(i4, i5, i6, i7);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = drawable.getBounds().left;
        }
        if ((i8 & 2) != 0) {
            i5 = drawable.getBounds().top;
        }
        if ((i8 & 4) != 0) {
            i6 = drawable.getBounds().right;
        }
        if ((i8 & 8) != 0) {
            i7 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i4, i5, i6, i7);
    }
}
