package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import androidx.annotation.InterfaceC0075Px;
import com.beizi.fusion.widget.ScrollClickView;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a2\u0010\r\u001a\u00020\f*\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00012\b\b\u0003\u0010\t\u001a\u00020\u00012\b\b\u0003\u0010\n\u001a\u00020\u00012\b\b\u0003\u0010\u000b\u001a\u00020\u0001¨\u0006\u000e"}, m12616d2 = {"Landroid/graphics/drawable/Drawable;", "", "width", "height", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "toBitmap", ScrollClickView.DIR_LEFT, "top", ScrollClickView.DIR_RIGHT, "bottom", "Lkotlin/f1;", "updateBounds", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.graphics.drawable.DrawableKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Drawable {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0.getConfig() == r9) goto L6;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Bitmap toBitmap(@org.jetbrains.annotations.NotNull android.graphics.drawable.Drawable r6, @androidx.annotation.InterfaceC0075Px int r7, @androidx.annotation.InterfaceC0075Px int r8, @org.jetbrains.annotations.Nullable android.graphics.Bitmap.Config r9) {
        /*
            java.lang.String r0 = "$this$toBitmap"
            kotlin.jvm.internal.C14342f0.m8183q(r6, r0)
            boolean r0 = r6 instanceof android.graphics.drawable.BitmapDrawable
            java.lang.String r1 = "bitmap"
            if (r0 == 0) goto L42
            if (r9 == 0) goto L1d
            r0 = r6
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            kotlin.jvm.internal.C14342f0.m8192h(r0, r1)
            android.graphics.Bitmap$Config r0 = r0.getConfig()
            if (r0 != r9) goto L42
        L1d:
            android.graphics.drawable.BitmapDrawable r6 = (android.graphics.drawable.BitmapDrawable) r6
            int r9 = r6.getIntrinsicWidth()
            if (r7 != r9) goto L33
            int r9 = r6.getIntrinsicHeight()
            if (r8 != r9) goto L33
            android.graphics.Bitmap r6 = r6.getBitmap()
            kotlin.jvm.internal.C14342f0.m8192h(r6, r1)
            return r6
        L33:
            android.graphics.Bitmap r6 = r6.getBitmap()
            r9 = 1
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r6, r7, r8, r9)
            java.lang.String r7 = "Bitmap.createScaledBitma…map, width, height, true)"
            kotlin.jvm.internal.C14342f0.m8192h(r6, r7)
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
            kotlin.jvm.internal.C14342f0.m8192h(r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.Drawable.toBitmap(android.graphics.drawable.Drawable, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    public static /* synthetic */ Bitmap toBitmap$default(android.graphics.drawable.Drawable drawable, int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        if ((i3 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i, i2, config);
    }

    public static final void updateBounds(@NotNull android.graphics.drawable.Drawable updateBounds, @InterfaceC0075Px int i, @InterfaceC0075Px int i2, @InterfaceC0075Px int i3, @InterfaceC0075Px int i4) {
        C14342f0.m8183q(updateBounds, "$this$updateBounds");
        updateBounds.setBounds(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateBounds$default(android.graphics.drawable.Drawable drawable, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = drawable.getBounds().left;
        }
        if ((i5 & 2) != 0) {
            i2 = drawable.getBounds().top;
        }
        if ((i5 & 4) != 0) {
            i3 = drawable.getBounds().right;
        }
        if ((i5 & 8) != 0) {
            i4 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i, i2, i3, i4);
    }
}
