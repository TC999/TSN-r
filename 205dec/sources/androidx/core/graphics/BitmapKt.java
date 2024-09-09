package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.acse.ottn.f3;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Bitmap.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004H\u0086\b\u001a\u001d\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0086\n\u001a'\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u0007H\u0086\n\u001a'\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0086\b\u001a#\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0086\b\u001a7\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0087\b\u001a\u0015\u0010\u001a\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0086\n\u001a\u0015\u0010\u001a\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001bH\u0086\n\u00a8\u0006\u001c"}, d2 = {"Landroid/graphics/Bitmap;", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "applyCanvas", "", "x", "y", f3.f5657f, "color", f3.f5659h, "width", "height", "", "filter", "scale", "Landroid/graphics/Bitmap$Config;", "config", "createBitmap", "hasAlpha", "Landroid/graphics/ColorSpace;", "colorSpace", "Landroid/graphics/Point;", "p", "contains", "Landroid/graphics/PointF;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class BitmapKt {
    @NotNull
    public static final Bitmap applyCanvas(@NotNull Bitmap applyCanvas, @NotNull l<? super Canvas, f1> block) {
        f0.q(applyCanvas, "$this$applyCanvas");
        f0.q(block, "block");
        block.invoke(new Canvas(applyCanvas));
        return applyCanvas;
    }

    public static final boolean contains(@NotNull Bitmap contains, @NotNull Point p3) {
        int i4;
        f0.q(contains, "$this$contains");
        f0.q(p3, "p");
        int i5 = p3.x;
        return i5 >= 0 && i5 < contains.getWidth() && (i4 = p3.y) >= 0 && i4 < contains.getHeight();
    }

    @NotNull
    public static final Bitmap createBitmap(int i4, int i5, @NotNull Bitmap.Config config) {
        f0.q(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, config);
        f0.h(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i4, int i5, Bitmap.Config config, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        f0.q(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, config);
        f0.h(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(@NotNull Bitmap get, int i4, int i5) {
        f0.q(get, "$this$get");
        return get.getPixel(i4, i5);
    }

    @NotNull
    public static final Bitmap scale(@NotNull Bitmap scale, int i4, int i5, boolean z3) {
        f0.q(scale, "$this$scale");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(scale, i4, i5, z3);
        f0.h(createScaledBitmap, "Bitmap.createScaledBitma\u2026s, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap scale, int i4, int i5, boolean z3, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z3 = true;
        }
        f0.q(scale, "$this$scale");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(scale, i4, i5, z3);
        f0.h(createScaledBitmap, "Bitmap.createScaledBitma\u2026s, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(@NotNull Bitmap set, int i4, int i5, @ColorInt int i6) {
        f0.q(set, "$this$set");
        set.setPixel(i4, i5, i6);
    }

    public static final boolean contains(@NotNull Bitmap contains, @NotNull PointF p3) {
        f0.q(contains, "$this$contains");
        f0.q(p3, "p");
        float f4 = p3.x;
        float f5 = 0;
        if (f4 < f5 || f4 >= contains.getWidth()) {
            return false;
        }
        float f6 = p3.y;
        return f6 >= f5 && f6 < ((float) contains.getHeight());
    }

    @RequiresApi(26)
    @NotNull
    public static final Bitmap createBitmap(int i4, int i5, @NotNull Bitmap.Config config, boolean z3, @NotNull ColorSpace colorSpace) {
        f0.q(config, "config");
        f0.q(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, config, z3, colorSpace);
        f0.h(createBitmap, "Bitmap.createBitmap(widt\u2026ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i4, int i5, Bitmap.Config config, boolean z3, ColorSpace colorSpace, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i6 & 8) != 0) {
            z3 = true;
        }
        if ((i6 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            f0.h(colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        f0.q(config, "config");
        f0.q(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, config, z3, colorSpace);
        f0.h(createBitmap, "Bitmap.createBitmap(widt\u2026ig, hasAlpha, colorSpace)");
        return createBitmap;
    }
}
